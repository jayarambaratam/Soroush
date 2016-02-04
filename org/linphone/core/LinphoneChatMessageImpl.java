package org.linphone.core;

import org.linphone.core.LinphoneAddressImpl.WrapMode;
import org.linphone.core.LinphoneChatMessage.State;

public class LinphoneChatMessageImpl implements LinphoneChatMessage {
    protected final long nativePtr;

    protected LinphoneChatMessageImpl(long j) {
        this.nativePtr = j;
        setUserData();
    }

    private native void addCustomHeader(long j, String str, String str2);

    private native String getCustomHeader(long j, String str);

    private native String getExternalBodyUrl(long j);

    private native long getFrom(long j);

    private native long getPeerAddress(long j);

    private native int getReason(long j);

    private native int getStatus(long j);

    private native int getStorageId(long j);

    private native String getText(long j);

    private native long getTime(long j);

    private native boolean isOutgoing(long j);

    private native boolean isRead(long j);

    private native void setExternalBodyUrl(long j, String str);

    private native void setUserData(long j);

    private native void store(long j);

    public void addCustomHeader(String str, String str2) {
        addCustomHeader(this.nativePtr, str, str2);
    }

    public String getCustomHeader(String str) {
        return getCustomHeader(this.nativePtr, str);
    }

    public String getExternalBodyUrl() {
        return getExternalBodyUrl(this.nativePtr);
    }

    public LinphoneAddress getFrom() {
        return new LinphoneAddressImpl(getFrom(this.nativePtr), WrapMode.FromConst);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public LinphoneAddress getPeerAddress() {
        return new LinphoneAddressImpl(getPeerAddress(this.nativePtr), WrapMode.FromConst);
    }

    public Reason getReason() {
        return Reason.fromInt(getReason(this.nativePtr));
    }

    public State getStatus() {
        return State.fromInt(getStatus(this.nativePtr));
    }

    public int getStorageId() {
        return getStorageId(this.nativePtr);
    }

    public String getText() {
        return getText(this.nativePtr);
    }

    public long getTime() {
        return getTime(this.nativePtr) * 1000;
    }

    public Object getUserData() {
        return null;
    }

    public boolean isOutgoing() {
        return isOutgoing(this.nativePtr);
    }

    public boolean isRead() {
        return isRead(this.nativePtr);
    }

    public void setExternalBodyUrl(String str) {
        setExternalBodyUrl(this.nativePtr, str);
    }

    public void setUserData() {
        setUserData(this.nativePtr);
    }

    public void store() {
        store(this.nativePtr);
    }
}
