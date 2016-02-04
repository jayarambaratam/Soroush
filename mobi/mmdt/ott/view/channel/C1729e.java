package mobi.mmdt.ott.view.channel;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.channel.e */
class C1729e implements OnClickListener {
    final /* synthetic */ C1727c f5706a;

    C1729e(C1727c c1727c) {
        this.f5706a = c1727c;
    }

    public void onClick(View view) {
        Snackbar.m377a(this.f5706a.f5704b.f5702a.i, (CharSequence) "No media found!", -1).m395a();
    }
}
