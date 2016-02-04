package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2187g;
import mobi.mmdt.ott.view.p178a.am;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.u */
public class C2126u extends C2106a {
    private TextView f6960c;
    private boolean f6961d;

    public C2126u(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1987g c1987g) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968670, c1987g);
        this.a = activity;
        this.f6960c = (TextView) this.itemView.findViewById(2131689740);
        this.f6960c.setOnLongClickListener(new C2127v(this));
        this.f6960c.setOnTouchListener(new C2128w(this));
    }

    protected void m9784a(C1722f c1722f) {
        C2153a c2153a = (C2187g) c1722f;
        super.m9759a(c2153a);
        this.f6960c.setTextSize((float) c2153a.m10015p());
        this.f6960c.setText(c2153a.m10014o());
        am.m8479a(this.f6960c);
        switch (C2129x.f6964a[c2153a.m9849m().ordinal()]) {
        }
    }
}
