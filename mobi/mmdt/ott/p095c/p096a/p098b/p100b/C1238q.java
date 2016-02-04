package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1215r;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.al;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.q */
public class C1238q extends ai {
    public C1195v m6760a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("Members");
        al[] alVarArr = new al[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("Role");
            C1258f c1258f = string.equalsIgnoreCase(C1258f.OWNER.toString()) ? C1258f.OWNER : string.equalsIgnoreCase(C1258f.ADMIN.toString()) ? C1258f.ADMIN : string.equalsIgnoreCase(C1258f.MEMBER.toString()) ? C1258f.MEMBER : string.equalsIgnoreCase(C1258f.VISITOR.toString()) ? C1258f.VISITOR : C1258f.NONE;
            alVarArr[i] = new al(jSONObject2.getString("Username"), c1258f, jSONObject2.getInt("AddedByMe"), jSONObject2.getLong("LastActivity"));
        }
        C1195v c1215r = new C1215r(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), alVarArr);
        c1215r.m6614b(false);
        return c1215r;
    }
}
