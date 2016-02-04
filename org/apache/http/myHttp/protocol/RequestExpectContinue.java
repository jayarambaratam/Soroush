package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpEntity;
import org.apache.http.myHttp.HttpEntityEnclosingRequest;
import org.apache.http.myHttp.HttpRequest;
import org.apache.http.myHttp.HttpRequestInterceptor;
import org.apache.http.myHttp.HttpVersion;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.params.CoreProtocolPNames;
import org.apache.http.myHttp.util.Args;

@Immutable
public class RequestExpectContinue implements HttpRequestInterceptor {
    private final boolean activeByDefault;

    @Deprecated
    public RequestExpectContinue() {
        this(false);
    }

    public RequestExpectContinue(boolean z) {
        this.activeByDefault = z;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.containsHeader(HTTP.EXPECT_DIRECTIVE) && (httpRequest instanceof HttpEntityEnclosingRequest)) {
            ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
            if (entity != null && entity.getContentLength() != 0 && !protocolVersion.lessEquals(HttpVersion.HTTP_1_0) && httpRequest.getParams().getBooleanParameter(CoreProtocolPNames.USE_EXPECT_CONTINUE, this.activeByDefault)) {
                httpRequest.addHeader(HTTP.EXPECT_DIRECTIVE, HTTP.EXPECT_CONTINUE);
            }
        }
    }
}
