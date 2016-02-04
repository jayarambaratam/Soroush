package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class as implements Callback {
    final /* synthetic */ ap f1600a;

    as(ap apVar) {
        this.f1600a = apVar;
    }

    public void invalidateDrawable(Drawable drawable) {
        this.f1600a.invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        this.f1600a.scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        this.f1600a.unscheduleSelf(runnable);
    }
}
