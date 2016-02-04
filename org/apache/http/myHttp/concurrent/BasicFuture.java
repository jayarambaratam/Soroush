package org.apache.http.myHttp.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.http.myHttp.util.Args;

public class BasicFuture<T> implements Future<T>, Cancellable {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private volatile Exception ex;
    private volatile T result;

    public BasicFuture(FutureCallback<T> futureCallback) {
        this.callback = futureCallback;
    }

    private T getResult() {
        if (this.ex == null) {
            return this.result;
        }
        throw new ExecutionException(this.ex);
    }

    public boolean cancel() {
        return cancel(true);
    }

    public boolean cancel(boolean z) {
        boolean z2 = true;
        synchronized (this) {
            if (this.completed) {
                z2 = false;
            } else {
                this.completed = true;
                this.cancelled = true;
                notifyAll();
                if (this.callback != null) {
                    this.callback.cancelled();
                }
            }
        }
        return z2;
    }

    public boolean completed(T t) {
        boolean z = true;
        synchronized (this) {
            if (this.completed) {
                z = false;
            } else {
                this.completed = true;
                this.result = t;
                notifyAll();
                if (this.callback != null) {
                    this.callback.completed(t);
                }
            }
        }
        return z;
    }

    public boolean failed(Exception exception) {
        boolean z = true;
        synchronized (this) {
            if (this.completed) {
                z = false;
            } else {
                this.completed = true;
                this.ex = exception;
                notifyAll();
                if (this.callback != null) {
                    this.callback.failed(exception);
                }
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized T get() {
        /*
        r1 = this;
        monitor-enter(r1);
    L_0x0001:
        r0 = r1.completed;	 Catch:{ all -> 0x0009 }
        if (r0 != 0) goto L_0x000c;
    L_0x0005:
        r1.wait();	 Catch:{ all -> 0x0009 }
        goto L_0x0001;
    L_0x0009:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
    L_0x000c:
        r0 = r1.getResult();	 Catch:{ all -> 0x0009 }
        monitor-exit(r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.myHttp.concurrent.BasicFuture.get():T");
    }

    public synchronized T get(long j, TimeUnit timeUnit) {
        T result;
        Args.notNull(timeUnit, "Time unit");
        long toMillis = timeUnit.toMillis(j);
        long currentTimeMillis = toMillis <= 0 ? 0 : System.currentTimeMillis();
        if (this.completed) {
            result = getResult();
        } else if (toMillis <= 0) {
            throw new TimeoutException();
        } else {
            long j2 = toMillis;
            do {
                wait(j2);
                if (this.completed) {
                    result = getResult();
                } else {
                    j2 = toMillis - (System.currentTimeMillis() - currentTimeMillis);
                }
            } while (j2 > 0);
            throw new TimeoutException();
        }
        return result;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isDone() {
        return this.completed;
    }
}
