package mobi.mmdt.ott.view.conversation.groupinfo;

import java.util.ArrayList;
import java.util.Map.Entry;

/* renamed from: mobi.mmdt.ott.view.conversation.groupinfo.b */
class C2251b implements Runnable {
    final /* synthetic */ C2249a f7467a;

    C2251b(C2249a c2249a) {
        this.f7467a = c2249a;
    }

    public void run() {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : this.f7467a.f7424a.m9286l().entrySet()) {
            if (((Boolean) entry.getValue()).booleanValue()) {
                arrayList.add(entry.getKey());
            }
        }
        this.f7467a.f7424a.m10170a(arrayList);
    }
}
