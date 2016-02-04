package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

class TintContextWrapper extends ContextWrapper {
    private Resources mResources;

    class TintResources extends ResourcesWrapper {
        private final TintManager mTintManager;

        public TintResources(Resources resources, TintManager tintManager) {
            super(resources);
            this.mTintManager = tintManager;
        }

        public Drawable getDrawable(int i) {
            Drawable drawable = super.getDrawable(i);
            if (drawable != null) {
                this.mTintManager.tintDrawableUsingColorFilter(i, drawable);
            }
            return drawable;
        }
    }

    private TintContextWrapper(Context context) {
        super(context);
    }

    public static Context wrap(Context context) {
        return !(context instanceof TintContextWrapper) ? new TintContextWrapper(context) : context;
    }

    public Resources getResources() {
        if (this.mResources == null) {
            this.mResources = new TintResources(super.getResources(), TintManager.get(this));
        }
        return this.mResources;
    }
}
