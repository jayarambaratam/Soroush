package org.linphone.compatibility;

import android.annotation.TargetApi;
import android.app.Activity;
import android.preference.Preference;
import android.preference.TwoStatePreference;

@TargetApi(14)
public class ApiFourteenPlus {
    public static void hideNavigationBar(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(2);
    }

    public static boolean isPreferenceChecked(Preference preference) {
        return ((TwoStatePreference) preference).isChecked();
    }

    public static void setPreferenceChecked(Preference preference, boolean z) {
        ((TwoStatePreference) preference).setChecked(z);
    }

    public static void showNavigationBar(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(0);
    }
}
