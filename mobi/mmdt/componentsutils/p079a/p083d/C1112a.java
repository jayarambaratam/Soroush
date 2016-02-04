package mobi.mmdt.componentsutils.p079a.p083d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.ThumbnailUtils;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* renamed from: mobi.mmdt.componentsutils.a.d.a */
public class C1112a {
    public static synchronized Bitmap m6418a(String str) {
        Bitmap extractThumbnail;
        synchronized (C1112a.class) {
            extractThumbnail = ThumbnailUtils.extractThumbnail(ThumbnailUtils.createVideoThumbnail(str, 1), 256, 256);
        }
        return extractThumbnail;
    }

    public static void m6419a(Bitmap bitmap, String str) {
        OutputStream fileOutputStream = new FileOutputStream(str);
        bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
        fileOutputStream.close();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.graphics.Bitmap m6420b(java.lang.String r8) {
        /*
        r7 = mobi.mmdt.componentsutils.p079a.p083d.C1112a.class;
        monitor-enter(r7);
        r0 = new android.media.ExifInterface;	 Catch:{ all -> 0x004b }
        r0.<init>(r8);	 Catch:{ all -> 0x004b }
        r1 = "Orientation";
        r2 = 1;
        r0 = r0.getAttributeInt(r1, r2);	 Catch:{ all -> 0x004b }
        r5 = new android.graphics.Matrix;	 Catch:{ all -> 0x004b }
        r5.<init>();	 Catch:{ all -> 0x004b }
        switch(r0) {
            case 3: goto L_0x004e;
            case 4: goto L_0x0017;
            case 5: goto L_0x0017;
            case 6: goto L_0x0045;
            case 7: goto L_0x0017;
            case 8: goto L_0x0054;
            default: goto L_0x0017;
        };	 Catch:{ all -> 0x004b }
    L_0x0017:
        r0 = new android.graphics.BitmapFactory$Options;	 Catch:{ all -> 0x004b }
        r0.<init>();	 Catch:{ all -> 0x004b }
        r1 = 24576; // 0x6000 float:3.4438E-41 double:1.2142E-319;
        r1 = new byte[r1];	 Catch:{ all -> 0x004b }
        r0.inTempStorage = r1;	 Catch:{ all -> 0x004b }
        r1 = 0;
        r0.inJustDecodeBounds = r1;	 Catch:{ all -> 0x004b }
        r1 = 2;
        r0.inSampleSize = r1;	 Catch:{ all -> 0x004b }
        r0 = android.graphics.BitmapFactory.decodeFile(r8, r0);	 Catch:{ all -> 0x004b }
        r1 = 0;
        r2 = 0;
        r3 = r0.getWidth();	 Catch:{ all -> 0x004b }
        r4 = r0.getHeight();	 Catch:{ all -> 0x004b }
        r6 = 1;
        r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2, r3, r4, r5, r6);	 Catch:{ all -> 0x004b }
        r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r0 = android.media.ThumbnailUtils.extractThumbnail(r0, r1, r2);	 Catch:{ all -> 0x004b }
        monitor-exit(r7);
        return r0;
    L_0x0045:
        r0 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r5.postRotate(r0);	 Catch:{ all -> 0x004b }
        goto L_0x0017;
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x004e:
        r0 = 1127481344; // 0x43340000 float:180.0 double:5.570497984E-315;
        r5.postRotate(r0);	 Catch:{ all -> 0x004b }
        goto L_0x0017;
    L_0x0054:
        r0 = 1132920832; // 0x43870000 float:270.0 double:5.597372625E-315;
        r5.postRotate(r0);	 Catch:{ all -> 0x004b }
        goto L_0x0017;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.componentsutils.a.d.a.b(java.lang.String):android.graphics.Bitmap");
    }
}
