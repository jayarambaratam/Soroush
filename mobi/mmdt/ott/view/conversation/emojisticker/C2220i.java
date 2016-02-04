package mobi.mmdt.ott.view.conversation.emojisticker;

import android.support.v4.view.bt;
import android.view.View;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.C2219f;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.C2231a;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.i */
class C2220i extends bt implements C2219f {
    final /* synthetic */ C2197c f7304a;

    public C2220i(C2197c c2197c) {
        this.f7304a = c2197c;
    }

    public Object m10094a(ViewGroup viewGroup, int i) {
        View a = ((C2195a) this.f7304a.f7232c.get(i)).m10032a();
        viewGroup.addView(a, 0);
        return a;
    }

    public C2231a m10095a(int i) {
        return (C2231a) this.f7304a.f7233d.get(i % this.f7304a.f7233d.size());
    }

    public void m10096a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public boolean m10097a(View view, Object obj) {
        return obj == view;
    }

    public int m10098b() {
        return this.f7304a.f7232c.size();
    }

    public CharSequence m10099c(int i) {
        return BuildConfig.FLAVOR;
    }
}
