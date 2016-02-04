package mobi.mmdt.ott.view.main.p236b;

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

/* renamed from: mobi.mmdt.ott.view.main.b.d */
public class C2303d extends C1786a {
    final /* synthetic */ C2298a f7612j;

    public C2303d(C2298a c2298a, Context context) {
        this.f7612j = c2298a;
        super(context);
    }

    public C1712b m10417a(ViewGroup viewGroup, int i) {
        return new C2297a(this.f7612j.m10381b(), this.f7612j, m8750a(), viewGroup);
    }

    protected C1722f m10418a(Cursor cursor, int i) {
        int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("members_moto"));
        String string2 = cursor.getString(cursor.getColumnIndex("members_avatar_thumbnail_url"));
        String string3 = cursor.getString(cursor.getColumnIndex("members_local_image_uri"));
        String string4 = cursor.getString(cursor.getColumnIndex("members_user_id"));
        return new C2300b(i2, string4, ah.m8469a(cursor.getString(cursor.getColumnIndex("members_local_name")), cursor.getString(cursor.getColumnIndex("members_local_phone_number"))), string, string2, string3, C1111c.m6402b(this.d, string4), cursor.getPosition());
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10417a(viewGroup, i);
    }
}
