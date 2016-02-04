package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p149i.p151b.C1464b;
import mobi.mmdt.ott.provider.p174h.C1634g;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2160g;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.al */
public class al extends C2027a {
    private ImageView f6644d;
    private ProgressWheel f6645e;
    private int f6646f;
    private C0866h<String, C0742b> f6647g;

    public al(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C1981a c1981a) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968663, c1981a);
        this.f6647g = new am(this);
        this.f6644d = (ImageView) this.itemView.findViewById(2131689732);
        this.f6645e = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6646f = i;
    }

    protected void m9671a(C1722f c1722f) {
        C2154a c2154a = (C2160g) c1722f;
        super.m9664a(c2154a);
        int v = c2154a.m9883v() != 0 ? this.f6646f * c2154a.m9883v() : this.f6646f;
        int u = c2154a.m9882u() != 0 ? this.f6646f * c2154a.m9882u() : this.f6646f;
        LayoutParams layoutParams = this.f6644d.getLayoutParams();
        layoutParams.height = v;
        layoutParams.width = u;
        this.f6644d.setImageBitmap(null);
        if (c2154a.m9885x() == C1634g.FINISHED) {
            C0872i.m5265a(this.a).m5329a(c2154a.m9880s()).m4413a(this.f6647g).m4408a(u, v).m4406a(0.25f).m4417a(this.f6644d);
        } else {
            C1494c.m7541c(new C1464b(this.a, c2154a.m9884w(), c2154a.m9878q()));
        }
        switch (an.f6649a[c2154a.m9849m().ordinal()]) {
        }
    }
}
