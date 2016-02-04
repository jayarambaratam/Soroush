package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2163j;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ax */
class ax implements OnClickListener {
    final /* synthetic */ aw f6674a;

    ax(aw awVar) {
        this.f6674a = awVar;
    }

    public void onClick(View view) {
        C2163j c2163j = (C2163j) this.f6674a.m8619a();
        switch (az.f6676a[c2163j.m9899u().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6674a.f6672i.m9344a(c2163j.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6674a.f6672i.m9345b(c2163j.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6674a.f6672i.m9344a(c2163j.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6674a.f6672i.m9344a(c2163j.m9847k(), true);
            default:
        }
    }
}
