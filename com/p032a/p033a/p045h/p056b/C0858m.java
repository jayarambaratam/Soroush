package com.p032a.p033a.p045h.p056b;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.a.a.h.b.m */
class C0858m {
    private final View f2974a;
    private final List<C0855h> f2975b;
    private C0859n f2976c;
    private Point f2977d;

    public C0858m(View view) {
        this.f2975b = new ArrayList();
        this.f2974a = view;
    }

    private int m5176a(int i, boolean z) {
        if (i != -2) {
            return i;
        }
        Point d = m5183d();
        return z ? d.y : d.x;
    }

    private void m5177a() {
        if (!this.f2975b.isEmpty()) {
            int c = m5182c();
            int b = m5181b();
            if (m5180a(c) && m5180a(b)) {
                m5178a(c, b);
                ViewTreeObserver viewTreeObserver = this.f2974a.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(this.f2976c);
                }
                this.f2976c = null;
            }
        }
    }

    private void m5178a(int i, int i2) {
        for (C0855h a : this.f2975b) {
            a.m5171a(i, i2);
        }
        this.f2975b.clear();
    }

    private boolean m5180a(int i) {
        return i > 0 || i == -2;
    }

    private int m5181b() {
        LayoutParams layoutParams = this.f2974a.getLayoutParams();
        return m5180a(this.f2974a.getHeight()) ? this.f2974a.getHeight() : layoutParams != null ? m5176a(layoutParams.height, true) : 0;
    }

    private int m5182c() {
        LayoutParams layoutParams = this.f2974a.getLayoutParams();
        return m5180a(this.f2974a.getWidth()) ? this.f2974a.getWidth() : layoutParams != null ? m5176a(layoutParams.width, false) : 0;
    }

    @TargetApi(13)
    private Point m5183d() {
        if (this.f2977d != null) {
            return this.f2977d;
        }
        Display defaultDisplay = ((WindowManager) this.f2974a.getContext().getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 13) {
            this.f2977d = new Point();
            defaultDisplay.getSize(this.f2977d);
        } else {
            this.f2977d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        return this.f2977d;
    }

    public void m5184a(C0855h c0855h) {
        int c = m5182c();
        int b = m5181b();
        if (m5180a(c) && m5180a(b)) {
            c0855h.m5171a(c, b);
            return;
        }
        if (!this.f2975b.contains(c0855h)) {
            this.f2975b.add(c0855h);
        }
        if (this.f2976c == null) {
            ViewTreeObserver viewTreeObserver = this.f2974a.getViewTreeObserver();
            this.f2976c = new C0859n(this);
            viewTreeObserver.addOnPreDrawListener(this.f2976c);
        }
    }
}
