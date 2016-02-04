package mobi.mmdt.ott.view.components.mediaselector.p205a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.mmdt.ott.view.components.mediaselector.p206b.C1896c;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.a.c */
class C1891c implements OnCheckedChangeListener {
    final /* synthetic */ C1890b f6077a;

    C1891c(C1890b c1890b) {
        this.f6077a = c1890b;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!this.f6077a.f6076h) {
            if (z) {
                this.f6077a.f6074f.m9122a((C1896c) this.f6077a.m8619a());
            } else {
                this.f6077a.f6074f.m9124b((C1896c) this.f6077a.m8619a());
            }
        }
    }
}
