package com.cocosw.bottomsheet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.MenuInflater;
import android.view.MenuItem.OnMenuItemClickListener;

/* renamed from: com.cocosw.bottomsheet.l */
public class C1003l {
    private final Context f3797a;
    private int f3798b;
    private final C0991a f3799c;
    private CharSequence f3800d;
    private boolean f3801e;
    private int f3802f;
    private OnClickListener f3803g;
    private OnDismissListener f3804h;
    private Drawable f3805i;
    private String f3806j;
    private int f3807k;
    private int f3808l;
    private OnMenuItemClickListener f3809m;

    public C1003l(Activity activity) {
        this(activity, C1011u.BottomSheet_Dialog);
        TypedArray obtainStyledAttributes = activity.getTheme().obtainStyledAttributes(new int[]{C1008r.bottomSheetStyle});
        try {
            this.f3798b = obtainStyledAttributes.getResourceId(0, C1011u.BottomSheet_Dialog);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public C1003l(Context context, int i) {
        this.f3802f = 3;
        this.f3808l = -1;
        this.f3797a = context;
        this.f3798b = i;
        this.f3799c = new C0991a(context);
    }

    @SuppressLint({"Override"})
    public C0993c m6119a() {
        C0993c c0993c = new C0993c(this.f3797a, this.f3798b);
        c0993c.f3772h = this;
        return c0993c;
    }

    public C1003l m6120a(int i) {
        new MenuInflater(this.f3797a).inflate(i, this.f3799c);
        return this;
    }

    public C1003l m6121a(OnClickListener onClickListener) {
        this.f3803g = onClickListener;
        return this;
    }

    public C1003l m6122a(CharSequence charSequence) {
        this.f3800d = charSequence;
        return this;
    }

    public C1003l m6123b(int i) {
        this.f3807k = i;
        return this;
    }

    public C1003l m6124c(int i) {
        this.f3801e = true;
        this.f3802f = i;
        return this;
    }
}
