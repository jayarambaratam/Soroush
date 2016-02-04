package mobi.mmdt.ott.provider.p169c;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;

/* renamed from: mobi.mmdt.ott.provider.c.g */
public class C1587g extends C1568b {
    public C1587g(Cursor cursor) {
        super(cursor);
    }

    public long m8026a() {
        Long d = m7902d("_id");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m8027b() {
        String b = m7900b("conversations_message_id");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'message_id' in the database was null, which is not allowed according to the model definition");
    }

    public C1594n m8028c() {
        Integer c = m7901c("conversations_event_type");
        if (c != null) {
            return C1594n.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'event_type' in the database was null, which is not allowed according to the model definition");
    }

    public String m8029d() {
        return m7900b("conversations_event");
    }

    public long m8030e() {
        Long d = m7902d("conversations_send_time");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of 'send_time' in the database was null, which is not allowed according to the model definition");
    }

    public long m8031f() {
        Long d = m7902d("conversations_receive_time");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of 'receive_time' in the database was null, which is not allowed according to the model definition");
    }

    public C1592l m8032g() {
        Integer c = m7901c("conversations_direction_type");
        if (c != null) {
            return C1592l.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'direction_type' in the database was null, which is not allowed according to the model definition");
    }

    public C1593m m8033h() {
        Integer c = m7901c("conversations_event_state");
        if (c != null) {
            return C1593m.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'event_state' in the database was null, which is not allowed according to the model definition");
    }

    public String m8034i() {
        String b = m7900b("conversations_party");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'party' in the database was null, which is not allowed according to the model definition");
    }

    public String m8035j() {
        String b = m7900b("conversations_peer_user_id");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'sender' in the database was null, which is not allowed according to the model definition");
    }

    public C1595o m8036k() {
        Integer c = m7901c("conversations_group_type");
        if (c != null) {
            return C1595o.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'group_type' in the database was null, which is not allowed according to the model definition");
    }

    public Long m8037l() {
        return m7902d("conversations_file_id");
    }

    public String m8038m() {
        return m7900b("conversations_sticker_id");
    }

    public String m8039n() {
        return m7900b("conversations_reply_message_id");
    }
}
