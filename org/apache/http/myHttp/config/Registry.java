package org.apache.http.myHttp.config;

import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.myHttp.annotation.ThreadSafe;

@ThreadSafe
public final class Registry<I> implements Lookup<I> {
    private final Map<String, I> map;

    Registry(Map<String, I> map) {
        this.map = new ConcurrentHashMap(map);
    }

    public I lookup(String str) {
        return str == null ? null : this.map.get(str.toLowerCase(Locale.US));
    }

    public String toString() {
        return this.map.toString();
    }
}
