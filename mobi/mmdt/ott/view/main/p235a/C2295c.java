package mobi.mmdt.ott.view.main.p235a;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import mobi.mmdt.ott.view.main.p235a.p239a.C2290a;

/* renamed from: mobi.mmdt.ott.view.main.a.c */
public class C2295c extends C1721e {
    final /* synthetic */ C2291a f7584a;

    public C2295c(C2291a c2291a, Context context) {
        this.f7584a = c2291a;
        super(context);
    }

    public C1712b m10397a(ViewGroup viewGroup, int i) {
        return new C2290a(this.f7584a.m10381b(), this.f7584a, m8654a(), viewGroup);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10397a(viewGroup, i);
    }
}
