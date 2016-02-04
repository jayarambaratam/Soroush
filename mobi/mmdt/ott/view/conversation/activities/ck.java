package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class ck implements OnClickListener {
    final /* synthetic */ C2152a f6487a;
    final /* synthetic */ GroupConversationActivity f6488b;

    ck(GroupConversationActivity groupConversationActivity, C2152a c2152a) {
        this.f6488b = groupConversationActivity;
        this.f6487a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6488b.m9436k(this.f6487a);
            case 2131689976:
                this.f6488b.m9434i(this.f6487a);
            case 2131689979:
                this.f6488b.m9404a(this.f6487a.m9847k());
            case 2131689988:
                this.f6488b.m9421b(this.f6487a);
            default:
        }
    }
}
