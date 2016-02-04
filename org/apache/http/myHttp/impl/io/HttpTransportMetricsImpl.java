package org.apache.http.myHttp.impl.io;

import org.apache.http.myHttp.annotation.NotThreadSafe;
import org.apache.http.myHttp.io.HttpTransportMetrics;

@NotThreadSafe
public class HttpTransportMetricsImpl implements HttpTransportMetrics {
    private long bytesTransferred;

    public HttpTransportMetricsImpl() {
        this.bytesTransferred = 0;
    }

    public long getBytesTransferred() {
        return this.bytesTransferred;
    }

    public void incrementBytesTransferred(long j) {
        this.bytesTransferred += j;
    }

    public void reset() {
        this.bytesTransferred = 0;
    }

    public void setBytesTransferred(long j) {
        this.bytesTransferred = j;
    }
}
