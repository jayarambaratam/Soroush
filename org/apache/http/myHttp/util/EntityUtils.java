package org.apache.http.myHttp.util;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.http.myHttp.HeaderElement;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.NameValuePair;
import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.protocol.HTTP;

public final class EntityUtils {
    private EntityUtils() {
    }

    public static void consume(HttpEntity httpEntity) {
        if (httpEntity != null && httpEntity.isStreaming()) {
            InputStream content = httpEntity.getContent();
            if (content != null) {
                content.close();
            }
        }
    }

    public static void consumeQuietly(HttpEntity httpEntity) {
        try {
            consume(httpEntity);
        } catch (IOException e) {
        }
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity httpEntity) {
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() == null) {
            return null;
        }
        HeaderElement[] elements = httpEntity.getContentType().getElements();
        if (elements.length <= 0) {
            return null;
        }
        NameValuePair parameterByName = elements[0].getParameterByName("charset");
        return parameterByName != null ? parameterByName.getValue() : null;
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity httpEntity) {
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() == null) {
            return null;
        }
        HeaderElement[] elements = httpEntity.getContentType().getElements();
        return elements.length > 0 ? elements[0].getName() : null;
    }

    public static byte[] toByteArray(HttpEntity httpEntity) {
        int i = ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
        boolean z = false;
        Args.notNull(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return null;
        }
        try {
            if (httpEntity.getContentLength() <= 2147483647L) {
                z = true;
            }
            Args.check(z, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength >= 0) {
                i = contentLength;
            }
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(i);
            byte[] bArr = new byte[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
            while (true) {
                int read = content.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayBuffer.append(bArr, 0, read);
            }
            bArr = byteArrayBuffer.toByteArray();
            return bArr;
        } finally {
            content.close();
        }
    }

    public static String toString(HttpEntity httpEntity) {
        return toString(httpEntity, (Charset) null);
    }

    public static String toString(HttpEntity httpEntity, String str) {
        return toString(httpEntity, str != null ? Charset.forName(str) : null);
    }

    public static String toString(HttpEntity httpEntity, Charset charset) {
        String charArrayBuffer;
        Charset charset2 = null;
        boolean z = false;
        Args.notNull(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content != null) {
            try {
                if (httpEntity.getContentLength() <= 2147483647L) {
                    z = true;
                }
                Args.check(z, "HTTP entity too large to be buffered in memory");
                int contentLength = (int) httpEntity.getContentLength();
                if (contentLength < 0) {
                    contentLength = ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT;
                }
                ContentType contentType = ContentType.get(httpEntity);
                if (contentType != null) {
                    charset2 = contentType.getCharset();
                }
                if (charset2 == null) {
                    charset2 = charset;
                }
                if (charset2 == null) {
                    charset2 = HTTP.DEF_CONTENT_CHARSET;
                }
                Reader inputStreamReader = new InputStreamReader(content, charset2);
                CharArrayBuffer charArrayBuffer2 = new CharArrayBuffer(contentLength);
                char[] cArr = new char[1024];
                while (true) {
                    int read = inputStreamReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    charArrayBuffer2.append(cArr, 0, read);
                }
                charArrayBuffer = charArrayBuffer2.toString();
                content.close();
            } catch (UnsupportedCharsetException e) {
                throw new UnsupportedEncodingException(e.getMessage());
            } catch (Throwable th) {
                content.close();
            }
        }
        return charArrayBuffer;
    }

    public static void updateEntity(HttpResponse httpResponse, HttpEntity httpEntity) {
        Args.notNull(httpResponse, "Response");
        consume(httpResponse.getEntity());
        httpResponse.setEntity(httpEntity);
    }
}
