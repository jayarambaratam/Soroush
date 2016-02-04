package mobi.mmdt.ott.provider.p176j;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.j.b */
public class C1642b implements BaseColumns {
    public static final Uri f5457a;
    public static final String[] f5458b;

    static {
        f5457a = Uri.parse("content://mobi.mmdt.ott.provider/syncedcontacts");
        f5458b = new String[]{"_id", "syncedcontacts_phone_number", "syncedcontacts_extra_field"};
    }
}
