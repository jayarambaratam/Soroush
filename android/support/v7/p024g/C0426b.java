package android.support.v7.p024g;

import java.util.Comparator;

/* renamed from: android.support.v7.g.b */
public abstract class C0426b<T2> implements Comparator<T2> {
    public abstract boolean areContentsTheSame(T2 t2, T2 t22);

    public abstract boolean areItemsTheSame(T2 t2, T2 t22);

    public abstract int compare(T2 t2, T2 t22);

    public abstract void onChanged(int i, int i2);

    public abstract void onInserted(int i, int i2);

    public abstract void onMoved(int i, int i2);

    public abstract void onRemoved(int i, int i2);
}
