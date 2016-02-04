package android.support.v4.p012b;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: android.support.v4.b.aa */
class aa extends FutureTask<Result> {
    final /* synthetic */ C0156x f1058a;

    aa(C0156x c0156x, Callable callable) {
        this.f1058a = c0156x;
        super(callable);
    }

    protected void done() {
        try {
            this.f1058a.m1497c(get());
        } catch (Throwable e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            this.f1058a.m1497c(null);
        } catch (Throwable e4) {
            RuntimeException runtimeException = new RuntimeException("An error occurred while executing doInBackground()", e4);
        }
    }
}
