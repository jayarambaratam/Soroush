package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class bc extends bb {
    bc() {
    }

    public Intent m1134a(Activity activity) {
        Intent a = bd.m1139a(activity);
        return a == null ? m1137b(activity) : a;
    }

    public String m1135a(Context context, ActivityInfo activityInfo) {
        String a = bd.m1140a(activityInfo);
        return a == null ? super.m1131a(context, activityInfo) : a;
    }

    public boolean m1136a(Activity activity, Intent intent) {
        return bd.m1141a(activity, intent);
    }

    Intent m1137b(Activity activity) {
        return super.m1130a(activity);
    }

    public void m1138b(Activity activity, Intent intent) {
        bd.m1142b(activity, intent);
    }
}
