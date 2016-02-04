package mobi.mmdt.ott.view.conversation.groupinfo;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.conversation.groupinfo.p231a.C2247a;
import mobi.mmdt.ott.view.conversation.groupinfo.p232b.C2250a;
import org.linphone.core.VideoSize;

public class ax extends C1786a {
    final /* synthetic */ aw f7458j;

    public ax(aw awVar, Context context) {
        this.f7458j = awVar;
        super(context);
    }

    public C1712b m10261a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C2247a(this.f7458j.getActivity(), this.f7458j, m8750a(), viewGroup);
            default:
                return null;
        }
    }

    protected C1722f m10262a(Cursor cursor, int i) {
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("members_user_id"));
        long j2 = cursor.getLong(cursor.getColumnIndex("members_last_online"));
        String string2 = cursor.getString(cursor.getColumnIndex("members_nick_name"));
        String string3 = cursor.getString(cursor.getColumnIndex("members_moto"));
        String string4 = cursor.getString(cursor.getColumnIndex("members_avatar_thumbnail_url"));
        int i2 = cursor.getInt(cursor.getColumnIndex("members_group_user_role"));
        return new C2250a(i, j, string, string2, string3, string4, C1111c.m6402b(this.f7458j.getActivity(), string), C1619f.values()[i2], j2);
    }

    public int getItemViewType(int i) {
        return 1;
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10261a(viewGroup, i);
    }
}
