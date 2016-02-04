package com.p032a.p033a.p037d.p049d.p050a;

/* renamed from: com.a.a.d.d.a.h */
final class C0735h extends C0733f {
    C0735h() {
    }

    protected int m4822a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
        int max = Math.max(1, Integer.highestOneBit(ceil));
        if (max >= ceil) {
            i5 = 0;
        }
        return max << i5;
    }

    public String m4823a() {
        return "AT_MOST.com.bumptech.glide.load.data.bitmap";
    }
}
