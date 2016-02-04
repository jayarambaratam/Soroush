package org.apache.http.myHttp.io;

public interface HttpTransportMetrics {
    long getBytesTransferred();

    void reset();
}
