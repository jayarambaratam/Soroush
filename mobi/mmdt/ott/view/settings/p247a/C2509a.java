package mobi.mmdt.ott.view.settings.p247a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.settings.p248b.C2518b;

/* renamed from: mobi.mmdt.ott.view.settings.a.a */
public class C2509a extends C1712b {
    private TextView f8103a;
    private TextView f8104b;
    private View f8105c;

    public C2509a(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968799, c1790i);
        this.f8103a = (TextView) this.itemView.findViewById(2131689707);
        this.f8104b = (TextView) this.itemView.findViewById(2131689708);
        this.f8105c = this.itemView.findViewById(2131689710);
    }

    protected void m10832a(C1722f c1722f) {
        C2518b c2518b = (C2518b) c1722f;
        this.f8103a.setText(c2518b.m10844a());
        this.f8104b.setText(c2518b.m10845b());
        if (c2518b.m8660h() == 0) {
            this.f8105c.setVisibility(4);
        } else {
            this.f8105c.setVisibility(0);
        }
    }
}
