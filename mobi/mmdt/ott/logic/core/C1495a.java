package mobi.mmdt.ott.logic.core;

import android.content.Context;
import android.provider.Settings.Secure;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import mobi.mmdt.componentsutils.p079a.C1107a;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.logic.p156c.C1492b;
import mobi.mmdt.ott.logic.p156c.C1493c;
import mobi.mmdt.ott.logic.p157e.C1518g;
import mobi.mmdt.ott.logic.p161g.C1528a;
import mobi.mmdt.ott.logic.p161g.C1529b;
import mobi.mmdt.ott.logic.p161g.C1534g;
import mobi.mmdt.ott.logic.p164k.C1548c;
import mobi.mmdt.ott.p089b.C1153a;
import mobi.mmdt.ott.p089b.C1158b;
import mobi.mmdt.ott.p089b.C1165j;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.aq;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.at;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.au;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.core.a */
public class C1495a {
    private static C1495a f5039a;
    private Context f5040b;
    private boolean f5041c;
    private C1309a f5042d;
    private Timer f5043e;
    private Timer f5044f;
    private Timer f5045g;
    private int f5046h;
    private int f5047i;
    private Queue<C1493c> f5048j;
    private Queue<C1528a> f5049k;
    private boolean f5050l;

    private C1495a(Context context) {
        this.f5041c = false;
        this.f5046h = 1;
        this.f5047i = 1;
        this.f5048j = new LinkedList();
        this.f5049k = new LinkedList();
        this.f5050l = false;
        this.f5040b = context;
        this.f5042d = C1309a.m6934a(this.f5040b);
    }

    public static C1495a m7555a(Context context) {
        if (f5039a == null) {
            f5039a = new C1495a(context);
        }
        return f5039a;
    }

