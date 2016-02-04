package android.support.v7.app;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;

/* renamed from: android.support.v7.app.o */
class C0389o {
    private static final int[] f1901a;

    static {
        f1901a = new int[]{16843531};
    }

    public static Drawable m3841a(Activity activity) {
        TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(f1901a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    public static C0390p m3842a(C0390p c0390p, Activity activity, int i) {
        if (c0390p == null) {
            c0390p = new C0390p(activity);
        }
        if (c0390p.f1902a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                c0390p.f1903b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
                if (VERSION.SDK_INT <= 19) {
                    actionBar.setSubtitle(actionBar.getSubtitle());
                }
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set content description via JB-MR2 API", e);
            }
        }
        return c0390p;
    }

    public static C0390p m3843a(C0390p c0390p, Activity activity, Drawable drawable, int i) {
        C0390p c0390p2 = new C0390p(activity);
        if (c0390p2.f1902a != null) {
            try {
                ActionBar actionBar = activity.getActionBar();
                c0390p2.f1902a.invoke(actionBar, new Object[]{drawable});
                c0390p2.f1903b.invoke(actionBar, new Object[]{Integer.valueOf(i)});
            } catch (Throwable e) {
                Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator via JB-MR2 API", e);
            }
        } else if (c0390p2.f1904c != null) {
            c0390p2.f1904c.setImageDrawable(drawable);
        } else {
            Log.w("ActionBarDrawerToggleHoneycomb", "Couldn't set home-as-up indicator");
        }
        return c0390p2;
    }
}
