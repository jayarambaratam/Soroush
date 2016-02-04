package jp.wasabeef.recyclerview.animators.holder;

import android.support.v4.view.fc;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public abstract class AnimateViewHolder extends ViewHolder {
    public AnimateViewHolder(View view) {
        super(view);
    }

    public abstract void animateAddImpl(fc fcVar);

    public abstract void animateRemoveImpl(fc fcVar);

    public void preAnimateAddImpl() {
    }

    public void preAnimateRemoveImpl() {
    }
}
