package mobi.mmdt.ott.logic.p161g;

import java.util.Vector;

/* renamed from: mobi.mmdt.ott.logic.g.f */
public class C1533f {
    public static final C1533f f5133a;
    public static final C1533f f5134b;
    public static final C1533f f5135c;
    public static final C1533f f5136d;
    public static final C1533f f5137e;
    public static final C1533f f5138f;
    public static final C1533f f5139g;
    public static final C1533f f5140h;
    public static final C1533f f5141i;
    public static final C1533f f5142j;
    public static final C1533f f5143k;
    public static final C1533f f5144l;
    public static final C1533f f5145m;
    public static final C1533f f5146n;
    public static final C1533f f5147o;
    public static final C1533f f5148p;
    public static final C1533f f5149q;
    public static final C1533f f5150r;
    public static final C1533f f5151s;
    private Vector<C1533f> f5152t;
    private final int f5153u;
    private final String f5154v;

    static {
        f5133a = new C1533f(0, "Idle");
        f5134b = new C1533f(1, "IncomingReceived");
        f5135c = new C1533f(2, "OutgoingInit");
        f5136d = new C1533f(3, "OutgoingProgress");
        f5137e = new C1533f(4, "OutgoingRinging");
        f5138f = new C1533f(5, "OutgoingEarlyMedia");
        f5139g = new C1533f(6, "Connected");
        f5140h = new C1533f(7, "StreamsRunning");
        f5141i = new C1533f(8, "Pausing");
        f5142j = new C1533f(9, "Paused");
        f5143k = new C1533f(10, "Resuming");
        f5144l = new C1533f(11, "Refered");
        f5145m = new C1533f(12, "Error");
        f5146n = new C1533f(13, "CallEnd");
        f5147o = new C1533f(14, "PausedByRemote");
        f5148p = new C1533f(15, "UpdatedByRemote");
        f5149q = new C1533f(16, "IncomingEarlyMedia");
        f5150r = new C1533f(17, "Updating");
        f5151s = new C1533f(18, "Released");
    }

    private C1533f(int i, String str) {
        this.f5152t = new Vector();
        this.f5153u = i;
        this.f5152t.addElement(this);
        this.f5154v = str;
    }

    public String toString() {
        return this.f5154v;
    }
}
