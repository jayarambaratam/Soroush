package mobi.mmdt.ott;

import android.app.FragmentManager;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2212b;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2213c;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2214d;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2215e;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2216f;
import mobi.mmdt.ott.view.p178a.p179a.C1653a;

/* renamed from: mobi.mmdt.ott.f */
class C1315f implements Runnable {
    final /* synthetic */ FragmentManager f4586a;
    final /* synthetic */ MyApplication f4587b;

    C1315f(MyApplication myApplication, FragmentManager fragmentManager) {
        this.f4587b = myApplication;
        this.f4586a = fragmentManager;
    }

    public void run() {
        this.f4587b.f4170a = C1653a.m8398a(this.f4586a, 0.2f);
        this.f4587b.m6447a(C2212b.f7297a);
        this.f4587b.m6447a(C2213c.f7298a);
        this.f4587b.m6447a(C2214d.f7299a);
        this.f4587b.m6447a(C2215e.f7300a);
        this.f4587b.m6447a(C2216f.f7301a);
    }
}
