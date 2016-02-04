package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import android.util.Base64;
import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1196a;
import mobi.mmdt.ott.p095c.p108d.C1300a;
import mobi.mmdt.ott.p095c.p108d.C1302c;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.a */
public class C1222a extends ai {
    private C1263m f4431a;

    public C1222a(C1263m c1263m) {
        this.f4431a = c1263m;
    }

    private static String m6722a(String str, String str2, String str3, String str4, String str5) {
        String a = C1302c.m6874a(str + str2 + str3);
        byte[] decode = Base64.decode(str5, 0);
        C1300a.m6866a(a);
        C1300a.m6867a(str4, decode);
        return C1300a.m6865a();
    }

    public C1195v m6723a(JSONObject jSONObject) {
        C1195v c1196a = new C1196a(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("Username"));
        c1196a.m6614b(false);
        this.f4431a.m6852g(C1222a.m6722a(jSONObject.getString("Username"), this.f4431a.m6839a(), this.f4431a.m6841b(), jSONObject.getString("EToken"), jSONObject.getString("Iv")));
        return c1196a;
    }
}
