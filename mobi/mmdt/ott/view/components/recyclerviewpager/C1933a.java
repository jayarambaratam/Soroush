package mobi.mmdt.ott.view.components.recyclerviewpager;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* renamed from: mobi.mmdt.ott.view.components.recyclerviewpager.a */
class C1933a implements OnGlobalLayoutListener {
    final /* synthetic */ RecyclerViewPager f6218a;

    C1933a(RecyclerViewPager recyclerViewPager) {
        this.f6218a = recyclerViewPager;
    }

    public void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.f6218a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.f6218a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        if (this.f6218a.f6215n >= 0 && this.f6218a.f6215n < this.f6218a.getAdapter().getItemCount() && this.f6218a.f6214m != null) {
            for (C1934b c1934b : this.f6218a.f6214m) {
                if (c1934b != null) {
                    c1934b.m9207a(this.f6218a.f6216o, this.f6218a.getCurrentPosition());
                }
            }
        }
    }
}
