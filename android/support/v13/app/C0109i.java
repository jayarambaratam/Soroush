package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.support.v4.view.bt;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v13.app.i */
public abstract class C0109i extends bt {
    private final FragmentManager f690a;
    private FragmentTransaction f691b;
    private Fragment f692c;

    public C0109i(FragmentManager fragmentManager) {
        this.f691b = null;
        this.f692c = null;
        this.f690a = fragmentManager;
    }

    private static String m880a(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }

    public abstract Fragment m881a(int i);

    public Parcelable m882a() {
        return null;
    }

    public Object m883a(ViewGroup viewGroup, int i) {
        if (this.f691b == null) {
            this.f691b = this.f690a.beginTransaction();
        }
        long b = m888b(i);
        Fragment findFragmentByTag = this.f690a.findFragmentByTag(C0109i.m880a(viewGroup.getId(), b));
        if (findFragmentByTag != null) {
            this.f691b.attach(findFragmentByTag);
        } else {
            findFragmentByTag = m881a(i);
            this.f691b.add(viewGroup.getId(), findFragmentByTag, C0109i.m880a(viewGroup.getId(), b));
        }
        if (findFragmentByTag != this.f692c) {
            C0101a.m850a(findFragmentByTag, false);
            C0101a.m851b(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    public void m884a(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m885a(ViewGroup viewGroup) {
    }

    public void m886a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f691b == null) {
            this.f691b = this.f690a.beginTransaction();
        }
        this.f691b.detach((Fragment) obj);
    }

    public boolean m887a(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    public long m888b(int i) {
        return (long) i;
    }

    public void m889b(ViewGroup viewGroup) {
        if (this.f691b != null) {
            this.f691b.commitAllowingStateLoss();
            this.f691b = null;
            this.f690a.executePendingTransactions();
        }
    }

    public void m890b(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.f692c) {
            if (this.f692c != null) {
                C0101a.m850a(this.f692c, false);
                C0101a.m851b(this.f692c, false);
            }
            if (fragment != null) {
                C0101a.m850a(fragment, true);
                C0101a.m851b(fragment, true);
            }
            this.f692c = fragment;
        }
    }
}
