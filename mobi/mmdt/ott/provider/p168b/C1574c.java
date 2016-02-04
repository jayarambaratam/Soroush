package mobi.mmdt.ott.provider.p168b;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.b.c */
public class C1574c implements BaseColumns {
    public static final Uri f5275a;
    public static final String[] f5276b;

    static {
        f5275a = Uri.parse("content://mobi.mmdt.ott.provider/CHANNELS");
        f5276b = new String[]{"_id", "CHANNELS_id", "CHANNELS_name", "CHANNELS_avatar_thumbnail_url", "CHANNELS_avatar_url", "CHANNELS_description", "CHANNELS_followers", "CHANNELS_is_mute", "CHANNELS_my_role", "CHANNELS_creation_date", "CHANNELS_is_reply_allowed"};
    }
}
