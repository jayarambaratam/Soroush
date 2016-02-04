package mobi.mmdt.ott.logic.p160f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1603h;

/* renamed from: mobi.mmdt.ott.logic.f.d */
class C1524d implements OnErrorListener {
    final /* synthetic */ C1521a f5105a;

    C1524d(C1521a c1521a) {
        this.f5105a = c1521a;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f5105a.f5099d.cancel();
        C1598c.m8103b(this.f5105a.f5097b, this.f5105a.f5100e.m8087e(), 0);
        C1598c.m8094a(this.f5105a.f5097b, this.f5105a.f5100e.m8087e(), C1603h.STOP);
        this.f5105a.f5102g = C1603h.STOP;
        return false;
    }
}
