package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016f.C0223a;

public final class MediaMetadataCompat implements Parcelable {
    public static final Creator<MediaMetadataCompat> CREATOR;
    private static final C0223a<String, Integer> f1184a;
    private static final String[] f1185b;
    private static final String[] f1186c;
    private static final String[] f1187d;
    private final Bundle f1188e;

    static {
        f1184a = new C0223a();
        f1184a.put("android.media.metadata.TITLE", Integer.valueOf(1));
        f1184a.put("android.media.metadata.ARTIST", Integer.valueOf(1));
        f1184a.put("android.media.metadata.DURATION", Integer.valueOf(0));
        f1184a.put("android.media.metadata.ALBUM", Integer.valueOf(1));
        f1184a.put("android.media.metadata.AUTHOR", Integer.valueOf(1));
        f1184a.put("android.media.metadata.WRITER", Integer.valueOf(1));
        f1184a.put("android.media.metadata.COMPOSER", Integer.valueOf(1));
        f1184a.put("android.media.metadata.COMPILATION", Integer.valueOf(1));
        f1184a.put("android.media.metadata.DATE", Integer.valueOf(1));
        f1184a.put("android.media.metadata.YEAR", Integer.valueOf(0));
        f1184a.put("android.media.metadata.GENRE", Integer.valueOf(1));
        f1184a.put("android.media.metadata.TRACK_NUMBER", Integer.valueOf(0));
        f1184a.put("android.media.metadata.NUM_TRACKS", Integer.valueOf(0));
        f1184a.put("android.media.metadata.DISC_NUMBER", Integer.valueOf(0));
        f1184a.put("android.media.metadata.ALBUM_ARTIST", Integer.valueOf(1));
        f1184a.put("android.media.metadata.ART", Integer.valueOf(2));
        f1184a.put("android.media.metadata.ART_URI", Integer.valueOf(1));
        f1184a.put("android.media.metadata.ALBUM_ART", Integer.valueOf(2));
        f1184a.put("android.media.metadata.ALBUM_ART_URI", Integer.valueOf(1));
        f1184a.put("android.media.metadata.USER_RATING", Integer.valueOf(3));
        f1184a.put("android.media.metadata.RATING", Integer.valueOf(3));
        f1184a.put("android.media.metadata.DISPLAY_TITLE", Integer.valueOf(1));
        f1184a.put("android.media.metadata.DISPLAY_SUBTITLE", Integer.valueOf(1));
        f1184a.put("android.media.metadata.DISPLAY_DESCRIPTION", Integer.valueOf(1));
        f1184a.put("android.media.metadata.DISPLAY_ICON", Integer.valueOf(2));
        f1184a.put("android.media.metadata.DISPLAY_ICON_URI", Integer.valueOf(1));
        f1184a.put("android.media.metadata.MEDIA_ID", Integer.valueOf(1));
        f1185b = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        f1186c = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        f1187d = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new C0251k();
    }

    private MediaMetadataCompat(Parcel parcel) {
        this.f1188e = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(this.f1188e);
    }
}
