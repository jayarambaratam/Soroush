package org.apache.http.myHttp.impl.io;

import java.io.IOException;
import java.io.InputStream;
import org.apache.http.myHttp.Header;
import org.apache.http.myHttp.MalformedChunkCodingException;
import org.apache.http.myHttp.TruncatedChunkException;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.io.BufferInfo;
import org.apache.http.myHttp.io.SessionInputBuffer;
import org.apache.http.myHttp.util.Args;
import org.apache.http.myHttp.util.CharArrayBuffer;

@NotThreadSafe
public class ChunkedInputStream extends InputStream {
    private static final int BUFFER_SIZE = 2048;
    private static final int CHUNK_CRLF = 3;
    private static final int CHUNK_DATA = 2;
    private static final int CHUNK_LEN = 1;
    private final CharArrayBuffer buffer;
    private int chunkSize;
    private boolean closed;
    private boolean eof;
    private Header[] footers;
    private final SessionInputBuffer in;
    private int pos;
    private int state;

    public ChunkedInputStream(SessionInputBuffer sessionInputBuffer) {
        this.eof = false;
        this.closed = false;
        this.footers = new Header[0];
        this.in = (SessionInputBuffer) Args.notNull(sessionInputBuffer, "Session input buffer");
        this.pos = 0;
        this.buffer = new CharArrayBuffer(16);
        this.state = CHUNK_LEN;
    }

    private int getChunkSize() {
        int i = 0;
        switch (this.state) {
            case CHUNK_CRLF /*3*/:
                this.buffer.clear();
                if (this.in.readLine(this.buffer) != -1) {
                    if (this.buffer.isEmpty()) {
                        this.state = CHUNK_LEN;
                    } else {
                        throw new MalformedChunkCodingException("Unexpected content at the end of chunk");
                    }
                }
                break;
            case CHUNK_LEN /*1*/:
                this.buffer.clear();
                if (this.in.readLine(this.buffer) != -1) {
                    i = this.buffer.indexOf(59);
                    if (i < 0) {
                        i = this.buffer.length();
                    }
                    try {
                        i = Integer.parseInt(this.buffer.substringTrimmed(0, i), 16);
                        break;
                    } catch (NumberFormatException e) {
                        throw new MalformedChunkCodingException("Bad chunk header");
                    }
                }
                break;
            default:
                throw new IllegalStateException("Inconsistent codec state");
        }
        return i;
    }

    private void nextChunk() {
        this.chunkSize = getChunkSize();
        if (this.chunkSize < 0) {
            throw new MalformedChunkCodingException("Negative chunk size");
        }
        this.state = CHUNK_DATA;
        this.pos = 0;
        if (this.chunkSize == 0) {
            this.eof = true;
            parseTrailerHeaders();
        }
    }

    private void parseTrailerHeaders() {
        try {
            this.footers = AbstractMessageParser.parseHeaders(this.in, -1, -1, null);
        } catch (Throwable e) {
            IOException malformedChunkCodingException = new MalformedChunkCodingException("Invalid footer: " + e.getMessage());
            malformedChunkCodingException.initCause(e);
            throw malformedChunkCodingException;
        }
    }

    public int available() {
        return this.in instanceof BufferInfo ? Math.min(((BufferInfo) this.in).length(), this.chunkSize - this.pos) : 0;
    }

    public void close() {
        if (!this.closed) {
            try {
                if (!this.eof) {
                    do {
                    } while (read(new byte[BUFFER_SIZE]) >= 0);
                }
                this.eof = true;
                this.closed = true;
            } catch (Throwable th) {
                this.eof = true;
                this.closed = true;
            }
        }
    }

    public Header[] getFooters() {
        return (Header[]) this.footers.clone();
    }

    public int read() {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.eof) {
            return -1;
        } else {
            if (this.state != CHUNK_DATA) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.in.read();
            if (read != -1) {
                this.pos += CHUNK_LEN;
                if (this.pos >= this.chunkSize) {
                    this.state = CHUNK_CRLF;
                }
            }
            return read;
        }
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.closed) {
            throw new IOException("Attempted read from closed stream.");
        } else if (this.eof) {
            return -1;
        } else {
            if (this.state != CHUNK_DATA) {
                nextChunk();
                if (this.eof) {
                    return -1;
                }
            }
            int read = this.in.read(bArr, i, Math.min(i2, this.chunkSize - this.pos));
            if (read != -1) {
                this.pos += read;
                if (this.pos >= this.chunkSize) {
                    this.state = CHUNK_CRLF;
                }
                return read;
            }
            this.eof = true;
            throw new TruncatedChunkException("Truncated chunk ( expected size: " + this.chunkSize + "; actual size: " + this.pos + ")");
        }
    }
}
