package org.apache.http.myHttp.concurrent;

public interface FutureCallback<T> {
    void cancelled();

    void completed(T t);

    void failed(Exception exception);
}
