package org.apache.http.myHttp;

public interface Header {
    HeaderElement[] getElements();

    String getName();

    String getValue();
}
