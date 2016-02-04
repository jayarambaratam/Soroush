package org.apache.http.myHttp.entity.mime;

import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

class HttpStrictMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpStrictMultipart(String str, Charset charset, String str2, List<FormBodyPart> list) {
        super(str, charset, str2);
        this.parts = list;
    }

    protected void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) {
        Iterator it = formBodyPart.getHeader().iterator();
        while (it.hasNext()) {
            AbstractMultipartForm.writeField((MinimalField) it.next(), outputStream);
        }
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }
}
