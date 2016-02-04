package mobi.mmdt.ott.view.conversation.activities;

import android.os.Handler;

class ca implements Runnable {
    final /* synthetic */ String f6469a;
    final /* synthetic */ String f6470b;
    final /* synthetic */ String[] f6471c;
    final /* synthetic */ String f6472d;
    final /* synthetic */ ChannelConversationActivity f6473e;

    ca(ChannelConversationActivity channelConversationActivity, String str, String str2, String[] strArr, String str3) {
        this.f6473e = channelConversationActivity;
        this.f6469a = str;
        this.f6470b = str2;
        this.f6471c = strArr;
        this.f6472d = str3;
    }

    public void run() {
        new Handler().postDelayed(new cb(this), 10);
        new Handler().postDelayed(new cc(this), 100);
    }
}
