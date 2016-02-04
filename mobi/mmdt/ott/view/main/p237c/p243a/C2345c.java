package mobi.mmdt.ott.view.main.p237c.p243a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.p237c.p244b.C2350c;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.main.c.a.c */
public class C2345c extends C1712b {
    public TextView f7744a;
    public TextView f7745b;
    public TextView f7746c;
    public TextView f7747d;
    private Activity f7748e;
    private RoundAvatarImageView f7749f;
    private ImageView f7750g;
    private View f7751h;

    public C2345c(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968773, c1790i);
        this.f7748e = activity;
        this.f7751h = this.itemView.findViewById(2131689710);
        this.f7750g = (ImageView) this.itemView.findViewById(2131689726);
        this.f7749f = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f7744a = (TextView) this.itemView.findViewById(2131689707);
        this.f7745b = (TextView) this.itemView.findViewById(2131689708);
        this.f7747d = (TextView) this.itemView.findViewById(2131689709);
        this.f7746c = (TextView) this.itemView.findViewById(2131689909);
    }

    protected void m10506a(C1722f c1722f) {
        C2350c c2350c = (C2350c) c1722f;
        this.f7744a.setText(c2350c.m10538c());
        this.f7745b.setText(c2350c.m10540e());
        this.f7747d.setText(c2350c.m10539d());
        if (c2350c.m10541f() != 0) {
            this.f7746c.setVisibility(0);
            if (c2350c.m10541f() < 100) {
                this.f7746c.setText(c2350c.m10541f() + BuildConfig.FLAVOR);
            } else {
                this.f7746c.setText(this.f7748e.getString(2131230960));
            }
            if (c2350c.m10546m()) {
                this.f7746c.setBackgroundResource(2130838625);
            } else {
                this.f7746c.setBackgroundResource(2130838624);
            }
        } else {
            this.f7746c.setVisibility(8);
        }
        this.f7749f.setImageBitmap(null);
        this.f7749f.setName(c2350c.m10538c());
        this.f7749f.setBackgroundColor(c2350c.m10542i());
        if (c2350c.m10543j() == null || c2350c.m10543j().isEmpty()) {
            C0872i.m5265a(this.f7748e).m5328a(Integer.valueOf(2130838598)).m4406a(0.25f).m4417a(this.f7749f);
        } else {
            C0872i.m5265a(this.f7748e).m5329a(aj.m8474a(c2350c.m10543j())).m4407a(2130838598).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f7749f);
        }
        switch (C2346d.f7753b[c2350c.m10544k().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f7750g.setVisibility(8);
                break;
            case VideoSize.HVGA /*2*/:
                this.f7750g.setVisibility(0);
                switch (C2346d.f7752a[c2350c.m10545l().ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        this.f7750g.setImageResource(2130838557);
                        break;
                    case VideoSize.HVGA /*2*/:
                    case Version.API03_CUPCAKE_15 /*3*/:
                        this.f7750g.setImageResource(2130838559);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        this.f7750g.setImageResource(2130838560);
                        break;
                    case Version.API05_ECLAIR_20 /*5*/:
                        this.f7750g.setImageResource(2130838560);
                        break;
                    case Version.API06_ECLAIR_201 /*6*/:
                        this.f7750g.setImageResource(2130838561);
                        break;
                    case Version.API07_ECLAIR_21 /*7*/:
                    case Version.API08_FROYO_22 /*8*/:
                        break;
                    case Version.API09_GINGERBREAD_23 /*9*/:
                        this.f7750g.setImageResource(2130838554);
                        break;
                    default:
                        break;
                }
        }
        if (c2350c.m8660h() == 0) {
            this.f7751h.setVisibility(4);
        } else {
            this.f7751h.setVisibility(0);
        }
    }
}
