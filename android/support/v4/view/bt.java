package android.support.v4.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class bt {
    private DataSetObservable f689a;

    public bt() {
        this.f689a = new DataSetObservable();
    }

    public int m860a(Object obj) {
        return -1;
    }

    public Parcelable m861a() {
        return null;
    }

    public Object m862a(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public Object m863a(ViewGroup viewGroup, int i) {
        return m862a((View) viewGroup, i);
    }

    public void m864a(DataSetObserver dataSetObserver) {
        this.f689a.registerObserver(dataSetObserver);
    }

    public void m865a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m866a(View view) {
    }

    public void m867a(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void m868a(ViewGroup viewGroup) {
        m866a((View) viewGroup);
    }

    public void m869a(ViewGroup viewGroup, int i, Object obj) {
        m867a((View) viewGroup, i, obj);
    }

    public abstract boolean m870a(View view, Object obj);

    public abstract int m871b();

    public void m872b(DataSetObserver dataSetObserver) {
        this.f689a.unregisterObserver(dataSetObserver);
    }

    public void m873b(View view) {
    }

    public void m874b(View view, int i, Object obj) {
    }

    public void m875b(ViewGroup viewGroup) {
        m873b((View) viewGroup);
    }

    public void m876b(ViewGroup viewGroup, int i, Object obj) {
        m874b((View) viewGroup, i, obj);
    }

    public CharSequence m877c(int i) {
        return null;
    }

    public void m878c() {
        this.f689a.notifyChanged();
    }

    public float m879d(int i) {
        return 1.0f;
    }
}
