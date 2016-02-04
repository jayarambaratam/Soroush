package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

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
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2168e;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.m */
public class C2065m extends C2053a {
    private TextView f6784c;
    private ImageButton f6785d;
    private ProgressWheel f6786e;
    private SeekBar f6787f;
    private C1986f f6788g;
    private C1985e f6789h;

    public C2065m(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, C1986f c1986f, C1985e c1985e) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968660);
        this.f6788g = c1986f;
        this.f6789h = c1985e;
        this.f6784c = (TextView) this.itemView.findViewById(2131689725);
        this.f6785d = (ImageButton) this.itemView.findViewById(2131689723);
        this.f6786e = (ProgressWheel) this.itemView.findViewById(C1119f.progress_wheel);
        this.f6787f = (SeekBar) this.itemView.findViewById(2131689745);
        this.f6785d.setOnClickListener(new C2066n(this));
        this.f6787f.setOnSeekBarChangeListener(new C2067o(this));
    }

    private void m9715a(int i) {
        if (i == C1603h.PLAYING.ordinal()) {
            this.f6787f.setEnabled(true);
            this.f6785d.setImageResource(2130838573);
        } else if (i == C1603h.PAUSE.ordinal()) {
            this.f6787f.setEnabled(true);
            this.f6785d.setImageResource(2130838574);
        } else if (i == C1603h.STOP.ordinal()) {
            this.f6787f.setEnabled(false);
            this.f6785d.setImageResource(2130838574);
        }
    }

    protected void m9717a(C1722f c1722f) {
        C2168e c2168e = (C2168e) c1722f;
        super.m9659a(c2168e);
        int q = c2168e.m9919q();
        int r = c2168e.m9920r();
        int o = c2168e.m9917o();
        CharSequence a = C1111c.m6393a(o / 1000);
        this.f6787f.setMax(o);
        this.f6787f.setProgress(0);
        if (r != 0) {
            a = C1111c.m6393a(r / 1000);
            this.f6787f.setProgress(r);
        }
        this.f6784c.setText(a);
        switch (C2068p.f6793b[c2168e.m9849m().ordinal()]) {
        }
        switch (C2068p.f6792a[c2168e.m9921s().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f6786e.setVisibility(8);
                this.f6785d.setImageResource(2130838518);
                this.f6787f.setEnabled(false);
            case VideoSize.HVGA /*2*/:
                this.f6786e.setVisibility(0);
                this.f6785d.setImageResource(2130838520);
                this.f6787f.setEnabled(false);
                if (c2168e.m9918p() > 0) {
                    if (this.f6786e.m6352a()) {
                        this.f6786e.m6353b();
                    }
                    this.f6786e.setProgress(((float) c2168e.m9918p()) * 0.01f);
                } else if (!this.f6786e.m6352a()) {
                    this.f6786e.m6354c();
                }
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f6786e.setVisibility(8);
                this.f6785d.setImageResource(2130838518);
                this.f6787f.setEnabled(false);
            case Version.API04_DONUT_16 /*4*/:
                this.f6786e.setVisibility(8);
                this.f6785d.setImageResource(2130838518);
                this.f6787f.setEnabled(false);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f6786e.setVisibility(8);
                m9715a(q);
            default:
        }
    }
}
