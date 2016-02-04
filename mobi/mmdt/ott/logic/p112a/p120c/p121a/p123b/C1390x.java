package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import android.net.Uri;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0990j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.logic.p112a.C1396d;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.x */
public class C1390x extends C0950c {
    private Context f4773a;
    private Uri f4774b;

    public C1390x(Context context, Uri uri) {
        super(new C0990j(C1396d.f4795a));
        this.f4773a = context;
        this.f4774b = uri;
    }

    public static void m7223a(File file, File file2) {
        FileChannel channel;
        FileChannel channel2;
        Throwable th;
        FileChannel fileChannel = null;
        if (!file2.exists()) {
            file2.createNewFile();
            try {
                channel = new FileInputStream(file).getChannel();
                try {
                    channel2 = new FileOutputStream(file2).getChannel();
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    channel = null;
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    throw th;
                }
                try {
                    channel2.transferFrom(channel, 0, channel.size());
                    if (channel != null) {
                        channel.close();
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    fileChannel = channel;
                    channel = channel2;
                    th = th4;
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                    if (channel != null) {
                        channel.close();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                channel = null;
                if (fileChannel != null) {
                    fileChannel.close();
                }
                if (channel != null) {
                    channel.close();
                }
                throw th;
            }
        }
    }

    protected boolean m7224a(Throwable th) {
        return false;
    }

    public void m7225b() {
    }

    public void m7226c() {
        String b = C1490b.m7516a(this.f4773a).m7523b(new File(this.f4774b.getPath()).getName());
        C1390x.m7223a(new File(this.f4774b.getPath()), new File(b));
        C1490b.m7516a(this.f4773a).m7522a(Uri.fromFile(new File(b)));
    }

    protected void m7227d() {
    }
}
