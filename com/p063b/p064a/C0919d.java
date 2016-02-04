package com.p063b.p064a;

import net.frakbot.glowpadbackport.BuildConfig;
import org.xml.sax.SAXException;

/* renamed from: com.b.a.d */
class C0919d extends cr {
    public C0919d(String str) {
        super(str.replaceAll("(?s)/\\*.*?\\*/", BuildConfig.FLAVOR));
    }

    private int m5767t() {
        if (m5750c()) {
            return this.b;
        }
        int i = this.b;
        int i2 = this.b;
        char charAt = this.a.charAt(this.b);
        if (charAt == '-') {
            charAt = m5759l();
        }
        if ((charAt >= 'A' && charAt <= 'Z') || ((charAt >= 'a' && charAt <= 'z') || charAt == '_')) {
            i2 = m5759l();
            while (true) {
                if ((i2 < 65 || i2 > 90) && ((i2 < 97 || i2 > 122) && !((i2 >= 48 && i2 <= 57) || i2 == 45 || i2 == 95))) {
                    break;
                }
                i2 = m5759l();
            }
            i2 = this.b;
        }
        this.b = i;
        return i2;
    }

    private String m5768u() {
        if (m5750c()) {
            return null;
        }
        String r = m5765r();
        return r == null ? m5769a() : r;
    }

    public String m5769a() {
        int t = m5767t();
        if (t == this.b) {
            return null;
        }
        String substring = this.a.substring(this.b, t);
        this.b = t;
        return substring;
    }

