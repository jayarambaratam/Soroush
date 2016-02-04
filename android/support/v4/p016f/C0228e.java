package android.support.v4.p016f;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.f.e */
public class C0228e extends Writer {
    private final String f1140a;
    private StringBuilder f1141b;

    public C0228e(String str) {
        this.f1141b = new StringBuilder(128);
        this.f1140a = str;
    }

    private void m1706a() {
        if (this.f1141b.length() > 0) {
            Log.d(this.f1140a, this.f1141b.toString());
            this.f1141b.delete(0, this.f1141b.length());
        }
    }

    public void close() {
        m1706a();
    }

    public void flush() {
        m1706a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1706a();
            } else {
                this.f1141b.append(c);
            }
        }
    }
}
