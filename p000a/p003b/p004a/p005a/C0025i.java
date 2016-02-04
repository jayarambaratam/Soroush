package p000a.p003b.p004a.p005a;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: a.b.a.a.i */
public class C0025i implements C0017d {
    protected byte[] f81a;

    public String m37a() {
        List b = m39b();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < b.size() - 1) {
            stringBuilder.append(new String((byte[]) b.get(i))).append(" / ");
            i++;
        }
        stringBuilder.append(new String((byte[]) b.get(i)));
        return stringBuilder.toString();
    }

    public void m38a(DataInputStream dataInputStream, byte[] bArr, int i) {
        this.f81a = new byte[i];
        dataInputStream.readFully(this.f81a);
    }

    public List<byte[]> m39b() {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < this.f81a.length) {
            int i2 = this.f81a[i] & 255;
            i++;
            arrayList.add(Arrays.copyOfRange(this.f81a, i, i + i2));
            i += i2;
        }
        return arrayList;
    }

    public String toString() {
        return "\"" + m37a() + "\"";
    }
}
