package com.p065c.p066a.p067a.p075h.p076a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteStatement;
import com.p065c.p066a.p067a.C0939i;
import com.p065c.p066a.p067a.C0944a;
import com.p065c.p066a.p067a.C0954d;
import com.p065c.p066a.p067a.p072e.C0956b;
import java.util.Collection;

/* renamed from: com.c.a.a.h.a.g */
public class C0983g implements C0939i {
    C0977a f3717a;
    SQLiteDatabase f3718b;
    C0979c f3719c;
    C0986k f3720d;
    C0978b f3721e;
    C0978b f3722f;
    private final long f3723g;

    public C0983g(Context context, long j, String str, C0986k c0986k) {
        this.f3723g = j;
        this.f3717a = new C0977a(context, "db_" + str);
        this.f3718b = this.f3717a.getWritableDatabase();
        this.f3719c = new C0979c(this.f3718b, "job_holder", C0977a.f3685a.f3714a, 9, j);
        this.f3720d = c0986k;
        this.f3721e = new C0978b();
        this.f3722f = new C0978b();
        this.f3719c.m6005a(Long.MIN_VALUE);
    }

    private C0944a m6012a(byte[] bArr) {
        try {
            return this.f3720d.m6028a(bArr);
        } catch (Throwable th) {
            C0956b.m5905a(th, "error while deserializing job", new Object[0]);
            return null;
        }
    }

    private C0954d m6013a(Cursor cursor) {
        C0944a a = m6012a(cursor.getBlob(C0977a.f3689e.f3716c));
        if (a != null) {
            return new C0954d(Long.valueOf(cursor.getLong(C0977a.f3685a.f3716c)), cursor.getInt(C0977a.f3686b.f3716c), cursor.getString(C0977a.f3687c.f3716c), cursor.getInt(C0977a.f3688d.f3716c), a, cursor.getLong(C0977a.f3690f.f3716c), cursor.getLong(C0977a.f3691g.f3716c), cursor.getLong(C0977a.f3692h.f3716c));
        }
        throw new C0985i();
    }

