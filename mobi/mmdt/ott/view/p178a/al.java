package mobi.mmdt.ott.view.p178a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* renamed from: mobi.mmdt.ott.view.a.al */
public class al {
    public static boolean m8477a(String str, byte[] bArr) {
        boolean z = true;
        File file = new File(str);
        if (!file.exists()) {
            z = file.createNewFile();
        }
        if (z) {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byte[] bArr2 = new byte[10240];
            while (true) {
                int read = byteArrayInputStream.read(bArr2);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr2, 0, read);
            }
            fileOutputStream.close();
        }
        return z;
    }

    public static byte[] m8478a(Bitmap bitmap) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }
}
