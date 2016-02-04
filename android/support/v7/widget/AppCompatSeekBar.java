package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p019a.C0359b;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
    private AppCompatSeekBarHelper mAppCompatSeekBarHelper;
    private TintManager mTintManager;

    public AppCompatSeekBar(Context context) {
        this(context, null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0359b.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTintManager = TintManager.get(context);
        this.mAppCompatSeekBarHelper = new AppCompatSeekBarHelper(this, this.mTintManager);
        this.mAppCompatSeekBarHelper.loadFromAttributes(attributeSet, i);
    }
}
