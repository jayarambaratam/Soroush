package mobi.mmdt.ott.provider.p175i;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.i.b */
public class C1636b implements BaseColumns {
    public static final Uri f5447a;
    public static final String[] f5448b;

    static {
        f5447a = Uri.parse("content://mobi.mmdt.ott.provider/stickerspackage");
        f5448b = new String[]{"_id", "stickerspackage_package_version", "stickerspackage_package_id", "stickerspackage_count", "stickerspackage_price", "stickerspackage_designer", "stickerspackage_field", "stickerspackage_name", "stickerspackage_is_hidden", "stickerspackage_thumbnail_uri", "stickerspackage_progress", "stickerspackage_download_state", "stickerspackage_download_id", "stickerspackage_description"};
    }
}
