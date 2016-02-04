package mobi.mmdt.ott.view.registeration.introduction;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

/* renamed from: mobi.mmdt.ott.view.registeration.introduction.k */
class C2444k implements OnCheckedChangeListener {
    final /* synthetic */ C2443j f7951a;

    C2444k(C2443j c2443j) {
        this.f7951a = c2443j;
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (this.f7951a.f7950a != null) {
            switch (i) {
                case 2131689871:
                    this.f7951a.f7950a.m10621a(2);
                case 2131689872:
                    this.f7951a.f7950a.m10621a(1);
                default:
            }
        }
    }
}
