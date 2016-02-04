package mobi.mmdt.ott.p095c.p096a.p098b.p100b;

import java.util.ArrayList;
import mobi.mmdt.ott.p095c.p096a.C1263m;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.C1195v;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.aq;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ar;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.as;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.at;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.au;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.a.b.b.ak */
public class ak extends ai {
    C1263m f4439a;

    public ak(C1263m c1263m) {
        this.f4439a = c1263m;
    }

    public C1195v m6735a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = jSONObject.getJSONArray("Servers");
        for (int i = 0; i < jSONArray2.length(); i++) {
            JSONObject jSONObject2 = jSONArray2.getJSONObject(i);
            ar arVar = jSONObject2.getString("Application").equals("chat") ? ar.Chat : ar.Voip;
            as asVar = jSONObject2.getString("EncryptionMode").equals("plain") ? as.Plain : as.Encrypted;
            jSONArray = new JSONArray();
            JSONArray jSONArray3 = jSONObject2.getJSONArray("Protocol");
            at[] atVarArr = new at[jSONArray3.length()];
            for (int i2 = 0; i2 < jSONArray3.length(); i2++) {
                if (jSONArray3.getString(i2).equals("tcp")) {
                    atVarArr[i2] = at.TCP;
                } else if (jSONArray3.getString(i2).equals("udp")) {
                    atVarArr[i2] = at.UDP;
                } else {
                    atVarArr[i2] = at.TLS;
                }
            }
            arrayList.add(new aq(arVar, jSONObject2.getString("ServerAddress"), Integer.parseInt(jSONObject2.getString("PortNo")), atVarArr, jSONObject2.getString("Hostname"), jSONObject2.getString("Username"), jSONObject2.getString("Password"), asVar, jSONObject2.getString("Iv")));
        }
        C1195v auVar = new au(jSONObject.getString("ResultCode"), jSONObject.getString("ResultMessage"), arrayList, jSONObject.getLong("SinceLastConnection"));
        auVar.m6614b(false);
        return auVar;
    }
}
