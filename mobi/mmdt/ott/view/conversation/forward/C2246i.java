package mobi.mmdt.ott.view.conversation.forward;

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

/* renamed from: mobi.mmdt.ott.view.conversation.forward.i */
public class C2246i extends C1786a {
    final /* synthetic */ C2244g f7388j;

    public C2246i(C2244g c2244g, Context context) {
        this.f7388j = c2244g;
        super(context);
    }

    public C1712b m10167a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C2343a(this.f7388j.getActivity(), this.f7388j, m8750a(), viewGroup);
            case VideoSize.HVGA /*2*/:
                return new C2345c(this.f7388j.getActivity(), this.f7388j, m8750a(), viewGroup);
            default:
                return null;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected mobi.mmdt.ott.view.components.p181b.C1722f m10168a(android.database.Cursor r30, int r31) {
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
        r2 = mobi.mmdt.ott.provider.p169c.C1595o.values();
        r5 = "conversations_group_type";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getInt(r5);
        r13 = r2[r5];
        r2 = "PrivateGroups_is_mute";
        r0 = r30;
        r2 = r0.getColumnIndex(r2);
        r0 = r30;
        r2 = r0.getInt(r2);
        if (r2 == 0) goto L_0x00c0;
    L_0x0086:
        r27 = 1;
    L_0x0088:
        r5 = "";
        r2 = "";
        r6 = mobi.mmdt.ott.view.conversation.forward.C2245h.f7386a;
        r9 = r13.ordinal();
        r6 = r6[r9];
        switch(r6) {
            case 1: goto L_0x00c3;
            case 2: goto L_0x011b;
            default: goto L_0x0097;
        };
    L_0x0097:
        r6 = mobi.mmdt.ott.view.conversation.forward.C2245h.f7387b;
        r9 = mobi.mmdt.ott.provider.p169c.C1594n.values();
        r8 = r9[r8];
        r8 = r8.ordinal();
        r6 = r6[r8];
        switch(r6) {
            case 1: goto L_0x0174;
            case 2: goto L_0x017a;
            case 3: goto L_0x0189;
            case 4: goto L_0x0198;
            case 5: goto L_0x019e;
            case 6: goto L_0x01b5;
            case 7: goto L_0x01cc;
            case 8: goto L_0x01d2;
            case 9: goto L_0x01e1;
            case 10: goto L_0x01e5;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r10 = r7;
        r11 = r2;
    L_0x00aa:
        r0 = r29;
        r2 = r0.d;
        r8 = mobi.mmdt.componentsutils.p079a.C1111c.m6402b(r2, r4);
        r14 = 0;
        r2 = 0;
        r6 = mobi.mmdt.ott.view.conversation.forward.C2245h.f7386a;
        r7 = r13.ordinal();
        r6 = r6[r7];
        switch(r6) {
            case 1: goto L_0x01eb;
            case 2: goto L_0x0239;
            default: goto L_0x00bf;
        };
    L_0x00bf:
        return r2;
    L_0x00c0:
        r27 = 0;
        goto L_0x0088;
    L_0x00c3:
        r5 = "members_is_local_user";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getInt(r5);
        if (r5 == 0) goto L_0x00f7;
    L_0x00d3:
        r5 = 1;
    L_0x00d4:
        if (r5 == 0) goto L_0x00f9;
    L_0x00d6:
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
        goto L_0x0097;
    L_0x00f7:
        r5 = 0;
        goto L_0x00d4;
    L_0x00f9:
        r5 = "members_nick_name";
        r0 = r30;
        r5 = r0.getColumnIndex(r5);
        r0 = r30;
        r5 = r0.getString(r5);
        r6 = "members_user_id";
        r0 = r30;
        r6 = r0.getColumnIndex(r6);
        r0 = r30;
        r6 = r0.getString(r6);
        r5 = mobi.mmdt.ott.view.p178a.ah.m8470b(r5, r6);
        goto L_0x0097;
    L_0x011b:
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
        r9 = r0.f7388j;
        r9 = r9.f7385e;
        r9 = r9.equals(r5);
        if (r9 == 0) goto L_0x016f;
    L_0x0153:
        r2 = "You";
    L_0x0155:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5 = r5.append(r2);
        r9 = ": ";
        r5 = r5.append(r9);
        r5 = r5.toString();
        if (r2 != 0) goto L_0x0286;
    L_0x016a:
        r2 = "";
        r5 = r6;
        goto L_0x0097;
    L_0x016f:
        r2 = mobi.mmdt.ott.view.p178a.ah.m8470b(r2, r5);
        goto L_0x0155;
    L_0x0174:
        r6 = "Call";
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x017a:
        r0 = r29;
        r6 = r0.f7388j;
        r7 = 2131230929; // 0x7f0800d1 float:1.8077925E38 double:1.0529679854E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x0189:
        r0 = r29;
        r6 = r0.f7388j;
        r7 = 2131230932; // 0x7f0800d4 float:1.807793E38 double:1.052967987E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x0198:
        r6 = "Audio";
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x019e:
        if (r7 == 0) goto L_0x01a6;
    L_0x01a0:
        r6 = r7.isEmpty();
        if (r6 == 0) goto L_0x00a8;
    L_0x01a6:
        r0 = r29;
        r6 = r0.f7388j;
        r7 = 2131230930; // 0x7f0800d2 float:1.8077927E38 double:1.052967986E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x01b5:
        if (r7 == 0) goto L_0x01bd;
    L_0x01b7:
        r6 = r7.isEmpty();
        if (r6 == 0) goto L_0x00a8;
    L_0x01bd:
        r0 = r29;
        r6 = r0.f7388j;
        r7 = 2131230934; // 0x7f0800d6 float:1.8077935E38 double:1.052967988E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x01cc:
        r6 = "Missed Call";
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x01d2:
        r0 = r29;
        r6 = r0.f7388j;
        r7 = 2131230933; // 0x7f0800d5 float:1.8077933E38 double:1.0529679873E-314;
        r6 = r6.getString(r7);
        r10 = r6;
        r11 = r2;
        goto L_0x00aa;
    L_0x01e1:
        r10 = r7;
        r11 = r2;
        goto L_0x00aa;
    L_0x01e5:
        r2 = "";
        r10 = r7;
        r11 = r2;
        goto L_0x00aa;
    L_0x01eb:
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
        goto L_0x00bf;
    L_0x0239:
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
        goto L_0x00bf;
    L_0x0286:
        r2 = r5;
        r5 = r6;
        goto L_0x0097;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.conversation.forward.i.a(android.database.Cursor, int):mobi.mmdt.ott.view.components.b.f");
    }

    public int getItemViewType(int i) {
        Cursor cursor = (Cursor) m8746b(i);
        switch (C2245h.f7386a[C1595o.values()[cursor.getInt(cursor.getColumnIndex("conversations_group_type"))].ordinal()]) {
            case VideoSize.CIF /*1*/:
                return 1;
            case VideoSize.HVGA /*2*/:
                return 2;
            default:
                return super.getItemViewType(i);
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10167a(viewGroup, i);
    }
}
