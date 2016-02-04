package com.cocosw.bottomsheet;

import android.database.DataSetObserver;

/* renamed from: com.cocosw.bottomsheet.x */
class C1014x extends DataSetObserver {
    final /* synthetic */ C1013w f3831a;

    C1014x(C1013w c1013w) {
        this.f3831a = c1013w;
    }

    public void onChanged() {
        this.f3831a.f3813b = !this.f3831a.f3816e.isEmpty();
        this.f3831a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f3831a.f3813b = false;
        this.f3831a.notifyDataSetInvalidated();
    }
}
