package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1213p;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ah;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.o */
public class C1236o extends ai {
    public C1195v m6758a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("PollResult");
        JSONArray jSONArray = jSONObject2.getJSONArray("Options");
        ah[] ahVarArr = new ah[jSONArray.length()];
        for (int i = 0; i < ahVarArr.length; i++) {
            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
            ahVarArr[i] = new ah(jSONObject3.getString("OptionID"), jSONObject3.getString("Text"), jSONObject3.getLong("VotesCount"));
        }
        C1195v c1213p = new C1213p(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject.getString("PollID"), new af(jSONObject2.getString("Question"), jSONObject2.getLong("TotalVotes"), jSONObject2.getString("UserVote"), ahVarArr));
        c1213p.m6614b(false);
        return c1213p;
    }
}
