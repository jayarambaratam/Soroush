package org.apache.http.myHttp.entity.mime.content;

import java.nio.charset.Charset;
import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.util.Args;

public abstract class AbstractContentBody implements ContentBody {
    private final ContentType contentType;

    @Deprecated
    public AbstractContentBody(String str) {
        this(ContentType.parse(str));
    }

    public AbstractContentBody(ContentType contentType) {
        Args.notNull(contentType, "Content type");
        this.contentType = contentType;
    }

    public String getCharset() {
        Charset charset = this.contentType.getCharset();
        return charset != null ? charset.name() : null;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public String getMediaType() {
        String mimeType = this.contentType.getMimeType();
        int indexOf = mimeType.indexOf(47);
        return indexOf != -1 ? mimeType.substring(0, indexOf) : mimeType;
    }

    public String getMimeType() {
        return this.contentType.getMimeType();
    }

    public String getSubType() {
        String mimeType = this.contentType.getMimeType();
        int indexOf = mimeType.indexOf(47);
        return indexOf != -1 ? mimeType.substring(indexOf + 1) : null;
    }
}
