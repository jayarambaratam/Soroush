package mobi.mmdt.ott.view.conversation.p214b;

import android.app.Activity;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.Calendar;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1593m;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.provider.p174h.C1634g;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.conversation.activities.C1992a;
import mobi.mmdt.ott.view.conversation.activities.ChannelConversationActivity;
import mobi.mmdt.ott.view.conversation.p213a.C1983c;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.C2032f;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.C2035i;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.C2039m;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.C2043q;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.ah;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.al;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.ao;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.as;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p217a.aw;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2054b;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2057e;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2061i;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2065m;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2069q;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2072t;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2076x;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.C2081b;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.C2084e;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.C2088i;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.C2092m;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.C2096q;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.C2099t;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.C2103x;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p219c.ab;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.C2108c;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.C2111f;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.C2115j;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.C2119n;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.C2123r;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.C2126u;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.C2130y;
import mobi.mmdt.ott.view.conversation.p215c.p216a.p220d.ac;
import mobi.mmdt.ott.view.conversation.p215c.p221b.C2133b;
import mobi.mmdt.ott.view.conversation.p215c.p221b.C2134c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2182b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2183c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2184d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2185e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2186f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2187g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2188h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2189i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2155b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2156c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2157d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2159f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2160g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2161h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2162i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2163j;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2165b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2166c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2167d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2168e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2169f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2170g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2171h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2172i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2174b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2175c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2176d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2177e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2178f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2179g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2180h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2181i;
import mobi.mmdt.ott.view.conversation.p222d.p228b.C2191b;
import mobi.mmdt.ott.view.conversation.p222d.p228b.C2192c;
import org.apache.http.myHttp.protocol.HTTP;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.b.f */
public class C2023f extends C1786a {
    private Activity f6592j;
    private C1983c f6593k;
    private int f6594l;
    private int f6595m;
    private int f6596n;
    private int f6597o;
    private int f6598p;

    public C2023f(Activity activity, C1983c c1983c, int i, int i2, int i3, int i4, int i5) {
        super(activity);
        this.f6592j = activity;
        this.f6593k = c1983c;
        this.f6594l = i3;
        this.f6595m = i;
        this.f6596n = i2;
        this.f6597o = i4;
        this.f6598p = i5;
    }

    private int m9653a(int i, int i2, int i3, String str) {
        if (i == C1594n.TEXT.ordinal()) {
            if (i2 != C1592l.IN.ordinal()) {
                return 11;
            }
            if (i3 == C1595o.SINGLE.ordinal()) {
                return 12;
            }
            if (i3 == C1595o.GROUP.ordinal()) {
                return 13;
            }
            if (i3 == C1595o.CHANNEL.ordinal()) {
                return 14;
            }
        } else if (i == C1594n.IMAGE.ordinal()) {
            if (i2 != C1592l.IN.ordinal()) {
                return (str == null || str.isEmpty()) ? 21 : 71;
            } else {
                if (str == null || str.isEmpty()) {
                    if (i3 == C1595o.SINGLE.ordinal()) {
                        return 22;
                    }
                    if (i3 == C1595o.GROUP.ordinal()) {
                        return 23;
                    }
                    if (i3 == C1595o.CHANNEL.ordinal()) {
                        return 24;
                    }
                } else if (i3 == C1595o.SINGLE.ordinal()) {
                    return 72;
                } else {
                    if (i3 == C1595o.GROUP.ordinal()) {
                        return 73;
                    }
                    if (i3 == C1595o.CHANNEL.ordinal()) {
                        return 74;
                    }
                }
            }
        } else if (i == C1594n.VIDEO.ordinal()) {
            if (i2 != C1592l.IN.ordinal()) {
                return (str == null || str.isEmpty()) ? 31 : 81;
            } else {
                if (str == null || str.isEmpty()) {
                    if (i3 == C1595o.SINGLE.ordinal()) {
                        return 32;
                    }
                    if (i3 == C1595o.GROUP.ordinal()) {
                        return 33;
                    }
                    if (i3 == C1595o.CHANNEL.ordinal()) {
                        return 34;
                    }
                } else if (i3 == C1595o.SINGLE.ordinal()) {
                    return 82;
                } else {
                    if (i3 == C1595o.GROUP.ordinal()) {
                        return 83;
                    }
                    if (i3 == C1595o.CHANNEL.ordinal()) {
                        return 84;
                    }
                }
            }
        } else if (i == C1594n.PUSH_TO_TALK.ordinal()) {
            if (i2 != C1592l.IN.ordinal()) {
                return 51;
            }
            if (i3 == C1595o.SINGLE.ordinal()) {
                return 52;
            }
            if (i3 == C1595o.GROUP.ordinal()) {
                return 53;
            }
            if (i3 == C1595o.CHANNEL.ordinal()) {
                return 54;
            }
        } else if (i == C1594n.FILE.ordinal()) {
            if (i2 != C1592l.IN.ordinal()) {
                return 41;
            }
            if (i3 == C1595o.SINGLE.ordinal()) {
                return 42;
            }
            if (i3 == C1595o.GROUP.ordinal()) {
                return 43;
            }
            if (i3 == C1595o.CHANNEL.ordinal()) {
                return 44;
            }
        } else if (i == C1594n.STICKER.ordinal()) {
            if (i2 != C1592l.IN.ordinal()) {
                return 61;
            }
            if (i3 == C1595o.SINGLE.ordinal()) {
                return 62;
            }
            if (i3 == C1595o.GROUP.ordinal()) {
                return 63;
            }
            if (i3 == C1595o.CHANNEL.ordinal()) {
                return 64;
            }
        } else if (i == C1594n.REPORT.ordinal()) {
            return 8;
        } else {
            if (i == C1594n.VOTE.ordinal()) {
                return 92;
            }
            if (i == C1594n.MISSED_CALL.ordinal() || i == C1594n.CALL.ordinal()) {
                return 9;
            }
        }
        return -1;
    }

