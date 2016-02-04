package jp.wasabeef.recyclerview.animators;

import android.support.v4.view.cb;
import android.support.v7.widget.RecyclerView.ViewHolder;
import jp.wasabeef.recyclerview.animators.BaseItemAnimator.DefaultAddVpaListener;
import jp.wasabeef.recyclerview.animators.BaseItemAnimator.DefaultRemoveVpaListener;

public class SlideInLeftAnimator extends BaseItemAnimator {
    protected void animateAddImpl(ViewHolder viewHolder) {
        cb.m2442s(viewHolder.itemView).m2803b(0.0f).m2799a(getAddDuration()).m2800a(new DefaultAddVpaListener(viewHolder)).m2807c();
    }

    protected void animateRemoveImpl(ViewHolder viewHolder) {
        cb.m2442s(viewHolder.itemView).m2803b((float) (-viewHolder.itemView.getRootView().getWidth())).m2799a(getRemoveDuration()).m2800a(new DefaultRemoveVpaListener(viewHolder)).m2807c();
    }

    protected void preAnimateAddImpl(ViewHolder viewHolder) {
        cb.m2393a(viewHolder.itemView, (float) (-viewHolder.itemView.getRootView().getWidth()));
    }
}