    private void m7558a(boolean z) {
        C1104b.m6366b((Object) this, "callXMPP " + z);
        if (!m7567k()) {
            long a;
            if (z) {
                try {
                    a = C1548c.m7822a(this.f5040b).m7835d().m6718a();
                } catch (Throwable e) {
                    C1104b.m6368b((Object) this, e);
                    m7564h();
                    return;
                }
            }
            a = ((C1493c) this.f5048j.peek()).m7537g();
            C1153a[] c1153aArr = new C1153a[this.f5048j.size()];
            int i = 0;
            for (C1493c c1493c : this.f5048j) {
                C1158b c1158b = null;
                switch (C1500f.f5057c[c1493c.m7531a().ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        c1158b = C1158b.TCP;
                        break;
                    case VideoSize.HVGA /*2*/:
                        c1158b = C1158b.TLS;
                        break;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        c1158b = C1158b.UDP;
                        break;
                    default:
                        break;
                }
                int i2 = i + 1;
                c1153aArr[i] = new C1153a(c1493c.m7535e(), c1493c.m7532b(), c1493c.m7533c(), c1493c.m7534d(), c1158b, c1493c.m7538h(), c1493c.m7536f(), a);
                i = i2;
            }
            C1518g.m7654a(this.f5040b).m7661a(c1153aArr[0]);
            this.f5046h = 2;
            m7566j();
        }
    }

    private void m7560d() {
        C1104b.m6366b((Object) this, "start");
        if (!m7567k()) {
            try {
                m7561e();
                this.f5047i = 2;
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
                m7562f();
            }
        }
    }

    private void m7561e() {
        C1104b.m6366b((Object) this, "callWebservice");
        if (!m7567k()) {
            au c = C1548c.m7822a(this.f5040b).m7834c();
            long b = c.m6658b();
            String str = "Android_" + Secure.getString(this.f5040b.getContentResolver(), "android_id");
            Iterator it = c.m6657a().iterator();
            while (it.hasNext()) {
                aq aqVar = (aq) it.next();
                switch (C1500f.f5055a[aqVar.m6650a().ordinal()]) {
                    case VideoSize.CIF /*1*/:
                        for (at atVar : aqVar.m6655f()) {
                            if (atVar.equals(at.TCP)) {
                                this.f5048j.add(new C1493c(aqVar.m6656g(), aqVar.m6653d(), aqVar.m6652c(), aqVar.m6651b(), aqVar.m6654e(), C1492b.TCP, b, str));
                            } else if (atVar.equals(at.TLS)) {
                                this.f5048j.add(new C1493c(aqVar.m6656g(), aqVar.m6653d(), aqVar.m6652c(), aqVar.m6651b(), aqVar.m6654e(), C1492b.TLS, b, str));
                            } else {
                                this.f5048j.add(new C1493c(aqVar.m6656g(), aqVar.m6653d(), aqVar.m6652c(), aqVar.m6651b(), aqVar.m6654e(), C1492b.UDP, b, str));
                            }
                        }
                        break;
                    case VideoSize.HVGA /*2*/:
                        for (at atVar2 : aqVar.m6655f()) {
                            Object c1528a = atVar2.equals(at.TCP) ? new C1528a(aqVar.m6652c(), aqVar.m6654e(), aqVar.m6656g(), aqVar.m6653d(), C1529b.TCP, 3600, true) : atVar2.equals(at.TLS) ? new C1528a(aqVar.m6652c(), aqVar.m6654e(), aqVar.m6656g(), aqVar.m6653d(), C1529b.TLS, 3600, true) : new C1528a(aqVar.m6652c(), aqVar.m6654e(), aqVar.m6656g(), aqVar.m6653d(), C1529b.UDP, 3600, true);
                            this.f5049k.add(c1528a);
                        }
                        break;
                    default:
                        break;
                }
            }
            m7563g();
            m7558a(false);
        }
    }

    private void m7562f() {
        C1104b.m6366b((Object) this, "callWebserviceTimer");
        if (!m7567k()) {
            this.f5044f = new Timer();
            if (this.f5047i < 16) {
                this.f5047i *= 2;
            }
            this.f5044f.schedule(new C1497c(this), (long) (this.f5047i * 1000));
        }
    }

    private void m7563g() {
        C1104b.m6366b((Object) this, "callVOIP");
        if (!m7567k()) {
            for (C1528a c1528a : this.f5049k) {
                if (!this.f5049k.isEmpty()) {
                    switch (C1500f.f5056b[c1528a.m7700e().ordinal()]) {
                        case VideoSize.CIF /*1*/:
                        case VideoSize.HVGA /*2*/:
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            C1534g.m7722a(this.f5040b).m7736a(c1528a.m7696a(), c1528a.m7699d(), c1528a.m7697b(), c1528a.m7698c(), 0, c1528a.m7701f(), false);
                            C1534g.m7722a(this.f5040b).m7743d();
                            return;
                        default:
                            break;
                    }
                }
            }
        }
    }

    private void m7564h() {
        C1104b.m6366b((Object) this, "callXMPPTimer");
        if (!m7567k()) {
            this.f5043e = new Timer();
            if (this.f5046h < 16) {
                this.f5046h *= 2;
            }
            this.f5043e.schedule(new C1498d(this), (long) (this.f5046h * 1000));
        }
    }

    private void m7565i() {
        C1104b.m6366b((Object) this, "callXMPPCheckDisconnect");
        if (!m7567k()) {
            this.f5050l = !this.f5050l;
            if (!C1518g.m7654a(this.f5040b).m7663b().m7505a(true, this.f5050l) && C1518g.m7654a(this.f5040b).m7663b().m7505a(false, false)) {
                m7568l();
                m7558a(true);
            } else if (C1518g.m7654a(this.f5040b).m7663b().m7505a(false, false) || C1518g.m7654a(this.f5040b).m7663b().m7504a()) {
                m7566j();
            } else {
                m7568l();
                m7558a(true);
            }
        }
    }

    private void m7566j() {
        C1104b.m6366b((Object) this, "callXMPPCheckDisconnectTimer");
        if (!m7567k()) {
            this.f5045g = new Timer();
            this.f5045g.schedule(new C1499e(this), 60000);
        }
    }

    private boolean m7567k() {
        C1104b.m6366b((Object) this, "checkNetwork");
        if (C1107a.m6377b(this.f5040b)) {
            return false;
        }
        if (this.f5045g != null) {
            this.f5045g.cancel();
            this.f5045g = null;
        }
        if (this.f5043e != null) {
            this.f5043e.cancel();
            this.f5043e = null;
        }
        if (this.f5044f != null) {
            this.f5044f.cancel();
            this.f5044f = null;
        }
        m7568l();
        this.f5046h = 1;
        this.f5047i = 1;
        this.f5041c = false;
        return true;
    }

    private void m7568l() {
        C1104b.m6366b((Object) this, "killXMPPConnections");
        C1518g.m7654a(this.f5040b).m7655a();
    }

    public synchronized void m7569a() {
        C1104b.m6366b((Object) this, "runIfNotRun");
        if (this.f5041c) {
            m7572c();
        } else {
            this.f5041c = true;
            new Thread(new C1496b(this)).start();
        }
    }

    public void m7570a(C1165j c1165j) {
        C1104b.m6366b((Object) this, "ChatConnectionStateChanged " + c1165j);
        if (c1165j.equals(C1165j.DISCONNECTED_ON_ERROR)) {
            m7572c();
        }
    }

    public synchronized void m7571b() {
        C1104b.m6366b((Object) this, "killAll");
        C1518g.m7654a(this.f5040b).m7655a();
        C1534g.m7722a(this.f5040b).m7742c();
        C1534g.m7722a(this.f5040b).m7740b();
        C1534g.m7722a(this.f5040b).m7735a();
        if (this.f5045g != null) {
            this.f5045g.cancel();
            this.f5045g = null;
        }
        if (this.f5043e != null) {
            this.f5043e.cancel();
            this.f5043e = null;
        }
        if (this.f5044f != null) {
            this.f5044f.cancel();
            this.f5044f = null;
        }
        this.f5046h = 1;
        this.f5047i = 1;
        this.f5041c = false;
    }

    public void m7572c() {
        C1104b.m6366b((Object) this, "resetTimers");
        this.f5046h = 1;
        this.f5047i = 1;
    }
}
