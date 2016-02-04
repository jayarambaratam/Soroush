package org.apache.http.myHttp.impl;

import java.util.Locale;
import org.apache.http.myHttp.HttpResponse;
import org.apache.http.myHttp.HttpResponseFactory;
import org.apache.http.myHttp.ProtocolVersion;
import org.apache.http.myHttp.ReasonPhraseCatalog;
import org.apache.http.myHttp.StatusLine;
import org.apache.http.myHttp.annotation.Immutable;
import org.apache.http.myHttp.message.BasicHttpResponse;
import org.apache.http.myHttp.message.BasicStatusLine;
import org.apache.http.myHttp.protocol.HttpContext;
import org.apache.http.myHttp.util.Args;

@Immutable
public class DefaultHttpResponseFactory implements HttpResponseFactory {
    public static final DefaultHttpResponseFactory INSTANCE;
    protected final ReasonPhraseCatalog reasonCatalog;

    static {
        INSTANCE = new DefaultHttpResponseFactory();
    }

    public DefaultHttpResponseFactory() {
        this(EnglishReasonPhraseCatalog.INSTANCE);
    }

    public DefaultHttpResponseFactory(ReasonPhraseCatalog reasonPhraseCatalog) {
        this.reasonCatalog = (ReasonPhraseCatalog) Args.notNull(reasonPhraseCatalog, "Reason phrase catalog");
    }

    protected Locale determineLocale(HttpContext httpContext) {
        return Locale.getDefault();
    }

    public HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i, HttpContext httpContext) {
        Args.notNull(protocolVersion, "HTTP version");
        Locale determineLocale = determineLocale(httpContext);
        return new BasicHttpResponse(new BasicStatusLine(protocolVersion, i, this.reasonCatalog.getReason(i, determineLocale)), this.reasonCatalog, determineLocale);
    }

    public HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext) {
        Args.notNull(statusLine, "Status line");
        return new BasicHttpResponse(statusLine, this.reasonCatalog, determineLocale(httpContext));
    }
}
