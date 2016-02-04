package mobi.mmdt.ott.view.settings.p247a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.settings.p248b.C2519c;

/* renamed from: mobi.mmdt.ott.view.settings.a.b */
public class C2510b extends C1712b {
    private TextView f8106a;
    private TextView f8107b;
    private TextView f8108c;
    private View f8109d;

    public C2510b(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968800, c1790i);
        this.f8106a = (TextView) this.itemView.findViewById(2131689707);
        this.f8107b = (TextView) this.itemView.findViewById(2131689708);
        this.f8108c = (TextView) this.itemView.findViewById(2131689709);
        this.f8109d = this.itemView.findViewById(2131689710);
    }

    protected void m10833a(C1722f c1722f) {
        C2519c c2519c = (C2519c) c1722f;
        this.f8106a.setText(c2519c.m10846a());
        this.f8107b.setText(c2519c.m10847b());
        this.f8108c.setText(c2519c.m10848c());
        if (c2519c.m8660h() == 0) {
            this.f8109d.setVisibility(4);
        } else {
            this.f8109d.setVisibility(0);
        }
    }
}
