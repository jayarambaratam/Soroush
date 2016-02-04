package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

class cc implements co {
    WeakHashMap<View, el> f1344a;

    cc() {
        this.f1344a = null;
    }

    private boolean m2516a(bu buVar, int i) {
        int computeHorizontalScrollOffset = buVar.computeHorizontalScrollOffset();
        int computeHorizontalScrollRange = buVar.computeHorizontalScrollRange() - buVar.computeHorizontalScrollExtent();
        return computeHorizontalScrollRange == 0 ? false : i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + -1;
    }

    private boolean m2517b(bu buVar, int i) {
        int computeVerticalScrollOffset = buVar.computeVerticalScrollOffset();
        int computeVerticalScrollRange = buVar.computeVerticalScrollRange() - buVar.computeVerticalScrollExtent();
        return computeVerticalScrollRange == 0 ? false : i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
    }

    public void m2518A(View view) {
    }

    public boolean m2519B(View view) {
        return false;
    }

    public boolean m2520C(View view) {
        return view instanceof bo ? ((bo) view).isNestedScrollingEnabled() : false;
    }

    public void m2521D(View view) {
        if (view instanceof bo) {
            ((bo) view).stopNestedScroll();
        }
    }

    public boolean m2522E(View view) {
        return cp.m2659a(view);
    }

    public float m2523F(View view) {
        return m2584y(view) + m2583x(view);
    }

    public boolean m2524G(View view) {
        return cp.m2662d(view);
    }

    public boolean m2525H(View view) {
        return false;
    }

    public int m2526a(int i, int i2) {
        return i | i2;
    }

    public int m2527a(int i, int i2, int i3) {
        return View.resolveSize(i, i2);
    }

    public int m2528a(View view) {
        return 2;
    }

    long m2529a() {
        return 10;
    }

    public ff m2530a(View view, ff ffVar) {
        return ffVar;
    }

    public void m2531a(View view, float f) {
    }

    public void m2532a(View view, int i, int i2) {
    }

    public void m2533a(View view, int i, int i2, int i3, int i4) {
        view.invalidate(i, i2, i3, i4);
    }

    public void m2534a(View view, int i, Paint paint) {
    }

    public void m2535a(View view, ColorStateList colorStateList) {
        cp.m2657a(view, colorStateList);
    }

    public void m2536a(View view, Paint paint) {
    }

    public void m2537a(View view, Mode mode) {
        cp.m2658a(view, mode);
    }

    public void m2538a(View view, C0077a c0077a) {
    }

    public void m2539a(View view, bs bsVar) {
    }

    public void m2540a(View view, Runnable runnable) {
        view.postDelayed(runnable, m2529a());
    }

    public void m2541a(View view, Runnable runnable, long j) {
        view.postDelayed(runnable, m2529a() + j);
    }

    public void m2542a(View view, boolean z) {
    }

    public void m2543a(ViewGroup viewGroup, boolean z) {
    }

    public boolean m2544a(View view, int i) {
        return (view instanceof bu) && m2516a((bu) view, i);
    }

    public ff m2545b(View view, ff ffVar) {
        return ffVar;
    }

    public void m2546b(View view, float f) {
    }

    public void m2547b(View view, int i, int i2, int i3, int i4) {
        view.setPadding(i, i2, i3, i4);
    }

    public void m2548b(View view, boolean z) {
    }

    public boolean m2549b(View view) {
        return false;
    }

    public boolean m2550b(View view, int i) {
        return (view instanceof bu) && m2517b((bu) view, i);
    }

    public void m2551c(View view, float f) {
    }

    public void m2552c(View view, int i) {
    }

    public void m2553c(View view, boolean z) {
    }

    public boolean m2554c(View view) {
        return false;
    }

    public void m2555d(View view) {
        view.invalidate();
    }

    public void m2556d(View view, float f) {
    }

    public void m2557d(View view, int i) {
    }

    public int m2558e(View view) {
        return 0;
    }

    public void m2559e(View view, float f) {
    }

    public float m2560f(View view) {
        return 1.0f;
    }

    public void m2561f(View view, float f) {
    }

    public int m2562g(View view) {
        return 0;
    }

    public void m2563g(View view, float f) {
    }

    public int m2564h(View view) {
        return 0;
    }

    public void m2565h(View view, float f) {
    }

    public ViewParent m2566i(View view) {
        return view.getParent();
    }

    public void m2567i(View view, float f) {
    }

    public void m2568j(View view, float f) {
    }

    public boolean m2569j(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public int m2570k(View view) {
        return view.getMeasuredWidth();
    }

    public int m2571l(View view) {
        return 0;
    }

    public int m2572m(View view) {
        return view.getPaddingLeft();
    }

    public int m2573n(View view) {
        return view.getPaddingRight();
    }

    public boolean m2574o(View view) {
        return true;
    }

    public float m2575p(View view) {
        return 0.0f;
    }

    public float m2576q(View view) {
        return 0.0f;
    }

    public float m2577r(View view) {
        return 0.0f;
    }

    public int m2578s(View view) {
        return cp.m2660b(view);
    }

    public int m2579t(View view) {
        return cp.m2661c(view);
    }

    public el m2580u(View view) {
        return new el(view);
    }

    public int m2581v(View view) {
        return 0;
    }

    public void m2582w(View view) {
    }

    public float m2583x(View view) {
        return 0.0f;
    }

    public float m2584y(View view) {
        return 0.0f;
    }

    public boolean m2585z(View view) {
        return false;
    }
}
