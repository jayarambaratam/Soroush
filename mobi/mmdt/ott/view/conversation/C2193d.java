package mobi.mmdt.ott.view.conversation;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.conversation.p213a.C1982b;

/* renamed from: mobi.mmdt.ott.view.conversation.d */
final class C2193d implements OnCheckedChangeListener {
    final /* synthetic */ String f7221a;
    final /* synthetic */ String f7222b;
    final /* synthetic */ C1982b f7223c;
    final /* synthetic */ boolean f7224d;

    C2193d(String str, String str2, C1982b c1982b, boolean z) {
        this.f7221a = str;
        this.f7222b = str2;
        this.f7223c = c1982b;
        this.f7224d = z;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MyApplication.m6445a().m6450a(this.f7221a).putBoolean(C2135c.m9794a(this.f7221a, this.f7222b), z);
        if (this.f7223c != null) {
            this.f7223c.m9339a(this.f7221a, this.f7224d, z);
        }
    }
}
