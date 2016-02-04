package mobi.mmdt.ott.view.components.fileselector.p198a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1809c;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.a.c */
public class C1805c extends C1712b {
    private Activity f5808a;
    private RoundAvatarImageView f5809b;
    private TextView f5810c;
    private TextView f5811d;
    private View f5812e;

    public C1805c(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968705, c1790i);
        this.f5808a = activity;
        this.f5812e = this.itemView.findViewById(2131689710);
        this.f5809b = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f5810c = (TextView) this.itemView.findViewById(2131689707);
        this.f5811d = (TextView) this.itemView.findViewById(2131689708);
    }

    protected void m8785a(C1722f c1722f) {
        C1809c c1809c = (C1809c) c1722f;
        this.f5810c.setText(c1809c.m8796a());
        this.f5811d.setText(c1809c.m8798b());
        this.f5809b.setBackgroundColor(this.f5808a.getResources().getColor(2131624020));
        this.f5809b.setTextColor(-1);
        this.f5809b.setImageBitmap(null);
        C0872i.m5265a(this.f5808a).m5328a(Integer.valueOf(2130838512)).m4417a(this.f5809b);
        if (c1809c.m8660h() == 0) {
            this.f5812e.setVisibility(4);
        } else {
            this.f5812e.setVisibility(0);
        }
    }
}
