package com.p032a.p033a.p037d.p046c.p048b;

import android.content.Context;
import com.p032a.p033a.p037d.p046c.C0677s;
import com.p032a.p033a.p037d.p046c.C0681t;
import com.p032a.p033a.p037d.p046c.C0709c;
import com.p032a.p033a.p037d.p046c.C0711e;
import com.p032a.p033a.p037d.p046c.C0722p;
import java.io.InputStream;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;

/* renamed from: com.a.a.d.c.b.b */
public class C0694b implements C0681t<C0711e, InputStream> {
    private final C0722p<C0711e, C0711e> f2708a;

    public C0694b() {
        this.f2708a = new C0722p(PacketWriter.QUEUE_SIZE);
    }

    public C0677s<C0711e, InputStream> m4729a(Context context, C0709c c0709c) {
        return new C0693a(this.f2708a);
    }

    public void m4730a() {
    }
}
