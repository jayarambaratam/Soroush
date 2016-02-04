package mobi.mmdt.ott.view.conversation.activities;

import android.support.design.widget.Snackbar;
import org.linphone.core.VideoSize;

class bl implements Runnable {
    final /* synthetic */ bj f6452a;

    bl(bj bjVar) {
        this.f6452a = bjVar;
    }

    public void run() {
        switch (bu.f6462a[this.f6452a.f6449a.m6997d().ordinal()]) {
            case VideoSize.CIF /*1*/:
                Snackbar.m377a(this.f6452a.f6450b.k, this.f6452a.f6450b.getString(2131230870), -1).m395a();
            case VideoSize.HVGA /*2*/:
                Snackbar.m377a(this.f6452a.f6450b.k, this.f6452a.f6450b.getString(2131230972), -1).m395a();
            default:
        }
    }
}
