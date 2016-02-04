package mobi.mmdt.ott.view.stickermarket.stickersettings.p251a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.mmdt.ott.view.stickermarket.stickersettings.p252b.C2603b;

/* renamed from: mobi.mmdt.ott.view.stickermarket.stickersettings.a.c */
class C2600c implements OnCheckedChangeListener {
    final /* synthetic */ C2598a f8329a;

    C2600c(C2598a c2598a) {
        this.f8329a = c2598a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!this.f8329a.f8326i) {
            if (z) {
                this.f8329a.f8318a.m11037a((C2603b) this.f8329a.m8619a());
            } else {
                this.f8329a.f8318a.m11038b((C2603b) this.f8329a.m8619a());
            }
        }
    }
}
