package mobi.mmdt.ott.view.p178a;

import java.io.StringWriter;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.p079a.p080a.C1105c;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.a.af */
class af implements Runnable {
    final /* synthetic */ Throwable f5498a;
    final /* synthetic */ StringWriter f5499b;
    final /* synthetic */ ae f5500c;

    af(ae aeVar, Throwable th, StringWriter stringWriter) {
        this.f5500c = aeVar;
        this.f5498a = th;
        this.f5499b = stringWriter;
    }

    public void run() {
        try {
            C1104b.m6368b((Object) this, this.f5498a);
            this.f5500c.f5497a.m8468a(this.f5498a.getMessage(), C1105c.error, this.f5499b.toString(), BuildConfig.FLAVOR);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        this.f5500c.f5497a.f5495c = true;
    }
}
