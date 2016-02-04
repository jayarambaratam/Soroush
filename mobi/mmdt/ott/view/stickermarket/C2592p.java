package mobi.mmdt.ott.view.stickermarket;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.stickermarket.p */
class C2592p implements OnClickListener {
    final /* synthetic */ Runnable f8299a;
    final /* synthetic */ StickerMarketActivity f8300b;

    C2592p(StickerMarketActivity stickerMarketActivity, Runnable runnable) {
        this.f8300b = stickerMarketActivity;
        this.f8299a = runnable;
    }

    public void onClick(View view) {
        this.f8299a.run();
    }
}
