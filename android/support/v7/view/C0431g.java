package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p007d.p008a.C0048a;
import android.support.v7.view.menu.ab;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

@TargetApi(11)
/* renamed from: android.support.v7.view.g */
public class C0431g extends ActionMode {
    final Context f2064a;
    final C0378b f2065b;

    public C0431g(Context context, C0378b c0378b) {
        this.f2064a = context;
        this.f2065b = c0378b;
    }

    public void finish() {
        this.f2065b.m3768c();
    }

    public View getCustomView() {
        return this.f2065b.m3773i();
    }

    public Menu getMenu() {
        return ab.m4037a(this.f2064a, (C0048a) this.f2065b.m3765b());
    }

    public MenuInflater getMenuInflater() {
        return this.f2065b.m3759a();
    }

    public CharSequence getSubtitle() {
        return this.f2065b.m3771g();
    }

    public Object getTag() {
        return this.f2065b.m3774j();
    }

    public CharSequence getTitle() {
        return this.f2065b.m3770f();
    }

    public boolean getTitleOptionalHint() {
        return this.f2065b.m3775k();
    }

    public void invalidate() {
        this.f2065b.m3769d();
    }

    public boolean isTitleOptional() {
        return this.f2065b.m3772h();
    }

    public void setCustomView(View view) {
        this.f2065b.m3761a(view);
    }

    public void setSubtitle(int i) {
        this.f2065b.m3766b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f2065b.m3762a(charSequence);
    }

    public void setTag(Object obj) {
        this.f2065b.m3763a(obj);
    }

    public void setTitle(int i) {
        this.f2065b.m3760a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f2065b.m3767b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f2065b.m3764a(z);
    }
}
