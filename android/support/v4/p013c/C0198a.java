package android.support.v4.p013c;

import android.graphics.Color;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: android.support.v4.c.a */
public class C0198a {
    public static double m1615a(int i) {
        double red = ((double) Color.red(i)) / 255.0d;
        double green = ((double) Color.green(i)) / 255.0d;
        double blue = ((double) Color.blue(i)) / 255.0d;
        return (((red < 0.03928d ? red / 12.92d : Math.pow((red + 0.055d) / 1.055d, 2.4d)) * 0.2126d) + ((green < 0.03928d ? green / 12.92d : Math.pow((green + 0.055d) / 1.055d, 2.4d)) * 0.7152d)) + (0.0722d * (blue < 0.03928d ? blue / 12.92d : Math.pow((blue + 0.055d) / 1.055d, 2.4d)));
    }

    private static float m1616a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int m1617a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int d = C0198a.m1626d(alpha2, alpha);
        return Color.argb(d, C0198a.m1620a(Color.red(i), alpha2, Color.red(i2), alpha, d), C0198a.m1620a(Color.green(i), alpha2, Color.green(i2), alpha, d), C0198a.m1620a(Color.blue(i), alpha2, Color.blue(i2), alpha, d));
    }

    public static int m1618a(int i, int i2, float f) {
        int i3 = 0;
        int i4 = 255;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        } else if (C0198a.m1624b(C0198a.m1625c(i, 255), i2) < ((double) f)) {
            return -1;
        } else {
            int i5 = 0;
            while (i5 <= 10 && i4 - i3 > 1) {
                int i6 = (i3 + i4) / 2;
                if (C0198a.m1624b(C0198a.m1625c(i, i6), i2) >= ((double) f)) {
                    i4 = i6;
                    i6 = i3;
                }
                i5++;
                i3 = i6;
            }
            return i4;
        }
    }

    private static int m1619a(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    private static int m1620a(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? 0 : (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int m1621a(float[] fArr) {
        int round;
        int round2;
        int round3;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float abs = (1.0f - Math.abs((2.0f * f3) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = abs * (1.0f - Math.abs(((f / 60.0f) % 2.0f) - 1.0f));
        switch (((int) f) / 60) {
            case VideoSize.QCIF /*0*/:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round(255.0f * f4);
                break;
            case VideoSize.CIF /*1*/:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round(255.0f * f4);
                break;
            case VideoSize.HVGA /*2*/:
                round = Math.round(255.0f * f4);
                round2 = Math.round((abs + f4) * 255.0f);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                round = Math.round(255.0f * f4);
                round2 = Math.round((abs2 + f4) * 255.0f);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case Version.API04_DONUT_16 /*4*/:
                round = Math.round((abs2 + f4) * 255.0f);
                round2 = Math.round(255.0f * f4);
                round3 = Math.round((abs + f4) * 255.0f);
                break;
            case Version.API05_ECLAIR_20 /*5*/:
            case Version.API06_ECLAIR_201 /*6*/:
                round = Math.round((abs + f4) * 255.0f);
                round2 = Math.round(255.0f * f4);
                round3 = Math.round((abs2 + f4) * 255.0f);
                break;
            default:
                round3 = 0;
                round2 = 0;
                round = 0;
                break;
        }
        return Color.rgb(C0198a.m1619a(round, 0, 255), C0198a.m1619a(round2, 0, 255), C0198a.m1619a(round3, 0, 255));
    }

    public static void m1622a(int i, int i2, int i3, float[] fArr) {
        float f = ((float) i) / 255.0f;
        float f2 = ((float) i2) / 255.0f;
        float f3 = ((float) i3) / 255.0f;
        float max = Math.max(f, Math.max(f2, f3));
        float min = Math.min(f, Math.min(f2, f3));
        float f4 = max - min;
        float f5 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            f = 0.0f;
        } else {
            f = max == f ? ((f2 - f3) / f4) % 6.0f : max == f2 ? ((f3 - f) / f4) + 2.0f : ((f - f2) / f4) + 4.0f;
            f2 = f4 / (1.0f - Math.abs((2.0f * f5) - 1.0f));
        }
        f = (f * 60.0f) % 360.0f;
        if (f < 0.0f) {
            f += 360.0f;
        }
        fArr[0] = C0198a.m1616a(f, 0.0f, 360.0f);
        fArr[1] = C0198a.m1616a(f2, 0.0f, 1.0f);
        fArr[2] = C0198a.m1616a(f5, 0.0f, 1.0f);
    }

    public static void m1623a(int i, float[] fArr) {
        C0198a.m1622a(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    public static double m1624b(int i, int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        if (Color.alpha(i) < 255) {
            i = C0198a.m1617a(i, i2);
        }
        double a = C0198a.m1615a(i) + 0.05d;
        double a2 = C0198a.m1615a(i2) + 0.05d;
        return Math.max(a, a2) / Math.min(a, a2);
    }

    public static int m1625c(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int m1626d(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }
}
