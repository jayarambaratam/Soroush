package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class ch implements OnClickListener {
    final /* synthetic */ C2152a f6482a;
    final /* synthetic */ ChannelConversationActivity f6483b;

    ch(ChannelConversationActivity channelConversationActivity, C2152a c2152a) {
        this.f6483b = channelConversationActivity;
        this.f6482a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6483b.m9436k(this.f6482a);
            case 2131689976:
                this.f6483b.m9434i(this.f6482a);
            case 2131689978:
                this.f6483b.m9490d(this.f6482a);
            case 2131689980:
                this.f6483b.m9413a(this.f6482a);
            default:
        }
    }
}
