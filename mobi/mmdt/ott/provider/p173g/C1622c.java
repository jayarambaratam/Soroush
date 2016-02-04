package mobi.mmdt.ott.provider.p173g;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.ott.p109d.p110a.C1307c;
import mobi.mmdt.ott.provider.p172f.C1615b;
import mobi.mmdt.ott.provider.p172f.C1619f;

/* renamed from: mobi.mmdt.ott.provider.g.c */
public class C1622c {
    public static long m8251a(Context context, String str, String str2, String str3, String str4, String str5, C1619f c1619f, long j, boolean z, int i) {
        if (str == null) {
            throw new NullPointerException();
        }
        C1624e c1624e = new C1624e();
        c1624e.m8268d(str3).m8263a(str2).m8266b(str4).m8267c(str5).m8264a(c1619f).m8262a(j).m8265a(z).m8261a(i);
        C1627h c1627h = new C1627h();
        c1627h.m8282a(str);
        return (long) c1624e.m8259a(context, c1627h);
    }

    public static long m8252a(Context context, String str, boolean z) {
        C1624e c1624e = new C1624e();
        c1624e.m8265a(z);
        C1627h c1627h = new C1627h();
        c1627h.m8282a(str);
        return (long) c1624e.m8259a(context, c1627h);
    }

    public static void m8253a(Context context, ArrayList<C1307c> arrayList) {
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1307c c1307c = (C1307c) it.next();
            contentValuesArr[i] = new ContentValues();
            contentValuesArr[i].put("PrivateGroups_group_id", c1307c.m6912a());
            contentValuesArr[i].put("PrivateGroups_description", c1307c.m6914c());
            contentValuesArr[i].put("PrivateGroups_name", c1307c.m6913b());
            contentValuesArr[i].put("PrivateGroups_avatar_url", c1307c.m6915d());
            contentValuesArr[i].put("PrivateGroups_thumbnail_url", c1307c.m6916e());
            contentValuesArr[i].put("PrivateGroups_my_role", Integer.valueOf(c1307c.m6917f().ordinal()));
            contentValuesArr[i].put("PrivateGroups_creation_date", Long.valueOf(c1307c.m6918g()));
            contentValuesArr[i].put("PrivateGroups_is_mute", Boolean.valueOf(c1307c.m6919h()));
            contentValuesArr[i].put("PrivateGroups_extra", new C1626g(c1307c.m6920i()).m8278a());
            i++;
        }
        new C1627h().m8283a(context, contentValuesArr);
    }

    public static boolean m8254a(Context context, String str) {
        C1627h c1627h = new C1627h();
        c1627h.m8282a(str);
        C1625f b = c1627h.m8284b(context);
        if (b.getCount() > 0) {
            b.close();
            return true;
        }
        b.close();
        return false;
    }

    public static C1621b m8255b(Context context, String str) {
        C1627h c1627h = new C1627h();
        c1627h.m8282a(str);
        C1625f b = c1627h.m8284b(context);
        C1621b c1621b = null;
        if (b.moveToFirst()) {
            c1621b = new C1621b(b.m8269a(), b.m8270b(), b.m8271c(), b.m8272d(), b.m8273e(), b.m8274f(), b.m8275g(), b.m8276h());
        }
        b.close();
        return c1621b;
    }

    public static C1620a m8256c(Context context, String str) {
        String str2 = "SELECT PrivateGroups._id , PrivateGroups.PrivateGroups_group_id , PrivateGroups.PrivateGroups_name , PrivateGroups.PrivateGroups_thumbnail_url , PrivateGroups.PrivateGroups_avatar_url , PrivateGroups.PrivateGroups_description , PrivateGroups.PrivateGroups_is_mute , PrivateGroups.PrivateGroups_my_role   FROM PrivateGroups WHERE PrivateGroups_group_id = '" + str + "'";
        return new C1620a(context, C1623d.f5433a, str2, C1623d.f5433a, C1615b.f5415a);
    }

    public static int m8257d(Context context, String str) {
        int i = 0;
        C1627h c1627h = new C1627h();
        c1627h.m8282a(str);
        C1625f b = c1627h.m8284b(context);
        if (b.moveToFirst()) {
            i = b.m8277i();
        }
        b.close();
        return i;
    }

    public static int m8258e(Context context, String str) {
        return new C1627h().m8282a(str).m7905a(context);
    }
}
