package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class dq implements OnClickListener {
    final /* synthetic */ C2152a f6529a;
    final /* synthetic */ SingleConversationActivity f6530b;

    dq(SingleConversationActivity singleConversationActivity, C2152a c2152a) {
        this.f6530b = singleConversationActivity;
        this.f6529a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6530b.m9436k(this.f6529a);
            case 2131689976:
                this.f6530b.m9434i(this.f6529a);
            case 2131689977:
                this.f6530b.m9435j(this.f6529a);
            case 2131689988:
                this.f6530b.m9421b(this.f6529a);
            default:
        }
    }
}
