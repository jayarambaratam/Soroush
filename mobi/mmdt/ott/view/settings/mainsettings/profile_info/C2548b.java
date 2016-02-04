package mobi.mmdt.ott.view.settings.mainsettings.profile_info;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: mobi.mmdt.ott.view.settings.mainsettings.profile_info.b */
class C2548b implements TextWatcher {
    final /* synthetic */ ProfileInfoSettingsActivity f8177a;
    private boolean f8178b;

    C2548b(ProfileInfoSettingsActivity profileInfoSettingsActivity) {
        this.f8177a = profileInfoSettingsActivity;
        this.f8178b = true;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f8178b) {
            this.f8178b = false;
        } else {
            this.f8177a.f8172w = true;
        }
    }
}
