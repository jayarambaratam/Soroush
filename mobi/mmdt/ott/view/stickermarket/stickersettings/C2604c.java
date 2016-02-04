package mobi.mmdt.ott.view.stickermarket.stickersettings;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.provider.p175i.C1638d;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.stickermarket.stickersettings.p251a.C2598a;
import mobi.mmdt.ott.view.stickermarket.stickersettings.p252b.C2603b;

/* renamed from: mobi.mmdt.ott.view.stickermarket.stickersettings.c */
public class C2604c extends C1786a {
    final /* synthetic */ StickerSettingsFragment f8335j;

    public C2604c(StickerSettingsFragment stickerSettingsFragment, Context context) {
        this.f8335j = stickerSettingsFragment;
        super(context);
    }

    public C1712b m11057a(ViewGroup viewGroup, int i) {
        return new C2598a(this.f8335j.getActivity(), this.f8335j, m8750a(), viewGroup, this.f8335j);
    }

    protected C1722f m11058a(Cursor cursor, int i) {
        C1638d c1638d = new C1638d(cursor);
        return new C2603b(c1638d.m8360d(), c1638d.m8361e(), c1638d.m8363g(), c1638d.m8362f(), c1638d.getPosition());
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m11057a(viewGroup, i);
    }
}
