package mobi.mmdt.ott.provider.p172f;

import android.content.ContentValues;
import android.content.Context;
import java.util.ArrayList;
import mobi.mmdt.ott.provider.p171e.C1608b;

/* renamed from: mobi.mmdt.ott.provider.f.a */
public class C1614a {
    public static int m8228a(Context context, String str, String[] strArr) {
        C1617d c1617d = new C1617d();
        ((C1617d) c1617d.m8240a(str).m7912b()).m8244c(strArr);
        return c1617d.m7905a(context);
    }

    public static C1618e m8229a(Context context, String str) {
        String str2 = "SELECT members_group._id as _id,members_group.members_group_added_by_me,members_group.members_group_group_id,members_group.members_group_user_id,members_group.members_group_user_role,members.members_nick_name,members.members_avatar_url,members.members_avatar_thumbnail_url,members.members_user_id,members.members_last_online,members.members_can_reply,members.members_is_anouncer,members.members_local_name,members.members_moto,members.members_local_image_uri FROM ( members_group LEFT JOIN members ON members_group.members_group_user_id = members.members_user_id) WHERE members_group.members_group_group_id = '" + str + "'" + " ORDER BY " + "members" + "." + "members_last_online" + " DESC";
        return new C1618e(context, C1615b.f5415a, str2, C1615b.f5415a, C1608b.f5398a);
    }

    public static void m8230a(Context context, String str, ArrayList<String> arrayList, ArrayList<Boolean> arrayList2, ArrayList<C1619f> arrayList3) {
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            contentValuesArr[i] = new ContentValues();
            contentValuesArr[i].put("members_group_group_id", str);
            contentValuesArr[i].put("members_group_user_id", (String) arrayList.get(i));
            contentValuesArr[i].put("members_group_added_by_me", (Boolean) arrayList2.get(i));
            contentValuesArr[i].put("members_group_user_role", Integer.valueOf(((C1619f) arrayList3.get(i)).ordinal()));
        }
        new C1617d().m8241a(context, contentValuesArr);
    }

    public static boolean m8231a(Context context, String str, String str2) {
        C1617d c1617d = new C1617d();
        ((C1617d) c1617d.m8240a(str).m7912b()).m8243b(str2);
        C1616c b = c1617d.m8242b(context);
        if (b.getCount() > 0) {
            b.close();
            return true;
        }
        b.close();
        return false;
    }

    public static String[] m8232b(Context context, String str) {
        int i = 0;
        C1617d c1617d = new C1617d();
        c1617d.m8240a(str);
        C1616c b = c1617d.m8242b(context);
        String[] strArr = new String[b.getCount()];
        if (b.moveToFirst()) {
            while (true) {
                int i2 = i + 1;
                strArr[i] = b.m8235a();
                if (!b.moveToNext()) {
                    break;
                }
                i = i2;
            }
        }
        b.close();
        return strArr;
    }

    public static int m8233c(Context context, String str) {
        C1617d c1617d = new C1617d();
        c1617d.m8240a(str);
        C1616c b = c1617d.m8242b(context);
        int count = b.getCount();
        b.close();
        return count;
    }

    public static int m8234d(Context context, String str) {
        return new C1617d().m8240a(str).m7905a(context);
    }
}
