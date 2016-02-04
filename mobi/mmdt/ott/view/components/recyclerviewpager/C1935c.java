package mobi.mmdt.ott.view.components.recyclerviewpager;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

/* renamed from: mobi.mmdt.ott.view.components.recyclerviewpager.c */
public class C1935c<VH extends ViewHolder> extends Adapter<VH> {
    Adapter<VH> f6219a;
    private final RecyclerViewPager f6220b;

    public C1935c(RecyclerViewPager recyclerViewPager, Adapter<VH> adapter) {
        this.f6219a = adapter;
        this.f6220b = recyclerViewPager;
        setHasStableIds(this.f6219a.hasStableIds());
    }

    public int getItemCount() {
        return this.f6219a.getItemCount();
    }

    public long getItemId(int i) {
        return this.f6219a.getItemId(i);
    }

    public int getItemViewType(int i) {
        return this.f6219a.getItemViewType(i);
    }

    public void onBindViewHolder(VH vh, int i) {
        this.f6219a.onBindViewHolder(vh, i);
        View view = vh.itemView;
        LayoutParams layoutParams = view.getLayoutParams() == null ? new LayoutParams(-1, -1) : view.getLayoutParams();
        if (this.f6220b.getLayoutManager().canScrollHorizontally()) {
            layoutParams.width = (this.f6220b.getWidth() - this.f6220b.getPaddingLeft()) - this.f6220b.getPaddingRight();
        } else {
            layoutParams.height = (this.f6220b.getHeight() - this.f6220b.getPaddingTop()) - this.f6220b.getPaddingBottom();
        }
        view.setLayoutParams(layoutParams);
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.f6219a.onCreateViewHolder(viewGroup, i);
    }

    public void registerAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
        super.registerAdapterDataObserver(adapterDataObserver);
        this.f6219a.registerAdapterDataObserver(adapterDataObserver);
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(z);
        this.f6219a.setHasStableIds(z);
    }

    public void unregisterAdapterDataObserver(AdapterDataObserver adapterDataObserver) {
        super.unregisterAdapterDataObserver(adapterDataObserver);
        this.f6219a.unregisterAdapterDataObserver(adapterDataObserver);
    }
}
