package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.cb;
import android.support.v7.p019a.C0359b;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class AppCompatRatingBar extends RatingBar {
    private AppCompatProgressBarHelper mAppCompatProgressBarHelper;
    private TintManager mTintManager;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0359b.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTintManager = TintManager.get(context);
        this.mAppCompatProgressBarHelper = new AppCompatProgressBarHelper(this, this.mTintManager);
        this.mAppCompatProgressBarHelper.loadFromAttributes(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap sampleTime = this.mAppCompatProgressBarHelper.getSampleTime();
        if (sampleTime != null) {
            setMeasuredDimension(cb.m2390a(sampleTime.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
