package mobi.mmdt.ott.view.conversation.p215c.p216a.p220d;

import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.d.p */
class C2121p implements OnSeekBarChangeListener {
    final /* synthetic */ C2119n f6951a;

    C2121p(C2119n c2119n) {
        this.f6951a = c2119n;
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.f6951a.f6948g.m9347b(seekBar.getProgress());
    }
}
