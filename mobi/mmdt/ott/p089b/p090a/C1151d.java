package mobi.mmdt.ott.p089b.p090a;

import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p089b.C1165j;
import org.jivesoftware.smack.ConnectionListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smackx.ping.PingManager;

/* renamed from: mobi.mmdt.ott.b.a.d */
class C1151d implements ConnectionListener {
    final /* synthetic */ C1144a f4225a;

    C1151d(C1144a c1144a) {
        this.f4225a = c1144a;
    }

    public void authenticated(XMPPConnection xMPPConnection, boolean z) {
        if (xMPPConnection instanceof XMPPTCPConnection) {
            this.f4225a.f4201c = (XMPPTCPConnection) xMPPConnection;
            this.f4225a.f4204f.m6493a(this.f4225a.f4201c);
            this.f4225a.f4205g.m6561a(this.f4225a.f4201c);
            this.f4225a.f4206h.m6558a(this.f4225a.f4201c);
            this.f4225a.f4207i = PingManager.getInstanceFor(this.f4225a.f4201c);
        }
        if (!z) {
            this.f4225a.f4203e.m6577a(C1165j.CONNECTED);
        }
    }

    public void connected(XMPPConnection xMPPConnection) {
    }

    public void connectionClosed() {
        this.f4225a.f4203e.m6577a(C1165j.DISCONNECTED_ON_REQUEST);
    }

    public void connectionClosedOnError(Exception exception) {
        C1104b.m6368b((Object) this, (Throwable) exception);
        this.f4225a.f4203e.m6577a(C1165j.DISCONNECTED_ON_ERROR);
    }

    public void reconnectingIn(int i) {
    }

    public void reconnectionFailed(Exception exception) {
        C1104b.m6368b((Object) this, (Throwable) exception);
    }

    public void reconnectionSuccessful() {
    }
}
