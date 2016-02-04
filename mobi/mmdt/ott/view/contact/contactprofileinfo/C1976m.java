package mobi.mmdt.ott.view.contact.contactprofileinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;

/* renamed from: mobi.mmdt.ott.view.contact.contactprofileinfo.m */
class C1976m implements OnClickListener {
    final /* synthetic */ ContactProfileInfoActivity f6331a;

    C1976m(ContactProfileInfoActivity contactProfileInfoActivity) {
        this.f6331a = contactProfileInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        new Handler().postDelayed(new C1977n(this), 50);
        new Handler().postDelayed(new C1978o(this), 2050);
        new Handler().postDelayed(new C1979p(this), 2150);
    }
}
