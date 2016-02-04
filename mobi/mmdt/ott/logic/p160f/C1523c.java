package mobi.mmdt.ott.logic.p160f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1603h;

/* renamed from: mobi.mmdt.ott.logic.f.c */
class C1523c implements OnCompletionListener {
    final /* synthetic */ C1521a f5104a;

    C1523c(C1521a c1521a) {
        this.f5104a = c1521a;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f5104a.f5099d.cancel();
        C1598c.m8103b(this.f5104a.f5097b, this.f5104a.f5100e.m8087e(), 0);
        C1598c.m8094a(this.f5104a.f5097b, this.f5104a.f5100e.m8087e(), C1603h.STOP);
        this.f5104a.f5102g = C1603h.STOP;
    }
}
