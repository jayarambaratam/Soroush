package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2163j;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ay */
class ay implements OnClickListener {
    final /* synthetic */ aw f6675a;

    ay(aw awVar) {
        this.f6675a = awVar;
    }

    public void onClick(View view) {
        C2163j c2163j = (C2163j) this.f6675a.m8619a();
        switch (az.f6676a[c2163j.m9899u().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6675a.f6673j.m9341a(c2163j.m9895q(), c2163j.m9845i(), true);
            default:
        }
    }
}
