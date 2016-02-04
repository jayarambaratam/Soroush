package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2189i;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.ae */
class ae implements OnClickListener {
    final /* synthetic */ ac f6911a;

    ae(ac acVar) {
        this.f6911a = acVar;
    }

    public void onClick(View view) {
        C2189i c2189i = (C2189i) this.f6911a.m8619a();
        switch (af.f6912a[c2189i.m10027s().ordinal()]) {
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6911a.f6909i.m9341a(c2189i.m10023o(), c2189i.m9845i(), true);
            default:
        }
    }
}
