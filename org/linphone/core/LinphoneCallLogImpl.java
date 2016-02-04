package org.linphone.core;

import org.linphone.core.LinphoneAddressImpl.WrapMode;
import org.linphone.core.LinphoneCallLog.CallStatus;

class LinphoneCallLogImpl implements LinphoneCallLog {
    protected final long nativePtr;

    LinphoneCallLogImpl(long j) {
        this.nativePtr = j;
    }

    private native int getCallDuration(long j);

    private native int getCallId(long j);

    private native long getFrom(long j);

    private native String getStartDate(long j);

    private native int getStatus(long j);

    private native long getTimestamp(long j);

    private native long getTo(long j);

    private native boolean isIncoming(long j);

    public int getCallDuration() {
        return getCallDuration(this.nativePtr);
    }

    public int getCallId() {
        return getCallId(this.nativePtr);
    }

    public CallDirection getDirection() {
        return isIncoming(this.nativePtr) ? CallDirection.Incoming : CallDirection.Outgoing;
    }

    public LinphoneAddress getFrom() {
        return new LinphoneAddressImpl(getFrom(this.nativePtr), WrapMode.FromExisting);
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public String getStartDate() {
        return getStartDate(this.nativePtr);
    }

    public CallStatus getStatus() {
        return CallStatus.fromInt(getStatus(this.nativePtr));
    }

    public long getTimestamp() {
        return getTimestamp(this.nativePtr) * 1000;
    }

    public LinphoneAddress getTo() {
        return new LinphoneAddressImpl(getTo(this.nativePtr), WrapMode.FromExisting);
    }
}
