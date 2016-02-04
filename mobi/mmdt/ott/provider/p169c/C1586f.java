package mobi.mmdt.ott.provider.p169c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import mobi.mmdt.ott.provider.p167a.C1567a;

/* renamed from: mobi.mmdt.ott.provider.c.f */
public class C1586f extends C1567a {
    public int m8006a(Context context, C1589i c1589i) {
        String[] strArr = null;
        ContentResolver contentResolver = context.getContentResolver();
        Uri a = m8007a();
        ContentValues b = m7898b();
        String c = c1589i == null ? null : c1589i.m7914c();
        if (c1589i != null) {
            strArr = c1589i.m7915d();
        }
        return contentResolver.update(a, b, c, strArr);
    }

    public Uri m8007a() {
        return C1585e.f5294a;
    }

    public C1586f m8008a(int i) {
        this.a.put("conversations_likes", Integer.valueOf(i));
        return this;
    }

    public C1586f m8009a(long j) {
        this.a.put("conversations_send_time", Long.valueOf(j));
        return this;
    }

    public C1586f m8010a(Long l) {
        this.a.put("conversations_file_id", l);
        return this;
    }

    public C1586f m8011a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("messageId must not be null");
        }
        this.a.put("conversations_message_id", str);
        return this;
    }

    public C1586f m8012a(C1592l c1592l) {
        if (c1592l == null) {
            throw new IllegalArgumentException("directionType must not be null");
        }
        this.a.put("conversations_direction_type", Integer.valueOf(c1592l.ordinal()));
        return this;
    }

    public C1586f m8013a(C1593m c1593m) {
        if (c1593m == null) {
            throw new IllegalArgumentException("eventState must not be null");
        }
        this.a.put("conversations_event_state", Integer.valueOf(c1593m.ordinal()));
        return this;
    }

    public C1586f m8014a(C1594n c1594n) {
        if (c1594n == null) {
            throw new IllegalArgumentException("eventType must not be null");
        }
        this.a.put("conversations_event_type", Integer.valueOf(c1594n.ordinal()));
        return this;
    }

    public C1586f m8015a(C1595o c1595o) {
        if (c1595o == null) {
            throw new IllegalArgumentException("groupType must not be null");
        }
        this.a.put("conversations_group_type", Integer.valueOf(c1595o.ordinal()));
        return this;
    }

    public C1586f m8016b(int i) {
        this.a.put("conversations_my_like", Integer.valueOf(i));
        return this;
    }

    public C1586f m8017b(long j) {
        this.a.put("conversations_receive_time", Long.valueOf(j));
        return this;
    }

    public C1586f m8018b(String str) {
        this.a.put("conversations_event", str);
        return this;
    }

    public C1586f m8019c() {
        this.a.putNull("conversations_reply_message_id");
        return this;
    }

    public C1586f m8020c(String str) {
        this.a.put("conversations_my_vote", str);
        return this;
    }

    public C1586f m8021d(String str) {
        this.a.put("conversations_reply_message_id", str);
        return this;
    }

    public C1586f m8022e(String str) {
        if (str == null) {
            throw new IllegalArgumentException("party must not be null");
        }
        this.a.put("conversations_party", str);
        return this;
    }

    public C1586f m8023f(String str) {
        if (str == null) {
            throw new IllegalArgumentException("sender must not be null");
        }
        this.a.put("conversations_peer_user_id", str);
        return this;
    }

    public C1586f m8024g(String str) {
        this.a.put("conversations_sticker_id", str);
        return this;
    }

    public C1586f m8025h(String str) {
        this.a.put("conversations_extra", str);
        return this;
    }
}
