package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import android.text.TextUtils;
import java.util.ArrayList;
import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ac;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bm;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.aq */
public class aq extends ai {
    C1263m f4444a;

    public aq(C1263m c1263m) {
        this.f4444a = c1263m;
    }

    public C1195v m6741a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.getJSONArray("Members");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("AvatarURL");
            if (TextUtils.isEmpty(string)) {
                string = null;
            }
            String string2 = jSONObject2.getString("AvatarThumbnailURL");
            if (TextUtils.isEmpty(string2)) {
                string2 = null;
            }
            arrayList.add(new ac(jSONObject2.getString("MemberID"), jSONObject2.getInt("CanReply"), string, string2, jSONObject2.getString("Nickname"), jSONObject2.getString("Motto"), jSONObject2.getInt("OfficialUser")));
        }
        C1195v bmVar = new bm(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), arrayList);
        bmVar.m6614b(false);
        return bmVar;
    }
}
