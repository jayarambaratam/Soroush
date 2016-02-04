package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.ConnectionReuseStrategy;
import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpEntityEnclosingRequest;
import org.apache.http.myHttp.HttpException;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpResponseFactory;
import org.apache.http.myHttp.HttpServerConnection;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.MethodNotSupportedException;
import org.apache.http.myHttp.ProtocolException;
import org.apache.http.myHttp.UnsupportedHttpVersionException;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.entity.ByteArrayEntity;
import org.apache.http.myHttp.impl.DefaultConnectionReuseStrategy;
import org.apache.http.myHttp.impl.DefaultHttpResponseFactory;
import org.apache.http.myHttp.params.HttpParams;
import org.apache.http.myHttp.util.Args;
import org.apache.http.myHttp.util.EncodingUtils;
import org.apache.http.myHttp.util.EntityUtils;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;

@Immutable
public class HttpService {
    private volatile ConnectionReuseStrategy connStrategy;
    private volatile HttpExpectationVerifier expectationVerifier;
    private volatile HttpRequestHandlerMapper handlerMapper;
    private volatile HttpParams params;
    private volatile HttpProcessor processor;
    private volatile HttpResponseFactory responseFactory;

    @Deprecated
    class HttpRequestHandlerResolverAdapter implements HttpRequestHandlerMapper {
        private final HttpRequestHandlerResolver resolver;

        public HttpRequestHandlerResolverAdapter(HttpRequestHandlerResolver httpRequestHandlerResolver) {
            this.resolver = httpRequestHandlerResolver;
        }

