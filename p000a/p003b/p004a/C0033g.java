package p000a.p003b.p004a;

import java.io.DataInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.linphone.core.Privacy;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p003b.p004a.p005a.C0017d;
import p000a.p003b.p004a.p005a.C0018a;
import p000a.p003b.p004a.p005a.C0019b;
import p000a.p003b.p004a.p005a.C0020c;
import p000a.p003b.p004a.p005a.C0021e;
import p000a.p003b.p004a.p005a.C0022f;
import p000a.p003b.p004a.p005a.C0023g;
import p000a.p003b.p004a.p005a.C0024h;
import p000a.p003b.p004a.p005a.C0025i;
import p000a.p003b.p004a.p006b.C0027a;

/* renamed from: a.b.a.g */
public class C0033g {
    private static final Logger f129g;
    protected String f130a;
    protected C0036j f131b;
    protected C0035i f132c;
    protected long f133d;
    protected C0017d f134e;
    protected boolean f135f;

    static {
        f129g = Logger.getLogger(C0026a.class.getName());
    }

    public C0017d m67a() {
        return this.f134e;
    }

    public void m68a(DataInputStream dataInputStream, byte[] bArr) {
        int i = 0;
        this.f130a = C0027a.m47a(dataInputStream, bArr);
        this.f131b = C0036j.m73a(dataInputStream.readUnsignedShort());
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        this.f132c = C0035i.m71a(readUnsignedShort & 32767);
        this.f135f = (Privacy.DEFAULT & readUnsignedShort) > 0;
        if (this.f132c == null) {
            f129g.log(Level.FINE, "Unknown class " + readUnsignedShort);
        }
        this.f133d = (((long) dataInputStream.readUnsignedShort()) << 32) + ((long) dataInputStream.readUnsignedShort());
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        switch (C0034h.f136a[this.f131b.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f134e = new C0024h();
                break;
            case VideoSize.HVGA /*2*/:
                this.f134e = new C0021e();
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f134e = new C0019b();
                break;
            case Version.API04_DONUT_16 /*4*/:
                this.f134e = new C0018a();
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                this.f134e = new C0022f();
                break;
            case Version.API06_ECLAIR_201 /*6*/:
                this.f134e = new C0020c();
                break;
            case Version.API07_ECLAIR_21 /*7*/:
                this.f134e = new C0023g();
                break;
            case Version.API08_FROYO_22 /*8*/:
                this.f134e = new C0025i();
                break;
            default:
                f129g.log(Level.FINE, "Unparsed type " + this.f131b);
                this.f134e = null;
                while (i < readUnsignedShort2) {
                    dataInputStream.readByte();
                    i++;
                }
                break;
        }
        if (this.f134e != null) {
            this.f134e.m27a(dataInputStream, bArr, readUnsignedShort2);
        }
    }

    public boolean m69a(C0032f c0032f) {
        return (c0032f.m63a() == this.f131b || c0032f.m63a() == C0036j.ANY) && ((c0032f.m64b() == this.f132c || c0032f.m64b() == C0035i.ANY) && c0032f.m65c().equals(this.f130a));
    }

    public long m70b() {
        return this.f133d;
    }

    public String toString() {
        return this.f134e == null ? "RR " + this.f131b + "/" + this.f132c : "RR " + this.f131b + "/" + this.f132c + ": " + this.f134e.toString();
    }
}
