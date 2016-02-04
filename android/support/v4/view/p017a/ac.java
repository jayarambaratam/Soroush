package android.support.v4.view.p017a;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.view.a.ac */
class ac implements ai {
    final /* synthetic */ C0303z f1286a;
    final /* synthetic */ ab f1287b;

    ac(ab abVar, C0303z c0303z) {
        this.f1287b = abVar;
        this.f1286a = c0303z;
    }

    public Object m1874a(int i) {
        C0284g a = this.f1286a.m2200a(i);
        return a == null ? null : a.m1945a();
    }

    public List<Object> m1875a(String str, int i) {
        List a = this.f1286a.m2202a(str, i);
        List<Object> arrayList = new ArrayList();
        int size = a.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((C0284g) a.get(i2)).m1945a());
        }
        return arrayList;
    }

    public boolean m1876a(int i, int i2, Bundle bundle) {
        return this.f1286a.m2203a(i, i2, bundle);
    }
}
