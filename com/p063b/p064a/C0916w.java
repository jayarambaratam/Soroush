package com.p063b.p064a;

import android.graphics.Matrix;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;

/* renamed from: com.b.a.w */
public class C0916w extends bg implements be {
    public List<bi> f3340a;
    public Boolean f3341b;
    public Matrix f3342c;
    public C0938x f3343d;
    public String f3344e;

    protected C0916w() {
        this.f3340a = new ArrayList();
    }

    public List<bi> m5499a() {
        return this.f3340a;
    }

    public void m5500a(bi biVar) {
        if (biVar instanceof aq) {
            this.f3340a.add(biVar);
            return;
        }
        throw new SAXException("Gradient elements cannot contain " + biVar + " elements.");
    }
}
