package mobi.mmdt.ott.provider.p170d;

import android.net.Uri;
import android.provider.BaseColumns;

/* renamed from: mobi.mmdt.ott.provider.d.d */
public class C1599d implements BaseColumns {
    public static final Uri f5376a;
    public static final String[] f5377b;

    static {
        f5376a = Uri.parse("content://mobi.mmdt.ott.provider/files");
        f5377b = new String[]{"_id", "files_file_uri", "files_file_url", "files_server_file_id", "files_type", "files_name", "files_size", "files_progress", "files_thumbnail_uri", "files_thumbnail_url", "files_duration", "files_download_state", "files_thumbnail_download_state", "files_audio_state", "files_audio_playing_time"};
    }
}