    private static String m6014a(String str, Collection<String> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str2 : collection) {
            if (stringBuilder.length() != 0) {
                stringBuilder.append(str);
            }
            stringBuilder.append(str2);
        }
        return stringBuilder.toString();
    }

    private String m6015a(boolean z, Collection<String> collection, boolean z2) {
        String str = C0977a.f3692h.f3714a + " != ? " + " AND " + C0977a.f3691g.f3714a + " <= ? ";
        if (!z) {
            str = str + " AND " + C0977a.f3693i.f3714a + " != 1 ";
        }
        String str2 = null;
        if (collection != null && collection.size() > 0) {
            str2 = C0977a.f3687c.f3714a + " IS NULL OR " + C0977a.f3687c.f3714a + " NOT IN('" + C0983g.m6014a("','", (Collection) collection) + "')";
        }
        if (!z2) {
            return str2 != null ? str + " AND ( " + str2 + " )" : str;
        } else {
            str = str + " GROUP BY " + C0977a.f3687c.f3714a;
            return str2 != null ? str + " HAVING " + str2 : str;
        }
    }

    private void m6016a(SQLiteStatement sQLiteStatement, C0954d c0954d) {
        if (c0954d.m5886a() != null) {
            sQLiteStatement.bindLong(C0977a.f3685a.f3716c + 1, c0954d.m5886a().longValue());
        }
        sQLiteStatement.bindLong(C0977a.f3686b.f3716c + 1, (long) c0954d.m5892c());
        if (c0954d.m5898i() != null) {
            sQLiteStatement.bindString(C0977a.f3687c.f3716c + 1, c0954d.m5898i());
        }
        sQLiteStatement.bindLong(C0977a.f3688d.f3716c + 1, (long) c0954d.m5893d());
        byte[] e = m6020e(c0954d);
        if (e != null) {
            sQLiteStatement.bindBlob(C0977a.f3689e.f3716c + 1, e);
        }
        sQLiteStatement.bindLong(C0977a.f3690f.f3716c + 1, c0954d.m5894e());
        sQLiteStatement.bindLong(C0977a.f3691g.f3716c + 1, c0954d.m5896g());
        sQLiteStatement.bindLong(C0977a.f3692h.f3716c + 1, c0954d.m5895f());
        sQLiteStatement.bindLong(C0977a.f3693i.f3716c + 1, c0954d.m5891b() ? 1 : 0);
    }

    private void m6017a(Long l) {
        SQLiteStatement d = this.f3719c.m6008d();
        synchronized (d) {
            d.clearBindings();
            d.bindLong(1, l.longValue());
            d.execute();
        }
    }

    private byte[] m6018a(Object obj) {
        try {
            return this.f3720d.m6029a(obj);
        } catch (Throwable th) {
            C0956b.m5905a(th, "error while serializing object %s", obj.getClass().getSimpleName());
            return null;
        }
    }

    private void m6019d(C0954d c0954d) {
        SQLiteStatement e = this.f3719c.m6009e();
        c0954d.m5890b(c0954d.m5893d() + 1);
        c0954d.m5887a(this.f3723g);
        synchronized (e) {
            e.clearBindings();
            e.bindLong(1, (long) c0954d.m5893d());
            e.bindLong(2, this.f3723g);
            e.bindLong(3, c0954d.m5886a().longValue());
            e.execute();
        }
    }

    private byte[] m6020e(C0954d c0954d) {
        return m6018a(c0954d.m5897h());
    }

    public int m6021a() {
        int simpleQueryForLong;
        SQLiteStatement b = this.f3719c.m6006b();
        synchronized (b) {
            b.clearBindings();
            b.bindLong(1, this.f3723g);
            simpleQueryForLong = (int) b.simpleQueryForLong();
        }
        return simpleQueryForLong;
    }

    public int m6022a(boolean z, Collection<String> collection) {
        String a = this.f3721e.m5999a(z, collection);
        if (a == null) {
            a = "SELECT SUM(case WHEN " + C0977a.f3687c.f3714a + " is null then group_cnt else 1 end) from (" + ("SELECT count(*) group_cnt, " + C0977a.f3687c.f3714a + " FROM " + "job_holder" + " WHERE " + m6015a(z, collection, true)) + ")";
            this.f3721e.m6000a(a, z, collection);
        }
        Cursor rawQuery = this.f3718b.rawQuery(a, new String[]{Long.toString(this.f3723g), Long.toString(System.nanoTime())});
        try {
            if (!rawQuery.moveToNext()) {
                return 0;
            }
            int i = rawQuery.getInt(0);
            rawQuery.close();
            return i;
        } finally {
            rawQuery.close();
        }
    }

    public long m6023a(C0954d c0954d) {
        long executeInsert;
        SQLiteStatement a = this.f3719c.m6003a();
        synchronized (a) {
            a.clearBindings();
            m6016a(a, c0954d);
            executeInsert = a.executeInsert();
        }
        c0954d.m5888a(Long.valueOf(executeInsert));
        return executeInsert;
    }

    public Long m6024a(boolean z) {
        Long valueOf;
        SQLiteStatement f = z ? this.f3719c.m6010f() : this.f3719c.m6011g();
        synchronized (f) {
            try {
                f.clearBindings();
                valueOf = Long.valueOf(f.simpleQueryForLong());
            } catch (SQLiteDoneException e) {
                return null;
            }
        }
        return valueOf;
    }

    public long m6025b(C0954d c0954d) {
        if (c0954d.m5886a() == null) {
            return m6023a(c0954d);
        }
        long executeInsert;
        c0954d.m5887a(Long.MIN_VALUE);
        SQLiteStatement c = this.f3719c.m6007c();
        synchronized (c) {
            c.clearBindings();
            m6016a(c, c0954d);
            executeInsert = c.executeInsert();
        }
        c0954d.m5888a(Long.valueOf(executeInsert));
        return executeInsert;
    }

    public C0954d m6026b(boolean z, Collection<String> collection) {
        C0954d moveToNext;
        Collection collection2 = null;
        String a = this.f3722f.m5999a(z, collection);
        if (a == null) {
            a = m6015a(z, collection, false);
            a = this.f3719c.m6004a(a, Integer.valueOf(1), new C0980d(C0977a.f3686b, C0981e.DESC), new C0980d(C0977a.f3690f, C0981e.ASC), new C0980d(C0977a.f3685a, C0981e.ASC));
            this.f3722f.m6000a(a, z, collection);
        }
        Cursor rawQuery = this.f3718b.rawQuery(a, new String[]{Long.toString(this.f3723g), Long.toString(System.nanoTime())});
        try {
            moveToNext = rawQuery.moveToNext();
            if (moveToNext == false) {
                return collection2;
            }
            moveToNext = m6013a(rawQuery);
            m6019d(moveToNext);
            rawQuery.close();
            return moveToNext;
        } catch (C0985i e) {
            m6017a(Long.valueOf(rawQuery.getLong(0)));
            collection2 = null;
            moveToNext = m6026b(true, null);
            return moveToNext;
        } finally {
            rawQuery.close();
        }
    }

    public void m6027c(C0954d c0954d) {
        if (c0954d.m5886a() == null) {
            C0956b.m5907b("called remove with null job id.", new Object[0]);
        } else {
            m6017a(c0954d.m5886a());
        }
    }
}
