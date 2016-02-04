package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p019a.C0359b;
import android.support.v7.view.C0376c;
import android.support.v7.view.C0378b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class bf extends Dialog implements ah {
    private ai f1772a;

    public bf(Context context, int i) {
        super(context, m3593a(context, i));
        m3594a().m3467a(null);
    }

    private static int m3593a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0359b.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public ai m3594a() {
        if (this.f1772a == null) {
            this.f1772a = ai.m3462a((Dialog) this, (ah) this);
        }
        return this.f1772a;
    }

    public C0378b m3595a(C0376c c0376c) {
        return null;
    }

    public void m3596a(C0378b c0378b) {
    }

    public boolean m3597a(int i) {
        return m3594a().m3475b(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m3594a().m3474b(view, layoutParams);
    }

    public void m3598b(C0378b c0378b) {
    }

    public void invalidateOptionsMenu() {
        m3594a().m3478e();
    }

    protected void onCreate(Bundle bundle) {
        m3594a().m3481h();
        super.onCreate(bundle);
        m3594a().m3467a(bundle);
    }

    protected void onStop() {
        super.onStop();
        m3594a().m3476c();
    }

    public void setContentView(int i) {
        m3594a().m3465a(i);
    }

    public void setContentView(View view) {
        m3594a().m3469a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m3594a().m3470a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m3594a().m3471a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m3594a().m3471a(charSequence);
    }
}
