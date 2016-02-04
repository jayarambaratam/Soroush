package android.support.v4.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import java.lang.reflect.Field;

class ao {
    private static Field f1326a;
    private static boolean f1327b;

    static void m2230a(LayoutInflater layoutInflater, ar arVar) {
        Factory2 apVar = arVar != null ? new ap(arVar) : null;
        layoutInflater.setFactory2(apVar);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            m2231a(layoutInflater, (Factory2) factory);
        } else {
            m2231a(layoutInflater, apVar);
        }
    }

    static void m2231a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f1327b) {
            try {
                f1326a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1326a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f1327b = true;
        }
        if (f1326a != null) {
            try {
                f1326a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
