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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2163j;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.aw */
public class aw extends C2027a {
    private ImageView f6667d;
    private TextView f6668e;
    private ImageView f6669f;
    private ImageButton f6670g;
    private ProgressWheel f6671h;
    private C1985e f6672i;
    private C1984d f6673j;

    public aw(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1981a c1981a, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968676, c1981a);
        this.f6672i = c1985e;
        this.f6673j = c1984d;
        this.f6667d = (ImageView) this.itemView.findViewById(2131689732);
        this.f6668e = (TextView) this.itemView.findViewById(2131689748);
        this.f6669f = (ImageView) this.itemView.findViewById(2131689733);
        this.f6670g = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6671h = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6667d.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6669f.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6670g.setOnClickListener(new ax(this));
        this.f6667d.setOnClickListener(new ay(this));
    }

    protected void m9684a(C1722f c1722f) {
        C2154a c2154a = (C2163j) c1722f;
        super.m9664a(c2154a);
        this.f6667d.setImageBitmap(null);
        if (c2154a.m9900v() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9897s())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6667d);
        } else if (c2154a.m9899u() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2154a.m9895q())).m4405a().m4407a(2130838589).m4406a(0.25f).m4417a(this.f6667d);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838589)).m4406a(0.25f).m4417a(this.f6667d);
        }
        this.f6668e.setText(C1111c.m6393a(c2154a.m9898t() / 1000));
        switch (az.f6677b[c2154a.m9849m().ordinal()]) {
        }
        switch (az.f6676a[c2154a.m9899u().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6671h.setVisibility(8);
                this.f6670g.setVisibility(0);
                this.f6670g.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6671h.setVisibility(0);
                this.f6670g.setVisibility(0);
                this.f6670g.setImageResource(2130838520);
                if (c2154a.m9896r() > 0) {
                    if (this.f6671h.m6352a()) {
                        this.f6671h.m6353b();
                    }
                    this.f6671h.setProgress(((float) c2154a.m9896r()) * 0.01f);
                } else if (!this.f6671h.m6352a()) {
                    this.f6671h.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6671h.setVisibility(8);
                this.f6670g.setVisibility(0);
                this.f6670g.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6671h.setVisibility(8);
                this.f6670g.setVisibility(0);
                this.f6670g.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6671h.setVisibility(8);
                this.f6670g.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6671h.setVisibility(8);
                this.f6670g.setVisibility(8);
            default:
        }
    }
}
