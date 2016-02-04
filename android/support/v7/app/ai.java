package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class ai {
    ai() {
    }

    public static ai m3461a(Activity activity, ah ahVar) {
        return m3463a(activity, activity.getWindow(), ahVar);
    }

    public static ai m3462a(Dialog dialog, ah ahVar) {
        return m3463a(dialog.getContext(), dialog.getWindow(), ahVar);
    }

    private static ai m3463a(Context context, Window window, ah ahVar) {
        int i = VERSION.SDK_INT;
        return i >= 23 ? new aq(context, window, ahVar) : i >= 14 ? new ao(context, window, ahVar) : i >= 11 ? new an(context, window, ahVar) : new AppCompatDelegateImplV7(context, window, ahVar);
    }

    public abstract C0370a m3464a();

    public abstract void m3465a(int i);

    public abstract void m3466a(Configuration configuration);

    public abstract void m3467a(Bundle bundle);

    public abstract void m3468a(Toolbar toolbar);

    public abstract void m3469a(View view);

    public abstract void m3470a(View view, LayoutParams layoutParams);

    public abstract void m3471a(CharSequence charSequence);

    public abstract MenuInflater m3472b();

    public abstract void m3473b(Bundle bundle);

    public abstract void m3474b(View view, LayoutParams layoutParams);

    public abstract boolean m3475b(int i);

    public abstract void m3476c();

    public abstract void m3477d();

    public abstract void m3478e();

    public abstract void m3479f();

    public abstract C0372g m3480g();

    public abstract void m3481h();
}
