package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.provider.p170d.C1603h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2159f;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ai */
class ai implements OnClickListener {
    final /* synthetic */ ah f6640a;

    ai(ah ahVar) {
        this.f6640a = ahVar;
    }

    public void onClick(View view) {
        C2159f c2159f = (C2159f) this.f6640a.m8619a();
        switch (ak.f6642a[c2159f.m9877u().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6640a.f6639i.m9344a(c2159f.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6640a.f6639i.m9345b(c2159f.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6640a.f6639i.m9344a(c2159f.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6640a.f6639i.m9344a(c2159f.m9847k(), true);
            case Version.API05_ECLAIR_20 /*5*/:
                if (c2159f.m9875s() == C1603h.PLAYING.ordinal()) {
                    this.f6640a.f6638h.m9348z();
                } else {
                    this.f6640a.f6638h.m9346a(c2159f.m9847k());
                }
            default:
        }
    }
}
