package mobi.mmdt.ott.view.main.p238d.p245a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.main.p238d.p246b.C2371b;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.main.d.a.a */
public class C2367a extends C1712b {
    public TextView f7804a;
    public TextView f7805b;
    public TextView f7806c;
    public TextView f7807d;
    private Activity f7808e;
    private RoundAvatarImageView f7809f;
    private ImageView f7810g;
    private View f7811h;

    public C2367a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968774, c1790i);
        this.f7808e = activity;
        this.f7811h = this.itemView.findViewById(2131689710);
        this.f7810g = (ImageView) this.itemView.findViewById(2131689726);
        this.f7809f = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f7804a = (TextView) this.itemView.findViewById(2131689707);
        this.f7805b = (TextView) this.itemView.findViewById(2131689708);
        this.f7807d = (TextView) this.itemView.findViewById(2131689709);
        this.f7806c = (TextView) this.itemView.findViewById(2131689909);
    }

    protected void m10549a(C1722f c1722f) {
        C2371b c2371b = (C2371b) c1722f;
        this.f7804a.setText(c2371b.m10569c());
        this.f7805b.setText(c2371b.m10571e());
        this.f7807d.setText(c2371b.m10570d());
        if (c2371b.m10572f() != 0) {
            this.f7806c.setVisibility(0);
            if (c2371b.m10572f() < 100) {
                this.f7806c.setText(c2371b.m10572f() + BuildConfig.FLAVOR);
            } else {
                this.f7806c.setText(this.f7808e.getString(2131230960));
            }
            if (c2371b.m10577m()) {
                this.f7806c.setBackgroundResource(2130838625);
            } else {
                this.f7806c.setBackgroundResource(2130838624);
            }
        } else {
            this.f7806c.setVisibility(8);
        }
        this.f7809f.setImageBitmap(null);
        this.f7809f.setName(c2371b.m10569c());
        this.f7809f.setBackgroundColor(c2371b.m10573i());
        if (c2371b.m10574j() == null || c2371b.m10574j().isEmpty()) {
            C0872i.m5265a(this.f7808e).m5328a(Integer.valueOf(2130838594)).m4406a(0.25f).m4417a(this.f7809f);
        } else {
            C0872i.m5265a(this.f7808e).m5329a(aj.m8474a(c2371b.m10574j())).m4407a(2130838598).m4406a(0.25f).m4417a(this.f7809f);
        }
        switch (C2368b.f7813b[c2371b.m10575k().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f7810g.setVisibility(8);
                break;
            case VideoSize.HVGA /*2*/:
                this.f7810g.setVisibility(0);
                switch (C2368b.f7812a[c2371b.m10576l().ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        this.f7810g.setImageResource(2130838557);
                        break;
                    case VideoSize.HVGA /*2*/:
                    case Version.API03_CUPCAKE_15 /*3*/:
                        this.f7810g.setImageResource(2130838559);
                        break;
                    case Version.API04_DONUT_16 /*4*/:
                        this.f7810g.setImageResource(2130838560);
                        break;
                    case Version.API05_ECLAIR_20 /*5*/:
                        this.f7810g.setImageResource(2130838560);
                        break;
                    case Version.API06_ECLAIR_201 /*6*/:
                        this.f7810g.setImageResource(2130838561);
                        break;
                    case Version.API07_ECLAIR_21 /*7*/:
                    case Version.API08_FROYO_22 /*8*/:
                        break;
                    default:
                        break;
                }
        }
        if (c2371b.m8660h() == 0) {
            this.f7811h.setVisibility(4);
        } else {
            this.f7811h.setVisibility(0);
        }
    }
}
