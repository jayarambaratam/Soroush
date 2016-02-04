package org.apache.http.myHttp.config;

public interface Lookup<I> {
    I lookup(String str);
}
