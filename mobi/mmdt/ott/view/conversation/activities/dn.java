package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class dn implements OnClickListener {
    final /* synthetic */ C2152a f6523a;
    final /* synthetic */ SingleConversationActivity f6524b;

    dn(SingleConversationActivity singleConversationActivity, C2152a c2152a) {
        this.f6524b = singleConversationActivity;
        this.f6523a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6524b.m9436k(this.f6523a);
            case 2131689976:
                this.f6524b.m9434i(this.f6523a);
            case 2131689977:
                this.f6524b.m9435j(this.f6523a);
            case 2131689981:
                this.f6524b.m9424c(this.f6523a);
            case 2131689988:
                this.f6524b.m9421b(this.f6523a);
            default:
        }
    }
}
