package mobi.mmdt.ott.view.conversation.emojisticker.emoji;

import android.app.Activity;
import java.util.ArrayList;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.Emojicon;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.p230b.C2204a;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.emoji.c */
class C2206c implements Runnable {
    final /* synthetic */ Emojicon[] f7265a;
    final /* synthetic */ Activity f7266b;
    final /* synthetic */ C2203a f7267c;

    C2206c(C2203a c2203a, Emojicon[] emojiconArr, Activity activity) {
        this.f7267c = c2203a;
        this.f7265a = emojiconArr;
        this.f7266b = activity;
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f7265a.length; i++) {
            arrayList.add(new C2204a(i, this.f7265a[i]));
        }
        this.f7266b.runOnUiThread(new C2207d(this, arrayList));
    }
}
