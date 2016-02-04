package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class dc implements OnClickListener {
    final /* synthetic */ C2152a f6509a;
    final /* synthetic */ GroupConversationActivity f6510b;

    dc(GroupConversationActivity groupConversationActivity, C2152a c2152a) {
        this.f6510b = groupConversationActivity;
        this.f6509a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6510b.m9436k(this.f6509a);
            case 2131689976:
                this.f6510b.m9434i(this.f6509a);
            case 2131689977:
                this.f6510b.m9435j(this.f6509a);
            case 2131689988:
                this.f6510b.m9421b(this.f6509a);
            default:
        }
    }
}
