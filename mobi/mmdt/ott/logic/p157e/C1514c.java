package mobi.mmdt.ott.logic.p157e;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p168b.C1573b;
import mobi.mmdt.ott.provider.p171e.C1607a;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.logic.e.c */
public class C1514c {
    private static C1514c f5080a;
    private Context f5081b;
    private C1518g f5082c;

    private C1514c(Context context) {
        this.f5081b = context;
        this.f5082c = C1518g.m7654a(this.f5081b);
    }

    private Map<String, String> m7636a(String str, String str2, String str3, String str4, String str5) {
        Map<String, String> hashMap = new HashMap();
        hashMap.put("MAJOR_TYPE", str);
        hashMap.put("MINOR_TYPE", str2);
        hashMap.put("VERSION", "1");
        hashMap.put("LONGITUDE", null);
        hashMap.put("LATITUDE", null);
        hashMap.put("SEND_TIME_IN_GMT", str3);
        hashMap.put("ENCRYPTED", "FALSE");
        hashMap.put("TIMEOUT", "0");
        if (!(str4 == null || str4.isEmpty())) {
            hashMap.put("REPLY_ON_MESSAGE_ID", str4);
            hashMap.put("REPLY_ON_THREAD_ID", str5);
        }
        return hashMap;
    }

    public static C1514c m7637a(Context context) {
        if (f5080a == null) {
            f5080a = new C1514c(context);
        }
        return f5080a;
    }

