package p000a.p003b.p004a.p005a;

import java.io.DataInputStream;
import p000a.p003b.p004a.p006b.C0027a;

/* renamed from: a.b.a.a.e */
public class C0021e implements C0017d {
    protected int f75a;
    protected String f76b;

    public void m31a(DataInputStream dataInputStream, byte[] bArr, int i) {
        this.f75a = dataInputStream.readUnsignedShort();
        this.f76b = C0027a.m47a(dataInputStream, bArr);
    }

    public String toString() {
        return "MX " + this.f76b + " p:" + this.f75a;
    }
}
