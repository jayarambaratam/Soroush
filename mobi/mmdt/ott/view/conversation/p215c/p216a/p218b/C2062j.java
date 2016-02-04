package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2167d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.j */
class C2062j implements OnClickListener {
    final /* synthetic */ C2061i f6780a;

    C2062j(C2061i c2061i) {
        this.f6780a = c2061i;
    }

    public void onClick(View view) {
        C2167d c2167d = (C2167d) this.f6780a.m8619a();
        switch (C2064l.f6782a[c2167d.m9915r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6780a.f6778g.m9344a(c2167d.m9847k(), true);
            case VideoSize.HVGA /*2*/:
                this.f6780a.f6778g.m9345b(c2167d.m9847k());
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6780a.f6778g.m9344a(c2167d.m9847k(), true);
            case Version.API04_DONUT_16 /*4*/:
                this.f6780a.f6778g.m9344a(c2167d.m9847k(), true);
            default:
        }
    }
}
