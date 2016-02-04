package mobi.mmdt.ott.view.contact.p209a;

import android.text.Editable;
import android.text.TextWatcher;

/* renamed from: mobi.mmdt.ott.view.contact.a.h */
class C1961h implements TextWatcher {
    final /* synthetic */ C1960g f6294a;

    C1961h(C1960g c1960g) {
        this.f6294a = c1960g;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f6294a.f6292k.m9243a(charSequence.toString());
    }
}
