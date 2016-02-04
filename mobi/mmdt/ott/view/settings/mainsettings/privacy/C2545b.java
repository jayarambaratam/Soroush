package mobi.mmdt.ott.view.settings.mainsettings.privacy;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.RadioGroup;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.privacy.b */
class C2545b implements OnClickListener {
    final /* synthetic */ RadioGroup f8170a;
    final /* synthetic */ PrivacySettingsListActivity f8171b;

    C2545b(PrivacySettingsListActivity privacySettingsListActivity, RadioGroup radioGroup) {
        this.f8171b = privacySettingsListActivity;
        this.f8170a = radioGroup;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f8170a.getCheckedRadioButtonId();
    }
}
