package com.p032a.p033a.p037d.p039b.p041b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.Log;

/* renamed from: com.a.a.d.b.b.q */
public class C0635q {
    private final int f2604a;
    private final int f2605b;
    private final Context f2606c;

    public C0635q(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new C0637r(context.getResources().getDisplayMetrics()));
    }

    C0635q(Context context, ActivityManager activityManager, C0636s c0636s) {
        this.f2606c = context;
        int a = C0635q.m4619a(activityManager);
        int a2 = (c0636s.m4624a() * c0636s.m4625b()) * 4;
        int i = a2 * 4;
        a2 *= 2;
        if (a2 + i <= a) {
            this.f2605b = a2;
            this.f2604a = i;
        } else {
            int round = Math.round(((float) a) / 6.0f);
            this.f2605b = round * 2;
            this.f2604a = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + m4620a(this.f2605b) + " pool size: " + m4620a(this.f2604a) + " memory class limited? " + (a2 + i > a) + " max size: " + m4620a(a) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + C0635q.m4621b(activityManager));
        }
    }

    private static int m4619a(ActivityManager activityManager) {
        return Math.round((C0635q.m4621b(activityManager) ? 0.33f : 0.4f) * ((float) ((activityManager.getMemoryClass() * 1024) * 1024)));
    }

    private String m4620a(int i) {
        return Formatter.formatFileSize(this.f2606c, (long) i);
    }

    @TargetApi(19)
    private static boolean m4621b(ActivityManager activityManager) {
        int i = VERSION.SDK_INT;
        return i < 11 || (i >= 19 && activityManager.isLowRamDevice());
    }

    public int m4622a() {
        return this.f2605b;
    }

    public int m4623b() {
        return this.f2604a;
    }
}
