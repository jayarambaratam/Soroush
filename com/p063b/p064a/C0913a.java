package com.p063b.p064a;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.xml.sax.SAXException;

/* renamed from: com.b.a.a */
public class C0913a {
    private C0921f f3192a;
    private boolean f3193b;

    public C0913a(C0921f c0921f) {
        this.f3192a = null;
        this.f3193b = false;
        this.f3192a = c0921f;
    }

    private static int m5416a(List<be> list, int i, bg bgVar) {
        if (i < 0) {
            return -1;
        }
        if (list.get(i) != bgVar.v) {
            return -1;
        }
        int i2 = 0;
        for (bi biVar : bgVar.v.m5444a()) {
            if (biVar == bgVar) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private static List<C0921f> m5417a(C0919d c0919d) {
        Object arrayList = new ArrayList();
        while (!c0919d.m5750c()) {
            try {
                arrayList.add(C0921f.valueOf(c0919d.m5748b(',')));
                if (!c0919d.m5752e()) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                throw new SAXException("Invalid @media type list");
            }
        }
        return arrayList;
    }

    private void m5418a(C0923h c0923h, C0919d c0919d) {
        String a = c0919d.m5769a();
        c0919d.m5751d();
        if (a == null) {
            throw new SAXException("Invalid '@' rule in <style> element");
        }
        if (this.f3193b || !a.equals("media")) {
            C0913a.m5419a("Ignoring @%s rule", a);
            m5427b(c0919d);
        } else {
            List a2 = C0913a.m5417a(c0919d);
            if (c0919d.m5745a('{')) {
                c0919d.m5751d();
                if (C0913a.m5425a(a2, this.f3192a)) {
                    this.f3193b = true;
                    c0923h.m5774a(m5429c(c0919d));
                    this.f3193b = false;
                } else {
                    m5429c(c0919d);
                }
                if (!c0919d.m5745a('}')) {
                    throw new SAXException("Invalid @media rule: expected '}' at end of rule set");
                }
            }
            throw new SAXException("Invalid @media rule: missing rule set");
        }
        c0919d.m5751d();
    }

    private static void m5419a(String str, Object... objArr) {
        Log.w("AndroidSVG CSSParser", String.format(str, objArr));
    }

    private static boolean m5420a(C0924i c0924i, int i, List<be> list, int i2) {
        C0925j a = c0924i.m5777a(i);
        bg bgVar = (bg) list.get(i2);
        if (!C0913a.m5423a(a, (List) list, i2, bgVar)) {
            return false;
        }
        if (a.f3540a == C0920e.DESCENDANT) {
            if (i == 0) {
                return true;
            }
            while (i2 > 0) {
                i2--;
                if (C0913a.m5420a(c0924i, i - 1, (List) list, i2)) {
                    return true;
                }
            }
            return false;
        } else if (a.f3540a == C0920e.CHILD) {
            return C0913a.m5420a(c0924i, i - 1, (List) list, i2 - 1);
        } else {
            int a2 = C0913a.m5416a(list, i2, bgVar);
            if (a2 <= 0) {
                return false;
            }
            return C0913a.m5421a(c0924i, i - 1, list, i2, (bg) bgVar.v.m5444a().get(a2 - 1));
        }
    }

    private static boolean m5421a(C0924i c0924i, int i, List<be> list, int i2, bg bgVar) {
        C0925j a = c0924i.m5777a(i);
        if (!C0913a.m5423a(a, (List) list, i2, bgVar)) {
            return false;
        }
        if (a.f3540a == C0920e.DESCENDANT) {
            if (i == 0) {
                return true;
            }
            while (i2 >= 0) {
                if (C0913a.m5420a(c0924i, i - 1, (List) list, i2)) {
                    return true;
                }
                i2--;
            }
            return false;
        } else if (a.f3540a == C0920e.CHILD) {
            return C0913a.m5420a(c0924i, i - 1, (List) list, i2);
        } else {
            int a2 = C0913a.m5416a(list, i2, bgVar);
            if (a2 <= 0) {
                return false;
            }
            return C0913a.m5421a(c0924i, i - 1, list, i2, (bg) bgVar.v.m5444a().get(a2 - 1));
        }
    }

    protected static boolean m5422a(C0924i c0924i, bg bgVar) {
        List arrayList = new ArrayList();
        for (Object obj = bgVar.v; obj != null; obj = ((bi) obj).f3195v) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        return c0924i.m5776a() == 1 ? C0913a.m5423a(c0924i.m5777a(0), arrayList, size, bgVar) : C0913a.m5421a(c0924i, c0924i.m5776a() - 1, arrayList, size, bgVar);
    }

    private static boolean m5423a(C0925j c0925j, List<be> list, int i, bg bgVar) {
        if (c0925j.f3541b != null) {
            if (c0925j.f3541b.equalsIgnoreCase("G")) {
                if (!(bgVar instanceof C0917z)) {
                    return false;
                }
            } else if (!c0925j.f3541b.equals(bgVar.getClass().getSimpleName().toLowerCase(Locale.US))) {
                return false;
            }
        }
        if (c0925j.f3542c != null) {
            for (C0915b c0915b : c0925j.f3542c) {
                if (c0915b.f3332a == "id") {
                    if (!c0915b.f3334c.equals(bgVar.f3196p)) {
                        return false;
                    }
                } else if (c0915b.f3332a != "class") {
                    return false;
                } else {
                    if (bgVar.f3200t == null) {
                        return false;
                    }
                    if (!bgVar.f3200t.contains(c0915b.f3334c)) {
                        return false;
                    }
                }
            }
        }
        if (c0925j.f3543d != null) {
            for (String equals : c0925j.f3543d) {
                if (!equals.equals("first-child")) {
                    return false;
                }
                if (C0913a.m5416a(list, i, bgVar) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean m5424a(String str, C0921f c0921f) {
        C0919d c0919d = new C0919d(str);
        c0919d.m5751d();
        List a = C0913a.m5417a(c0919d);
        if (c0919d.m5750c()) {
            return C0913a.m5425a(a, c0921f);
        }
        throw new SAXException("Invalid @media type list");
    }

    private static boolean m5425a(List<C0921f> list, C0921f c0921f) {
        for (C0921f c0921f2 : list) {
            if (c0921f2 != C0921f.all) {
                if (c0921f2 == c0921f) {
                }
            }
            return true;
        }
        return false;
    }

    protected static List<String> m5426b(String str) {
        C0919d c0919d = new C0919d(str);
        List<String> list = null;
        while (!c0919d.m5750c()) {
            String a = c0919d.m5769a();
            if (a == null) {
                throw new SAXException("Invalid value for \"class\" attribute: " + str);
            }
            if (list == null) {
                list = new ArrayList();
            }
            list.add(a);
            c0919d.m5751d();
        }
        return list;
    }

    private void m5427b(C0919d c0919d) {
        int i = 0;
        while (!c0919d.m5750c()) {
            int intValue = c0919d.m5756i().intValue();
            if (intValue != 59 || i != 0) {
                if (intValue == 123) {
                    i++;
                } else if (intValue == 125 && i > 0) {
                    i--;
                    if (i == 0) {
                        return;
                    }
                }
            } else {
                return;
            }
        }
    }

    private boolean m5428b(C0923h c0923h, C0919d c0919d) {
        List<C0924i> d = m5430d(c0919d);
        if (d == null || d.isEmpty()) {
            return false;
        }
        if (c0919d.m5745a('{')) {
            c0919d.m5751d();
            ar e = m5431e(c0919d);
            c0919d.m5751d();
            for (C0924i c0922g : d) {
                c0923h.m5773a(new C0922g(c0922g, e));
            }
            return true;
        }
        throw new SAXException("Malformed rule block in <style> element: missing '{'");
    }

    private C0923h m5429c(C0919d c0919d) {
        C0923h c0923h = new C0923h();
        while (!c0919d.m5750c()) {
            if (!(c0919d.m5747a("<!--") || c0919d.m5747a("-->"))) {
                if (!c0919d.m5745a('@')) {
                    if (!m5428b(c0923h, c0919d)) {
                        break;
                    }
                } else {
                    m5418a(c0923h, c0919d);
                }
            }
        }
        return c0923h;
    }

    private List<C0924i> m5430d(C0919d c0919d) {
        if (c0919d.m5750c()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(1);
        C0924i c0924i = new C0924i();
        while (!c0919d.m5750c() && c0919d.m5770a(c0924i)) {
            if (c0919d.m5752e()) {
                arrayList.add(c0924i);
                c0924i = new C0924i();
            }
        }
        if (!c0924i.m5779b()) {
            arrayList.add(c0924i);
        }
        return arrayList;
    }

    private ar m5431e(C0919d c0919d) {
        ar arVar = new ar();
        do {
            String a = c0919d.m5769a();
            c0919d.m5751d();
            if (!c0919d.m5745a(':')) {
                break;
            }
            c0919d.m5751d();
            String b = c0919d.m5771b();
            if (b == null) {
                break;
            }
            c0919d.m5751d();
            if (c0919d.m5745a('!')) {
                c0919d.m5751d();
                if (c0919d.m5747a("important")) {
                    c0919d.m5751d();
                } else {
                    throw new SAXException("Malformed rule set in <style> element: found unexpected '!'");
                }
            }
            c0919d.m5745a(';');
            cp.m5668a(arVar, a, b);
            c0919d.m5751d();
            if (c0919d.m5745a('}')) {
                return arVar;
            }
        } while (!c0919d.m5750c());
        throw new SAXException("Malformed rule set in <style> element");
    }

    public C0923h m5432a(String str) {
        C0919d c0919d = new C0919d(str);
        c0919d.m5751d();
        return m5429c(c0919d);
    }
}
