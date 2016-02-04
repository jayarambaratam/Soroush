package org.apache.http.myHttp.pool;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import org.apache.http.myHttp.annotation.ThreadSafe;
import org.apache.http.myHttp.concurrent.FutureCallback;
import org.apache.http.myHttp.util.Args;

@ThreadSafe
abstract class PoolEntryFuture<T> implements Future<T> {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private final Condition condition;
    private final Lock lock;
    private T result;

    PoolEntryFuture(Lock lock, FutureCallback<T> futureCallback) {
        this.lock = lock;
        this.condition = lock.newCondition();
        this.callback = futureCallback;
    }

    public boolean await(Date date) {
        this.lock.lock();
        try {
            if (this.cancelled) {
                throw new InterruptedException("Operation interrupted");
            }
            boolean awaitUntil;
            if (date != null) {
                awaitUntil = this.condition.awaitUntil(date);
            } else {
                this.condition.await();
                awaitUntil = true;
            }
            if (!this.cancelled) {
                return awaitUntil;
            }
            throw new InterruptedException("Operation interrupted");
        } finally {
            this.lock.unlock();
        }
    }

    public boolean cancel(boolean z) {
        this.lock.lock();
        try {
            if (this.completed) {
                return false;
            }
            this.completed = true;
            this.cancelled = true;
            if (this.callback != null) {
                this.callback.cancelled();
            }
            this.condition.signalAll();
            this.lock.unlock();
            return true;
        } finally {
            this.lock.unlock();
        }
    }

    public T get() {
        try {
            return get(0, TimeUnit.MILLISECONDS);
        } catch (Throwable e) {
            throw new ExecutionException(e);
        }
    }

    public T get(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        this.lock.lock();
        try {
            T t;
            if (this.completed) {
                t = this.result;
                this.lock.unlock();
            } else {
                this.result = getPoolEntry(j, timeUnit);
                this.completed = true;
                if (this.callback != null) {
                    this.callback.completed(this.result);
                }
                t = this.result;
                this.lock.unlock();
            }
            return t;
        } catch (Throwable e) {
            this.completed = true;
            this.result = null;
            if (this.callback != null) {
                this.callback.failed(e);
            }
            throw new ExecutionException(e);
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    protected abstract T getPoolEntry(long j, TimeUnit timeUnit);

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isDone() {
        return this.completed;
    }

    public void wakeup() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
