package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.p019a.C0359b;
import android.util.TypedValue;
import android.view.KeyEvent;

public class ae extends bf implements DialogInterface {
    private C0391q f1773a;

    ae(Context context, int i, boolean z) {
        super(context, m3599a(context, i));
        this.f1773a = new C0391q(getContext(), this, getWindow());
    }

    static int m3599a(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0359b.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1773a.m3872a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1773a.m3878a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1773a.m3882b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1773a.m3877a(charSequence);
    }
}
