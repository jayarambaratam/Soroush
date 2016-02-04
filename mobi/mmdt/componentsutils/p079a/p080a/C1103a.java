package mobi.mmdt.componentsutils.p079a.p080a;

import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.componentsutils.a.a.a */
public class C1103a {
    private static final Object m6358a(String str) {
        Object obj = null;
        try {
            obj = Class.forName("mobi.mmdt.ott.a").getField(str).get(null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        }
        return obj;
    }

    public static final boolean m6359a() {
        String c = C1103a.m6361c();
        return c != null ? (c.equals("debug") || c.equals("debug_version")) ? true : c.equals(BuildConfig.BUILD_TYPE) ? false : false : false;
    }

    public static final boolean m6360b() {
        String c = C1103a.m6361c();
        return c != null ? c.equals("debug") ? false : (c.equals("debug_version") || !c.equals(BuildConfig.BUILD_TYPE)) ? true : true : true;
    }

    public static final String m6361c() {
        Object a = C1103a.m6358a("BUILD_TYPE");
        return a == null ? null : a.toString();
    }
}
