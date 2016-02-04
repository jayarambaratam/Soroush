package mobi.mmdt.ott.view.components.mediacaption;

import android.support.v4.app.C0151x;
import android.support.v4.app.Fragment;
import android.support.v4.app.aj;
import java.util.ArrayList;
import java.util.Map.Entry;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.components.mediacaption.h */
public class C1885h extends aj {
    final /* synthetic */ MediaCaptionActivity f6055a;
    private ArrayList<String> f6056b;

    public C1885h(MediaCaptionActivity mediaCaptionActivity, C0151x c0151x, ArrayList<String> arrayList) {
        this.f6055a = mediaCaptionActivity;
        super(c0151x);
        this.f6056b = new ArrayList();
        this.f6056b = arrayList;
    }

    public int m9038a(Object obj) {
        return -2;
    }

    public Fragment m9039a(int i) {
        String str = (String) this.f6056b.get(i);
        String str2 = BuildConfig.FLAVOR;
        if (this.f6055a.m9010s().containsKey(str)) {
            str2 = (String) this.f6055a.m9010s().get(str);
        }
        Fragment a = C1886i.m9043a(i + 1, str, str2);
        this.f6055a.f6026s.put(str, a);
        return a;
    }

    public void m9040a(String str) {
        int i = -1;
        for (int i2 = 0; i2 < this.f6056b.size(); i2++) {
            if (((String) this.f6056b.get(i2)).equals(str)) {
                i = i2;
            }
        }
        if (i != -1) {
            this.f6056b.remove(i);
            m878c();
        }
        this.f6055a.m9010s().remove(str);
        this.f6055a.f6026s.remove(str);
        for (Entry entry : this.f6055a.f6026s.entrySet()) {
            ((C1886i) entry.getValue()).m9046a((String) this.f6055a.m9010s().get(entry.getKey()));
        }
    }

    public int m9041b() {
        return this.f6056b.size();
    }

    public CharSequence m9042c(int i) {
        return BuildConfig.FLAVOR;
    }
}
