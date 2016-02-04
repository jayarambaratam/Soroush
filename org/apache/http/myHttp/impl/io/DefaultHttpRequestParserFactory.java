package org.apache.http.myHttp.impl.io;

import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpRequestFactory;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.config.MessageConstraints;
import org.apache.http.myHttp.impl.DefaultHttpRequestFactory;
import org.apache.http.myHttp.io.HttpMessageParser;
import org.apache.http.myHttp.io.HttpMessageParserFactory;
import org.apache.http.myHttp.io.SessionInputBuffer;
import org.apache.http.myHttp.message.BasicLineParser;
import org.apache.http.myHttp.message.LineParser;

@Immutable
public class DefaultHttpRequestParserFactory implements HttpMessageParserFactory<HttpRequest> {
    public static final DefaultHttpRequestParserFactory INSTANCE;
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;

    static {
        INSTANCE = new DefaultHttpRequestParserFactory();
    }

    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }

    public DefaultHttpRequestParserFactory(LineParser lineParser, HttpRequestFactory httpRequestFactory) {
        if (lineParser == null) {
            lineParser = BasicLineParser.INSTANCE;
        }
        this.lineParser = lineParser;
        if (httpRequestFactory == null) {
            httpRequestFactory = DefaultHttpRequestFactory.INSTANCE;
        }
        this.requestFactory = httpRequestFactory;
    }

    public HttpMessageParser<HttpRequest> create(SessionInputBuffer sessionInputBuffer, MessageConstraints messageConstraints) {
        return new DefaultHttpRequestParser(sessionInputBuffer, this.lineParser, this.requestFactory, messageConstraints);
    }
}
