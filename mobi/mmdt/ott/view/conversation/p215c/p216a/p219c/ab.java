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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2181i;
import mobi.mmdt.ott.view.p178a.an;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.ab */
public class ab extends C2080a {
    private ImageView f6818c;
    private TextView f6819d;
    private ImageView f6820e;
    private ImageView f6821f;
    private ImageButton f6822g;
    private ProgressWheel f6823h;
    private C1985e f6824i;
    private C1984d f6825j;

    public ab(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968678);
        this.a = activity;
        this.f6824i = c1985e;
        this.f6825j = c1984d;
        this.f6818c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6819d = (TextView) this.itemView.findViewById(2131689748);
        this.f6820e = (ImageView) this.itemView.findViewById(2131689726);
        this.f6821f = (ImageView) this.itemView.findViewById(2131689733);
        this.f6822g = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6823h = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6818c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6821f.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6822g.setOnClickListener(new ac(this));
        this.f6818c.setOnClickListener(new ad(this));
    }

    protected void m9732a(C1722f c1722f) {
        C2181i c2181i = (C2181i) c1722f;
        super.m9659a(c2181i);
        this.f6818c.setImageBitmap(null);
        Uri parse = Uri.parse(c2181i.m9981q());
        if (c2181i.m9983s() == C1604i.DELETED) {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4409a(C0652e.SOURCE).m4416a(new an(this.a)).m4417a(this.f6818c);
        } else {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6818c);
        }
        this.f6819d.setText(C1111c.m6393a(c2181i.m9982r() / 1000));
        switch (ae.f6829b[c2181i.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6820e.setImageResource(2130838558);
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6820e.setImageResource(2130838563);
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f6820e.setImageResource(2130838562);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6820e.setImageResource(2130838562);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6820e.setImageResource(2130838561);
                break;
        }
        switch (ae.f6828a[c2181i.m9983s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6823h.setVisibility(8);
                this.f6822g.setVisibility(0);
                this.f6822g.setImageResource(2130838519);
            case VideoSize.HVGA /*2*/:
                this.f6823h.setVisibility(0);
                this.f6822g.setVisibility(0);
                this.f6822g.setImageResource(2130838520);
                if (c2181i.m9980p() > 0) {
                    if (this.f6823h.m6352a()) {
                        this.f6823h.m6353b();
                    }
                    this.f6823h.setProgress(((float) c2181i.m9980p()) * 0.01f);
                } else if (!this.f6823h.m6352a()) {
                    this.f6823h.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6823h.setVisibility(8);
                this.f6822g.setVisibility(0);
                this.f6822g.setImageResource(2130838519);
            case Version.API04_DONUT_16 /*4*/:
                this.f6823h.setVisibility(8);
                this.f6822g.setVisibility(0);
                this.f6822g.setImageResource(2130838519);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6823h.setVisibility(8);
                this.f6822g.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6823h.setVisibility(8);
                this.f6822g.setVisibility(8);
            default:
        }
    }
}
