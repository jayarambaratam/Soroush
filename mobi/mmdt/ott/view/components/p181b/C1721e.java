package mobi.mmdt.ott.view.components.p181b;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mobi.mmdt.ott.view.components.b.e */
public abstract class C1721e extends Adapter<C1712b> {
    private LayoutInflater f5687a;
    protected List<C1722f> f5688b;

    public C1721e(Context context) {
        this.f5688b = new ArrayList();
        this.f5687a = LayoutInflater.from(context);
    }

    public LayoutInflater m8654a() {
        return this.f5687a;
    }

    public C1722f m8655a(int i) {
        return (C1722f) this.f5688b.get(i);
    }

    public void m8656a(List<C1722f> list) {
        this.f5688b.clear();
        this.f5688b.addAll(list);
        notifyDataSetChanged();
    }

    public void m8657a(C1712b c1712b, int i) {
        c1712b.m8621b((C1722f) this.f5688b.get(i));
    }

    public int getItemCount() {
        return this.f5688b.size();
    }

    public int getItemViewType(int i) {
        return ((C1722f) this.f5688b.get(i)).m8659g();
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m8657a((C1712b) viewHolder, i);
    }
}
