package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2166c;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.e */
public class C2057e extends C2053a {
    private ImageView f6764c;
    private TextView f6765d;
    private ImageButton f6766e;
    private ProgressWheel f6767f;
    private C1985e f6768g;
    private C1984d f6769h;

    public C2057e(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968649);
        this.f6768g = c1985e;
        this.f6769h = c1984d;
        this.f6764c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6765d = (TextView) this.itemView.findViewById(2131689731);
        this.f6766e = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6767f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6764c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6766e.setOnClickListener(new C2058f(this));
        this.f6764c.setOnClickListener(new C2059g(this));
    }

    protected void m9710a(C1722f c1722f) {
        C2166c c2166c = (C2166c) c1722f;
        super.m9659a(c2166c);
        this.f6764c.setImageBitmap(null);
        if (c2166c.m9911t() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2166c.m9908q())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6764c);
        } else if (c2166c.m9909r() == C1604i.FINISHED) {
            C0872i.m5265a(this.a).m5327a(Uri.parse(c2166c.m9906o())).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6764c);
        } else {
            C0872i.m5265a(this.a).m5328a(Integer.valueOf(2130838530)).m4406a(0.25f).m4417a(this.f6764c);
        }
        if (c2166c.m9910s() == null || c2166c.m9910s().isEmpty()) {
            this.f6765d.setVisibility(8);
        } else {
            this.f6765d.setText(c2166c.m9910s());
            this.f6765d.setVisibility(0);
        }
        switch (C2060h.f6773b[c2166c.m9849m().ordinal()]) {
        }
        switch (C2060h.f6772a[c2166c.m9909r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6767f.setVisibility(8);
                this.f6766e.setVisibility(0);
                this.f6766e.setImageResource(2130838518);
            case VideoSize.HVGA /*2*/:
                this.f6767f.setVisibility(0);
                this.f6766e.setVisibility(0);
                this.f6766e.setImageResource(2130838520);
                if (c2166c.m9907p() > 0) {
                    if (this.f6767f.m6352a()) {
                        this.f6767f.m6353b();
                    }
                    this.f6767f.setProgress(((float) c2166c.m9907p()) * 0.01f);
                } else if (!this.f6767f.m6352a()) {
                    this.f6767f.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6767f.setVisibility(8);
                this.f6766e.setVisibility(0);
                this.f6766e.setImageResource(2130838518);
            case Version.API04_DONUT_16 /*4*/:
                this.f6767f.setVisibility(8);
                this.f6766e.setVisibility(0);
                this.f6766e.setImageResource(2130838518);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6767f.setVisibility(8);
                this.f6766e.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6767f.setVisibility(8);
                this.f6766e.setVisibility(8);
            default:
        }
    }
}
