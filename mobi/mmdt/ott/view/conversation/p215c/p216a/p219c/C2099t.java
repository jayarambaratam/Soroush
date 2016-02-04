package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2179g;
import mobi.mmdt.ott.view.p178a.am;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.t */
public class C2099t extends C2080a {
    private TextView f6880c;
    private ImageView f6881d;
    private boolean f6882e;

    public C2099t(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968669);
        this.f6880c = (TextView) this.itemView.findViewById(2131689740);
        this.f6881d = (ImageView) this.itemView.findViewById(2131689726);
        this.f6880c.setOnLongClickListener(new C2100u(this));
        this.f6880c.setOnTouchListener(new C2101v(this));
    }

    protected void m9754a(C1722f c1722f) {
        C2179g c2179g = (C2179g) c1722f;
        super.m9659a(c2179g);
        this.f6880c.setTextSize((float) c2179g.m9971p());
        this.f6880c.setText(c2179g.m9970o());
        am.m8479a(this.f6880c);
        switch (C2102w.f6885a[c2179g.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6881d.setImageResource(2130838557);
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6881d.setImageResource(2130838559);
            case Version.API04_DONUT_16 /*4*/:
                this.f6881d.setImageResource(2130838560);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6881d.setImageResource(2130838560);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6881d.setImageResource(2130838561);
            default:
        }
    }
}
