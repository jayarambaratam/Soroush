package mobi.mmdt.ott.view.stickermarket;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.stickermarket.b */
class C2578b implements OnClickListener {
    final /* synthetic */ Runnable f8281a;
    final /* synthetic */ StickerCategoryActivity f8282b;

    C2578b(StickerCategoryActivity stickerCategoryActivity, Runnable runnable) {
        this.f8282b = stickerCategoryActivity;
        this.f8281a = runnable;
    }

    public void onClick(View view) {
        this.f8281a.run();
    }
}
