package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.C1258f;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1204g;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1208k;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1216t;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.j */
public class C1231j extends ai {
    public C1195v m6753a(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("Channels");
        C1204g[] c1204gArr = new C1204g[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            String string = jSONObject2.getString("MyRole");
            C1258f c1258f = string.equalsIgnoreCase(C1258f.OWNER.toString()) ? C1258f.OWNER : string.equalsIgnoreCase(C1258f.ADMIN.toString()) ? C1258f.ADMIN : string.equalsIgnoreCase(C1258f.MEMBER.toString()) ? C1258f.MEMBER : string.equalsIgnoreCase(C1258f.VISITOR.toString()) ? C1258f.VISITOR : C1258f.NONE;
            c1204gArr[i] = new C1204g(jSONObject2.getString("ChannelID"), jSONObject2.getString("Name"), c1258f, jSONObject2.getString("AvatarURL"), jSONObject2.getString("AvatarThumbnailURL"), jSONObject2.getString("Description"), jSONObject2.getInt("MembersCount"), jSONObject2.getLong("CreationDate"), jSONObject2.getInt("Followed"), jSONObject2.getInt("ReplyAllowed"), jSONObject2.getString("OwnerUsername"), jSONObject2.getString("CategoryId"));
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("Categories");
        C1216t[] c1216tArr = new C1216t[jSONArray2.length()];
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            JSONObject jSONObject3 = jSONArray2.getJSONObject(i2);
            c1216tArr[i2] = new C1216t(jSONObject3.getString("CategoryId"), jSONObject3.getString("CategoryName"), jSONObject3.getString("BannerUrl"), jSONObject3.getString("Description"), jSONObject3.getString("ParentCategoryId"));
        }
        C1195v c1208k = new C1208k(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getInt("CategoriesCount"), jSONObject.getInt("ChannelsCount"), c1216tArr, c1204gArr);
        c1208k.m6614b(false);
        return c1208k;
    }
}
