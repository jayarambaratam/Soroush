package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class dr implements OnClickListener {
    final /* synthetic */ C2152a f6531a;
    final /* synthetic */ SingleConversationActivity f6532b;

    dr(SingleConversationActivity singleConversationActivity, C2152a c2152a) {
        this.f6532b = singleConversationActivity;
        this.f6531a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6532b.m9436k(this.f6531a);
            case 2131689976:
                this.f6532b.m9434i(this.f6531a);
            case 2131689977:
                this.f6532b.m9435j(this.f6531a);
            case 2131689988:
                this.f6532b.m9421b(this.f6531a);
            default:
        }
    }
}
