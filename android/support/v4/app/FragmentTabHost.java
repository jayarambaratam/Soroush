package android.support.v4.app;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<am> f793a;
    private Context f794b;
    private C0151x f795c;
    private int f796d;
    private OnTabChangeListener f797e;
    private am f798f;
    private boolean f799g;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        String f792a;

        static {
            CREATOR = new al();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f792a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f792a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f792a);
        }
    }

    private an m1017a(String str, an anVar) {
        am amVar = null;
        int i = 0;
        while (i < this.f793a.size()) {
            am amVar2 = (am) this.f793a.get(i);
            if (!amVar2.f817a.equals(str)) {
                amVar2 = amVar;
            }
            i++;
            amVar = amVar2;
        }
        if (amVar == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f798f != amVar) {
            if (anVar == null) {
                anVar = this.f795c.m1383a();
            }
            if (!(this.f798f == null || this.f798f.f820d == null)) {
                anVar.m1061b(this.f798f.f820d);
            }
            if (amVar != null) {
                if (amVar.f820d == null) {
                    amVar.f820d = Fragment.m942a(this.f794b, amVar.f818b.getName(), amVar.f819c);
                    anVar.m1057a(this.f796d, amVar.f820d, amVar.f817a);
                } else {
                    anVar.m1062c(amVar.f820d);
                }
            }
            this.f798f = amVar;
        }
        return anVar;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        an anVar = null;
        for (int i = 0; i < this.f793a.size(); i++) {
            am amVar = (am) this.f793a.get(i);
            amVar.f820d = this.f795c.m1382a(amVar.f817a);
            if (!(amVar.f820d == null || amVar.f820d.m993g())) {
                if (amVar.f817a.equals(currentTabTag)) {
                    this.f798f = amVar;
                } else {
                    if (anVar == null) {
                        anVar = this.f795c.m1383a();
                    }
                    anVar.m1061b(amVar.f820d);
                }
            }
        }
        this.f799g = true;
        an a = m1017a(currentTabTag, anVar);
        if (a != null) {
            a.m1055a();
            this.f795c.m1386b();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f799g = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f792a);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f792a = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        if (this.f799g) {
            an a = m1017a(str, null);
            if (a != null) {
                a.m1055a();
            }
        }
        if (this.f797e != null) {
            this.f797e.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f797e = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
