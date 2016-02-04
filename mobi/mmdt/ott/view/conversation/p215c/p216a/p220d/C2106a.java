package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p215c.p216a.C2026a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.a */
public abstract class C2106a extends C2026a {
    private TextView f6897c;
    private RoundAvatarImageView f6898d;
    private C1987g f6899e;

    public C2106a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C1987g c1987g) {
        super(activity, c1790i, layoutInflater, viewGroup, i);
        this.f6897c = (TextView) this.itemView.findViewById(2131689720);
        this.f6898d = (RoundAvatarImageView) this.itemView.findViewById(2131689718);
        this.f6899e = c1987g;
        this.a = activity;
        this.f6898d.setOnClickListener(new C2107b(this));
    }

    protected void m9759a(C2153a c2153a) {
        super.m9659a(c2153a);
        this.f6897c.setText(c2153a.m9846j());
        this.f6898d.setName(c2153a.m9846j());
        this.f6898d.setBackgroundColor(C1111c.m6402b(this.a, c2153a.m9851w()));
        this.f6898d.setImageBitmap(null);
        if (c2153a.m9852y() == null || c2153a.m9852y().isEmpty()) {
            C0872i.m5267a(this.f6898d);
        } else {
            C0872i.m5265a(this.a).m5329a(aj.m8474a(c2153a.m9852y())).m4406a(0.25f).m4409a(C0652e.ALL).m4417a(this.f6898d);
        }
    }
}
