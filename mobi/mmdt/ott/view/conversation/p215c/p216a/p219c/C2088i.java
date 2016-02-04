package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2176d;
import mobi.mmdt.ott.view.p178a.an;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.i */
public class C2088i extends C2080a {
    private ImageView f6851c;
    private ImageView f6852d;
    private ImageView f6853e;
    private ImageButton f6854f;
    private ProgressWheel f6855g;
    private C1985e f6856h;
    private C1984d f6857i;

    public C2088i(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, int i2, C1985e c1985e, C1984d c1984d) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968654);
        this.f6856h = c1985e;
        this.f6857i = c1984d;
        this.f6851c = (ImageView) this.itemView.findViewById(2131689732);
        this.f6852d = (ImageView) this.itemView.findViewById(2131689726);
        this.f6853e = (ImageView) this.itemView.findViewById(2131689733);
        this.f6854f = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6855g = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        LayoutParams layoutParams = (LayoutParams) this.f6851c.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        layoutParams = (LayoutParams) this.f6853e.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        this.f6854f.setOnClickListener(new C2089j(this));
        this.f6851c.setOnClickListener(new C2090k(this));
    }

    protected void m9741a(C1722f c1722f) {
        C2176d c2176d = (C2176d) c1722f;
        super.m9659a(c2176d);
        this.f6851c.setImageBitmap(null);
        Uri parse = Uri.parse(c2176d.m9958q());
        if (c2176d.m9959r() == C1604i.DELETED) {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4409a(C0652e.SOURCE).m4416a(new an(this.a)).m4417a(this.f6851c);
        } else {
            C0872i.m5265a(this.a).m5327a(parse).m4405a().m4407a(2130838530).m4406a(0.25f).m4417a(this.f6851c);
        }
        switch (C2091l.f6861b[c2176d.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6852d.setImageResource(2130838558);
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6852d.setImageResource(2130838563);
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f6852d.setImageResource(2130838562);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6852d.setImageResource(2130838562);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6852d.setImageResource(2130838561);
                break;
        }
        switch (C2091l.f6860a[c2176d.m9959r().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6855g.setVisibility(8);
                this.f6854f.setVisibility(0);
                this.f6854f.setImageResource(2130838519);
            case VideoSize.HVGA /*2*/:
                this.f6855g.setVisibility(0);
                this.f6854f.setVisibility(0);
                this.f6854f.setImageResource(2130838520);
                if (c2176d.m9957p() > 0) {
                    if (this.f6855g.m6352a()) {
                        this.f6855g.m6353b();
                    }
                    this.f6855g.setProgress(((float) c2176d.m9957p()) * 0.01f);
                } else if (!this.f6855g.m6352a()) {
                    this.f6855g.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6855g.setVisibility(8);
                this.f6854f.setVisibility(0);
                this.f6854f.setImageResource(2130838519);
            case Version.API04_DONUT_16 /*4*/:
                this.f6855g.setVisibility(8);
                this.f6854f.setVisibility(0);
                this.f6854f.setImageResource(2130838519);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6855g.setVisibility(8);
                this.f6854f.setVisibility(8);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6855g.setVisibility(8);
                this.f6854f.setVisibility(8);
            default:
        }
    }
}
