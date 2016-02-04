package mobi.mmdt.ott.view.conversation.groupinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.design.widget.Snackbar;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.r */
class C2267r implements OnClickListener {
    final /* synthetic */ String f7485a;
    final /* synthetic */ boolean f7486b;
    final /* synthetic */ C1619f f7487c;
    final /* synthetic */ GroupInfoActivity f7488d;

    C2267r(GroupInfoActivity groupInfoActivity, String str, boolean z, C1619f c1619f) {
        this.f7488d = groupInfoActivity;
        this.f7485a = str;
        this.f7486b = z;
        this.f7487c = c1619f;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        if (this.f7485a.equals(this.f7488d.f7396F)) {
            Snackbar.m377a(this.f7488d.i, (CharSequence) "You cannot change your membership status yourself!", -1).m395a();
        } else if (this.f7488d.f7397G == C1619f.ADMIN || this.f7488d.f7397G == C1619f.OWNER || this.f7486b) {
            switch (i) {
                case 2131689989:
                    this.f7488d.m10223h(this.f7485a);
                case 2131689990:
                    this.f7488d.m10203a(this.f7485a, this.f7487c);
                default:
            }
        } else {
            Snackbar.m377a(this.f7488d.i, (CharSequence) "Permission Denied!", -1).m395a();
        }
    }
}
