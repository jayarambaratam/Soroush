package mobi.mmdt.ott.provider.p171e;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.e.b */
public class C1608b implements BaseColumns {
    public static final Uri f5398a;
    public static final String[] f5399b;

    static {
        f5398a = Uri.parse("content://mobi.mmdt.ott.provider/members");
        f5399b = new String[]{"_id", "members_nick_name", "members_avatar_url", "members_avatar_thumbnail_url", "members_user_id", "members_local_phone_number", "members_last_online", "members_is_local_user", "members_can_reply", "members_is_anouncer", "members_local_name", "members_moto", "members_local_image_uri", "members_is_new_user", "members_is_deactivated_user", "members_is_synced_contact"};
    }
}
