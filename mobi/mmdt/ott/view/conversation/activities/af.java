package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;

class af implements OnClickListener {
    final /* synthetic */ C2152a f6415a;
    final /* synthetic */ ChannelConversationActivity f6416b;

    af(ChannelConversationActivity channelConversationActivity, C2152a c2152a) {
        this.f6416b = channelConversationActivity;
        this.f6415a = c2152a;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        switch (i) {
            case 2131689975:
                this.f6416b.m9436k(this.f6415a);
            case 2131689976:
                this.f6416b.m9434i(this.f6415a);
            case 2131689978:
                this.f6416b.m9490d(this.f6415a);
            case 2131689979:
                this.f6416b.m9404a(this.f6415a.m9847k());
            default:
        }
    }
}
