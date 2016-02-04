package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class dp implements OnClickListener {
    final /* synthetic */ C2152a f6527a;
    final /* synthetic */ SingleConversationActivity f6528b;

    dp(SingleConversationActivity singleConversationActivity, C2152a c2152a) {
        this.f6528b = singleConversationActivity;
        this.f6527a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6528b.m9436k(this.f6527a);
            case 2131689976:
                this.f6528b.m9434i(this.f6527a);
            case 2131689977:
                this.f6528b.m9435j(this.f6527a);
            case 2131689988:
                this.f6528b.m9421b(this.f6527a);
            default:
        }
    }
}
