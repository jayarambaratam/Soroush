package org.apache.http.myHttp.entity.mime.content;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.myHttp.Consts;
import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.entity.mime.MIME;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;

public class StringBody extends AbstractContentBody {
    private final byte[] content;

    @Deprecated
    public StringBody(String str) {
        this(str, HTTP.PLAIN_TEXT_TYPE, Consts.ASCII);
    }

    @Deprecated
    public StringBody(String str, String str2, Charset charset) {
        this(str, ContentType.create(str2, charset));
    }

    @Deprecated
    public StringBody(String str, Charset charset) {
        this(str, HTTP.PLAIN_TEXT_TYPE, charset);
    }

    public StringBody(String str, ContentType contentType) {
        super(contentType);
        Args.notNull(str, "Text");
        Charset charset = contentType.getCharset();
        String name = charset != null ? charset.name() : Consts.ASCII.name();
        try {
            this.content = str.getBytes(name);
        } catch (UnsupportedEncodingException e) {
            throw new UnsupportedCharsetException(name);
        }
    }

    @Deprecated
    public static StringBody create(String str) {
        return create(str, null, null);
    }

    @Deprecated
    public static StringBody create(String str, String str2, Charset charset) {
        try {
            return new StringBody(str, str2, charset);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e);
        }
    }

    @Deprecated
    public static StringBody create(String str, Charset charset) {
        return create(str, null, charset);
    }

    public long getContentLength() {
        return (long) this.content.length;
    }

    public String getFilename() {
        return null;
    }

    public Reader getReader() {
        Charset charset = getContentType().getCharset();
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        if (charset == null) {
            charset = Consts.ASCII;
        }
        return new InputStreamReader(byteArrayInputStream, charset);
    }

    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    public void writeTo(OutputStream outputStream) {
        Args.notNull(outputStream, "Output stream");
        InputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        byte[] bArr = new byte[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }
}
