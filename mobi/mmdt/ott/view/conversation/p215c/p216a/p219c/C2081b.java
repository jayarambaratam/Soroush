package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2174b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.b */
public class C2081b extends C2080a {
    private TextView f6830c;
    private TextView f6831d;
    private ImageView f6832e;
    private ImageButton f6833f;
    private ProgressWheel f6834g;
    private C1985e f6835h;
    private C1984d f6836i;

    public C2081b(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968646);
        this.f6835h = c1985e;
        this.f6836i = c1984d;
        this.f6830c = (TextView) this.itemView.findViewById(2131689724);
        this.f6831d = (TextView) this.itemView.findViewById(2131689725);
        this.f6832e = (ImageView) this.itemView.findViewById(2131689726);
        this.f6833f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6834g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6833f.setOnClickListener(new C2082c(this));
    }

    protected void m9735a(C1722f c1722f) {
        C2174b c2174b = (C2174b) c1722f;
        super.m9659a(c2174b);
        this.f6830c.setText(c2174b.m9947q());
        this.f6831d.setText(c2174b.m9945o());
        switch (C2083d.f6839b[c2174b.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6832e.setImageResource(2130838557);
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6832e.setImageResource(2130838559);
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f6832e.setImageResource(2130838560);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6832e.setImageResource(2130838560);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6832e.setImageResource(2130838561);
                break;
        }
        switch (C2083d.f6838a[c2174b.m9949s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                break;
            case VideoSize.HVGA /*2*/:
                this.f6834g.setVisibility(0);
                this.f6833f.setImageResource(2130838520);
                if (c2174b.m9946p() > 0) {
                    if (this.f6834g.m6352a()) {
                        this.f6834g.m6353b();
                    }
                    this.f6834g.setProgress(((float) c2174b.m9946p()) * 0.01f);
                    return;
                } else if (!this.f6834g.m6352a()) {
                    this.f6834g.m6354c();
                    return;
                } else {
                    return;
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6834g.setVisibility(8);
                this.f6833f.setImageResource(2130838519);
                return;
            case Version.API04_DONUT_16 /*4*/:
                this.f6834g.setVisibility(8);
                this.f6833f.setImageResource(2130838519);
                return;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6834g.setVisibility(8);
                this.f6833f.setImageResource(2130838508);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6834g.setVisibility(8);
                this.f6833f.setImageResource(2130838508);
                return;
            default:
                return;
        }
        this.f6834g.setVisibility(8);
        this.f6833f.setImageResource(2130838519);
    }
}
