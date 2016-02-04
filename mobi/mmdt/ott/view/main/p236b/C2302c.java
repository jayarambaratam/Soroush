package mobi.mmdt.ott.view.main.p236b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.design.widget.Snackbar;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.ott.view.p178a.C1659a;

/* renamed from: mobi.mmdt.ott.view.main.b.c */
class C2302c implements OnClickListener {
    final /* synthetic */ String f7610a;
    final /* synthetic */ C2298a f7611b;

    C2302c(C2298a c2298a, String str) {
        this.f7611b = c2298a;
        this.f7610a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689963:
                C1659a.m8432a(this.f7611b.m10381b(), this.f7610a, false);
            case 2131689964:
                if (C1107a.m6377b(this.f7611b.m10381b())) {
                    C1659a.m8445c(this.f7611b.m10381b(), this.f7610a);
                } else {
                    Snackbar.m377a(this.f7611b.f7593b, this.f7611b.m10381b().getString(2131230821), -1).m395a();
                }
            default:
        }
    }
}
