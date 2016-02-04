package mobi.mmdt.ott.view.conversation;

import android.text.Editable;
import android.text.TextWatcher;
import mobi.mmdt.ott.MyApplication;

/* renamed from: mobi.mmdt.ott.view.conversation.f */
final class C2236f implements TextWatcher {
    final /* synthetic */ String f7354a;
    final /* synthetic */ int f7355b;

    C2236f(String str, int i) {
        this.f7354a = str;
        this.f7355b = i;
    }

    public void afterTextChanged(Editable editable) {
        MyApplication.m6445a().m6450a(this.f7354a).putString(C2135c.m9793a(this.f7354a, this.f7355b), editable.toString());
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
