package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;
import java.util.List;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.a */
public class C2455a extends Adapter<C2458d> {
    private List<C2456b> f7988a;
    private int f7989b;
    private boolean f7990c;
    private final Context f7991d;
    private RecyclerView f7992e;

    public C2455a(Context context, RecyclerView recyclerView) {
        this.f7991d = context;
        this.f7992e = recyclerView;
        this.f7989b = 8;
    }

    private void m10722a() {
        for (int i = 0; i < this.f7988a.size(); i++) {
            if (((C2456b) this.f7988a.get(i)).f7996d) {
                notifyItemChanged(i);
            }
        }
    }

    public C2456b m10723a(int i) {
        return (C2456b) this.f7988a.get(i);
    }

    public C2458d m10724a(ViewGroup viewGroup, int i) {
        return new C2458d(i == 1 ? LayoutInflater.from(viewGroup.getContext()).inflate(2130968771, viewGroup, false) : LayoutInflater.from(viewGroup.getContext()).inflate(2130968772, viewGroup, false));
    }

    public void m10725a(List<C2456b> list) {
        this.f7988a = new ArrayList(list);
        notifyDataSetChanged();
        if (this.f7992e.getVerticalScrollbarPosition() != 0) {
            this.f7992e.scrollToPosition(0);
        }
    }

    public void m10726a(C2458d c2458d, int i) {
        boolean z = true;
        C2456b c2456b = (C2456b) this.f7988a.get(i);
        View view = c2458d.itemView;
        c2458d.m10730a(c2456b.f7997e, c2456b.f7998f);
        LayoutParams a = C2462f.m10776a(view.getLayoutParams());
        if (c2456b.f7996d) {
            a.b = this.f7989b;
            if (a.m10772f() || (this.f7990c && !a.m10773g())) {
                a.width = -1;
            } else {
                a.width = -2;
            }
            a.f = !this.f7990c;
            if (this.f7990c) {
                z = false;
            }
            a.e = z;
        }
        a.m10768b(c2456b.f7993a == 0 ? C2473r.f8039a : C2460e.f8004a);
        a.m10767a(c2456b.f7994b);
        view.setLayoutParams(a);
    }

    public void m10727a(boolean z) {
        this.f7990c = z;
        m10722a();
    }

    public void m10728b(int i) {
        this.f7989b = i;
        m10722a();
    }

    public int getItemCount() {
        return this.f7988a.size();
    }

    public int getItemViewType(int i) {
        return ((C2456b) this.f7988a.get(i)).f7996d ? 1 : 0;
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m10726a((C2458d) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10724a(viewGroup, i);
    }
}
