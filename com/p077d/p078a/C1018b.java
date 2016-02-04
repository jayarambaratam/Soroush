package com.p077d.p078a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v4.p012b.C0125h;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import com.nineoldandroids.view.ViewHelper;

@SuppressLint({"ViewConstructor"})
/* renamed from: com.d.a.b */
public class C1018b extends RelativeLayout {
    int f3838a;
    private View f3839b;
    private View f3840c;
    private int f3841d;
    private Activity f3842e;
    private boolean f3843f;
    private int f3844g;
    private boolean f3845h;
    private RecyclerView f3846i;
    private C1017a f3847j;
    private int f3848k;
    private boolean f3849l;
    private boolean f3850m;
    private C1020d f3851n;

    public C1018b(Context context, RecyclerView recyclerView, boolean z) {
        super(context);
        this.f3841d = Color.parseColor("#9c9c9c");
        this.f3843f = true;
        this.f3844g = 2500;
        this.f3845h = true;
        this.f3848k = C0125h.m1020b(getContext(), 17170443);
        this.f3850m = false;
        if (!isInEditMode()) {
            this.f3842e = (Activity) context;
        }
        this.f3839b = new View(context);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(C1025i.m6158a(8, this), -1);
        layoutParams.addRule(11);
        this.f3839b.setLayoutParams(layoutParams);
        this.f3839b.setBackgroundColor(getResources().getColor(17170432));
        ViewHelper.setAlpha(this.f3839b, 0.4f);
        this.f3840c = new View(context);
        layoutParams = new RelativeLayout.LayoutParams(C1025i.m6158a(8, this), C1025i.m6158a(48, this));
        layoutParams.addRule(11);
        this.f3840c.setLayoutParams(layoutParams);
        this.f3849l = z;
        if (VERSION.SDK_INT >= 21) {
            this.f3838a = m6141a(context);
        } else {
            this.f3838a = Color.parseColor("#9c9c9c");
        }
        this.f3840c.setBackgroundColor(z ? Color.parseColor("#9c9c9c") : this.f3838a);
        addView(this.f3839b);
        addView(this.f3840c);
        setId(C1024h.reservedNamedId);
        LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(C1025i.m6158a(20, this), -1);
        layoutParams2.addRule(7, recyclerView.getId());
        layoutParams2.addRule(6, recyclerView.getId());
        layoutParams2.addRule(8, recyclerView.getId());
        ((ViewGroup) recyclerView.getParent()).addView(this, layoutParams2);
        recyclerView.addOnScrollListener(new C1022f(this, this));
        this.f3846i = recyclerView;
        m6142a();
        this.f3851n = new C1020d(this, this);
        this.f3851n.start();
        Animation translateAnimation = new TranslateAnimation(2, 0.0f, 1, 1.0f, 2, 0.0f, 2, 0.0f);
        translateAnimation.setFillAfter(true);
        startAnimation(translateAnimation);
    }

    @TargetApi(21)
    private int m6141a(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new TypedValue().data, new int[]{16843829});
        int color = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
        return color;
    }

    private void m6142a() {
        setOnTouchListener(new C1019c(this));
    }

    private void m6145b() {
        if (!this.f3843f) {
            Animation translateAnimation = new TranslateAnimation(2, 0.0f, 1, 1.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation.setDuration(500);
            translateAnimation.setFillAfter(true);
            this.f3843f = true;
            startAnimation(translateAnimation);
        }
    }

    private void m6146c() {
        if (this.f3843f && this.f3845h && !this.f3850m) {
            this.f3843f = false;
            Animation translateAnimation = new TranslateAnimation(1, 1.0f, 1, 0.0f, 2, 0.0f, 2, 0.0f);
            translateAnimation.setDuration(500);
            translateAnimation.setFillAfter(true);
            startAnimation(translateAnimation);
        }
    }

    public boolean getHidden() {
        return this.f3843f;
    }

    public String getIndicatorText() {
        return (String) this.f3847j.f3837a.getText();
    }

    public void setScrollBarHidden(boolean z) {
        this.f3850m = z;
        m6145b();
    }
}
