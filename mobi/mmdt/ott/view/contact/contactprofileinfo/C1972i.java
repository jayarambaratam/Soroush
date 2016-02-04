package mobi.mmdt.ott.view.contact.contactprofileinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.contact.contactprofileinfo.i */
class C1972i implements OnClickListener {
    final /* synthetic */ ContactProfileInfoActivity f6327a;

    C1972i(ContactProfileInfoActivity contactProfileInfoActivity) {
        this.f6327a = contactProfileInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new Handler().postDelayed(new C1973j(this), 50);
        new Handler().postDelayed(new C1974k(this), 2050);
        new Handler().postDelayed(new C1975l(this), 2150);
    }
}
