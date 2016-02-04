package mobi.mmdt.ott.view.conversation.emojisticker.emoji;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.p229a.C2200a;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.emoji.e */
class C2208e extends C1721e {
    final /* synthetic */ C2203a f7270a;

    public C2208e(C2203a c2203a, Context context) {
        this.f7270a = c2203a;
        super(context);
    }

    public C1712b m10073a(ViewGroup viewGroup, int i) {
        if (i != 1) {
            return null;
        }
        return new C2200a(this.f7270a.f7254b, null, m8654a(), viewGroup, this.f7270a.f7260h, this.f7270a.f7261i, this.f7270a.f7262j, this.f7270a);
    }

    public void m10074a(C1712b c1712b, int i) {
        super.m8657a(c1712b, i);
    }

    public /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        m10074a((C1712b) viewHolder, i);
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10073a(viewGroup, i);
    }
}
