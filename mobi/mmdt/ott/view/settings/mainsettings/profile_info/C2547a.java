package mobi.mmdt.ott.view.settings.mainsettings.profile_info;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.profile_info.a */
class C2547a implements TextWatcher {
    final /* synthetic */ ProfileInfoSettingsActivity f8175a;
    private boolean f8176b;

    C2547a(ProfileInfoSettingsActivity profileInfoSettingsActivity) {
        this.f8175a = profileInfoSettingsActivity;
        this.f8176b = true;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f8176b) {
            this.f8176b = false;
        } else {
            this.f8175a.f8172w = true;
        }
    }
}
