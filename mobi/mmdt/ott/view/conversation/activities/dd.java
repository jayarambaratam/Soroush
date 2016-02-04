package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class dd implements OnClickListener {
    final /* synthetic */ C2152a f6511a;
    final /* synthetic */ GroupConversationActivity f6512b;

    dd(GroupConversationActivity groupConversationActivity, C2152a c2152a) {
        this.f6512b = groupConversationActivity;
        this.f6511a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6512b.m9436k(this.f6511a);
            case 2131689976:
                this.f6512b.m9434i(this.f6511a);
            case 2131689977:
                this.f6512b.m9435j(this.f6511a);
            case 2131689988:
                this.f6512b.m9421b(this.f6511a);
            default:
        }
    }
}
