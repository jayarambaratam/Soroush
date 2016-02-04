package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1204g;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1212o;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ak;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.n */
public class C1235n extends ai {
    public C1195v m6757a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("Channels");
        C1204g[] c1204gArr = new C1204g[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("MyRole");
            C1258f c1258f = string.equalsIgnoreCase(C1258f.OWNER.toString()) ? C1258f.OWNER : string.equalsIgnoreCase(C1258f.ADMIN.toString()) ? C1258f.ADMIN : string.equalsIgnoreCase(C1258f.MEMBER.toString()) ? C1258f.MEMBER : string.equalsIgnoreCase(C1258f.VISITOR.toString()) ? C1258f.VISITOR : C1258f.NONE;
            c1204gArr[i] = new C1204g(jSONObject2.getString("ChannelID"), jSONObject2.getString("Name"), c1258f, jSONObject2.getString("AvatarURL"), jSONObject2.getString("AvatarThumbnailURL"), jSONObject2.getString("Description"), jSONObject2.getInt("MembersCount"), jSONObject2.getLong("CreationDate"), jSONObject2.getInt("MembersCount"), jSONObject2.getInt("ReplyAllowed"), jSONObject2.getString("OwnerUsername"), jSONObject2.getString("CategoryId"));
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("PrivateGroups");
        ak[] akVarArr = new ak[jSONArray2.length()];
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
            string = jSONObject3.getString("MyRole");
            c1258f = string.equals(C1258f.ADMIN.toString()) ? C1258f.ADMIN : string.equals(C1258f.MEMBER.toString()) ? C1258f.MEMBER : string.equals(C1258f.VISITOR.toString()) ? C1258f.VISITOR : string.equals(C1258f.OWNER.toString()) ? C1258f.OWNER : C1258f.NONE;
            akVarArr[i2] = new ak(jSONObject3.getString("GroupJID"), jSONObject3.getString("GroupName"), c1258f, jSONObject3.getString("GroupAvatarURL"), jSONObject3.getString("GroupAvatarThumbnailURL"), jSONObject3.getString("Description"), jSONObject3.getInt("MembersCount"), jSONObject3.getLong("CreationDate"));
        }
        C1195v c1212o = new C1212o(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), akVarArr, c1204gArr);
        c1212o.m6614b(false);
        return c1212o;
    }
}
