package org.apache.http.myHttp.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.myHttp.util.Args;
import org.apache.http.myHttp.util.ByteArrayBuffer;

abstract class AbstractMultipartForm {
    private static final ByteArrayBuffer CR_LF;
    private static final ByteArrayBuffer FIELD_SEP;
    private static final ByteArrayBuffer TWO_DASHES;
    private final String boundary;
    protected final Charset charset;
    private final String subType;

    static {
        FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
        CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
        TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    }

    public AbstractMultipartForm(String str, String str2) {
        this(str, null, str2);
    }

    public AbstractMultipartForm(String str, Charset charset, String str2) {
        Args.notNull(str, "Multipart subtype");
        Args.notNull(str2, "Multipart boundary");
        this.subType = str;
        if (charset == null) {
            charset = MIME.DEFAULT_CHARSET;
        }
        this.charset = charset;
        this.boundary = str2;
    }

    private static ByteArrayBuffer encode(Charset charset, String str) {
        ByteBuffer encode = charset.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void writeBytes(String str, OutputStream outputStream) {
        writeBytes(encode(MIME.DEFAULT_CHARSET, str), outputStream);
    }

    private static void writeBytes(String str, Charset charset, OutputStream outputStream) {
        writeBytes(encode(charset, str), outputStream);
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    protected static void writeField(MinimalField minimalField, OutputStream outputStream) {
        writeBytes(minimalField.getName(), outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), outputStream);
        writeBytes(CR_LF, outputStream);
    }

    protected static void writeField(MinimalField minimalField, Charset charset, OutputStream outputStream) {
        writeBytes(minimalField.getName(), charset, outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), charset, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    void doWriteTo(OutputStream outputStream, boolean z) {
        ByteArrayBuffer encode = encode(this.charset, getBoundary());
        for (FormBodyPart formBodyPart : getBodyParts()) {
            writeBytes(TWO_DASHES, outputStream);
            writeBytes(encode, outputStream);
            writeBytes(CR_LF, outputStream);
            formatMultipartHeader(formBodyPart, outputStream);
            writeBytes(CR_LF, outputStream);
            if (z) {
                formBodyPart.getBody().writeTo(outputStream);
            }
            writeBytes(CR_LF, outputStream);
        }
        writeBytes(TWO_DASHES, outputStream);
        writeBytes(encode, outputStream);
        writeBytes(TWO_DASHES, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    protected abstract void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream);

    public abstract List<FormBodyPart> getBodyParts();

    public String getBoundary() {
        return this.boundary;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getSubType() {
        return this.subType;
    }

    public long getTotalLength() {
        long j = 0;
        for (FormBodyPart body : getBodyParts()) {
            long contentLength = body.getBody().getContentLength();
            if (contentLength < 0) {
                return -1;
            }
            j = contentLength + j;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            doWriteTo(byteArrayOutputStream, false);
            return ((long) byteArrayOutputStream.toByteArray().length) + j;
        } catch (IOException e) {
            return -1;
        }
    }

    public void writeTo(OutputStream outputStream) {
        doWriteTo(outputStream, true);
    }
}
