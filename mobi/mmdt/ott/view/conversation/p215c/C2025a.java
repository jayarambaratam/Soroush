package mobi.mmdt.ott.view.conversation.p215c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p222d.C2151a;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a */
public abstract class C2025a extends C1712b {
    private RelativeLayout f6599a;
    private TextView f6600b;
    private View f6601c;
    private View f6602d;

    public C2025a(C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(layoutInflater, viewGroup, i, c1790i);
        this.f6600b = (TextView) this.itemView.findViewById(2131689717);
        this.f6601c = this.itemView.findViewById(2131689712);
        this.f6602d = this.itemView.findViewById(2131689713);
        this.f6599a = (RelativeLayout) this.itemView.findViewById(2131689737);
    }

    protected void m9658a(C2151a c2151a) {
        if (c2151a.m9841c()) {
            this.f6601c.setVisibility(0);
            this.f6600b.setText(c2151a.m9840b());
        } else {
            this.f6601c.setVisibility(8);
        }
        if (c2151a.m9842d()) {
            this.f6602d.setVisibility(0);
        } else {
            this.f6602d.setVisibility(8);
        }
        if (c2151a.m9843e()) {
            this.f6599a.setVisibility(0);
        } else {
            this.f6599a.setVisibility(8);
        }
    }
}
