package p000a.p003b.p004a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager;
import org.linphone.core.Privacy;

/* renamed from: a.b.a.c */
public class C0029c {
    protected int f87a;
    protected C0030d f88b;
    protected C0031e f89c;
    protected boolean f90d;
    protected boolean f91e;
    protected boolean f92f;
    protected boolean f93g;
    protected boolean f94h;
    protected boolean f95i;
    protected boolean f96j;
    protected C0032f[] f97k;
    protected C0033g[] f98l;
    protected C0033g[] f99m;
    protected C0033g[] f100n;
    protected long f101o;

    public static C0029c m50a(byte[] bArr) {
        boolean z = true;
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        C0029c c0029c = new C0029c();
        c0029c.f87a = dataInputStream.readUnsignedShort();
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        c0029c.f90d = ((readUnsignedShort >> 15) & 1) == 0;
        c0029c.f88b = C0030d.m58a((readUnsignedShort >> 11) & 15);
        c0029c.f91e = ((readUnsignedShort >> 10) & 1) == 1;
        c0029c.f92f = ((readUnsignedShort >> 9) & 1) == 1;
        c0029c.f93g = ((readUnsignedShort >> 8) & 1) == 1;
        c0029c.f94h = ((readUnsignedShort >> 7) & 1) == 1;
        c0029c.f95i = ((readUnsignedShort >> 5) & 1) == 1;
        if (((readUnsignedShort >> 4) & 1) != 1) {
            z = false;
        }
        c0029c.f96j = z;
        c0029c.f89c = C0031e.m60a(readUnsignedShort & 15);
        c0029c.f101o = System.currentTimeMillis();
        readUnsignedShort = dataInputStream.readUnsignedShort();
        int readUnsignedShort2 = dataInputStream.readUnsignedShort();
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        int readUnsignedShort4 = dataInputStream.readUnsignedShort();
        c0029c.f97k = new C0032f[readUnsignedShort];
        while (true) {
            int i = readUnsignedShort - 1;
            if (readUnsignedShort <= 0) {
                break;
            }
            c0029c.f97k[i] = C0032f.m62a(dataInputStream, bArr);
            readUnsignedShort = i;
        }
        c0029c.f98l = new C0033g[readUnsignedShort2];
        while (true) {
            readUnsignedShort = readUnsignedShort2 - 1;
            if (readUnsignedShort2 <= 0) {
                break;
            }
            C0033g c0033g = new C0033g();
            c0033g.m68a(dataInputStream, bArr);
            c0029c.f98l[readUnsignedShort] = c0033g;
            readUnsignedShort2 = readUnsignedShort;
        }
        c0029c.f99m = new C0033g[readUnsignedShort3];
        while (true) {
            readUnsignedShort2 = readUnsignedShort3 - 1;
            if (readUnsignedShort3 <= 0) {
                break;
            }
            C0033g c0033g2 = new C0033g();
            c0033g2.m68a(dataInputStream, bArr);
            c0029c.f99m[readUnsignedShort2] = c0033g2;
            readUnsignedShort3 = readUnsignedShort2;
        }
        c0029c.f100n = new C0033g[readUnsignedShort4];
        while (true) {
            readUnsignedShort3 = readUnsignedShort4 - 1;
            if (readUnsignedShort4 <= 0) {
                return c0029c;
            }
            C0033g c0033g3 = new C0033g();
            c0033g3.m68a(dataInputStream, bArr);
            c0029c.f100n[readUnsignedShort3] = c0033g3;
            readUnsignedShort4 = readUnsignedShort3;
        }
    }

    public int m51a() {
        return this.f87a;
    }

    public void m52a(int i) {
        this.f87a = InBandBytestreamManager.MAXIMUM_BLOCK_SIZE & i;
    }

    public void m53a(boolean z) {
        this.f93g = z;
    }

    public void m54a(C0032f... c0032fArr) {
        this.f97k = c0032fArr;
    }

    public byte[] m55b() {
        int i = 0;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i2 = this.f90d ? Privacy.DEFAULT : 0;
        if (this.f88b != null) {
            i2 += this.f88b.m59a() << 11;
        }
        if (this.f91e) {
            i2 += 1024;
        }
        if (this.f92f) {
            i2 += 512;
        }
        if (this.f93g) {
            i2 += 256;
        }
        if (this.f94h) {
            i2 += 128;
        }
        if (this.f95i) {
            i2 += 32;
        }
        if (this.f96j) {
            i2 += 16;
        }
        if (this.f89c != null) {
            i2 += this.f89c.m61a();
        }
        dataOutputStream.writeShort((short) this.f87a);
        dataOutputStream.writeShort((short) i2);
        if (this.f97k == null) {
            dataOutputStream.writeShort(0);
        } else {
            dataOutputStream.writeShort((short) this.f97k.length);
        }
        if (this.f98l == null) {
            dataOutputStream.writeShort(0);
        } else {
            dataOutputStream.writeShort((short) this.f98l.length);
        }
        if (this.f99m == null) {
            dataOutputStream.writeShort(0);
        } else {
            dataOutputStream.writeShort((short) this.f99m.length);
        }
        if (this.f100n == null) {
            dataOutputStream.writeShort(0);
        } else {
            dataOutputStream.writeShort((short) this.f100n.length);
        }
        C0032f[] c0032fArr = this.f97k;
        int length = c0032fArr.length;
        while (i < length) {
            dataOutputStream.write(c0032fArr[i].m66d());
            i++;
        }
        dataOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public C0031e m56c() {
        return this.f89c;
    }

    public C0033g[] m57d() {
        return this.f98l;
    }

    public String toString() {
        return "-- DNSMessage " + this.f87a + " --\n" + "Q" + Arrays.toString(this.f97k) + "NS" + Arrays.toString(this.f99m) + "A" + Arrays.toString(this.f98l) + "ARR" + Arrays.toString(this.f100n);
    }
}