    public boolean m5770a(C0924i c0924i) {
        if (m5750c()) {
            return false;
        }
        C0920e c0920e;
        String a;
        C0925j c0925j;
        String a2;
        C0918c c0918c;
        int i;
        int i2 = this.b;
        if (!c0924i.m5779b()) {
            if (m5745a('>')) {
                c0920e = C0920e.CHILD;
                m5751d();
            } else if (m5745a('+')) {
                c0920e = C0920e.FOLLOWS;
                m5751d();
            }
            if (m5745a('*')) {
                a = m5769a();
                if (a == null) {
                    c0925j = new C0925j(c0920e, a);
                    c0924i.m5782e();
                } else {
                    c0925j = null;
                }
            } else {
                c0925j = new C0925j(c0920e, null);
            }
            while (!m5750c()) {
                if (m5745a('.')) {
                    if (m5745a('#')) {
                        if (c0925j == null) {
                            c0925j = new C0925j(c0920e, null);
                        }
                        a = m5769a();
                        if (a != null) {
                            throw new SAXException("Invalid \"#id\" selector in <style> element");
                        }
                        c0925j.m5785a("id", C0918c.EQUALS, a);
                        c0924i.m5780c();
                    }
                    if (c0925j == null) {
                        break;
                    } else if (m5745a('[')) {
                        m5751d();
                        a2 = m5769a();
                        if (a2 != null) {
                            throw new SAXException("Invalid attribute selector in <style> element");
                        }
                        m5751d();
                        c0918c = m5745a('=') ? C0918c.EQUALS : m5747a("~=") ? C0918c.INCLUDES : m5747a("|=") ? C0918c.DASHMATCH : null;
                        if (c0918c == null) {
                            m5751d();
                            a = m5768u();
                            if (a != null) {
                                throw new SAXException("Invalid attribute selector in <style> element");
                            }
                            m5751d();
                        } else {
                            a = null;
                        }
                        if (m5745a(']')) {
                            throw new SAXException("Invalid attribute selector in <style> element");
                        }
                        if (c0918c == null) {
                            c0918c = C0918c.EXISTS;
                        }
                        c0925j.m5785a(a2, c0918c, a);
                        c0924i.m5781d();
                    } else if (m5745a(':')) {
                        i = this.b;
                        if (m5769a() != null) {
                            if (m5745a('(')) {
                                m5751d();
                                if (m5769a() != null) {
                                    m5751d();
                                    if (!m5745a(')')) {
                                        this.b = i - 1;
                                    }
                                }
                            }
                            c0925j.m5784a(this.a.substring(i, this.b));
                            c0924i.m5781d();
                        }
                    }
                } else {
                    if (c0925j == null) {
                        c0925j = new C0925j(c0920e, null);
                    }
                    a = m5769a();
                    if (a != null) {
                        throw new SAXException("Invalid \".class\" selector in <style> element");
                    }
                    c0925j.m5785a("class", C0918c.EQUALS, a);
                    c0924i.m5781d();
                }
            }
            if (c0925j != null) {
                c0924i.m5778a(c0925j);
                return true;
            }
            this.b = i2;
            return false;
        }
        c0920e = null;
        if (m5745a('*')) {
            a = m5769a();
            if (a == null) {
                c0925j = null;
            } else {
                c0925j = new C0925j(c0920e, a);
                c0924i.m5782e();
            }
        } else {
            c0925j = new C0925j(c0920e, null);
        }
        while (!m5750c()) {
            if (m5745a('.')) {
                if (m5745a('#')) {
                    if (c0925j == null) {
                        c0925j = new C0925j(c0920e, null);
                    }
                    a = m5769a();
                    if (a != null) {
                        c0925j.m5785a("id", C0918c.EQUALS, a);
                        c0924i.m5780c();
                    } else {
                        throw new SAXException("Invalid \"#id\" selector in <style> element");
                    }
                }
                if (c0925j == null) {
                    break;
                } else if (m5745a('[')) {
                    m5751d();
                    a2 = m5769a();
                    if (a2 != null) {
                        m5751d();
                        if (m5745a('=')) {
                        }
                        if (c0918c == null) {
                            a = null;
                        } else {
                            m5751d();
                            a = m5768u();
                            if (a != null) {
                                m5751d();
                            } else {
                                throw new SAXException("Invalid attribute selector in <style> element");
                            }
                        }
                        if (m5745a(']')) {
                            if (c0918c == null) {
                                c0918c = C0918c.EXISTS;
                            }
                            c0925j.m5785a(a2, c0918c, a);
                            c0924i.m5781d();
                        } else {
                            throw new SAXException("Invalid attribute selector in <style> element");
                        }
                    }
                    throw new SAXException("Invalid attribute selector in <style> element");
                } else if (m5745a(':')) {
                    i = this.b;
                    if (m5769a() != null) {
                        if (m5745a('(')) {
                            m5751d();
                            if (m5769a() != null) {
                                m5751d();
                                if (m5745a(')')) {
                                    this.b = i - 1;
                                }
                            }
                        }
                        c0925j.m5784a(this.a.substring(i, this.b));
                        c0924i.m5781d();
                    }
                }
                if (c0925j != null) {
                    this.b = i2;
                    return false;
                }
                c0924i.m5778a(c0925j);
                return true;
            }
            if (c0925j == null) {
                c0925j = new C0925j(c0920e, null);
            }
            a = m5769a();
            if (a != null) {
                c0925j.m5785a("class", C0918c.EQUALS, a);
                c0924i.m5781d();
            } else {
                throw new SAXException("Invalid \".class\" selector in <style> element");
            }
        }
        if (c0925j != null) {
            c0924i.m5778a(c0925j);
            return true;
        }
        this.b = i2;
        return false;
    }

    public String m5771b() {
        if (m5750c()) {
            return null;
        }
        int i = this.b;
        int i2 = this.b;
        int i3 = i2;
        i2 = this.a.charAt(this.b);
        while (i2 != -1 && i2 != 59 && i2 != 125 && i2 != 33 && !m5749b(i2)) {
            if (!m5746a(i2)) {
                i3 = this.b + 1;
            }
            i2 = m5759l();
        }
        if (this.b > i) {
            return this.a.substring(i, i3);
        }
        this.b = i;
        return null;
    }
}
