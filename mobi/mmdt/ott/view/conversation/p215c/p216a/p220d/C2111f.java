package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2183c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.f */
public class C2111f extends C2106a {
    private ImageView f6924c;
    private TextView f6925d;
    private ImageButton f6926e;
    private ProgressWheel f6927f;
    private C1985e f6928g;
    private C1984d f6929h;

    public C2111f(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1987g c1987g, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968651, c1987g);
        this.f6928g = c1985e;
        this.f6929h = c1984d;
        this.f6924c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6925d = (TextView) this.itemView.findViewById(2131689731);
        this.f6926e = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6927f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6924c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6926e.setOnClickListener(new C2112g(this));
        this.f6924c.setOnClickListener(new C2113h(this));
    }

    protected void m9768a(C1722f c1722f) {
        C2153a c2153a = (C2183c) c1722f;
        super.m9759a(c2153a);
        this.f6924c.setImageBitmap(null);
        if (c2153a.m9995t() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m9992q())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6924c);
        } else if (c2153a.m9993r() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2153a.m9990o())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6924c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838530)).m4406a(0.25f).m4417a(this.f6924c);
        }
        if (c2153a.m9994s() == null || c2153a.m9994s().isEmpty()) {
            this.f6925d.setVisibility(8);
        } else {
            this.f6925d.setText(c2153a.m9994s());
            this.f6925d.setVisibility(0);
        }
        switch (C2114i.f6933b[c2153a.m9849m().ordinal()]) {
        }
        switch (C2114i.f6932a[c2153a.m9993r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6927f.setVisibility(8);
                this.f6926e.setVisibility(0);
                this.f6926e.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6927f.setVisibility(0);
                this.f6926e.setVisibility(0);
                this.f6926e.setImageResource(2130838520);
                if (c2153a.m9991p() > 0) {
                    if (this.f6927f.m6352a()) {
                        this.f6927f.m6353b();
                    }
                    this.f6927f.setProgress(((float) c2153a.m9991p()) * 0.01f);
                } else if (!this.f6927f.m6352a()) {
                    this.f6927f.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6927f.setVisibility(8);
                this.f6926e.setVisibility(0);
                this.f6926e.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6927f.setVisibility(8);
                this.f6926e.setVisibility(0);
                this.f6926e.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6927f.setVisibility(8);
                this.f6926e.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6927f.setVisibility(8);
                this.f6926e.setVisibility(8);
            default:
        }
    }
}
