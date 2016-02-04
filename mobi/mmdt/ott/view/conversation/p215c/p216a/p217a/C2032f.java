package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2155b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.f */
public class C2032f extends C2027a {
    private TextView f6686d;
    private TextView f6687e;
    private ImageButton f6688f;
    private ProgressWheel f6689g;
    private C1985e f6690h;
    private C1984d f6691i;

    public C2032f(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1985e c1985e, C1981a c1981a, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968644, c1981a);
        this.f6690h = c1985e;
        this.f6691i = c1984d;
        this.f6686d = (TextView) this.itemView.findViewById(2131689724);
        this.f6687e = (TextView) this.itemView.findViewById(2131689725);
        this.f6688f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6689g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6688f.setOnClickListener(new C2033g(this));
    }

    protected void m9687a(C1722f c1722f) {
        C2154a c2154a = (C2155b) c1722f;
        super.m9664a(c2154a);
        this.f6686d.setText(c2154a.m9857s());
        this.f6687e.setText(c2154a.m9855q());
        switch (C2034h.f6694b[c2154a.m9849m().ordinal()]) {
        }
        switch (C2034h.f6693a[c2154a.m9859u().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6689g.setVisibility(8);
                this.f6688f.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6689g.setVisibility(0);
                this.f6688f.setImageResource(2130838520);
                if (c2154a.m9856r() > 0) {
                    if (this.f6689g.m6352a()) {
                        this.f6689g.m6353b();
                    }
                    this.f6689g.setProgress(((float) c2154a.m9856r()) * 0.01f);
                } else if (!this.f6689g.m6352a()) {
                    this.f6689g.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6689g.setVisibility(8);
                this.f6688f.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6689g.setVisibility(8);
                this.f6688f.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6689g.setVisibility(8);
                this.f6688f.setImageResource(2130838508);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6689g.setVisibility(8);
                this.f6688f.setImageResource(2130838508);
            default:
        }
    }
}
