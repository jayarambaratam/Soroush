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
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2162i;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.as */
public class as extends C2027a {
    private ImageView f6655d;
    private TextView f6656e;
    private TextView f6657f;
    private ImageView f6658g;
    private ImageButton f6659h;
    private ProgressWheel f6660i;
    private C1985e f6661j;
    private C1984d f6662k;

    public as(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1981a c1981a, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968672, c1981a);
        this.f6661j = c1985e;
        this.f6662k = c1984d;
        this.f6655d = (ImageView) this.itemView.findViewById(2131689732);
        this.f6656e = (TextView) this.itemView.findViewById(2131689731);
        this.f6657f = (TextView) this.itemView.findViewById(2131689748);
        this.f6658g = (ImageView) this.itemView.findViewById(2131689733);
        this.f6659h = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6660i = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6655d.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6658g.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6659h.setOnClickListener(new at(this));
        this.f6655d.setOnClickListener(new au(this));
    }

    protected void m9681a(C1722f c1722f) {
        C2154a c2154a = (C2162i) c1722f;
        super.m9664a(c2154a);
        this.f6655d.setImageBitmap(null);
        if (c2154a.m9894x() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9890s())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6655d);
        } else if (c2154a.m9892u() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9888q())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6655d);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838589)).m4406a(0.25f).m4417a(this.f6655d);
        }
        this.f6657f.setText(C1111c.m6393a(c2154a.m9891t() / 1000));
        if (c2154a.m9893v() == null || c2154a.m9893v().isEmpty()) {
            this.f6656e.setVisibility(8);
        } else {
            this.f6656e.setText(c2154a.m9893v());
            this.f6656e.setVisibility(0);
        }
        switch (av.f6666b[c2154a.m9849m().ordinal()]) {
        }
        switch (av.f6665a[c2154a.m9892u().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6660i.setVisibility(8);
                this.f6659h.setVisibility(0);
                this.f6659h.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6660i.setVisibility(0);
                this.f6659h.setVisibility(0);
                this.f6659h.setImageResource(2130838520);
                if (c2154a.m9889r() > 0) {
                    if (this.f6660i.m6352a()) {
                        this.f6660i.m6353b();
                    }
                    this.f6660i.setProgress(((float) c2154a.m9889r()) * 0.01f);
                } else if (!this.f6660i.m6352a()) {
                    this.f6660i.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6660i.setVisibility(8);
                this.f6659h.setVisibility(0);
                this.f6659h.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6660i.setVisibility(8);
                this.f6659h.setVisibility(0);
                this.f6659h.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6660i.setVisibility(8);
                this.f6659h.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6660i.setVisibility(8);
                this.f6659h.setVisibility(8);
            default:
        }
    }
}
