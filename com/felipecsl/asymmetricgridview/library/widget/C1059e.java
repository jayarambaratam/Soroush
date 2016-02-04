package com.felipecsl.asymmetricgridview.library.widget;

import android.util.Log;
import com.felipecsl.asymmetricgridview.library.C1041b;
import com.felipecsl.asymmetricgridview.library.model.AsymmetricItem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.e */
class C1059e extends C1041b<List<T>, Void, List<RowInfo<T>>> {
    final /* synthetic */ C1058d f3991c;

    C1059e(C1058d c1058d) {
        this.f3991c = c1058d;
    }

    private List<RowInfo<T>> m6286a(int i, List<T> list) {
        List<RowInfo<T>> arrayList = new ArrayList();
        while (!list.isEmpty()) {
            RowInfo a = this.f3991c.m6274b((List) list);
            List<AsymmetricItem> a2 = a.m6252a();
            if (a2.isEmpty()) {
                break;
            }
            for (AsymmetricItem remove : a2) {
                list.remove(remove);
            }
            arrayList.add(a);
            i++;
        }
        return arrayList;
    }

    @SafeVarargs
    protected final List<RowInfo<T>> m6288a(List<T>... listArr) {
        return m6286a(0, listArr[0]);
    }

    protected void m6290a(List<RowInfo<T>> list) {
        for (RowInfo put : list) {
            this.f3991c.f3987d.put(Integer.valueOf(this.f3991c.m6284c()), put);
        }
        if (this.f3991c.f3984a.m6251c()) {
            for (Entry entry : this.f3991c.f3987d.entrySet()) {
                Log.d("AsymmetricGridViewAdapter", "row: " + entry.getKey() + ", items: " + ((RowInfo) entry.getValue()).m6252a().size());
            }
        }
        this.f3991c.notifyDataSetChanged();
    }
}
