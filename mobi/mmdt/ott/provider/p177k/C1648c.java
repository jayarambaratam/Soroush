package mobi.mmdt.ott.provider.p177k;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.k.c */
public class C1648c implements BaseColumns {
    public static final Uri f5460a;
    public static final String[] f5461b;

    static {
        f5460a = Uri.parse("content://mobi.mmdt.ott.provider/userinchatstates");
        f5461b = new String[]{"_id", "userinchatstates_sender", "userinchatstates_party", "userinchatstates_state"};
    }
}
