package mobi.mmdt.ott.logic.p112a.p147h;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.util.HashMap;
import mobi.mmdt.ott.logic.p112a.C1396d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.p178a.ak;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.logic.a.h.a */
public abstract class C1450a extends C0950c {
    protected HashMap<String, String> f4880a;
    protected HashMap<String, String> f4881b;
    protected HashMap<String, Uri> f4882c;
    protected Context f4883d;
    protected C1309a f4884e;

    protected C1450a(Context context, String str, String str2) {
        super(new C0990j(C1396d.f4795a));
        this.f4880a = new HashMap();
        this.f4881b = new HashMap();
        this.f4882c = new HashMap();
        this.f4883d = context;
        this.f4884e = C1309a.m6934a(this.f4883d);
        m7380b(str, str2);
    }

    private String m7379a(String str) {
        String str2 = BuildConfig.FLAVOR;
        String str3 = str2;
        for (char c : str.toCharArray()) {
            if (c == '0' || c == '1' || c == '2' || c == '3' || c == '4' || c == '5' || c == '6' || c == '7' || c == '8' || c == '9') {
                str3 = str3 + c;
            }
        }
        return str3;
    }

    private void m7380b(String str, String str2) {
        HashMap hashMap = new HashMap();
        Cursor query = this.f4883d.getContentResolver().query(Phone.CONTENT_URI, new String[]{"data1", "contact_id", "display_name"}, null, null, null);
        int columnIndex = query.getColumnIndex("data1");
        int columnIndex2 = query.getColumnIndex("contact_id");
        if (query.moveToFirst()) {
            do {
                String string = query.getString(columnIndex);
                String a = m7381a(str, string);
                long j = query.getLong(columnIndex2);
                if (hashMap.containsKey(Long.valueOf(j))) {
                    String[] strArr = (String[]) hashMap.get(Long.valueOf(j));
                    Object obj = new String[(strArr.length + 1)];
                    System.arraycopy(strArr, 0, obj, 0, strArr.length);
                    obj[obj.length - 1] = a;
                    hashMap.put(Long.valueOf(j), obj);
                } else {
                    hashMap.put(Long.valueOf(j), new String[]{a});
                }
                this.f4880a.put(a, string);
            } while (query.moveToNext());
        }
        query.close();
        String a2 = m7381a(str, str2);
        if (!this.f4880a.containsKey(a2)) {
            this.f4880a.put(a2, str2);
            this.f4881b.put(a2, "\u0000You");
        }
        ContentResolver contentResolver = this.f4883d.getContentResolver();
        Uri uri = Contacts.CONTENT_URI;
        String[] strArr2 = new String[3];
        strArr2[0] = "_id";
        strArr2[1] = ak.m8475a() ? "photo_uri" : "_id";
        strArr2[2] = ak.m8475a() ? "display_name" : "display_name";
        Cursor query2 = contentResolver.query(uri, strArr2, "has_phone_number <>?", new String[]{"0"}, null);
        int columnIndex3 = query2.getColumnIndex("_id");
        int columnIndex4 = query2.getColumnIndex(ak.m8475a() ? "photo_uri" : "_id");
        int columnIndex5 = query2.getColumnIndex(ak.m8475a() ? "display_name" : "display_name");
        if (query2.moveToFirst()) {
            do {
                strArr = (String[]) hashMap.get(Long.valueOf(query2.getLong(columnIndex3)));
                if (strArr != null) {
                    for (Object obj2 : strArr) {
                        String string2 = query2.getString(columnIndex5);
                        String string3 = query2.getString(columnIndex4);
                        uri = null;
                        if (string3 != null) {
                            uri = Uri.parse(string3);
                        }
                        if (!(string2 == null || string2.equals(BuildConfig.FLAVOR))) {
                            this.f4881b.put(obj2, string2);
                        }
                        if (!(uri == null || uri.equals(BuildConfig.FLAVOR))) {
                            this.f4882c.put(obj2, uri);
                        }
                    }
                }
            } while (query2.moveToNext());
        }
        query2.close();
        hashMap.clear();
    }

    protected String m7381a(String str, String str2) {
        if (str2.startsWith("+")) {
            str2 = str2.replaceFirst("\\+", "00");
        }
        String a = m7379a(str2);
        return a.startsWith("00") ? a.replaceFirst("00", BuildConfig.FLAVOR) : a.startsWith("0") ? str + a.replaceFirst("0", BuildConfig.FLAVOR) : a;
    }
}
