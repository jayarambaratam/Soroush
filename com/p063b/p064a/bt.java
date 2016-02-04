package com.p063b.p064a;

import org.xml.sax.SAXException;

/* renamed from: com.b.a.bt */
public class bt extends bc {
    protected bt() {
    }

    public void m5502a(bi biVar) {
        if (biVar instanceof bs) {
            this.i.add(biVar);
            return;
        }
        throw new SAXException("Text content elements cannot contain " + biVar + " elements.");
    }
}
