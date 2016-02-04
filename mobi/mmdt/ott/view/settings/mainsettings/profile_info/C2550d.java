package mobi.mmdt.ott.view.settings.mainsettings.profile_info;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.profile_info.d */
class C2550d implements OnClickListener {
    final /* synthetic */ ProfileInfoSettingsActivity f8180a;

    C2550d(ProfileInfoSettingsActivity profileInfoSettingsActivity) {
        this.f8180a = profileInfoSettingsActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new Handler().postDelayed(new C2561e(this), 50);
    }
}
