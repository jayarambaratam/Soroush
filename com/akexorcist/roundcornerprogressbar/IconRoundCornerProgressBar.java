package com.akexorcist.roundcornerprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.akexorcist.roundcornerprogressbar.common.BaseRoundCornerProgressBar;

public class IconRoundCornerProgressBar extends BaseRoundCornerProgressBar implements OnClickListener {
    private ImageView f3126a;
    private int f3127b;
    private int f3128c;
    private int f3129d;
    private int f3130e;
    private int f3131f;
    private int f3132g;
    private int f3133h;
    private int f3134i;
    private int f3135j;
    private int f3136k;
    private C0892b f3137l;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f3102a;
        int f3103b;
        int f3104c;
        int f3105d;
        int f3106e;
        int f3107f;
        int f3108g;
        int f3109h;
        int f3110i;
        int f3111j;

        static {
            CREATOR = new C0893c();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3102a = parcel.readInt();
            this.f3103b = parcel.readInt();
            this.f3104c = parcel.readInt();
            this.f3105d = parcel.readInt();
            this.f3106e = parcel.readInt();
            this.f3107f = parcel.readInt();
            this.f3108g = parcel.readInt();
            this.f3109h = parcel.readInt();
            this.f3110i = parcel.readInt();
            this.f3111j = parcel.readInt();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3102a);
            parcel.writeInt(this.f3103b);
            parcel.writeInt(this.f3104c);
            parcel.writeInt(this.f3105d);
            parcel.writeInt(this.f3106e);
            parcel.writeInt(this.f3107f);
            parcel.writeInt(this.f3108g);
            parcel.writeInt(this.f3109h);
            parcel.writeInt(this.f3110i);
            parcel.writeInt(this.f3111j);
        }
    }

    private void m5368f() {
        this.f3126a.setImageResource(this.f3127b);
    }

    private void m5369g() {
        if (this.f3128c == -1) {
            this.f3126a.setLayoutParams(new LayoutParams(this.f3129d, this.f3130e));
        } else {
            this.f3126a.setLayoutParams(new LayoutParams(this.f3128c, this.f3128c));
        }
    }

    private void m5370h() {
        if (this.f3131f == -1 || this.f3131f == 0) {
            this.f3126a.setPadding(this.f3132g, this.f3134i, this.f3133h, this.f3135j);
        } else {
            this.f3126a.setPadding(this.f3131f, this.f3131f, this.f3131f, this.f3131f);
        }
        this.f3126a.invalidate();
    }

    private void m5371i() {
        Drawable a = m5359a(this.f3136k);
        int radius = getRadius() - (getPadding() / 2);
        a.setCornerRadii(new float[]{(float) radius, (float) radius, 0.0f, 0.0f, 0.0f, 0.0f, (float) radius, (float) radius});
        if (VERSION.SDK_INT >= 16) {
            this.f3126a.setBackground(a);
        } else {
            this.f3126a.setBackgroundDrawable(a);
        }
    }

    public int m5372a() {
        return C0900g.layout_icon_round_corner_progress_bar;
    }

    protected void m5373a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0902i.IconRoundCornerProgress);
        this.f3127b = obtainStyledAttributes.getResourceId(C0902i.IconRoundCornerProgress_rcIconSrc, C0901h.round_corner_progress_icon);
        this.f3128c = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconSize, -1.0f);
        this.f3129d = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconWidth, m5357a(20.0f));
        this.f3130e = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconHeight, m5357a(20.0f));
        this.f3131f = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconPadding, -1.0f);
        this.f3132g = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconPaddingLeft, m5357a(0.0f));
        this.f3133h = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconPaddingRight, m5357a(0.0f));
        this.f3134i = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconPaddingTop, m5357a(0.0f));
        this.f3135j = (int) obtainStyledAttributes.getDimension(C0902i.IconRoundCornerProgress_rcIconPaddingBottom, m5357a(0.0f));
        this.f3136k = obtainStyledAttributes.getColor(C0902i.IconRoundCornerProgress_rcIconBackgroundColor, context.getResources().getColor(C0898e.round_corner_progress_bar_background_default));
        obtainStyledAttributes.recycle();
    }

    protected void m5374a(LinearLayout linearLayout, float f, float f2, float f3, int i, int i2, int i3, boolean z) {
        Drawable a = m5359a(i3);
        int i4 = i - (i2 / 2);
        if (!z || f2 == f) {
            a.setCornerRadii(new float[]{0.0f, 0.0f, (float) i4, (float) i4, (float) i4, (float) i4, 0.0f, 0.0f});
        } else {
            a.setCornerRadii(new float[]{(float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4, (float) i4});
        }
        if (VERSION.SDK_INT >= 16) {
            linearLayout.setBackground(a);
        } else {
            linearLayout.setBackgroundDrawable(a);
        }
        int width = (int) ((f3 - ((float) ((i2 * 2) + this.f3126a.getWidth()))) / (f / f2));
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        layoutParams.width = width;
        linearLayout.setLayoutParams(layoutParams);
    }

    protected void m5375b() {
        this.f3126a = (ImageView) findViewById(C0899f.iv_progress_icon);
        this.f3126a.setOnClickListener(this);
    }

    protected void m5376c() {
        m5368f();
        m5369g();
        m5370h();
        m5371i();
    }

    public int getColorIconBackground() {
        return this.f3136k;
    }

    public int getIconImageResource() {
        return this.f3127b;
    }

    public int getIconPadding() {
        return this.f3131f;
    }

    public int getIconPaddingBottom() {
        return this.f3135j;
    }

    public int getIconPaddingLeft() {
        return this.f3132g;
    }

    public int getIconPaddingRight() {
        return this.f3133h;
    }

    public int getIconPaddingTop() {
        return this.f3134i;
    }

    public int getIconSize() {
        return this.f3128c;
    }

    public void onClick(View view) {
        if (view.getId() == C0899f.iv_progress_icon && this.f3137l != null) {
            this.f3137l.m5390a();
        }
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f3127b = savedState.f3102a;
            this.f3128c = savedState.f3103b;
            this.f3129d = savedState.f3104c;
            this.f3130e = savedState.f3105d;
            this.f3131f = savedState.f3106e;
            this.f3132g = savedState.f3107f;
            this.f3133h = savedState.f3108g;
            this.f3134i = savedState.f3109h;
            this.f3135j = savedState.f3110i;
            this.f3136k = savedState.f3111j;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3102a = this.f3127b;
        savedState.f3103b = this.f3128c;
        savedState.f3104c = this.f3129d;
        savedState.f3105d = this.f3130e;
        savedState.f3106e = this.f3131f;
        savedState.f3107f = this.f3132g;
        savedState.f3108g = this.f3133h;
        savedState.f3109h = this.f3134i;
        savedState.f3110i = this.f3135j;
        savedState.f3111j = this.f3136k;
        return savedState;
    }

    public void setIconBackgroundColor(int i) {
        this.f3136k = i;
        m5371i();
    }

    public void setIconImageResource(int i) {
        this.f3127b = i;
        m5368f();
    }

    public void setIconPadding(int i) {
        if (i >= 0) {
            this.f3131f = i;
        }
        m5370h();
    }

    public void setIconPaddingBottom(int i) {
        if (i > 0) {
            this.f3135j = i;
        }
        m5370h();
    }

    public void setIconPaddingLeft(int i) {
        if (i > 0) {
            this.f3132g = i;
        }
        m5370h();
    }

    public void setIconPaddingRight(int i) {
        if (i > 0) {
            this.f3133h = i;
        }
        m5370h();
    }

    public void setIconPaddingTop(int i) {
        if (i > 0) {
            this.f3134i = i;
        }
        m5370h();
    }

    public void setIconSize(int i) {
        if (i >= 0) {
            this.f3128c = i;
        }
        m5369g();
    }

    public void setOnIconClickListener(C0892b c0892b) {
        this.f3137l = c0892b;
    }
}
