package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2165b;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.b */
public class C2054b extends C2053a {
    private TextView f6755c;
    private TextView f6756d;
    private ImageButton f6757e;
    private ProgressWheel f6758f;
    private C1985e f6759g;
    private C1984d f6760h;

    public C2054b(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968645);
        this.f6759g = c1985e;
        this.f6760h = c1984d;
        this.f6755c = (TextView) this.itemView.findViewById(2131689724);
        this.f6756d = (TextView) this.itemView.findViewById(2131689725);
        this.f6757e = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6758f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6757e.setOnClickListener(new C2055c(this));
    }

    protected void m9707a(C1722f c1722f) {
        C2165b c2165b = (C2165b) c1722f;
        super.m9659a(c2165b);
        this.f6755c.setText(c2165b.m9903q());
        this.f6756d.setText(c2165b.m9901o());
        switch (C2056d.f6763b[c2165b.m9849m().ordinal()]) {
        }
        switch (C2056d.f6762a[c2165b.m9905s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                break;
            case VideoSize.HVGA /*2*/:
                this.f6758f.setVisibility(0);
                this.f6757e.setImageResource(2130838520);
                if (c2165b.m9902p() > 0) {
                    if (this.f6758f.m6352a()) {
                        this.f6758f.m6353b();
                    }
                    this.f6758f.setProgress(((float) c2165b.m9902p()) * 0.01f);
                    return;
                } else if (!this.f6758f.m6352a()) {
                    this.f6758f.m6354c();
                    return;
                } else {
                    return;
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6758f.setVisibility(8);
                this.f6757e.setImageResource(2130838518);
                return;
            case Version.API04_DONUT_16 /*4*/:
                this.f6758f.setVisibility(8);
                this.f6757e.setImageResource(2130838518);
                return;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6758f.setVisibility(8);
                this.f6757e.setImageResource(2130838508);
                return;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6758f.setVisibility(8);
                this.f6757e.setImageResource(2130838508);
                break;
            default:
                return;
        }
        this.f6758f.setVisibility(8);
        this.f6757e.setImageResource(2130838518);
    }
}
