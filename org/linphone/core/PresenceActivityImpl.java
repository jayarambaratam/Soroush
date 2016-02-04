package org.linphone.core;

public class PresenceActivityImpl implements PresenceActivity {
    private long mNativePtr;

    protected PresenceActivityImpl(long j) {
        this.mNativePtr = j;
    }

    protected PresenceActivityImpl(PresenceActivityType presenceActivityType, String str) {
        this.mNativePtr = newPresenceActivityImpl(presenceActivityType.toInt(), str);
    }

    private native String getDescription(long j);

    private native int getType(long j);

    private native long newPresenceActivityImpl(int i, String str);

    private native int setDescription(long j, String str);

    private native int setType(long j, int i);

    private native String toString(long j);

    private native void unref(long j);

    protected void finalize() {
        unref(this.mNativePtr);
    }

    public String getDescription() {
        return getDescription(this.mNativePtr);
    }

    public long getNativePtr() {
        return this.mNativePtr;
    }

    public PresenceActivityType getType() {
        return PresenceActivityType.fromInt(getType(this.mNativePtr));
    }

    public int setDescription(String str) {
        return setDescription(this.mNativePtr, str);
    }

    public int setType(PresenceActivityType presenceActivityType) {
        return setType(this.mNativePtr, presenceActivityType.toInt());
    }

    public String toString() {
        return toString(this.mNativePtr);
    }
}
