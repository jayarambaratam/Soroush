package mobi.mmdt.ott.provider.p169c;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.provider.c.b */
public class C1582b {
    private static String f5278a;
    private static String f5279b;
    private static String f5280c;
    private static String f5281d;
    private static String f5282e;
    private static String f5283f;
    private static String f5284g;
    private String f5285h;
    private String f5286i;
    private String f5287j;
    private String f5288k;
    private String f5289l;
    private String f5290m;
    private C1594n f5291n;
    private JSONObject f5292o;

    static {
        f5278a = "REPLY_PARTY";
        f5279b = "REPLY_TEXT";
        f5280c = "REPLY_FILE_PATH";
        f5281d = "REPLY_THUMBNAIL_PATH";
        f5282e = "REPLY_STICKER_ID";
        f5283f = "REPLY_TYPE";
        f5284g = "REPLY_PEER_NAME";
    }

    public C1582b(String str, String str2, C1594n c1594n, String str3, String str4, String str5, String str6) {
        this.f5285h = str;
        this.f5291n = c1594n;
        this.f5286i = str3;
        this.f5287j = str4;
        this.f5288k = str5;
        this.f5289l = str6;
        this.f5290m = str2;
        this.f5292o = new JSONObject();
        try {
            this.f5292o.put(f5278a, this.f5285h);
            this.f5292o.put(f5284g, this.f5290m);
            this.f5292o.put(f5283f, c1594n.ordinal());
            this.f5292o.put(f5279b, m7958a(str3));
            this.f5292o.put(f5280c, m7958a(this.f5287j));
            this.f5292o.put(f5281d, m7958a(this.f5288k));
            this.f5292o.put(f5282e, m7958a(this.f5289l));
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    private String m7958a(String str) {
        return str == null ? BuildConfig.FLAVOR : str;
    }

    public String m7959a() {
        return this.f5292o.toString();
    }
}
