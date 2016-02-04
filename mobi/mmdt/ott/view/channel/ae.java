package mobi.mmdt.ott.view.channel;

import java.util.Iterator;
import mobi.mmdt.ott.view.channel.p183b.C1723a;
import mobi.mmdt.ott.view.channel.p183b.C1725c;

class ae implements Runnable {
    final /* synthetic */ String f5681a;
    final /* synthetic */ boolean f5682b;
    final /* synthetic */ ad f5683c;

    ae(ad adVar, String str, boolean z) {
        this.f5683c = adVar;
        this.f5681a = str;
        this.f5682b = z;
    }

    public void run() {
        Iterator it = this.f5683c.m8646c().iterator();
        while (it.hasNext()) {
            C1723a c1723a = (C1723a) it.next();
            if (c1723a.m8659g() == 1) {
                C1725c c1725c = (C1725c) c1723a;
                if (c1725c.m8668d().equals(this.f5681a)) {
                    c1725c.m8665a(this.f5682b);
                    break;
                }
            }
        }
        this.f5683c.f5675c.notifyDataSetChanged();
    }
}
