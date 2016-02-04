package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2178f;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.q */
public class C2096q extends C2080a {
    private ImageView f6873c;
    private ImageView f6874d;
    private ProgressWheel f6875e;
    private int f6876f;
    private C0866h<String, C0742b> f6877g;

    public C2096q(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968665);
        this.f6877g = new C2097r(this);
        this.f6873c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6874d = (ImageView) this.itemView.findViewById(2131689726);
        this.f6875e = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6876f = i;
    }

    protected void m9747a(C1722f c1722f) {
        C2178f c2178f = (C2178f) c1722f;
        super.m9659a(c2178f);
        int r = c2178f.m9969r() != 0 ? this.f6876f * c2178f.m9969r() : this.f6876f;
        int q = c2178f.m9968q() != 0 ? this.f6876f * c2178f.m9968q() : this.f6876f;
        LayoutParams layoutParams = this.f6873c.getLayoutParams();
        layoutParams.height = r;
        layoutParams.width = q;
        this.f6873c.setImageBitmap(null);
        C0872i.m5265a(this.a).m5329a(c2178f.m9966o()).m4413a(this.f6877g).m4408a(q, r).m4406a(0.25f).m4417a(this.f6873c);
        switch (C2098s.f6879a[c2178f.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6874d.setImageResource(2130838558);
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6874d.setImageResource(2130838563);
            case Version.API04_DONUT_16 /*4*/:
                this.f6874d.setImageResource(2130838562);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6874d.setImageResource(2130838562);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6874d.setImageResource(2130838561);
            default:
        }
    }
}
