package org.linphone.core;

import org.linphone.core.LinphoneCore.MediaEncryption;

public class LinphoneCallParamsImpl implements LinphoneCallParams {
    protected final long nativePtr;

    public LinphoneCallParamsImpl(long j) {
        this.nativePtr = j;
    }

    private native void addCustomHeader(long j, String str, String str2);

    private native void audioBandwidth(long j, int i);

    private native void destroy(long j);

    private native void enableLowBandwidth(long j, boolean z);

    private native void enableVideo(long j, boolean z);

    private native String getCustomHeader(long j, String str);

    private native int getMediaEncryption(long j);

    private native int getPrivacy(long j);

    private native String getSessionName(long j);

    private native long getUsedAudioCodec(long j);

    private native long getUsedVideoCodec(long j);

    private native boolean getVideoEnabled(long j);

    private native boolean isLowBandwidthEnabled(long j);

    private native boolean localConferenceMode(long j);

    private native void setMediaEncryption(long j, int i);

    private native void setPrivacy(long j, int i);

    private native void setRecordFile(long j, String str);

    private native void setSessionName(long j, String str);

    public void addCustomHeader(String str, String str2) {
        addCustomHeader(this.nativePtr, str, str2);
    }

    public void enableLowBandwidth(boolean z) {
        enableLowBandwidth(this.nativePtr, z);
    }

    protected void finalize() {
        destroy(this.nativePtr);
        super.finalize();
    }

    public String getCustomHeader(String str) {
        return getCustomHeader(this.nativePtr, str);
    }

    public MediaEncryption getMediaEncryption() {
        return MediaEncryption.fromInt(getMediaEncryption(this.nativePtr));
    }

    public int getPrivacy() {
        return getPrivacy(this.nativePtr);
    }

    public String getSessionName() {
        return getSessionName(this.nativePtr);
    }

    public PayloadType getUsedAudioCodec() {
        long usedAudioCodec = getUsedAudioCodec(this.nativePtr);
        return usedAudioCodec == 0 ? null : new PayloadTypeImpl(usedAudioCodec);
    }

    public PayloadType getUsedVideoCodec() {
        long usedVideoCodec = getUsedVideoCodec(this.nativePtr);
        return usedVideoCodec == 0 ? null : new PayloadTypeImpl(usedVideoCodec);
    }

    public boolean getVideoEnabled() {
        return getVideoEnabled(this.nativePtr);
    }

    public boolean isLowBandwidthEnabled() {
        return isLowBandwidthEnabled(this.nativePtr);
    }

    public boolean localConferenceMode() {
        return localConferenceMode(this.nativePtr);
    }

    public void setAudioBandwidth(int i) {
        audioBandwidth(this.nativePtr, i);
    }

    public void setMediaEnctyption(MediaEncryption mediaEncryption) {
        setMediaEncryption(this.nativePtr, mediaEncryption.mValue);
    }

    public void setPrivacy(int i) {
        setPrivacy(this.nativePtr, i);
    }

    public void setRecordFile(String str) {
        setRecordFile(this.nativePtr, str);
    }

    public void setSessionName(String str) {
        setSessionName(this.nativePtr, str);
    }

    public void setVideoEnabled(boolean z) {
        enableVideo(this.nativePtr, z);
    }
}
