package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2161h;
import mobi.mmdt.ott.view.p178a.am;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ao */
public class ao extends C2027a {
    private TextView f6650d;
    private boolean f6651e;

    public ao(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1981a c1981a) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968667, c1981a);
        this.f6650d = (TextView) this.itemView.findViewById(2131689740);
        this.f6650d.setOnLongClickListener(new ap(this));
        this.f6650d.setOnTouchListener(new aq(this));
    }

    protected void m9678a(C1722f c1722f) {
        C2154a c2154a = (C2161h) c1722f;
        super.m9664a(c2154a);
        this.f6650d.setTextSize((float) c2154a.m9887r());
        this.f6650d.setText(c2154a.m9886q());
        am.m8479a(this.f6650d);
        switch (ar.f6654a[c2154a.m9849m().ordinal()]) {
        }
    }
}
