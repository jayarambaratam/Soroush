package org.apache.http.myHttp.impl.io;

import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpResponseFactory;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.config.MessageConstraints;
import org.apache.http.myHttp.impl.DefaultHttpResponseFactory;
import org.apache.http.myHttp.io.HttpMessageParser;
import org.apache.http.myHttp.io.HttpMessageParserFactory;
import org.apache.http.myHttp.io.SessionInputBuffer;
import org.apache.http.myHttp.message.BasicLineParser;
import org.apache.http.myHttp.message.LineParser;

@Immutable
public class DefaultHttpResponseParserFactory implements HttpMessageParserFactory<HttpResponse> {
    public static final DefaultHttpResponseParserFactory INSTANCE;
    private final LineParser lineParser;
    private final HttpResponseFactory responseFactory;

    static {
        INSTANCE = new DefaultHttpResponseParserFactory();
    }

    public DefaultHttpResponseParserFactory() {
        this(null, null);
    }

    public DefaultHttpResponseParserFactory(LineParser lineParser, HttpResponseFactory httpResponseFactory) {
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        if (httpResponseFactory == null) {
            httpResponseFactory = DefaultHttpResponseFactory.INSTANCE;
        }
        this.responseFactory = httpResponseFactory;
    }

    public HttpMessageParser<HttpResponse> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpResponseParser(sessionInputBuffer, this.lineParser, this.responseFactory, messageConstraints);
    }
}
