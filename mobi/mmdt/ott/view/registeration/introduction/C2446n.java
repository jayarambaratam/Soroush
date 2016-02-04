package mobi.mmdt.ott.view.registeration.introduction;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* renamed from: mobi.mmdt.ott.view.registeration.introduction.n */
class C2446n implements OnCheckedChangeListener {
    final /* synthetic */ C2445m f7953a;

    C2446n(C2445m c2445m) {
        this.f7953a = c2445m;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.f7953a.f7952a != null) {
            this.f7953a.f7952a.m10622b(z);
        }
    }
}
