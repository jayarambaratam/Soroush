package mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.C2209b;

public class Emojicon implements Parcelable {
    public static final Creator<Emojicon> CREATOR;
    private int f7294a;
    private char f7295b;
    private String f7296c;

    static {
        CREATOR = new C2211a();
    }

    private Emojicon() {
    }

    public Emojicon(Parcel parcel) {
        this.f7294a = parcel.readInt();
        this.f7295b = (char) parcel.readInt();
        this.f7296c = parcel.readString();
    }

    public static Emojicon m10084a(char c) {
        Emojicon emojicon = new Emojicon();
        emojicon.f7296c = Character.toString(c);
        emojicon.f7294a = C2209b.f7283b.get(c);
        return emojicon;
    }

    public static Emojicon m10085a(int i) {
        Emojicon emojicon = new Emojicon();
        emojicon.f7296c = m10087b(i);
        emojicon.f7294a = C2209b.f7283b.get(i);
        return emojicon;
    }

    public static Emojicon m10086a(String str) {
        Emojicon emojicon = new Emojicon();
        emojicon.f7296c = str;
        if (C2209b.f7282a.containsKey(str)) {
            emojicon.f7294a = ((Integer) C2209b.f7282a.get(str)).intValue();
        }
        return emojicon;
    }

    public static final String m10087b(int i) {
        return Character.charCount(i) == 1 ? String.valueOf(i) : new String(Character.toChars(i));
    }

    public int m10088a() {
        return this.f7294a;
    }

    public String m10089b() {
        return this.f7296c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Emojicon) && this.f7296c.equals(((Emojicon) obj).f7296c);
    }

    public int hashCode() {
        return this.f7296c.hashCode();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f7294a);
        parcel.writeInt(this.f7295b);
        parcel.writeString(this.f7296c);
    }
}
