package org.apache.http.myHttp.impl.io;

import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.io.HttpMessageWriter;
import org.apache.http.myHttp.io.HttpMessageWriterFactory;
import org.apache.http.myHttp.io.SessionOutputBuffer;
import org.apache.http.myHttp.message.BasicLineFormatter;
import org.apache.http.myHttp.message.LineFormatter;

@Immutable
public class DefaultHttpResponseWriterFactory implements HttpMessageWriterFactory<HttpResponse> {
    public static final DefaultHttpResponseWriterFactory INSTANCE;
    private final LineFormatter lineFormatter;

    static {
        INSTANCE = new DefaultHttpResponseWriterFactory();
    }

    public DefaultHttpResponseWriterFactory() {
        this(null);
    }

    public DefaultHttpResponseWriterFactory(LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = BasicLineFormatter.INSTANCE;
        }
        this.lineFormatter = lineFormatter;
    }

    public HttpMessageWriter<HttpResponse> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpResponseWriter(sessionOutputBuffer, this.lineFormatter);
    }
}
