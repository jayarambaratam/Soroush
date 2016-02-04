package mobi.mmdt.ott.provider.p171e;

import android.content.ContentValues;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mobi.mmdt.ott.p109d.p110a.C1308d;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.provider.e.a */
public class C1607a {
    public static int m8150a(Context context, String str, String str2, String str3, String str4, String str5, String str6, boolean z, boolean z2, boolean z3, String str7, Uri uri) {
        if (str5 == null || str == null) {
            throw new NullPointerException();
        } else if (z && (str6 == null || str6.isEmpty())) {
            throw new NullPointerException();
        } else {
            C1609c c1609c = new C1609c();
            c1609c.m8173a(str).m8175b(str3).m8180d(str6).m8174a(z).m8179c(z2).m8176b(z3).m8182e(str7).m8178c(str4).m8183f(str2);
            if (uri != null) {
                c1609c.m8184g(uri.toString());
            } else {
                c1609c.m8177c();
            }
            return c1609c.m8171a(context, new C1612f().m8214a(str5));
        }
    }

    public static int m8151a(Context context, String str, boolean z) {
        C1609c c1609c = new C1609c();
        c1609c.m8181d(z);
        C1612f c1612f = new C1612f();
        c1612f.m8214a(str);
        return c1609c.m8171a(context, c1612f);
    }

    public static C1611e m8152a(Context context, String str) {
        C1612f c1612f = new C1612f();
        c1612f.m8214a(str);
        C1610d b = c1612f.m8217b(context);
        C1611e c1611e = null;
        if (b.moveToFirst()) {
            Uri uri = null;
            String m = b.m8197m();
            if (m != null) {
                uri = Uri.parse(m);
            }
            c1611e = new C1611e(b.m8185a(), b.m8186b(), b.m8187c(), b.m8188d(), b.m8189e(), b.m8190f(), b.m8191g(), b.m8192h(), b.m8194j(), b.m8193i(), b.m8195k(), b.m8196l(), uri, b.m8198n());
        }
        b.close();
        return c1611e;
    }

