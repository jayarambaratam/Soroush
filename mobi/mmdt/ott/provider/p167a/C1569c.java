package mobi.mmdt.ott.provider.p167a;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: mobi.mmdt.ott.provider.a.c */
public abstract class C1569c<T extends C1569c<?>> {
    Boolean f5252a;
    String f5253b;
    String f5254c;
    Integer f5255d;
    private final StringBuilder f5256e;
    private final List<String> f5257f;
    private final StringBuilder f5258g;

    public C1569c() {
        this.f5256e = new StringBuilder();
        this.f5257f = new ArrayList(5);
        this.f5258g = new StringBuilder();
    }

    private String m7904a(Object obj) {
        return obj instanceof Date ? String.valueOf(((Date) obj).getTime()) : obj instanceof Boolean ? ((Boolean) obj).booleanValue() ? "1" : "0" : obj instanceof Enum ? String.valueOf(((Enum) obj).ordinal()) : String.valueOf(obj);
    }

    public int m7905a(Context context) {
        return context.getContentResolver().delete(m7917f(), m7914c(), m7915d());
    }

    public T m7906a() {
        this.f5256e.append(")");
        return this;
    }

    protected void m7907a(String str, Object obj) {
        this.f5256e.append(str);
        this.f5256e.append("<=?");
        this.f5257f.add(m7904a(obj));
    }

    protected void m7908a(String str, Object[] objArr) {
        int i = 0;
        this.f5256e.append(str);
        if (objArr == null) {
            this.f5256e.append(" IS NULL");
        } else if (objArr.length > 1) {
            this.f5256e.append(" IN (");
            while (i < objArr.length) {
                this.f5256e.append("?");
                if (i < objArr.length - 1) {
                    this.f5256e.append(",");
                }
                this.f5257f.add(m7904a(objArr[i]));
                i++;
            }
            this.f5256e.append(")");
        } else if (objArr[0] == null) {
            this.f5256e.append(" IS NULL");
        } else {
            this.f5256e.append("=?");
            this.f5257f.add(m7904a(objArr[0]));
        }
    }

    protected Object[] m7909a(Boolean bool) {
        return new Object[]{bool};
    }

    protected Object[] m7910a(int... iArr) {
        Object[] objArr = new Object[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            objArr[i] = Integer.valueOf(iArr[i]);
        }
        return objArr;
    }

    protected Object[] m7911a(long... jArr) {
        Object[] objArr = new Object[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            objArr[i] = Long.valueOf(jArr[i]);
        }
        return objArr;
    }

    public T m7912b() {
        this.f5256e.append(" AND ");
        return this;
    }

    protected void m7913b(String str, Object[] objArr) {
        int i = 0;
        this.f5256e.append(str);
        if (objArr == null) {
            this.f5256e.append(" IS NOT NULL");
        } else if (objArr.length > 1) {
            this.f5256e.append(" NOT IN (");
            while (i < objArr.length) {
                this.f5256e.append("?");
                if (i < objArr.length - 1) {
                    this.f5256e.append(",");
                }
                this.f5257f.add(m7904a(objArr[i]));
                i++;
            }
            this.f5256e.append(")");
        } else if (objArr[0] == null) {
            this.f5256e.append(" IS NOT NULL");
        } else {
            this.f5256e.append("<>?");
            this.f5257f.add(m7904a(objArr[0]));
        }
    }

    public String m7914c() {
        return this.f5256e.toString();
    }

    public String[] m7915d() {
        int size = this.f5257f.size();
        return size == 0 ? null : (String[]) this.f5257f.toArray(new String[size]);
    }

    public String m7916e() {
        return this.f5258g.length() > 0 ? this.f5258g.toString() : null;
    }

    public Uri m7917f() {
        Uri g = m7918g();
        if (this.f5252a != null) {
            g = C1566d.m7881a(g, this.f5252a.booleanValue());
        }
        if (this.f5253b != null) {
            g = C1566d.m7883c(g, this.f5253b);
        }
        if (this.f5254c != null) {
            g = C1566d.m7884d(g, this.f5254c);
        }
        return this.f5255d != null ? C1566d.m7885e(g, String.valueOf(this.f5255d)) : g;
    }

    protected abstract Uri m7918g();
}
