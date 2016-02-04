package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1204g;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1209l;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.k */
public class C1232k extends ai {
    public C1195v m6754a(JSONObject jSONObject) {
        String string = jSONObject.getString("MyRole");
        C1258f c1258f = string.equalsIgnoreCase(C1258f.OWNER.toString()) ? C1258f.OWNER : string.equalsIgnoreCase(C1258f.ADMIN.toString()) ? C1258f.ADMIN : string.equalsIgnoreCase(C1258f.MEMBER.toString()) ? C1258f.MEMBER : string.equalsIgnoreCase(C1258f.VISITOR.toString()) ? C1258f.VISITOR : C1258f.NONE;
        C1195v c1209l = new C1209l(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), new C1204g(jSONObject.getString("ChannelID"), jSONObject.getString("Name"), c1258f, jSONObject.getString("AvatarURL"), jSONObject.getString("AvatarThumbnailURL"), jSONObject.getString("Description"), jSONObject.getInt("MembersCount"), jSONObject.getLong("CreationDate"), jSONObject.getInt("MembersCount"), jSONObject.getInt("ReplyAllowed"), jSONObject.getString("OwnerUsername"), jSONObject.getString("CategoryId")));
        c1209l.m6614b(false);
        return c1209l;
    }
}
