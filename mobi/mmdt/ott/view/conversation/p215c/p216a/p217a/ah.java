package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

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
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p213a.C1986f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2159f;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ah */
public class ah extends C2027a {
    private TextView f6634d;
    private ImageButton f6635e;
    private ProgressWheel f6636f;
    private SeekBar f6637g;
    private C1986f f6638h;
    private C1985e f6639i;

    public ah(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1986f c1986f, C1985e c1985e, C1981a c1981a) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968659, c1981a);
        this.f6638h = c1986f;
        this.f6639i = c1985e;
        this.f6634d = (TextView) this.itemView.findViewById(2131689725);
        this.f6635e = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6636f = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6637g = (SeekBar) this.itemView.findViewById(2131689745);
        this.f6635e.setOnClickListener(new ai(this));
        this.f6637g.setOnSeekBarChangeListener(new aj(this));
    }

    private void m9667a(int i) {
        if (i == C1603h.PLAYING.ordinal()) {
            this.f6637g.setEnabled(true);
            this.f6635e.setImageResource(2130838573);
        } else if (i == C1603h.PAUSE.ordinal()) {
            this.f6637g.setEnabled(true);
            this.f6635e.setImageResource(2130838574);
        } else if (i == C1603h.STOP.ordinal()) {
            this.f6637g.setEnabled(false);
            this.f6635e.setImageResource(2130838574);
        }
    }

    protected void m9669a(C1722f c1722f) {
        C2154a c2154a = (C2159f) c1722f;
        super.m9664a(c2154a);
        int s = c2154a.m9875s();
        int t = c2154a.m9876t();
        int q = c2154a.m9873q();
        CharSequence a = C1111c.m6393a(q / 1000);
        this.f6637g.setMax(q);
        this.f6637g.setProgress(0);
        if (t != 0) {
            a = C1111c.m6393a(t / 1000);
            this.f6637g.setProgress(t);
        }
        this.f6634d.setText(a);
        switch (ak.f6643b[c2154a.m9849m().ordinal()]) {
        }
        switch (ak.f6642a[c2154a.m9877u().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6636f.setVisibility(8);
                this.f6635e.setImageResource(2130838518);
                this.f6637g.setEnabled(false);
            case VideoSize.HVGA /*2*/:
                this.f6636f.setVisibility(0);
                this.f6635e.setImageResource(2130838520);
                this.f6637g.setEnabled(false);
                if (c2154a.m9874r() > 0) {
                    if (this.f6636f.m6352a()) {
                        this.f6636f.m6353b();
                    }
                    this.f6636f.setProgress(((float) c2154a.m9874r()) * 0.01f);
                } else if (!this.f6636f.m6352a()) {
                    this.f6636f.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6636f.setVisibility(8);
                this.f6635e.setImageResource(2130838518);
                this.f6637g.setEnabled(false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6636f.setVisibility(8);
                this.f6635e.setImageResource(2130838518);
                this.f6637g.setEnabled(false);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6636f.setVisibility(8);
                m9667a(s);
            default:
        }
    }
}
