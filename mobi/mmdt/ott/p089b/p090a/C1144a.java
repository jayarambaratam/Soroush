package mobi.mmdt.ott.p089b.p090a;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p089b.C1143f;
import mobi.mmdt.ott.p089b.C1153a;
import mobi.mmdt.ott.p089b.C1161e;
import mobi.mmdt.ott.p089b.C1162g;
import mobi.mmdt.ott.p089b.C1163h;
import mobi.mmdt.ott.p089b.C1164i;
import mobi.mmdt.ott.p089b.p090a.p091a.C1138a;
import mobi.mmdt.ott.p089b.p090a.p091a.C1139b;
import mobi.mmdt.ott.p089b.p090a.p092b.C1141a;
import mobi.mmdt.ott.p089b.p090a.p092b.C1145b;
import mobi.mmdt.ott.p089b.p090a.p093c.C1142a;
import mobi.mmdt.ott.p089b.p090a.p093c.C1148b;
import mobi.mmdt.ott.p089b.p094b.C1154a;
import mobi.mmdt.ott.p089b.p094b.C1155b;
import mobi.mmdt.ott.p089b.p094b.C1156c;
import mobi.mmdt.ott.p089b.p094b.C1157d;
import org.jivesoftware.smack.ConnectionConfiguration.SecurityMode;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.ReconnectionManager;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smack.roster.Roster;
import org.jivesoftware.smack.roster.Roster.SubscriptionMode;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration.Builder;
import org.jivesoftware.smack.util.TLSUtils;
import org.jivesoftware.smackx.chatstates.ChatState;
import org.jivesoftware.smackx.iqlast.LastActivityManager;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.ping.PingManager;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.b.a.a */
public class C1144a implements C1138a, C1141a, C1142a, C1143f {
    private static C1144a f4199a;
    private Context f4200b;
    private XMPPTCPConnection f4201c;
    private XMPPTCPConnectionConfiguration f4202d;
    private C1164i f4203e;
    private C1139b f4204f;
    private C1148b f4205g;
    private C1145b f4206h;
    private PingManager f4207i;
    private C1153a f4208j;
    private long f4209k;
    private boolean f4210l;
    private HostnameVerifier f4211m;
    private ConnectionListener f4212n;

    private C1144a(Context context) {
        this.f4210l = false;
        this.f4211m = new C1147b(this);
        this.f4212n = new C1151d(this);
        m6521b(context);
    }

    public static C1144a m6516a(Context context) {
        if (f4199a == null) {
            f4199a = new C1144a(context);
        }
        return f4199a;
    }

    private void m6521b(Context context) {
        this.f4200b = context;
        Roster.setDefaultSubscriptionMode(SubscriptionMode.accept_all);
        ReconnectionManager.setEnabledPerDefault(false);
        LastActivityManager.setEnabledPerDefault(true);
    }

    private SSLContext m6523d() {
        C1150c c1150c = new C1150c(this);
        SSLContext instance = SSLContext.getInstance(TLSUtils.TLS);
        instance.init(null, new TrustManager[]{c1150c}, null);
        return instance;
    }

    public long m6526a(String str) {
        if (m6541a(false, false)) {
            try {
                return this.f4205g.m6563c(str + "@" + this.f4201c.getServiceName());
            } catch (Exception e) {
                throw new C1157d(e);
            } catch (Exception e2) {
                throw new C1156c(e2);
            } catch (Exception e22) {
                throw new C1155b(e22);
            }
        }
        throw new C1156c(new IOException());
    }

    public String m6527a(String str, String str2, String str3, Map<String, String> map) {
        if (m6541a(true, true)) {
            try {
                return this.f4206h.m6551a(str + "@" + "conference." + this.f4201c.getServiceName(), str2, str3, map);
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            }
        }
        throw new C1156c(new IOException());
    }

