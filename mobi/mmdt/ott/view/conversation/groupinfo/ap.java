package mobi.mmdt.ott.view.conversation.groupinfo;

import android.text.Editable;
import android.text.TextWatcher;

class ap implements TextWatcher {
    final /* synthetic */ GroupInfoActivity f7443a;
    private boolean f7444b;

    ap(GroupInfoActivity groupInfoActivity) {
        this.f7443a = groupInfoActivity;
        this.f7444b = true;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f7444b) {
            this.f7444b = false;
        } else {
            this.f7443a.f7415z = true;
        }
    }
}
