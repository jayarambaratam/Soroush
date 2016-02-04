package org.apache.http.myHttp.protocol;

import java.io.IOException;
import org.apache.http.myHttp.HttpClientConnection;
import org.apache.http.myHttp.HttpEntityEnclosingRequest;
import org.apache.http.myHttp.HttpException;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpStatus;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ProtocolException;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.util.Args;

@Immutable
public class HttpRequestExecutor {
    public static final int DEFAULT_WAIT_FOR_CONTINUE = 3000;
    private final int waitForContinue;

    public HttpRequestExecutor() {
        this(DEFAULT_WAIT_FOR_CONTINUE);
    }

    public HttpRequestExecutor(int i) {
        this.waitForContinue = Args.positive(i, "Wait for continue time");
    }

    private static void closeConnection(HttpClientConnection httpClientConnection) {
        try {
            httpClientConnection.close();
        } catch (IOException e) {
        }
    }

    protected boolean canResponseHaveBody(HttpRequest httpRequest, HttpResponse httpResponse) {
        if ("HEAD".equalsIgnoreCase(httpRequest.getRequestLine().getMethod())) {
            return false;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        return (statusCode < HttpStatus.SC_OK || statusCode == HttpStatus.SC_NO_CONTENT || statusCode == HttpStatus.SC_NOT_MODIFIED || statusCode == HttpStatus.SC_RESET_CONTENT) ? false : true;
    }

    protected HttpResponse doReceiveResponse(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        HttpResponse httpResponse = null;
        int i = 0;
        while (true) {
            if (httpResponse != null && r0 >= HttpStatus.SC_OK) {
                return httpResponse;
            }
            httpResponse = httpClientConnection.receiveResponseHeader();
            if (canResponseHaveBody(httpRequest, httpResponse)) {
                httpClientConnection.receiveResponseEntity(httpResponse);
            }
            i = httpResponse.getStatusLine().getStatusCode();
        }
    }

    protected HttpResponse doSendRequest(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) {
        HttpResponse httpResponse;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute(HttpCoreContext.HTTP_CONNECTION, httpClientConnection);
        httpContext.setAttribute(HttpCoreContext.HTTP_REQ_SENT, Boolean.FALSE);
        httpClientConnection.sendRequestHeader(httpRequest);
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
            Object obj;
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            if (((HttpEntityEnclosingRequest) httpRequest).expectContinue() && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                httpClientConnection.flush();
                if (httpClientConnection.isResponseAvailable(this.waitForContinue)) {
                    HttpResponse receiveResponseHeader = httpClientConnection.receiveResponseHeader();
                    if (canResponseHaveBody(httpRequest, receiveResponseHeader)) {
                        httpClientConnection.receiveResponseEntity(receiveResponseHeader);
                    }
                    int statusCode = receiveResponseHeader.getStatusLine().getStatusCode();
                    if (statusCode >= HttpStatus.SC_OK) {
                        obj = null;
                        httpResponse = receiveResponseHeader;
                    } else if (statusCode != 100) {
                        throw new ProtocolException("Unexpected response: " + receiveResponseHeader.getStatusLine());
                    } else {
                        httpResponse = null;
                        obj = 1;
                    }
                    if (obj != null) {
                        httpClientConnection.sendRequestEntity((HttpEntityEnclosingRequest) httpRequest);
                    }
                }
            }
            httpResponse = null;
            int i = 1;
            if (obj != null) {
                httpClientConnection.sendRequestEntity((HttpEntityEnclosingRequest) httpRequest);
            }
        } else {
            httpResponse = null;
        }
        httpClientConnection.flush();
        httpContext.setAttribute(HttpCoreContext.HTTP_REQ_SENT, Boolean.TRUE);
        return httpResponse;
    }

    public HttpResponse execute(HttpRequest httpRequest, HttpClientConnection httpClientConnection, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpClientConnection, "Client connection");
        Args.notNull(httpContext, "HTTP context");
        try {
            HttpResponse doSendRequest = doSendRequest(httpRequest, httpClientConnection, httpContext);
            if (doSendRequest == null) {
                doSendRequest = doReceiveResponse(httpRequest, httpClientConnection, httpContext);
            }
            return doSendRequest;
        } catch (IOException e) {
            closeConnection(httpClientConnection);
            throw e;
        } catch (HttpException e2) {
            closeConnection(httpClientConnection);
            throw e2;
        } catch (RuntimeException e3) {
            closeConnection(httpClientConnection);
            throw e3;
        }
    }

    public void postProcess(HttpResponse httpResponse, HttpProcessor httpProcessor, HttpContext httpContext) {
        Args.notNull(httpResponse, "HTTP response");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute(HttpCoreContext.HTTP_RESPONSE, httpResponse);
        httpProcessor.process(httpResponse, httpContext);
    }

    public void preProcess(HttpRequest httpRequest, HttpProcessor httpProcessor, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpProcessor, "HTTP processor");
        Args.notNull(httpContext, "HTTP context");
        httpContext.setAttribute(HttpCoreContext.HTTP_REQUEST, httpRequest);
        httpProcessor.process(httpRequest, httpContext);
    }
}
