package com.p065c.p066a.p067a.p075h.p076a;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.p065c.p066a.p067a.p072e.C0956b;

/* renamed from: com.c.a.a.h.a.c */
public class C0979c {
    String f3696a;
    final SQLiteDatabase f3697b;
    final String f3698c;
    final String f3699d;
    final int f3700e;
    final long f3701f;
    private SQLiteStatement f3702g;
    private SQLiteStatement f3703h;
    private SQLiteStatement f3704i;
    private SQLiteStatement f3705j;
    private SQLiteStatement f3706k;
    private SQLiteStatement f3707l;
    private SQLiteStatement f3708m;

    public C0979c(SQLiteDatabase sQLiteDatabase, String str, String str2, int i, long j) {
        this.f3697b = sQLiteDatabase;
        this.f3698c = str;
        this.f3700e = i;
        this.f3699d = str2;
        this.f3701f = j;
        this.f3696a = "SELECT * FROM " + str + " WHERE " + C0977a.f3685a.f3714a + " = ?";
    }

    public static String m6001a(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }

    public static String m6002a(String str, C0982f c0982f, C0982f... c0982fArr) {
        StringBuilder stringBuilder = new StringBuilder("CREATE TABLE ");
        stringBuilder.append(str).append(" (");
        stringBuilder.append(c0982f.f3714a).append(" ");
        stringBuilder.append(c0982f.f3715b);
        stringBuilder.append("  primary key autoincrement ");
        for (C0982f c0982f2 : c0982fArr) {
            stringBuilder.append(", `").append(c0982f2.f3714a).append("` ").append(c0982f2.f3715b);
        }
        stringBuilder.append(" );");
        C0956b.m5904a(stringBuilder.toString(), new Object[0]);
        return stringBuilder.toString();
    }

    public SQLiteStatement m6003a() {
        if (this.f3702g == null) {
            StringBuilder append = new StringBuilder("INSERT INTO ").append(this.f3698c);
            append.append(" VALUES (");
            for (int i = 0; i < this.f3700e; i++) {
                if (i != 0) {
                    append.append(",");
                }
                append.append("?");
            }
            append.append(")");
            this.f3702g = this.f3697b.compileStatement(append.toString());
        }
        return this.f3702g;
    }

    public String m6004a(String str, Integer num, C0980d... c0980dArr) {
        StringBuilder stringBuilder = new StringBuilder("SELECT * FROM ");
        stringBuilder.append(this.f3698c);
        if (str != null) {
            stringBuilder.append(" WHERE ").append(str);
        }
        int length = c0980dArr.length;
        Object obj = 1;
        int i = 0;
        while (i < length) {
            C0980d c0980d = c0980dArr[i];
            if (obj != null) {
                stringBuilder.append(" ORDER BY ");
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(c0980d.f3709a.f3714a).append(" ").append(c0980d.f3710b);
            i++;
            obj = null;
        }
        if (num != null) {
            stringBuilder.append(" LIMIT ").append(num);
        }
        return stringBuilder.toString();
    }

    public void m6005a(long j) {
        this.f3697b.execSQL("UPDATE job_holder SET " + C0977a.f3691g.f3714a + "=?", new Object[]{Long.valueOf(j)});
    }

    public SQLiteStatement m6006b() {
        if (this.f3706k == null) {
            this.f3706k = this.f3697b.compileStatement("SELECT COUNT(*) FROM " + this.f3698c + " WHERE " + C0977a.f3692h.f3714a + " != ?");
        }
        return this.f3706k;
    }

    public SQLiteStatement m6007c() {
        if (this.f3703h == null) {
            StringBuilder append = new StringBuilder("INSERT OR REPLACE INTO ").append(this.f3698c);
            append.append(" VALUES (");
            for (int i = 0; i < this.f3700e; i++) {
                if (i != 0) {
                    append.append(",");
                }
                append.append("?");
            }
            append.append(")");
            this.f3703h = this.f3697b.compileStatement(append.toString());
        }
        return this.f3703h;
    }

    public SQLiteStatement m6008d() {
        if (this.f3704i == null) {
            this.f3704i = this.f3697b.compileStatement("DELETE FROM " + this.f3698c + " WHERE " + this.f3699d + " = ?");
        }
        return this.f3704i;
    }

    public SQLiteStatement m6009e() {
        if (this.f3705j == null) {
            this.f3705j = this.f3697b.compileStatement("UPDATE " + this.f3698c + " SET " + C0977a.f3688d.f3714a + " = ? , " + C0977a.f3692h.f3714a + " = ? " + " WHERE " + this.f3699d + " = ? ");
        }
        return this.f3705j;
    }

    public SQLiteStatement m6010f() {
        if (this.f3707l == null) {
            this.f3707l = this.f3697b.compileStatement("SELECT " + C0977a.f3691g.f3714a + " FROM " + this.f3698c + " WHERE " + C0977a.f3692h.f3714a + " != " + this.f3701f + " ORDER BY " + C0977a.f3691g.f3714a + " ASC" + " LIMIT 1");
        }
        return this.f3707l;
    }

    public SQLiteStatement m6011g() {
        if (this.f3708m == null) {
            this.f3708m = this.f3697b.compileStatement("SELECT " + C0977a.f3691g.f3714a + " FROM " + this.f3698c + " WHERE " + C0977a.f3692h.f3714a + " != " + this.f3701f + " AND " + C0977a.f3693i.f3714a + " != 1" + " ORDER BY " + C0977a.f3691g.f3714a + " ASC" + " LIMIT 1");
        }
        return this.f3708m;
    }
}
