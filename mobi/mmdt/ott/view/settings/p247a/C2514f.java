package mobi.mmdt.ott.view.settings.p247a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.p109d.p111b.C1309a;

/* renamed from: mobi.mmdt.ott.view.settings.a.f */
class C2514f implements OnCheckedChangeListener {
    final /* synthetic */ C2512d f8118a;

    C2514f(C2512d c2512d) {
        this.f8118a = c2512d;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!this.f8118a.f8116e) {
            C1309a.m6934a(compoundButton.getContext()).m6968k(z);
            C1490b.m7516a(compoundButton.getContext()).m7525c();
        }
    }
}
