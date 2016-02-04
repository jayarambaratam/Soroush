package mobi.mmdt.componentsutils.p079a.p082c;

import java.util.Random;

/* renamed from: mobi.mmdt.componentsutils.a.c.a */
public class C1110a {
    private static final char[] f4148a;

    static {
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        for (c = '0'; c <= '9'; c = (char) (c + 1)) {
            stringBuilder.append(c);
        }
        for (c = 'a'; c <= 'z'; c = (char) (c + 1)) {
            stringBuilder.append(c);
        }
        for (c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            stringBuilder.append(c);
        }
        f4148a = stringBuilder.toString().toCharArray();
    }

    public static String m6387a(int i) {
        Random random = new Random();
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = f4148a[random.nextInt(f4148a.length)];
        }
        return new String(cArr);
    }
}
