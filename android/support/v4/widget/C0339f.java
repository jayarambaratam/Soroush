package android.support.v4.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.shapes.OvalShape;

/* renamed from: android.support.v4.widget.f */
class C0339f extends OvalShape {
    final /* synthetic */ C0338e f1693a;
    private RadialGradient f1694b;
    private Paint f1695c;
    private int f1696d;

    public C0339f(C0338e c0338e, int i, int i2) {
        this.f1693a = c0338e;
        this.f1695c = new Paint();
        c0338e.f1692b = i;
        this.f1696d = i2;
        this.f1694b = new RadialGradient((float) (this.f1696d / 2), (float) (this.f1696d / 2), (float) c0338e.f1692b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
        this.f1695c.setShader(this.f1694b);
    }

    public void draw(Canvas canvas, Paint paint) {
        int width = this.f1693a.getWidth();
        int height = this.f1693a.getHeight();
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f1696d / 2) + this.f1693a.f1692b), this.f1695c);
        canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f1696d / 2), paint);
    }
}
