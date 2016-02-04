package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class db implements OnClickListener {
    final /* synthetic */ C2152a f6507a;
    final /* synthetic */ GroupConversationActivity f6508b;

    db(GroupConversationActivity groupConversationActivity, C2152a c2152a) {
        this.f6508b = groupConversationActivity;
        this.f6507a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6508b.m9436k(this.f6507a);
            case 2131689976:
                this.f6508b.m9434i(this.f6507a);
            case 2131689980:
                this.f6508b.m9413a(this.f6507a);
            case 2131689988:
                this.f6508b.m9421b(this.f6507a);
            default:
        }
    }
}
