package mobi.mmdt.ott.view.components.fileselector.p198a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.fileselector.C1810h;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1808b;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.a.a */
public class C1803a extends C1712b {
    private Activity f5799a;
    private C1810h f5800b;
    private RoundAvatarImageView f5801c;
    private TextView f5802d;
    private TextView f5803e;
    private CheckBox f5804f;
    private View f5805g;
    private boolean f5806h;

    public C1803a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1810h c1810h) {
        super(layoutInflater, viewGroup, 2130968704, c1790i);
        this.f5806h = false;
        this.f5799a = activity;
        this.f5800b = c1810h;
        this.f5805g = this.itemView.findViewById(2131689710);
        this.f5801c = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f5802d = (TextView) this.itemView.findViewById(2131689707);
        this.f5803e = (TextView) this.itemView.findViewById(2131689708);
        this.f5804f = (CheckBox) this.itemView.findViewById(2131689776);
        this.f5804f.setOnCheckedChangeListener(new C1804b(this));
    }

    protected void m8784a(C1722f c1722f) {
        C1808b c1808b = (C1808b) c1722f;
        this.f5802d.setText(c1808b.m8789a());
        this.f5803e.setText(c1808b.m8792b());
        this.f5801c.setBackgroundColor(this.f5799a.getResources().getColor(2131624019));
        this.f5801c.setTextColor(-1);
        this.f5801c.setImageBitmap(null);
        if (c1808b.m8795e() == 2130838513) {
            C0872i.m5265a(this.f5799a).m5329a(c1808b.m8793c()).m4407a(c1808b.m8795e()).m4417a(this.f5801c);
        } else if (c1808b.m8795e() == 2130838514) {
            C0872i.m5265a(this.f5799a).m5329a(c1808b.m8793c()).m4407a(c1808b.m8795e()).m4417a(this.f5801c);
        } else {
            C0872i.m5265a(this.f5799a).m5328a(Integer.valueOf(c1808b.m8795e())).m4417a(this.f5801c);
        }
        this.f5806h = true;
        this.f5804f.setChecked(c1808b.m8794d());
        this.f5806h = false;
        if (this.f5800b == null || !this.f5800b.m8802b()) {
            this.f5804f.setVisibility(8);
        } else {
            this.f5804f.setVisibility(0);
        }
        if (c1808b.m8660h() == 0) {
            this.f5805g.setVisibility(4);
        } else {
            this.f5805g.setVisibility(0);
        }
    }
}
