package com.p032a.p033a.p037d.p046c;

import android.util.Log;
import com.p032a.p033a.p037d.C0676b;
import com.p032a.p033a.p042j.C0873a;
import java.io.InputStream;
import java.io.OutputStream;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: com.a.a.d.c.v */
public class C0725v implements C0676b<InputStream> {
    public String m4786a() {
        return BuildConfig.FLAVOR;
    }

    public boolean m4787a(InputStream inputStream, OutputStream outputStream) {
        byte[] b = C0873a.m5286a().m5288b();
        while (true) {
            try {
                int read = inputStream.read(b);
                if (read != -1) {
                    outputStream.write(b, 0, read);
                } else {
                    C0873a.m5286a().m5287a(b);
                    return true;
                }
            } catch (Throwable e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                C0873a.m5286a().m5287a(b);
                return false;
            } catch (Throwable th) {
                C0873a.m5286a().m5287a(b);
            }
        }
    }
}
