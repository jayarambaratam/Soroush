package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

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
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2186f;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.r */
public class C2123r extends C2106a {
    private ImageView f6954c;
    private ProgressWheel f6955d;
    private int f6956e;
    private C0866h<String, C0742b> f6957f;

    public C2123r(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C1987g c1987g) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968666, c1987g);
        this.f6957f = new C2124s(this);
        this.f6954c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6955d = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6956e = i;
    }

    protected void m9777a(C1722f c1722f) {
        C2153a c2153a = (C2186f) c1722f;
        super.m9759a(c2153a);
        int t = c2153a.m10011t() != 0 ? this.f6956e * c2153a.m10011t() : this.f6956e;
        int s = c2153a.m10010s() != 0 ? this.f6956e * c2153a.m10010s() : this.f6956e;
        LayoutParams layoutParams = this.f6954c.getLayoutParams();
        layoutParams.height = t;
        layoutParams.width = s;
        this.f6954c.setImageBitmap(null);
        if (c2153a.m10012u() == C1634g.FINISHED) {
            C0872i.m5265a(this.a).m5329a(c2153a.m10008q()).m4413a(this.f6957f).m4408a(s, t).m4406a(0.25f).m4417a(this.f6954c);
        } else {
            C1494c.m7540b(new C1464b(this.a, c2153a.m10013w(), c2153a.m10006o()));
        }
        switch (C2125t.f6959a[c2153a.m9849m().ordinal()]) {
        }
    }
}
