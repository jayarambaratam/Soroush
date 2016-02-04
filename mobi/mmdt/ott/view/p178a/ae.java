package mobi.mmdt.ott.view.p178a;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.Thread.UncaughtExceptionHandler;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.view.a.ae */
class ae implements UncaughtExceptionHandler {
    final /* synthetic */ ad f5497a;

    ae(ad adVar) {
        this.f5497a = adVar;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        try {
            Writer stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            this.f5497a.f5495c = false;
            this.f5497a.f5496d = System.currentTimeMillis();
            new Thread(new af(this, th, stringWriter)).start();
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        if (thread != null && thread.getName().equals("main")) {
            while (!this.f5497a.f5495c) {
                try {
                    Thread.currentThread();
                    Thread.sleep(100);
                } catch (Throwable e2) {
                    C1104b.m6368b((Object) this, e2);
                }
                if (System.currentTimeMillis() - this.f5497a.f5496d > 2000) {
                    break;
                }
            }
            System.exit(1);
        }
    }
}
