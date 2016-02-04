package org.apache.http.myHttp.entity;

import org.apache.http.myHttp.HttpMessage;

public interface ContentLengthStrategy {
    public static final int CHUNKED = -2;
    public static final int IDENTITY = -1;

    long determineLength(HttpMessage httpMessage);
}
