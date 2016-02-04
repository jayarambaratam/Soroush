package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.support.v4.p012b.C0168n;

public class az {
    private static final ba f866a;

    static {
        if (VERSION.SDK_INT >= 16) {
            f866a = new bc();
        } else {
            f866a = new bb();
        }
    }

    public static Intent m1119a(Activity activity) {
        return f866a.m1126a(activity);
    }

    public static Intent m1120a(Context context, ComponentName componentName) {
        String b = m1123b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return m1123b(context, componentName2) == null ? C0168n.m1535a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean m1121a(Activity activity, Intent intent) {
        return f866a.m1128a(activity, intent);
    }

    public static String m1122b(Activity activity) {
        try {
            return m1123b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m1123b(Context context, ComponentName componentName) {
        return f866a.m1127a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void m1124b(Activity activity, Intent intent) {
        f866a.m1129b(activity, intent);
    }
}
