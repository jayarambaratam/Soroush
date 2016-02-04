package org.apache.http.myHttp.impl.io;

import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.io.SessionOutputBuffer;
import org.apache.http.myHttp.message.LineFormatter;

@NotThreadSafe
public class DefaultHttpResponseWriter extends AbstractMessageWriter<HttpResponse> {
    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer) {
        super(sessionOutputBuffer, null);
    }

    public DefaultHttpResponseWriter(SessionOutputBuffer sessionOutputBuffer, LineFormatter lineFormatter) {
        super(sessionOutputBuffer, lineFormatter);
    }

    protected void writeHeadLine(HttpResponse httpResponse) {
        this.lineFormatter.formatStatusLine(this.lineBuf, httpResponse.getStatusLine());
        this.sessionBuffer.writeLine(this.lineBuf);
    }
}
