package mobi.mmdt.ott.logic.p160f;

import android.content.Context;
import android.media.MediaPlayer;
import java.util.Timer;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1588h;
import mobi.mmdt.ott.provider.p170d.C1597b;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1603h;

/* renamed from: mobi.mmdt.ott.logic.f.a */
public class C1521a {
    private static C1521a f5096a;
    private final Context f5097b;
    private MediaPlayer f5098c;
    private Timer f5099d;
    private C1597b f5100e;
    private C1588h f5101f;
    private C1603h f5102g;

    private C1521a(Context context) {
        this.f5098c = new MediaPlayer();
        this.f5099d = new Timer();
        this.f5102g = C1603h.STOP;
        this.f5097b = context;
        C1598c.m8097a(this.f5097b, C1603h.STOP);
        C1598c.m8098a(this.f5097b, C1603h.STOP, 0);
    }

    public static C1521a m7668a(Context context) {
        if (f5096a == null) {
            f5096a = new C1521a(context);
        }
        return f5096a;
    }

    private void m7671b() {
        this.f5099d = new Timer();
        this.f5099d.schedule(new C1522b(this), 250, 250);
    }

    private void m7673c() {
        C1598c.m8103b(this.f5097b, this.f5100e.m8087e(), 0);
        this.f5098c = new MediaPlayer();
        this.f5098c.setDataSource(this.f5097b, this.f5100e.m8088f());
        this.f5098c.setLooping(false);
        this.f5098c.setOnCompletionListener(new C1523c(this));
        this.f5098c.setOnErrorListener(new C1524d(this));
        this.f5098c.prepare();
        C1598c.m8105c(this.f5097b, this.f5100e.m8087e(), this.f5098c.getDuration());
        this.f5098c.start();
        this.f5102g = C1603h.PLAYING;
        m7671b();
        C1598c.m8094a(this.f5097b, this.f5100e.m8087e(), C1603h.PLAYING);
    }

    private synchronized void m7675d() {
        this.f5099d.cancel();
        this.f5098c.stop();
        this.f5098c.release();
        C1598c.m8094a(this.f5097b, this.f5100e.m8087e(), C1603h.STOP);
        C1598c.m8103b(this.f5097b, this.f5100e.m8087e(), 0);
        this.f5102g = C1603h.STOP;
    }

    public synchronized void m7676a() {
        this.f5099d.cancel();
        this.f5098c.pause();
        C1598c.m8094a(this.f5097b, this.f5100e.m8087e(), C1603h.PAUSE);
        C1598c.m8103b(this.f5097b, this.f5100e.m8087e(), this.f5098c.getCurrentPosition());
        this.f5102g = C1603h.PAUSE;
    }

    public synchronized void m7677a(int i) {
        this.f5098c.seekTo(i);
        C1598c.m8103b(this.f5097b, this.f5100e.m8087e(), i);
    }

    public synchronized void m7678a(long j) {
        if (this.f5102g.equals(C1603h.PAUSE) && j == this.f5101f.m8047h()) {
            C1598c.m8094a(this.f5097b, this.f5100e.m8087e(), C1603h.PLAYING);
            this.f5098c.start();
            this.f5102g = C1603h.PLAYING;
            m7671b();
        } else if (this.f5102g.equals(C1603h.PLAYING) || this.f5102g.equals(C1603h.PAUSE)) {
            m7675d();
            this.f5101f = C1583c.m7968a(this.f5097b, j);
            this.f5100e = C1598c.m8102a(this.f5097b, this.f5101f.m8048i().longValue());
            m7673c();
        } else {
            C1598c.m8097a(this.f5097b, C1603h.STOP);
            C1598c.m8098a(this.f5097b, C1603h.STOP, 0);
            this.f5101f = C1583c.m7968a(this.f5097b, j);
            this.f5100e = C1598c.m8102a(this.f5097b, this.f5101f.m8048i().longValue());
            m7673c();
        }
    }
}
