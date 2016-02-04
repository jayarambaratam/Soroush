package org.apache.http.myHttp.entity.mime.content;

import java.io.OutputStream;
import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.entity.mime.MIME;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;

public class ByteArrayBody extends AbstractContentBody {
    private final byte[] data;
    private final String filename;

    public ByteArrayBody(byte[] bArr, String str) {
        this(bArr, HTTP.OCTET_STREAM_TYPE, str);
    }

    @Deprecated
    public ByteArrayBody(byte[] bArr, String str, String str2) {
        this(bArr, ContentType.create(str), str2);
    }

    public ByteArrayBody(byte[] bArr, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(bArr, "byte[]");
        this.data = bArr;
        this.filename = str;
    }

    public String getCharset() {
        return null;
    }

    public long getContentLength() {
        return (long) this.data.length;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    public void writeTo(OutputStream outputStream) {
        outputStream.write(this.data);
    }
}
