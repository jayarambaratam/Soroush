package mobi.mmdt.ott.p095c;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ah;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ai;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.aj;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bn;
import mobi.mmdt.ott.p095c.p107c.C1291s;
import net.frakbot.glowpadbackport.BuildConfig;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: mobi.mmdt.ott.c.d */
public class C1303d {
    public static aj m6879a(JSONObject jSONObject) {
        boolean z = jSONObject.getString("Enable").equalsIgnoreCase("1");
        String string = jSONObject.getString("Type");
        ai aiVar = null;
        if (string.equalsIgnoreCase(ai.radio.toString())) {
            aiVar = ai.radio;
        } else if (string.equalsIgnoreCase(ai.checkbox.toString())) {
            aiVar = ai.checkbox;
        } else if (string.equalsIgnoreCase(ai.commentbox.toString())) {
            aiVar = ai.commentbox;
        }
        string = jSONObject.getString("PollID");
        boolean z2 = jSONObject.getString("HaveCommentBox").equalsIgnoreCase("1");
        JSONArray jSONArray = jSONObject.getJSONArray("Options");
        ah[] ahVarArr = new ah[jSONArray.length()];
        for (int i = 0; i < ahVarArr.length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            ahVarArr[i] = new ah(jSONObject2.getString("OptionID"), jSONObject2.getString("Text"), jSONObject2.getString("DisplayCommentBox").equalsIgnoreCase("1"));
        }
        return new aj(string, jSONObject.getString("Question"), z, aiVar, z2, jSONObject.getInt("CommentBoxCharsLimit"), ahVarArr);
    }

    public static JSONObject m6880a(bn bnVar) {
        JSONObject jSONObject = new JSONObject();
        String str = BuildConfig.FLAVOR;
        int i = 0;
        while (i < bnVar.m6695b().length) {
            str = i == 0 ? str + bnVar.m6695b()[i] : str + "," + bnVar.m6695b()[i];
            i++;
        }
        jSONObject.put("QuestionAnswer", str);
        jSONObject.put("QuestionComment", bnVar.m6694a());
        return jSONObject;
    }

    public static void m6881a(Context context) {
        if (!C1107a.m6377b(context)) {
            throw new C1291s();
        }
    }

    public static bn m6882b(JSONObject jSONObject) {
        return new bn(jSONObject.getString("QuestionAnswer").split(","), jSONObject.getString("QuestionComment"));
    }
}
