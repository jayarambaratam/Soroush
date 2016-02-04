package mobi.mmdt.ott.view.conversation.activities;

import mobi.mmdt.ott.logic.p160f.C1527g;
import mobi.mmdt.ott.provider.p170d.C1605j;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.i */
class C2001i implements C1527g {
    final /* synthetic */ C1992a f6539a;

    C2001i(C1992a c1992a) {
        this.f6539a = c1992a;
    }

    public void m9623a(int i) {
    }

    public void m9624a(int i, int i2) {
        this.f6539a.m9378b(this.f6539a.f6366p.m7691d(), BuildConfig.FLAVOR, C1605j.PUSH_TO_TALK);
    }

    public void m9625a(int i, Exception exception) {
    }

    public void m9626b(int i) {
        this.f6539a.runOnUiThread(new C2002j(this));
    }
}
