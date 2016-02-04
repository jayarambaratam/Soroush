package mobi.mmdt.ott.logic.notifications;

import android.content.Context;
import android.content.Intent;

/* renamed from: mobi.mmdt.ott.logic.notifications.c */
public class C1556c {
    public static void m7849a(Context context, int i) {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i);
        intent.putExtra("badge_count_package_name", context.getPackageName());
        intent.putExtra("badge_count_class_name", C1558e.m7854b(context));
        context.sendBroadcast(intent);
    }
}
