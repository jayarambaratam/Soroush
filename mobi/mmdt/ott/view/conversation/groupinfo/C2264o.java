package mobi.mmdt.ott.view.conversation.groupinfo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.o */
class C2264o implements OnClickListener {
    final /* synthetic */ GroupInfoActivity f7482a;

    C2264o(GroupInfoActivity groupInfoActivity) {
        this.f7482a = groupInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f7482a.runOnUiThread(new C2265p(this));
    }
}