    private C1712b m9654a(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        switch (i) {
            case Version.API08_FROYO_22 /*8*/:
                return new C2134c(null, layoutInflater, viewGroup);
            case Version.API09_GINGERBREAD_23 /*9*/:
                return new C2133b(null, layoutInflater, viewGroup);
            case Version.API11_HONEYCOMB_30 /*11*/:
                return new C2099t(this.f6592j, null, layoutInflater, viewGroup);
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                return new C2072t(this.f6592j, null, layoutInflater, viewGroup);
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                return new C2126u(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j);
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                return new ao(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j);
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                return new C2088i(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Toolbar_logoDescription /*22*/:
                return new C2061i(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Toolbar_titleTextColor /*23*/:
                return new C2115j(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Toolbar_subtitleTextColor /*24*/:
                return new C2039m(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_actionModeCloseDrawable /*31*/:
                return new ab(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case HTTP.SP /*32*/:
                return new mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.ab(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_actionModeCopyDrawable /*33*/:
                return new ac(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_actionModePasteDrawable /*34*/:
                return new aw(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_textAppearanceSmallPopupMenu /*41*/:
                return new C2081b(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_dialogTheme /*42*/:
                return new C2054b(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_dialogPreferredPadding /*43*/:
                return new C2108c(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_listDividerAlertDialog /*44*/:
                return new C2032f(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_buttonBarButtonStyle /*51*/:
                return new C2092m(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_selectableItemBackground /*52*/:
                return new C2065m(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_selectableItemBackgroundBorderless /*53*/:
                return new C2119n(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_borderlessButtonStyle /*54*/:
                return new ah(this.f6592j, null, layoutInflater, viewGroup, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_popupWindowStyle /*61*/:
                return new C2096q(this.f6592j, null, layoutInflater, viewGroup, this.f6594l);
            case C1317h.Theme_editTextColor /*62*/:
                return new C2069q(this.f6592j, null, layoutInflater, viewGroup, this.f6594l);
            case C1317h.Theme_editTextBackground /*63*/:
                return new C2123r(this.f6592j, null, layoutInflater, viewGroup, this.f6594l, (C1992a) this.f6592j);
            case C1317h.Theme_imageButtonStyle /*64*/:
                return new al(this.f6592j, null, layoutInflater, viewGroup, this.f6594l, (C1992a) this.f6592j);
            case C1317h.Theme_listPreferredItemHeightLarge /*71*/:
                return new C2084e(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_listPreferredItemPaddingLeft /*72*/:
                return new C2057e(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_listPreferredItemPaddingRight /*73*/:
                return new C2111f(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_dropDownListViewStyle /*74*/:
                return new C2035i(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_listChoiceBackgroundIndicator /*81*/:
                return new C2103x(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_colorPrimary /*82*/:
                return new C2076x(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_colorPrimaryDark /*83*/:
                return new C2130y(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_colorAccent /*84*/:
                return new as(this.f6592j, null, layoutInflater, viewGroup, this.f6595m, this.f6596n, (C1992a) this.f6592j, (C1992a) this.f6592j, (C1992a) this.f6592j);
            case C1317h.Theme_alertDialogButtonGroupStyle /*92*/:
                return new C2043q(this.f6592j, null, layoutInflater, viewGroup, this.f6597o, (C1992a) this.f6592j);
            default:
                return null;
        }
    }

    public C1712b m9655a(ViewGroup viewGroup, int i) {
        return m9654a(m8750a(), viewGroup, i);
    }

    protected C1722f m9656a(Cursor cursor, int i) {
        boolean z;
        boolean z2;
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        int i2 = cursor.getInt(cursor.getColumnIndex("conversations_event_type"));
        int i3 = cursor.getInt(cursor.getColumnIndex("conversations_event_state"));
        int i4 = cursor.getInt(cursor.getColumnIndex("conversations_direction_type"));
        int i5 = cursor.getInt(cursor.getColumnIndex("conversations_group_type"));
        long j2 = cursor.getLong(cursor.getColumnIndex("conversations_send_time"));
        String string = cursor.getString(cursor.getColumnIndex("conversations_event"));
        String string2 = cursor.getString(cursor.getColumnIndex("conversations_message_id"));
        String string3 = cursor.getString(cursor.getColumnIndex("conversations_reply_message_id"));
        String string4 = cursor.getString(cursor.getColumnIndex("conversations_extra"));
        String string5 = cursor.getString(cursor.getColumnIndex("conversations_party"));
        String string6 = cursor.getString(cursor.getColumnIndex("members_local_name"));
        String string7 = cursor.getString(cursor.getColumnIndex("members_local_phone_number"));
        String string8 = cursor.getString(cursor.getColumnIndex("conversations_peer_user_id"));
        String string9 = cursor.getString(cursor.getColumnIndex("members_nick_name"));
        String string10 = cursor.getString(cursor.getColumnIndex("members_avatar_thumbnail_url"));
        Object obj = cursor.getInt(cursor.getColumnIndex("members_is_local_user")) != 0 ? 1 : null;
        int a = m9653a(i2, i4, i5, string);
        boolean z3 = false;
        boolean z4 = false;
        if (i == cursor.getCount() - 1) {
            z = true;
            z4 = !this.f6593k.m9340a();
            z2 = false;
        } else {
            Cursor cursor2 = (Cursor) m8746b(i + 1);
            long j3 = cursor2.getLong(cursor2.getColumnIndex("conversations_send_time"));
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j2);
            int i6 = instance.get(6);
            instance.setTimeInMillis(j3);
            if (i6 != instance.get(6)) {
                z3 = true;
            }
            boolean z5 = i4 == C1592l.IN.ordinal() && i3 == C1593m.NOT_READ.ordinal() && cursor2.getInt(cursor.getColumnIndex("conversations_event_state")) != C1593m.NOT_READ.ordinal();
            m8746b(i);
            z = z3;
            z2 = z5;
        }
        String a2 = i4 == C1592l.OUT.ordinal() ? "You" : obj != null ? mobi.mmdt.ott.view.p178a.ah.m8469a(string6, string7) : mobi.mmdt.ott.view.p178a.ah.m8470b(string9, string8);
        switch (a) {
            case Version.API08_FROYO_22 /*8*/:
                return new C2192c(i, string2, string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2));
            case Version.API09_GINGERBREAD_23 /*9*/:
                i3 = 1;
                if (i2 == C1594n.MISSED_CALL.ordinal()) {
                    i3 = 1;
                } else if (i2 == C1594n.CALL.ordinal()) {
                    i3 = i4 == C1592l.IN.ordinal() ? 2 : 3;
                }
                return new C2191b(i, string2, string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), i3);
            case Version.API11_HONEYCOMB_30 /*11*/:
                return new C2179g(j, i, string5, a2, string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, this.f6598p);
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                return new C2170g(j, i, string5, a2, string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, this.f6598p);
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                return new C2187g(j, i, string8, string10, string5, a2, string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, this.f6598p);
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                return new C2161h(j, i, string8, string10, string5, a2, string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G(), this.f6598p);
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                return new C2176d(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Toolbar_logoDescription /*22*/:
                return new C2167d(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Toolbar_titleTextColor /*23*/:
                return new C2184d(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Toolbar_subtitleTextColor /*24*/:
                return new C2157d(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G());
            case C1317h.Theme_actionModeCloseDrawable /*31*/:
                return new C2181i(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")));
            case HTTP.SP /*32*/:
                return new C2172i(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")));
            case C1317h.Theme_actionModeCopyDrawable /*33*/:
                return new C2189i(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")));
            case C1317h.Theme_actionModePasteDrawable /*34*/:
                return new C2163j(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")), cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G());
            case C1317h.Theme_textAppearanceSmallPopupMenu /*41*/:
                return new C2174b(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_name")), C1111c.m6403b(cursor.getInt(cursor.getColumnIndex("files_size"))), cursor.getString(cursor.getColumnIndex("files_file_uri")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Theme_dialogTheme /*42*/:
                return new C2165b(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_name")), C1111c.m6403b(cursor.getInt(cursor.getColumnIndex("files_size"))), cursor.getString(cursor.getColumnIndex("files_file_uri")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Theme_dialogPreferredPadding /*43*/:
                return new C2182b(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_name")), C1111c.m6403b(cursor.getInt(cursor.getColumnIndex("files_size"))), cursor.getString(cursor.getColumnIndex("files_file_uri")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Theme_listDividerAlertDialog /*44*/:
                return new C2155b(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_name")), C1111c.m6403b(cursor.getInt(cursor.getColumnIndex("files_size"))), cursor.getString(cursor.getColumnIndex("files_file_uri")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G());
            case C1317h.Theme_buttonBarButtonStyle /*51*/:
                return new C2177e(j, i, string5, a2, cursor.getInt(cursor.getColumnIndex("files_duration")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getInt(cursor.getColumnIndex("files_audio_state")), cursor.getInt(cursor.getColumnIndex("files_audio_playing_time")));
            case C1317h.Theme_selectableItemBackground /*52*/:
                return new C2168e(j, i, string5, a2, cursor.getInt(cursor.getColumnIndex("files_duration")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getInt(cursor.getColumnIndex("files_audio_state")), cursor.getInt(cursor.getColumnIndex("files_audio_playing_time")));
            case C1317h.Theme_selectableItemBackgroundBorderless /*53*/:
                return new C2185e(j, i, string8, string10, string5, a2, cursor.getInt(cursor.getColumnIndex("files_duration")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getInt(cursor.getColumnIndex("files_audio_state")), cursor.getInt(cursor.getColumnIndex("files_audio_playing_time")));
            case C1317h.Theme_borderlessButtonStyle /*54*/:
                return new C2159f(j, i, string8, string10, string5, a2, cursor.getInt(cursor.getColumnIndex("files_duration")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getInt(cursor.getColumnIndex("files_audio_state")), cursor.getInt(cursor.getColumnIndex("files_audio_playing_time")), cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G());
            case C1317h.Theme_popupWindowStyle /*61*/:
                return new C2178f(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("stickers_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_package_id")), cursor.getString(cursor.getColumnIndex("stickers_sticker_version")), cursor.getString(cursor.getColumnIndex("conversations_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_thumbnail_uri")), cursor.getString(cursor.getColumnIndex("stickers_original_uri")), cursor.getInt(cursor.getColumnIndex("stickers_hor_span")), cursor.getInt(cursor.getColumnIndex("stickers_ver_span")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4);
            case C1317h.Theme_editTextColor /*62*/:
                return new C2169f(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("stickers_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_package_id")), cursor.getString(cursor.getColumnIndex("stickers_sticker_version")), cursor.getString(cursor.getColumnIndex("conversations_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_thumbnail_uri")), cursor.getString(cursor.getColumnIndex("stickers_original_uri")), cursor.getInt(cursor.getColumnIndex("stickers_hor_span")), cursor.getInt(cursor.getColumnIndex("stickers_ver_span")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, string8, C1634g.values()[cursor.getInt(cursor.getColumnIndex("stickers_download_state"))]);
            case C1317h.Theme_editTextBackground /*63*/:
                return new C2186f(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("stickers_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_package_id")), cursor.getString(cursor.getColumnIndex("stickers_sticker_version")), cursor.getString(cursor.getColumnIndex("conversations_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_thumbnail_uri")), cursor.getString(cursor.getColumnIndex("stickers_original_uri")), cursor.getInt(cursor.getColumnIndex("stickers_hor_span")), cursor.getInt(cursor.getColumnIndex("stickers_ver_span")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, string8, C1634g.values()[cursor.getInt(cursor.getColumnIndex("stickers_download_state"))]);
            case C1317h.Theme_imageButtonStyle /*64*/:
                return new C2160g(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("stickers_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_package_id")), cursor.getString(cursor.getColumnIndex("stickers_sticker_version")), cursor.getString(cursor.getColumnIndex("conversations_sticker_id")), cursor.getString(cursor.getColumnIndex("stickers_thumbnail_uri")), cursor.getString(cursor.getColumnIndex("stickers_original_uri")), cursor.getInt(cursor.getColumnIndex("stickers_hor_span")), cursor.getInt(cursor.getColumnIndex("stickers_ver_span")), j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, string8, C1634g.values()[cursor.getInt(cursor.getColumnIndex("stickers_download_state"))], cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G());
            case C1317h.Theme_listPreferredItemHeightLarge /*71*/:
                return new C2175c(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Theme_listPreferredItemPaddingLeft /*72*/:
                return new C2166c(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Theme_listPreferredItemPaddingRight /*73*/:
                return new C2183c(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")));
            case C1317h.Theme_dropDownListViewStyle /*74*/:
                return new C2156c(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G());
            case C1317h.Theme_listChoiceBackgroundIndicator /*81*/:
                return new C2180h(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")));
            case C1317h.Theme_colorPrimary /*82*/:
                return new C2171h(j, i, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")));
            case C1317h.Theme_colorPrimaryDark /*83*/:
                return new C2188h(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")));
            case C1317h.Theme_colorAccent /*84*/:
                return new C2162i(j, i, string8, string10, string5, a2, cursor.getString(cursor.getColumnIndex("files_file_uri")), cursor.getString(cursor.getColumnIndex("files_thumbnail_uri")), C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_thumbnail_download_state"))], string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], C1604i.values()[cursor.getInt(cursor.getColumnIndex("files_download_state"))], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("files_progress")), cursor.getInt(cursor.getColumnIndex("files_duration")), cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G());
            case C1317h.Theme_alertDialogButtonGroupStyle /*92*/:
                return new C2158e(j, i, string8, string10, string5, a2, string, j2, C1111c.m6395a(this.d, j2), z, z2, z4, C1111c.m6394a(j2), C1593m.values()[i3], string2, string3, string4, cursor.getInt(cursor.getColumnIndex("conversations_my_like")), cursor.getInt(cursor.getColumnIndex("conversations_likes")), ((ChannelConversationActivity) this.f6592j).m9517G(), cursor.getString(cursor.getColumnIndex("conversations_my_vote")));
            default:
                return null;
        }
    }

    public int getItemViewType(int i) {
        Cursor cursor = (Cursor) m8746b(i);
        return m9653a(cursor.getInt(cursor.getColumnIndex("conversations_event_type")), cursor.getInt(cursor.getColumnIndex("conversations_direction_type")), cursor.getInt(cursor.getColumnIndex("conversations_group_type")), cursor.getString(cursor.getColumnIndex("conversations_event")));
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9655a(viewGroup, i);
    }
}
