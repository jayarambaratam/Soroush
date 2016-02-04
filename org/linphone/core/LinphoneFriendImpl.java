package org.linphone.core;

import java.io.Serializable;
import org.linphone.core.LinphoneAddressImpl.WrapMode;
import org.linphone.core.LinphoneFriend.SubscribePolicy;

class LinphoneFriendImpl implements Serializable, LinphoneFriend {
    protected final long nativePtr;
    boolean ownPtr;

    protected LinphoneFriendImpl() {
        this.ownPtr = false;
        this.nativePtr = newLinphoneFriend(null);
    }

    protected LinphoneFriendImpl(long j) {
        this.ownPtr = false;
        this.nativePtr = j;
        this.ownPtr = false;
    }

    protected LinphoneFriendImpl(String str) {
        this.ownPtr = false;
        this.nativePtr = newLinphoneFriend(str);
    }

    private native void delete(long j);

    private native void done(long j);

    private native void edit(long j);

    private native void enableSubscribes(long j, boolean z);

    private native long getAddress(long j);

    private native Object getCore(long j);

    private native int getIncSubscribePolicy(long j);

    private native Object getPresenceModel(long j);

    private native int getStatus(long j);

    private Object getSyncObject() {
        Object core = getCore(this.nativePtr);
        return core != null ? core : this;
    }

    private native boolean isSubscribesEnabled(long j);

    private native long newLinphoneFriend(String str);

    private native void setAddress(long j, long j2);

    private native void setIncSubscribePolicy(long j, int i);

    private native void setPresenceModel(long j, long j2);

    public void done() {
        synchronized (getSyncObject()) {
            done(this.nativePtr);
        }
    }

    public void edit() {
        synchronized (getSyncObject()) {
            edit(this.nativePtr);
        }
    }

    public void enableSubscribes(boolean z) {
        synchronized (getSyncObject()) {
            enableSubscribes(this.nativePtr, z);
        }
    }

    protected void finalize() {
        if (this.ownPtr) {
            delete(this.nativePtr);
        }
    }

    public LinphoneAddress getAddress() {
        return new LinphoneAddressImpl(getAddress(this.nativePtr), WrapMode.FromConst);
    }

    public SubscribePolicy getIncSubscribePolicy() {
        return SubscribePolicy.fromInt(getIncSubscribePolicy(this.nativePtr));
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public PresenceModel getPresenceModel() {
        return (PresenceModel) getPresenceModel(this.nativePtr);
    }

    public OnlineStatus getStatus() {
        return OnlineStatus.fromInt(getStatus(this.nativePtr));
    }

    public boolean isSubscribesEnabled() {
        return isSubscribesEnabled(this.nativePtr);
    }

    public void setAddress(LinphoneAddress linphoneAddress) {
        setAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
    }

    public void setIncSubscribePolicy(SubscribePolicy subscribePolicy) {
        synchronized (getSyncObject()) {
            setIncSubscribePolicy(this.nativePtr, subscribePolicy.mValue);
        }
    }
}
