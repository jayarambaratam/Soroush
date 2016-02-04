package org.apache.http.myHttp;

import org.apache.http.myHttp.util.CharArrayBuffer;

public interface FormattedHeader extends Header {
    CharArrayBuffer getBuffer();

    int getValuePos();
}
