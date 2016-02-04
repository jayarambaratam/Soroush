package android.support.v4.view.p017a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.ae */
class ae implements al {
    final /* synthetic */ C0303z f1288a;
    final /* synthetic */ ad f1289b;

    ae(ad adVar, C0303z c0303z) {
        this.f1289b = adVar;
        this.f1288a = c0303z;
    }

    public Object m1882a(int i) {
        C0284g a = this.f1288a.m2200a(i);
        return a == null ? null : a.m1945a();
    }

    public List<Object> m1883a(String str, int i) {
        List a = this.f1288a.m2202a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0284g) a.get(i2)).m1945a());
        }
        return arrayList;
    }

    public boolean m1884a(int i, int i2, Bundle bundle) {
        return this.f1288a.m2203a(i, i2, bundle);
    }

    public Object m1885b(int i) {
        C0284g b = this.f1288a.m2204b(i);
        return b == null ? null : b.m1945a();
    }
}
