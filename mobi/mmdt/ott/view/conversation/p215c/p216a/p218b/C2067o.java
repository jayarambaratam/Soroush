package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.o */
class C2067o implements OnSeekBarChangeListener {
    final /* synthetic */ C2065m f6791a;

    C2067o(C2065m c2065m) {
        this.f6791a = c2065m;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f6791a.f6788g.m9347b(seekBar.getProgress());
    }
}
