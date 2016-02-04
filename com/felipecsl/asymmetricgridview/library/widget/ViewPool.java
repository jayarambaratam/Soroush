package com.felipecsl.asymmetricgridview.library.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import java.util.Stack;

class ViewPool<T extends View> implements Parcelable {
    Stack<T> f3969a;
    C1063j<T> f3970b;
    C1066l f3971c;

    ViewPool() {
        this.f3969a = new Stack();
        this.f3970b = null;
        this.f3971c = new C1066l();
    }

    ViewPool(C1063j<T> c1063j) {
        this.f3969a = new Stack();
        this.f3970b = null;
        this.f3970b = c1063j;
    }

    T m6254a() {
        if (this.f3969a.size() > 0) {
            C1066l c1066l = this.f3971c;
            c1066l.f4003b++;
            c1066l = this.f3971c;
            c1066l.f4002a--;
            return (View) this.f3969a.pop();
        }
        c1066l = this.f3971c;
        c1066l.f4004c++;
        T b = this.f3970b != null ? this.f3970b.m6296b() : null;
        if (b == null) {
            return b;
        }
        C1066l c1066l2 = this.f3971c;
        c1066l2.f4005d++;
        return b;
    }

    String m6255a(String str) {
        return this.f3971c.m6301a(str);
    }

    void m6256a(T t) {
        this.f3969a.push(t);
        C1066l c1066l = this.f3971c;
        c1066l.f4002a++;
    }

    void m6257b() {
        this.f3971c = new C1066l();
        this.f3969a.clear();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
