package mobi.mmdt.ott.p095c.p108d;

import android.annotation.SuppressLint;
import android.util.Base64;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.c.d.a */
public class C1300a {
    private static SecretKeySpec f4517a;
    private static String f4518b;

    public static String m6865a() {
        return f4518b;
    }

    @SuppressLint({"NewApi"})
    public static void m6866a(String str) {
        f4517a = new SecretKeySpec(Arrays.copyOf(str.getBytes(), 16), "AES");
        System.out.println(f4517a);
    }

    public static void m6867a(String str, byte[] bArr) {
        int i = 16;
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            Object obj = new byte[16];
            if (bArr.length <= 16) {
                i = bArr.length;
            }
            System.arraycopy(bArr, 0, obj, 0, i);
            instance.init(2, f4517a, new IvParameterSpec(bArr));
            C1300a.m6868b(new String(instance.doFinal(Base64.decode(str, 0)), 0));
        } catch (Throwable e) {
            C1104b.m6367b(C1300a.class, e.getMessage(), e);
        }
    }

    private static void m6868b(String str) {
        f4518b = str;
    }
}
