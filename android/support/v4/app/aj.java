package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.view.bt;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class aj extends bt {
    private final C0151x f812a;
    private an f813b;
    private ArrayList<SavedState> f814c;
    private ArrayList<Fragment> f815d;
    private Fragment f816e;

    public aj(C0151x c0151x) {
        this.f813b = null;
        this.f814c = new ArrayList();
        this.f815d = new ArrayList();
        this.f816e = null;
        this.f812a = c0151x;
    }

    public Parcelable m1039a() {
        Bundle bundle = null;
        if (this.f814c.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new SavedState[this.f814c.size()];
            this.f814c.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f815d.size(); i++) {
            Fragment fragment = (Fragment) this.f815d.get(i);
            if (fragment != null && fragment.m991f()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f812a.m1384a(parcelable, "f" + i, fragment);
            }
        }
        return parcelable;
    }

    public abstract Fragment m1040a(int i);

    public Object m1041a(ViewGroup viewGroup, int i) {
        if (this.f815d.size() > i) {
            Fragment fragment = (Fragment) this.f815d.get(i);
            if (fragment != null) {
                return fragment;
            }
        }
        if (this.f813b == null) {
            this.f813b = this.f812a.m1383a();
        }
        Fragment a = m1040a(i);
        if (this.f814c.size() > i) {
            SavedState savedState = (SavedState) this.f814c.get(i);
            if (savedState != null) {
                a.m964a(savedState);
            }
        }
        while (this.f815d.size() <= i) {
            this.f815d.add(null);
        }
        a.m976b(false);
        a.m981c(false);
        this.f815d.set(i, a);
        this.f813b.m1056a(viewGroup.getId(), a);
        return a;
    }

    public void m1042a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f814c.clear();
            this.f815d.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f814c.add((SavedState) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    Fragment a = this.f812a.m1381a(bundle, str);
                    if (a != null) {
                        while (this.f815d.size() <= parseInt) {
                            this.f815d.add(null);
                        }
                        a.m976b(false);
                        this.f815d.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public void m1043a(ViewGroup viewGroup) {
    }

    public void m1044a(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f813b == null) {
            this.f813b = this.f812a.m1383a();
        }
        while (this.f814c.size() <= i) {
            this.f814c.add(null);
        }
        this.f814c.set(i, this.f812a.m1380a(fragment));
        this.f815d.set(i, null);
        this.f813b.m1058a(fragment);
    }

    public boolean m1045a(View view, Object obj) {
        return ((Fragment) obj).m996i() == view;
    }

    public void m1046b(ViewGroup viewGroup) {
        if (this.f813b != null) {
            this.f813b.m1060b();
            this.f813b = null;
            this.f812a.m1386b();
        }
    }

    public void m1047b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f816e) {
            if (this.f816e != null) {
                this.f816e.m976b(false);
                this.f816e.m981c(false);
            }
            if (fragment != null) {
                fragment.m976b(true);
                fragment.m981c(true);
            }
            this.f816e = fragment;
        }
    }
}
