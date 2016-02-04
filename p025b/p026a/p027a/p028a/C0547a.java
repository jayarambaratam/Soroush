package p025b.p026a.p027a.p028a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.view.View;

/* renamed from: b.a.a.a.a */
public class C0547a {
    public static int m4154a(int i) {
        return VERSION.SDK_INT >= 11 ? C0547a.m4158c(i) : C0547a.m4156b(i);
    }

    public static void m4155a(View view, Runnable runnable) {
        if (VERSION.SDK_INT >= 16) {
            C0547a.m4157b(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    @TargetApi(5)
    private static int m4156b(int i) {
        return (65280 & i) >> 8;
    }

    @TargetApi(16)
    private static void m4157b(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    @TargetApi(11)
    private static int m4158c(int i) {
        return (65280 & i) >> 8;
    }
}
