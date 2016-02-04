package mobi.mmdt.ott.view.components.p181b;

import android.view.View;
import android.view.View.OnLongClickListener;

/* renamed from: mobi.mmdt.ott.view.components.b.d */
class C1788d implements OnLongClickListener {
    final /* synthetic */ C1712b f5778a;

    C1788d(C1712b c1712b) {
        this.f5778a = c1712b;
    }

    public boolean onLongClick(View view) {
        if (this.f5778a.f5648b != null && this.f5778a.f5647a.m8660h() > -1) {
            this.f5778a.f5648b.m8757b(view, this.f5778a.f5647a.m8660h());
        }
        return false;
    }
}
