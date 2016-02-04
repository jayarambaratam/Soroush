package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class ag implements OnClickListener {
    final /* synthetic */ C2152a f6417a;
    final /* synthetic */ ChannelConversationActivity f6418b;

    ag(ChannelConversationActivity channelConversationActivity, C2152a c2152a) {
        this.f6418b = channelConversationActivity;
        this.f6417a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6418b.m9436k(this.f6417a);
            default:
        }
    }
}
