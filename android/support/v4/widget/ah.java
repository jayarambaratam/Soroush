package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;

public class ah {
    private static final ak f1579b;
    private Object f1580a;

    static {
        if (VERSION.SDK_INT >= 21) {
            f1579b = new al();
        } else if (VERSION.SDK_INT >= 14) {
            f1579b = new aj();
        } else {
            f1579b = new ai();
        }
    }

    public ah(Context context) {
        this.f1580a = f1579b.m3142a(context);
    }

    public void m3134a(int i, int i2) {
        f1579b.m3143a(this.f1580a, i, i2);
    }

    public boolean m3135a() {
        return f1579b.m3144a(this.f1580a);
    }

    public boolean m3136a(float f) {
        return f1579b.m3145a(this.f1580a, f);
    }

    public boolean m3137a(float f, float f2) {
        return f1579b.m3146a(this.f1580a, f, f2);
    }

    public boolean m3138a(int i) {
        return f1579b.m3147a(this.f1580a, i);
    }

    public boolean m3139a(Canvas canvas) {
        return f1579b.m3148a(this.f1580a, canvas);
    }

    public void m3140b() {
        f1579b.m3149b(this.f1580a);
    }

    public boolean m3141c() {
        return f1579b.m3150c(this.f1580a);
    }
}
