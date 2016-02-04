package mobi.mmdt.ott.view.conversation.groupinfo.p231a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.groupinfo.p232b.C2250a;
import mobi.mmdt.ott.view.p178a.ah;
import mobi.mmdt.ott.view.p178a.aj;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.a.a */
public class C2247a extends C1712b {
    private Activity f7416a;
    private RoundAvatarImageView f7417b;
    private TextView f7418c;
    private TextView f7419d;
    private FrameLayout f7420e;
    private TextView f7421f;
    private View f7422g;

    public C2247a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(layoutInflater, viewGroup, 2130968757, c1790i);
        this.f7416a = activity;
        this.f7422g = this.itemView.findViewById(2131689710);
        this.f7417b = (RoundAvatarImageView) this.itemView.findViewById(2131689706);
        this.f7418c = (TextView) this.itemView.findViewById(2131689707);
        this.f7419d = (TextView) this.itemView.findViewById(2131689708);
        this.f7420e = (FrameLayout) this.itemView.findViewById(2131689635);
        this.f7421f = (TextView) this.itemView.findViewById(2131689899);
    }

    protected void m10256a(C1722f c1722f) {
        C2250a c2250a = (C2250a) c1722f;
        Object b = ah.m8470b(c2250a.m10264b(), c2250a.m10266d());
        this.f7418c.setText(b);
        long f = c2250a.m10268f();
        if (f != -1) {
            CharSequence d = C1111c.m6411d(this.f7416a, f);
            if (d.equals(this.f7416a.getString(C1136d.online))) {
                this.f7419d.setTextColor(this.f7416a.getResources().getColor(2131624021));
            } else {
                this.f7419d.setTextColor(this.f7416a.getResources().getColor(2131624084));
            }
            this.f7419d.setText(d);
        } else {
            this.f7419d.setText(BuildConfig.FLAVOR);
        }
        switch (C2248b.f7423a[c2250a.m10267e().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f7421f.setVisibility(0);
                this.f7421f.setText("Group Owner");
                break;
            case VideoSize.HVGA /*2*/:
                this.f7421f.setVisibility(0);
                this.f7421f.setText("Group Admin");
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f7421f.setVisibility(8);
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f7421f.setVisibility(8);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f7421f.setVisibility(8);
                break;
        }
        this.f7417b.setImageBitmap(null);
        this.f7417b.setName(b);
        this.f7417b.setBackgroundColor(c2250a.m10265c());
        if (c2250a.m10263a() != null) {
            C0872i.m5265a(this.f7416a).m5329a(aj.m8474a(c2250a.m10263a())).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f7417b);
        } else {
            C0872i.m5267a(this.f7417b);
        }
        if (c2250a.m8660h() == 0) {
            this.f7422g.setVisibility(4);
        } else {
            this.f7422g.setVisibility(0);
        }
    }
}
