package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentManagerState implements Parcelable {
    public static final Creator<FragmentManagerState> CREATOR;
    FragmentState[] f778a;
    int[] f779b;
    BackStackState[] f780c;

    static {
        CREATOR = new ag();
    }

    public FragmentManagerState(Parcel parcel) {
        this.f778a = (FragmentState[]) parcel.createTypedArray(FragmentState.CREATOR);
        this.f779b = parcel.createIntArray();
        this.f780c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f778a, i);
        parcel.writeIntArray(this.f779b);
        parcel.writeTypedArray(this.f780c, i);
    }
}
