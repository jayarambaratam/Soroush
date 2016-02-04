package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class cg implements OnClickListener {
    final /* synthetic */ C2152a f6480a;
    final /* synthetic */ ChannelConversationActivity f6481b;

    cg(ChannelConversationActivity channelConversationActivity, C2152a c2152a) {
        this.f6481b = channelConversationActivity;
        this.f6480a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6481b.m9436k(this.f6480a);
            case 2131689976:
                this.f6481b.m9434i(this.f6480a);
            case 2131689977:
                this.f6481b.m9435j(this.f6480a);
            case 2131689978:
                this.f6481b.m9490d(this.f6480a);
            case 2131689981:
                this.f6481b.m9424c(this.f6480a);
            default:
        }
    }
}
