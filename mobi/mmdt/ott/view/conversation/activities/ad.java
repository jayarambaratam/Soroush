package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class ad implements OnClickListener {
    final /* synthetic */ C2152a f6411a;
    final /* synthetic */ ChannelConversationActivity f6412b;

    ad(ChannelConversationActivity channelConversationActivity, C2152a c2152a) {
        this.f6412b = channelConversationActivity;
        this.f6411a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6412b.m9436k(this.f6411a);
            case 2131689976:
                this.f6412b.m9434i(this.f6411a);
            case 2131689977:
                this.f6412b.m9435j(this.f6411a);
            case 2131689978:
                this.f6412b.m9490d(this.f6411a);
            default:
        }
    }
}
