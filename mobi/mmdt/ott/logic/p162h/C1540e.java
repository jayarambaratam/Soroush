package mobi.mmdt.ott.logic.p162h;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import mobi.mmdt.componentsutils.C1114a;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.p095c.p108d.C1301b;
import mobi.mmdt.ott.provider.p174h.C1629b;
import mobi.mmdt.ott.provider.p174h.C1634g;
import mobi.mmdt.ott.provider.p175i.C1635a;
import mobi.mmdt.ott.provider.p175i.C1640f;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.logic.h.e */
public class C1540e {
    private Context f5191a;
    private String f5192b;
    private C1537b f5193c;

    public C1540e(Context context, C1537b c1537b) {
        this.f5191a = context;
        this.f5193c = c1537b;
    }

    private void m7779a(String str, InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                C1538c c1538c;
                C1635a.m8333a(this.f5191a, i, C1640f.EXTRACTING);
                String h = C1490b.m7516a(this.f5191a).m7530h(i + BuildConfig.FLAVOR);
                File file = new File(h);
                C1541f.m7781a(inputStream, file);
                String str2 = h + File.separator + i + "_" + C1301b.m6870a(this.f5191a);
                C1538c c1538c2 = null;
                if (file.isDirectory()) {
                    for (File file2 : file.listFiles()) {
                        if (file2.isDirectory()) {
                            file2.renameTo(new File(str2));
                        } else if (C1114a.m6430h(file2.getPath()).equals("xml")) {
                            c1538c2 = C1536a.m7759a(file2);
                        }
                    }
                    c1538c = c1538c2;
                } else {
                    c1538c = null;
                }
                if (c1538c != null) {
                    this.f5192b = Uri.fromFile(new File(str2 + File.separator + c1538c.m7768h())).toString();
                    C1635a.m8332a(this.f5191a, c1538c.m7765e(), c1538c.m7769i(), c1538c.m7764d(), c1538c.m7766f(), this.f5192b, c1538c.m7767g(), c1538c.m7763c(), c1538c.m7762b(), c1538c.m7761a(), false, 100, C1640f.READY);
                    Iterator it = c1538c.m7770j().iterator();
                    while (it.hasNext()) {
                        C1539d c1539d = (C1539d) it.next();
                        C1629b.m8288a(this.f5191a, c1539d.m7778h(), c1539d.m7773c());
                        String uri = Uri.fromFile(new File(str2 + File.separator + c1539d.m7774d())).toString();
                        C1629b.m8292a(this.f5191a, c1539d.m7778h(), c1539d.m7773c(), c1538c.m7769i(), C1629b.m8293a(c1538c.m7769i(), c1539d.m7778h(), c1539d.m7773c()), Uri.fromFile(new File(str2 + File.separator + c1539d.m7772b())).toString(), uri, c1539d.m7775e(), c1539d.m7771a(), c1539d.m7776f(), c1539d.m7777g(), C1634g.FINISHED);
                    }
                }
                File file3 = new File(str);
                if (file3.isFile()) {
                    file3.delete();
                }
                if (this.f5193c == null) {
                    return;
                }
                if (c1538c != null) {
                    this.f5193c.m7760a(c1538c.m7765e());
                } else {
                    this.f5193c.m7760a(-1);
                }
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
    }

    public void m7780a(String str, int i) {
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
            fileInputStream = null;
        }
        if (fileInputStream != null) {
            m7779a(str, fileInputStream, i);
        } else if (this.f5193c != null) {
            this.f5193c.m7760a(-1);
        }
    }
}
