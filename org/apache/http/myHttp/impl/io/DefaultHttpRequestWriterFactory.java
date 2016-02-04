package org.apache.http.myHttp.impl.io;

import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.io.HttpMessageWriter;
import org.apache.http.myHttp.io.HttpMessageWriterFactory;
import org.apache.http.myHttp.io.SessionOutputBuffer;
import org.apache.http.myHttp.message.BasicLineFormatter;
import org.apache.http.myHttp.message.LineFormatter;

@Immutable
public class DefaultHttpRequestWriterFactory implements HttpMessageWriterFactory<HttpRequest> {
    public static final DefaultHttpRequestWriterFactory INSTANCE;
    private final LineFormatter lineFormatter;

    static {
        INSTANCE = new DefaultHttpRequestWriterFactory();
    }

    public DefaultHttpRequestWriterFactory() {
        this(null);
    }

    public DefaultHttpRequestWriterFactory(LineFormatter lineFormatter) {
        if (lineFormatter == null) {
            lineFormatter = BasicLineFormatter.INSTANCE;
        }
        this.lineFormatter = lineFormatter;
    }

    public HttpMessageWriter<HttpRequest> create(SessionOutputBuffer sessionOutputBuffer) {
        return new DefaultHttpRequestWriter(sessionOutputBuffer, this.lineFormatter);
    }
}
