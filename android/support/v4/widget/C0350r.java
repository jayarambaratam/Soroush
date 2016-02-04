package android.support.v4.widget;

import android.database.DataSetObserver;

/* renamed from: android.support.v4.widget.r */
class C0350r extends DataSetObserver {
    final /* synthetic */ C0335o f1701a;

    private C0350r(C0335o c0335o) {
        this.f1701a = c0335o;
    }

    public void onChanged() {
        this.f1701a.mDataValid = true;
        this.f1701a.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.f1701a.mDataValid = false;
        this.f1701a.notifyDataSetInvalidated();
    }
}
