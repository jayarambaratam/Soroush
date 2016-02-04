package jp.wasabeef.recyclerview.animators;

import android.support.v4.view.cb;
import android.support.v7.widget.RecyclerView.ViewHolder;
import jp.wasabeef.recyclerview.animators.BaseItemAnimator.DefaultAddVpaListener;
import jp.wasabeef.recyclerview.animators.BaseItemAnimator.DefaultRemoveVpaListener;

public class ScaleInTopAnimator extends BaseItemAnimator {
    protected void animateAddImpl(ViewHolder viewHolder) {
        cb.m2442s(viewHolder.itemView).m2810f(1.0f).m2811g(1.0f).m2799a(getAddDuration()).m2800a(new DefaultAddVpaListener(viewHolder)).m2807c();
    }

    protected void animateRemoveImpl(ViewHolder viewHolder) {
        cb.m2442s(viewHolder.itemView).m2810f(0.0f).m2811g(0.0f).m2799a(getRemoveDuration()).m2800a(new DefaultRemoveVpaListener(viewHolder)).m2807c();
    }

    protected void preAnimateAddImpl(ViewHolder viewHolder) {
        viewHolder.itemView.setPivotY(0.0f);
        cb.m2427g(viewHolder.itemView, 0.0f);
        cb.m2429h(viewHolder.itemView, 0.0f);
    }

    protected void preAnimateRemoveImpl(ViewHolder viewHolder) {
        viewHolder.itemView.setPivotY(0.0f);
    }
}
