package mobi.mmdt.componentsutils.p079a.p080a;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.protocol.HttpRequestExecutor;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.componentsutils.a.a.b */
public class C1104b {
    public static final boolean f4137a;
    public static final boolean f4138b;

    static {
        f4137a = C1103a.m6359a();
        f4138b = C1103a.m6360b();
    }

    public static void m6362a(Object obj, String str) {
        int length = str.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        for (int i = 0; i < length; i++) {
            if (f4137a) {
                Log.e("MyApp", str.substring(i * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, (i + 1) * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
            }
        }
        if (str.length() % HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE != 0 && f4137a) {
            Log.e("MyApp", str.substring(length * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
        }
    }

    public static void m6363a(Object obj, String str, Throwable th) {
        int length = str.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        for (int i = 0; i < length; i++) {
            if (f4137a) {
                Log.wtf("MyApp", str.substring(i * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, (i + 1) * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE), th);
            }
        }
        if (str.length() % HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE != 0 && f4137a) {
            Log.wtf("MyApp", str.substring(length * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE), th);
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        C0002c.m2a().m17c(new C1106d(th.getMessage(), C1105c.bug, stringWriter.toString(), BuildConfig.FLAVOR));
    }

    public static void m6364a(Object obj, Throwable th) {
        if (f4137a) {
            Log.wtf("MyApp", th);
        }
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        C0002c.m2a().m17c(new C1106d(th.getMessage(), C1105c.bug, stringWriter.toString(), BuildConfig.FLAVOR));
    }

    public static void m6365a(String str) {
        int length = str.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        for (int i = 0; i < length; i++) {
            if (f4137a) {
                Log.d("MyApp", "***** " + str.substring(i * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, (i + 1) * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
            }
        }
        if (str.length() % HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE != 0 && f4137a) {
            Log.d("MyApp", "*****  " + str.substring(length * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
        }
    }

    public static void m6366b(Object obj, String str) {
        int length = str.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        for (int i = 0; i < length; i++) {
            if (f4137a) {
                Log.d("MyApp", str.substring(i * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, (i + 1) * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
            }
        }
        if (str.length() % HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE != 0 && f4137a) {
            Log.d("MyApp", str.substring(length * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
        }
    }

    public static void m6367b(Object obj, String str, Throwable th) {
        int length = str.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        for (int i = 0; i < length; i++) {
            if (f4137a) {
                Log.e("MyApp", str.substring(i * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, (i + 1) * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE), th);
            }
        }
        if (str.length() % HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE != 0 && f4137a) {
            Log.e("MyApp", str.substring(length * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE), th);
        }
    }

    public static void m6368b(Object obj, Throwable th) {
        if (f4137a) {
            Log.e("MyApp", "Some Exception", th);
        }
    }

    public static void m6369c(Object obj, String str) {
        int length = str.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        for (int i = 0; i < length; i++) {
            if (f4137a) {
                Log.i("MyApp", str.substring(i * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, (i + 1) * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
            }
        }
        if (str.length() % HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE != 0 && f4137a) {
            Log.i("MyApp", str.substring(length * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
        }
    }

    public static void m6370d(Object obj, String str) {
        int length = str.length() / HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE;
        for (int i = 0; i < length; i++) {
            if (f4137a) {
                Log.v("MyApp", str.substring(i * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE, (i + 1) * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
            }
        }
        if (str.length() % HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE != 0 && f4137a) {
            Log.v("MyApp", str.substring(length * HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE));
        }
    }
}
