package android.support.v4.os;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.os.a */
public class C0260a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m1797a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0261b.m1798a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
