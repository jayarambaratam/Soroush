package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.media.session.MediaSessionCompat.QueueItem;

/* renamed from: android.support.v4.media.session.b */
final class C0254b implements Creator<QueueItem> {
    C0254b() {
    }

    public QueueItem m1785a(Parcel parcel) {
        return new QueueItem(null);
    }

    public QueueItem[] m1786a(int i) {
        return new QueueItem[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m1785a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m1786a(i);
    }
}
