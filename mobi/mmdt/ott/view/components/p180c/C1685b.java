package mobi.mmdt.ott.view.components.p180c;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.C0370a;
import android.support.v7.app.ag;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import java.util.Locale;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import net.frakbot.glowpadbackport.BuildConfig;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.view.components.c.b */
public abstract class C1685b extends ag {
    private boolean f5559i;
    private Locale f5560j;

    public C1685b() {
        this.f5559i = true;
        this.f5560j = null;
    }

    @TargetApi(21)
    private void m8486b(Window window, int i) {
        window.setStatusBarColor(i);
    }

    protected void m8487a(Bundle bundle, boolean z) {
        this.f5559i = z;
        super.onCreate(bundle);
        C0002c.m2a().m14a((Object) this);
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        String a = C1309a.m6934a(getApplicationContext()).m6937a();
        if (!BuildConfig.FLAVOR.equals(a) && !configuration.locale.getLanguage().equals(a)) {
            this.f5560j = new Locale(a);
            Locale.setDefault(this.f5560j);
            configuration.locale = this.f5560j;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    protected void m8488a(Toolbar toolbar, String str) {
        toolbar.setTitle((CharSequence) str);
    }

    protected void m8489a(Window window, int i) {
        if (window != null && VERSION.SDK_INT >= 21) {
            m8486b(window, i);
        }
    }

    protected void m8490b(Toolbar toolbar, String str) {
        toolbar.setSubtitle((CharSequence) str);
    }

    protected void m8491e(int i) {
        m3625h().m3570a(i);
    }

    protected void m8492e(String str) {
        m3625h().m3573a((CharSequence) str);
    }

    protected void m8493f(String str) {
        if (str == null) {
            m3625h().m3578b(null);
        } else {
            m3625h().m3578b((CharSequence) str);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f5560j != null) {
            Locale locale = new Locale(C1309a.m6934a(getApplicationContext()).m6937a());
            Locale.setDefault(locale);
            Configuration configuration2 = new Configuration(configuration);
            configuration2.locale = locale;
            getBaseContext().getResources().updateConfiguration(configuration2, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0002c.m2a().m14a((Object) this);
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        String a = C1309a.m6934a(getApplicationContext()).m6937a();
        if (!BuildConfig.FLAVOR.equals(a) && !configuration.locale.getLanguage().equals(a)) {
            this.f5560j = new Locale(a);
            Locale.setDefault(this.f5560j);
            configuration.locale = this.f5560j;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        C0002c.m2a().m16b(this);
    }

    public void onEvent(C1797a c1797a) {
        finish();
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        if (this.f5559i) {
            C0370a h = m3625h();
            h.m3574a(true);
            h.m3579b(true);
            h.m3577b(2130838564);
        }
    }

    protected void onResume() {
        super.onResume();
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        String a = C1309a.m6934a(getApplicationContext()).m6937a();
        if (!configuration.locale.getLanguage().equals(a)) {
            this.f5560j = new Locale(a);
            Locale.setDefault(this.f5560j);
            configuration.locale = this.f5560j;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    protected Activity m8494q() {
        return this;
    }
}
