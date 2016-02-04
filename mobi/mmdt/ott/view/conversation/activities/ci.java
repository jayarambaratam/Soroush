package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class ci implements OnClickListener {
    final /* synthetic */ C2152a f6484a;
    final /* synthetic */ ChannelConversationActivity f6485b;

    ci(ChannelConversationActivity channelConversationActivity, C2152a c2152a) {
        this.f6485b = channelConversationActivity;
        this.f6484a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6485b.m9436k(this.f6484a);
            case 2131689976:
                this.f6485b.m9434i(this.f6484a);
            case 2131689977:
                this.f6485b.m9435j(this.f6484a);
            case 2131689978:
                this.f6485b.m9490d(this.f6484a);
            default:
        }
    }
}
