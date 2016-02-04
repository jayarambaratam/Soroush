package mobi.mmdt.ott.provider.p170d;

import android.database.Cursor;
import mobi.mmdt.ott.provider.p167a.C1568b;

/* renamed from: mobi.mmdt.ott.provider.d.f */
public class C1601f extends C1568b {
    public C1601f(Cursor cursor) {
        super(cursor);
    }

    public long m8122a() {
        Long d = m7902d("_id");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
    }

    public String m8123b() {
        return m7900b("files_file_uri");
    }

    public String m8124c() {
        return m7900b("files_file_url");
    }

    public String m8125d() {
        return m7900b("files_server_file_id");
    }

    public C1605j m8126e() {
        Integer c = m7901c("files_type");
        if (c != null) {
            return C1605j.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'type' in the database was null, which is not allowed according to the model definition");
    }

    public String m8127f() {
        String b = m7900b("files_name");
        if (b != null) {
            return b;
        }
        throw new NullPointerException("The value of 'name' in the database was null, which is not allowed according to the model definition");
    }

    public long m8128g() {
        Long d = m7902d("files_size");
        if (d != null) {
            return d.longValue();
        }
        throw new NullPointerException("The value of 'size' in the database was null, which is not allowed according to the model definition");
    }

    public int m8129h() {
        Integer c = m7901c("files_progress");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'progress' in the database was null, which is not allowed according to the model definition");
    }

    public String m8130i() {
        return m7900b("files_thumbnail_uri");
    }

    public String m8131j() {
        return m7900b("files_thumbnail_url");
    }

    public Integer m8132k() {
        return m7901c("files_duration");
    }

    public C1604i m8133l() {
        Integer c = m7901c("files_download_state");
        if (c != null) {
            return C1604i.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'download_state' in the database was null, which is not allowed according to the model definition");
    }

    public C1604i m8134m() {
        Integer c = m7901c("files_thumbnail_download_state");
        if (c != null) {
            return C1604i.values()[c.intValue()];
        }
        throw new NullPointerException("The value of 'THUMBNAIL_download_state' in the database was null, which is not allowed according to the model definition");
    }

    public C1603h m8135n() {
        Integer c = m7901c("files_audio_state");
        return c == null ? null : C1603h.values()[c.intValue()];
    }

    public int m8136o() {
        Integer c = m7901c("files_audio_playing_time");
        if (c != null) {
            return c.intValue();
        }
        throw new NullPointerException("The value of 'audio_playing_time' in the database was null, which is not allowed according to the model definition");
    }
}
