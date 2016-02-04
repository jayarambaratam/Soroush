package org.linphone.core;

import org.linphone.core.LinphoneAddressImpl.WrapMode;
import org.linphone.core.LinphoneChatMessage.State;
import org.linphone.core.LinphoneChatMessage.StateListener;

class LinphoneChatRoomImpl implements LinphoneChatRoom {
    protected final long nativePtr;

    protected LinphoneChatRoomImpl(long j) {
        this.nativePtr = j;
    }

    private native void compose(long j);

    private native long createLinphoneChatMessage(long j, String str);

    private native long createLinphoneChatMessage2(long j, String str, String str2, int i, long j2, boolean z, boolean z2);

    private native void deleteHistory(long j);

    private native void deleteMessage(long j, long j2);

    private native void destroy(long j);

    private native long[] getHistory(long j, int i);

    private native long getPeerAddress(long j);

    private native int getUnreadMessagesCount(long j);

    private native boolean isRemoteComposing(long j);

    private native void markAsRead(long j);

    private native void sendMessage(long j, String str);

    private native void sendMessage2(long j, long j2, StateListener stateListener);

    private native void updateUrl(long j, long j2);

    public void compose() {
        compose(this.nativePtr);
    }

    public LinphoneChatMessage createLinphoneChatMessage(String str) {
        return new LinphoneChatMessageImpl(createLinphoneChatMessage(this.nativePtr, str));
    }

    public LinphoneChatMessage createLinphoneChatMessage(String str, String str2, State state, long j, boolean z, boolean z2) {
        return new LinphoneChatMessageImpl(createLinphoneChatMessage2(this.nativePtr, str, str2, state.value(), j / 1000, z, z2));
    }

    public void deleteHistory() {
        deleteHistory(this.nativePtr);
    }

    public void deleteMessage(LinphoneChatMessage linphoneChatMessage) {
        if (linphoneChatMessage != null) {
            deleteMessage(this.nativePtr, linphoneChatMessage.getNativePtr());
        }
    }

    public void destroy() {
        destroy(this.nativePtr);
    }

    public LinphoneChatMessage[] getHistory() {
        return getHistory(0);
    }

    public LinphoneChatMessage[] getHistory(int i) {
        long[] history = getHistory(this.nativePtr, i);
        if (history == null) {
            return null;
        }
        LinphoneChatMessage[] linphoneChatMessageArr = new LinphoneChatMessage[history.length];
        for (int i2 = 0; i2 < linphoneChatMessageArr.length; i2++) {
            linphoneChatMessageArr[i2] = new LinphoneChatMessageImpl(history[i2]);
        }
        return linphoneChatMessageArr;
    }

    public LinphoneAddress getPeerAddress() {
        return new LinphoneAddressImpl(getPeerAddress(this.nativePtr), WrapMode.FromConst);
    }

    public int getUnreadMessagesCount() {
        return getUnreadMessagesCount(this.nativePtr);
    }

    public boolean isRemoteComposing() {
        return isRemoteComposing(this.nativePtr);
    }

    public void markAsRead() {
        markAsRead(this.nativePtr);
    }

    public void sendMessage(String str) {
        sendMessage(this.nativePtr, str);
    }

    public void sendMessage(LinphoneChatMessage linphoneChatMessage, StateListener stateListener) {
        sendMessage2(this.nativePtr, linphoneChatMessage.getNativePtr(), stateListener);
    }

    public void updateUrl(LinphoneChatMessage linphoneChatMessage) {
        if (linphoneChatMessage != null) {
            updateUrl(this.nativePtr, linphoneChatMessage.getNativePtr());
        }
    }
}
