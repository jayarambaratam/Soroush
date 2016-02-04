package mobi.mmdt.ott.provider.p167a;

import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.HashMap;

/* renamed from: mobi.mmdt.ott.provider.a.b */
public abstract class C1568b extends CursorWrapper {
    private final HashMap<String, Integer> f5251a;

    public C1568b(Cursor cursor) {
        super(cursor);
        this.f5251a = new HashMap((cursor.getColumnCount() * 4) / 3, 0.75f);
    }

    protected int m7899a(String str) {
        Integer num = (Integer) this.f5251a.get(str);
        if (num == null) {
            num = Integer.valueOf(getColumnIndexOrThrow(str));
            this.f5251a.put(str, num);
        }
        return num.intValue();
    }

    public String m7900b(String str) {
        int a = m7899a(str);
        return isNull(a) ? null : getString(a);
    }

    public Integer m7901c(String str) {
        int a = m7899a(str);
        return isNull(a) ? null : Integer.valueOf(getInt(a));
    }

    public Long m7902d(String str) {
        int a = m7899a(str);
        return isNull(a) ? null : Long.valueOf(getLong(a));
    }

    public Boolean m7903e(String str) {
        int a = m7899a(str);
        if (isNull(a)) {
            return null;
        }
        return Boolean.valueOf(getInt(a) != 0);
    }
}
