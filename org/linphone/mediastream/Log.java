package org.linphone.mediastream;

public final class Log {
    public static String TAG;
    private static boolean isLogEnabled;
    private static final boolean useIsLoggable = false;

    static {
        TAG = "Linphone";
        isLogEnabled = true;
    }

    public Log(String str, boolean z) {
        TAG = str;
        isLogEnabled = z;
    }

    public static void m11088d(Throwable th, Object... objArr) {
        if (isLoggable(3)) {
            android.util.Log.d(TAG, toString(objArr), th);
        }
    }

    public static void m11089d(Object... objArr) {
        if (isLoggable(3)) {
            android.util.Log.d(TAG, toString(objArr));
        }
    }

    public static void m11090e(Throwable th, Object... objArr) {
        if (isLoggable(6)) {
            android.util.Log.e(TAG, toString(objArr), th);
        }
    }

    public static void m11091e(Object... objArr) {
        if (isLoggable(6)) {
            android.util.Log.e(TAG, toString(objArr));
        }
    }

    public static void m11092f(Throwable th, Object... objArr) {
        if (isLoggable(6)) {
            android.util.Log.e(TAG, toString(objArr), th);
            throw new RuntimeException("Fatal error : " + toString(objArr), th);
        }
    }

    public static void m11093f(Object... objArr) {
        if (isLoggable(6)) {
            android.util.Log.e(TAG, toString(objArr));
            throw new RuntimeException("Fatal error : " + toString(objArr));
        }
    }

    public static void m11094i(Throwable th, Object... objArr) {
        if (isLoggable(4)) {
            android.util.Log.i(TAG, toString(objArr), th);
        }
    }

    public static void m11095i(Object... objArr) {
        if (isLoggable(4)) {
            android.util.Log.i(TAG, toString(objArr));
        }
    }

    private static boolean isLoggable(int i) {
        return isLogEnabled;
    }

    private static String toString(Object... objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object append : objArr) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }

    public static void m11096w(Throwable th, Object... objArr) {
        if (isLoggable(5)) {
            android.util.Log.w(TAG, toString(objArr), th);
        }
    }

    public static void m11097w(Object... objArr) {
        if (isLoggable(5)) {
            android.util.Log.w(TAG, toString(objArr));
        }
    }
}
