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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2172i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.ab */
public class ab extends C2053a {
    private ImageView f6744c;
    private TextView f6745d;
    private ImageView f6746e;
    private ImageButton f6747f;
    private ProgressWheel f6748g;
    private C1985e f6749h;
    private C1984d f6750i;

    public ab(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968677);
        this.a = activity;
        this.f6749h = c1985e;
        this.f6750i = c1984d;
        this.f6744c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6745d = (TextView) this.itemView.findViewById(2131689748);
        this.f6746e = (ImageView) this.itemView.findViewById(2131689733);
        this.f6747f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6748g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6744c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6746e.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6747f.setOnClickListener(new ac(this));
        this.f6744c.setOnClickListener(new ad(this));
    }

    protected void m9704a(C1722f c1722f) {
        C2172i c2172i = (C2172i) c1722f;
        super.m9659a(c2172i);
        this.f6744c.setImageBitmap(null);
        if (c2172i.m9944t() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2172i.m9941q())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6744c);
        } else if (c2172i.m9943s() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2172i.m9939o())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6744c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838589)).m4406a(0.25f).m4417a(this.f6744c);
        }
        this.f6745d.setText(C1111c.m6393a(c2172i.m9942r() / 1000));
        switch (ae.f6754b[c2172i.m9849m().ordinal()]) {
        }
        switch (ae.f6753a[c2172i.m9943s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6748g.setVisibility(8);
                this.f6747f.setVisibility(0);
                this.f6747f.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6748g.setVisibility(0);
                this.f6747f.setVisibility(0);
                this.f6747f.setImageResource(2130838520);
                if (c2172i.m9940p() > 0) {
                    if (this.f6748g.m6352a()) {
                        this.f6748g.m6353b();
                    }
                    this.f6748g.setProgress(((float) c2172i.m9940p()) * 0.01f);
                } else if (!this.f6748g.m6352a()) {
                    this.f6748g.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6748g.setVisibility(8);
                this.f6747f.setVisibility(0);
                this.f6747f.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6748g.setVisibility(8);
                this.f6747f.setVisibility(0);
                this.f6747f.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6748g.setVisibility(8);
                this.f6747f.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6748g.setVisibility(8);
                this.f6747f.setVisibility(8);
            default:
        }
    }
}
