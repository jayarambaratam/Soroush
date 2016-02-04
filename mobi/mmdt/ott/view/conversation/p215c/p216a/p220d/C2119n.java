package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2153a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2185e;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.n */
public class C2119n extends C2106a {
    private TextView f6944c;
    private ImageButton f6945d;
    private ProgressWheel f6946e;
    private SeekBar f6947f;
    private C1986f f6948g;
    private C1985e f6949h;

    public C2119n(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1986f c1986f, C1985e c1985e, C1987g c1987g) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968662, c1987g);
        this.f6948g = c1986f;
        this.f6949h = c1985e;
        this.a = activity;
        this.f6944c = (TextView) this.itemView.findViewById(2131689725);
        this.f6945d = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6946e = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6947f = (SeekBar) this.itemView.findViewById(2131689745);
        this.f6945d.setOnClickListener(new C2120o(this));
        this.f6947f.setOnSeekBarChangeListener(new C2121p(this));
    }

    private void m9773a(int i) {
        if (i == C1603h.PLAYING.ordinal()) {
            this.f6947f.setEnabled(true);
            this.f6945d.setImageResource(2130838573);
        } else if (i == C1603h.PAUSE.ordinal()) {
            this.f6947f.setEnabled(true);
            this.f6945d.setImageResource(2130838574);
        } else if (i == C1603h.STOP.ordinal()) {
            this.f6947f.setEnabled(false);
            this.f6945d.setImageResource(2130838574);
        }
    }

    protected void m9775a(C1722f c1722f) {
        C2153a c2153a = (C2185e) c1722f;
        super.m9759a(c2153a);
        int q = c2153a.m10003q();
        int r = c2153a.m10004r();
        int o = c2153a.m10001o();
        CharSequence a = C1111c.m6393a(o / 1000);
        this.f6947f.setMax(o);
        this.f6947f.setProgress(0);
        if (r != 0) {
            a = C1111c.m6393a(r / 1000);
            this.f6947f.setProgress(r);
        }
        this.f6944c.setText(a);
        switch (C2122q.f6953b[c2153a.m9849m().ordinal()]) {
        }
        switch (C2122q.f6952a[c2153a.m10005s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6946e.setVisibility(8);
                this.f6945d.setImageResource(2130838518);
                this.f6947f.setEnabled(false);
            case VideoSize.HVGA /*2*/:
                this.f6946e.setVisibility(0);
                this.f6945d.setImageResource(2130838520);
                this.f6947f.setEnabled(false);
                if (c2153a.m10002p() > 0) {
                    if (this.f6946e.m6352a()) {
                        this.f6946e.m6353b();
                    }
                    this.f6946e.setProgress(((float) c2153a.m10002p()) * 0.01f);
                } else if (!this.f6946e.m6352a()) {
                    this.f6946e.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6946e.setVisibility(8);
                this.f6945d.setImageResource(2130838518);
                this.f6947f.setEnabled(false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6946e.setVisibility(8);
                this.f6945d.setImageResource(2130838518);
                this.f6947f.setEnabled(false);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6946e.setVisibility(8);
                m9773a(q);
            default:
        }
    }
}
