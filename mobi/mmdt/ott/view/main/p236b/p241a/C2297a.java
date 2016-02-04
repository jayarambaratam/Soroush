package mobi.mmdt.ott.view.main.p236b.p241a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.p236b.p242b.C2300b;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.view.main.b.a.a */
public class C2297a extends C1712b {
    private Activity f7588a;
    private RoundAvatarImageView f7589b;
    private TextView f7590c;
    private TextView f7591d;
    private View f7592e;

    public C2297a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968769, c1790i);
        this.f7588a = activity;
        this.f7592e = this.itemView.findViewById(2131689710);
        this.f7589b = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f7590c = (TextView) this.itemView.findViewById(2131689707);
        this.f7591d = (TextView) this.itemView.findViewById(2131689708);
    }

    protected void m10398a(C1722f c1722f) {
        C2300b c2300b = (C2300b) c1722f;
        this.f7590c.setText(c2300b.m10414d());
        TextView textView = this.f7591d;
        CharSequence string = (c2300b.m10413c() == null || c2300b.m10413c().isEmpty()) ? this.f7588a.getString(2131230860) : c2300b.m10413c();
        textView.setText(string);
        this.f7589b.setImageBitmap(null);
        if (c2300b.m10411a() != null && !c2300b.m10411a().isEmpty()) {
            C0872i.m5265a(this.f7588a).m5329a(aj.m8474a(c2300b.m10411a())).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f7589b);
        } else if (c2300b.m10412b() != null) {
            C0872i.m5265a(this.f7588a).m5329a(c2300b.m10412b()).m4406a(0.25f).m4417a(this.f7589b);
        } else {
            C0872i.m5267a(this.f7589b);
        }
        this.f7589b.setName(c2300b.m10414d());
        this.f7589b.setBackgroundColor(c2300b.m10415e());
        if (c2300b.m8660h() == 0) {
            this.f7592e.setVisibility(4);
        } else {
            this.f7592e.setVisibility(0);
        }
    }
}