        public HttpRequestHandler lookup(HttpRequest httpRequest) {
            return this.resolver.lookup(httpRequest.getRequestLine().getUri());
        }
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        setHttpProcessor(httpProcessor);
        setConnReuseStrategy(connectionReuseStrategy);
        setResponseFactory(httpResponseFactory);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, httpRequestHandlerMapper, null);
    }

    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerMapper httpRequestHandlerMapper, HttpExpectationVerifier httpExpectationVerifier) {
        this.params = null;
        this.processor = null;
        this.handlerMapper = null;
        this.connStrategy = null;
        this.responseFactory = null;
        this.expectationVerifier = null;
        this.processor = (HttpProcessor) Args.notNull(httpProcessor, "HTTP processor");
        if (connectionReuseStrategy == null) {
            connectionReuseStrategy = DefaultConnectionReuseStrategy.INSTANCE;
        }
        this.connStrategy = connectionReuseStrategy;
        if (httpResponseFactory == null) {
            httpResponseFactory = DefaultHttpResponseFactory.INSTANCE;
        }
        this.responseFactory = httpResponseFactory;
        this.handlerMapper = httpRequestHandlerMapper;
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), null);
        this.params = httpParams;
    }

    @Deprecated
    public HttpService(HttpProcessor httpProcessor, ConnectionReuseStrategy connectionReuseStrategy, HttpResponseFactory httpResponseFactory, HttpRequestHandlerResolver httpRequestHandlerResolver, HttpExpectationVerifier httpExpectationVerifier, HttpParams httpParams) {
        this(httpProcessor, connectionReuseStrategy, httpResponseFactory, new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver), httpExpectationVerifier);
        this.params = httpParams;
    }

    public HttpService(HttpProcessor httpProcessor, HttpRequestHandlerMapper httpRequestHandlerMapper) {
        this(httpProcessor, null, null, httpRequestHandlerMapper, null);
    }

    protected void doService(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) {
        HttpRequestHandler httpRequestHandler = null;
        if (this.handlerMapper != null) {
            httpRequestHandler = this.handlerMapper.lookup(httpRequest);
        }
        if (httpRequestHandler != null) {
            httpRequestHandler.handle(httpRequest, httpResponse, httpContext);
        } else {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        }
    }

    @Deprecated
    public HttpParams getParams() {
        return this.params;
    }

    protected void handleException(HttpException httpException, HttpResponse httpResponse) {
        if (httpException instanceof MethodNotSupportedException) {
            httpResponse.setStatusCode(HttpStatus.SC_NOT_IMPLEMENTED);
        } else if (httpException instanceof UnsupportedHttpVersionException) {
            httpResponse.setStatusCode(HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED);
        } else if (httpException instanceof ProtocolException) {
            httpResponse.setStatusCode(HttpStatus.SC_BAD_REQUEST);
        } else {
            httpResponse.setStatusCode(PacketWriter.QUEUE_SIZE);
        }
        String message = httpException.getMessage();
        if (message == null) {
            message = httpException.toString();
        }
        HttpEntity byteArrayEntity = new ByteArrayEntity(EncodingUtils.getAsciiBytes(message));
        byteArrayEntity.setContentType("text/plain; charset=US-ASCII");
        httpResponse.setEntity(byteArrayEntity);
    }

    public void handleRequest(HttpServerConnection httpServerConnection, HttpContext httpContext) {
        HttpResponse newHttpResponse;
        httpContext.setAttribute(HttpCoreContext.HTTP_CONNECTION, httpServerConnection);
        try {
            HttpRequest receiveRequestHeader = httpServerConnection.receiveRequestHeader();
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                if (((HttpEntityEnclosingRequest) receiveRequestHeader).expectContinue()) {
                    newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, 100, httpContext);
                    if (this.expectationVerifier != null) {
                        try {
                            this.expectationVerifier.verify(receiveRequestHeader, newHttpResponse, httpContext);
                        } catch (HttpException e) {
                            HttpResponse newHttpResponse2 = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, PacketWriter.QUEUE_SIZE, httpContext);
                            handleException(e, newHttpResponse2);
                            newHttpResponse = newHttpResponse2;
                        }
                    }
                    if (newHttpResponse.getStatusLine().getStatusCode() < HttpStatus.SC_OK) {
                        httpServerConnection.sendResponseHeader(newHttpResponse);
                        httpServerConnection.flush();
                        httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
                        newHttpResponse = null;
                    }
                    httpContext.setAttribute(HttpCoreContext.HTTP_REQUEST, receiveRequestHeader);
                    if (newHttpResponse == null) {
                        newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, httpContext);
                        this.processor.process(receiveRequestHeader, httpContext);
                        doService(receiveRequestHeader, newHttpResponse, httpContext);
                    }
                    if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                        EntityUtils.consume(((HttpEntityEnclosingRequest) receiveRequestHeader).getEntity());
                    }
                    httpContext.setAttribute(HttpCoreContext.HTTP_RESPONSE, newHttpResponse);
                    this.processor.process(newHttpResponse, httpContext);
                    httpServerConnection.sendResponseHeader(newHttpResponse);
                    httpServerConnection.sendResponseEntity(newHttpResponse);
                    httpServerConnection.flush();
                    if (!this.connStrategy.keepAlive(newHttpResponse, httpContext)) {
                        httpServerConnection.close();
                    }
                }
                httpServerConnection.receiveRequestEntity((HttpEntityEnclosingRequest) receiveRequestHeader);
            }
            newHttpResponse = null;
            httpContext.setAttribute(HttpCoreContext.HTTP_REQUEST, receiveRequestHeader);
            if (newHttpResponse == null) {
                newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_1, HttpStatus.SC_OK, httpContext);
                this.processor.process(receiveRequestHeader, httpContext);
                doService(receiveRequestHeader, newHttpResponse, httpContext);
            }
            if (receiveRequestHeader instanceof HttpEntityEnclosingRequest) {
                EntityUtils.consume(((HttpEntityEnclosingRequest) receiveRequestHeader).getEntity());
            }
        } catch (HttpException e2) {
            HttpException httpException = e2;
            newHttpResponse = this.responseFactory.newHttpResponse(HttpVersion.HTTP_1_0, PacketWriter.QUEUE_SIZE, httpContext);
            handleException(httpException, newHttpResponse);
        }
        httpContext.setAttribute(HttpCoreContext.HTTP_RESPONSE, newHttpResponse);
        this.processor.process(newHttpResponse, httpContext);
        httpServerConnection.sendResponseHeader(newHttpResponse);
        httpServerConnection.sendResponseEntity(newHttpResponse);
        httpServerConnection.flush();
        if (!this.connStrategy.keepAlive(newHttpResponse, httpContext)) {
            httpServerConnection.close();
        }
    }

    @Deprecated
    public void setConnReuseStrategy(ConnectionReuseStrategy connectionReuseStrategy) {
        Args.notNull(connectionReuseStrategy, "Connection reuse strategy");
        this.connStrategy = connectionReuseStrategy;
    }

    @Deprecated
    public void setExpectationVerifier(HttpExpectationVerifier httpExpectationVerifier) {
        this.expectationVerifier = httpExpectationVerifier;
    }

    @Deprecated
    public void setHandlerResolver(HttpRequestHandlerResolver httpRequestHandlerResolver) {
        this.handlerMapper = new HttpRequestHandlerResolverAdapter(httpRequestHandlerResolver);
    }

    @Deprecated
    public void setHttpProcessor(HttpProcessor httpProcessor) {
        Args.notNull(httpProcessor, "HTTP processor");
        this.processor = httpProcessor;
    }

    @Deprecated
    public void setParams(HttpParams httpParams) {
        this.params = httpParams;
    }

    @Deprecated
    public void setResponseFactory(HttpResponseFactory httpResponseFactory) {
        Args.notNull(httpResponseFactory, "Response factory");
        this.responseFactory = httpResponseFactory;
    }
}
