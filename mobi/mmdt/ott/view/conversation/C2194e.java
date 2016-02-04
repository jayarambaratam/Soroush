package mobi.mmdt.ott.view.conversation;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.conversation.p213a.C1982b;

/* renamed from: mobi.mmdt.ott.view.conversation.e */
final class C2194e implements OnCheckedChangeListener {
    final /* synthetic */ String f7225a;
    final /* synthetic */ String f7226b;
    final /* synthetic */ C1982b f7227c;
    final /* synthetic */ boolean f7228d;

    C2194e(String str, String str2, C1982b c1982b, boolean z) {
        this.f7225a = str;
        this.f7226b = str2;
        this.f7227c = c1982b;
        this.f7228d = z;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        MyApplication.m6445a().m6450a(this.f7225a).putBoolean(C2135c.m9796b(this.f7225a, this.f7226b), z);
        if (this.f7227c != null) {
            this.f7227c.m9339a(this.f7225a, this.f7228d, z);
        }
    }
}
