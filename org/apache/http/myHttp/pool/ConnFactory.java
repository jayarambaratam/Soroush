package org.apache.http.myHttp.pool;

public interface ConnFactory<T, C> {
    C create(T t);
}
