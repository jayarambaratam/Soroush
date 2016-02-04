package mobi.mmdt.ott;

import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ConcurrentHashMap;
import mobi.mmdt.ott.provider.p169c.C1583c;

/* renamed from: mobi.mmdt.ott.b */
class C1166b implements Runnable {
    final /* synthetic */ MyApplication f4260a;

    C1166b(MyApplication myApplication) {
        this.f4260a = myApplication;
    }

    public void run() {
        Thread.currentThread().setPriority(1);
        this.f4260a.f4175f = new ConcurrentHashMap();
        for (SimpleEntry simpleEntry : C1583c.m7980b(this.f4260a.getApplicationContext())) {
            this.f4260a.f4175f.put(simpleEntry.getKey(), simpleEntry.getValue());
        }
    }
}
