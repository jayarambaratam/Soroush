package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

public class TextRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnGlobalLayoutListener {
    private TextView f3142a;
    private int f3143b;
    private int f3144c;
    private int f3145d;
    private String f3146e;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f3138a;
        int f3139b;
        int f3140c;
        String f3141d;

        static {
            CREATOR = new C0904k();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3138a = parcel.readInt();
            this.f3139b = parcel.readInt();
            this.f3140c = parcel.readInt();
            this.f3141d = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3138a);
            parcel.writeInt(this.f3139b);
            parcel.writeInt(this.f3140c);
            parcel.writeString(this.f3141d);
        }
    }

    public TextRoundCornerProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextRoundCornerProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void m5377f() {
        this.f3142a.setText(this.f3146e);
    }

    private void m5378g() {
        this.f3142a.setTextColor(this.f3143b);
    }

    private void m5379h() {
        this.f3142a.setTextSize(0, (float) this.f3144c);
    }

    private void m5380i() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f3142a.getLayoutParams();
        marginLayoutParams.setMargins(this.f3145d, 0, this.f3145d, 0);
        this.f3142a.setLayoutParams(marginLayoutParams);
    }

    private void m5381j() {
        m5382k();
        if ((this.f3142a.getMeasuredWidth() + (getTextProgressMargin() * 2)) + this.f3145d < ((int) ((getLayoutWidth() - ((float) (getPadding() * 2))) / (getMax() / getProgress())))) {
            m5383l();
        } else {
            m5384m();
        }
    }

    private void m5382k() {
        LayoutParams layoutParams = (LayoutParams) this.f3142a.getLayoutParams();
        layoutParams.addRule(5, 0);
        layoutParams.addRule(7, 0);
        layoutParams.addRule(0, 0);
        layoutParams.addRule(1, 0);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.removeRule(16);
            layoutParams.removeRule(17);
            layoutParams.removeRule(18);
            layoutParams.removeRule(19);
        }
        this.f3142a.setLayoutParams(layoutParams);
    }

    private void m5383l() {
        LayoutParams layoutParams = (LayoutParams) this.f3142a.getLayoutParams();
        if (m5367e()) {
            layoutParams.addRule(5, C0899f.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(18, C0899f.layout_progress);
            }
        } else {
            layoutParams.addRule(7, C0899f.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(19, C0899f.layout_progress);
            }
        }
        this.f3142a.setLayoutParams(layoutParams);
    }

    private void m5384m() {
        LayoutParams layoutParams = (LayoutParams) this.f3142a.getLayoutParams();
        if (m5367e()) {
            layoutParams.addRule(0, C0899f.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(16, C0899f.layout_progress);
            }
        } else {
            layoutParams.addRule(1, C0899f.layout_progress);
            if (VERSION.SDK_INT >= 17) {
                layoutParams.addRule(17, C0899f.layout_progress);
            }
        }
        this.f3142a.setLayoutParams(layoutParams);
    }

    protected int m5385a() {
        return C0900g.layout_text_round_corner_progress_bar;
    }

    protected void m5386a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0902i.TextRoundCornerProgress);
        this.f3143b = obtainStyledAttributes.getColor(C0902i.TextRoundCornerProgress_rcTextProgressColor, -1);
        this.f3144c = (int) obtainStyledAttributes.getDimension(C0902i.TextRoundCornerProgress_rcTextProgressSize, m5357a(16.0f));
        this.f3145d = (int) obtainStyledAttributes.getDimension(C0902i.TextRoundCornerProgress_rcTextProgressMargin, m5357a(10.0f));
        this.f3146e = obtainStyledAttributes.getString(C0902i.TextRoundCornerProgress_rcTextProgress);
        obtainStyledAttributes.recycle();
    }

    protected void m5387a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z) {
        Drawable a = m5359a(i3);
        int i4 = i - (i2 / 2);
        a.setCornerRadii(new float[]{(float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4});
        if (VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(a);
        } else {
            linearLayout.setBackgroundDrawable(a);
        }
        int i5 = (int) ((f3 - ((float) (i2 * 2))) / (f / f2));
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = i5;
        linearLayout.setLayoutParams(layoutParams);
    }

    protected void m5388b() {
        this.f3142a = (TextView) findViewById(C0899f.tv_progress);
        this.f3142a.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    protected void m5389c() {
        m5377f();
        m5379h();
        m5380i();
        m5381j();
        m5378g();
    }

    public String getProgressText() {
        return this.f3146e;
    }

    public int getTextProgressColor() {
        return this.f3143b;
    }

    public int getTextProgressMargin() {
        return this.f3145d;
    }

    public int getTextProgressSize() {
        return this.f3144c;
    }

    public void onGlobalLayout() {
        if (VERSION.SDK_INT >= 16) {
            this.f3142a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        } else {
            this.f3142a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
        m5381j();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f3143b = savedState.f3138a;
            this.f3144c = savedState.f3139b;
            this.f3145d = savedState.f3140c;
            this.f3146e = savedState.f3141d;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3138a = this.f3143b;
        savedState.f3139b = this.f3144c;
        savedState.f3140c = this.f3145d;
        savedState.f3141d = this.f3146e;
        return savedState;
    }

    public void setProgress(float f) {
        super.setProgress(f);
        m5381j();
    }

    public void setProgressText(String str) {
        this.f3146e = str;
        m5377f();
        m5381j();
    }

    public void setTextProgressColor(int i) {
        this.f3143b = i;
        m5378g();
    }

    public void setTextProgressMargin(int i) {
        this.f3145d = i;
        m5380i();
        m5381j();
    }

    public void setTextProgressSize(int i) {
        this.f3144c = i;
        m5379h();
        m5381j();
    }
}
