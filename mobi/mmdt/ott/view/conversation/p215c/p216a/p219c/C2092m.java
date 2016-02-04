package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p170d.C1603h;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p213a.C1986f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2177e;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.m */
public class C2092m extends C2080a {
    private TextView f6862c;
    private ImageButton f6863d;
    private ImageView f6864e;
    private ProgressWheel f6865f;
    private SeekBar f6866g;
    private C1986f f6867h;
    private C1985e f6868i;

    public C2092m(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1986f c1986f, C1985e c1985e) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968661);
        this.f6867h = c1986f;
        this.f6868i = c1985e;
        this.f6862c = (TextView) this.itemView.findViewById(2131689725);
        this.f6864e = (ImageView) this.itemView.findViewById(2131689726);
        this.f6863d = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6865f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6866g = (SeekBar) this.itemView.findViewById(2131689745);
        this.f6863d.setOnClickListener(new C2093n(this));
        this.f6866g.setOnSeekBarChangeListener(new C2094o(this));
    }

    private void m9743a(int i) {
        if (i == C1603h.PLAYING.ordinal()) {
            this.f6866g.setEnabled(true);
            this.f6863d.setImageResource(2130838573);
        } else if (i == C1603h.PAUSE.ordinal()) {
            this.f6866g.setEnabled(true);
            this.f6863d.setImageResource(2130838574);
        } else if (i == C1603h.STOP.ordinal()) {
            this.f6866g.setEnabled(false);
            this.f6863d.setImageResource(2130838574);
        }
    }

    protected void m9745a(C1722f c1722f) {
        C2177e c2177e = (C2177e) c1722f;
        super.m9659a(c2177e);
        int q = c2177e.m9963q();
        int r = c2177e.m9964r();
        int o = c2177e.m9961o();
        CharSequence a = C1111c.m6393a(o / 1000);
        this.f6866g.setMax(o);
        this.f6866g.setProgress(0);
        if (r != 0) {
            a = C1111c.m6393a(r / 1000);
            this.f6866g.setProgress(r);
        }
        this.f6862c.setText(a);
        switch (C2095p.f6872b[c2177e.m9849m().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6864e.setImageResource(2130838557);
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6864e.setImageResource(2130838559);
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f6864e.setImageResource(2130838560);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6864e.setImageResource(2130838560);
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f6864e.setImageResource(2130838561);
                break;
        }
        switch (C2095p.f6871a[c2177e.m9965s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6865f.setVisibility(8);
                this.f6863d.setImageResource(2130838519);
                this.f6866g.setEnabled(false);
            case VideoSize.HVGA /*2*/:
                this.f6865f.setVisibility(0);
                this.f6863d.setImageResource(2130838520);
                this.f6866g.setEnabled(false);
                if (c2177e.m9962p() > 0) {
                    if (this.f6865f.m6352a()) {
                        this.f6865f.m6353b();
                    }
                    this.f6865f.setProgress(((float) c2177e.m9962p()) * 0.01f);
                } else if (!this.f6865f.m6352a()) {
                    this.f6865f.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6865f.setVisibility(8);
                this.f6863d.setImageResource(2130838519);
                this.f6866g.setEnabled(false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6865f.setVisibility(8);
                this.f6863d.setImageResource(2130838519);
                this.f6866g.setEnabled(false);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6865f.setVisibility(8);
                m9743a(q);
            default:
        }
    }
}
