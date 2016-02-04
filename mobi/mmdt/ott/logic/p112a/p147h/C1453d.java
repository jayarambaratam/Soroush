package mobi.mmdt.ott.logic.p112a.p147h;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1446a;
import mobi.mmdt.ott.logic.p112a.p147h.p148a.C1447b;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ac;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bk;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.bl;
import mobi.mmdt.ott.p109d.p110a.C1308d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p176j.C1641a;
import p000a.p001a.p002a.C0002c;

/* renamed from: mobi.mmdt.ott.logic.a.h.d */
public class C1453d extends C1450a {
    public C1453d(Context context) {
        super(context, C1309a.m6934a(context).m6954e(), C1309a.m6934a(context).m6957f());
    }

    private ArrayList<String> m7390a(String[] strArr) {
        int i = 0;
        if (strArr.length < 998) {
            return m7391b(strArr);
        }
        Collection b;
        int length = strArr.length / 998;
        Set[] setArr = strArr.length % 998 == 0 ? new Set[length] : new Set[(length + 1)];
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = new String[998];
            System.arraycopy(strArr, i2 * 998, obj, 0, obj.length);
            Collection b2 = m7391b(obj);
            Set hashSet = new HashSet();
            hashSet.addAll(b2);
            int i4 = i3 + 1;
            setArr[i3] = hashSet;
            i2++;
            i3 = i4;
        }
        if (strArr.length % 998 != 0) {
            Object obj2 = new String[(strArr.length % 998)];
            System.arraycopy(strArr, length * 998, obj2, 0, obj2.length);
            b = m7391b(obj2);
            Set hashSet2 = new HashSet();
            hashSet2.addAll(b);
            i2 = i3 + 1;
            setArr[i3] = hashSet2;
        }
        b = new HashSet();
        b.addAll(setArr[0]);
        i3 = setArr.length;
        while (i < i3) {
            b.retainAll(setArr[i]);
            i++;
        }
        ArrayList<String> arrayList = new ArrayList();
        arrayList.addAll(b);
        return arrayList;
    }

    private ArrayList<String> m7391b(String[] strArr) {
        int length = strArr.length;
        StringBuilder stringBuilder = new StringBuilder(length * 2);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append("?");
        }
        Cursor query = this.d.getContentResolver().query(Phone.CONTENT_URI, new String[]{"data1"}, "data1 NOT IN (" + stringBuilder.toString() + ")", strArr, null);
        length = query.getColumnIndex("data1");
        ArrayList<String> arrayList = new ArrayList();
        if (query.moveToFirst()) {
            do {
                C1104b.m6365a("ssss1 " + query.getString(length));
                arrayList.add(m7381a(this.e.m6954e(), query.getString(length)));
            } while (query.moveToNext());
        }
        query.close();
        return arrayList;
    }

    protected boolean m7392a(Throwable th) {
        C0002c.m2a().m17c(new C1447b(th));
        C1309a.m6934a(this.d).m6945b(false);
        return false;
    }

    public void m7393b() {
    }

    public void m7394c() {
        Iterator it;
        ArrayList arrayList = new ArrayList();
        String[] a = C1641a.m8370a(this.d);
        if (a.length == 0) {
            a = C1607a.m8156a(this.d);
        }
        ArrayList a2 = m7390a(a);
        String[] strArr = new String[this.a.size()];
        int i = 0;
        for (String str : this.a.keySet()) {
            String str2;
            int i2 = i + 1;
            strArr[i] = str2;
            i = i2;
        }
        strArr = C1607a.m8164b(this.d, strArr);
        for (Object obj : strArr) {
            C1104b.m6365a("*****  removeUserNames: " + ((String) this.a.get(obj)));
            C1641a.m8372c(this.d, (String) this.a.get(obj));
        }
        String[] strArr2 = new String[this.b.size()];
        i = 0;
        for (String str22 : this.b.keySet()) {
            i2 = i + 1;
            strArr2[i] = (String) this.b.get(str22);
            i = i2;
        }
        Uri[] uriArr = new Uri[this.c.size()];
        i = 0;
        for (String str222 : this.c.keySet()) {
            i2 = i + 1;
            uriArr[i] = (Uri) this.c.get(str222);
            i = i2;
        }
        if (strArr2.length != 0) {
            Collections.addAll(arrayList, C1607a.m8166c(this.d, strArr2));
        }
        if (uriArr.length != 0) {
            Collections.addAll(arrayList, C1607a.m8157a(this.d, uriArr));
        }
        if (strArr.length != 0) {
            C1607a.m8161b(this.d, strArr, false);
            C1607a.m8155a(this.d, strArr, false);
        }
        bk[] bkVarArr = new bk[((a2.size() + strArr.length) + arrayList.size())];
        if (bkVarArr.length != 0) {
            int i3;
            it = a2.iterator();
            i2 = 0;
            while (it.hasNext()) {
                str222 = (String) it.next();
                i3 = i2 + 1;
                bkVarArr[i2] = new bk((String) this.b.get(str222), str222, bl.Add);
                i2 = i3;
            }
            int length = strArr.length;
            i = i2;
            i2 = 0;
            while (i2 < length) {
                String str3 = strArr[i2];
                i3 = i + 1;
                bkVarArr[i] = new bk((String) this.b.get(str3), str3, bl.Delete);
                i2++;
                i = i3;
            }
            Iterator it2 = arrayList.iterator();
            i2 = i;
            while (it2.hasNext()) {
                String str4 = (String) it2.next();
                i3 = i2 + 1;
                bkVarArr[i2] = new bk((String) this.b.get(str4), str4, bl.Update);
                i2 = i3;
            }
            a2 = C1548c.m7822a(this.d).m7830a(bkVarArr).m6693a();
            String[] strArr3 = new String[a2.size()];
            Iterator it3 = a2.iterator();
            i = 0;
            while (it3.hasNext()) {
                i2 = i + 1;
                strArr3[i] = ((ac) it3.next()).m6618d();
                i = i2;
            }
            List asList = Arrays.asList(C1607a.m8158a(this.d, strArr3));
            ArrayList arrayList2 = new ArrayList();
            Iterator it4 = a2.iterator();
            while (it4.hasNext()) {
                ac acVar = (ac) it4.next();
                if (asList.contains(acVar.m6618d())) {
                    C1607a.m8150a(this.d, acVar.m6619e(), acVar.m6620f(), acVar.m6616b(), acVar.m6615a(), acVar.m6618d(), (String) this.a.get(acVar.m6618d()), this.a.containsKey(acVar.m6618d()), acVar.m6621g(), acVar.m6617c(), (String) this.b.get(acVar.m6618d()), (Uri) this.c.get(acVar.m6618d()));
                } else {
                    arrayList2.add(new C1308d(acVar.m6619e(), acVar.m6620f(), acVar.m6616b(), acVar.m6615a(), acVar.m6618d(), (String) this.a.get(acVar.m6618d()), this.a.containsKey(acVar.m6618d()), acVar.m6621g(), acVar.m6617c(), (String) this.b.get(acVar.m6618d()), (Uri) this.c.get(acVar.m6618d()), true, false));
                }
            }
            for (String str2222 : this.a.keySet()) {
                str2222 = (String) this.a.get(str2222);
                if (!C1641a.m8371b(this.d, str2222)) {
                    C1641a.m8369a(this.d, str2222);
                }
            }
            C1607a.m8153a(this.d, arrayList2);
        }
        C0002c.m2a().m17c(new C1446a());
        C1309a.m6934a(this.d).m6945b(true);
    }

    protected void m7395d() {
    }
}
