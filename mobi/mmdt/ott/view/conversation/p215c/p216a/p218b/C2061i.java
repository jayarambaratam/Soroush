package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2167d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.i */
public class C2061i extends C2053a {
    private ImageView f6774c;
    private ImageView f6775d;
    private ImageButton f6776e;
    private ProgressWheel f6777f;
    private C1985e f6778g;
    private C1984d f6779h;

    public C2061i(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968653);
        this.f6778g = c1985e;
        this.f6779h = c1984d;
        this.f6774c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6775d = (ImageView) this.itemView.findViewById(2131689733);
        this.f6776e = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6777f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6774c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6775d.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6776e.setOnClickListener(new C2062j(this));
        this.f6774c.setOnClickListener(new C2063k(this));
    }

    protected void m9713a(C1722f c1722f) {
        C2167d c2167d = (C2167d) c1722f;
        super.m9659a(c2167d);
        this.f6774c.setImageBitmap(null);
        if (c2167d.m9916s() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2167d.m9914q())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6774c);
        } else if (c2167d.m9915r() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2167d.m9912o())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6774c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838530)).m4406a(0.25f).m4417a(this.f6774c);
        }
        switch (C2064l.f6783b[c2167d.m9849m().ordinal()]) {
        }
        switch (C2064l.f6782a[c2167d.m9915r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6777f.setVisibility(8);
                this.f6776e.setVisibility(0);
                this.f6776e.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6777f.setVisibility(0);
                this.f6776e.setVisibility(0);
                this.f6776e.setImageResource(2130838520);
                if (c2167d.m9913p() > 0) {
                    if (this.f6777f.m6352a()) {
                        this.f6777f.m6353b();
                    }
                    this.f6777f.setProgress(((float) c2167d.m9913p()) * 0.01f);
                } else if (!this.f6777f.m6352a()) {
                    this.f6777f.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6777f.setVisibility(8);
                this.f6776e.setVisibility(0);
                this.f6776e.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6777f.setVisibility(8);
                this.f6776e.setVisibility(0);
                this.f6776e.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6777f.setVisibility(8);
                this.f6776e.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6777f.setVisibility(8);
                this.f6776e.setVisibility(8);
            default:
        }
    }
}
