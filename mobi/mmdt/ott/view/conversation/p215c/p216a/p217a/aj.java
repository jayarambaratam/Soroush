package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.aj */
class aj implements OnSeekBarChangeListener {
    final /* synthetic */ ah f6641a;

    aj(ah ahVar) {
        this.f6641a = ahVar;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f6641a.f6638h.m9347b(seekBar.getProgress());
    }
}
