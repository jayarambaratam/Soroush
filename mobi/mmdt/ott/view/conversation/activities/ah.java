package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class ah implements OnClickListener {
    final /* synthetic */ ChannelConversationActivity f6419a;

    ah(ChannelConversationActivity channelConversationActivity) {
        this.f6419a = channelConversationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6419a.runOnUiThread(new ai(this));
    }
}
