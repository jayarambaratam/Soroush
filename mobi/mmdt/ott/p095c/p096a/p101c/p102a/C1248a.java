package mobi.mmdt.ott.p095c.p096a.p101c.p102a;

import android.net.Uri;
import java.io.File;
import mobi.mmdt.ott.p095c.p096a.p097a.C1167x;
import mobi.mmdt.ott.p095c.p108d.C1302c;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.c.a.c.a.a */
public class C1248a extends C1167x {
    public C1248a(Uri uri, String str, String str2, String str3) {
        super(str);
        put("FileHash", m6770a(uri));
        put("FileSize", m6772c(uri));
        put("FileName", m6771b(uri));
        put("PhoneNo", str);
        put("HashMethod", str2);
        put("AuthValue", BuildConfig.FLAVOR);
        put("AuthValue", C1167x.m6580a(this, str3));
    }

    private String m6770a(Uri uri) {
        return C1302c.m6876b(uri.getPath());
    }

    private String m6771b(Uri uri) {
        return new File(uri.getPath()).getName();
    }

    private String m6772c(Uri uri) {
        return new File(uri.getPath()).length() + BuildConfig.FLAVOR;
    }
}
