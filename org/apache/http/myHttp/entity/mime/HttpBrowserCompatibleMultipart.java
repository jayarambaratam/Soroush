package org.apache.http.myHttp.entity.mime;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;
import org.apache.http.myHttp.protocol.HTTP;

class HttpBrowserCompatibleMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpBrowserCompatibleMultipart(String str, Charset charset, String str2, List<FormBodyPart> list) {
        super(str, charset, str2);
        this.parts = list;
    }

    protected void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) {
        Header header = formBodyPart.getHeader();
        AbstractMultipartForm.writeField(header.getField(MIME.CONTENT_DISPOSITION), this.charset, outputStream);
        if (formBodyPart.getBody().getFilename() != null) {
            AbstractMultipartForm.writeField(header.getField(HTTP.CONTENT_TYPE), this.charset, outputStream);
        }
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }
}
