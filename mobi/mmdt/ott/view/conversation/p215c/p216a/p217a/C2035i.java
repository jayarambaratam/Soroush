package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

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
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2156c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.i */
public class C2035i extends C2027a {
    private ImageView f6695d;
    private TextView f6696e;
    private ImageButton f6697f;
    private ProgressWheel f6698g;
    private C1985e f6699h;
    private C1984d f6700i;

    public C2035i(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1981a c1981a, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968648, c1981a);
        this.f6699h = c1985e;
        this.f6700i = c1984d;
        this.f6695d = (ImageView) this.itemView.findViewById(2131689732);
        this.f6696e = (TextView) this.itemView.findViewById(2131689731);
        this.f6697f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6698g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6695d.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6697f.setOnClickListener(new C2036j(this));
        this.f6695d.setOnClickListener(new C2037k(this));
    }

    protected void m9690a(C1722f c1722f) {
        C2154a c2154a = (C2156c) c1722f;
        super.m9664a(c2154a);
        this.f6695d.setImageBitmap(null);
        if (c2154a.m9865v() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9862s())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6695d);
        } else if (c2154a.m9863t() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9860q())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6695d);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838530)).m4406a(0.25f).m4417a(this.f6695d);
        }
        if (c2154a.m9864u() == null || c2154a.m9864u().isEmpty()) {
            this.f6696e.setVisibility(8);
        } else {
            this.f6696e.setText(c2154a.m9864u());
            this.f6696e.setVisibility(0);
        }
        switch (C2038l.f6704b[c2154a.m9849m().ordinal()]) {
        }
        switch (C2038l.f6703a[c2154a.m9863t().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6698g.setVisibility(8);
                this.f6697f.setVisibility(0);
                this.f6697f.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6698g.setVisibility(0);
                this.f6697f.setVisibility(0);
                this.f6697f.setImageResource(2130838520);
                if (c2154a.m9861r() > 0) {
                    if (this.f6698g.m6352a()) {
                        this.f6698g.m6353b();
                    }
                    this.f6698g.setProgress(((float) c2154a.m9861r()) * 0.01f);
                } else if (!this.f6698g.m6352a()) {
                    this.f6698g.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6698g.setVisibility(8);
                this.f6697f.setVisibility(0);
                this.f6697f.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6698g.setVisibility(8);
                this.f6697f.setVisibility(0);
                this.f6697f.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6698g.setVisibility(8);
                this.f6697f.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6698g.setVisibility(8);
                this.f6697f.setVisibility(8);
            default:
        }
    }
}
