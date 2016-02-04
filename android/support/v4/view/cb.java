package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class cb {
    static final co f1343a;

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1343a = new cn();
        } else if (i >= 21) {
            f1343a = new cm();
        } else if (i >= 19) {
            f1343a = new cl();
        } else if (i >= 17) {
            f1343a = new cj();
        } else if (i >= 16) {
            f1343a = new ci();
        } else if (i >= 15) {
            f1343a = new cg();
        } else if (i >= 14) {
            f1343a = new ch();
        } else if (i >= 11) {
            f1343a = new cf();
        } else if (i >= 9) {
            f1343a = new ce();
        } else if (i >= 7) {
            f1343a = new cd();
        } else {
            f1343a = new cc();
        }
    }

    public static boolean m2382A(View view) {
        return f1343a.m2451B(view);
    }

    public static boolean m2383B(View view) {
        return f1343a.m2452C(view);
    }

    public static void m2384C(View view) {
        f1343a.m2453D(view);
    }

    public static boolean m2385D(View view) {
        return f1343a.m2454E(view);
    }

    public static float m2386E(View view) {
        return f1343a.m2455F(view);
    }

    public static boolean m2387F(View view) {
        return f1343a.m2456G(view);
    }

    public static boolean m2388G(View view) {
        return f1343a.m2457H(view);
    }

    public static int m2389a(int i, int i2) {
        return f1343a.m2458a(i, i2);
    }

    public static int m2390a(int i, int i2, int i3) {
        return f1343a.m2459a(i, i2, i3);
    }

    public static int m2391a(View view) {
        return f1343a.m2460a(view);
    }

    public static ff m2392a(View view, ff ffVar) {
        return f1343a.m2461a(view, ffVar);
    }

    public static void m2393a(View view, float f) {
        f1343a.m2477b(view, f);
    }

    public static void m2394a(View view, int i, int i2) {
        f1343a.m2463a(view, i, i2);
    }

    public static void m2395a(View view, int i, int i2, int i3, int i4) {
        f1343a.m2464a(view, i, i2, i3, i4);
    }

    public static void m2396a(View view, int i, Paint paint) {
        f1343a.m2465a(view, i, paint);
    }

    public static void m2397a(View view, ColorStateList colorStateList) {
        f1343a.m2466a(view, colorStateList);
    }

    public static void m2398a(View view, Paint paint) {
        f1343a.m2467a(view, paint);
    }

    public static void m2399a(View view, Mode mode) {
        f1343a.m2468a(view, mode);
    }

    public static void m2400a(View view, C0077a c0077a) {
        f1343a.m2469a(view, c0077a);
    }

    public static void m2401a(View view, bs bsVar) {
        f1343a.m2470a(view, bsVar);
    }

    public static void m2402a(View view, Runnable runnable) {
        f1343a.m2471a(view, runnable);
    }

    public static void m2403a(View view, Runnable runnable, long j) {
        f1343a.m2472a(view, runnable, j);
    }

    public static void m2404a(View view, boolean z) {
        f1343a.m2473a(view, z);
    }

    public static void m2405a(ViewGroup viewGroup, boolean z) {
        f1343a.m2474a(viewGroup, z);
    }

    public static boolean m2406a(View view, int i) {
        return f1343a.m2475a(view, i);
    }

    public static ff m2407b(View view, ff ffVar) {
        return f1343a.m2476b(view, ffVar);
    }

    public static void m2408b(View view, float f) {
        f1343a.m2482c(view, f);
    }

    public static void m2409b(View view, int i, int i2, int i3, int i4) {
        f1343a.m2478b(view, i, i2, i3, i4);
    }

    public static void m2410b(View view, boolean z) {
        f1343a.m2479b(view, z);
    }

    public static boolean m2411b(View view) {
        return f1343a.m2480b(view);
    }

    public static boolean m2412b(View view, int i) {
        return f1343a.m2481b(view, i);
    }

    public static void m2413c(View view, float f) {
        f1343a.m2487d(view, f);
    }

    public static void m2414c(View view, int i) {
        f1343a.m2483c(view, i);
    }

    public static void m2415c(View view, boolean z) {
        f1343a.m2484c(view, z);
    }

    public static boolean m2416c(View view) {
        return f1343a.m2485c(view);
    }

    public static void m2417d(View view) {
        f1343a.m2486d(view);
    }

    public static void m2418d(View view, float f) {
        f1343a.m2462a(view, f);
    }

    public static void m2419d(View view, int i) {
        f1343a.m2488d(view, i);
    }

    public static int m2420e(View view) {
        return f1343a.m2489e(view);
    }

    public static void m2421e(View view, float f) {
        f1343a.m2490e(view, f);
    }

    public static void m2422e(View view, int i) {
        view.offsetTopAndBottom(i);
        if (i != 0 && VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static float m2423f(View view) {
        return f1343a.m2491f(view);
    }

    public static void m2424f(View view, float f) {
        f1343a.m2492f(view, f);
    }

    public static void m2425f(View view, int i) {
        view.offsetLeftAndRight(i);
        if (i != 0 && VERSION.SDK_INT < 11) {
            view.invalidate();
        }
    }

    public static int m2426g(View view) {
        return f1343a.m2493g(view);
    }

    public static void m2427g(View view, float f) {
        f1343a.m2494g(view, f);
    }

    public static int m2428h(View view) {
        return f1343a.m2495h(view);
    }

    public static void m2429h(View view, float f) {
        f1343a.m2496h(view, f);
    }

    public static ViewParent m2430i(View view) {
        return f1343a.m2497i(view);
    }

    public static void m2431i(View view, float f) {
        f1343a.m2498i(view, f);
    }

    public static void m2432j(View view, float f) {
        f1343a.m2499j(view, f);
    }

    public static boolean m2433j(View view) {
        return f1343a.m2500j(view);
    }

    public static int m2434k(View view) {
        return f1343a.m2501k(view);
    }

    public static int m2435l(View view) {
        return f1343a.m2502l(view);
    }

    public static int m2436m(View view) {
        return f1343a.m2503m(view);
    }

    public static int m2437n(View view) {
        return f1343a.m2504n(view);
    }

    public static float m2438o(View view) {
        return f1343a.m2506p(view);
    }

    public static float m2439p(View view) {
        return f1343a.m2507q(view);
    }

    public static int m2440q(View view) {
        return f1343a.m2509s(view);
    }

    public static int m2441r(View view) {
        return f1343a.m2510t(view);
    }

    public static el m2442s(View view) {
        return f1343a.m2511u(view);
    }

    public static float m2443t(View view) {
        return f1343a.m2508r(view);
    }

    public static float m2444u(View view) {
        return f1343a.m2514x(view);
    }

    public static int m2445v(View view) {
        return f1343a.m2512v(view);
    }

    public static void m2446w(View view) {
        f1343a.m2513w(view);
    }

    public static boolean m2447x(View view) {
        return f1343a.m2515z(view);
    }

    public static void m2448y(View view) {
        f1343a.m2450A(view);
    }

    public static boolean m2449z(View view) {
        return f1343a.m2505o(view);
    }
}
