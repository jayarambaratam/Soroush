package org.linphone.core;

class LinphoneAuthInfoImpl implements LinphoneAuthInfo {
    protected final long nativePtr;
    boolean ownPtr;

    protected LinphoneAuthInfoImpl(long j) {
        this.ownPtr = false;
        this.nativePtr = j;
        this.ownPtr = false;
    }

    protected LinphoneAuthInfoImpl(String str, String str2, String str3, String str4) {
        this(str, null, str2, null, null, str4);
    }

    protected LinphoneAuthInfoImpl(String str, String str2, String str3, String str4, String str5, String str6) {
        this.ownPtr = false;
        this.nativePtr = newLinphoneAuthInfo();
        setUsername(str);
        setUserId(str2);
        setPassword(str3);
        setHa1(str4);
        setDomain(str6);
        this.ownPtr = true;
    }

    private native void delete(long j);

    private native String getDomain(long j);

    private native String getHa1(long j);

    private native String getPassword(long j);

    private native String getRealm(long j);

    private native String getUserId(long j);

    private native String getUsername(long j);

    private native long newLinphoneAuthInfo();

    private native void setDomain(long j, String str);

    private native void setHa1(long j, String str);

    private native void setPassword(long j, String str);

    private native void setRealm(long j, String str);

    private native void setUserId(long j, String str);

    private native void setUsername(long j, String str);

    public LinphoneAuthInfo clone() {
        return LinphoneCoreFactory.instance().createAuthInfo(getUsername(), getUserId(), getPassword(), getHa1(), getRealm(), getDomain());
    }

    protected void finalize() {
        if (this.ownPtr) {
            delete(this.nativePtr);
        }
    }

    public String getDomain() {
        return getDomain(this.nativePtr);
    }

    public String getHa1() {
        return getHa1(this.nativePtr);
    }

    public String getPassword() {
        return getPassword(this.nativePtr);
    }

    public String getRealm() {
        return getRealm(this.nativePtr);
    }

    public String getUserId() {
        return getUserId(this.nativePtr);
    }

    public String getUsername() {
        return getUsername(this.nativePtr);
    }

    public void setDomain(String str) {
        setDomain(this.nativePtr, str);
    }

    public void setHa1(String str) {
        setHa1(this.nativePtr, str);
    }

    public void setPassword(String str) {
        setPassword(this.nativePtr, str);
    }

    public void setRealm(String str) {
        setRealm(this.nativePtr, str);
    }

    public void setUserId(String str) {
        setUserId(this.nativePtr, str);
    }

    public void setUsername(String str) {
        setUsername(this.nativePtr, str);
    }
}
