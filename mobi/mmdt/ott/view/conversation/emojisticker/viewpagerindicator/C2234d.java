package mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator;

import android.view.View;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.d */
class C2234d implements Runnable {
    final /* synthetic */ View f7350a;
    final /* synthetic */ IconPageIndicator f7351b;

    C2234d(IconPageIndicator iconPageIndicator, View view) {
        this.f7351b = iconPageIndicator;
        this.f7350a = view;
    }

    public void run() {
        this.f7351b.smoothScrollTo(this.f7350a.getLeft() - ((this.f7351b.getWidth() - this.f7350a.getWidth()) / 2), 0);
        this.f7351b.f7339d = null;
    }
}
