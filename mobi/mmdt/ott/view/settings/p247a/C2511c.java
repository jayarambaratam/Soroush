package mobi.mmdt.ott.view.settings.p247a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.settings.p248b.C2520d;

/* renamed from: mobi.mmdt.ott.view.settings.a.c */
public class C2511c extends C1712b {
    private TextView f8110a;
    private View f8111b;

    public C2511c(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968802, c1790i);
        this.f8110a = (TextView) this.itemView.findViewById(2131689707);
        this.f8111b = this.itemView.findViewById(2131689710);
    }

    protected void m10834a(C1722f c1722f) {
        C2520d c2520d = (C2520d) c1722f;
        this.f8110a.setText(c2520d.m10849a());
        if (c2520d.m8660h() == 0) {
            this.f8111b.setVisibility(4);
        } else {
            this.f8111b.setVisibility(0);
        }
    }
}
