package mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.e */
class C2235e implements OnClickListener {
    final /* synthetic */ C2231a f7352a;
    final /* synthetic */ IconPageIndicator f7353b;

    C2235e(IconPageIndicator iconPageIndicator, C2231a c2231a) {
        this.f7353b = iconPageIndicator;
        this.f7352a = c2231a;
    }

    public void onClick(View view) {
        this.f7353b.setCurrentItem(this.f7352a.m10131a());
    }
}
