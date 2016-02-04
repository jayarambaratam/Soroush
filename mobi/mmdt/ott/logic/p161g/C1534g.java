package mobi.mmdt.ott.logic.p161g;

import android.content.Context;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p086a.p087a.C1130b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.logic.g.g */
public class C1534g {
    private static C1534g f5155a;
    private ArrayList<C1531e> f5156b;
    private C1130b f5157c;
    private boolean f5158d;
    private String f5159e;
    private String f5160f;
    private boolean f5161g;
    private int f5162h;
    private int f5163i;
    private int f5164j;
    private String f5165k;
    private boolean f5166l;
    private boolean f5167m;
    private boolean f5168n;
    private boolean f5169o;
    private LinphoneCall f5170p;
    private Context f5171q;

    static {
        f5155a = null;
    }

    private C1534g(Context context) {
        this.f5156b = new ArrayList();
        this.f5158d = false;
        this.f5159e = BuildConfig.FLAVOR;
        this.f5160f = BuildConfig.FLAVOR;
        this.f5161g = false;
        this.f5162h = -1;
        this.f5163i = 5060;
        this.f5165k = BuildConfig.FLAVOR;
        this.f5166l = false;
        this.f5167m = false;
        this.f5168n = false;
        this.f5169o = false;
        this.f5171q = context;
        this.f5157c = C1130b.m6468a(this.f5171q, new C1535h(this));
    }

    private C1533f m7721a(State state) {
        return state.equals(State.CallEnd) ? C1533f.f5146n : state.equals(State.CallIncomingEarlyMedia) ? C1533f.f5149q : state.equals(State.CallReleased) ? C1533f.f5151s : state.equals(State.CallUpdatedByRemote) ? C1533f.f5148p : state.equals(State.CallUpdating) ? C1533f.f5150r : state.equals(State.Connected) ? C1533f.f5139g : state.equals(State.Error) ? C1533f.f5145m : state.equals(State.Idle) ? C1533f.f5133a : state.equals(State.IncomingReceived) ? C1533f.f5134b : state.equals(State.OutgoingEarlyMedia) ? C1533f.f5138f : state.equals(State.OutgoingInit) ? C1533f.f5135c : state.equals(State.OutgoingProgress) ? C1533f.f5136d : state.equals(State.OutgoingRinging) ? C1533f.f5137e : state.equals(State.Paused) ? C1533f.f5142j : state.equals(State.PausedByRemote) ? C1533f.f5147o : state.equals(State.Pausing) ? C1533f.f5141i : state.equals(State.Refered) ? C1533f.f5144l : state.equals(State.Resuming) ? C1533f.f5143k : state.equals(State.StreamsRunning) ? C1533f.f5140h : null;
    }

    public static C1534g m7722a(Context context) {
        if (f5155a == null) {
            f5155a = new C1534g(context);
        }
        return f5155a;
    }

    private void m7733j() {
        int i = 2;
        if (this.f5166l) {
            try {
                switch (this.f5164j) {
                    case VideoSize.CIF /*1*/:
                        i = 0;
                        break;
                    case VideoSize.HVGA /*2*/:
                        i = 1;
                        break;
                }
                this.f5157c.m6474a(this.f5165k, this.f5163i, this.f5159e, this.f5160f, this.f5162h, i, this.f5161g);
                return;
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
                return;
            }
        }
        this.f5158d = true;
    }

    private void m7734k() {
        if (this.f5166l) {
            try {
                this.f5157c.m6481d();
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
    }

    public void m7735a() {
        if (this.f5166l) {
            try {
                this.f5157c.m6482e();
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
    }

    public void m7736a(String str, int i, String str2, String str3, int i2, int i3, boolean z) {
        if (!this.f5165k.equals(str) || i != this.f5163i || !str2.equals(this.f5159e) || !str3.equals(this.f5160f) || i2 != this.f5164j) {
            this.f5165k = str;
            this.f5163i = i;
            this.f5159e = str2;
            this.f5160f = str3;
            this.f5164j = i2;
            this.f5161g = z;
            this.f5162h = i3;
            m7733j();
            m7734k();
        }
    }

    public void m7737a(String str, String str2) {
        if (this.f5166l) {
            this.f5157c.m6475a(str, str2);
        }
    }

    public void m7738a(C1531e c1531e) {
        this.f5156b.add(c1531e);
    }

    public void m7739a(boolean z) {
        this.f5169o = z;
        if (this.f5166l) {
            this.f5157c.m6477a(z);
        }
    }

    public void m7740b() {
        if (this.f5166l) {
            try {
                this.f5157c.m6483f();
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
    }

    public void m7741b(boolean z) {
        if (this.f5166l) {
            this.f5157c.m6479b(z);
        }
    }

    public synchronized void m7742c() {
        try {
            this.f5157c.m6487j();
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        this.f5166l = false;
    }

    public void m7743d() {
        if (this.f5166l) {
            this.f5157c.m6480c();
        }
    }

    public void m7744e() {
        if (this.f5166l) {
            this.f5157c.m6478b();
        }
    }

    public boolean m7745f() {
        if (this.f5166l) {
            try {
                return this.f5157c.m6484g();
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
        return false;
    }

    public String m7746g() {
        if (this.f5157c.m6486i() != null) {
            this.f5170p = this.f5157c.m6486i();
        }
        LinphoneAddress remoteAddress = this.f5170p.getRemoteAddress();
        return remoteAddress.getUserName() != null ? remoteAddress.getUserName() : remoteAddress.getDisplayName() != null ? remoteAddress.getDisplayName() : null;
    }

    public C1533f m7747h() {
        if (this.f5157c.m6486i() != null) {
            this.f5170p = this.f5157c.m6486i();
        }
        return this.f5170p != null ? m7721a(this.f5170p.getState()) : null;
    }

    public void m7748i() {
        if (this.f5166l) {
            this.f5157c.m6485h();
        }
    }
}
