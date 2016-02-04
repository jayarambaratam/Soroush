package mobi.mmdt.ott;

import android.app.Application;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.DisplayMetrics;
import com.p065c.p066a.p067a.C0950c;
import com.p065c.p066a.p067a.C0959e;
import com.p065c.p066a.p067a.p069b.C0945a;
import com.p065c.p066a.p067a.p069b.C0947c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.core.StartUpService;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1320a;
import mobi.mmdt.ott.logic.p112a.p135f.p136a.C1421a;
import mobi.mmdt.ott.logic.p112a.p154k.C1484a;
import mobi.mmdt.ott.logic.p112a.p154k.C1485b;
import mobi.mmdt.ott.logic.p161g.C1534g;
import mobi.mmdt.ott.logic.p163i.C1542a;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.channel.p183b.C1723a;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.Emojicon;
import mobi.mmdt.ott.view.p178a.ad;
import mobi.mmdt.ott.view.p178a.p179a.C1653a;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.HttpStatus;
import p000a.p001a.p002a.C0002c;

public class MyApplication extends Application {
    private static MyApplication f4169p;
    public C1653a f4170a;
    public LinkedHashMap<String, Boolean> f4171b;
    public LinkedHashMap<String, Boolean> f4172c;
    public LinkedHashMap<String, Boolean> f4173d;
    public LinkedHashMap<String, String> f4174e;
    public ConcurrentHashMap<String, Integer> f4175f;
    public ArrayList<C1723a> f4176g;
    public String f4177h;
    private HashMap<String, Bundle> f4178i;
    private C0959e f4179j;
    private C0959e f4180k;
    private C0959e f4181l;
    private int f4182m;
    private C1542a f4183n;
    private Locale f4184o;

    public MyApplication() {
        this.f4171b = new LinkedHashMap();
        this.f4172c = new LinkedHashMap();
        this.f4173d = new LinkedHashMap();
        this.f4174e = new LinkedHashMap();
        this.f4175f = new ConcurrentHashMap();
        this.f4178i = new HashMap();
        this.f4176g = new ArrayList();
        this.f4177h = null;
        this.f4182m = 0;
        this.f4184o = null;
        f4169p = this;
    }

    public static MyApplication m6445a() {
        return f4169p;
    }

