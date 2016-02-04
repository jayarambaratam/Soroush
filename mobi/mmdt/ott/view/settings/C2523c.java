package mobi.mmdt.ott.view.settings;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import mobi.mmdt.ott.view.settings.p247a.C2509a;
import mobi.mmdt.ott.view.settings.p247a.C2510b;
import mobi.mmdt.ott.view.settings.p247a.C2511c;
import mobi.mmdt.ott.view.settings.p247a.C2512d;
import org.apache.http.myHttp.protocol.HttpRequestExecutor;

/* renamed from: mobi.mmdt.ott.view.settings.c */
class C2523c extends C1721e {
    final /* synthetic */ C2522b f8134a;

    public C2523c(C2522b c2522b, Context context) {
        this.f8134a = c2522b;
        super(context);
    }

    public C1712b m10858a(ViewGroup viewGroup, int i) {
        return i > 4000 ? new C2512d(this.f8134a, this.f8134a.f8130b.m8654a(), viewGroup) : i > HttpRequestExecutor.DEFAULT_WAIT_FOR_CONTINUE ? new C2510b(this.f8134a, this.f8134a.f8130b.m8654a(), viewGroup) : i > 2000 ? new C2509a(this.f8134a, this.f8134a.f8130b.m8654a(), viewGroup) : i > 1000 ? new C2511c(this.f8134a, this.f8134a.f8130b.m8654a(), viewGroup) : null;
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10858a(viewGroup, i);
    }
}
