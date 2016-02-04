package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class RatingCompat implements Parcelable {
    public static final Creator<RatingCompat> CREATOR;
    private final int f1189a;
    private final float f1190b;

    static {
        CREATOR = new C0252l();
    }

    private RatingCompat(int i, float f) {
        this.f1189a = i;
        this.f1190b = f;
    }

    public int describeContents() {
        return this.f1189a;
    }

    public String toString() {
        return "Rating:style=" + this.f1189a + " rating=" + (this.f1190b < 0.0f ? "unrated" : String.valueOf(this.f1190b));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f1189a);
        parcel.writeFloat(this.f1190b);
    }
}
