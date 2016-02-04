package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2171h;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.x */
public class C2076x extends C2053a {
    private ImageView f6805c;
    private TextView f6806d;
    private TextView f6807e;
    private ImageView f6808f;
    private ImageButton f6809g;
    private ProgressWheel f6810h;
    private C1985e f6811i;
    private C1984d f6812j;

    public C2076x(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968673);
        this.f6811i = c1985e;
        this.f6812j = c1984d;
        this.f6805c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6806d = (TextView) this.itemView.findViewById(2131689731);
        this.f6807e = (TextView) this.itemView.findViewById(2131689748);
        this.f6808f = (ImageView) this.itemView.findViewById(2131689733);
        this.f6809g = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6810h = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6805c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6808f.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6809g.setOnClickListener(new C2077y(this));
        this.f6805c.setOnClickListener(new C2078z(this));
    }

    protected void m9729a(C1722f c1722f) {
        C2171h c2171h = (C2171h) c1722f;
        super.m9659a(c2171h);
        this.f6805c.setImageBitmap(null);
        if (c2171h.m9938u() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2171h.m9934q())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6805c);
        } else if (c2171h.m9936s() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2171h.m9932o())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6805c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838589)).m4406a(0.25f).m4417a(this.f6805c);
        }
        this.f6807e.setText(C1111c.m6393a(c2171h.m9935r() / 1000));
        if (c2171h.m9937t() == null || c2171h.m9937t().isEmpty()) {
            this.f6806d.setVisibility(8);
        } else {
            this.f6806d.setText(c2171h.m9937t());
            this.f6806d.setVisibility(0);
        }
        switch (aa.f6743b[c2171h.m9849m().ordinal()]) {
        }
        switch (aa.f6742a[c2171h.m9936s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6810h.setVisibility(8);
                this.f6809g.setVisibility(0);
                this.f6809g.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6810h.setVisibility(0);
                this.f6809g.setVisibility(0);
                this.f6809g.setImageResource(2130838520);
                if (c2171h.m9933p() > 0) {
                    if (this.f6810h.m6352a()) {
                        this.f6810h.m6353b();
                    }
                    this.f6810h.setProgress(((float) c2171h.m9933p()) * 0.01f);
                } else if (!this.f6810h.m6352a()) {
                    this.f6810h.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6810h.setVisibility(8);
                this.f6809g.setVisibility(0);
                this.f6809g.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6810h.setVisibility(8);
                this.f6809g.setVisibility(0);
                this.f6809g.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6810h.setVisibility(8);
                this.f6809g.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6810h.setVisibility(8);
                this.f6809g.setVisibility(8);
            default:
        }
    }
}
