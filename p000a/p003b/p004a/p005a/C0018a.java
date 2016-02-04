package p000a.p003b.p004a.p005a;

import java.io.DataInputStream;

/* renamed from: a.b.a.a.a */
public class C0018a implements C0017d {
    private byte[] f72a;

    public void m28a(DataInputStream dataInputStream, byte[] bArr, int i) {
        this.f72a = new byte[4];
        dataInputStream.readFully(this.f72a);
    }

    public String toString() {
        return Integer.toString(this.f72a[0] & 255) + "." + Integer.toString(this.f72a[1] & 255) + "." + Integer.toString(this.f72a[2] & 255) + "." + Integer.toString(this.f72a[3] & 255);
    }
}
