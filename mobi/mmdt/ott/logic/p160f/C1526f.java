package mobi.mmdt.ott.logic.p160f;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;

/* renamed from: mobi.mmdt.ott.logic.f.f */
class C1526f implements OnErrorListener {
    final /* synthetic */ C1525e f5114a;

    C1526f(C1525e c1525e) {
        this.f5114a = c1525e;
    }

    public void onError(MediaRecorder mediaRecorder, int i, int i2) {
        if (C1525e.f5107f != null) {
            C1525e.f5107f.m7694a(this.f5114a.f5108b, new Exception());
        }
    }
}
