package org.apache.http.myHttp.impl;

import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import org.apache.http.myHttp.HttpClientConnection;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpEntityEnclosingRequest;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.config.MessageConstraints;
import org.apache.http.myHttp.entity.ContentLengthStrategy;
import org.apache.http.myHttp.impl.io.DefaultHttpRequestWriterFactory;
import org.apache.http.myHttp.impl.io.DefaultHttpResponseParserFactory;
import org.apache.http.myHttp.io.HttpMessageParser;
import org.apache.http.myHttp.io.HttpMessageParserFactory;
import org.apache.http.myHttp.io.HttpMessageWriter;
import org.apache.http.myHttp.io.HttpMessageWriterFactory;
import org.apache.http.myHttp.util.Args;

@NotThreadSafe
public class DefaultBHttpClientConnection extends BHttpConnectionBase implements HttpClientConnection {
    private final HttpMessageWriter<HttpRequest> requestWriter;
    private final HttpMessageParser<HttpResponse> responseParser;

    public DefaultBHttpClientConnection(int i) {
        this(i, i, null, null, null, null, null, null, null);
    }

    public DefaultBHttpClientConnection(int i, int i2, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints, ContentLengthStrategy contentLengthStrategy, ContentLengthStrategy contentLengthStrategy2, HttpMessageWriterFactory<HttpRequest> httpMessageWriterFactory, HttpMessageParserFactory<HttpResponse> httpMessageParserFactory) {
        HttpMessageWriterFactory httpMessageWriterFactory2;
        HttpMessageParserFactory httpMessageParserFactory2;
        super(i, i2, charsetDecoder, charsetEncoder, messageConstraints, contentLengthStrategy, contentLengthStrategy2);
        if (httpMessageWriterFactory == null) {
            httpMessageWriterFactory2 = DefaultHttpRequestWriterFactory.INSTANCE;
        }
        this.requestWriter = httpMessageWriterFactory2.create(getSessionOutputBuffer());
        if (httpMessageParserFactory == null) {
            httpMessageParserFactory2 = DefaultHttpResponseParserFactory.INSTANCE;
        }
        this.responseParser = httpMessageParserFactory2.create(getSessionInputBuffer(), messageConstraints);
    }

    public DefaultBHttpClientConnection(int i, CharsetDecoder charsetDecoder, CharsetEncoder charsetEncoder, MessageConstraints messageConstraints) {
        this(i, i, charsetDecoder, charsetEncoder, messageConstraints, null, null, null, null);
    }

    public void bind(Socket socket) {
        super.bind(socket);
    }

    public void flush() {
        ensureOpen();
        doFlush();
    }

    public boolean isResponseAvailable(int i) {
        ensureOpen();
        try {
            return awaitInput(i);
        } catch (SocketTimeoutException e) {
            return false;
        }
    }

    protected void onRequestSubmitted(HttpRequest httpRequest) {
    }

    protected void onResponseReceived(HttpResponse httpResponse) {
    }

    public void receiveResponseEntity(HttpResponse httpResponse) {
        Args.notNull(httpResponse, "HTTP response");
        ensureOpen();
        httpResponse.setEntity(prepareInput(httpResponse));
    }

    public HttpResponse receiveResponseHeader() {
        ensureOpen();
        HttpResponse httpResponse = (HttpResponse) this.responseParser.parse();
        onResponseReceived(httpResponse);
        if (httpResponse.getStatusLine().getStatusCode() >= HttpStatus.SC_OK) {
            incrementResponseCount();
        }
        return httpResponse;
    }

    public void sendRequestEntity(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        Args.notNull(httpEntityEnclosingRequest, "HTTP request");
        ensureOpen();
        HttpEntity entity = httpEntityEnclosingRequest.getEntity();
        if (entity != null) {
            OutputStream prepareOutput = prepareOutput(httpEntityEnclosingRequest);
            entity.writeTo(prepareOutput);
            prepareOutput.close();
        }
    }

    public void sendRequestHeader(HttpRequest httpRequest) {
        Args.notNull(httpRequest, "HTTP request");
        ensureOpen();
        this.requestWriter.write(httpRequest);
        onRequestSubmitted(httpRequest);
        incrementRequestCount();
    }
}