    public String m6528a(String str, String str2, String str3, Map<String, String> map, boolean z) {
        if (m6541a(true, false)) {
            try {
                return this.f4204f.m6492a(str + "@" + this.f4201c.getServiceName(), str2, str3, map, z);
            } catch (Exception e) {
                throw new C1156c(e);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6529a() {
        if (this.f4201c != null) {
            this.f4201c.disconnect();
        }
    }

    public void m6530a(String str, int i) {
        if (m6541a(true, false)) {
            try {
                this.f4206h.m6553a(str + "@" + "conference." + this.f4201c.getServiceName(), i);
                return;
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            } catch (Exception e22) {
                throw new C1154a(e22);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6531a(String str, String str2) {
        if (m6541a(true, false)) {
            try {
                String str3 = str2 + "@" + this.f4201c.getServiceName();
                this.f4206h.m6555a(str + "@" + "conference." + this.f4201c.getServiceName(), str3);
                return;
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            } catch (Exception e22) {
                throw new C1155b(e22);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6532a(String str, String str2, String str3) {
        if (m6541a(true, false)) {
            try {
                String str4 = str2 + "@" + this.f4201c.getServiceName();
                this.f4206h.m6556a(str + "@" + "conference." + this.f4201c.getServiceName(), str4, str3);
                return;
            } catch (Exception e) {
                throw new C1156c(e);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6533a(String str, String str2, String str3, String str4, Map<String, String> map) {
        String str5 = str3.split("@")[0];
        this.f4203e.m6573a(str2.split("@")[0], str5, str4, str, map);
    }

    public void m6534a(String str, String str2, C1161e c1161e) {
        if (m6541a(true, false)) {
            try {
                String str3 = str2 + "@" + this.f4201c.getServiceName();
                String str4 = str + "@" + "conference." + this.f4201c.getServiceName();
                switch (C1152e.f4227b[c1161e.ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        this.f4206h.m6557a(str4, str3, MUCAffiliation.admin);
                        return;
                    case VideoSize.HVGA /*2*/:
                        this.f4206h.m6557a(str4, str3, MUCAffiliation.member);
                        return;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        this.f4206h.m6557a(str4, str3, MUCAffiliation.outcast);
                        return;
                    case Version.API04_DONUT_16 /*4*/:
                        this.f4206h.m6557a(str4, str3, MUCAffiliation.owner);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            } catch (Exception e22) {
                throw new C1155b(e22);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6535a(String str, String str2, ChatState chatState) {
        String str3 = str2.split("@")[0];
        String str4 = str.split("@")[0];
        switch (C1152e.f4228c[chatState.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4203e.m6578b(str4, str3, C1162g.COMPOSING);
            case VideoSize.HVGA /*2*/:
                this.f4203e.m6578b(str4, str3, C1162g.GONE);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4203e.m6578b(str4, str3, C1162g.INACTIVE);
            case Version.API04_DONUT_16 /*4*/:
                this.f4203e.m6578b(str4, str3, C1162g.PAUSED);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f4203e.m6578b(str4, str3, C1162g.ACTIVE);
            default:
        }
    }

    public void m6536a(String str, Presence presence) {
        String str2 = str.split("@")[0];
        switch (C1152e.f4229d[presence.getType().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4203e.m6576a(str2, C1163h.Online);
            case VideoSize.HVGA /*2*/:
                this.f4203e.m6576a(str2, C1163h.Offline);
            default:
        }
    }

    public synchronized void m6537a(C1153a c1153a) {
        Throwable th;
        if (!(this.f4210l || m6541a(true, false))) {
            Object obj;
            this.f4210l = true;
            this.f4208j = c1153a;
            try {
                this.f4209k = c1153a.m6569f();
                this.f4202d = ((Builder) ((Builder) ((Builder) ((Builder) ((Builder) ((Builder) ((Builder) ((Builder) XMPPTCPConnectionConfiguration.builder().setSendPresence(true)).setCompressionEnabled(false).setDebuggerEnabled(C1104b.f4137a)).setSecurityMode(SecurityMode.required)).setCustomSSLContext(m6523d())).setHost(c1153a.m6566c())).setPort(c1153a.m6567d())).setServiceName(c1153a.m6564a())).setHostnameVerifier(this.f4211m)).build();
                if (this.f4201c != null) {
                    this.f4201c.disconnect();
                }
                this.f4201c = new XMPPTCPConnection(this.f4202d);
                this.f4201c.setPacketReplyTimeout(10000);
                this.f4204f = new C1139b(this);
                this.f4205g = new C1148b(this);
                this.f4206h = new C1145b(this);
                this.f4201c.addConnectionListener(this.f4212n);
                this.f4201c.connect();
                this.f4201c.login(c1153a.m6568e(), c1153a.m6565b(), c1153a.m6570g());
                th = null;
                obj = 1;
            } catch (Exception e) {
                th = e;
                C1104b.m6368b((Object) this, th);
                obj = null;
            }
            this.f4210l = false;
            if (obj == null) {
                throw th;
            }
        }
    }

    public void m6538a(C1162g c1162g, String str) {
        if (m6541a(true, false)) {
            String str2 = str + "@" + this.f4201c.getServiceName();
            try {
                switch (C1152e.f4226a[c1162g.ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        this.f4204f.m6494a(ChatState.inactive, str2);
                        return;
                    case VideoSize.HVGA /*2*/:
                        this.f4204f.m6494a(ChatState.paused, str2);
                        return;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        this.f4204f.m6494a(ChatState.composing, str2);
                        return;
                    case Version.API04_DONUT_16 /*4*/:
                        this.f4204f.m6494a(ChatState.gone, str2);
                        return;
                    case Version.API05_ECLAIR_20 /*5*/:
                        this.f4204f.m6494a(ChatState.active, str2);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                throw new C1156c(e);
            }
            throw new C1156c(e);
        }
        throw new C1156c(new IOException());
    }

    public void m6539a(C1164i c1164i) {
        if (this.f4203e == null) {
            this.f4203e = c1164i;
        }
    }

    public void m6540a(ChatState chatState, String str) {
        String str2 = str.split("@")[0];
        switch (C1152e.f4228c[chatState.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f4203e.m6575a(str2, str2, C1162g.COMPOSING);
            case VideoSize.HVGA /*2*/:
                this.f4203e.m6575a(str2, str2, C1162g.GONE);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f4203e.m6575a(str2, str2, C1162g.INACTIVE);
            case Version.API04_DONUT_16 /*4*/:
                this.f4203e.m6575a(str2, str2, C1162g.PAUSED);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f4203e.m6575a(str2, str2, C1162g.ACTIVE);
            default:
        }
    }

    public boolean m6541a(boolean z, boolean z2) {
        boolean z3 = false;
        if (this.f4201c == null || !this.f4201c.isConnected() || !this.f4201c.isAuthenticated()) {
            return false;
        }
        if (!z && !z2) {
            return true;
        }
        if (z) {
            boolean e;
            try {
                e = C1107a.m6380e(this.f4200b);
            } catch (Throwable e2) {
                C1104b.m6368b((Object) this, e2);
                e = false;
            } catch (Throwable e22) {
                C1104b.m6368b((Object) this, e22);
                e = false;
            }
            if (!e) {
                return false;
            }
            z3 = e;
        }
        if (!z2) {
            return z3;
        }
        try {
            return this.f4207i.pingMyServer();
        } catch (Throwable e222) {
            C1104b.m6368b((Object) this, e222);
            return z3;
        }
    }

    public void m6542b(String str) {
        if (m6541a(true, false)) {
            try {
                this.f4206h.m6552a(str + "@" + "conference." + this.f4201c.getServiceName());
                return;
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            } catch (Exception e22) {
                throw new C1154a(e22);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6543b(String str, String str2) {
        this.f4203e.m6572a(str, str2.split("@")[0]);
    }

    public void m6544b(String str, String str2, String str3, Map<String, String> map) {
        this.f4203e.m6574a(str.split("@")[0], str2, str3, map);
    }

    public void m6545b(C1162g c1162g, String str) {
        if (m6541a(true, false)) {
            try {
                String str2 = str + "@" + "conference." + this.f4201c.getServiceName();
                switch (C1152e.f4226a[c1162g.ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        this.f4206h.m6559a(ChatState.inactive, str2);
                        return;
                    case VideoSize.HVGA /*2*/:
                        this.f4206h.m6559a(ChatState.paused, str2);
                        return;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        this.f4206h.m6559a(ChatState.composing, str2);
                        return;
                    case Version.API04_DONUT_16 /*4*/:
                        this.f4206h.m6559a(ChatState.gone, str2);
                        return;
                    case Version.API05_ECLAIR_20 /*5*/:
                        this.f4206h.m6559a(ChatState.active, str2);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6546b(C1164i c1164i) {
        this.f4203e = c1164i;
    }

    public boolean m6547b() {
        return this.f4210l;
    }

    public String m6548c() {
        if (m6541a(true, false)) {
            try {
                return this.f4206h.m6550a().split("@")[0];
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            } catch (Exception e22) {
                throw new C1155b(e22);
            } catch (Exception e222) {
                throw new C1154a(e222);
            }
        }
        throw new C1156c(new IOException());
    }

    public void m6549c(String str) {
        if (m6541a(true, false)) {
            try {
                this.f4206h.m6554a(str + "@" + "conference." + this.f4201c.getServiceName(), this.f4209k);
                return;
            } catch (Exception e) {
                throw new C1156c(e);
            } catch (Exception e2) {
                throw new C1157d(e2);
            } catch (Exception e22) {
                throw new C1154a(e22);
            }
        }
        throw new C1156c(new IOException());
    }
}
