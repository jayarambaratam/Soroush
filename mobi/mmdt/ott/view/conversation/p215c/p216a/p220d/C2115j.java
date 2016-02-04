package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2184d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.j */
public class C2115j extends C2106a {
    private ImageView f6934c;
    private ImageView f6935d;
    private ImageButton f6936e;
    private ProgressWheel f6937f;
    private C1985e f6938g;
    private C1984d f6939h;

    public C2115j(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1987g c1987g, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968655, c1987g);
        this.f6938g = c1985e;
        this.f6939h = c1984d;
        this.f6934c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6935d = (ImageView) this.itemView.findViewById(2131689733);
        this.f6936e = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6937f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6934c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6935d.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6936e.setOnClickListener(new C2116k(this));
        this.f6934c.setOnClickListener(new C2117l(this));
    }

    protected void m9771a(C1722f c1722f) {
        C2153a c2153a = (C2184d) c1722f;
        super.m9759a(c2153a);
        this.f6934c.setImageBitmap(null);
        if (c2153a.m10000s() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m9998q())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6934c);
        } else if (c2153a.m9999r() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m9996o())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6934c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838530)).m4406a(0.25f).m4417a(this.f6934c);
        }
        switch (C2118m.f6943b[c2153a.m9849m().ordinal()]) {
        }
        switch (C2118m.f6942a[c2153a.m9999r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6937f.setVisibility(8);
                this.f6936e.setVisibility(0);
                this.f6936e.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6937f.setVisibility(0);
                this.f6936e.setVisibility(0);
                this.f6936e.setImageResource(2130838520);
                if (c2153a.m9997p() > 0) {
                    if (this.f6937f.m6352a()) {
                        this.f6937f.m6353b();
                    }
                    this.f6937f.setProgress(((float) c2153a.m9997p()) * 0.01f);
                } else if (!this.f6937f.m6352a()) {
                    this.f6937f.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6937f.setVisibility(8);
                this.f6936e.setVisibility(0);
                this.f6936e.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6937f.setVisibility(8);
                this.f6936e.setVisibility(0);
                this.f6936e.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6937f.setVisibility(8);
                this.f6936e.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6937f.setVisibility(8);
                this.f6936e.setVisibility(8);
            default:
        }
    }
}
