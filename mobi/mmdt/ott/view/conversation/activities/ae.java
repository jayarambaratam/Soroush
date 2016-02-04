package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class ae implements OnClickListener {
    final /* synthetic */ C2152a f6413a;
    final /* synthetic */ ChannelConversationActivity f6414b;

    ae(ChannelConversationActivity channelConversationActivity, C2152a c2152a) {
        this.f6414b = channelConversationActivity;
        this.f6413a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6414b.m9436k(this.f6413a);
            case 2131689976:
                this.f6414b.m9434i(this.f6413a);
            case 2131689977:
                this.f6414b.m9435j(this.f6413a);
            case 2131689978:
                this.f6414b.m9490d(this.f6413a);
            default:
        }
    }
}
