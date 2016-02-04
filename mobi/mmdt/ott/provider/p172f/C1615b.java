package mobi.mmdt.ott.provider.p172f;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.f.b */
public class C1615b implements BaseColumns {
    public static final Uri f5415a;
    public static final String[] f5416b;

    static {
        f5415a = Uri.parse("content://mobi.mmdt.ott.provider/members_group");
        f5416b = new String[]{"_id", "members_group_group_id", "members_group_user_id", "members_group_user_role", "members_group_added_by_me"};
    }
}
