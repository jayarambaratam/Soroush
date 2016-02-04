package mobi.mmdt.ott.view.contact.p209a.p211b;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1953b;

/* renamed from: mobi.mmdt.ott.view.contact.a.b.c */
class C1947c implements OnCheckedChangeListener {
    final /* synthetic */ C1945a f6254a;

    C1947c(C1945a c1945a) {
        this.f6254a = c1945a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (((C1953b) this.f6254a.m8619a()).m9267k() && !this.f6254a.f6252i) {
            if (z) {
                this.f6254a.f6251h.m9225a(((C1953b) this.f6254a.m8619a()).m9261c());
            } else {
                this.f6254a.f6251h.m9226b(((C1953b) this.f6254a.m8619a()).m9261c());
            }
        }
    }
}
