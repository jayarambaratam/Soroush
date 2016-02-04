package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ah;
import mobi.mmdt.ott.view.conversation.C2135c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.ag */
class ag implements OnClickListener {
    final /* synthetic */ ah[] f6629a;
    final /* synthetic */ Bundle f6630b;
    final /* synthetic */ C2158e f6631c;
    final /* synthetic */ String f6632d;
    final /* synthetic */ C2043q f6633e;

    ag(C2043q c2043q, ah[] ahVarArr, Bundle bundle, C2158e c2158e, String str) {
        this.f6633e = c2043q;
        this.f6629a = ahVarArr;
        this.f6630b = bundle;
        this.f6631c = c2158e;
        this.f6632d = str;
    }

    public void onClick(View view) {
        ArrayList arrayList = new ArrayList();
        for (ah b : this.f6629a) {
            String b2 = b.m6628b();
            if (this.f6630b.getBoolean(C2135c.m9796b(this.f6631c.m9844f(), b2), false)) {
                arrayList.add(b2);
            }
        }
        this.f6633e.c.m9337a(this.f6631c.m9844f(), this.f6632d, (String[]) arrayList.toArray(new String[arrayList.size()]), this.f6630b.getString(C2135c.m9793a(this.f6631c.m9844f(), 1), BuildConfig.FLAVOR));
    }
}