    public static void m8153a(Context context, ArrayList<C1308d> arrayList) {
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1308d c1308d = (C1308d) it.next();
            contentValuesArr[i] = new ContentValues();
            contentValuesArr[i].put("members_nick_name", c1308d.m6921a());
            contentValuesArr[i].put("members_avatar_url", c1308d.m6926f());
            contentValuesArr[i].put("members_avatar_thumbnail_url", c1308d.m6925e());
            contentValuesArr[i].put("members_user_id", c1308d.m6924d());
            contentValuesArr[i].put("members_local_phone_number", c1308d.m6923c());
            contentValuesArr[i].put("members_is_local_user", Boolean.valueOf(c1308d.m6933m()));
            contentValuesArr[i].put("members_is_anouncer", Boolean.valueOf(c1308d.m6930j()));
            contentValuesArr[i].put("members_can_reply", Boolean.valueOf(c1308d.m6932l()));
            contentValuesArr[i].put("members_local_name", c1308d.m6922b());
            contentValuesArr[i].put("members_is_new_user", Boolean.valueOf(false));
            contentValuesArr[i].put("members_moto", c1308d.m6927g());
            contentValuesArr[i].put("members_is_synced_contact", Boolean.valueOf(c1308d.m6929i()));
            contentValuesArr[i].put("members_is_deactivated_user", Boolean.valueOf(c1308d.m6931k()));
            if (c1308d.m6928h() != null) {
                contentValuesArr[i].put("members_local_image_uri", c1308d.m6928h().toString());
            } else {
                contentValuesArr[i].putNull("members_local_image_uri");
            }
            i++;
        }
        new C1612f().m8216a(context, contentValuesArr);
    }

    public static void m8154a(Context context, Map<String, Long> map) {
        if (map == null) {
            throw new NullPointerException();
        }
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        String str3 = str;
        str = str2;
        Object obj = 1;
        for (String str4 : map.keySet()) {
            if (obj != null) {
                str3 = str3 + "'" + str4;
                obj = null;
            } else {
                str3 = str3 + "','" + str4;
            }
            str = str + " WHEN members_user_id = '" + str4 + "' AND " + "members_last_online" + " < " + map.get(str4) + " THEN " + map.get(str4);
        }
        new C1612f().m8215a(context, "UPDATE members SET members_last_online = CASE " + str + " ELSE " + "members_last_online" + " END WHERE " + "members_user_id" + " IN (" + (str3 + "'") + ")");
    }

    public static void m8155a(Context context, String[] strArr, boolean z) {
        Object obj = 1;
        if (strArr == null) {
            throw new NullPointerException();
        }
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        int i = z ? 1 : 0;
        String str3 = str2;
        str2 = str;
        for (String str4 : strArr) {
            if (obj != null) {
                str2 = str2 + "'" + str4;
                obj = null;
            } else {
                str2 = str2 + "','" + str4;
            }
            str3 = str3 + " WHEN '" + str4 + "' THEN " + i + " ";
        }
        new C1612f().m8215a(context, "UPDATE members SET members_is_synced_contact = CASE members_user_id" + str3 + " END WHERE " + "members_user_id" + " IN (" + (str2 + "'") + ")");
    }

    public static String[] m8156a(Context context) {
        C1612f c1612f = new C1612f();
        c1612f.m8218b(true);
        C1610d b = c1612f.m8217b(context);
        String[] strArr = new String[b.getCount()];
        int i = 0;
        if (b.moveToFirst()) {
            while (!b.isAfterLast()) {
                int i2 = i + 1;
                strArr[i] = b.m8190f();
                b.moveToNext();
                i = i2;
            }
        }
        b.close();
        return strArr;
    }

    public static String[] m8157a(Context context, Uri[] uriArr) {
        int i = 0;
        if (uriArr.length < 998) {
            return C1607a.m8163b(context, uriArr);
        }
        int i2;
        int length = uriArr.length / 998;
        Set[] setArr = uriArr.length % 998 == 0 ? new Set[length] : new Set[(length + 1)];
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            Object obj = new String[998];
            System.arraycopy(uriArr, i3 * 998, obj, 0, obj.length);
            String[] b = C1607a.m8163b(context, uriArr);
            Set hashSet = new HashSet();
            for (Object add : b) {
                hashSet.add(add);
            }
            int i5 = i4 + 1;
            setArr[i4] = hashSet;
            i3++;
            i4 = i5;
        }
        if (uriArr.length % 998 != 0) {
            obj = new String[(uriArr.length % 998)];
            System.arraycopy(uriArr, length * 998, obj, 0, obj.length);
            String[] b2 = C1607a.m8163b(context, uriArr);
            Set hashSet2 = new HashSet();
            for (Object add2 : b2) {
                hashSet2.add(add2);
            }
            i2 = i4 + 1;
            setArr[i4] = hashSet2;
        }
        Collection hashSet3 = new HashSet();
        hashSet3.addAll(setArr[0]);
        i3 = setArr.length;
        while (i < i3) {
            hashSet3.retainAll(setArr[i]);
            i++;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet3);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] m8158a(Context context, String[] strArr) {
        int i = 0;
        if (strArr.length < 998) {
            return C1607a.m8170f(context, strArr);
        }
        int i2;
        int length = strArr.length / 998;
        ArrayList arrayList = new ArrayList();
        for (i2 = 0; i2 < length; i2++) {
            Object obj = new String[998];
            System.arraycopy(strArr, i2 * 998, obj, 0, obj.length);
            for (Object add : C1607a.m8170f(context, obj)) {
                arrayList.add(add);
            }
        }
        if (strArr.length % 998 != 0) {
            obj = new String[(strArr.length % 998)];
            System.arraycopy(strArr, length * 998, obj, 0, obj.length);
            String[] f = C1607a.m8170f(context, obj);
            i2 = f.length;
            while (i < i2) {
                arrayList.add(f[i]);
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static C1611e[] m8159a(Context context, List<String> list, boolean z) {
        C1612f c1612f = new C1612f();
        c1612f.m8213a(z);
        c1612f.m7912b();
        if (!(list == null || list.isEmpty())) {
            c1612f.m8219b((String) list.get(0));
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    c1612f.m7912b();
                    c1612f.m8219b((String) list.get(i));
                }
            }
        }
        C1610d b = c1612f.m8217b(context);
        C1611e[] c1611eArr = new C1611e[b.getCount()];
        if (b.moveToFirst()) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                c1611eArr[i2] = new C1611e(b.m8185a(), b.m8186b(), b.m8187c(), b.m8188d(), b.m8189e(), b.m8190f(), b.m8191g(), b.m8192h(), b.m8194j(), b.m8193i(), b.m8195k(), b.m8196l(), b.m8197m() != null ? Uri.parse(b.m8197m()) : null, b.m8198n());
                if (!b.moveToNext()) {
                    break;
                }
                i2 = i3;
            }
        }
        b.close();
        return c1611eArr;
    }

    public static CursorLoader m8160b(Context context, String str) {
        String[] strArr = new String[]{"_id", "members_avatar_url", "members_avatar_thumbnail_url", "members_local_name", "members_is_local_user", "members_moto", "members_local_image_uri", "members_user_id", "members_local_phone_number"};
        Uri uri = C1608b.f5398a;
        String str2 = "members_is_local_user =? and members_is_deactivated_user =? and (members_local_name LIKE '%" + str + "%' OR " + "members_local_phone_number" + " LIKE '%" + str + "%')";
        return new CursorLoader(context, uri, strArr, str2, new String[]{"1", "0"}, "members_local_name COLLATE NOCASE ASC ");
    }

    public static void m8161b(Context context, String[] strArr, boolean z) {
        Object obj = 1;
        if (strArr == null) {
            throw new NullPointerException();
        }
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        int i = z ? 1 : 0;
        String str3 = str2;
        str2 = str;
        for (String str4 : strArr) {
            if (obj != null) {
                str2 = str2 + "'" + str4;
                obj = null;
            } else {
                str2 = str2 + "','" + str4;
            }
            str3 = str3 + " WHEN '" + str4 + "' THEN " + i + " ";
        }
        new C1612f().m8215a(context, "UPDATE members SET members_is_local_user = CASE members_user_id" + str3 + " END WHERE " + "members_user_id" + " IN (" + (str2 + "'") + ")");
    }

    public static String[] m8162b(Context context) {
        C1612f c1612f = new C1612f();
        c1612f.m8218b(true);
        C1610d b = c1612f.m8217b(context);
        String[] strArr = new String[b.getCount()];
        int i = 0;
        if (b.moveToFirst()) {
            while (!b.isAfterLast()) {
                int i2 = i + 1;
                strArr[i] = b.m8189e();
                b.moveToNext();
                i = i2;
            }
        }
        b.close();
        return strArr;
    }

    private static String[] m8163b(Context context, Uri[] uriArr) {
        String[] strArr = new String[uriArr.length];
        int length = uriArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            strArr[i2] = uriArr[i].toString();
            i++;
            i2 = i3;
        }
        String[] strArr2 = new String[]{"members_user_id"};
        i2 = uriArr.length;
        StringBuilder stringBuilder = new StringBuilder(i2 * 2);
        for (i = 0; i < i2; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("?");
        }
        Cursor query = context.getContentResolver().query(C1608b.f5398a, strArr2, "members_local_image_uri NOT IN (" + stringBuilder.toString() + ")", strArr, null);
        strArr2 = new String[query.getCount()];
        if (query.moveToFirst()) {
            i = 0;
            while (!query.isAfterLast()) {
                strArr2[i] = query.getString(query.getColumnIndex("members_user_id"));
                i++;
                query.moveToNext();
            }
        }
        query.close();
        return strArr2;
    }

    public static String[] m8164b(Context context, String[] strArr) {
        int i = 0;
        if (strArr.length < 998) {
            return C1607a.m8168d(context, strArr);
        }
        int length = strArr.length / 998;
        Set[] setArr = strArr.length % 998 == 0 ? new Set[length] : new Set[(length + 1)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4;
            String[] strArr2 = new String[998];
            System.arraycopy(strArr, i2 * 998, strArr2, 0, strArr2.length);
            String[] d = C1607a.m8168d(context, strArr2);
            Set hashSet = new HashSet();
            for (Object add : d) {
                hashSet.add(add);
            }
            int i5 = i3 + 1;
            setArr[i3] = hashSet;
            i2++;
            i3 = i5;
        }
        if (strArr.length % 998 != 0) {
            strArr2 = new String[(strArr.length % 998)];
            System.arraycopy(strArr, length * 998, strArr2, 0, strArr2.length);
            String[] d2 = C1607a.m8168d(context, strArr2);
            Set hashSet2 = new HashSet();
            for (Object add2 : d2) {
                hashSet2.add(add2);
            }
            i4 = i3 + 1;
            setArr[i3] = hashSet2;
        }
        Collection hashSet3 = new HashSet();
        hashSet3.addAll(setArr[0]);
        i2 = setArr.length;
        while (i < i2) {
            hashSet3.retainAll(setArr[i]);
            i++;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet3);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static CursorLoader m8165c(Context context, String str) {
        return new CursorLoader(context, C1608b.f5398a, null, "members_user_id =? ", new String[]{str}, null);
    }

    public static String[] m8166c(Context context, String[] strArr) {
        int i = 0;
        if (strArr.length < 998) {
            return C1607a.m8169e(context, strArr);
        }
        int length = strArr.length / 998;
        Set[] setArr = strArr.length % 998 == 0 ? new Set[length] : new Set[(length + 1)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4;
            Object obj = new String[998];
            System.arraycopy(strArr, i2 * 998, obj, 0, obj.length);
            String[] e = C1607a.m8169e(context, obj);
            Set hashSet = new HashSet();
            for (Object add : e) {
                hashSet.add(add);
            }
            int i5 = i3 + 1;
            setArr[i3] = hashSet;
            i2++;
            i3 = i5;
        }
        if (strArr.length % 998 != 0) {
            obj = new String[(strArr.length % 998)];
            System.arraycopy(strArr, length * 998, obj, 0, obj.length);
            String[] e2 = C1607a.m8169e(context, obj);
            Set hashSet2 = new HashSet();
            for (Object add2 : e2) {
                hashSet2.add(add2);
            }
            i4 = i3 + 1;
            setArr[i3] = hashSet2;
        }
        Collection hashSet3 = new HashSet();
        hashSet3.addAll(setArr[0]);
        i2 = setArr.length;
        while (i < i2) {
            hashSet3.retainAll(setArr[i]);
            i++;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(hashSet3);
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean m8167d(Context context, String str) {
        C1612f c1612f = new C1612f();
        c1612f.m8214a(str);
        C1610d b = c1612f.m8217b(context);
        if (b.getCount() > 0) {
            b.close();
            return true;
        }
        b.close();
        return false;
    }

    private static String[] m8168d(Context context, String[] strArr) {
        int i;
        String[] strArr2 = new String[]{"members_user_id"};
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (i = 0; i < length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("?");
        }
        Cursor query = context.getContentResolver().query(C1608b.f5398a, strArr2, "members_user_id NOT IN (" + stringBuilder.toString() + ") " + " AND " + "members_is_local_user" + " = " + 1, strArr, null);
        strArr2 = new String[query.getCount()];
        if (query.moveToFirst()) {
            i = 0;
            while (!query.isAfterLast()) {
                strArr2[i] = query.getString(query.getColumnIndex("members_user_id"));
                i++;
                query.moveToNext();
            }
        }
        query.close();
        return strArr2;
    }

    private static String[] m8169e(Context context, String[] strArr) {
        int i;
        String[] strArr2 = new String[]{"members_user_id"};
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (i = 0; i < length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("?");
        }
        Cursor query = context.getContentResolver().query(C1608b.f5398a, strArr2, "members_local_name NOT IN (" + stringBuilder.toString() + ")", strArr, null);
        strArr2 = new String[query.getCount()];
        if (query.moveToFirst()) {
            i = 0;
            while (!query.isAfterLast()) {
                strArr2[i] = query.getString(query.getColumnIndex("members_user_id"));
                i++;
                query.moveToNext();
            }
        }
        query.close();
        return strArr2;
    }

    private static String[] m8170f(Context context, String[] strArr) {
        int i;
        String[] strArr2 = new String[]{"members_user_id"};
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (i = 0; i < length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("?");
        }
        Cursor query = context.getContentResolver().query(C1608b.f5398a, strArr2, "members_user_id IN (" + stringBuilder.toString() + ")", strArr, null);
        strArr2 = new String[query.getCount()];
        if (query.moveToFirst()) {
            i = 0;
            while (!query.isAfterLast()) {
                strArr2[i] = query.getString(query.getColumnIndex("members_user_id"));
                i++;
                query.moveToNext();
            }
        }
        query.close();
        return strArr2;
    }
}
