package mobi.mmdt.ott.view.components.fileselector.p199b;

import mobi.mmdt.ott.view.components.p181b.C1722f;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.b.a */
public abstract class C1807a extends C1722f implements Comparable<C1807a> {
    public C1807a(int i, int i2) {
        super(i, i2);
    }

    public int m8786a(C1807a c1807a) {
        return (m8659g() == 2 && c1807a.m8659g() == 2) ? m8788b(c1807a) : (m8659g() == 2 && c1807a.m8659g() == 1) ? -1 : (m8659g() == 1 && c1807a.m8659g() == 2) ? 1 : (m8659g() == 1 && c1807a.m8659g() == 1) ? m8788b(c1807a) : 0;
    }

    public void m8787a(int i) {
        this.a = i;
    }

    protected abstract int m8788b(C1807a c1807a);

    public /* synthetic */ int compareTo(Object obj) {
        return m8786a((C1807a) obj);
    }
}
