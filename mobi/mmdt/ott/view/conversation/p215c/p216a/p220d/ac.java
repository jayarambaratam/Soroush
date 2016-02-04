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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2189i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.ac */
public class ac extends C2106a {
    private ImageView f6903c;
    private TextView f6904d;
    private ImageView f6905e;
    private ImageButton f6906f;
    private ProgressWheel f6907g;
    private C1985e f6908h;
    private C1984d f6909i;

    public ac(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1987g c1987g, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968679, c1987g);
        this.f6908h = c1985e;
        this.f6909i = c1984d;
        this.f6903c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6904d = (TextView) this.itemView.findViewById(2131689748);
        this.f6905e = (ImageView) this.itemView.findViewById(2131689733);
        this.f6906f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6907g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6903c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6905e.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6906f.setOnClickListener(new ad(this));
        this.f6903c.setOnClickListener(new ae(this));
    }

    protected void m9762a(C1722f c1722f) {
        C2153a c2153a = (C2189i) c1722f;
        super.m9759a(c2153a);
        this.f6903c.setImageBitmap(null);
        if (c2153a.m10028t() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m10025q())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6903c);
        } else if (c2153a.m10027s() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m10023o())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6903c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838589)).m4406a(0.25f).m4417a(this.f6903c);
        }
        this.f6904d.setText(C1111c.m6393a(c2153a.m10026r() / 1000));
        switch (af.f6913b[c2153a.m9849m().ordinal()]) {
        }
        switch (af.f6912a[c2153a.m10027s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6907g.setVisibility(8);
                this.f6906f.setVisibility(0);
                this.f6906f.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6907g.setVisibility(0);
                this.f6906f.setVisibility(0);
                this.f6906f.setImageResource(2130838520);
                if (c2153a.m10024p() > 0) {
                    if (this.f6907g.m6352a()) {
                        this.f6907g.m6353b();
                    }
                    this.f6907g.setProgress(((float) c2153a.m10024p()) * 0.01f);
                } else if (!this.f6907g.m6352a()) {
                    this.f6907g.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6907g.setVisibility(8);
                this.f6906f.setVisibility(0);
                this.f6906f.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6907g.setVisibility(8);
                this.f6906f.setVisibility(0);
                this.f6906f.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6907g.setVisibility(8);
                this.f6906f.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6907g.setVisibility(8);
                this.f6906f.setVisibility(8);
            default:
        }
    }
}
