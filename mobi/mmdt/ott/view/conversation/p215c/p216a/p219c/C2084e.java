package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2175c;
import mobi.mmdt.ott.view.p178a.an;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.e */
public class C2084e extends C2080a {
    private ImageView f6840c;
    private TextView f6841d;
    private ImageView f6842e;
    private ImageButton f6843f;
    private ProgressWheel f6844g;
    private C1985e f6845h;
    private C1984d f6846i;

    public C2084e(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968650);
        this.f6845h = c1985e;
        this.f6846i = c1984d;
        this.f6840c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6841d = (TextView) this.itemView.findViewById(2131689731);
        this.f6842e = (ImageView) this.itemView.findViewById(2131689726);
        this.f6843f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6844g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6840c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6843f.setOnClickListener(new C2085f(this));
        this.f6840c.setOnClickListener(new C2086g(this));
    }

    protected void m9738a(C1722f c1722f) {
        C2175c c2175c = (C2175c) c1722f;
        super.m9659a(c2175c);
        this.f6840c.setImageBitmap(null);
        Uri parse = Uri.parse(c2175c.m9952q());
        if (c2175c.m9953r() == C1604i.DELETED) {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4409a(C0652e.SOURCE).m4416a(new an(this.a)).m4417a(this.f6840c);
        } else {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6840c);
        }
        if (c2175c.m9954s() == null || c2175c.m9954s().isEmpty()) {
            this.f6841d.setVisibility(8);
        } else {
            this.f6841d.setText(c2175c.m9954s());
            this.f6841d.setVisibility(0);
        }
        switch (C2087h.f6850b[c2175c.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6842e.setImageResource(2130838557);
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6842e.setImageResource(2130838559);
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f6842e.setImageResource(2130838560);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6842e.setImageResource(2130838560);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6842e.setImageResource(2130838561);
                break;
        }
        switch (C2087h.f6849a[c2175c.m9953r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6844g.setVisibility(8);
                this.f6843f.setVisibility(0);
                this.f6843f.setImageResource(2130838519);
            case VideoSize.HVGA /*2*/:
                this.f6844g.setVisibility(0);
                this.f6843f.setVisibility(0);
                this.f6843f.setImageResource(2130838520);
                if (c2175c.m9951p() > 0) {
                    if (this.f6844g.m6352a()) {
                        this.f6844g.m6353b();
                    }
                    this.f6844g.setProgress(((float) c2175c.m9951p()) * 0.01f);
                } else if (!this.f6844g.m6352a()) {
                    this.f6844g.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6844g.setVisibility(8);
                this.f6843f.setVisibility(0);
                this.f6843f.setImageResource(2130838519);
            case Version.API04_DONUT_16 /*4*/:
                this.f6844g.setVisibility(8);
                this.f6843f.setVisibility(0);
                this.f6843f.setImageResource(2130838519);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6844g.setVisibility(8);
                this.f6843f.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6844g.setVisibility(8);
                this.f6843f.setVisibility(8);
            default:
        }
    }
}
