package mobi.mmdt.ott.view.conversation.emojisticker.sticker;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.sticker.i */
final class C2229i implements Creator<StickerItemViewModel> {
    C2229i() {
    }

    public StickerItemViewModel m10122a(Parcel parcel) {
        return new StickerItemViewModel(parcel);
    }

    public StickerItemViewModel[] m10123a(int i) {
        return new StickerItemViewModel[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10122a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10123a(i);
    }
}
