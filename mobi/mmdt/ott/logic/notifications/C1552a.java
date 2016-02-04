package mobi.mmdt.ott.logic.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.app.bl;
import android.support.v4.app.bo;
import android.support.v4.app.by;
import android.support.v7.app.bk;
import java.util.ArrayList;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p168b.C1573b;
import mobi.mmdt.ott.provider.p171e.C1607a;
import mobi.mmdt.ott.provider.p173g.C1622c;
import mobi.mmdt.ott.view.main.MainActivity;
import mobi.mmdt.ott.view.p178a.C1659a;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.notifications.a */
public class C1552a {
    private static final long[] f5219a;
    private static final long[] f5220b;
    private static final long[] f5221c;

    static {
        f5219a = new long[]{0, 0};
        f5220b = new long[]{0, 1000};
        f5221c = new long[]{0, 100, 0, 100};
    }

    private static PendingIntent m7842a(Context context, String str) {
        if (C1607a.m8152a(context, str) != null) {
            return C1659a.m8426a(context, str, (int) C1317h.Theme_RoundAvatarImageViewStyle);
        }
        if (C1622c.m8255b(context, str) != null) {
            return C1659a.m8437b(context, str, (int) C1317h.Theme_RoundAvatarImageViewStyle);
        }
        if (C1573b.m7922a(context, str) != null) {
            return C1659a.m8443c(context, str, (int) C1317h.Theme_RoundAvatarImageViewStyle);
        }
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(603979776);
        return PendingIntent.getActivity(context, C1317h.Theme_RoundAvatarImageViewStyle, intent, 134217728);
    }

    public static void m7843a(Context context) {
        ((NotificationManager) context.getSystemService("notification")).cancel(C1317h.Theme_RoundAvatarImageViewStyle);
    }

    public static void m7844a(Context context, Bitmap bitmap, String str, String str2, String str3, String str4, int i, String str5, boolean z) {
        bk bkVar = new bk(context);
        by blVar = new bl();
        blVar.m1164a(str).m1166c(str2);
        if (i > 1) {
            blVar.m1165b(str3);
        }
        C1552a.m7845a(context, bkVar, blVar, str, str3, bitmap, str + ": " + str4, str5, z, false);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (i > 1) {
            bkVar.m1181b(i);
        }
        notificationManager.notify(C1317h.Theme_RoundAvatarImageViewStyle, bkVar.m1169a());
    }

    private static void m7845a(Context context, bk bkVar, by byVar, String str, String str2, Bitmap bitmap, String str3, String str4, boolean z, boolean z2) {
        bkVar.m1176a(byVar).m1170a(2130838569).m1177a((CharSequence) str).m1182b((CharSequence) str2).m1174a(bitmap).m1183b(true).m1178a("msg");
        if (str4 != null && !str4.isEmpty()) {
            bkVar.m1173a(C1552a.m7842a(context, str4));
        } else if (z2) {
            bkVar.m1173a(C1659a.m8424a(context, (int) C1317h.Theme_RoundAvatarImageViewStyle));
        }
        if (z) {
            CharSequence charSequence;
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            if (str3.length() > 140) {
                charSequence = str3.substring(0, 140) + "...";
            }
            bkVar.m1186c(charSequence).m1175a(defaultUri);
            if (VERSION.SDK_INT >= 16) {
                bkVar.m1187d(1);
            }
            long[] jArr = null;
            switch (C1555b.f5227a[C1309a.m6934a(context).m6982y().ordinal()]) {
                case VideoSize.CIF /*1*/:
                    bkVar.m1185c(-1);
                    break;
                case VideoSize.HVGA /*2*/:
                    jArr = f5219a;
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    jArr = f5220b;
                    break;
                case Version.API04_DONUT_16 /*4*/:
                    jArr = f5221c;
                    break;
                case Version.API05_ECLAIR_20 /*5*/:
                    bkVar.m1185c(2);
                    break;
            }
            if (jArr != null) {
                bkVar.m1180a(jArr);
                return;
            }
            return;
        }
        bkVar.m1186c(null).m1175a(null).m1180a(f5219a);
    }

    public static void m7846a(Context context, ArrayList<String> arrayList, String str, String str2, int i, boolean z) {
        bk bkVar = new bk(context);
        by boVar = new bo();
        Object string = context.getString(C1136d.app_name);
        boVar.m1189a(string).m1190b(str2);
        for (int i2 = 0; i2 < Math.min(arrayList.size(), 10); i2++) {
            boVar.m1191c((CharSequence) arrayList.get(i2));
        }
        C1552a.m7845a(context, bkVar, boVar, string, str2, C1558e.m7853a(context), str, BuildConfig.FLAVOR, z, true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        bkVar.m1181b(i);
        notificationManager.notify(C1317h.Theme_RoundAvatarImageViewStyle, bkVar.m1169a());
    }
}
