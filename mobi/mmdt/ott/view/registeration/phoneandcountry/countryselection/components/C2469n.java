package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.LayoutManager.SavedState;

/* renamed from: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.n */
final class C2469n implements Creator<SavedState> {
    C2469n() {
    }

    public SavedState m10780a(Parcel parcel) {
        return new SavedState(parcel);
    }

    public SavedState[] m10781a(int i) {
        return new SavedState[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m10780a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m10781a(i);
    }
}
