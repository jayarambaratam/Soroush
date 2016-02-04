package mobi.mmdt.ott.view.conversation.activities;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class dh implements OnClickListener {
    final /* synthetic */ SingleConversationActivity f6517a;

    dh(SingleConversationActivity singleConversationActivity) {
        this.f6517a = singleConversationActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6517a.runOnUiThread(new di(this));
    }
}
