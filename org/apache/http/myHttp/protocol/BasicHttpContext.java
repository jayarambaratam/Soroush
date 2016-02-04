package org.apache.http.myHttp.protocol;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.myHttp.annotation.ThreadSafe;
import org.apache.http.myHttp.util.Args;

@ThreadSafe
public class BasicHttpContext implements HttpContext {
    private final Map<String, Object> map;
    private final HttpContext parentContext;

    public BasicHttpContext() {
        this(null);
    }

    public BasicHttpContext(HttpContext httpContext) {
        this.map = new ConcurrentHashMap();
        this.parentContext = httpContext;
    }

    public void clear() {
        this.map.clear();
    }

    public Object getAttribute(String str) {
        Args.notNull(str, "Id");
        Object obj = this.map.get(str);
        return (obj != null || this.parentContext == null) ? obj : this.parentContext.getAttribute(str);
    }

    public Object removeAttribute(String str) {
        Args.notNull(str, "Id");
        return this.map.remove(str);
    }

    public void setAttribute(String str, Object obj) {
        Args.notNull(str, "Id");
        if (obj != null) {
            this.map.put(str, obj);
        } else {
            this.map.remove(str);
        }
    }

    public String toString() {
        return this.map.toString();
    }
}
