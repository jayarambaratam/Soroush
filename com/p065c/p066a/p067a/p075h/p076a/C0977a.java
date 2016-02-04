package com.p065c.p066a.p067a.p075h.p076a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.jivesoftware.smackx.xdatalayout.packet.DataLayout.Text;

/* renamed from: com.c.a.a.h.a.a */
public class C0977a extends SQLiteOpenHelper {
    static final C0982f f3685a;
    static final C0982f f3686b;
    static final C0982f f3687c;
    static final C0982f f3688d;
    static final C0982f f3689e;
    static final C0982f f3690f;
    static final C0982f f3691g;
    static final C0982f f3692h;
    static final C0982f f3693i;

    static {
        f3685a = new C0982f("_id", "integer", 0);
        f3686b = new C0982f("priority", "integer", 1);
        f3687c = new C0982f("group_id", Text.ELEMENT, 2);
        f3688d = new C0982f("run_count", "integer", 3);
        f3689e = new C0982f("base_job", "byte", 4);
        f3690f = new C0982f("created_ns", "long", 5);
        f3691g = new C0982f("delay_until_ns", "long", 6);
        f3692h = new C0982f("running_session_id", "long", 7);
        f3693i = new C0982f("requires_network", "integer", 8);
    }

    public C0977a(Context context, String str) {
        super(context, str, null, 3);
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(C0979c.m6002a("job_holder", f3685a, f3686b, f3687c, f3688d, f3689e, f3690f, f3691g, f3692h, f3693i));
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(C0979c.m6001a("job_holder"));
        onCreate(sQLiteDatabase);
    }
}
