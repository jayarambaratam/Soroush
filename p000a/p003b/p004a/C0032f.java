package p000a.p003b.p004a;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.linphone.core.Privacy;
import p000a.p003b.p004a.p006b.C0027a;

/* renamed from: a.b.a.f */
public class C0032f {
    private final String f124a;
    private final C0036j f125b;
    private final C0035i f126c;
    private final boolean f127d;
    private byte[] f128e;

    public C0032f(String str, C0036j c0036j, C0035i c0035i) {
        this(str, c0036j, c0035i, false);
    }

    public C0032f(String str, C0036j c0036j, C0035i c0035i, boolean z) {
        this.f124a = str;
        this.f125b = c0036j;
        this.f126c = c0035i;
        this.f127d = z;
    }

    public static C0032f m62a(DataInputStream dataInputStream, byte[] bArr) {
        return new C0032f(C0027a.m47a(dataInputStream, bArr), C0036j.m73a(dataInputStream.readUnsignedShort()), C0035i.m71a(dataInputStream.readUnsignedShort()));
    }

    public C0036j m63a() {
        return this.f125b;
    }

    public C0035i m64b() {
        return this.f126c;
    }

    public String m65c() {
        return this.f124a;
    }

    public byte[] m66d() {
        if (this.f128e == null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.write(C0027a.m49a(this.f124a));
                dataOutputStream.writeShort(this.f125b.m74a());
                dataOutputStream.writeShort((this.f127d ? Privacy.DEFAULT : 0) | this.f126c.m72a());
                dataOutputStream.flush();
                this.f128e = byteArrayOutputStream.toByteArray();
            } catch (Throwable e) {
                throw new IllegalStateException(e);
            }
        }
        return this.f128e;
    }

    public boolean equals(Object obj) {
        return this == obj ? true : !(obj instanceof C0032f) ? false : Arrays.equals(m66d(), ((C0032f) obj).m66d());
    }

    public int hashCode() {
        return Arrays.hashCode(m66d());
    }

    public String toString() {
        return "Question/" + this.f126c + "/" + this.f125b + ": " + this.f124a;
    }
}
