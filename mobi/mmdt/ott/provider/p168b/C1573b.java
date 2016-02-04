package mobi.mmdt.ott.provider.p168b;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.ott.p109d.p110a.C1305a;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.provider.b.b */
public class C1573b {
    public static long m7920a(Context context, String str, String str2, String str3, String str4, String str5, C1619f c1619f, int i, boolean z, long j, String str6) {
        C1575d c1575d = new C1575d();
        c1575d.m7937e(str3).m7931a(str2).m7935c(str4).m7936d(str5).m7932a(c1619f).m7929a(i).m7933a(z).m7930a(j).m7934b(str6);
        C1577f c1577f = new C1577f();
        c1577f.m7950a(str);
        return (long) c1575d.m7927a(context, c1577f);
    }

    public static long m7921a(Context context, String str, boolean z) {
        C1575d c1575d = new C1575d();
        c1575d.m7933a(z);
        C1577f c1577f = new C1577f();
        c1577f.m7950a(str);
        return (long) c1575d.m7927a(context, c1577f);
    }

    public static C1572a m7922a(Context context, String str) {
        C1577f c1577f = new C1577f();
        c1577f.m7950a(str);
        C1576e b = c1577f.m7952b(context);
        C1572a c1572a = null;
        if (b.moveToFirst()) {
            c1572a = new C1572a(b.m7938a(), b.m7939b(), b.m7940c(), b.m7941d(), b.m7942e(), b.m7944g(), b.m7945h(), b.m7946i(), b.m7947j(), b.m7948k());
        }
        b.close();
        return c1572a;
    }

    public static void m7923a(Context context, ArrayList<C1305a> arrayList) {
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1305a c1305a = (C1305a) it.next();
            contentValuesArr[i] = new ContentValues();
            contentValuesArr[i].put("CHANNELS_id", c1305a.m6892f());
            contentValuesArr[i].put("CHANNELS_name", c1305a.m6893g());
            contentValuesArr[i].put("CHANNELS_description", c1305a.m6895i());
            contentValuesArr[i].put("CHANNELS_avatar_url", c1305a.m6891e());
            contentValuesArr[i].put("CHANNELS_avatar_thumbnail_url", c1305a.m6890d());
            contentValuesArr[i].put("CHANNELS_my_role", Integer.valueOf(c1305a.m6889c().ordinal()));
            contentValuesArr[i].put("CHANNELS_followers", Integer.valueOf(c1305a.m6887a()));
            contentValuesArr[i].put("CHANNELS_is_mute", Boolean.valueOf(c1305a.m6896j()));
            contentValuesArr[i].put("CHANNELS_creation_date", Long.valueOf(c1305a.m6888b()));
            contentValuesArr[i].put("CHANNELS_is_reply_allowed", Boolean.valueOf(c1305a.m6897k()));
            contentValuesArr[i].put("CHANNELS_channel_owner", c1305a.m6894h());
            i++;
        }
        new C1577f().m7951a(context, contentValuesArr);
    }

    public static String m7924b(Context context, String str) {
        String str2 = null;
        C1577f c1577f = new C1577f();
        c1577f.m7950a(str);
        C1576e b = c1577f.m7952b(context);
        if (b.moveToFirst()) {
            str2 = b.m7943f();
        }
        b.close();
        return str2;
    }

    public static boolean m7925c(Context context, String str) {
        C1577f c1577f = new C1577f();
        c1577f.m7950a(str);
        C1576e b = c1577f.m7952b(context);
        if (b.getCount() > 0) {
            b.close();
            return true;
        }
        b.close();
        return false;
    }

    public static C1580g m7926d(Context context, String str) {
        String str2 = "SELECT CHANNELS._id , CHANNELS.CHANNELS_id , CHANNELS.CHANNELS_name , CHANNELS.CHANNELS_avatar_thumbnail_url , CHANNELS.CHANNELS_avatar_url , CHANNELS.CHANNELS_followers , CHANNELS.CHANNELS_description , CHANNELS.CHANNELS_is_mute , CHANNELS.CHANNELS_my_role   FROM CHANNELS WHERE CHANNELS_id = '" + str + "'";
        return new C1580g(context, C1574c.f5275a, str2, C1574c.f5275a);
    }
}
