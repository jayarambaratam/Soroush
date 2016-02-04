package mobi.mmdt.ott.view.components.p181b;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/* renamed from: mobi.mmdt.ott.view.components.b.a */
public abstract class C1786a extends C1785m<C1712b> {
    private LayoutInflater f5776j;

    public C1786a(Context context) {
        super(context, null, 0);
        this.f5776j = LayoutInflater.from(context);
    }

    public LayoutInflater m8750a() {
        return this.f5776j;
    }

    public C1712b m8751a(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1722f m8752a(int i) {
        return m8753a((Cursor) m8746b(i), i);
    }

    protected abstract C1722f m8753a(Cursor cursor, int i);

    public void m8755a(C1712b c1712b, Cursor cursor, int i) {
        c1712b.m8621b(m8753a(cursor, i));
    }

    public int getItemCount() {
        return m8745b() != null ? m8745b().getCount() : 0;
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m8751a(viewGroup, i);
    }
}
