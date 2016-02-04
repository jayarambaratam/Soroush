package mobi.mmdt.ott.view.contact.p209a;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: mobi.mmdt.ott.view.contact.a.k */
class C1963k implements TextWatcher {
    final /* synthetic */ C1962j f6298a;

    C1963k(C1962j c1962j) {
        this.f6298a = c1962j;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6298a.f6296j.m9243a(charSequence.toString());
    }
}