    private void m6447a(Emojicon[] emojiconArr) {
        for (Emojicon a : emojiconArr) {
            int a2 = a.m10088a();
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), a2);
            if (!(decodeResource == null || this.f4170a == null)) {
                this.f4170a.m8402a(Integer.valueOf(a2), decodeResource);
            }
        }
    }

    private void m6448c() {
        new Thread(new C1166b(this)).start();
    }

    private void m6449d() {
        C0945a a = new C0947c(this).m5857a(new C1304c(this)).m5859c(0).m5858b(20).m5860d(10).m5856a((int) HttpStatus.SC_MULTIPLE_CHOICES).m5855a();
        C0945a a2 = new C0947c(this).m5857a(new C1313d(this)).m5859c(0).m5858b(10).m5860d(5).m5856a(15).m5855a();
        C0945a a3 = new C0947c(this).m5857a(new C1314e(this)).m5859c(0).m5858b(10).m5860d(5).m5856a((int) HttpStatus.SC_MULTIPLE_CHOICES).m5855a();
        this.f4179j = new C0959e(this, a);
        this.f4180k = new C0959e(this, a2);
        this.f4181l = new C0959e(this, a3);
    }

    public Bundle m6450a(String str) {
        if (this.f4178i.containsKey(str)) {
            return (Bundle) this.f4178i.get(str);
        }
        Bundle bundle = new Bundle();
        this.f4178i.put(str, bundle);
        return bundle;
    }

    public void m6451a(FragmentManager fragmentManager) {
        new Thread(new C1315f(this, fragmentManager)).start();
    }

    public void m6452a(C0950c c0950c) {
        this.f4179j.m5935a(c0950c);
    }

    public boolean m6453a(int i) {
        if (i > this.f4182m) {
            this.f4182m = i;
            return true;
        }
        this.f4182m = i;
        return false;
    }

    public void m6454b() {
        this.f4178i.clear();
    }

    public void m6455b(C0950c c0950c) {
        this.f4180k.m5935a(c0950c);
    }

    public void m6456b(String str) {
        Locale locale = new Locale(str);
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
        C1309a.m6934a(getApplicationContext()).m6939a(str);
    }

    public void m6457c(C0950c c0950c) {
        this.f4181l.m5935a(c0950c);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f4184o != null) {
            Locale locale = new Locale(C1309a.m6934a(getApplicationContext()).m6937a());
            Locale.setDefault(locale);
            Configuration configuration2 = new Configuration(configuration);
            configuration2.locale = locale;
            getBaseContext().getResources().updateConfiguration(configuration2, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    public void onCreate() {
        super.onCreate();
        C0002c.m2a().m14a((Object) this);
        ad.m8463a(getApplicationContext());
        m6449d();
        StartUpService.m7549c(getApplicationContext());
        Configuration configuration = getBaseContext().getResources().getConfiguration();
        String a = C1309a.m6934a(getApplicationContext()).m6937a();
        if (!(BuildConfig.FLAVOR.equals(a) || configuration.locale.getLanguage().equals(a))) {
            this.f4184o = new Locale(a);
            Locale.setDefault(this.f4184o);
            configuration.locale = this.f4184o;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        }
        this.f4183n = new C1542a(getApplicationContext());
        getApplicationContext().getContentResolver().registerContentObserver(Contacts.CONTENT_URI, true, this.f4183n);
        m6448c();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEvent(mobi.mmdt.componentsutils.p079a.p080a.C1106d r6) {
        /*
        r5 = this;
        r0 = r5.getApplicationContext();	 Catch:{ ag -> 0x0029, aj -> 0x002b, JSONException -> 0x002d, ae -> 0x0027, u -> 0x0025, j -> 0x003b, af -> 0x0023, t -> 0x001c, ab -> 0x0035, f -> 0x0039, IOException -> 0x0033, h -> 0x0037, r -> 0x0021, GeneralSecurityException -> 0x002f, e -> 0x003d, c -> 0x0031 }
        r0 = mobi.mmdt.ott.view.p178a.ad.m8463a(r0);	 Catch:{ ag -> 0x0029, aj -> 0x002b, JSONException -> 0x002d, ae -> 0x0027, u -> 0x0025, j -> 0x003b, af -> 0x0023, t -> 0x001c, ab -> 0x0035, f -> 0x0039, IOException -> 0x0033, h -> 0x0037, r -> 0x0021, GeneralSecurityException -> 0x002f, e -> 0x003d, c -> 0x0031 }
        r1 = r6.m6373c();	 Catch:{ ag -> 0x0029, aj -> 0x002b, JSONException -> 0x002d, ae -> 0x0027, u -> 0x0025, j -> 0x003b, af -> 0x0023, t -> 0x001c, ab -> 0x0035, f -> 0x0039, IOException -> 0x0033, h -> 0x0037, r -> 0x0021, GeneralSecurityException -> 0x002f, e -> 0x003d, c -> 0x0031 }
        r2 = r6.m6374d();	 Catch:{ ag -> 0x0029, aj -> 0x002b, JSONException -> 0x002d, ae -> 0x0027, u -> 0x0025, j -> 0x003b, af -> 0x0023, t -> 0x001c, ab -> 0x0035, f -> 0x0039, IOException -> 0x0033, h -> 0x0037, r -> 0x0021, GeneralSecurityException -> 0x002f, e -> 0x003d, c -> 0x0031 }
        r3 = r6.m6372b();	 Catch:{ ag -> 0x0029, aj -> 0x002b, JSONException -> 0x002d, ae -> 0x0027, u -> 0x0025, j -> 0x003b, af -> 0x0023, t -> 0x001c, ab -> 0x0035, f -> 0x0039, IOException -> 0x0033, h -> 0x0037, r -> 0x0021, GeneralSecurityException -> 0x002f, e -> 0x003d, c -> 0x0031 }
        r4 = r6.m6371a();	 Catch:{ ag -> 0x0029, aj -> 0x002b, JSONException -> 0x002d, ae -> 0x0027, u -> 0x0025, j -> 0x003b, af -> 0x0023, t -> 0x001c, ab -> 0x0035, f -> 0x0039, IOException -> 0x0033, h -> 0x0037, r -> 0x0021, GeneralSecurityException -> 0x002f, e -> 0x003d, c -> 0x0031 }
        r0.m8468a(r1, r2, r3, r4);	 Catch:{ ag -> 0x0029, aj -> 0x002b, JSONException -> 0x002d, ae -> 0x0027, u -> 0x0025, j -> 0x003b, af -> 0x0023, t -> 0x001c, ab -> 0x0035, f -> 0x0039, IOException -> 0x0033, h -> 0x0037, r -> 0x0021, GeneralSecurityException -> 0x002f, e -> 0x003d, c -> 0x0031 }
    L_0x001b:
        return;
    L_0x001c:
        r0 = move-exception;
    L_0x001d:
        mobi.mmdt.componentsutils.p079a.p080a.C1104b.m6368b(r5, r0);
        goto L_0x001b;
    L_0x0021:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0023:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0025:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0027:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0029:
        r0 = move-exception;
        goto L_0x001d;
    L_0x002b:
        r0 = move-exception;
        goto L_0x001d;
    L_0x002d:
        r0 = move-exception;
        goto L_0x001d;
    L_0x002f:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0031:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0033:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0035:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0037:
        r0 = move-exception;
        goto L_0x001d;
    L_0x0039:
        r0 = move-exception;
        goto L_0x001d;
    L_0x003b:
        r0 = move-exception;
        goto L_0x001d;
    L_0x003d:
        r0 = move-exception;
        goto L_0x001d;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.MyApplication.onEvent(mobi.mmdt.componentsutils.a.a.d):void");
    }

    public void onEvent(C1320a c1320a) {
        C1494c.m7539a(new C1421a(getApplicationContext(), c1320a.m6993a(), c1320a.m6995c() != null ? c1320a.m6995c() : C1534g.m7722a(getApplicationContext()).m7746g()));
    }

    public void onEvent(C1485b c1485b) {
        C1494c.m7539a(new C1484a(getApplicationContext()));
    }

    public void onTerminate() {
        super.onTerminate();
        C0002c.m2a().m16b(this);
        getApplicationContext().getContentResolver().unregisterContentObserver(this.f4183n);
    }
}
