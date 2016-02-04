package mobi.mmdt.ott.view.settings.mainsettings.privacy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.privacy.a */
class C2544a implements OnClickListener {
    final /* synthetic */ RadioGroup f8168a;
    final /* synthetic */ PrivacySettingsListActivity f8169b;

    C2544a(PrivacySettingsListActivity privacySettingsListActivity, RadioGroup radioGroup) {
        this.f8169b = privacySettingsListActivity;
        this.f8168a = radioGroup;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8168a.getCheckedRadioButtonId();
    }
}
