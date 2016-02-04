package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class MediaBrowserCompat {

    public class MediaItem implements Parcelable {
        public static final Creator<MediaItem> CREATOR;
        private final int f1173a;
        private final MediaDescriptionCompat f1174b;

        static {
            CREATOR = new C0244d();
        }

        private MediaItem(Parcel parcel) {
            this.f1173a = parcel.readInt();
            this.f1174b = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("MediaItem{");
            stringBuilder.append("mFlags=").append(this.f1173a);
            stringBuilder.append(", mDescription=").append(this.f1174b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f1173a);
            this.f1174b.writeToParcel(parcel, i);
        }
    }
}
