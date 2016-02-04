package mobi.mmdt.ott.provider.p174h;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.h.c */
public class C1630c implements BaseColumns {
    public static final Uri f5439a;
    public static final String[] f5440b;

    static {
        f5439a = Uri.parse("content://mobi.mmdt.ott.provider/stickers");
        f5440b = new String[]{"_id", "stickers_complete_sticker_id", "stickers_sticker_id", "stickers_package_id", "stickers_sticker_version", "stickers_original_uri", "stickers_thumbnail_uri", "stickers_download_state", "stickers_x_axis", "stickers_y_axis", "stickers_ver_span", "stickers_hor_span"};
    }
}
