package p000a.p003b.p004a.p005a;

import java.io.DataInputStream;

/* renamed from: a.b.a.a.b */
public class C0019b implements C0017d {
    private byte[] f73a;

    public void m29a(DataInputStream dataInputStream, byte[] bArr, int i) {
        this.f73a = new byte[16];
        dataInputStream.readFully(this.f73a);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f73a.length; i += 2) {
            if (i != 0) {
                stringBuilder.append(':');
            }
            stringBuilder.append(Integer.toHexString(((this.f73a[i] & 255) << 8) + (this.f73a[i + 1] & 255)));
        }
        return stringBuilder.toString();
    }
}
