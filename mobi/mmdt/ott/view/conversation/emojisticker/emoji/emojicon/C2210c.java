package mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import java.lang.ref.WeakReference;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.c */
class C2210c extends DynamicDrawableSpan {
    private final Context f7285a;
    private final int f7286b;
    private final int f7287c;
    private final int f7288d;
    private int f7289e;
    private int f7290f;
    private int f7291g;
    private Drawable f7292h;
    private WeakReference<Drawable> f7293i;

    public C2210c(Context context, int i, int i2, int i3, int i4) {
        super(i3);
        this.f7285a = context;
        this.f7286b = i;
        this.f7287c = i2;
        this.f7289e = i2;
        this.f7290f = i2;
        this.f7288d = i4;
    }

    private Drawable m10083a() {
        if (this.f7293i == null || this.f7293i.get() == null) {
            this.f7293i = new WeakReference(getDrawable());
        }
        return (Drawable) this.f7293i.get();
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
        Drawable a = m10083a();
        canvas.save();
        int i6 = i5 - a.getBounds().bottom;
        if (this.mVerticalAlignment == 1) {
            i6 = ((((i5 - i3) / 2) + i3) - ((a.getBounds().bottom - a.getBounds().top) / 2)) - this.f7291g;
        }
        canvas.translate(f, (float) i6);
        a.draw(canvas);
        canvas.restore();
    }

    public Drawable getDrawable() {
        if (this.f7292h == null) {
            try {
                this.f7292h = this.f7285a.getResources().getDrawable(this.f7286b);
                this.f7289e = this.f7287c;
                this.f7290f = (this.f7289e * this.f7292h.getIntrinsicWidth()) / this.f7292h.getIntrinsicHeight();
                this.f7291g = (this.f7288d - this.f7289e) / 2;
                this.f7292h.setBounds(0, this.f7291g, this.f7290f, this.f7291g + this.f7289e);
            } catch (Exception e) {
            }
        }
        return this.f7292h;
    }
}
