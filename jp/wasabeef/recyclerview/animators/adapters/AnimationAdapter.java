package jp.wasabeef.recyclerview.animators.adapters;

import android.animation.Animator;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import jp.wasabeef.recyclerview.animators.internal.ViewHelper;
import org.apache.http.myHttp.HttpStatus;

public abstract class AnimationAdapter extends Adapter<ViewHolder> {
    private boolean isFirstOnly;
    private Adapter<ViewHolder> mAdapter;
    private int mDuration;
    private Interpolator mInterpolator;
    private int mLastPosition;

    public AnimationAdapter(Adapter<ViewHolder> adapter) {
        this.mDuration = HttpStatus.SC_MULTIPLE_CHOICES;
        this.mInterpolator = new LinearInterpolator();
        this.mLastPosition = -1;
        this.isFirstOnly = true;
        this.mAdapter = adapter;
    }

    protected abstract Animator[] getAnimators(View view);

    public int getItemCount() {
        return this.mAdapter.getItemCount();
    }

    public int getItemViewType(int i) {
        return this.mAdapter.getItemViewType(i);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        this.mAdapter.onBindViewHolder(viewHolder, i);
        if (!this.isFirstOnly || i > this.mLastPosition) {
            for (Animator animator : getAnimators(viewHolder.itemView)) {
                animator.setDuration((long) this.mDuration).start();
                animator.setInterpolator(this.mInterpolator);
            }
            this.mLastPosition = i;
            return;
        }
        ViewHelper.clear(viewHolder.itemView);
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return this.mAdapter.onCreateViewHolder(viewGroup, i);
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setFirstOnly(boolean z) {
        this.isFirstOnly = z;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public void setStartPosition(int i) {
        this.mLastPosition = i;
    }
}
