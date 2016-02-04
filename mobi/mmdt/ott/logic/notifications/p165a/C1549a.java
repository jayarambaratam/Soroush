package mobi.mmdt.ott.logic.notifications.p165a;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.bl;
import android.support.v4.app.by;
import android.support.v7.app.bk;
import mobi.mmdt.ott.view.conversation.C1988a;
import mobi.mmdt.ott.view.p178a.C1659a;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.notifications.a.a */
public class C1549a {
    private static bk m7836a(Context context, String str, String str2, Bitmap bitmap) {
        bk bkVar = new bk(context);
        by blVar = new bl();
        blVar.m1164a(str).m1166c(str2);
        bkVar.m1176a(blVar).m1170a(2130838460).m1177a((CharSequence) str).m1182b((CharSequence) str2).m1174a(bitmap).m1186c((CharSequence) str2).m1179a(true);
        if (VERSION.SDK_INT >= 16) {
            bkVar.m1187d(2);
        }
        return bkVar;
    }

    public static void m7837a(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(111);
    }

    public static void m7838a(Context context, String str, String str2, String str3, Bitmap bitmap) {
        bk a = C1549a.m7836a(context, str2, str3, bitmap);
        C1549a.m7839a(context, str, C1551c.Incoming, a);
        ((NotificationManager) context.getSystemService("notification")).notify(111, a.m1169a());
    }

    private static void m7839a(Context context, String str, C1551c c1551c, bk bkVar) {
        bkVar.m1173a(C1659a.m8425a(context, 111, str, C1988a.NOTHING));
        PendingIntent a = C1659a.m8425a(context, 112, str, C1988a.END_CALL);
        switch (C1550b.f5214a[c1551c.ordinal()]) {
            case VideoSize.CIF /*1*/:
                bkVar.m1172a(2130838491, "Answer", C1659a.m8425a(context, 112, str, C1988a.ANSWER_CALL));
                bkVar.m1172a(2130838490, "Reject", a);
            case VideoSize.HVGA /*2*/:
                bkVar.m1172a(2130838490, "Hang Up", a);
            case Version.API03_CUPCAKE_15 /*3*/:
                bkVar.m1172a(2130838490, "End Call", a);
            default:
        }
    }

    public static void m7840b(Context context, String str, String str2, String str3, Bitmap bitmap) {
        bk a = C1549a.m7836a(context, str2, str3, bitmap);
        C1549a.m7839a(context, str, C1551c.InCall, a);
        ((NotificationManager) context.getSystemService("notification")).notify(111, a.m1169a());
    }

    public static void m7841c(Context context, String str, String str2, String str3, Bitmap bitmap) {
        bk a = C1549a.m7836a(context, str2, str3, bitmap);
        C1549a.m7839a(context, str, C1551c.Dialing, a);
        ((NotificationManager) context.getSystemService("notification")).notify(111, a.m1169a());
    }
}
