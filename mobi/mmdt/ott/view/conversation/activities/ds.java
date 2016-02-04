package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class ds implements OnClickListener {
    final /* synthetic */ C2152a f6533a;
    final /* synthetic */ SingleConversationActivity f6534b;

    ds(SingleConversationActivity singleConversationActivity, C2152a c2152a) {
        this.f6534b = singleConversationActivity;
        this.f6533a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6534b.m9436k(this.f6533a);
            case 2131689976:
                this.f6534b.m9434i(this.f6533a);
            case 2131689979:
                this.f6534b.m9404a(this.f6533a.m9847k());
            case 2131689988:
                this.f6534b.m9421b(this.f6533a);
            default:
        }
    }
}
