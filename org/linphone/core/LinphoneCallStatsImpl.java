package org.linphone.core;

import org.linphone.core.LinphoneCallStats.IceState;
import org.linphone.core.LinphoneCallStats.MediaType;

class LinphoneCallStatsImpl implements LinphoneCallStats {
    private float downloadBandwidth;
    private int iceState;
    private float jitterBufferSize;
    private long latePacketsCumulativeNumber;
    private float localLateRate;
    private float localLossRate;
    private int mediaType;
    private long nativePtr;
    private float receiverInterarrivalJitter;
    private float receiverLossRate;
    private float roundTripDelay;
    private float senderInterarrivalJitter;
    private float senderLossRate;
    private float uploadBandwidth;

    protected LinphoneCallStatsImpl(long j, long j2) {
        this.nativePtr = j2;
        this.mediaType = getMediaType(j2);
        this.iceState = getIceState(j2);
        this.downloadBandwidth = getDownloadBandwidth(j2);
        this.uploadBandwidth = getUploadBandwidth(j2);
        this.senderLossRate = getSenderLossRate(j2);
        this.receiverLossRate = getReceiverLossRate(j2);
        this.senderInterarrivalJitter = getSenderInterarrivalJitter(j2, j);
        this.receiverInterarrivalJitter = getReceiverInterarrivalJitter(j2, j);
        this.roundTripDelay = getRoundTripDelay(j2);
        this.latePacketsCumulativeNumber = getLatePacketsCumulativeNumber(j2, j);
        this.jitterBufferSize = getJitterBufferSize(j2);
    }

    private native float getDownloadBandwidth(long j);

    private native int getIceState(long j);

    private native float getJitterBufferSize(long j);

    private native long getLatePacketsCumulativeNumber(long j, long j2);

    private native float getLocalLateRate(long j);

    private native float getLocalLossRate(long j);

    private native int getMediaType(long j);

    private native float getReceiverInterarrivalJitter(long j, long j2);

    private native float getReceiverLossRate(long j);

    private native float getRoundTripDelay(long j);

    private native float getSenderInterarrivalJitter(long j, long j2);

    private native float getSenderLossRate(long j);

    private native float getUploadBandwidth(long j);

    private native void updateStats(long j, int i);

    public float getDownloadBandwidth() {
        return this.downloadBandwidth;
    }

    public IceState getIceState() {
        return IceState.fromInt(this.iceState);
    }

    public float getJitterBufferSize() {
        return this.jitterBufferSize;
    }

    public long getLatePacketsCumulativeNumber() {
        return this.latePacketsCumulativeNumber;
    }

    public float getLocalLateRate() {
        return this.localLateRate;
    }

    public float getLocalLossRate() {
        return this.localLossRate;
    }

    public MediaType getMediaType() {
        return MediaType.fromInt(this.mediaType);
    }

    public float getReceiverInterarrivalJitter() {
        return this.receiverInterarrivalJitter;
    }

    public float getReceiverLossRate() {
        return this.receiverLossRate;
    }

    public float getRoundTripDelay() {
        return this.roundTripDelay;
    }

    public float getSenderInterarrivalJitter() {
        return this.senderInterarrivalJitter;
    }

    public float getSenderLossRate() {
        return this.senderLossRate;
    }

    public float getUploadBandwidth() {
        return this.uploadBandwidth;
    }

    protected void updateRealTimeStats(LinphoneCall linphoneCall) {
        updateStats(((LinphoneCallImpl) linphoneCall).nativePtr, this.mediaType);
        this.localLossRate = getLocalLossRate(this.nativePtr);
        this.localLateRate = getLocalLateRate(this.nativePtr);
    }
}
