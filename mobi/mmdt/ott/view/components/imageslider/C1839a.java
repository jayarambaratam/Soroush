package mobi.mmdt.ott.view.components.imageslider;

import android.content.Context;
import android.support.v4.view.bt;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.ott.view.components.imageslider.p201b.C1838d;
import mobi.mmdt.ott.view.components.imageslider.p201b.C1840a;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.a */
public class C1839a extends bt implements C1838d {
    private ArrayList<C1840a> f5957a;

    public C1839a(Context context) {
        this.f5957a = new ArrayList();
    }

    public int m8928a(Object obj) {
        return -2;
    }

    public Object m8929a(ViewGroup viewGroup, int i) {
        View d = ((C1840a) this.f5957a.get(i)).m8948d();
        viewGroup.addView(d);
        return d;
    }

    public C1840a m8930a(int i) {
        return (i < 0 || i >= this.f5957a.size()) ? null : (C1840a) this.f5957a.get(i);
    }

    public void m8931a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public <T extends C1840a> void m8932a(T t) {
        t.m8943a((C1838d) this);
        this.f5957a.add(t);
        m878c();
    }

    public void m8933a(boolean z, C1840a c1840a) {
        if (c1840a.m8944a() && !z) {
            Iterator it = this.f5957a.iterator();
            while (it.hasNext()) {
                if (((C1840a) it.next()).equals(c1840a)) {
                    m8936b(c1840a);
                    return;
                }
            }
        }
    }

    public boolean m8934a(View view, Object obj) {
        return view == obj;
    }

    public int m8935b() {
        return this.f5957a.size();
    }

    public <T extends C1840a> void m8936b(T t) {
        if (this.f5957a.contains(t)) {
            this.f5957a.remove(t);
            m878c();
        }
    }

    public void m8937c(C1840a c1840a) {
    }
}
