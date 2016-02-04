package android.support.v4.os;

import android.os.AsyncTask;

/* renamed from: android.support.v4.os.b */
class C0261b {
    static <Params, Progress, Result> void m1798a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
