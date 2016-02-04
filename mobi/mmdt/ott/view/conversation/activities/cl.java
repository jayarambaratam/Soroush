package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class cl implements OnClickListener {
    final /* synthetic */ GroupConversationActivity f6489a;

    cl(GroupConversationActivity groupConversationActivity) {
        this.f6489a = groupConversationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6489a.runOnUiThread(new cm(this));
    }
}
