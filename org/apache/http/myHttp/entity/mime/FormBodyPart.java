package org.apache.http.myHttp.entity.mime;

import org.apache.http.myHttp.entity.ContentType;
import org.apache.http.myHttp.entity.mime.content.AbstractContentBody;
import org.apache.http.myHttp.entity.mime.content.ContentBody;
import org.apache.http.myHttp.protocol.HTTP;
import org.apache.http.myHttp.util.Args;

public class FormBodyPart {
    private final ContentBody body;
    private final Header header;
    private final String name;

    public FormBodyPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Body");
        this.name = str;
        this.body = contentBody;
        this.header = new Header();
        generateContentDisp(contentBody);
        generateContentType(contentBody);
        generateTransferEncoding(contentBody);
    }

    public void addField(String str, String str2) {
        Args.notNull(str, "Field name");
        this.header.addField(new MinimalField(str, str2));
    }

    protected void generateContentDisp(ContentBody contentBody) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("form-data; name=\"");
        stringBuilder.append(getName());
        stringBuilder.append("\"");
        if (contentBody.getFilename() != null) {
            stringBuilder.append("; filename=\"");
            stringBuilder.append(contentBody.getFilename());
            stringBuilder.append("\"");
        }
        addField(MIME.CONTENT_DISPOSITION, stringBuilder.toString());
    }

    protected void generateContentType(ContentBody contentBody) {
        ContentType contentType = contentBody instanceof AbstractContentBody ? ((AbstractContentBody) contentBody).getContentType() : null;
        if (contentType != null) {
            addField(HTTP.CONTENT_TYPE, contentType.toString());
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(contentBody.getMimeType());
        if (contentBody.getCharset() != null) {
            stringBuilder.append(HTTP.CHARSET_PARAM);
            stringBuilder.append(contentBody.getCharset());
        }
        addField(HTTP.CONTENT_TYPE, stringBuilder.toString());
    }

    protected void generateTransferEncoding(ContentBody contentBody) {
        addField(MIME.CONTENT_TRANSFER_ENC, contentBody.getTransferEncoding());
    }

    public ContentBody getBody() {
        return this.body;
    }

    public Header getHeader() {
        return this.header;
    }

    public String getName() {
        return this.name;
    }
}
