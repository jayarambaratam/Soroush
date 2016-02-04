package org.linphone.core;

public class LinphoneEventImpl implements LinphoneEvent {
    private long mNativePtr;
    private Object mUserContext;

    protected LinphoneEventImpl(long j) {
        this.mNativePtr = j;
    }

    private native int acceptSubscription(long j);

    private native int denySubscription(long j, int i);

    private native String getEventName(long j);

    private native int getReason(long j);

    private native int getSubscriptionDir(long j);

    private native int getSubscriptionState(long j);

    private native int notify(long j, String str, String str2, byte[] bArr, String str3);

    private native int terminate(long j);

    private native void unref(long j);

    private native int updatePublish(long j, String str, String str2, byte[] bArr, String str3);

    private native int updateSubscribe(long j, String str, String str2, byte[] bArr, String str3);

    public void acceptSubscription() {
        acceptSubscription(this.mNativePtr);
    }

    public void denySubscription(Reason reason) {
        denySubscription(this.mNativePtr, reason.mValue);
    }

    protected void finalize() {
        unref(this.mNativePtr);
    }

    public String getEventName() {
        return getEventName(this.mNativePtr);
    }

    public Reason getReason() {
        return Reason.fromInt(getReason(this.mNativePtr));
    }

    public SubscriptionDir getSubscriptionDir() {
        return SubscriptionDir.fromInt(getSubscriptionDir(this.mNativePtr));
    }

    public SubscriptionState getSubscriptionState() {
        try {
            return SubscriptionState.fromInt(getSubscriptionState(this.mNativePtr));
        } catch (LinphoneCoreException e) {
            e.printStackTrace();
            return SubscriptionState.Error;
        }
    }

    public Object getUserContext() {
        return this.mUserContext;
    }

    public void notify(LinphoneContent linphoneContent) {
        notify(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
    }

    public void setUserContext(Object obj) {
        this.mUserContext = obj;
    }

    public void terminate() {
        terminate(this.mNativePtr);
    }

    public void updatePublish(LinphoneContent linphoneContent) {
        updatePublish(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
    }

    public void updateSubscribe(LinphoneContent linphoneContent) {
        updateSubscribe(this.mNativePtr, linphoneContent.getType(), linphoneContent.getSubtype(), linphoneContent.getData(), linphoneContent.getEncoding());
    }
}
