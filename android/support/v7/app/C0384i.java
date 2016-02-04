package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.support.v7.p009c.p010a.C0382c;

/* renamed from: android.support.v7.app.i */
class C0384i extends C0382c implements C0383j {
    private final Activity f1893a;

    public C0384i(Activity activity, Context context) {
        super(context);
        this.f1893a = activity;
    }

    public void m3820a(float f) {
        if (f == 1.0f) {
            m3816b(true);
        } else if (f == 0.0f) {
            m3816b(false);
        }
        m3818d(f);
    }
}
