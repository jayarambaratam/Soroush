package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2182b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.c */
public class C2108c extends C2106a {
    private TextView f6915c;
    private TextView f6916d;
    private ImageButton f6917e;
    private ProgressWheel f6918f;
    private C1985e f6919g;
    private C1984d f6920h;

    public C2108c(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1985e c1985e, C1987g c1987g, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968647, c1987g);
        this.f6919g = c1985e;
        this.f6920h = c1984d;
        this.f6915c = (TextView) this.itemView.findViewById(2131689724);
        this.f6916d = (TextView) this.itemView.findViewById(2131689725);
        this.f6917e = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6918f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6917e.setOnClickListener(new C2109d(this));
    }

    protected void m9765a(C1722f c1722f) {
        C2153a c2153a = (C2182b) c1722f;
        super.m9759a(c2153a);
        this.f6915c.setText(c2153a.m9987q());
        this.f6916d.setText(c2153a.m9985o());
        switch (C2110e.f6923b[c2153a.m9849m().ordinal()]) {
        }
        switch (C2110e.f6922a[c2153a.m9989s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                break;
            case VideoSize.HVGA /*2*/:
                this.f6918f.setVisibility(0);
                this.f6917e.setImageResource(2130838520);
                if (c2153a.m9986p() > 0) {
                    if (this.f6918f.m6352a()) {
                        this.f6918f.m6353b();
                    }
                    this.f6918f.setProgress(((float) c2153a.m9986p()) * 0.01f);
                    return;
                } else if (!this.f6918f.m6352a()) {
                    this.f6918f.m6354c();
                    return;
                } else {
                    return;
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6918f.setVisibility(8);
                this.f6917e.setImageResource(2130838518);
                return;
            case Version.API04_DONUT_16 /*4*/:
                this.f6918f.setVisibility(8);
                this.f6917e.setImageResource(2130838518);
                return;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6918f.setVisibility(8);
                this.f6917e.setImageResource(2130838508);
                return;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6918f.setVisibility(8);
                this.f6917e.setImageResource(2130838508);
                break;
            default:
                return;
        }
        this.f6918f.setVisibility(8);
        this.f6917e.setImageResource(2130838518);
    }
}
