package com.p065c.p066a.p067a.p075h.p076a;

import com.p065c.p066a.p067a.C0944a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/* renamed from: com.c.a.a.h.a.j */
public class C0987j implements C0986k {
    public <T extends C0944a> T m6030a(byte[] bArr) {
        ObjectInputStream objectInputStream;
        Throwable th;
        T t = null;
        if (!(bArr == null || bArr.length == 0)) {
            try {
                objectInputStream = new ObjectInputStream(new ByteArrayInputStream(bArr));
                try {
                    C0944a c0944a = (C0944a) objectInputStream.readObject();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                objectInputStream = null;
                th = th4;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                throw th;
            }
        }
        return t;
    }

    public byte[] m6031a(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        byte[] bArr = null;
        if (obj != null) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                    bArr = byteArrayOutputStream.toByteArray();
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                byteArrayOutputStream = null;
                th = th4;
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        }
        return bArr;
    }
}
