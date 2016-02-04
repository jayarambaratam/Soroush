package org.apache.http.myHttp.impl;

import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpEntityEnclosingRequest;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpServerConnection;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.config.MessageConstraints;
import org.apache.http.myHttp.entity.ContentLengthStrategy;
import org.apache.http.myHttp.impl.entity.DisallowIdentityContentLengthStrategy;
import org.apache.http.myHttp.impl.io.DefaultHttpRequestParserFactory;
import org.apache.http.myHttp.impl.io.DefaultHttpResponseWriterFactory;
import org.apache.http.myHttp.io.HttpMessageParser;
import org.apache.http.myHttp.io.HttpMessageParserFactory;
import org.apache.http.myHttp.io.HttpMessageWriter;
import org.apache.http.myHttp.io.HttpMessageWriterFactory;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public class DefaultBHttpServerConnection extends BHttpConnectionBase implements HttpServerConnection {
    private final HttpMessageParser<HttpRequest> requestParser;
    private final HttpMessageWriter<HttpResponse> responseWriter;

    public DefaultBHttpServerConnection(int i) {
        this(i, i, null, null, null, null, null, null, null);
    }

    public DefaultBHttpServerConnection(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageParserFactory<HttpRequest> httpMessageParserFactory, HttpMessageWriterFactory<HttpResponse> httpMessageWriterFactory) {
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy != null ? contentLengthStrategy : DisallowIdentityContentLengthStrategy.INSTANCE, contentLengthStrategy2);
        if (httpMessageParserFactory == null) {
            httpMessageParserFactory = DefaultHttpRequestParserFactory.INSTANCE;
        }
        this.requestParser = httpMessageParserFactory.create(getSessionInputBuffer(), messageConstraints);
        if (httpMessageWriterFactory == null) {
            httpMessageWriterFactory = DefaultHttpResponseWriterFactory.INSTANCE;
        }
        this.responseWriter = httpMessageWriterFactory.create(getSessionOutputBuffer());
    }

    public DefaultBHttpServerConnection(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i, i, charsetDecoder, charsetEncoder, messageConstraints, null, null, null, null);
    }

    public void bind(Socket socket) {
        super.bind(socket);
    }

    public void flush() {
        ensureOpen();
        doFlush();
    }

    protected void onRequestReceived(HttpRequest httpRequest) {
    }

    protected void onResponseSubmitted(HttpResponse httpResponse) {
    }

    public void receiveRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        httpEntityEnclosingRequest.setEntity(prepareInput(httpEntityEnclosingRequest));
    }

    public HttpRequest receiveRequestHeader() {
        ensureOpen();
        HttpRequest httpRequest = (HttpRequest) this.requestParser.parse();
        onRequestReceived(httpRequest);
        incrementRequestCount();
        return httpRequest;
    }

    public void sendResponseEntity(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            OutputStream prepareOutput = prepareOutput(httpResponse);
            entity.writeTo(prepareOutput);
            prepareOutput.close();
        }
    }

    public void sendResponseHeader(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        this.responseWriter.write(httpResponse);
        onResponseSubmitted(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= HttpStatus.SC_OK) {
            incrementResponseCount();
        }
    }
}
