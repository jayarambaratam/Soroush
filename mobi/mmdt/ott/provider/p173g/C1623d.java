package mobi.mmdt.ott.provider.p173g;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.g.d */
public class C1623d implements BaseColumns {
    public static final Uri f5433a;
    public static final String[] f5434b;

    static {
        f5433a = Uri.parse("content://mobi.mmdt.ott.provider/PrivateGroups");
        f5434b = new String[]{"_id", "PrivateGroups_group_id", "PrivateGroups_name", "PrivateGroups_thumbnail_url", "PrivateGroups_avatar_url", "PrivateGroups_description", "PrivateGroups_is_mute", "PrivateGroups_my_role"};
    }
}
