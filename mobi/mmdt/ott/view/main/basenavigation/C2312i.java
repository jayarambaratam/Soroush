package mobi.mmdt.ott.view.main.basenavigation;

import android.support.v7.widget.SearchView.OnCloseListener;
import org.apache.http.myHttp.HttpStatus;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.i */
class C2312i implements OnCloseListener {
    final /* synthetic */ C2285a f7627a;

    C2312i(C2285a c2285a) {
        this.f7627a = c2285a;
    }

    public boolean onClose() {
        this.f7627a.m10313a((int) HttpStatus.SC_MULTIPLE_CHOICES);
        return false;
    }
}
