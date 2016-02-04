package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

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
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2157d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.m */
public class C2039m extends C2027a {
    private ImageView f6705d;
    private ImageView f6706e;
    private ImageButton f6707f;
    private ProgressWheel f6708g;
    private C1985e f6709h;
    private C1984d f6710i;

    public C2039m(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1981a c1981a, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968652, c1981a);
        this.f6709h = c1985e;
        this.f6710i = c1984d;
        this.f6705d = (ImageView) this.itemView.findViewById(2131689732);
        this.f6706e = (ImageView) this.itemView.findViewById(2131689733);
        this.f6707f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6708g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6705d.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6706e.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6707f.setOnClickListener(new C2040n(this));
        this.f6705d.setOnClickListener(new C2041o(this));
    }

    protected void m9693a(C1722f c1722f) {
        C2154a c2154a = (C2157d) c1722f;
        super.m9664a(c2154a);
        this.f6705d.setImageBitmap(null);
        if (c2154a.m9870u() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9868s())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6705d);
        } else if (c2154a.m9869t() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9866q())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6705d);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838530)).m4406a(0.25f).m4417a(this.f6705d);
        }
        switch (C2042p.f6714b[c2154a.m9849m().ordinal()]) {
        }
        switch (C2042p.f6713a[c2154a.m9869t().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6708g.setVisibility(8);
                this.f6707f.setVisibility(0);
                this.f6707f.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6708g.setVisibility(0);
                this.f6707f.setVisibility(0);
                this.f6707f.setImageResource(2130838520);
                if (c2154a.m9867r() > 0) {
                    if (this.f6708g.m6352a()) {
                        this.f6708g.m6353b();
                    }
                    this.f6708g.setProgress(((float) c2154a.m9867r()) * 0.01f);
                } else if (!this.f6708g.m6352a()) {
                    this.f6708g.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6708g.setVisibility(8);
                this.f6707f.setVisibility(0);
                this.f6707f.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6708g.setVisibility(8);
                this.f6707f.setVisibility(0);
                this.f6707f.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6708g.setVisibility(8);
                this.f6707f.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6708g.setVisibility(8);
                this.f6707f.setVisibility(8);
            default:
        }
    }
}
