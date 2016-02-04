package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import mobi.mmdt.ott.view.conversation.C2135c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.u */
class C2047u implements OnClickListener {
    final /* synthetic */ Bundle f6727a;
    final /* synthetic */ C2158e f6728b;
    final /* synthetic */ String f6729c;
    final /* synthetic */ C2043q f6730d;

    C2047u(C2043q c2043q, Bundle bundle, C2158e c2158e, String str) {
        this.f6730d = c2043q;
        this.f6727a = bundle;
        this.f6728b = c2158e;
        this.f6729c = str;
    }

    public void onClick(View view) {
        this.f6730d.c.m9337a(this.f6728b.m9844f(), this.f6729c, new String[0], this.f6727a.getString(C2135c.m9793a(this.f6728b.m9844f(), 1), BuildConfig.FLAVOR));
    }
}
