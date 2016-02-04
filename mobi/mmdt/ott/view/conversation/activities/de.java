package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class de implements OnClickListener {
    final /* synthetic */ C2152a f6513a;
    final /* synthetic */ GroupConversationActivity f6514b;

    de(GroupConversationActivity groupConversationActivity, C2152a c2152a) {
        this.f6514b = groupConversationActivity;
        this.f6513a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6514b.m9436k(this.f6513a);
            case 2131689976:
                this.f6514b.m9434i(this.f6513a);
            case 2131689977:
                this.f6514b.m9435j(this.f6513a);
            case 2131689988:
                this.f6514b.m9421b(this.f6513a);
            default:
        }
    }
}
