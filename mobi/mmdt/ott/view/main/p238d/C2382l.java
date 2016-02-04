package mobi.mmdt.ott.view.main.p238d;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.main.p238d.p245a.C2367a;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.main.d.l */
public class C2382l extends C1786a {
    final /* synthetic */ C2369a f7847j;

    public C2382l(C2369a c2369a, Context context) {
        this.f7847j = c2369a;
        super(context);
    }

    public C1712b m10578a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C2367a(this.f7847j.m10381b(), this.f7847j, m8750a(), viewGroup);
            default:
                return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected mobi.mmdt.ott.view.components.p181b.C1722f m10579a(android.database.Cursor r19, int r20) {
        /*
        r18 = this;
        r2 = "_id";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r3 = r0.getInt(r2);
        r2 = "conversations_party";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r4 = r0.getString(r2);
        r2 = "MAX_DATE";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r16 = r0.getLong(r2);
        r2 = "conversations_direction_type";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r11 = r0.getInt(r2);
        r2 = "conversations_event_state";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r15 = r0.getInt(r2);
        r2 = "conversations_event_type";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r8 = r0.getInt(r2);
        r2 = "conversations_event";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r7 = r0.getString(r2);
        r2 = mobi.mmdt.ott.provider.p169c.C1595o.values();
        r5 = "conversations_group_type";
        r0 = r19;
        r5 = r0.getColumnIndex(r5);
        r0 = r19;
        r5 = r0.getInt(r5);
        r12 = r2[r5];
        r2 = "CHANNELS_is_mute";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r2 = r0.getInt(r2);
        if (r2 == 0) goto L_0x00c2;
    L_0x0086:
        r14 = 1;
    L_0x0087:
        r5 = "";
        r2 = "";
        r6 = mobi.mmdt.ott.view.main.p238d.C2381k.f7845a;
        r9 = r12.ordinal();
        r6 = r6[r9];
        switch(r6) {
            case 1: goto L_0x00c4;
            default: goto L_0x0096;
        };
    L_0x0096:
        r6 = mobi.mmdt.ott.view.main.p238d.C2381k.f7846b;
        r9 = mobi.mmdt.ott.provider.p169c.C1594n.values();
        r8 = r9[r8];
        r8 = r8.ordinal();
        r6 = r6[r8];
        switch(r6) {
            case 1: goto L_0x011c;
            case 2: goto L_0x0121;
            case 3: goto L_0x0134;
            case 4: goto L_0x0147;
            case 5: goto L_0x014d;
            case 6: goto L_0x0168;
            case 7: goto L_0x0183;
            case 8: goto L_0x0189;
            case 9: goto L_0x018f;
            case 10: goto L_0x0193;
            case 11: goto L_0x01c2;
            default: goto L_0x00a7;
        };
    L_0x00a7:
        r9 = r7;
        r10 = r2;
    L_0x00a9:
        r0 = r18;
        r2 = r0.d;
        r7 = mobi.mmdt.componentsutils.p079a.C1111c.m6402b(r2, r4);
        r13 = mobi.mmdt.ott.logic.p157e.p159b.C1512c.m7633b(r4);
        r2 = 0;
        r6 = mobi.mmdt.ott.view.main.p238d.C2381k.f7845a;
        r8 = r12.ordinal();
        r6 = r6[r8];
        switch(r6) {
            case 1: goto L_0x01c8;
            default: goto L_0x00c1;
        };
    L_0x00c1:
        return r2;
    L_0x00c2:
        r14 = 0;
        goto L_0x0087;
    L_0x00c4:
        r2 = "CHANNELS_name";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r6 = r0.getString(r2);
        r2 = "members_nick_name";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r2 = r0.getString(r2);
        r5 = "members_user_id";
        r0 = r19;
        r5 = r0.getColumnIndex(r5);
        r0 = r19;
        r5 = r0.getString(r5);
        r0 = r18;
        r9 = r0.f7847j;
        r9 = r9.f7821i;
        r9 = r9.equals(r5);
        if (r9 == 0) goto L_0x0117;
    L_0x00fc:
        r2 = "You";
    L_0x00fe:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r2);
        r9 = ": ";
        r5 = r5.append(r9);
        r5 = r5.toString();
        if (r2 != 0) goto L_0x020a;
    L_0x0113:
        r2 = "";
        r5 = r6;
        goto L_0x0096;
    L_0x0117:
        r2 = mobi.mmdt.ott.view.p178a.ah.m8470b(r2, r5);
        goto L_0x00fe;
    L_0x011c:
        r6 = "Call";
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x0121:
        r0 = r18;
        r6 = r0.f7847j;
        r6 = r6.m10381b();
        r7 = 2131230929; // 0x7f0800d1 float:1.8077925E38 double:1.0529679854E-314;
        r6 = r6.getString(r7);
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x0134:
        r0 = r18;
        r6 = r0.f7847j;
        r6 = r6.m10381b();
        r7 = 2131230932; // 0x7f0800d4 float:1.807793E38 double:1.052967987E-314;
        r6 = r6.getString(r7);
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x0147:
        r6 = "Audio";
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x014d:
        if (r7 == 0) goto L_0x0155;
    L_0x014f:
        r6 = r7.isEmpty();
        if (r6 == 0) goto L_0x00a7;
    L_0x0155:
        r0 = r18;
        r6 = r0.f7847j;
        r6 = r6.m10381b();
        r7 = 2131230930; // 0x7f0800d2 float:1.8077927E38 double:1.052967986E-314;
        r6 = r6.getString(r7);
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x0168:
        if (r7 == 0) goto L_0x0170;
    L_0x016a:
        r6 = r7.isEmpty();
        if (r6 == 0) goto L_0x00a7;
    L_0x0170:
        r0 = r18;
        r6 = r0.f7847j;
        r6 = r6.m10381b();
        r7 = 2131230934; // 0x7f0800d6 float:1.8077935E38 double:1.052967988E-314;
        r6 = r6.getString(r7);
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x0183:
        r6 = "Missed Call";
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x0189:
        r6 = "Sticker";
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x018f:
        r9 = r7;
        r10 = r2;
        goto L_0x00a9;
    L_0x0193:
        r8 = 0;
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x01a7 }
        r6.<init>(r7);	 Catch:{ JSONException -> 0x01a7 }
        r6 = mobi.mmdt.ott.p095c.C1303d.m6879a(r6);	 Catch:{ JSONException -> 0x01a7 }
    L_0x019d:
        if (r6 == 0) goto L_0x01af;
    L_0x019f:
        r6 = r6.m6631a();
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x01a7:
        r6 = move-exception;
        r0 = r18;
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6368b(r0, r6);
        r6 = r8;
        goto L_0x019d;
    L_0x01af:
        r0 = r18;
        r6 = r0.f7847j;
        r6 = r6.m10381b();
        r7 = 2131230931; // 0x7f0800d3 float:1.8077929E38 double:1.0529679864E-314;
        r6 = r6.getString(r7);
        r9 = r6;
        r10 = r2;
        goto L_0x00a9;
    L_0x01c2:
        r2 = "";
        r9 = r7;
        r10 = r2;
        goto L_0x00a9;
    L_0x01c8:
        r2 = "CHANNELS_avatar_thumbnail_url";
        r0 = r19;
        r2 = r0.getColumnIndex(r2);
        r0 = r19;
        r6 = r0.getString(r2);
        r2 = new mobi.mmdt.ott.view.main.d.b.b;
        r0 = r18;
        r8 = r0.d;
        r0 = r16;
        r8 = mobi.mmdt.componentsutils.p079a.C1111c.m6408c(r8, r0);
        r16 = new java.lang.StringBuilder;
        r16.<init>();
        r0 = r16;
        r10 = r0.append(r10);
        r9 = r10.append(r9);
        r9 = r9.toString();
        r10 = mobi.mmdt.ott.provider.p169c.C1593m.values();
        r10 = r10[r15];
        r15 = mobi.mmdt.ott.provider.p169c.C1592l.values();
        r11 = r15[r11];
        r15 = r19.getPosition();
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        goto L_0x00c1;
    L_0x020a:
        r2 = r5;
        r5 = r6;
        goto L_0x0096;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.main.d.l.a(android.database.Cursor, int):mobi.mmdt.ott.view.components.b.f");
    }

    public int getItemViewType(int i) {
        Cursor cursor = (Cursor) m8746b(i);
        switch (C2381k.f7845a[C1595o.values()[cursor.getInt(cursor.getColumnIndex("conversations_group_type"))].ordinal()]) {
            case VideoSize.CIF /*1*/:
                return 1;
            default:
                return super.getItemViewType(i);
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10578a(viewGroup, i);
    }
}