    public String m7638a(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, String str6, String str7) {
        String str8 = str3;
        Map a = m7636a(str8, "FILE", j + BuildConfig.FLAVOR, str7, str);
        a.put("FILE_TYPE", "FILE_TYPE_PUSH_TO_TALK");
        a.put("FILE_NAME", str5);
        a.put("FILE_SIZE", j2 + BuildConfig.FLAVOR);
        a.put("FILE_URL", str4);
        a.put("FILE_ID", str6);
        a.put("FILE_TYPE_PUSH_TO_TALK_DURATION", j3 + BuildConfig.FLAVOR);
        Object obj = -1;
        switch (str3.hashCode()) {
            case -2029760204:
                if (str3.equals("CHANNEL_CHAT")) {
                    obj = 2;
                    break;
                }
                break;
            case 763157957:
                if (str3.equals("SIMPLE_CHAT")) {
                    obj = null;
                    break;
                }
                break;
            case 1796630840:
                if (str3.equals("GROUP_CHAT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                return this.f5082c.m7663b().m7497a(str, BuildConfig.FLAVOR, str2, a, true);
            case VideoSize.CIF /*1*/:
                return this.f5082c.m7663b().m7496a(str, BuildConfig.FLAVOR, str2, a);
            case VideoSize.HVGA /*2*/:
                str8 = C1573b.m7924b(this.f5081b, str);
                a.put("MAJOR_TYPE", "CHANNEL_REPLY");
                a.put("REPLY_ON_THREAD_ID", str);
                a.put("SENDER_NICKNAME", C1607a.m8152a(this.f5081b, C1309a.m6934a(this.f5081b).m6942b()).m8202d());
                return this.f5082c.m7663b().m7497a(str8, BuildConfig.FLAVOR, str2, a, false);
            default:
                return null;
        }
    }

    public String m7639a(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7) {
        String str8 = str3;
        Map a = m7636a(str8, "STICKER", j + BuildConfig.FLAVOR, str7, str);
        a.put("STICKER_VERSION", str4);
        a.put("STICKER_PACKAGE_ID", str5);
        a.put("STICKER_ID", str6);
        Object obj = -1;
        switch (str3.hashCode()) {
            case -2029760204:
                if (str3.equals("CHANNEL_CHAT")) {
                    obj = 2;
                    break;
                }
                break;
            case 763157957:
                if (str3.equals("SIMPLE_CHAT")) {
                    obj = null;
                    break;
                }
                break;
            case 1796630840:
                if (str3.equals("GROUP_CHAT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                return this.f5082c.m7663b().m7497a(str, BuildConfig.FLAVOR, str2, a, true);
            case VideoSize.CIF /*1*/:
                return this.f5082c.m7663b().m7496a(str, BuildConfig.FLAVOR, str2, a);
            case VideoSize.HVGA /*2*/:
                str8 = C1573b.m7924b(this.f5081b, str);
                a.remove("REPLY_ON_MESSAGE_ID");
                a.put("MAJOR_TYPE", "CHANNEL_REPLY");
                a.put("REPLY_ON_THREAD_ID", str);
                a.put("SENDER_NICKNAME", C1607a.m8152a(this.f5081b, C1309a.m6934a(this.f5081b).m6942b()).m8202d());
                return this.f5082c.m7663b().m7497a(str8, BuildConfig.FLAVOR, str2, a, false);
            default:
                return null;
        }
    }

    public String m7640a(String str, String str2, String str3, String str4, long j, String str5) {
        String str6 = str3;
        Map a = m7636a(str6, "TEXT", j + BuildConfig.FLAVOR, str5, str);
        Object obj = -1;
        switch (str3.hashCode()) {
            case -2029760204:
                if (str3.equals("CHANNEL_CHAT")) {
                    obj = 2;
                    break;
                }
                break;
            case 763157957:
                if (str3.equals("SIMPLE_CHAT")) {
                    obj = null;
                    break;
                }
                break;
            case 1796630840:
                if (str3.equals("GROUP_CHAT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                return this.f5082c.m7663b().m7497a(str, str4, str2, a, true);
            case VideoSize.CIF /*1*/:
                return this.f5082c.m7663b().m7496a(str, str4, str2, a);
            case VideoSize.HVGA /*2*/:
                str6 = C1573b.m7924b(this.f5081b, str);
                a.put("MAJOR_TYPE", "CHANNEL_REPLY");
                a.put("REPLY_ON_THREAD_ID", str);
                a.put("SENDER_NICKNAME", C1607a.m8152a(this.f5081b, C1309a.m6934a(this.f5081b).m6942b()).m8202d());
                return this.f5082c.m7663b().m7497a(str6, str4, str2, a, false);
            default:
                return null;
        }
    }

    public String m7641a(String str, String str2, String str3, String str4, long j, String str5, long j2, String str6, String str7, String str8) {
        String str9 = str3;
        Map a = m7636a(str9, "FILE", j + BuildConfig.FLAVOR, str8, str);
        a.put("FILE_TYPE", "FILE_TYPE_OTHER");
        a.put("FILE_NAME", str6);
        a.put("FILE_SIZE", j2 + BuildConfig.FLAVOR);
        a.put("FILE_ID", str7);
        a.put("FILE_URL", str5);
        Object obj = -1;
        switch (str3.hashCode()) {
            case -2029760204:
                if (str3.equals("CHANNEL_CHAT")) {
                    obj = 2;
                    break;
                }
                break;
            case 763157957:
                if (str3.equals("SIMPLE_CHAT")) {
                    obj = null;
                    break;
                }
                break;
            case 1796630840:
                if (str3.equals("GROUP_CHAT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                return this.f5082c.m7663b().m7497a(str, str4, str2, a, true);
            case VideoSize.CIF /*1*/:
                return this.f5082c.m7663b().m7496a(str, str4, str2, a);
            case VideoSize.HVGA /*2*/:
                str9 = C1573b.m7924b(this.f5081b, str);
                a.put("MAJOR_TYPE", "CHANNEL_REPLY");
                a.put("REPLY_ON_THREAD_ID", str);
                a.put("SENDER_NICKNAME", C1607a.m8152a(this.f5081b, C1309a.m6934a(this.f5081b).m6942b()).m8202d());
                return this.f5082c.m7663b().m7497a(str9, str4, str2, a, false);
            default:
                return null;
        }
    }

    public String m7642a(String str, String str2, String str3, String str4, long j, String str5, String str6, long j2, long j3, String str7, String str8, String str9) {
        String str10 = str3;
        Map a = m7636a(str10, "FILE", j + BuildConfig.FLAVOR, str9, str);
        a.put("FILE_URL", str5);
        a.put("FILE_THUMBNAIL_URL", str6);
        a.put("FILE_SIZE", j2 + BuildConfig.FLAVOR);
        a.put("FILE_ID", str8);
        a.put("FILE_TYPE", "FILE_TYPE_VIDEO");
        a.put("FILE_NAME", str7);
        a.put("FILE_TYPE_VIDEO_DURATION", j3 + BuildConfig.FLAVOR);
        Object obj = -1;
        switch (str3.hashCode()) {
            case -2029760204:
                if (str3.equals("CHANNEL_CHAT")) {
                    obj = 2;
                    break;
                }
                break;
            case 763157957:
                if (str3.equals("SIMPLE_CHAT")) {
                    obj = null;
                    break;
                }
                break;
            case 1796630840:
                if (str3.equals("GROUP_CHAT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                return this.f5082c.m7663b().m7497a(str, str4, str2, a, true);
            case VideoSize.CIF /*1*/:
                return this.f5082c.m7663b().m7496a(str, str4, str2, a);
            case VideoSize.HVGA /*2*/:
                str10 = C1573b.m7924b(this.f5081b, str);
                a.put("MAJOR_TYPE", "CHANNEL_REPLY");
                a.put("REPLY_ON_THREAD_ID", str);
                a.put("SENDER_NICKNAME", C1607a.m8152a(this.f5081b, C1309a.m6934a(this.f5081b).m6942b()).m8202d());
                return this.f5082c.m7663b().m7497a(str10, str4, str2, a, false);
            default:
                return null;
        }
    }

    public String m7643a(String str, String str2, String str3, String str4, long j, String str5, String str6, long j2, String str7, String str8, String str9) {
        String str10 = str3;
        Map a = m7636a(str10, "FILE", j + BuildConfig.FLAVOR, str9, str);
        a.put("FILE_TYPE", "FILE_TYPE_IMAGE");
        a.put("FILE_NAME", str7);
        a.put("FILE_SIZE", j2 + BuildConfig.FLAVOR);
        a.put("FILE_ID", str8);
        a.put("FILE_URL", str5);
        a.put("FILE_THUMBNAIL_URL", str6);
        Object obj = -1;
        switch (str3.hashCode()) {
            case -2029760204:
                if (str3.equals("CHANNEL_CHAT")) {
                    obj = 2;
                    break;
                }
                break;
            case 763157957:
                if (str3.equals("SIMPLE_CHAT")) {
                    obj = null;
                    break;
                }
                break;
            case 1796630840:
                if (str3.equals("GROUP_CHAT")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                return this.f5082c.m7663b().m7497a(str, str4, str2, a, true);
            case VideoSize.CIF /*1*/:
                return this.f5082c.m7663b().m7496a(str, str4, str2, a);
            case VideoSize.HVGA /*2*/:
                str10 = C1573b.m7924b(this.f5081b, str);
                a.put("MAJOR_TYPE", "CHANNEL_REPLY");
                a.put("REPLY_ON_THREAD_ID", str);
                a.put("SENDER_NICKNAME", C1607a.m8152a(this.f5081b, C1309a.m6934a(this.f5081b).m6942b()).m8202d());
                return this.f5082c.m7663b().m7497a(str10, str4, str2, a, false);
            default:
                return null;
        }
    }
}
