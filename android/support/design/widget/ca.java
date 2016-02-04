package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.cb;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class ca extends LinearLayout {
    final /* synthetic */ TabLayout f524a;
    private int f525b;
    private final Paint f526c;
    private int f527d;
    private float f528e;
    private int f529f;
    private int f530g;
    private cn f531h;

    ca(TabLayout tabLayout, Context context) {
        this.f524a = tabLayout;
        super(context);
        this.f527d = -1;
        this.f529f = -1;
        this.f530g = -1;
        setWillNotDraw(false);
        this.f526c = new Paint();
    }

    private void m637b(int i, int i2) {
        if (i != this.f529f || i2 != this.f530g) {
            this.f529f = i;
            this.f530g = i2;
            cb.m2417d(this);
        }
    }

    private void m638c() {
        int i;
        int i2;
        View childAt = getChildAt(this.f527d);
        if (childAt == null || childAt.getWidth() <= 0) {
            i = -1;
            i2 = -1;
        } else {
            i2 = childAt.getLeft();
            i = childAt.getRight();
            if (this.f528e > 0.0f && this.f527d < getChildCount() - 1) {
                View childAt2 = getChildAt(this.f527d + 1);
                i2 = (int) ((((float) i2) * (1.0f - this.f528e)) + (this.f528e * ((float) childAt2.getLeft())));
                i = (int) ((((float) i) * (1.0f - this.f528e)) + (((float) childAt2.getRight()) * this.f528e));
            }
        }
        m637b(i2, i);
    }

    void m639a(int i) {
        if (this.f526c.getColor() != i) {
            this.f526c.setColor(i);
            cb.m2417d(this);
        }
    }

    void m640a(int i, float f) {
        this.f527d = i;
        this.f528e = f;
        m638c();
    }

    void m641a(int i, int i2) {
        int i3;
        int i4;
        Object obj = cb.m2428h(this) == 1 ? 1 : null;
        View childAt = getChildAt(i);
        int left = childAt.getLeft();
        int right = childAt.getRight();
        if (Math.abs(i - this.f527d) <= 1) {
            i3 = this.f529f;
            i4 = this.f530g;
        } else {
            int b = this.f524a.m437d(24);
            if (i < this.f527d) {
                if (obj != null) {
                    i4 = left - b;
                    i3 = i4;
                } else {
                    i4 = right + b;
                    i3 = i4;
                }
            } else if (obj != null) {
                i4 = right + b;
                i3 = i4;
            } else {
                i4 = left - b;
                i3 = i4;
            }
        }
        if (i3 != left || i4 != right) {
            cn a = this.f524a.f408w = dk.m755a();
            a.m684a(C0072a.f429b);
            a.m680a(i2);
            a.m679a(0.0f, 1.0f);
            a.m683a(new cb(this, i3, left, i4, right));
            a.m682a(new cc(this, i));
            a.m678a();
            this.f531h = a;
        }
    }

    boolean m642a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getWidth() <= 0) {
                return true;
            }
        }
        return false;
    }

    float m643b() {
        return ((float) this.f527d) + this.f528e;
    }

    void m644b(int i) {
        if (this.f525b != i) {
            this.f525b = i;
            cb.m2417d(this);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f529f >= 0 && this.f530g > this.f529f) {
            canvas.drawRect((float) this.f529f, (float) (getHeight() - this.f525b), (float) this.f530g, (float) getHeight(), this.f526c);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f531h == null || !this.f531h.m685b()) {
            m638c();
            return;
        }
        this.f531h.m688e();
        m641a(this.f527d, Math.round(((float) this.f531h.m690g()) * (1.0f - this.f531h.m689f())));
    }

    protected void onMeasure(int i, int i2) {
        boolean z = false;
        super.onMeasure(i, i2);
        if (MeasureSpec.getMode(i) == 1073741824 && this.f524a.f404s == 1 && this.f524a.f403r == 1) {
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = 0;
            while (i3 < childCount) {
                View childAt = getChildAt(i3);
                i3++;
                i4 = childAt.getVisibility() == 0 ? Math.max(i4, childAt.getMeasuredWidth()) : i4;
            }
            if (i4 > 0) {
                if (i4 * childCount <= getMeasuredWidth() - (this.f524a.m437d(16) * 2)) {
                    i3 = 0;
                    while (i3 < childCount) {
                        boolean z2;
                        LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
                        if (layoutParams.width == i4 && layoutParams.weight == 0.0f) {
                            z2 = z;
                        } else {
                            layoutParams.width = i4;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                        i3++;
                        z = z2;
                    }
                } else {
                    this.f524a.f403r = 0;
                    this.f524a.m427a(false);
                    z = true;
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }
    }
}
