package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements OnTabChangeListener {
    private final ArrayList<C0112l> f681a;
    private Context f682b;
    private FragmentManager f683c;
    private int f684d;
    private OnTabChangeListener f685e;
    private C0112l f686f;
    private boolean f687g;

    class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        String f680a;

        static {
            CREATOR = new C0111k();
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f680a = parcel.readString();
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f680a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f680a);
        }
    }

    private FragmentTransaction m849a(String str, FragmentTransaction fragmentTransaction) {
        C0112l c0112l = null;
        int i = 0;
        while (i < this.f681a.size()) {
            C0112l c0112l2 = (C0112l) this.f681a.get(i);
            if (!c0112l2.f693a.equals(str)) {
                c0112l2 = c0112l;
            }
            i++;
            c0112l = c0112l2;
        }
        if (c0112l == null) {
            throw new IllegalStateException("No tab known for tag " + str);
        }
        if (this.f686f != c0112l) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.f683c.beginTransaction();
            }
            if (!(this.f686f == null || this.f686f.f696d == null)) {
                fragmentTransaction.detach(this.f686f.f696d);
            }
            if (c0112l != null) {
                if (c0112l.f696d == null) {
                    c0112l.f696d = Fragment.instantiate(this.f682b, c0112l.f694b.getName(), c0112l.f695c);
                    fragmentTransaction.add(this.f684d, c0112l.f696d, c0112l.f693a);
                } else {
                    fragmentTransaction.attach(c0112l.f696d);
                }
            }
            this.f686f = c0112l;
        }
        return fragmentTransaction;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i = 0; i < this.f681a.size(); i++) {
            C0112l c0112l = (C0112l) this.f681a.get(i);
            c0112l.f696d = this.f683c.findFragmentByTag(c0112l.f693a);
            if (!(c0112l.f696d == null || c0112l.f696d.isDetached())) {
                if (c0112l.f693a.equals(currentTabTag)) {
                    this.f686f = c0112l;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.f683c.beginTransaction();
                    }
                    fragmentTransaction.detach(c0112l.f696d);
                }
            }
        }
        this.f687g = true;
        FragmentTransaction a = m849a(currentTabTag, fragmentTransaction);
        if (a != null) {
            a.commit();
            this.f683c.executePendingTransactions();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f687g = false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f680a);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f680a = getCurrentTabTag();
        return savedState;
    }

    public void onTabChanged(String str) {
        if (this.f687g) {
            FragmentTransaction a = m849a(str, null);
            if (a != null) {
                a.commit();
            }
        }
        if (this.f685e != null) {
            this.f685e.onTabChanged(str);
        }
    }

    public void setOnTabChangedListener(OnTabChangeListener onTabChangeListener) {
        this.f685e = onTabChangeListener;
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}
