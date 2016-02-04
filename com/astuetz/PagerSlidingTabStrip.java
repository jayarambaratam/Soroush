package com.astuetz;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.ViewPager;
import android.support.v4.view.dz;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.astuetz.p062a.C0906b;
import com.astuetz.p062a.C0907c;
import java.util.Locale;

public class PagerSlidingTabStrip extends HorizontalScrollView {
    private static final int[] f3158b;
    private int f3159A;
    private int f3160B;
    private int f3161C;
    private Locale f3162D;
    public dz f3163a;
    private LayoutParams f3164c;
    private LayoutParams f3165d;
    private final C0911d f3166e;
    private LinearLayout f3167f;
    private ViewPager f3168g;
    private int f3169h;
    private int f3170i;
    private float f3171j;
    private Paint f3172k;
    private Paint f3173l;
    private int f3174m;
    private int f3175n;
    private int f3176o;
    private boolean f3177p;
    private boolean f3178q;
    private int f3179r;
    private int f3180s;
    private int f3181t;
    private int f3182u;
    private int f3183v;
    private int f3184w;
    private int f3185x;
    private int f3186y;
    private Typeface f3187z;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f3157a;

        static {
            CREATOR = new C0912e();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3157a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3157a);
        }
    }

    static {
        f3158b = new int[]{16842901, 16842904};
    }

    public PagerSlidingTabStrip(Context context) {
        this(context, null);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagerSlidingTabStrip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3166e = new C0911d();
        this.f3170i = 0;
        this.f3171j = 0.0f;
        this.f3174m = -10066330;
        this.f3175n = 436207616;
        this.f3176o = 436207616;
        this.f3177p = false;
        this.f3178q = true;
        this.f3179r = 52;
        this.f3180s = 8;
        this.f3181t = 2;
        this.f3182u = 12;
        this.f3183v = 24;
        this.f3184w = 1;
        this.f3185x = 12;
        this.f3186y = -10066330;
        this.f3187z = null;
        this.f3159A = 1;
        this.f3160B = 0;
        this.f3161C = C0906b.background_tab;
        setFillViewport(true);
        setWillNotDraw(false);
        this.f3167f = new LinearLayout(context);
        this.f3167f.setOrientation(0);
        this.f3167f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.f3167f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3179r = (int) TypedValue.applyDimension(1, (float) this.f3179r, displayMetrics);
        this.f3180s = (int) TypedValue.applyDimension(1, (float) this.f3180s, displayMetrics);
        this.f3181t = (int) TypedValue.applyDimension(1, (float) this.f3181t, displayMetrics);
        this.f3182u = (int) TypedValue.applyDimension(1, (float) this.f3182u, displayMetrics);
        this.f3183v = (int) TypedValue.applyDimension(1, (float) this.f3183v, displayMetrics);
        this.f3184w = (int) TypedValue.applyDimension(1, (float) this.f3184w, displayMetrics);
        this.f3185x = (int) TypedValue.applyDimension(2, (float) this.f3185x, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f3158b);
        this.f3185x = obtainStyledAttributes.getDimensionPixelSize(0, this.f3185x);
        this.f3186y = obtainStyledAttributes.getColor(1, this.f3186y);
        obtainStyledAttributes.recycle();
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0907c.PagerSlidingTabStrip);
        this.f3174m = obtainStyledAttributes.getColor(0, this.f3174m);
        this.f3175n = obtainStyledAttributes.getColor(1, this.f3175n);
        this.f3176o = obtainStyledAttributes.getColor(2, this.f3176o);
        this.f3180s = obtainStyledAttributes.getDimensionPixelSize(3, this.f3180s);
        this.f3181t = obtainStyledAttributes.getDimensionPixelSize(4, this.f3181t);
        this.f3182u = obtainStyledAttributes.getDimensionPixelSize(5, this.f3182u);
        this.f3183v = obtainStyledAttributes.getDimensionPixelSize(6, this.f3183v);
        this.f3161C = obtainStyledAttributes.getResourceId(8, this.f3161C);
        this.f3177p = obtainStyledAttributes.getBoolean(9, this.f3177p);
        this.f3179r = obtainStyledAttributes.getDimensionPixelSize(7, this.f3179r);
        this.f3178q = obtainStyledAttributes.getBoolean(10, this.f3178q);
        obtainStyledAttributes.recycle();
        this.f3172k = new Paint();
        this.f3172k.setAntiAlias(true);
        this.f3172k.setStyle(Style.FILL);
        this.f3173l = new Paint();
        this.f3173l.setAntiAlias(true);
        this.f3173l.setStrokeWidth((float) this.f3184w);
        this.f3164c = new LayoutParams(-2, -1);
        this.f3165d = new LayoutParams(0, -1, 1.0f);
        if (this.f3162D == null) {
            this.f3162D = getResources().getConfiguration().locale;
        }
    }

    private void m5401a(int i, int i2) {
        View imageButton = new ImageButton(getContext());
        imageButton.setImageResource(i2);
        m5402a(i, imageButton);
    }

    private void m5402a(int i, View view) {
        view.setFocusable(true);
        view.setOnClickListener(new C0909b(this, i));
        view.setPadding(this.f3183v, 0, this.f3183v, 0);
        this.f3167f.addView(view, i, this.f3177p ? this.f3165d : this.f3164c);
    }

    private void m5403a(int i, String str) {
        View textView = new TextView(getContext());
        textView.setText(str);
        textView.setGravity(17);
        textView.setSingleLine();
        m5402a(i, textView);
    }

    private void m5406b() {
        for (int i = 0; i < this.f3169h; i++) {
            View childAt = this.f3167f.getChildAt(i);
            childAt.setBackgroundResource(this.f3161C);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                textView.setTextSize(0, (float) this.f3185x);
                textView.setTypeface(this.f3187z, this.f3159A);
                textView.setTextColor(this.f3186y);
                if (this.f3178q) {
                    if (VERSION.SDK_INT >= 14) {
                        textView.setAllCaps(true);
                    } else {
                        textView.setText(textView.getText().toString().toUpperCase(this.f3162D));
                    }
                }
            }
        }
    }

    private void m5407b(int i, int i2) {
        if (this.f3169h != 0) {
            int left = this.f3167f.getChildAt(i).getLeft() + i2;
            if (i > 0 || i2 > 0) {
                left -= this.f3179r;
            }
            if (left != this.f3160B) {
                this.f3160B = left;
                scrollTo(left, 0);
            }
        }
    }

    public void m5409a() {
        this.f3167f.removeAllViews();
        this.f3169h = this.f3168g.getAdapter().m871b();
        for (int i = 0; i < this.f3169h; i++) {
            if (this.f3168g.getAdapter() instanceof C0910c) {
                m5401a(i, ((C0910c) this.f3168g.getAdapter()).m5410a(i));
            } else {
                m5403a(i, this.f3168g.getAdapter().m877c(i).toString());
            }
        }
        m5406b();
        getViewTreeObserver().addOnGlobalLayoutListener(new C0908a(this));
    }

    public int getDividerColor() {
        return this.f3176o;
    }

    public int getDividerPadding() {
        return this.f3182u;
    }

    public int getIndicatorColor() {
        return this.f3174m;
    }

    public int getIndicatorHeight() {
        return this.f3180s;
    }

    public int getScrollOffset() {
        return this.f3179r;
    }

    public boolean getShouldExpand() {
        return this.f3177p;
    }

    public int getTabBackground() {
        return this.f3161C;
    }

    public int getTabPaddingLeftRight() {
        return this.f3183v;
    }

    public int getTextColor() {
        return this.f3186y;
    }

    public int getTextSize() {
        return this.f3185x;
    }

    public int getUnderlineColor() {
        return this.f3175n;
    }

    public int getUnderlineHeight() {
        return this.f3181t;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f3169h != 0) {
            int height = getHeight();
            this.f3172k.setColor(this.f3174m);
            View childAt = this.f3167f.getChildAt(this.f3170i);
            float left = (float) childAt.getLeft();
            float right = (float) childAt.getRight();
            if (this.f3171j > 0.0f && this.f3170i < this.f3169h - 1) {
                childAt = this.f3167f.getChildAt(this.f3170i + 1);
                float left2 = (float) childAt.getLeft();
                left = (left * (1.0f - this.f3171j)) + (left2 * this.f3171j);
                right = (((float) childAt.getRight()) * this.f3171j) + ((1.0f - this.f3171j) * right);
            }
            canvas.drawRect(left, (float) (height - this.f3180s), right, (float) height, this.f3172k);
            this.f3172k.setColor(this.f3175n);
            canvas.drawRect(0.0f, (float) (height - this.f3181t), (float) this.f3167f.getWidth(), (float) height, this.f3172k);
            this.f3173l.setColor(this.f3176o);
            for (int i = 0; i < this.f3169h - 1; i++) {
                childAt = this.f3167f.getChildAt(i);
                canvas.drawLine((float) childAt.getRight(), (float) this.f3182u, (float) childAt.getRight(), (float) (height - this.f3182u), this.f3173l);
            }
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f3170i = savedState.f3157a;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3157a = this.f3170i;
        return savedState;
    }

    public void setAllCaps(boolean z) {
        this.f3178q = z;
    }

    public void setDividerColor(int i) {
        this.f3176o = i;
        invalidate();
    }

    public void setDividerColorResource(int i) {
        this.f3176o = getResources().getColor(i);
        invalidate();
    }

    public void setDividerPadding(int i) {
        this.f3182u = i;
        invalidate();
    }

    public void setIndicatorColor(int i) {
        this.f3174m = i;
        invalidate();
    }

    public void setIndicatorColorResource(int i) {
        this.f3174m = getResources().getColor(i);
        invalidate();
    }

    public void setIndicatorHeight(int i) {
        this.f3180s = i;
        invalidate();
    }

    public void setOnPageChangeListener(dz dzVar) {
        this.f3163a = dzVar;
    }

    public void setScrollOffset(int i) {
        this.f3179r = i;
        invalidate();
    }

    public void setShouldExpand(boolean z) {
        this.f3177p = z;
        requestLayout();
    }

    public void setTabBackground(int i) {
        this.f3161C = i;
    }

    public void setTabPaddingLeftRight(int i) {
        this.f3183v = i;
        m5406b();
    }

    public void setTextColor(int i) {
        this.f3186y = i;
        m5406b();
    }

    public void setTextColorResource(int i) {
        this.f3186y = getResources().getColor(i);
        m5406b();
    }

    public void setTextSize(int i) {
        this.f3185x = i;
        m5406b();
    }

    public void setUnderlineColor(int i) {
        this.f3175n = i;
        invalidate();
    }

    public void setUnderlineColorResource(int i) {
        this.f3175n = getResources().getColor(i);
        invalidate();
    }

    public void setUnderlineHeight(int i) {
        this.f3181t = i;
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        this.f3168g = viewPager;
        if (viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
        viewPager.setOnPageChangeListener(this.f3166e);
        m5409a();
    }
}
