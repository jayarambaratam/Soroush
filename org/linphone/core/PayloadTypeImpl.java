package org.linphone.core;

class PayloadTypeImpl implements PayloadType {
    protected final long nativePtr;

    protected PayloadTypeImpl(long j) {
        this.nativePtr = j;
    }

    private native String getMime(long j);

    private native int getRate(long j);

    private native String getRecvFmtp(long j);

    private native String getSendFmtp(long j);

    private native void setRecvFmtp(long j, String str);

    private native void setSendFmtp(long j, String str);

    private native String toString(long j);

    public String getMime() {
        return getMime(this.nativePtr);
    }

    public int getRate() {
        return getRate(this.nativePtr);
    }

    public String getRecvFmtp() {
        return getRecvFmtp(this.nativePtr);
    }

    public String getSendFmtp() {
        return getSendFmtp(this.nativePtr);
    }

    public void setRecvFmtp(String str) {
        setRecvFmtp(this.nativePtr, str);
    }

    public void setSendFmtp(String str) {
        setSendFmtp(this.nativePtr, str);
    }

    public String toString() {
        return toString(this.nativePtr);
    }
}
