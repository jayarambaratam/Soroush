package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ListAdapter;

public class af {
    private final C0397w f1774a;
    private int f1775b;

    public af(Context context) {
        this(context, ae.m3599a(context, 0));
    }

    public af(Context context, int i) {
        this.f1774a = new C0397w(new ContextThemeWrapper(context, ae.m3599a(context, i)));
        this.f1775b = i;
    }

    public Context m3601a() {
        return this.f1774a.f1971a;
    }

    public af m3602a(OnKeyListener onKeyListener) {
        this.f1774a.f1988r = onKeyListener;
        return this;
    }

    public af m3603a(Drawable drawable) {
        this.f1774a.f1974d = drawable;
        return this;
    }

    public af m3604a(View view) {
        this.f1774a.f1977g = view;
        return this;
    }

    public af m3605a(ListAdapter listAdapter, OnClickListener onClickListener) {
        this.f1774a.f1990t = listAdapter;
        this.f1774a.f1991u = onClickListener;
        return this;
    }

    public af m3606a(CharSequence charSequence) {
        this.f1774a.f1976f = charSequence;
        return this;
    }

    public af m3607a(CharSequence charSequence, OnClickListener onClickListener) {
        this.f1774a.f1979i = charSequence;
        this.f1774a.f1980j = onClickListener;
        return this;
    }

    public ae m3608b() {
        ae aeVar = new ae(this.f1774a.f1971a, this.f1775b, false);
        this.f1774a.m3887a(aeVar.f1773a);
        aeVar.setCancelable(this.f1774a.f1985o);
        if (this.f1774a.f1985o) {
            aeVar.setCanceledOnTouchOutside(true);
        }
        aeVar.setOnCancelListener(this.f1774a.f1986p);
        aeVar.setOnDismissListener(this.f1774a.f1987q);
        if (this.f1774a.f1988r != null) {
            aeVar.setOnKeyListener(this.f1774a.f1988r);
        }
        return aeVar;
    }

    public af m3609b(View view) {
        this.f1774a.f1993w = view;
        this.f1774a.f1992v = 0;
        this.f1774a.f1959B = false;
        return this;
    }

    public af m3610b(CharSequence charSequence) {
        this.f1774a.f1978h = charSequence;
        return this;
    }

    public af m3611b(CharSequence charSequence, OnClickListener onClickListener) {
        this.f1774a.f1981k = charSequence;
        this.f1774a.f1982l = onClickListener;
        return this;
    }

    public ae m3612c() {
        ae b = m3608b();
        b.show();
        return b;
    }
}
