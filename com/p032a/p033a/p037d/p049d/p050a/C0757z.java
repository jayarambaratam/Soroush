package com.p032a.p033a.p037d.p049d.p050a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: com.a.a.d.d.a.z */
public final class C0757z {
    public static int m4887a(int i) {
        switch (i) {
            case Version.API03_CUPCAKE_15 /*3*/:
            case Version.API04_DONUT_16 /*4*/:
                return 180;
            case Version.API05_ECLAIR_20 /*5*/:
            case Version.API06_ECLAIR_201 /*6*/:
                return 90;
            case Version.API07_ECLAIR_21 /*7*/:
            case Version.API08_FROYO_22 /*8*/:
                return 270;
            default:
                return 0;
        }
    }

    private static Config m4888a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    public static Bitmap m4889a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float f = 0.0f;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        float height;
        float width;
        Matrix matrix = new Matrix();
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            height = ((float) i2) / ((float) bitmap2.getHeight());
            width = (((float) i) - (((float) bitmap2.getWidth()) * height)) * 0.5f;
        } else {
            height = ((float) i) / ((float) bitmap2.getWidth());
            width = 0.0f;
            f = (((float) i2) - (((float) bitmap2.getHeight()) * height)) * 0.5f;
        }
        matrix.setScale(height, height);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (f + 0.5f)));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, C0757z.m4888a(bitmap2));
        }
        C0757z.m4893a(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap m4890a(Bitmap bitmap, C0605e c0605e, int i) {
        Matrix matrix = new Matrix();
        C0757z.m4892a(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Config a = C0757z.m4888a(bitmap);
        Bitmap a2 = c0605e.m4508a(round, round2, a);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(round, round2, a);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(a2).drawBitmap(bitmap, matrix, new Paint(6));
        return a2;
    }

    public static Bitmap m4891a(Bitmap bitmap, C0605e c0605e, int i, int i2) {
        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
            float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
            int width = (int) (((float) bitmap.getWidth()) * min);
            int height = (int) (((float) bitmap.getHeight()) * min);
            if (bitmap.getWidth() != width || bitmap.getHeight() != height) {
                Config a = C0757z.m4888a(bitmap);
                Bitmap a2 = c0605e.m4508a(width, height, a);
                if (a2 == null) {
                    a2 = Bitmap.createBitmap(width, height, a);
                }
                C0757z.m4893a(bitmap, a2);
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + i + DataForm.ELEMENT + i2);
                    Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + DataForm.ELEMENT + bitmap.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + a2.getWidth() + DataForm.ELEMENT + a2.getHeight());
                    Log.v("TransformationUtils", "minPct:   " + min);
                }
                Canvas canvas = new Canvas(a2);
                Matrix matrix = new Matrix();
                matrix.setScale(min, min);
                canvas.drawBitmap(bitmap, matrix, new Paint(6));
                return a2;
            } else if (!Log.isLoggable("TransformationUtils", 2)) {
                return bitmap;
            } else {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
                return bitmap;
            }
        } else if (!Log.isLoggable("TransformationUtils", 2)) {
            return bitmap;
        } else {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return bitmap;
        }
    }

    static void m4892a(int i, Matrix matrix) {
        switch (i) {
            case VideoSize.HVGA /*2*/:
                matrix.setScale(-1.0f, 1.0f);
            case Version.API03_CUPCAKE_15 /*3*/:
                matrix.setRotate(180.0f);
            case Version.API04_DONUT_16 /*4*/:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
            case Version.API05_ECLAIR_20 /*5*/:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
            case Version.API06_ECLAIR_201 /*6*/:
                matrix.setRotate(90.0f);
            case Version.API07_ECLAIR_21 /*7*/:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
            case Version.API08_FROYO_22 /*8*/:
                matrix.setRotate(-90.0f);
            default:
        }
    }

    @TargetApi(12)
    public static void m4893a(Bitmap bitmap, Bitmap bitmap2) {
        if (VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
