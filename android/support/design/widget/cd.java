package android.support.design.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

public final class cd {
    private Drawable f539a;
    private CharSequence f540b;
    private CharSequence f541c;
    private int f542d;
    private View f543e;
    private final TabLayout f544f;

    cd(TabLayout tabLayout) {
        this.f542d = -1;
        this.f544f = tabLayout;
    }

    public cd m655a(CharSequence charSequence) {
        this.f540b = charSequence;
        if (this.f542d >= 0) {
            this.f544f.m430b(this.f542d);
        }
        return this;
    }

    public View m656a() {
        return this.f543e;
    }

    void m657a(int i) {
        this.f542d = i;
    }

    public Drawable m658b() {
        return this.f539a;
    }

    public int m659c() {
        return this.f542d;
    }

    public CharSequence m660d() {
        return this.f540b;
    }

    public void m661e() {
        this.f544f.m457b(this);
    }

    public CharSequence m662f() {
        return this.f541c;
    }
}
