package mobi.mmdt.ott.view.main.p237c;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.main.p237c.p243a.C2343a;
import mobi.mmdt.ott.view.main.p237c.p243a.C2345c;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.main.c.p */
public class C2365p extends C1786a {
    final /* synthetic */ C2347a f7802j;

    public C2365p(C2347a c2347a, Context context) {
        this.f7802j = c2347a;
        super(context);
    }

    public C1712b m10547a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C2343a(this.f7802j.m10381b(), this.f7802j, m8750a(), viewGroup);
            case VideoSize.HVGA /*2*/:
                return new C2345c(this.f7802j.m10381b(), this.f7802j, m8750a(), viewGroup);
            default:
                return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected mobi.mmdt.ott.view.components.p181b.C1722f m10548a(android.database.Cursor r30, int r31) {
        /*
        r29 = this;
        r2 = "_id";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r3 = r0.getInt(r2);
        r2 = "conversations_party";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r4 = r0.getString(r2);
        r2 = "conversations_peer_user_id";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r6 = r0.getString(r2);
        r2 = "MAX_DATE";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r16 = r0.getLong(r2);
        r2 = "conversations_direction_type";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r12 = r0.getInt(r2);
        r2 = "conversations_event_state";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r18 = r0.getInt(r2);
        r2 = "conversations_event_type";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r8 = r0.getInt(r2);
        r2 = "conversations_event";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r7 = r0.getString(r2);
        r2 = "PrivateGroups_is_mute";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r2 = r0.getInt(r2);
        if (r2 == 0) goto L_0x00d1;
    L_0x0080:
        r27 = 1;
    L_0x0082:
        r2 = mobi.mmdt.ott.provider.p169c.C1595o.values();
        r5 = "conversations_group_type";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getInt(r5);
        r13 = r2[r5];
        r5 = "";
        r2 = "";
        r9 = mobi.mmdt.ott.view.main.p237c.C2364o.f7800a;
        r10 = r13.ordinal();
        r9 = r9[r10];
        switch(r9) {
            case 1: goto L_0x00d4;
            case 2: goto L_0x012b;
            default: goto L_0x00a5;
        };
    L_0x00a5:
        r6 = mobi.mmdt.ott.view.main.p237c.C2364o.f7801b;
        r9 = mobi.mmdt.ott.provider.p169c.C1594n.values();
        r8 = r9[r8];
        r8 = r8.ordinal();
        r6 = r6[r8];
        switch(r6) {
            case 1: goto L_0x018e;
            case 2: goto L_0x0194;
            case 3: goto L_0x01a7;
            case 4: goto L_0x01ba;
            case 5: goto L_0x01c0;
            case 6: goto L_0x01db;
            case 7: goto L_0x01f6;
            case 8: goto L_0x01fc;
            case 9: goto L_0x020f;
            case 10: goto L_0x0213;
            default: goto L_0x00b6;
        };
    L_0x00b6:
        r10 = r7;
        r11 = r2;
    L_0x00b8:
        r0 = r29;
        r2 = r0.d;
        r8 = mobi.mmdt.componentsutils.p079a.C1111c.m6402b(r2, r4);
        r14 = mobi.mmdt.ott.logic.p157e.p159b.C1512c.m7633b(r4);
        r2 = 0;
        r6 = mobi.mmdt.ott.view.main.p237c.C2364o.f7800a;
        r7 = r13.ordinal();
        r6 = r6[r7];
        switch(r6) {
            case 1: goto L_0x0219;
            case 2: goto L_0x0267;
            default: goto L_0x00d0;
        };
    L_0x00d0:
        return r2;
    L_0x00d1:
        r27 = 0;
        goto L_0x0082;
    L_0x00d4:
        r5 = r4.equals(r6);
        if (r5 != 0) goto L_0x00e1;
    L_0x00da:
        r0 = r29;
        r5 = r0.d;
        mobi.mmdt.ott.provider.p169c.C1583c.m8004o(r5, r4);
    L_0x00e1:
        r5 = "members_is_local_user";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getInt(r5);
        if (r5 == 0) goto L_0x0115;
    L_0x00f1:
        r5 = 1;
    L_0x00f2:
        if (r5 == 0) goto L_0x0117;
    L_0x00f4:
        r5 = "members_local_name";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getString(r5);
        r6 = "members_local_phone_number";
        r0 = r30;
        r6 = r0.getColumnIndex(r6);
        r0 = r30;
        r6 = r0.getString(r6);
        r5 = mobi.mmdt.ott.view.p178a.ah.m8469a(r5, r6);
        goto L_0x00a5;
    L_0x0115:
        r5 = 0;
        goto L_0x00f2;
    L_0x0117:
        r5 = "members_nick_name";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getString(r5);
        r5 = mobi.mmdt.ott.view.p178a.ah.m8470b(r5, r4);
        goto L_0x00a5;
    L_0x012b:
        r2 = "PrivateGroups_name";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r6 = r0.getString(r2);
        r2 = "members_nick_name";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r2 = r0.getString(r2);
        r5 = "members_user_id";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getString(r5);
        r0 = r29;
        r9 = r0.f7802j;
        r9 = r9.f7761i;
        if (r9 == 0) goto L_0x0189;
    L_0x015f:
        r0 = r29;
        r9 = r0.f7802j;
        r9 = r9.f7761i;
        r9 = r9.equals(r5);
        if (r9 == 0) goto L_0x0189;
    L_0x016d:
        r2 = "You";
    L_0x016f:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r2);
        r9 = ": ";
        r5 = r5.append(r9);
        r5 = r5.toString();
        if (r2 != 0) goto L_0x02b4;
    L_0x0184:
        r2 = "";
        r5 = r6;
        goto L_0x00a5;
    L_0x0189:
        r2 = mobi.mmdt.ott.view.p178a.ah.m8470b(r2, r5);
        goto L_0x016f;
    L_0x018e:
        r6 = "Call";
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x0194:
        r0 = r29;
        r6 = r0.f7802j;
        r6 = r6.m10381b();
        r7 = 2131230929; // 0x7f0800d1 float:1.8077925E38 double:1.0529679854E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x01a7:
        r0 = r29;
        r6 = r0.f7802j;
        r6 = r6.m10381b();
        r7 = 2131230932; // 0x7f0800d4 float:1.807793E38 double:1.052967987E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x01ba:
        r6 = "Audio";
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x01c0:
        if (r7 == 0) goto L_0x01c8;
    L_0x01c2:
        r6 = r7.isEmpty();
        if (r6 == 0) goto L_0x00b6;
    L_0x01c8:
        r0 = r29;
        r6 = r0.f7802j;
        r6 = r6.m10381b();
        r7 = 2131230930; // 0x7f0800d2 float:1.8077927E38 double:1.052967986E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x01db:
        if (r7 == 0) goto L_0x01e3;
    L_0x01dd:
        r6 = r7.isEmpty();
        if (r6 == 0) goto L_0x00b6;
    L_0x01e3:
        r0 = r29;
        r6 = r0.f7802j;
        r6 = r6.m10381b();
        r7 = 2131230934; // 0x7f0800d6 float:1.8077935E38 double:1.052967988E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x01f6:
        r6 = "Missed Call";
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x01fc:
        r0 = r29;
        r6 = r0.f7802j;
        r6 = r6.m10381b();
        r7 = 2131230933; // 0x7f0800d5 float:1.8077933E38 double:1.0529679873E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00b8;
    L_0x020f:
        r10 = r7;
        r11 = r2;
        goto L_0x00b8;
    L_0x0213:
        r2 = "";
        r10 = r7;
        r11 = r2;
        goto L_0x00b8;
    L_0x0219:
        r2 = "members_avatar_thumbnail_url";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r6 = r0.getString(r2);
        r2 = "members_local_image_uri";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r7 = r0.getString(r2);
        r2 = new mobi.mmdt.ott.view.main.c.b.b;
        r0 = r29;
        r9 = r0.d;
        r0 = r16;
        r9 = mobi.mmdt.componentsutils.p079a.C1111c.m6408c(r9, r0);
        r15 = new java.lang.StringBuilder;
        r15.<init>();
        r11 = r15.append(r11);
        r10 = r11.append(r10);
        r10 = r10.toString();
        r11 = mobi.mmdt.ott.provider.p169c.C1593m.values();
        r11 = r11[r18];
        r15 = mobi.mmdt.ott.provider.p169c.C1592l.values();
        r12 = r15[r12];
        r15 = r30.getPosition();
        r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        goto L_0x00d0;
    L_0x0267:
        r2 = "PrivateGroups_thumbnail_url";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r19 = r0.getString(r2);
        r15 = new mobi.mmdt.ott.view.main.c.b.c;
        r0 = r29;
        r2 = r0.d;
        r0 = r16;
        r21 = mobi.mmdt.componentsutils.p079a.C1111c.m6408c(r2, r0);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r11);
        r2 = r2.append(r10);
        r22 = r2.toString();
        r2 = mobi.mmdt.ott.provider.p169c.C1593m.values();
        r23 = r2[r18];
        r2 = mobi.mmdt.ott.provider.p169c.C1592l.values();
        r24 = r2[r12];
        r28 = r30.getPosition();
        r16 = r3;
        r17 = r4;
        r18 = r5;
        r20 = r8;
        r25 = r13;
        r26 = r14;
        r15.<init>(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        r2 = r15;
        goto L_0x00d0;
    L_0x02b4:
        r2 = r5;
        r5 = r6;
        goto L_0x00a5;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.main.c.p.a(android.database.Cursor, int):mobi.mmdt.ott.view.components.b.f");
    }

    public int getItemViewType(int i) {
        Cursor cursor = (Cursor) m8746b(i);
        switch (C2364o.f7800a[C1595o.values()[cursor.getInt(cursor.getColumnIndex("conversations_group_type"))].ordinal()]) {
            case VideoSize.CIF /*1*/:
                return 1;
            case VideoSize.HVGA /*2*/:
                return 2;
            default:
                return super.getItemViewType(i);
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10547a(viewGroup, i);
    }
}
