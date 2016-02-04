package org.linphone.core;

import org.linphone.core.LinphoneCore.RegistrationState;

class LinphoneProxyConfigImpl implements LinphoneProxyConfig {
    protected final long nativePtr;
    boolean ownPtr;

    protected LinphoneProxyConfigImpl(long j) {
        this.ownPtr = false;
        this.nativePtr = j;
        this.ownPtr = false;
    }

    protected LinphoneProxyConfigImpl(String str, String str2, String str3, boolean z) {
        this.ownPtr = false;
        this.nativePtr = newLinphoneProxyConfig();
        setIdentity(str);
        setProxy(str2);
        setRoute(str3);
        enableRegister(z);
        this.ownPtr = true;
    }

    private native void delete(long j);

    private native void done(long j);

    private native void edit(long j);

    private native void enablePublish(long j, boolean z);

    private native void enableRegister(long j, boolean z);

    private native String getContactParameters(long j);

    private native String getContactUriParameters(long j);

    private native boolean getDialEscapePlus(long j);

    private native String getDialPrefix(long j);

    private native String getDomain(long j);

    private native int getError(long j);

    private native int getExpires(long j);

    private native String getIdentity(long j);

    private native int getPrivacy(long j);

    private native String getProxy(long j);

    private native String getRoute(long j);

    private native int getState(long j);

    private native boolean isRegisterEnabled(long j);

    private native boolean isRegistered(long j);

    private native int lookupCCCFromE164(long j, String str);

    private native int lookupCCCFromIso(long j, String str);

    private native long newLinphoneProxyConfig();

    private native String normalizePhoneNumber(long j, String str);

    private native boolean publishEnabled(long j);

    private native void setContactParameters(long j, String str);

    private native void setContactUriParameters(long j, String str);

    private native void setDialEscapePlus(long j, boolean z);

    private native void setDialPrefix(long j, String str);

    private native void setExpires(long j, int i);

    private native void setIdentity(long j, String str);

    private native void setPrivacy(long j, int i);

    private native int setProxy(long j, String str);

    private native int setRoute(long j, String str);

    public void done() {
        done(this.nativePtr);
    }

    public LinphoneProxyConfig edit() {
        edit(this.nativePtr);
        return this;
    }

    public void enablePublish(boolean z) {
        enablePublish(this.nativePtr, z);
    }

    public LinphoneProxyConfig enableRegister(boolean z) {
        enableRegister(this.nativePtr, z);
        return this;
    }

    protected void finalize() {
        if (this.ownPtr) {
            delete(this.nativePtr);
        }
    }

    public String getContactParameters() {
        return getContactParameters(this.nativePtr);
    }

    public String getContactUriParameters() {
        return getContactUriParameters(this.nativePtr);
    }

    public boolean getDialEscapePlus() {
        return getDialEscapePlus(this.nativePtr);
    }

    public String getDialPrefix() {
        return getDialPrefix(this.nativePtr);
    }

    public String getDomain() {
        return getDomain(this.nativePtr);
    }

    public Reason getError() {
        return Reason.fromInt(getError(this.nativePtr));
    }

    public int getExpires() {
        return getExpires(this.nativePtr);
    }

    public String getIdentity() {
        return getIdentity(this.nativePtr);
    }

    public int getPrivacy() {
        return getPrivacy(this.nativePtr);
    }

    public String getProxy() {
        return getProxy(this.nativePtr);
    }

    public String getRoute() {
        return getRoute(this.nativePtr);
    }

    public RegistrationState getState() {
        return RegistrationState.fromInt(getState(this.nativePtr));
    }

    public boolean isRegistered() {
        return isRegistered(this.nativePtr);
    }

    public int lookupCCCFromE164(String str) {
        return lookupCCCFromE164(this.nativePtr, str);
    }

    public int lookupCCCFromIso(String str) {
        return lookupCCCFromIso(this.nativePtr, str);
    }

    public String normalizePhoneNumber(String str) {
        return normalizePhoneNumber(this.nativePtr, str);
    }

    public boolean publishEnabled() {
        return publishEnabled(this.nativePtr);
    }

    public boolean registerEnabled() {
        return isRegisterEnabled(this.nativePtr);
    }

    public void setContactParameters(String str) {
        setContactParameters(this.nativePtr, str);
    }

    public void setContactUriParameters(String str) {
        setContactUriParameters(this.nativePtr, str);
    }

    public void setDialEscapePlus(boolean z) {
        setDialEscapePlus(this.nativePtr, z);
    }

    public void setDialPrefix(String str) {
        setDialPrefix(this.nativePtr, str);
    }

    public void setExpires(int i) {
        setExpires(this.nativePtr, i);
    }

    public void setIdentity(String str) {
        setIdentity(this.nativePtr, str);
    }

    public void setPrivacy(int i) {
        setPrivacy(this.nativePtr, i);
    }

    public void setProxy(String str) {
        if (setProxy(this.nativePtr, str) != 0) {
            throw new LinphoneCoreException("Bad proxy address [" + str + "]");
        }
    }

    public void setRoute(String str) {
        if (setRoute(this.nativePtr, str) != 0) {
            throw new LinphoneCoreException("cannot set route [" + str + "]");
        }
    }
}
