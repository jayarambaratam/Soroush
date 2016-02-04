package com.p032a.p033a.p037d.p049d.p050a;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.a.a.d.d.a.r */
class C0749r {
    private final ByteBuffer f2788a;

    public C0749r(byte[] bArr) {
        this.f2788a = ByteBuffer.wrap(bArr);
        this.f2788a.order(ByteOrder.BIG_ENDIAN);
    }

    public int m4861a() {
        return this.f2788a.array().length;
    }

    public int m4862a(int i) {
        return this.f2788a.getInt(i);
    }

    public void m4863a(ByteOrder byteOrder) {
        this.f2788a.order(byteOrder);
    }

    public short m4864b(int i) {
        return this.f2788a.getShort(i);
    }
}
