package mobi.mmdt.ott.view.components.imageslider.p201b;

import android.view.View;
import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.p032a.p033a.p045h.p056b.C0778k;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.b.b */
class C1841b implements C0866h<String, C0742b> {
    final /* synthetic */ C1840a f5967a;
    final /* synthetic */ View f5968b;
    final /* synthetic */ C1840a f5969c;

    C1841b(C1840a c1840a, C1840a c1840a2, View view) {
        this.f5969c = c1840a;
        this.f5967a = c1840a2;
        this.f5968b = view;
    }

    public boolean m8949a(C0742b c0742b, String str, C0778k<C0742b> c0778k, boolean z, boolean z2) {
        if (this.f5968b.findViewById(2131689939) != null) {
            this.f5968b.findViewById(2131689939).setVisibility(8);
        }
        return false;
    }

    public boolean m8951a(Exception exception, String str, C0778k<C0742b> c0778k, boolean z) {
        if (this.f5969c.f5964g != null) {
            this.f5969c.f5964g.m8926a(false, this.f5967a);
        }
        if (this.f5968b.findViewById(2131689939) != null) {
            this.f5968b.findViewById(2131689939).setVisibility(8);
        }
        return false;
    }
}
