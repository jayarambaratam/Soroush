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
import mobi.mmdt.ott.view.main.p237c.p244b.C2349b;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.main.c.a.a */
public class C2343a extends C1712b {
    public TextView f7734a;
    public TextView f7735b;
    public TextView f7736c;
    public TextView f7737d;
    private Activity f7738e;
    private RoundAvatarImageView f7739f;
    private ImageView f7740g;
    private View f7741h;

    public C2343a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968770, c1790i);
        this.f7738e = activity;
        this.f7741h = this.itemView.findViewById(2131689710);
        this.f7740g = (ImageView) this.itemView.findViewById(2131689726);
        this.f7739f = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f7734a = (TextView) this.itemView.findViewById(2131689707);
        this.f7735b = (TextView) this.itemView.findViewById(2131689708);
        this.f7737d = (TextView) this.itemView.findViewById(2131689709);
        this.f7736c = (TextView) this.itemView.findViewById(2131689909);
    }

    protected void m10505a(C1722f c1722f) {
        C2349b c2349b = (C2349b) c1722f;
        this.f7734a.setText(c2349b.m10529c());
        this.f7735b.setText(c2349b.m10531e());
        this.f7737d.setText(c2349b.m10530d());
        if (c2349b.m10532f() != 0) {
            this.f7736c.setVisibility(0);
            if (c2349b.m10532f() < 100) {
                this.f7736c.setText(c2349b.m10532f() + BuildConfig.FLAVOR);
            } else {
                this.f7736c.setText(this.f7738e.getString(2131230960));
            }
        } else {
            this.f7736c.setVisibility(8);
        }
        this.f7739f.setImageBitmap(null);
        if (c2349b.m10534j() != null && !c2349b.m10534j().isEmpty()) {
            C0872i.m5265a(this.f7738e).m5329a(aj.m8474a(c2349b.m10534j())).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f7739f);
        } else if (c2349b.m10535k() != null) {
            C0872i.m5265a(this.f7738e).m5329a(c2349b.m10535k()).m4406a(0.25f).m4417a(this.f7739f);
        } else {
            C0872i.m5267a(this.f7739f);
        }
        this.f7739f.setName(c2349b.m10529c());
        this.f7739f.setBackgroundColor(c2349b.m10533i());
        switch (C2344b.f7743b[c2349b.m10536l().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f7740g.setVisibility(8);
                break;
            case VideoSize.HVGA /*2*/:
                this.f7740g.setVisibility(0);
                switch (C2344b.f7742a[c2349b.m10537m().ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        this.f7740g.setImageResource(2130838557);
                        break;
                    case VideoSize.HVGA /*2*/:
                    case Version.API03_CUPCAKE_15 /*3*/:
                        this.f7740g.setImageResource(2130838559);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        this.f7740g.setImageResource(2130838560);
                        break;
                    case Version.API05_ECLAIR_20 /*5*/:
                        this.f7740g.setImageResource(2130838560);
                        break;
                    case Version.API06_ECLAIR_201 /*6*/:
                        this.f7740g.setImageResource(2130838561);
                        break;
                    case Version.API07_ECLAIR_21 /*7*/:
                        this.f7740g.setImageResource(2130838560);
                        break;
                    case Version.API08_FROYO_22 /*8*/:
                        this.f7740g.setImageResource(2130838561);
                        break;
                    case Version.API09_GINGERBREAD_23 /*9*/:
                        this.f7740g.setImageResource(2130838554);
                        break;
                    default:
                        break;
                }
        }
        if (c2349b.m8660h() == 0) {
            this.f7741h.setVisibility(4);
        } else {
            this.f7741h.setVisibility(0);
        }
    }
}
