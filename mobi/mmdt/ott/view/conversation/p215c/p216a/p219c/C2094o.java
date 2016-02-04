package mobi.mmdt.ott.view.conversation.p215c.p216a.p219c;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.c.o */
class C2094o implements OnSeekBarChangeListener {
    final /* synthetic */ C2092m f6870a;

    C2094o(C2092m c2092m) {
        this.f6870a = c2092m;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f6870a.f6867h.m9347b(seekBar.getProgress());
    }
}
