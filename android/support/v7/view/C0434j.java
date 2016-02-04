package android.support.v7.view;

import android.view.InflateException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.view.j */
class C0434j implements OnMenuItemClickListener {
    private static final Class<?>[] f2076a;
    private Object f2077b;
    private Method f2078c;

    static {
        f2076a = new Class[]{MenuItem.class};
    }

    public C0434j(Object obj, String str) {
        this.f2077b = obj;
        Class cls = obj.getClass();
        try {
            this.f2078c = cls.getMethod(str, f2076a);
        } catch (Throwable e) {
            InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
            inflateException.initCause(e);
            throw inflateException;
        }
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            if (this.f2078c.getReturnType() == Boolean.TYPE) {
                return ((Boolean) this.f2078c.invoke(this.f2077b, new Object[]{menuItem})).booleanValue();
            }
            this.f2078c.invoke(this.f2077b, new Object[]{menuItem});
            return true;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
