package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Creator<PlaybackStateCompat> CREATOR;
    private final int f1212a;
    private final long f1213b;
    private final long f1214c;
    private final float f1215d;
    private final long f1216e;
    private final CharSequence f1217f;
    private final long f1218g;
    private List<CustomAction> f1219h;
    private final long f1220i;
    private final Bundle f1221j;

    public final class CustomAction implements Parcelable {
        public static final Creator<CustomAction> CREATOR;
        private final String f1208a;
        private final CharSequence f1209b;
        private final int f1210c;
        private final Bundle f1211d;

        static {
            CREATOR = new C0259g();
        }

        private CustomAction(Parcel parcel) {
            this.f1208a = parcel.readString();
            this.f1209b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f1210c = parcel.readInt();
            this.f1211d = parcel.readBundle();
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + this.f1209b + ", mIcon=" + this.f1210c + ", mExtras=" + this.f1211d;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1208a);
            TextUtils.writeToParcel(this.f1209b, parcel, i);
            parcel.writeInt(this.f1210c);
            parcel.writeBundle(this.f1211d);
        }
    }

    static {
        CREATOR = new C0258f();
    }

    private PlaybackStateCompat(Parcel parcel) {
        this.f1212a = parcel.readInt();
        this.f1213b = parcel.readLong();
        this.f1215d = parcel.readFloat();
        this.f1218g = parcel.readLong();
        this.f1214c = parcel.readLong();
        this.f1216e = parcel.readLong();
        this.f1217f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1219h = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f1220i = parcel.readLong();
        this.f1221j = parcel.readBundle();
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PlaybackState {");
        stringBuilder.append("state=").append(this.f1212a);
        stringBuilder.append(", position=").append(this.f1213b);
        stringBuilder.append(", buffered position=").append(this.f1214c);
        stringBuilder.append(", speed=").append(this.f1215d);
        stringBuilder.append(", updated=").append(this.f1218g);
        stringBuilder.append(", actions=").append(this.f1216e);
        stringBuilder.append(", error=").append(this.f1217f);
        stringBuilder.append(", custom actions=").append(this.f1219h);
        stringBuilder.append(", active item id=").append(this.f1220i);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1212a);
        parcel.writeLong(this.f1213b);
        parcel.writeFloat(this.f1215d);
        parcel.writeLong(this.f1218g);
        parcel.writeLong(this.f1214c);
        parcel.writeLong(this.f1216e);
        TextUtils.writeToParcel(this.f1217f, parcel, i);
        parcel.writeTypedList(this.f1219h);
        parcel.writeLong(this.f1220i);
        parcel.writeBundle(this.f1221j);
    }
}
