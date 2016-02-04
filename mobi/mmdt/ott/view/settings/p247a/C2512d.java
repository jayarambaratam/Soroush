package mobi.mmdt.ott.view.settings.p247a;

import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.settings.p248b.C2521e;

/* renamed from: mobi.mmdt.ott.view.settings.a.d */
public class C2512d extends C1712b {
    private TextView f8112a;
    private ViewGroup f8113b;
    private SwitchCompat f8114c;
    private View f8115d;
    private boolean f8116e;

    public C2512d(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968803, c1790i);
        this.f8116e = false;
        this.f8112a = (TextView) this.itemView.findViewById(2131689707);
        this.f8114c = (SwitchCompat) this.itemView.findViewById(2131689946);
        this.f8113b = (ViewGroup) this.itemView.findViewById(2131689635);
        this.f8115d = this.itemView.findViewById(2131689710);
        this.f8113b.setOnTouchListener(new C2513e(this));
        this.f8114c.setOnCheckedChangeListener(new C2514f(this));
    }

    protected void m10837a(C1722f c1722f) {
        C2521e c2521e = (C2521e) c1722f;
        this.f8112a.setText(c2521e.m10850a());
        this.f8116e = true;
        this.f8114c.setChecked(c2521e.m10851b());
        this.f8116e = false;
        if (c2521e.m8660h() == 0) {
            this.f8115d.setVisibility(4);
        } else {
            this.f8115d.setVisibility(0);
        }
    }
}
