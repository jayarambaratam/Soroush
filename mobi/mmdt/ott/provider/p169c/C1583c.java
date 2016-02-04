package mobi.mmdt.ott.provider.p169c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.af;
import mobi.mmdt.ott.p109d.p110a.C1306b;
import mobi.mmdt.ott.provider.p168b.C1574c;
import mobi.mmdt.ott.provider.p170d.C1599d;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.provider.p171e.C1608b;
import mobi.mmdt.ott.provider.p172f.C1619f;
import mobi.mmdt.ott.provider.p173g.C1623d;
import mobi.mmdt.ott.provider.p174h.C1630c;
import mobi.mmdt.ott.view.p178a.ah;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.provider.c.c */
public class C1583c {
    public static int m7960a(Context context) {
        C1586f c1586f = new C1586f();
        c1586f.m8013a(C1593m.PENDING);
        C1589i c1589i = new C1589i();
        c1589i.m8057a(C1593m.PENDING_RETRANSMIT);
        return c1586f.m8006a(context, c1589i);
    }

    public static int m7961a(Context context, String str, long j, long j2) {
        C1586f c1586f = new C1586f();
        c1586f.m8009a(j);
        c1586f.m8017b(j2);
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static int m7962a(Context context, String str, Long l) {
        C1586f c1586f = new C1586f();
        c1586f.m8013a(C1593m.SEEN);
        C1589i c1589i = new C1589i();
        ((C1589i) ((C1589i) ((C1589i) c1589i.m8054a(l.longValue()).m7912b()).m8056a(C1592l.OUT).m7912b()).m8061b(str).m7912b()).m8057a(C1593m.DELIVERED);
        return c1586f.m8006a(context, c1589i);
    }

    public static int m7963a(Context context, String str, String str2) {
        C1586f c1586f = new C1586f();
        c1586f.m8020c(str2);
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static int m7964a(Context context, String str, String str2, String str3, C1594n c1594n, String str4, String str5, String str6, String str7) {
        C1586f c1586f = new C1586f();
        c1586f.m8025h(new C1582b(str2, str3, c1594n, str4, str5, str6, str7).m7959a());
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static int m7965a(Context context, String str, C1593m c1593m) {
        C1586f c1586f = new C1586f();
        c1586f.m8013a(c1593m);
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static Uri m7966a(Context context, String str, C1594n c1594n, String str2, long j, long j2, C1592l c1592l, C1593m c1593m, String str3, C1595o c1595o, String str4, Long l, String str5) {
        if (C1583c.m7972a(context, str, c1592l)) {
            throw new C1581a();
        } else if (str3 == null || str4 == null) {
            throw new NullPointerException();
        } else {
            C1586f c1586f = new C1586f();
            c1586f.m8011a(str).m8014a(c1594n).m8018b(str2.trim()).m8009a(j).m8017b(j2).m8012a(c1592l).m8013a(c1593m).m8022e(str3).m8015a(c1595o).m8023f(str4).m8010a(l).m8024g(str5);
            return context.getContentResolver().insert(C1585e.f5294a, c1586f.m7898b());
        }
    }

    private static String m7967a() {
        return "conversations.conversations_message_id,conversations.conversations_event_type,conversations.conversations_event,conversations.conversations_send_time,conversations.conversations_receive_time,conversations.conversations_likes,conversations.conversations_my_like,conversations.conversations_my_vote,conversations.conversations_reply_message_id,conversations.conversations_direction_type,conversations.conversations_event_state,conversations.conversations_party,conversations.conversations_peer_user_id,conversations.conversations_group_type,conversations.conversations_file_id,conversations.conversations_sticker_id,conversations.conversations_extra";
    }

    public static C1588h m7968a(Context context, long j) {
        C1589i c1589i = new C1589i();
        c1589i.m8060b(j);
        C1587g b = c1589i.m8059b(context);
        C1588h c1588h = null;
        if (b.moveToFirst()) {
            c1588h = new C1588h(b.m8026a(), b.m8027b(), b.m8028c(), b.m8029d(), b.m8030e(), b.m8031f(), b.m8032g(), b.m8033h(), b.m8034i(), b.m8036k(), b.m8035j(), b.m8037l(), b.m8038m(), b.m8039n());
        }
        b.close();
        return c1588h;
    }

    public static C1588h m7969a(Context context, String str) {
        C1589i c1589i = new C1589i();
        ((C1589i) c1589i.m8061b(str).m7912b()).m8057a(C1593m.DRAFT);
        C1587g b = c1589i.m8059b(context);
        C1588h c1588h = null;
        if (b.moveToFirst()) {
            c1588h = new C1588h(b.m8026a(), b.m8027b(), b.m8028c(), b.m8029d(), b.m8030e(), b.m8031f(), b.m8032g(), b.m8033h(), b.m8034i(), b.m8036k(), b.m8035j(), b.m8037l(), b.m8038m(), b.m8039n());
        }
        b.close();
        return c1588h;
    }

    public static C1590j m7970a(Context context, String str, int i) {
        String str2 = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7990e() + " FROM " + "(((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations" + "." + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "PrivateGroups" + " ON " + "conversations_party" + " = " + "PrivateGroups_group_id" + ") WHERE " + "conversations" + "." + "conversations_party" + " = " + "'" + str + "' AND " + "conversations" + "." + "conversations_event_state" + " <> " + C1593m.DRAFT.ordinal() + " ORDER BY " + "conversations" + "." + "conversations_send_time" + " DESC " + " LIMIT " + i;
        return new C1590j(context, C1585e.f5294a, str2, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1623d.f5433a);
    }

    public static void m7971a(Context context, ArrayList<C1306b> arrayList) {
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1306b c1306b = (C1306b) it.next();
            if (c1306b.m6907i() == null || c1306b.m6908j() == null) {
                throw new NullPointerException();
            }
            contentValuesArr[i] = new ContentValues();
            contentValuesArr[i].put("conversations_message_id", c1306b.m6898a());
            contentValuesArr[i].put("conversations_event_type", Integer.valueOf(c1306b.m6902d().ordinal()));
            contentValuesArr[i].put("conversations_event", c1306b.m6910l().trim());
            contentValuesArr[i].put("conversations_send_time", Long.valueOf(c1306b.m6906h()));
            contentValuesArr[i].put("conversations_receive_time", Long.valueOf(c1306b.m6905g()));
            contentValuesArr[i].put("conversations_direction_type", Integer.valueOf(c1306b.m6900b().ordinal()));
            contentValuesArr[i].put("conversations_event_state", Integer.valueOf(c1306b.m6901c().ordinal()));
            contentValuesArr[i].put("conversations_party", c1306b.m6907i());
            contentValuesArr[i].put("conversations_group_type", Integer.valueOf(c1306b.m6903e().ordinal()));
            contentValuesArr[i].put("conversations_peer_user_id", c1306b.m6908j());
            contentValuesArr[i].put("conversations_file_id", c1306b.m6904f());
            contentValuesArr[i].put("conversations_sticker_id", c1306b.m6909k());
            contentValuesArr[i].put("conversations_reply_message_id", c1306b.m6911m());
            i++;
        }
        new C1589i().m8058a(context, contentValuesArr);
    }

    public static boolean m7972a(Context context, String str, C1592l c1592l) {
        C1589i c1589i = new C1589i();
        ((C1589i) c1589i.m8055a(str).m7912b()).m8056a(c1592l);
        Cursor b = c1589i.m8059b(context);
        if (b.getCount() > 0) {
            b.close();
            return true;
        }
        b.close();
        return false;
    }

    public static String[] m7973a(Context context, String str, int i, int i2) {
        String str2 = "SELECT conversations_message_id FROM conversations WHERE conversations_party = '" + str + "' AND " + "conversations_group_type" + " = '" + C1595o.CHANNEL.ordinal() + "'" + " ORDER BY " + "conversations_send_time" + " ASC " + " LIMIT " + i + " OFFSET " + i2;
        ArrayList arrayList = new ArrayList();
        C1587g a = new C1589i().m8052a(context, str2);
        if (a.moveToFirst()) {
            do {
                arrayList.add(a.m8027b());
            } while (a.moveToNext());
        }
        a.close();
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static int m7974b(Context context, String str, int i) {
        C1586f c1586f = new C1586f();
        if (i < 0) {
            C1104b.m6362a((Object) C1583c.class, "LIKE COUNT BE NEGATIVE MessageId:" + str);
            i = 0;
        }
        c1586f.m8008a(i);
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static int m7975b(Context context, String str, int i, int i2) {
        C1586f c1586f = new C1586f();
        c1586f.m8016b(i2);
        if (i2 == af.LIKE.ordinal()) {
            c1586f.m8008a(i + 1);
        } else if (i2 == af.UNLIKE.ordinal()) {
            c1586f.m8008a(i - 1);
        }
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static int m7976b(Context context, String str, String str2) {
        C1586f c1586f = new C1586f();
        if (str2 != null) {
            c1586f.m8021d(str2);
        } else {
            c1586f.m8019c();
        }
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static long m7977b(Context context, long j) {
        C1589i c1589i = new C1589i();
        c1589i.m8060b(j);
        C1587g b = c1589i.m8059b(context);
        long j2 = -1;
        if (b.moveToFirst()) {
            j2 = b.m8037l().longValue();
        }
        b.close();
        return j2;
    }

    public static long m7978b(Context context, String str) {
        return (long) new C1589i().m8055a(str).m7905a(context);
    }

    private static String m7979b() {
        return "files.files_file_uri,files.files_type,files.files_name,files.files_size,files.files_progress,files.files_thumbnail_uri,files.files_download_state,files.files_thumbnail_download_state,files.files_duration,files.files_audio_playing_time,files.files_audio_state";
    }

    public static List<SimpleEntry<String, Integer>> m7980b(Context context) {
        C1587g a = new C1589i().m8052a(context, "SELECT conversations_party, _id, COUNT(_id) AS unread_count FROM conversations WHERE conversations_event_state = '" + C1593m.NOT_READ.ordinal() + "' AND " + "conversations_direction_type" + " = '" + C1592l.IN.ordinal() + "' GROUP BY " + "conversations_party");
        List<SimpleEntry<String, Integer>> arrayList = new ArrayList(a.getCount());
        if (a.moveToFirst()) {
            do {
                String string = a.getString(a.getColumnIndex("conversations_party"));
                int i = a.getInt(a.getColumnIndex("unread_count"));
                if (string != null) {
                    arrayList.add(new SimpleEntry(string, Integer.valueOf(i)));
                }
            } while (a.moveToNext());
        }
        a.close();
        return arrayList;
    }

    public static long m7981c(Context context, long j) {
        return (long) new C1589i().m8060b(j).m7905a(context);
    }

    public static long m7982c(Context context, String str) {
        return (long) new C1589i().m8061b(str).m7905a(context);
    }

    private static String m7983c() {
        return "stickers.stickers_sticker_id,stickers.stickers_package_id,stickers.stickers_sticker_version,stickers.stickers_original_uri,stickers.stickers_thumbnail_uri,stickers.stickers_ver_span,stickers.stickers_hor_span,stickers.stickers_download_state";
    }

    public static C1588h[] m7984c(Context context) {
        C1589i c1589i = new C1589i();
        c1589i.m8057a(C1593m.SENDING);
        C1587g b = c1589i.m8059b(context);
        C1588h[] c1588hArr = new C1588h[b.getCount()];
        if (b.moveToFirst()) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                c1588hArr[i] = new C1588h(b.m8026a(), b.m8027b(), b.m8028c(), b.m8029d(), b.m8030e(), b.m8031f(), b.m8032g(), b.m8033h(), b.m8034i(), b.m8036k(), b.m8035j(), b.m8037l(), b.m8038m(), b.m8039n());
                if (!b.moveToNext()) {
                    break;
                }
                i = i2;
            }
        }
        b.close();
        return c1588hArr;
    }

    public static int m7985d(Context context) {
        C1589i c1589i = new C1589i();
        c1589i.m8057a(C1593m.PENDING);
        C1587g b = c1589i.m8059b(context);
        int count = b.getCount();
        b.close();
        return count;
    }

    public static int m7986d(Context context, String str) {
        C1589i c1589i = new C1589i();
        ((C1589i) ((C1589i) c1589i.m8057a(C1593m.NOT_READ).m7912b()).m8056a(C1592l.IN).m7912b()).m8061b(str);
        C1587g b = c1589i.m8059b(context);
        int count = b.getCount();
        b.close();
        return count;
    }

    private static String m7987d() {
        return "members.members_nick_name,members.members_avatar_url,members.members_avatar_thumbnail_url,members.members_user_id,members.members_is_local_user,members.members_last_online,members.members_can_reply,members.members_is_anouncer,members.members_local_name,members.members_local_phone_number,members.members_moto,members.members_local_image_uri";
    }

    public static C1588h[] m7988d(Context context, long j) {
        C1589i c1589i = new C1589i();
        ((C1589i) c1589i.m8057a(C1593m.PENDING).m7912b()).m8054a(j);
        C1587g b = c1589i.m8059b(context);
        C1588h[] c1588hArr = new C1588h[b.getCount()];
        if (b.moveToFirst()) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                c1588hArr[i] = new C1588h(b.m8026a(), b.m8027b(), b.m8028c(), b.m8029d(), b.m8030e(), b.m8031f(), b.m8032g(), b.m8033h(), b.m8034i(), b.m8036k(), b.m8035j(), b.m8037l(), b.m8038m(), b.m8039n());
                if (!b.moveToNext()) {
                    break;
                }
                i = i2;
            }
        }
        b.close();
        return c1588hArr;
    }

    public static int m7989e(Context context, String str) {
        C1586f c1586f = new C1586f();
        c1586f.m8013a(C1593m.READ);
        C1589i c1589i = new C1589i();
        ((C1589i) c1589i.m8061b(str).m7912b()).m8057a(C1593m.NOT_READ);
        return c1586f.m8006a(context, c1589i);
    }

    private static String m7990e() {
        return "PrivateGroups.PrivateGroups_group_id,PrivateGroups.PrivateGroups_name,PrivateGroups.PrivateGroups_avatar_url,PrivateGroups.PrivateGroups_thumbnail_url,PrivateGroups.PrivateGroups_description,PrivateGroups.PrivateGroups_is_mute,PrivateGroups.PrivateGroups_my_role";
    }

    public static C1590j m7991e(Context context) {
        String str = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + "MAX (" + "conversations" + "." + "conversations_send_time" + ") as " + "MAX_DATE" + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7990e() + " FROM " + "(((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "PrivateGroups" + " ON " + "conversations_party" + " = " + "PrivateGroups_group_id" + ") WHERE " + "conversations" + "." + "conversations_group_type" + " <> '" + C1595o.CHANNEL.ordinal() + "' GROUP BY " + "conversations" + "." + "conversations_party" + " ORDER BY " + "MAX_DATE" + " DESC LIMIT 20";
        return new C1590j(context, C1585e.f5294a, str, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1623d.f5433a);
    }

    private static String m7992f() {
        return "CHANNELS.CHANNELS_name,CHANNELS.CHANNELS_avatar_url,CHANNELS.CHANNELS_avatar_thumbnail_url,CHANNELS.CHANNELS_description,CHANNELS.CHANNELS_is_mute,CHANNELS.CHANNELS_my_role,CHANNELS.CHANNELS_channel_owner";
    }

    public static C1590j m7993f(Context context) {
        String str = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + "MAX (" + "conversations" + "." + "conversations_send_time" + ") as " + "MAX_DATE" + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7990e() + " FROM " + "(((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "PrivateGroups" + " ON " + "conversations_party" + " = " + "PrivateGroups_group_id" + ") WHERE " + "conversations" + "." + "conversations_group_type" + " = '" + C1595o.GROUP.ordinal() + "' GROUP BY " + "conversations" + "." + "conversations_party" + " ORDER BY " + "MAX_DATE" + " DESC ";
        return new C1590j(context, C1585e.f5294a, str, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1623d.f5433a);
    }

    public static C1588h[] m7994f(Context context, String str) {
        C1589i c1589i = new C1589i();
        ((C1589i) ((C1589i) c1589i.m8057a(C1593m.PENDING).m7906a()).m7912b()).m8061b(str);
        C1587g b = c1589i.m8059b(context);
        C1588h[] c1588hArr = new C1588h[b.getCount()];
        if (b.moveToFirst()) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                c1588hArr[i] = new C1588h(b.m8026a(), b.m8027b(), b.m8028c(), b.m8029d(), b.m8030e(), b.m8031f(), b.m8032g(), b.m8033h(), b.m8034i(), b.m8036k(), b.m8035j(), b.m8037l(), b.m8038m(), b.m8039n());
                if (!b.moveToNext()) {
                    break;
                }
                i = i2;
            }
        }
        b.close();
        return c1588hArr;
    }

    public static int m7995g(Context context, String str) {
        C1589i c1589i = new C1589i();
        c1589i.m8061b(str);
        C1587g b = c1589i.m8059b(context);
        int count = b.getCount();
        b.close();
        return count;
    }

    public static C1590j m7996g(Context context) {
        String str = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7990e() + "," + C1583c.m7992f() + " FROM " + "((((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations" + "." + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "PrivateGroups" + " ON " + "conversations_party" + " = " + "PrivateGroups_group_id" + ")" + " LEFT JOIN " + "CHANNELS" + " ON " + "conversations_party" + " = " + "CHANNELS_id" + ") WHERE " + "conversations" + "." + "conversations_event_state" + " = '" + C1593m.NOT_READ.ordinal() + "' AND " + "conversations_direction_type" + " = '" + C1592l.IN.ordinal() + "' " + "AND (" + "(" + "conversations_group_type" + " =" + C1595o.SINGLE.ordinal() + ") OR (" + "conversations_group_type" + " = " + C1595o.GROUP.ordinal() + " AND " + "PrivateGroups_is_mute" + " <> 1 )" + " OR (" + "conversations_group_type" + " = " + C1595o.CHANNEL.ordinal() + " AND " + "CHANNELS_is_mute" + " <> 1 )" + ") ORDER BY " + "conversations" + "." + "conversations_send_time" + " DESC ";
        return new C1590j(context, C1585e.f5294a, str, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1623d.f5433a);
    }

    public static C1593m m7997h(Context context, String str) {
        C1589i c1589i = new C1589i();
        c1589i.m8061b(str);
        C1587g b = c1589i.m8059b(context);
        C1593m c1593m = null;
        if (b.moveToFirst()) {
            c1593m = b.m8033h();
        }
        b.close();
        return c1593m;
    }

    public static C1590j m7998i(Context context, String str) {
        String str2 = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7990e() + " FROM " + "(((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations" + "." + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "PrivateGroups" + " ON " + "conversations_party" + " = " + "PrivateGroups_group_id" + ") WHERE " + "conversations" + "." + "conversations_party" + " = '" + str + "' AND (" + "conversations" + "." + "conversations_event_type" + " = " + C1594n.IMAGE.ordinal() + " OR " + "conversations" + "." + "conversations_event_type" + " = " + C1594n.VIDEO.ordinal() + ") AND (" + "conversations" + "." + "conversations_direction_type" + " = " + C1592l.OUT.ordinal() + " OR " + "files" + "." + "files_download_state" + " = " + C1604i.FINISHED.ordinal() + ")" + "ORDER BY " + "conversations" + "." + "conversations_send_time" + " ASC ";
        return new C1590j(context, C1585e.f5294a, str2, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1623d.f5433a);
    }

    public static C1590j m7999j(Context context, String str) {
        String str2 = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7990e() + " FROM " + "(((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations" + "." + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "PrivateGroups" + " ON " + "conversations_party" + " = " + "PrivateGroups_group_id" + ") WHERE " + "conversations" + "." + "conversations_party" + " = '" + str + "' AND (" + "conversations" + "." + "conversations_event_type" + " = " + C1594n.IMAGE.ordinal() + " OR " + "conversations" + "." + "conversations_event_type" + " = " + C1594n.VIDEO.ordinal() + ") AND (" + "conversations" + "." + "conversations_direction_type" + " = " + C1592l.OUT.ordinal() + " OR " + "files" + "." + "files_download_state" + " = " + C1604i.FINISHED.ordinal() + ")" + "ORDER BY " + "conversations" + "." + "conversations_send_time" + " DESC ";
        return new C1590j(context, C1585e.f5294a, str2, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1623d.f5433a);
    }

    public static C1590j m8000k(Context context, String str) {
        String str2 = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + "MAX (" + "conversations" + "." + "conversations_send_time" + ") as " + "MAX_DATE" + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7990e() + " FROM " + "(((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "PrivateGroups" + " ON " + "conversations_party" + " = " + "PrivateGroups_group_id" + ") WHERE " + "conversations" + "." + "conversations_group_type" + " <> '" + C1595o.CHANNEL.ordinal() + "' " + " AND ( " + "(" + "conversations" + "." + "conversations_group_type" + " = '" + C1595o.GROUP.ordinal() + "' AND " + "PrivateGroups" + "." + "PrivateGroups_name" + " LIKE '%" + str + "%' ) " + " OR " + "( " + "conversations" + "." + "conversations_group_type" + " = '" + C1595o.SINGLE.ordinal() + "' AND ( ( " + "members" + "." + "members_is_local_user" + " <> '0' AND " + "members" + "." + "members_local_name" + " LIKE '%" + str + "%' ) OR ( " + "members" + "." + "members_is_local_user" + " = '0' AND " + "members" + "." + "members_nick_name" + " LIKE '%" + str + "%' )" + " ) " + " ) " + " ) " + " GROUP BY " + "conversations" + "." + "conversations_party" + " ORDER BY " + "MAX_DATE" + " DESC ";
        return new C1590j(context, C1585e.f5294a, str2, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1623d.f5433a);
    }

    public static C1590j m8001l(Context context, String str) {
        String str2 = "SELECT conversations._id as _id," + C1583c.m7967a() + "," + "MAX (" + "conversations" + "." + "conversations_send_time" + ") as " + "MAX_DATE" + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + "," + C1583c.m7992f() + " FROM " + "(((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ")" + " LEFT JOIN " + "CHANNELS" + " ON " + "conversations_party" + " = " + "CHANNELS_id" + ") WHERE " + "conversations" + "." + "conversations_group_type" + " = '" + C1595o.CHANNEL.ordinal() + "'" + " AND " + "CHANNELS" + "." + "CHANNELS_my_role" + " <> " + C1619f.NONE.ordinal() + " AND " + "CHANNELS" + "." + "CHANNELS_name" + " LIKE '%" + str + "%' " + " GROUP BY " + "conversations" + "." + "conversations_party" + " ORDER BY " + "MAX_DATE" + " DESC ";
        return new C1590j(context, C1585e.f5294a, str2, C1585e.f5294a, C1599d.f5376a, C1630c.f5439a, C1608b.f5398a, C1574c.f5275a);
    }

    public static int m8002m(Context context, String str) {
        return new C1589i().m8052a(context, "SELECT " + C1583c.m7967a() + "," + C1583c.m7979b() + " FROM " + "( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations" + "." + "conversations_file_id" + " = " + "files" + "." + "_id" + ") WHERE " + "conversations" + "." + "conversations_party" + " = '" + str + "' AND (" + "conversations" + "." + "conversations_event_type" + " = " + C1594n.IMAGE.ordinal() + " OR " + "conversations" + "." + "conversations_event_type" + " = " + C1594n.VIDEO.ordinal() + ") AND (" + "conversations" + "." + "conversations_direction_type" + " = " + C1592l.OUT.ordinal() + " OR " + "files" + "." + "files_download_state" + " = " + C1604i.FINISHED.ordinal() + ")").getCount();
    }

    public static C1588h m8003n(Context context, String str) {
        C1589i c1589i = new C1589i();
        c1589i.m8055a(str);
        C1587g b = c1589i.m8059b(context);
        C1588h c1588h = null;
        if (b.moveToFirst()) {
            c1588h = new C1588h(b.m8026a(), b.m8027b(), b.m8028c(), b.m8029d(), b.m8030e(), b.m8031f(), b.m8032g(), b.m8033h(), b.m8034i(), b.m8036k(), b.m8035j(), b.m8037l(), b.m8038m(), b.m8039n());
        }
        b.close();
        return c1588h;
    }

    public static int m8004o(Context context, String str) {
        C1586f c1586f = new C1586f();
        c1586f.m8023f(str);
        C1589i c1589i = new C1589i();
        c1589i.m8061b(str);
        return c1586f.m8006a(context, c1589i);
    }

    public static C1591k m8005p(Context context, String str) {
        Cursor a = new C1589i().m8052a(context, "SELECT conversations._id as _id," + C1583c.m7967a() + "," + C1583c.m7979b() + "," + C1583c.m7983c() + "," + C1583c.m7987d() + " FROM " + "((( " + "conversations" + " LEFT JOIN " + "files" + " ON " + "conversations" + "." + "conversations_file_id" + " = " + "files" + "." + "_id" + ")" + " LEFT JOIN " + "stickers" + " ON " + "conversations" + "." + "conversations_sticker_id" + " = " + "stickers_complete_sticker_id" + ")" + " LEFT JOIN " + "members" + " ON " + "conversations_peer_user_id" + " = " + "members_user_id" + ") WHERE " + "conversations" + "." + "conversations_message_id" + " = " + "'" + str + "'");
        C1591k c1591k = null;
        if (a.moveToFirst()) {
            String string;
            String string2 = a.getString(a.getColumnIndex("members_user_id"));
            C1595o c1595o = C1595o.values()[a.getInt(a.getColumnIndex("conversations_group_type"))];
            C1592l c1592l = C1592l.values()[a.getInt(a.getColumnIndex("conversations_direction_type"))];
            Object obj = a.getInt(a.getColumnIndex("members_is_local_user")) != 0 ? 1 : null;
            String string3 = a.getString(a.getColumnIndex("members_local_name"));
            String string4 = a.getString(a.getColumnIndex("members_local_phone_number"));
            String string5 = a.getString(a.getColumnIndex("members_nick_name"));
            if (!c1595o.equals(C1595o.SINGLE)) {
                string4 = ah.m8470b(string5, string2);
            } else if (c1592l.equals(C1592l.IN)) {
                string4 = obj != null ? ah.m8469a(string3, string4) : ah.m8470b(string5, string2);
            } else {
                string4 = "You";
            }
            String string6 = a.getString(a.getColumnIndex("conversations_event"));
            String string7 = a.getString(a.getColumnIndex("files_file_uri"));
            string3 = a.getString(a.getColumnIndex("files_thumbnail_uri"));
            C1594n c1594n = C1594n.values()[a.getInt(a.getColumnIndex("conversations_event_type"))];
            switch (C1584d.f5293a[c1594n.ordinal()]) {
                case VideoSize.CIF /*1*/:
                    string6 = context.getString(2131230930);
                    break;
                case VideoSize.HVGA /*2*/:
                    string6 = context.getString(2131230934);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    string6 = context.getString(2131230932);
                    break;
                case Version.API04_DONUT_16 /*4*/:
                    string6 = context.getString(2131230929);
                    break;
            }
            if (c1594n.equals(C1594n.STICKER)) {
                string = context.getString(2131230933);
                string7 = a.getString(a.getColumnIndex("stickers_original_uri"));
                string3 = a.getString(a.getColumnIndex("stickers_thumbnail_uri"));
            } else {
                string = string6;
            }
            c1591k = new C1591k(string2, string, string7, string3, string4, c1594n);
        }
        a.close();
        return c1591k;
    }
}
