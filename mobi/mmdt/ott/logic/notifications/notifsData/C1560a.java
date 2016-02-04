package mobi.mmdt.ott.logic.notifications.notifsData;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.logic.notifications.notifsData.a */
public class C1560a extends C1559b {
    private final LinkedHashMap<String, C1559b> f5232a;

    public C1560a(String str) {
        super(str);
        this.f5232a = new LinkedHashMap();
    }

    private int m7859a(C1559b c1559b) {
        return c1559b instanceof C1565g ? 1 : c1559b instanceof C1562d ? 2 : c1559b instanceof C1561c ? 3 : 0;
    }

    public Set<Entry<String, C1559b>> m7860a() {
        return this.f5232a.entrySet();
    }

    public void m7861a(String str, C1559b c1559b) {
        if (this.f5232a.containsKey(str)) {
            C1559b c1559b2 = (C1559b) this.f5232a.get(str);
            if (c1559b2 != null) {
                switch (m7859a(c1559b2)) {
                    case VideoSize.CIF /*1*/:
                        ((C1565g) c1559b).m7878a(((C1565g) c1559b2).m7880d());
                        break;
                    case VideoSize.HVGA /*2*/:
                        ((C1562d) c1559b).m7869a(((C1562d) c1559b2).m7873e());
                        break;
                    case Version.API03_CUPCAKE_15 /*3*/:
                        ((C1561c) c1559b).m7863a(((C1561c) c1559b2).m7867e());
                        break;
                }
                this.f5232a.remove(str);
            }
        }
        this.f5232a.put(str, c1559b);
    }
}
