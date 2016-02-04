package android.support.v4.media.session;

import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;

public class MediaSessionCompat {

    public final class QueueItem implements Parcelable {
        public static final Creator<QueueItem> CREATOR;
        private final MediaDescriptionCompat f1199a;
        private final long f1200b;

        static {
            CREATOR = new C0254b();
        }

        private QueueItem(Parcel parcel) {
            this.f1199a = (MediaDescriptionCompat) MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f1200b = parcel.readLong();
        }

        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f1199a + ", Id=" + this.f1200b + " }";
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f1199a.writeToParcel(parcel, i);
            parcel.writeLong(this.f1200b);
        }
    }

    final class ResultReceiverWrapper implements Parcelable {
        public static final Creator<ResultReceiverWrapper> CREATOR;
        private ResultReceiver f1201a;

        static {
            CREATOR = new C0255c();
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f1201a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            this.f1201a.writeToParcel(parcel, i);
        }
    }

    public final class Token implements Parcelable {
        public static final Creator<Token> CREATOR;
        private final Object f1202a;

        static {
            CREATOR = new C0256d();
        }

        Token(Object obj) {
            this.f1202a = obj;
        }

        public Object m1784a() {
            return this.f1202a;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            if (VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f1202a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f1202a);
            }
        }
    }
}
