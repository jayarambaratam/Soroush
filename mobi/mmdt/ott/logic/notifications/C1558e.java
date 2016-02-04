package mobi.mmdt.ott.logic.notifications;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import mobi.mmdt.componentsutils.p079a.C1111c;

/* renamed from: mobi.mmdt.ott.logic.notifications.e */
public class C1558e {
    public static Bitmap m7853a(Context context) {
        return VERSION.SDK_INT >= 21 ? C1111c.m6392a(context.getResources().getDrawable(2130903041, context.getTheme())) : C1111c.m6392a(context.getResources().getDrawable(2130903041));
    }

    public static String m7854b(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            if (resolveInfo.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                return resolveInfo.activityInfo.name;
            }
        }
        return null;
    }
}
