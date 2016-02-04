package mobi.mmdt.ott.view.main.p237c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.main.c.c */
class C2352c implements OnClickListener {
    final /* synthetic */ String f7785a;
    final /* synthetic */ C2347a f7786b;

    C2352c(C2347a c2347a, String str) {
        this.f7786b = c2347a;
        this.f7785a = str;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689962:
                this.f7786b.f7760h = true;
                this.f7786b.m10517c(this.f7785a);
            case 2131689965:
                this.f7786b.f7760h = false;
                this.f7786b.m10517c(this.f7785a);
            case 2131689966:
                this.f7786b.m10513b(this.f7785a);
            default:
        }
    }
}
