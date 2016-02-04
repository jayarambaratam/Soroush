package mobi.mmdt.ott.view.conversation.p215c.p221b;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p215c.C2025a;
import mobi.mmdt.ott.view.conversation.p222d.p228b.C2190a;

/* renamed from: mobi.mmdt.ott.view.conversation.c.b.a */
public abstract class C2132a extends C2025a {
    private TextView f6974a;
    private TextView f6975b;

    public C2132a(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(c1790i, layoutInflater, viewGroup, i);
        this.f6974a = (TextView) this.itemView.findViewById(2131689715);
        this.f6975b = (TextView) this.itemView.findViewById(2131689716);
    }

    protected void m9788a(C2190a c2190a) {
        super.m9658a(c2190a);
        this.f6974a.setText(c2190a.m10029i());
        this.f6975b.setText(c2190a.m10030j());
    }
}
