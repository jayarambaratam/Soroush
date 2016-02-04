package mobi.mmdt.ott.logic.p160f;

import android.app.Activity;
import android.media.MediaRecorder;
import java.io.File;
import java.util.Calendar;
import java.util.TimeZone;
import mobi.mmdt.ott.logic.C1490b;

/* renamed from: mobi.mmdt.ott.logic.f.e */
public class C1525e {
    private static C1525e f5106a;
    private static C1527g f5107f;
    private int f5108b;
    private final Activity f5109c;
    private MediaRecorder f5110d;
    private String f5111e;
    private boolean f5112g;
    private long f5113h;

    private C1525e(Activity activity) {
        this.f5108b = -1;
        this.f5112g = false;
        this.f5109c = activity;
    }

    public static C1525e m7680a(Activity activity, C1527g c1527g) {
        f5107f = c1527g;
        if (f5106a == null) {
            f5106a = new C1525e(activity);
        }
        return f5106a;
    }

    private void m7682f() {
        this.f5113h = System.currentTimeMillis();
        this.f5110d.start();
        if (f5107f != null) {
            f5107f.m7692a(this.f5108b);
        }
    }

    private void m7683g() {
        m7686j();
        if (f5107f != null) {
            f5107f.m7693a(this.f5108b, (int) ((System.currentTimeMillis() - this.f5113h) / 1000));
        }
    }

    private void m7684h() {
        m7686j();
        if (f5107f != null) {
            f5107f.m7695b(this.f5108b);
        }
    }

    private void m7685i() {
        try {
            this.f5110d.prepare();
        } catch (Exception e) {
            if (f5107f != null) {
                f5107f.m7694a(this.f5108b, e);
            }
        }
    }

    private void m7686j() {
        try {
            this.f5110d.stop();
        } catch (RuntimeException e) {
            new File(this.f5111e).delete();
        } finally {
            this.f5110d.release();
            this.f5110d = null;
        }
    }

    private void m7687k() {
        this.f5111e = C1490b.m7516a(this.f5109c).m7526d(Calendar.getInstance(TimeZone.getDefault()).get(1) + "_" + Calendar.getInstance(TimeZone.getDefault()).get(2) + "_" + Calendar.getInstance(TimeZone.getDefault()).get(5) + ".m4a");
        this.f5110d = new MediaRecorder();
        this.f5110d.setOutputFile(this.f5111e);
        this.f5110d.setAudioSource(1);
        this.f5110d.setOutputFormat(2);
        this.f5110d.setAudioEncoder(3);
        this.f5110d.setOnErrorListener(new C1526f(this));
    }

    public void m7688a() {
        if (this.f5112g) {
            this.f5112g = false;
            m7683g();
        }
        m7687k();
        m7685i();
        this.f5112g = true;
        m7682f();
    }

    public void m7689b() {
        if (this.f5112g) {
            this.f5112g = false;
            m7683g();
        }
    }

    public void m7690c() {
        if (this.f5112g) {
            this.f5112g = false;
            m7684h();
        }
    }

    public String m7691d() {
        return this.f5111e;
    }
}
