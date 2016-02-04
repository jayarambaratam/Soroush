package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2169f;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.q */
public class C2069q extends C2053a {
    private ImageView f6794c;
    private ProgressWheel f6795d;
    private int f6796e;
    private C0866h<String, C0742b> f6797f;

    public C2069q(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968664);
        this.f6797f = new C2070r(this);
        this.f6794c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6795d = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6796e = i;
    }

    protected void m9719a(C1722f c1722f) {
        C2169f c2169f = (C2169f) c1722f;
        super.m9659a(c2169f);
        int t = c2169f.m9927t() != 0 ? this.f6796e * c2169f.m9927t() : this.f6796e;
        int s = c2169f.m9926s() != 0 ? this.f6796e * c2169f.m9926s() : this.f6796e;
        LayoutParams layoutParams = this.f6794c.getLayoutParams();
        layoutParams.height = t;
        layoutParams.width = s;
        this.f6794c.setImageBitmap(null);
        if (c2169f.m9929v() == C1634g.FINISHED) {
            C0872i.m5265a(this.a).m5329a(c2169f.m9924q()).m4413a(this.f6797f).m4408a(s, t).m4406a(0.25f).m4417a(this.f6794c);
        } else {
            C1494c.m7540b(new C1464b(this.a, c2169f.m9928u(), c2169f.m9922o()));
        }
        switch (C2071s.f6799a[c2169f.m9849m().ordinal()]) {
        }
    }
}
