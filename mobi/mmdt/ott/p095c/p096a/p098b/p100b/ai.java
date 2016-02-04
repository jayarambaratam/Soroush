package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p107c.C1276c;
import mobi.mmdt.ott.p095c.p107c.C1278e;
import mobi.mmdt.ott.p095c.p107c.C1279f;
import mobi.mmdt.ott.p095c.p107c.C1281h;
import mobi.mmdt.ott.p095c.p107c.C1283j;
import mobi.mmdt.ott.p095c.p107c.C1290r;
import mobi.mmdt.ott.p095c.p107c.C1293u;
import mobi.mmdt.ott.p095c.p107c.ab;
import mobi.mmdt.ott.p095c.p107c.ae;
import mobi.mmdt.ott.p095c.p107c.af;
import mobi.mmdt.ott.p095c.p107c.ag;
import mobi.mmdt.ott.p095c.p107c.aj;
import org.apache.http.myHttp.HttpStatus;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.ai */
public abstract class ai implements C1221x {
    public C1195v m6721a(JSONObject jSONObject, JSONObject jSONObject2) {
        int parseInt = Integer.parseInt(jSONObject.getString("ResultCode"));
        if (parseInt == 321 || parseInt == 322 || parseInt == 324) {
            throw new C1279f(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 315) {
            throw new C1293u(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == HttpStatus.SC_MOVED_PERMANENTLY) {
            throw new ae(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 310) {
            throw new C1276c(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 311 || parseInt == 320) {
            throw new C1290r(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 330) {
            throw new C1281h(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 335) {
            throw new ab(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == HttpStatus.SC_GONE) {
            throw new C1278e(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 601) {
            throw new af(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 316 || parseInt == 312) {
            throw new ag(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else if (parseInt == 313 || parseInt == 314) {
            throw new C1283j(parseInt, jSONObject.getString("ResultMessage"), jSONObject2);
        } else {
            throw new aj(jSONObject.getInt("ResultCode"), jSONObject.getString("ResultMessage"), jSONObject2);
        }
    }
}
