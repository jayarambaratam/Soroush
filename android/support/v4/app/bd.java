package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

class bd {
    public static Intent m1139a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static String m1140a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }

    public static boolean m1141a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m1142b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }
}
