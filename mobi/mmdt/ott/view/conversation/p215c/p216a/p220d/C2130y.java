package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2188h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.y */
public class C2130y extends C2106a {
    private ImageView f6965c;
    private TextView f6966d;
    private TextView f6967e;
    private ImageView f6968f;
    private ImageButton f6969g;
    private ProgressWheel f6970h;
    private C1985e f6971i;
    private C1984d f6972j;

    public C2130y(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1987g c1987g, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968675, c1987g);
        this.f6971i = c1985e;
        this.f6972j = c1984d;
        this.f6965c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6966d = (TextView) this.itemView.findViewById(2131689731);
        this.f6967e = (TextView) this.itemView.findViewById(2131689748);
        this.f6968f = (ImageView) this.itemView.findViewById(2131689733);
        this.f6969g = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6970h = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6965c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6968f.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6969g.setOnClickListener(new C2131z(this));
        this.f6965c.setOnClickListener(new aa(this));
    }

    protected void m9787a(C1722f c1722f) {
        C2153a c2153a = (C2188h) c1722f;
        super.m9759a(c2153a);
        this.f6965c.setImageBitmap(null);
        if (c2153a.m10022u() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m10018q())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6965c);
        } else if (c2153a.m10020s() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m10016o())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6965c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838589)).m4406a(0.25f).m4417a(this.f6965c);
        }
        this.f6967e.setText(C1111c.m6393a(c2153a.m10019r() / 1000));
        if (c2153a.m10021t() == null || c2153a.m10021t().isEmpty()) {
            this.f6966d.setVisibility(8);
        } else {
            this.f6966d.setText(c2153a.m10021t());
            this.f6966d.setVisibility(0);
        }
        switch (ab.f6902b[c2153a.m9849m().ordinal()]) {
        }
        switch (ab.f6901a[c2153a.m10020s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6970h.setVisibility(8);
                this.f6969g.setVisibility(0);
                this.f6969g.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6970h.setVisibility(0);
                this.f6969g.setVisibility(0);
                this.f6969g.setImageResource(2130838520);
                if (c2153a.m10017p() > 0) {
                    if (this.f6970h.m6352a()) {
                        this.f6970h.m6353b();
                    }
                    this.f6970h.setProgress(((float) c2153a.m10017p()) * 0.01f);
                } else if (!this.f6970h.m6352a()) {
                    this.f6970h.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6970h.setVisibility(8);
                this.f6969g.setVisibility(0);
                this.f6969g.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6970h.setVisibility(8);
                this.f6969g.setVisibility(0);
                this.f6969g.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6970h.setVisibility(8);
                this.f6969g.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6970h.setVisibility(8);
                this.f6969g.setVisibility(8);
            default:
        }
    }
}
