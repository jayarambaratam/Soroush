package mobi.mmdt.ott.logic.p162h;

import android.support.v7.widget.RecyclerView.ItemAnimator;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.logic.h.f */
public class C1541f {
    private static String f5194a;

    static {
        f5194a = C1541f.class.getSimpleName();
    }

    public static void m7781a(InputStream inputStream, File file) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            String str = file.getAbsolutePath() + "/";
            byte[] bArr = new byte[ItemAnimator.FLAG_APPEARED_IN_PRE_LAYOUT];
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    C1104b.m6369c(f5194a, "COMPLETED in " + ((System.currentTimeMillis() - currentTimeMillis) / 1000) + " seconds.");
                    return;
                } else if (nextEntry.isDirectory()) {
                    File file2 = new File(str, nextEntry.getName());
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    C1104b.m6369c(f5194a, "[DIR] " + nextEntry.getName());
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(str + nextEntry.getName());
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.close();
                    C1104b.m6369c(f5194a, "[FILE] " + nextEntry.getName());
                }
            }
        } catch (Exception e) {
            C1104b.m6362a(f5194a, "FAILED");
        }
    }
}
