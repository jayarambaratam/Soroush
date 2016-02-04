package mobi.mmdt.ott.logic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.util.DisplayMetrics;
import java.io.File;
import java.util.Calendar;
import java.util.Locale;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.p095c.p108d.C1301b;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import org.jivesoftware.smack.util.StringUtils;

/* renamed from: mobi.mmdt.ott.logic.b */
public class C1490b {
    private static C1490b f5016a;
    private Context f5017b;
    private String f5018c;
    private String f5019d;
    private String f5020e;
    private String f5021f;
    private String f5022g;
    private String f5023h;
    private String f5024i;
    private String f5025j;

    private C1490b(Context context) {
        this.f5017b = context;
        Configuration configuration = this.f5017b.getResources().getConfiguration();
        configuration.locale = new Locale("en");
        String string = new Resources(this.f5017b.getAssets(), new DisplayMetrics(), configuration).getString(C1136d.app_name);
        String str = Environment.getExternalStorageDirectory() + File.separator + string;
        this.f5018c = str + File.separator + string + "Images";
        this.f5025j = str + File.separator + "." + string + ".TEMPS";
        this.f5019d = str + File.separator + string + "Videos";
        this.f5020e = str + File.separator + "." + "Thumbnails";
        this.f5021f = str + File.separator + ".PushToTalks";
        this.f5023h = str + File.separator + ".Stickers";
        this.f5022g = str + File.separator + "Others";
        str = Environment.getExternalStorageDirectory() + File.separator + "Pictures";
        if (!new File(str).exists()) {
            new File(str).mkdir();
        }
        this.f5024i = str + File.separator + string;
    }

    public static C1490b m7516a(Context context) {
        if (f5016a == null) {
            f5016a = new C1490b(context);
        }
        return f5016a;
    }

    public static String m7517b() {
        Calendar instance = Calendar.getInstance();
        return Environment.getExternalStorageDirectory() + File.separator + Environment.DIRECTORY_DCIM + File.separator + instance.get(1) + (instance.get(2) + 1) + instance.get(5) + "_" + instance.get(11) + instance.get(12) + instance.get(13) + ".jpg";
    }

    private void m7518i(String str) {
        if (!new File(str).exists()) {
            new File(str).mkdirs();
        }
        String str2 = str + File.separator + ".nomedia";
        if (!new File(str2).exists() && !C1309a.m6934a(this.f5017b).m6981x()) {
            try {
                new File(str2).createNewFile();
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        } else if (new File(str2).exists() && C1309a.m6934a(this.f5017b).m6981x()) {
            new File(str2).delete();
        }
    }

    public String m7519a() {
        String str = this.f5020e;
        m7518i(str);
        return str + File.separator + System.currentTimeMillis() + ".png";
    }

    public String m7520a(String str) {
        String str2 = this.f5018c;
        m7518i(str2);
        return str2 + File.separator + System.currentTimeMillis() + "_" + str;
    }

    public String m7521a(String str, String str2) {
        String str3 = this.f5023h;
        m7518i(str3);
        String a = C1301b.m6870a(this.f5017b);
        m7518i(str3 + File.separator + str + File.separator + str + "_" + a);
        File file = new File(str3 + File.separator + str + File.separator + str + "_" + a + File.separator + str2);
        file.createNewFile();
        return file.getPath();
    }

    public void m7522a(Uri uri) {
        if (VERSION.SDK_INT >= 19) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(uri);
            this.f5017b.sendBroadcast(intent);
            return;
        }
        this.f5017b.sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
    }

    public String m7523b(String str) {
        String str2 = this.f5024i;
        if (!new File(str2).exists()) {
            new File(str2).mkdirs();
        }
        return str2 + File.separator + str;
    }

    public String m7524c(String str) {
        String str2 = this.f5019d;
        m7518i(str2);
        return str2 + File.separator + System.currentTimeMillis() + "_" + str;
    }

    public void m7525c() {
        for (String str : new String[]{this.f5018c, this.f5019d}) {
            m7518i(str);
            for (File fromFile : new File(str).listFiles()) {
                m7522a(Uri.fromFile(fromFile));
            }
        }
    }

    public String m7526d(String str) {
        String str2 = this.f5021f;
        m7518i(str2);
        return str2 + File.separator + System.currentTimeMillis() + "_" + str;
    }

    public String m7527e(String str) {
        String str2 = this.f5022g;
        m7518i(str2);
        return str2 + File.separator + System.currentTimeMillis() + "_" + str;
    }

    public String m7528f(String str) {
        String str2 = this.f5025j;
        m7518i(str2);
        return str2 + File.separator + "TMP_" + StringUtils.randomString(5) + str;
    }

    public String m7529g(String str) {
        String str2 = this.f5023h;
        m7518i(str2);
        return str2 + File.separator + "stpk_" + str;
    }

    public String m7530h(String str) {
        String str2 = this.f5023h;
        m7518i(str2);
        File file = new File(str2 + File.separator + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getPath();
    }
}
