package com.p032a.p033a.p037d.p039b.p040a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p032a.p033a.p042j.C0879h;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

@TargetApi(19)
/* renamed from: com.a.a.d.b.a.o */
public class C0613o implements C0599m {
    private static final Config[] f2560a;
    private static final Config[] f2561b;
    private static final Config[] f2562c;
    private static final Config[] f2563d;
    private final C0616r f2564e;
    private final C0607g<C0615q, Bitmap> f2565f;
    private final Map<Config, NavigableMap<Integer, Integer>> f2566g;

    static {
        f2560a = new Config[]{Config.ARGB_8888, null};
        f2561b = new Config[]{Config.RGB_565};
        f2562c = new Config[]{Config.ARGB_4444};
        f2563d = new Config[]{Config.ALPHA_8};
    }

    public C0613o() {
        this.f2564e = new C0616r();
        this.f2565f = new C0607g();
        this.f2566g = new HashMap();
    }

    private C0615q m4544a(C0615q c0615q, int i, Config config) {
        Config[] b = C0613o.m4549b(config);
        int length = b.length;
        int i2 = 0;
        while (i2 < length) {
            Config config2 = b[i2];
            Integer num = (Integer) m4546a(config2).ceilingKey(Integer.valueOf(i));
            if (num == null || num.intValue() > i * 8) {
                i2++;
            } else {
                if (num.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return c0615q;
                        }
                    } else if (config2.equals(config)) {
                        return c0615q;
                    }
                }
                this.f2564e.m4502a(c0615q);
                return this.f2564e.m4560a(num.intValue(), config2);
            }
        }
        return c0615q;
    }

    private NavigableMap<Integer, Integer> m4546a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f2566g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.f2566g.put(config, treeMap);
        return treeMap;
    }

    private void m4547a(Integer num, Config config) {
        NavigableMap a = m4546a(config);
        Integer num2 = (Integer) a.get(num);
        if (num2.intValue() == 1) {
            a.remove(num);
        } else {
            a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private static String m4548b(int i, Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Config[] m4549b(Config config) {
        switch (C0614p.f2567a[config.ordinal()]) {
            case VideoSize.CIF /*1*/:
                return f2560a;
            case VideoSize.HVGA /*2*/:
                return f2561b;
            case Version.API03_CUPCAKE_15 /*3*/:
                return f2562c;
            case Version.API04_DONUT_16 /*4*/:
                return f2563d;
            default:
                return new Config[]{config};
        }
    }

    public Bitmap m4550a() {
        Bitmap bitmap = (Bitmap) this.f2565f.m4522a();
        if (bitmap != null) {
            m4547a(Integer.valueOf(C0879h.m5302a(bitmap)), bitmap.getConfig());
        }
        return bitmap;
    }

    public Bitmap m4551a(int i, int i2, Config config) {
        int a = C0879h.m5300a(i, i2, config);
        Bitmap bitmap = (Bitmap) this.f2565f.m4523a(m4544a(this.f2564e.m4560a(a, config), a, config));
        if (bitmap != null) {
            m4547a(Integer.valueOf(C0879h.m5302a(bitmap)), bitmap.getConfig());
            bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        }
        return bitmap;
    }

    public void m4552a(Bitmap bitmap) {
        C0615q a = this.f2564e.m4560a(C0879h.m5302a(bitmap), bitmap.getConfig());
        this.f2565f.m4524a(a, bitmap);
        NavigableMap a2 = m4546a(bitmap.getConfig());
        Integer num = (Integer) a2.get(Integer.valueOf(a.f2569b));
        a2.put(Integer.valueOf(a.f2569b), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    public String m4553b(int i, int i2, Config config) {
        return C0613o.m4548b(C0879h.m5300a(i, i2, config), config);
    }

    public String m4554b(Bitmap bitmap) {
        return C0613o.m4548b(C0879h.m5302a(bitmap), bitmap.getConfig());
    }

    public int m4555c(Bitmap bitmap) {
        return C0879h.m5302a(bitmap);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f2565f).append(", sortedSizes=(");
        for (Entry entry : this.f2566g.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.f2566g.isEmpty()) {
            append.replace(append.length() - 2, append.length(), BuildConfig.FLAVOR);
        }
        return append.append(")}").toString();
    }
}
