package com.felipecsl.asymmetricgridview.library;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: com.felipecsl.asymmetricgridview.library.e */
class C1045e extends FutureTask<Result> {
    final /* synthetic */ C1041b f3935a;

    C1045e(C1041b c1041b, Callable callable) {
        this.f3935a = c1041b;
        super(callable);
    }

    protected void done() {
        try {
            this.f3935a.m6228c(get());
        } catch (Throwable e) {
            Log.w("AsyncTaskCompat", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            this.f3935a.m6228c(null);
        }
    }
}
