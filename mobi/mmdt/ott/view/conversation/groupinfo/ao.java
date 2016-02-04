package mobi.mmdt.ott.view.conversation.groupinfo;

import android.text.Editable;
import android.text.TextWatcher;

class ao implements TextWatcher {
    final /* synthetic */ GroupInfoActivity f7441a;
    private boolean f7442b;

    ao(GroupInfoActivity groupInfoActivity) {
        this.f7441a = groupInfoActivity;
        this.f7442b = true;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f7442b) {
            this.f7442b = false;
        } else {
            this.f7441a.f7415z = true;
        }
    }
}
