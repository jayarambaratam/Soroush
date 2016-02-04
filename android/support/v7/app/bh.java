package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Method;
import net.frakbot.glowpadbackport.BuildConfig;

class bh implements OnClickListener {
    private final View f1800a;
    private final String f1801b;
    private Method f1802c;
    private Context f1803d;

    public bh(View view, String str) {
        this.f1800a = view;
        this.f1801b = str;
    }

    private void m3663a(Context context, String str) {
        for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
            try {
                if (!context2.isRestricted()) {
                    Method method = context2.getClass().getMethod(this.f1801b, new Class[]{View.class});
                    if (method != null) {
                        this.f1802c = method;
                        this.f1803d = context2;
                        return;
                    }
                }
            } catch (NoSuchMethodException e) {
            }
        }
        int id = this.f1800a.getId();
        throw new IllegalStateException("Could not find method " + this.f1801b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f1800a.getClass() + (id == -1 ? BuildConfig.FLAVOR : " with id '" + this.f1800a.getContext().getResources().getResourceEntryName(id) + "'"));
    }

    public void onClick(View view) {
        if (this.f1802c == null) {
            m3663a(this.f1800a.getContext(), this.f1801b);
        }
        try {
            this.f1802c.invoke(this.f1803d, new Object[]{view});
        } catch (Throwable e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (Throwable e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
