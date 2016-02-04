package mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.a */
final class C2211a implements Creator<Emojicon> {
    C2211a() {
    }

    public Emojicon m10090a(Parcel parcel) {
        return new Emojicon(parcel);
    }

    public Emojicon[] m10091a(int i) {
        return new Emojicon[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10090a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10091a(i);
    }
}
