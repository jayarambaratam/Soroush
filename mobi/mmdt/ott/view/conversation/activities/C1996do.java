package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.do */
class C1996do implements OnClickListener {
    final /* synthetic */ C2152a f6525a;
    final /* synthetic */ SingleConversationActivity f6526b;

    C1996do(SingleConversationActivity singleConversationActivity, C2152a c2152a) {
        this.f6526b = singleConversationActivity;
        this.f6525a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6526b.m9436k(this.f6525a);
            case 2131689976:
                this.f6526b.m9434i(this.f6525a);
            case 2131689980:
                this.f6526b.m9413a(this.f6525a);
            case 2131689988:
                this.f6526b.m9421b(this.f6525a);
            default:
        }
    }
}
