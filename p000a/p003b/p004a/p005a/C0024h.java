package p000a.p003b.p004a.p005a;

import java.io.DataInputStream;
import p000a.p003b.p004a.p006b.C0027a;

/* renamed from: a.b.a.a.h */
public class C0024h implements C0017d {
    protected int f77a;
    protected int f78b;
    protected int f79c;
    protected String f80d;

    public int m32a() {
        return this.f77a;
    }

    public void m33a(DataInputStream dataInputStream, byte[] bArr, int i) {
        this.f77a = dataInputStream.readUnsignedShort();
        this.f78b = dataInputStream.readUnsignedShort();
        this.f79c = dataInputStream.readUnsignedShort();
        this.f80d = C0027a.m47a(dataInputStream, bArr);
    }

    public int m34b() {
        return this.f78b;
    }

    public int m35c() {
        return this.f79c;
    }

    public String m36d() {
        return this.f80d;
    }

    public String toString() {
        return "SRV " + this.f80d + ":" + this.f79c + " p:" + this.f77a + " w:" + this.f78b;
    }
}
