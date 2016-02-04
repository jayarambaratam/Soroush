package mobi.mmdt.ott.logic.p112a.p117b.p119b;

import android.content.Context;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.HashMap;
import java.util.Map;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1338d;
import mobi.mmdt.ott.logic.p112a.p117b.p118a.C1339e;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1383q;
import mobi.mmdt.ott.logic.p164k.C1546a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1593m;
import org.json.JSONObject;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.b.b.e */
public class C1353e extends C0950c {
    private String f4630a;
    private String f4631b;
    private Context f4632c;
    private int f4633d;
    private int f4634e;
    private boolean f4635f;
    private boolean f4636g;

    public C1353e(Context context, String str, int i, int i2) {
        super(new C0990j(C1396d.f4796b));
        this.f4636g = false;
        this.f4632c = context;
        this.f4630a = str;
        this.f4633d = i;
        this.f4634e = i2;
        this.f4631b = null;
        this.f4635f = false;
    }

    public C1353e(Context context, String str, String str2, int i, int i2) {
        super(new C0990j(C1396d.f4796b));
        this.f4636g = false;
        this.f4632c = context;
        this.f4630a = str;
        this.f4633d = i;
        this.f4634e = i2;
        this.f4631b = str2;
        this.f4635f = true;
    }

    private Map<String, String> m7047a(JSONObject jSONObject) {
        String string = jSONObject.getString("MINOR_TYPE");
        Map<String, String> hashMap = new HashMap();
        hashMap.put("MAJOR_TYPE", jSONObject.getString("MAJOR_TYPE"));
        hashMap.put("MINOR_TYPE", string);
        hashMap.put("SEND_TIME_IN_GMT", jSONObject.getString("SEND_TIME_IN_GMT"));
        if (string.equals("STICKER")) {
            hashMap.put("STICKER_ID", jSONObject.getString("STICKER_ID"));
            hashMap.put("STICKER_PACKAGE_ID", jSONObject.getString("STICKER_PACKAGE_ID"));
            hashMap.put("STICKER_VERSION", jSONObject.getString("STICKER_VERSION"));
        }
        if (string.equals("FILE")) {
            hashMap.put("FILE_TYPE", jSONObject.getString("FILE_TYPE"));
            hashMap.put("FILE_NAME", jSONObject.getString("FILE_NAME"));
            hashMap.put("FILE_URL", jSONObject.getString("FILE_URL"));
            hashMap.put("FILE_ID", jSONObject.getString("FILE_ID"));
            hashMap.put("FILE_SIZE", jSONObject.getString("FILE_SIZE"));
            if (jSONObject.getString("FILE_TYPE").equals("FILE_TYPE_IMAGE") || jSONObject.getString("FILE_TYPE").equals("FILE_TYPE_VIDEO")) {
                hashMap.put("FILE_THUMBNAIL_URL", jSONObject.getString("FILE_THUMBNAIL_URL"));
            }
            if (jSONObject.getString("FILE_TYPE").equals("FILE_TYPE_PUSH_TO_TALK")) {
                hashMap.put("FILE_TYPE_PUSH_TO_TALK_DURATION", jSONObject.getString("FILE_TYPE_PUSH_TO_TALK_DURATION"));
            }
            if (jSONObject.getString("FILE_TYPE").equals("FILE_TYPE_VIDEO")) {
                hashMap.put("FILE_TYPE_VIDEO_DURATION", jSONObject.getString("FILE_TYPE_VIDEO_DURATION"));
            }
        }
        if (string.equals("POLL")) {
            hashMap.put("POLL_ID", jSONObject.getString("POLL_ID"));
            hashMap.put("POLL_DATA", jSONObject.getString("POLL_DATA"));
        }
        return hashMap;
    }

    protected boolean m7048a(Throwable th) {
        C0002c.m2a().m17c(new C1338d(th, this.f4630a));
        return false;
    }

    public void m7049b() {
    }

    public void m7050c() {
        boolean z = true;
        C1309a.m6934a(this.f4632c).m6942b();
        String[] a = C1546a.m7793a(this.f4632c).m7802a(this.f4630a, this.f4633d, this.f4634e, this.f4631b).m6707a();
        for (String jSONObject : a) {
            JSONObject jSONObject2 = new JSONObject(jSONObject);
            String string = jSONObject2.getString("CHANNEL_ID");
            String string2 = jSONObject2.getString("USER_ID");
            String string3 = jSONObject2.getString("MESSAGE_ID");
            String string4 = jSONObject2.getString("MESSAGE_BODY");
            Map a2 = m7047a(jSONObject2);
            if (!C1583c.m7972a(this.f4632c, string3, C1592l.IN)) {
                C1494c.m7540b(new C1383q(this.f4632c, string2, string, string4, string3, a2, C1593m.READ));
            }
            if (!this.f4636g) {
                this.f4636g = true;
                C0002c.m2a().m17c(new C1339e(this.f4630a, this.f4635f, a.length > 0));
            }
        }
        if (!this.f4636g) {
            C0002c a3 = C0002c.m2a();
            string2 = this.f4630a;
            boolean z2 = this.f4635f;
            if (a.length <= 0) {
                z = false;
            }
            a3.m17c(new C1339e(string2, z2, z));
        }
    }

    protected void m7051d() {
    }
}
