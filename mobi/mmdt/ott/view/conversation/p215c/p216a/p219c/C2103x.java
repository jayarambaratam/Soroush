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
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2180h;
import mobi.mmdt.ott.view.p178a.an;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.x */
public class C2103x extends C2080a {
    private ImageView f6886c;
    private TextView f6887d;
    private TextView f6888e;
    private ImageView f6889f;
    private ImageView f6890g;
    private ImageButton f6891h;
    private ProgressWheel f6892i;
    private C1985e f6893j;
    private C1984d f6894k;

    public C2103x(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968674);
        this.f6893j = c1985e;
        this.f6894k = c1984d;
        this.f6886c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6887d = (TextView) this.itemView.findViewById(2131689731);
        this.f6888e = (TextView) this.itemView.findViewById(2131689748);
        this.f6889f = (ImageView) this.itemView.findViewById(2131689726);
        this.f6890g = (ImageView) this.itemView.findViewById(2131689733);
        this.f6891h = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6892i = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6886c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6890g.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6891h.setOnClickListener(new C2104y(this));
        this.f6886c.setOnClickListener(new C2105z(this));
    }

    protected void m9757a(C1722f c1722f) {
        C2180h c2180h = (C2180h) c1722f;
        super.m9659a(c2180h);
        this.f6886c.setImageBitmap(null);
        Uri parse = Uri.parse(c2180h.m9974q());
        if (c2180h.m9976s() == C1604i.DELETED) {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4409a(C0652e.SOURCE).m4416a(new an(this.a)).m4417a(this.f6886c);
        } else {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6886c);
        }
        this.f6888e.setText(C1111c.m6393a(c2180h.m9975r() / 1000));
        if (c2180h.m9977t() == null || c2180h.m9977t().isEmpty()) {
            this.f6887d.setVisibility(8);
        } else {
            this.f6887d.setText(c2180h.m9977t());
            this.f6887d.setVisibility(0);
        }
        switch (aa.f6817b[c2180h.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6889f.setImageResource(2130838557);
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6889f.setImageResource(2130838559);
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f6889f.setImageResource(2130838560);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6889f.setImageResource(2130838560);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6889f.setImageResource(2130838561);
                break;
        }
        switch (aa.f6816a[c2180h.m9976s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6892i.setVisibility(8);
                this.f6891h.setVisibility(0);
                this.f6891h.setImageResource(2130838519);
            case VideoSize.HVGA /*2*/:
                this.f6892i.setVisibility(0);
                this.f6891h.setVisibility(0);
                this.f6891h.setImageResource(2130838520);
                if (c2180h.m9973p() > 0) {
                    if (this.f6892i.m6352a()) {
                        this.f6892i.m6353b();
                    }
                    this.f6892i.setProgress(((float) c2180h.m9973p()) * 0.01f);
                } else if (!this.f6892i.m6352a()) {
                    this.f6892i.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6892i.setVisibility(8);
                this.f6891h.setVisibility(0);
                this.f6891h.setImageResource(2130838519);
            case Version.API04_DONUT_16 /*4*/:
                this.f6892i.setVisibility(8);
                this.f6891h.setVisibility(0);
                this.f6891h.setImageResource(2130838519);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6892i.setVisibility(8);
                this.f6891h.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6892i.setVisibility(8);
                this.f6891h.setVisibility(8);
            default:
        }
    }
}
