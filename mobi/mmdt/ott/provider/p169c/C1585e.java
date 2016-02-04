package mobi.mmdt.ott.provider.p169c;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.c.e */
public class C1585e implements BaseColumns {
    public static final Uri f5294a;
    public static final String[] f5295b;

    static {
        f5294a = Uri.parse("content://mobi.mmdt.ott.provider/conversations");
        f5295b = new String[]{"_id", "conversations_message_id", "conversations_event_type", "conversations_event", "conversations_send_time", "conversations_receive_time", "conversations_direction_type", "conversations_event_state", "conversations_party", "conversations_peer_user_id", "conversations_group_type", "conversations_file_id", "conversations_sticker_id"};
    }
}
