package mobi.mmdt.ott.view.contact.p209a.p212c;

import mobi.mmdt.ott.view.components.p181b.C1722f;

/* renamed from: mobi.mmdt.ott.view.contact.a.c.a */
public abstract class C1952a extends C1722f implements Comparable<C1952a> {
    public C1952a(int i, int i2) {
        super(i, i2);
    }

    public int m9256a(C1952a c1952a) {
        return (m8659g() == 1 && c1952a.m8659g() == 1) ? ((C1953b) this).m9263e().compareTo(((C1953b) c1952a).m9263e()) : (m8659g() == 3 && c1952a.m8659g() == 3) ? ((C1955d) this).m9274d().compareTo(((C1955d) c1952a).m9274d()) : 0;
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m9256a((C1952a) obj);
    }
}
