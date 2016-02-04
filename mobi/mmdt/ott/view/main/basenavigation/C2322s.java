package mobi.mmdt.ott.view.main.basenavigation;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;
import mobi.mmdt.ott.view.components.p184a.C1753a;
import mobi.mmdt.ott.view.components.p184a.p189e.C1764a;
import mobi.mmdt.ott.view.main.MainActivity;
import mobi.mmdt.ott.view.p178a.ac;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.HttpStatus;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.s */
public class C2322s extends ab {
    private View f7637b;
    private View f7638c;
    private View f7639d;
    private View f7640e;
    private RelativeLayout f7641f;
    private ImageView f7642g;
    private ImageView f7643h;
    private ImageView f7644i;
    private ImageView f7645j;
    private TextView f7646k;
    private TextView f7647l;
    private TextView f7648m;
    private TextView f7649n;
    private View f7650o;
    private Animation f7651p;
    private Animation f7652q;
    private aa f7653r;
    private OnClickListener f7654s;

    private C2322s(Activity activity, aa aaVar) {
        super(activity);
        this.f7654s = new C2342z(this);
        this.f7653r = aaVar;
        this.a = LayoutInflater.from(activity).inflate(2130968711, null, false);
        m10440d();
    }

    public static C2322s m10436a(Activity activity, aa aaVar) {
        return new C2322s(activity, aaVar);
    }

    private void m10440d() {
        this.f7642g = (ImageView) this.a.findViewById(2131689821);
        this.f7644i = (ImageView) this.a.findViewById(2131689815);
        this.f7643h = (ImageView) this.a.findViewById(2131689803);
        this.f7645j = (ImageView) this.a.findViewById(2131689809);
        this.f7637b = this.a.findViewById(2131689820);
        this.f7638c = this.a.findViewById(2131689808);
        this.f7639d = this.a.findViewById(2131689814);
        this.f7640e = this.a.findViewById(2131689802);
        this.f7641f = (RelativeLayout) this.a.findViewById(2131689800);
        this.f7646k = (TextView) this.a.findViewById(2131689807);
        this.f7647l = (TextView) this.a.findViewById(2131689819);
        this.f7648m = (TextView) this.a.findViewById(2131689825);
        this.f7649n = (TextView) this.a.findViewById(2131689813);
        this.f7650o = this.a.findViewById(2131689801);
        this.f7641f.setDrawingCacheEnabled(true);
        this.f7637b.setDrawingCacheEnabled(true);
        this.f7638c.setDrawingCacheEnabled(true);
        this.f7639d.setDrawingCacheEnabled(true);
        this.f7640e.setDrawingCacheEnabled(true);
        this.f7637b.setOnClickListener(this.f7654s);
        this.f7638c.setOnClickListener(this.f7654s);
        this.f7639d.setOnClickListener(this.f7654s);
        this.f7640e.setOnClickListener(this.f7654s);
        this.f7651p = ac.m8459a(m10381b()).m8461b();
        this.f7652q = ac.m8459a(m10381b()).m8460a();
        m10446g();
        if (MainActivity.f7558i) {
            m10453a(1000, (int) HttpStatus.SC_OK);
        } else {
            m10451a();
        }
        m10455b(C1512c.m7629a());
        m10452a(C1512c.m7632b());
    }

    private void m10441e() {
        new Handler().postDelayed(new C2341y(this), 50);
    }

    private void m10443f() {
    }

    private void m10446g() {
        if (m10381b().getResources().getConfiguration().orientation == 1) {
            this.f7641f.setScaleX(1.0f);
            this.f7641f.setScaleY(1.0f);
            return;
        }
        this.f7641f.setScaleX(0.75f);
        this.f7641f.setScaleY(0.75f);
    }

    public void m10451a() {
        this.f7640e.setAlpha(1.0f);
        this.f7638c.setAlpha(1.0f);
        this.f7639d.setAlpha(1.0f);
        this.f7637b.setAlpha(1.0f);
        this.f7642g.setAlpha(1.0f);
        this.f7644i.setAlpha(1.0f);
        this.f7643h.setAlpha(1.0f);
        this.f7645j.setAlpha(1.0f);
    }

    public void m10452a(int i) {
        if (this.f7649n == null) {
            return;
        }
        if (i == 0) {
            this.f7649n.setAlpha(0.0f);
        } else if (i < 100) {
            C1753a.m8688a(new C1764a()).m8701a(250).m8704a(this.f7649n);
            this.f7649n.setText(BuildConfig.FLAVOR + i);
        } else {
            C1753a.m8688a(new C1764a()).m8701a(250).m8704a(this.f7649n);
            this.f7649n.setText(m10381b().getString(2131230960));
        }
    }

    public void m10453a(int i, int i2) {
        this.f7640e.setAlpha(0.0f);
        this.f7638c.setAlpha(0.0f);
        this.f7639d.setAlpha(0.0f);
        this.f7637b.setAlpha(0.0f);
        this.f7646k.setAlpha(0.0f);
        this.f7647l.setAlpha(0.0f);
        this.f7648m.setAlpha(0.0f);
        this.f7649n.setAlpha(0.0f);
        this.f7642g.setAlpha(0.0f);
        this.f7644i.setAlpha(0.0f);
        this.f7643h.setAlpha(0.0f);
        this.f7645j.setAlpha(0.0f);
        new Handler().postDelayed(new C2323t(this, i2), (long) i);
        new Handler().postDelayed(new C2324u(this, i2), (long) (i + i2));
        new Handler().postDelayed(new C2325v(this, i2), (long) ((i2 * 2) + i));
        new Handler().postDelayed(new C2339w(this, i2), (long) ((i2 * 3) + i));
    }

    public void m10454a(String str) {
    }

    public void m10455b(int i) {
        if (this.f7648m == null) {
            return;
        }
        if (i == 0) {
            this.f7648m.setAlpha(0.0f);
        } else if (i < 100) {
            C1753a.m8688a(new C1764a()).m8701a(250).m8704a(this.f7648m);
            this.f7648m.setText(BuildConfig.FLAVOR + i);
        } else {
            C1753a.m8688a(new C1764a()).m8701a(250).m8704a(this.f7648m);
            this.f7648m.setText(m10381b().getString(2131230960));
        }
    }
}
