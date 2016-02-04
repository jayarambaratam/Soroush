package org.linphone.core;

import org.linphone.core.LinphoneAddress.TransportType;
import org.linphone.mediastream.Version;

public class LinphoneAddressImpl implements LinphoneAddress {
    protected final long nativePtr;

    /* renamed from: org.linphone.core.LinphoneAddressImpl.1 */
    /* synthetic */ class C28051 {
        static final /* synthetic */ int[] $SwitchMap$org$linphone$core$LinphoneAddressImpl$WrapMode;

        static {
            $SwitchMap$org$linphone$core$LinphoneAddressImpl$WrapMode = new int[WrapMode.values().length];
            try {
                $SwitchMap$org$linphone$core$LinphoneAddressImpl$WrapMode[WrapMode.FromNew.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$linphone$core$LinphoneAddressImpl$WrapMode[WrapMode.FromConst.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$linphone$core$LinphoneAddressImpl$WrapMode[WrapMode.FromExisting.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum WrapMode {
        FromNew,
        FromConst,
        FromExisting
    }

    private LinphoneAddressImpl(long j) {
        this(j, WrapMode.FromConst);
    }

    protected LinphoneAddressImpl(long j, WrapMode wrapMode) {
        switch (C28051.$SwitchMap$org$linphone$core$LinphoneAddressImpl$WrapMode[wrapMode.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.nativePtr = j;
            case VideoSize.HVGA /*2*/:
                this.nativePtr = clone(j);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.nativePtr = ref(j);
            default:
                this.nativePtr = 0;
        }
    }

    protected LinphoneAddressImpl(String str) {
        this.nativePtr = newLinphoneAddressImpl(str, null);
        if (this.nativePtr == 0) {
            throw new LinphoneCoreException("Cannot create LinphoneAdress from [" + str + "]");
        }
    }

    protected LinphoneAddressImpl(String str, String str2, String str3) {
        this.nativePtr = newLinphoneAddressImpl(null, str3);
        setUserName(str);
        setDomain(str2);
    }

    private native long clone(long j);

    private native String getDisplayName(long j);

    private native String getDomain(long j);

    private native int getTransport(long j);

    private native String getUserName(long j);

    private native long newLinphoneAddressImpl(String str, String str2);

    private native long ref(long j);

    private native void setDisplayName(long j, String str);

    private native void setDomain(long j, String str);

    private native void setTransport(long j, int i);

    private native void setUserName(long j, String str);

    private native String toString(long j);

    private native String toUri(long j);

    private native void unref(long j);

    public String asString() {
        return toString();
    }

    public String asStringUriOnly() {
        return toUri(this.nativePtr);
    }

    public void clean() {
        throw new RuntimeException("Not implemented");
    }

    protected void finalize() {
        if (this.nativePtr != 0) {
            unref(this.nativePtr);
        }
    }

    public String getDisplayName() {
        return getDisplayName(this.nativePtr);
    }

    public String getDomain() {
        return getDomain(this.nativePtr);
    }

    public String getPort() {
        return String.valueOf(getPortInt());
    }

    public int getPortInt() {
        return getPortInt();
    }

    public TransportType getTransport() {
        return TransportType.fromInt(getTransport(this.nativePtr));
    }

    public String getUserName() {
        return getUserName(this.nativePtr);
    }

    public void setDisplayName(String str) {
        setDisplayName(this.nativePtr, str);
    }

    public void setDomain(String str) {
        setDomain(this.nativePtr, str);
    }

    public void setPort(String str) {
        throw new RuntimeException("Not implemented");
    }

    public void setPortInt(int i) {
        throw new RuntimeException("Not implemented");
    }

    public void setTransport(TransportType transportType) {
        setTransport(this.nativePtr, transportType.toInt());
    }

    public void setUserName(String str) {
        setUserName(this.nativePtr, str);
    }

    public String toString() {
        return toString(this.nativePtr);
    }

    public String toUri() {
        return toUri(this.nativePtr);
    }
}
