package mobi.mmdt.ott.view.conversation.forward;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.main.p236b.p241a.C2297a;
import mobi.mmdt.ott.view.main.p236b.p242b.C2300b;
import mobi.mmdt.ott.view.p178a.ah;

/* renamed from: mobi.mmdt.ott.view.conversation.forward.c */
public class C2240c extends C1786a {
    final /* synthetic */ C2239b f7372j;

    public C2240c(C2239b c2239b, Context context) {
        this.f7372j = c2239b;
        super(context);
    }

    public C1712b m10153a(ViewGroup viewGroup, int i) {
        return new C2297a(this.f7372j.getActivity(), this.f7372j, m8750a(), viewGroup);
    }

    protected C1722f m10154a(Cursor cursor, int i) {
        int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("members_moto"));
        String string2 = cursor.getString(cursor.getColumnIndex("members_avatar_thumbnail_url"));
        String string3 = cursor.getString(cursor.getColumnIndex("members_local_image_uri"));
        String string4 = cursor.getString(cursor.getColumnIndex("members_user_id"));
        return new C2300b(i2, string4, ah.m8469a(cursor.getString(cursor.getColumnIndex("members_local_name")), cursor.getString(cursor.getColumnIndex("members_local_phone_number"))), string, string2, string3, C1111c.m6402b(this.d, string4), cursor.getPosition());
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10153a(viewGroup, i);
    }
}
