package org.apache.http.myHttp.pool;

public interface PoolEntryCallback<T, C> {
    void process(PoolEntry<T, C> poolEntry);
}
