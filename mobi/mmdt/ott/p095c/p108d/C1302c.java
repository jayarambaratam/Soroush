package mobi.mmdt.ott.p095c.p108d;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.util.StringUtils;

/* renamed from: mobi.mmdt.ott.c.d.c */
public class C1302c {
    public static String m6874a(String str) {
        byte[] digest = MessageDigest.getInstance("SHA1").digest(str.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    private static String m6875a(byte[] bArr) {
        String str = BuildConfig.FLAVOR;
        for (byte b : bArr) {
            str = str + Integer.toString((b & 255) + 256, 16).substring(1);
        }
        return str;
    }

    public static String m6876b(String str) {
        MessageDigest instance = MessageDigest.getInstance("SHA1");
        InputStream fileInputStream = new FileInputStream(str);
        byte[] bArr = new byte[8192];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read < 0) {
                fileInputStream.close();
                return C1302c.m6875a(instance.digest());
            }
            instance.update(bArr, 0, read);
        }
    }

    public static String m6877c(String str) {
        byte[] digest = MessageDigest.getInstance("SHA-256").digest(str.getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(Integer.toString((b & 255) + 256, 16).substring(1));
        }
        return stringBuilder.toString();
    }

    public static String m6878d(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(StringUtils.MD5);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : digest) {
                String toHexString = Integer.toHexString(b & 255);
                while (toHexString.length() < 2) {
                    toHexString = "0" + toHexString;
                }
                stringBuilder.append(toHexString);
            }
            return stringBuilder.toString();
        } catch (Throwable e) {
            C1104b.m6363a(C1302c.class, e.getMessage(), e);
            return BuildConfig.FLAVOR;
        }
    }
}
