package android.support.design.internal;

import android.support.design.C0044h;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/* renamed from: android.support.design.internal.k */
class C0061k extends C0054n {
    public C0061k(LayoutInflater layoutInflater, ViewGroup viewGroup, OnClickListener onClickListener) {
        super(layoutInflater.inflate(C0044h.design_navigation_item, viewGroup, false));
        this.itemView.setOnClickListener(onClickListener);
    }
}
