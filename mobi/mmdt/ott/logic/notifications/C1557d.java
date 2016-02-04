package mobi.mmdt.ott.logic.notifications;

import android.content.Context;
import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.logic.notifications.d */
public class C1557d {
    public static void m7850a(Context context) {
        C1552a.m7843a(context);
    }

    public static void m7851a(Context context, String str, String str2, String str3, ArrayList<String> arrayList, boolean z) {
        Bitmap a;
        Bitmap bitmap;
        String str4;
        String str5;
        int i;
        String format;
        if (str2 != null) {
            try {
                if (!str2.isEmpty()) {
                    a = C1111c.m6391a(context, aj.m8474a(str2));
                    bitmap = a;
                    str4 = (String) arrayList.get(0);
                    str5 = str4;
                    for (i = 1; i < Math.min(arrayList.size(), 10); i++) {
                        str5 = str5 + "\n" + ((String) arrayList.get(i));
                    }
                    if (arrayList.size() <= 1) {
                        format = String.format(context.getString(2131230892), new Object[]{Integer.valueOf(arrayList.size())});
                    } else {
                        format = str4;
                    }
                    C1552a.m7844a(context, bitmap, str, str5, format, (String) arrayList.get(0), arrayList.size(), str3, z);
                }
            } catch (InterruptedException e) {
                Throwable e2 = e;
                C1104b.m6367b(C1557d.class, "IOException happened in GenerateNotification", e2);
                bitmap = C1558e.m7853a(context);
                str4 = (String) arrayList.get(0);
                str5 = str4;
                for (i = 1; i < Math.min(arrayList.size(), 10); i++) {
                    str5 = str5 + "\n" + ((String) arrayList.get(i));
                }
                if (arrayList.size() <= 1) {
                    format = String.format(context.getString(2131230892), new Object[]{Integer.valueOf(arrayList.size())});
                } else {
                    format = str4;
                }
                C1552a.m7844a(context, bitmap, str, str5, format, (String) arrayList.get(0), arrayList.size(), str3, z);
            } catch (ExecutionException e3) {
                e2 = e3;
                C1104b.m6367b(C1557d.class, "IOException happened in GenerateNotification", e2);
                bitmap = C1558e.m7853a(context);
                str4 = (String) arrayList.get(0);
                str5 = str4;
                for (i = 1; i < Math.min(arrayList.size(), 10); i++) {
                    str5 = str5 + "\n" + ((String) arrayList.get(i));
                }
                if (arrayList.size() <= 1) {
                    format = str4;
                } else {
                    format = String.format(context.getString(2131230892), new Object[]{Integer.valueOf(arrayList.size())});
                }
                C1552a.m7844a(context, bitmap, str, str5, format, (String) arrayList.get(0), arrayList.size(), str3, z);
            }
        }
        a = C1558e.m7853a(context);
        bitmap = a;
        str4 = (String) arrayList.get(0);
        str5 = str4;
        for (i = 1; i < Math.min(arrayList.size(), 10); i++) {
            str5 = str5 + "\n" + ((String) arrayList.get(i));
        }
        if (arrayList.size() <= 1) {
            format = str4;
        } else {
            format = String.format(context.getString(2131230892), new Object[]{Integer.valueOf(arrayList.size())});
        }
        C1552a.m7844a(context, bitmap, str, str5, format, (String) arrayList.get(0), arrayList.size(), str3, z);
    }

    public static void m7852a(Context context, ArrayList<String> arrayList, int i, boolean z) {
        String format = String.format(context.getString(2131230893), new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(i)});
        C1552a.m7846a(context, arrayList, (String) arrayList.get(0), format, arrayList.size(), z);
    }
}
