package android.support.v7.p009c;

import android.graphics.Color;
import android.support.v4.p013c.C0198a;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import org.linphone.core.Privacy;

/* renamed from: android.support.v7.c.a */
final class C0407a {
    private static final Comparator<C0409c> f2006g;
    final int[] f2007a;
    final int[] f2008b;
    final List<C0418l> f2009c;
    final TimingLogger f2010d;
    final C0413i[] f2011e;
    private final float[] f2012f;

    static {
        f2006g = new C0408b();
    }

    C0407a(int[] iArr, int i, C0413i[] c0413iArr) {
        int i2;
        int f;
        int i3 = 0;
        this.f2012f = new float[3];
        this.f2010d = null;
        this.f2011e = c0413iArr;
        int[] iArr2 = new int[Privacy.DEFAULT];
        this.f2008b = iArr2;
        for (i2 = 0; i2 < iArr.length; i2++) {
            f = C0407a.m3903f(iArr[i2]);
            iArr[i2] = f;
            iArr2[f] = iArr2[f] + 1;
        }
        i2 = 0;
        f = 0;
        while (i2 < iArr2.length) {
            if (iArr2[i2] > 0 && m3902e(i2)) {
                iArr2[i2] = 0;
            }
            if (iArr2[i2] > 0) {
                f++;
            }
            i2++;
        }
        int[] iArr3 = new int[f];
        this.f2007a = iArr3;
        int i4 = 0;
        for (i2 = 0; i2 < iArr2.length; i2++) {
            if (iArr2[i2] > 0) {
                int i5 = i4 + 1;
                iArr3[i4] = i2;
                i4 = i5;
            }
        }
        if (f <= i) {
            this.f2009c = new ArrayList();
            i2 = iArr3.length;
            while (i3 < i2) {
                f = iArr3[i3];
                this.f2009c.add(new C0418l(C0407a.m3904g(f), iArr2[f]));
                i3++;
            }
            return;
        }
        this.f2009c = m3901d(i);
    }

    private List<C0418l> m3891a(Collection<C0409c> collection) {
        List arrayList = new ArrayList(collection.size());
        for (C0409c h : collection) {
            C0418l h2 = h.m3917h();
            if (!m3895a(h2)) {
                arrayList.add(h2);
            }
        }
        return arrayList;
    }

    private void m3892a(PriorityQueue<C0409c> priorityQueue, int i) {
        while (priorityQueue.size() < i) {
            C0409c c0409c = (C0409c) priorityQueue.poll();
            if (c0409c != null && c0409c.m3911b()) {
                priorityQueue.offer(c0409c.m3914e());
                priorityQueue.offer(c0409c);
            } else {
                return;
            }
        }
    }

    private boolean m3894a(int i, float[] fArr) {
        if (this.f2011e == null || this.f2011e.length <= 0) {
            return false;
        }
        for (C0413i a : this.f2011e) {
            if (!a.m3938a(i, fArr)) {
                return true;
            }
        }
        return false;
    }

    private boolean m3895a(C0418l c0418l) {
        return m3894a(c0418l.m3950a(), c0418l.m3951b());
    }

    private static int m3897b(int i, int i2, int i3) {
        return Color.rgb(C0407a.m3900c(i, 5, 8), C0407a.m3900c(i2, 5, 8), C0407a.m3900c(i3, 5, 8));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void m3898b(int[] r3, int r4, int r5, int r6) {
        /*
        switch(r4) {
            case -3: goto L_0x0003;
            case -2: goto L_0x0004;
            case -1: goto L_0x001f;
            default: goto L_0x0003;
        };
    L_0x0003:
        return;
    L_0x0004:
        if (r5 > r6) goto L_0x0003;
    L_0x0006:
        r0 = r3[r5];
        r1 = android.support.v7.p009c.C0407a.m3906i(r0);
        r1 = r1 << 10;
        r2 = android.support.v7.p009c.C0407a.m3905h(r0);
        r2 = r2 << 5;
        r1 = r1 | r2;
        r0 = android.support.v7.p009c.C0407a.m3907j(r0);
        r0 = r0 | r1;
        r3[r5] = r0;
        r5 = r5 + 1;
        goto L_0x0004;
    L_0x001f:
        if (r5 > r6) goto L_0x0003;
    L_0x0021:
        r0 = r3[r5];
        r1 = android.support.v7.p009c.C0407a.m3907j(r0);
        r1 = r1 << 10;
        r2 = android.support.v7.p009c.C0407a.m3906i(r0);
        r2 = r2 << 5;
        r1 = r1 | r2;
        r0 = android.support.v7.p009c.C0407a.m3905h(r0);
        r0 = r0 | r1;
        r3[r5] = r0;
        r5 = r5 + 1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.c.a.b(int[], int, int, int):void");
    }

    private static int m3900c(int i, int i2, int i3) {
        return (i3 > i2 ? i << (i3 - i2) : i >> (i2 - i3)) & ((1 << i3) - 1);
    }

    private List<C0418l> m3901d(int i) {
        Collection priorityQueue = new PriorityQueue(i, f2006g);
        priorityQueue.offer(new C0409c(this, 0, this.f2007a.length - 1));
        m3892a((PriorityQueue) priorityQueue, i);
        return m3891a(priorityQueue);
    }

    private boolean m3902e(int i) {
        int g = C0407a.m3904g(i);
        C0198a.m1623a(g, this.f2012f);
        return m3894a(g, this.f2012f);
    }

    private static int m3903f(int i) {
        return ((C0407a.m3900c(Color.red(i), 8, 5) << 10) | (C0407a.m3900c(Color.green(i), 8, 5) << 5)) | C0407a.m3900c(Color.blue(i), 8, 5);
    }

    private static int m3904g(int i) {
        return C0407a.m3897b(C0407a.m3905h(i), C0407a.m3906i(i), C0407a.m3907j(i));
    }

    private static int m3905h(int i) {
        return (i >> 10) & 31;
    }

    private static int m3906i(int i) {
        return (i >> 5) & 31;
    }

    private static int m3907j(int i) {
        return i & 31;
    }

    List<C0418l> m3908a() {
        return this.f2009c;
    }
}
