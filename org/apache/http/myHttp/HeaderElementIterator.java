package org.apache.http.myHttp;

import java.util.Iterator;

public interface HeaderElementIterator extends Iterator<Object> {
    boolean hasNext();

    HeaderElement nextElement();
}
