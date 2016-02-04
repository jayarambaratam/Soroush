package mobi.mmdt.ott.logic.notifications.p166b;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.os.Build.VERSION;
import android.support.v4.app.bl;
import android.support.v4.app.by;
import android.support.v7.app.bk;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.p178a.C1659a;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.notifications.b.a */
public class C1553a {
    private static final long[] f5222a;
    private static final long[] f5223b;
    private static final long[] f5224c;
    private static int f5225d;

    static {
        f5222a = new long[]{0, 0};
        f5223b = new long[]{0, 1000};
        f5224c = new long[]{0, 100, 0, 100};
        f5225d = 112;
    }

    public static void m7847a(Context context, String str, String str2, Bitmap bitmap) {
        bk b = C1553a.m7848b(context, str2, String.format(context.getString(2131230876), new Object[]{str2}), bitmap);
        b.m1173a(C1659a.m8426a(context, str, f5225d));
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        int i = f5225d;
        f5225d = i + 1;
        notificationManager.notify(i, b.m1169a());
    }

    private static bk m7848b(Context context, String str, String str2, Bitmap bitmap) {
        bk bkVar = new bk(context);
        by blVar = new bl();
        blVar.m1164a(str).m1166c(str2);
        bkVar.m1176a(blVar).m1170a(2130838569).m1177a((CharSequence) str).m1186c((CharSequence) str2).m1182b((CharSequence) str2).m1174a(bitmap).m1186c((CharSequence) str2).m1183b(true);
        bkVar.m1175a(RingtoneManager.getDefaultUri(2));
        if (VERSION.SDK_INT >= 16) {
            bkVar.m1187d(1);
        }
        long[] jArr = null;
        switch (C1554b.f5226a[C1309a.m6934a(context).m6982y().ordinal()]) {
            case VideoSize.CIF /*1*/:
                bkVar.m1185c(-1);
                break;
            case VideoSize.HVGA /*2*/:
                jArr = f5222a;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                jArr = f5223b;
                break;
            case Version.API04_DONUT_16 /*4*/:
                jArr = f5224c;
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                bkVar.m1185c(2);
                break;
        }
        if (jArr != null) {
            bkVar.m1180a(jArr);
        }
        if (VERSION.SDK_INT >= 16) {
            bkVar.m1187d(2);
        }
        return bkVar;
    }
}
