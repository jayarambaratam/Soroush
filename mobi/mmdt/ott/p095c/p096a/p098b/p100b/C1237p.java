package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1214q;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ak;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.p */
public class C1237p extends ai {
    public C1195v m6759a(JSONObject jSONObject) {
        String string = jSONObject.getString("MyRole");
        C1258f c1258f = string.equalsIgnoreCase(C1258f.OWNER.toString()) ? C1258f.OWNER : string.equalsIgnoreCase(C1258f.ADMIN.toString()) ? C1258f.ADMIN : string.equalsIgnoreCase(C1258f.MEMBER.toString()) ? C1258f.MEMBER : string.equalsIgnoreCase(C1258f.VISITOR.toString()) ? C1258f.VISITOR : C1258f.NONE;
        String str = BuildConfig.FLAVOR;
        if (jSONObject.has("GroupJID")) {
            str = jSONObject.getString("GroupJID");
        }
        C1195v c1214q = new C1214q(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), new ak(str, jSONObject.getString("GroupName"), c1258f, jSONObject.getString("GroupAvatarURL"), jSONObject.getString("GroupAvatarThumbnailURL"), jSONObject.getString("Description"), jSONObject.getInt("MembersCount"), jSONObject.getLong("CreationDate")));
        c1214q.m6614b(false);
        return c1214q;
    }
}
