package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import java.util.Iterator;
import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1211n;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ag;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.m */
public class C1234m extends ai {
    C1263m f4449a;

    public C1234m(C1263m c1263m) {
        this.f4449a = c1263m;
    }

    public C1195v m6756a(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = jSONObject.getJSONObject("MessagesLikeCount");
        Iterator keys = jSONObject3.keys();
        ag[] agVarArr = new ag[jSONObject3.length()];
        int i = 0;
        while (keys.hasNext()) {
            String str = (String) keys.next();
            agVarArr[i] = new ag(str, jSONObject3.getInt(str));
            i++;
        }
        C1195v c1211n = new C1211n(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), agVarArr);
        c1211n.m6614b(false);
        return c1211n;
    }
}
