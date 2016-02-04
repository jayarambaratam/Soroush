package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ah;
import mobi.mmdt.ott.view.conversation.C2135c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ab */
class ab implements OnClickListener {
    final /* synthetic */ ah[] f6615a;
    final /* synthetic */ Bundle f6616b;
    final /* synthetic */ C2158e f6617c;
    final /* synthetic */ String f6618d;
    final /* synthetic */ C2043q f6619e;

    ab(C2043q c2043q, ah[] ahVarArr, Bundle bundle, C2158e c2158e, String str) {
        this.f6619e = c2043q;
        this.f6615a = ahVarArr;
        this.f6616b = bundle;
        this.f6617c = c2158e;
        this.f6618d = str;
    }

    public void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        for (ah b : this.f6615a) {
            String b2 = b.m6628b();
            if (this.f6616b.getBoolean(C2135c.m9794a(this.f6617c.m9844f(), b2), false)) {
                arrayList.add(b2);
            }
        }
        this.f6619e.c.m9337a(this.f6617c.m9844f(), this.f6618d, (String[]) arrayList.toArray(new String[arrayList.size()]), this.f6616b.getString(C2135c.m9793a(this.f6617c.m9844f(), 1), BuildConfig.FLAVOR));
    }
}
