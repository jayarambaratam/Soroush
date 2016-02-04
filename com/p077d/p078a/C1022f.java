package com.p077d.p078a;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;

/* renamed from: com.d.a.f */
class C1022f extends OnScrollListener {
    C1018b f3859a;
    final /* synthetic */ C1018b f3860b;

    C1022f(C1018b c1018b, C1018b c1018b2) {
        this.f3860b = c1018b;
        this.f3859a = c1018b2;
    }

    public float m6157a(RecyclerView recyclerView) {
        int findLastCompletelyVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
        View childAt = recyclerView.getChildAt(0);
        if (childAt == null) {
            return 0.0f;
        }
        int height = recyclerView.getHeight() / recyclerView.getChildViewHolder(childAt).itemView.getHeight();
        int itemCount = recyclerView.getAdapter().getItemCount();
        height = itemCount - height;
        findLastCompletelyVisibleItemPosition -= (itemCount - height) - 1;
        if (this.f3860b.f3847j != null && this.f3860b.f3847j.getVisibility() == 0) {
            this.f3860b.f3847j.f3837a.setText(this.f3860b.f3847j.m6140a(Integer.valueOf(findLastCompletelyVisibleItemPosition), recyclerView.getAdapter()));
        }
        return ((float) findLastCompletelyVisibleItemPosition) / ((float) height);
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (!this.f3860b.f3845h) {
            return;
        }
        if (i == 0) {
            this.f3860b.f3851n.f3854b = System.currentTimeMillis() + ((long) this.f3860b.f3844g);
            this.f3860b.f3851n.f3855c = true;
        } else if (i == 1) {
            this.f3860b.f3851n.f3855c = false;
            this.f3859a.m6146c();
        }
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        ViewHelper.setY(this.f3860b.f3840c, m6157a(recyclerView) * ((float) (this.f3859a.getHeight() - this.f3860b.f3840c.getHeight())));
        if (this.f3860b.f3847j != null && this.f3860b.f3847j.getVisibility() == 0) {
            this.f3860b.f3847j.setScroll(m6157a(recyclerView) * ((float) (this.f3859a.getHeight() - this.f3860b.f3840c.getHeight())));
        }
    }
}
