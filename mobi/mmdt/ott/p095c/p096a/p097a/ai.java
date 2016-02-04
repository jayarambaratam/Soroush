package mobi.mmdt.ott.p095c.p096a.p097a;

import mobi.mmdt.ott.p095c.p096a.C1254c;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.packet.XMPPError;

/* renamed from: mobi.mmdt.ott.c.a.a.ai */
public class ai extends C1167x {
    public ai(String str, String str2, String str3, String str4, C1254c c1254c, String str5, String str6, String str7, String str8) {
        super(str);
        put("Username", str);
        put("OSVersion", str2);
        put("NetType", str3);
        put("ReportTitle", str4);
        put("ReportType", m6582a(c1254c));
        put("ReportDescription", str5);
        put("ReportData", str6);
        put("HashMethod", str7);
        put("AuthValue", BuildConfig.FLAVOR);
        String a = C1167x.m6580a(this, str8);
        remove("AuthValue");
        put("AuthValue", a);
    }

    String m6582a(C1254c c1254c) {
        return c1254c == C1254c.bug ? "bug" : c1254c == C1254c.error ? XMPPError.ERROR : c1254c == C1254c.info ? "info" : "bug";
    }
}
