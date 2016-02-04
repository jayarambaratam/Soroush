package android.support.design.widget;

import android.text.Editable;
import android.text.TextWatcher;

class ch implements TextWatcher {
    final /* synthetic */ TextInputLayout f557a;

    ch(TextInputLayout textInputLayout) {
        this.f557a = textInputLayout;
    }

    public void afterTextChanged(Editable editable) {
        this.f557a.m467a(true);
        if (this.f557a.f417i) {
            this.f557a.m462a(editable.length());
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
