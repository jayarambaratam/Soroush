package mobi.mmdt.ott.view.components.imageslider.Tricks;

import android.os.Parcelable;
import android.support.v4.view.bt;
import android.view.View;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.imageslider.C1839a;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Tricks.b */
public class C1824b extends bt {
    private C1839a f5942a;

    public C1824b(C1839a c1839a) {
        this.f5942a = c1839a;
    }

    private void m8902a(String str) {
    }

    public Parcelable m8903a() {
        return this.f5942a.m861a();
    }

    public Object m8904a(ViewGroup viewGroup, int i) {
        if (m8912e() == 0) {
            return null;
        }
        int e = i % m8912e();
        m8902a("instantiateItem: real position: " + i);
        m8902a("instantiateItem: virtual position: " + e);
        return this.f5942a.m8929a(viewGroup, e);
    }

    public void m8905a(Parcelable parcelable, ClassLoader classLoader) {
        this.f5942a.m865a(parcelable, classLoader);
    }

    public void m8906a(ViewGroup viewGroup) {
        this.f5942a.m868a(viewGroup);
    }

    public void m8907a(ViewGroup viewGroup, int i, Object obj) {
        if (m8912e() != 0) {
            int e = i % m8912e();
            m8902a("destroyItem: real position: " + i);
            m8902a("destroyItem: virtual position: " + e);
            this.f5942a.m8931a(viewGroup, e, obj);
        }
    }

    public boolean m8908a(View view, Object obj) {
        return this.f5942a.m8934a(view, obj);
    }

    public int m8909b() {
        return ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public void m8910b(ViewGroup viewGroup) {
        this.f5942a.m875b(viewGroup);
    }

    public C1839a m8911d() {
        return this.f5942a;
    }

    public int m8912e() {
        return this.f5942a.m8935b();
    }
}
