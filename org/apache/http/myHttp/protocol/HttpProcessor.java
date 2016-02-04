package org.apache.http.myHttp.protocol;

import org.apache.http.myHttp.HttpRequestInterceptor;
import org.apache.http.myHttp.HttpResponseInterceptor;

public interface HttpProcessor extends HttpRequestInterceptor, HttpResponseInterceptor {
}
