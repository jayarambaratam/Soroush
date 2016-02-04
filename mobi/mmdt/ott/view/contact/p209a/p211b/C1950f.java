package mobi.mmdt.ott.view.contact.p209a.p211b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.contact.p209a.p212c.C1955d;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.view.contact.a.b.f */
public class C1950f extends C1712b {
    private Activity f6259a;
    private RoundAvatarImageView f6260b;
    private TextView f6261c;
    private TextView f6262d;
    private FrameLayout f6263e;
    private View f6264f;

    public C1950f(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968769, c1790i);
        this.f6259a = activity;
        this.f6264f = this.itemView.findViewById(2131689710);
        this.f6260b = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f6261c = (TextView) this.itemView.findViewById(2131689707);
        this.f6262d = (TextView) this.itemView.findViewById(2131689708);
        this.f6263e = (FrameLayout) this.itemView.findViewById(2131689635);
    }

    protected void m9255a(C1722f c1722f) {
        C1955d c1955d = (C1955d) c1722f;
        this.f6261c.setText(c1955d.m9274d());
        TextView textView = this.f6262d;
        CharSequence string = (c1955d.m9273c() == null || c1955d.m9273c().isEmpty()) ? this.f6259a.getString(2131230860) : c1955d.m9273c();
        textView.setText(string);
        this.f6260b.setImageBitmap(null);
        if (c1955d.m9271a() != null) {
            C0872i.m5265a(this.f6259a).m5329a(aj.m8474a(c1955d.m9271a())).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f6260b);
        } else if (c1955d.m9272b() != null) {
            C0872i.m5265a(this.f6259a).m5327a(c1955d.m9272b()).m4406a(0.25f).m4417a(this.f6260b);
        } else {
            C0872i.m5267a(this.f6260b);
        }
        this.f6260b.setName(c1955d.m9274d());
        this.f6260b.setBackgroundColor(c1955d.m9275e());
    }
}
