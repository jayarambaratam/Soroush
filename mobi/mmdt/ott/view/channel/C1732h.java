package mobi.mmdt.ott.view.channel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.channel.h */
class C1732h implements OnClickListener {
    final /* synthetic */ ChannelInfoActivity f5709a;

    C1732h(ChannelInfoActivity channelInfoActivity) {
        this.f5709a = channelInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5709a.runOnUiThread(new C1733i(this));
    }
}
