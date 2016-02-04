package org.apache.http.myHttp;

import java.util.Iterator;

public interface HeaderIterator extends Iterator<Object> {
    boolean hasNext();

    Header nextHeader();
}
