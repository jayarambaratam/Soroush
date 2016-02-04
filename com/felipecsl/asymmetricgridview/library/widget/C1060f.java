package com.felipecsl.asymmetricgridview.library.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* renamed from: com.felipecsl.asymmetricgridview.library.widget.f */
public class C1060f extends Drawable {
    private int f3992a;
    private final Paint f3993b;

    public C1060f(ColorDrawable colorDrawable) {
        this.f3993b = new Paint();
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Config.ARGB_8888);
        colorDrawable.draw(new Canvas(createBitmap));
        this.f3992a = createBitmap.getPixel(0, 0);
        createBitmap.recycle();
    }

    public void draw(Canvas canvas) {
        if ((this.f3992a >>> 24) != 0) {
            this.f3993b.setColor(this.f3992a);
            canvas.drawRect(getBounds(), this.f3993b);
        }
    }

    public int getOpacity() {
        return this.f3992a >>> 24;
    }

    public void setAlpha(int i) {
        if (i != (this.f3992a >>> 24)) {
            this.f3992a = (this.f3992a & 16777215) | (i << 24);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
