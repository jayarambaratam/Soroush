package org.linphone.core;

import android.content.Context;
import android.media.AudioManager;
import java.io.File;
import org.linphone.core.LinphoneAddressImpl.WrapMode;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCore.FirewallPolicy;
import org.linphone.core.LinphoneCore.MediaEncryption;
import org.linphone.core.LinphoneCore.Transports;
import org.linphone.core.LinphoneCore.UpnpState;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.video.capture.hwconf.Hacks;

class LinphoneCoreImpl implements LinphoneCore {
    static int FIND_PAYLOAD_IGNORE_CHANNELS;
    static int FIND_PAYLOAD_IGNORE_RATE;
    private AudioManager mAudioManager;
    private Context mContext;
    private final LinphoneCoreListener mListener;
    private boolean mSpeakerEnabled;
    private long nativePtr;

    static {
        FIND_PAYLOAD_IGNORE_RATE = -1;
        FIND_PAYLOAD_IGNORE_CHANNELS = -1;
    }

    LinphoneCoreImpl(LinphoneCoreListener linphoneCoreListener) {
        this.nativePtr = 0;
        this.mContext = null;
        this.mAudioManager = null;
        this.mSpeakerEnabled = false;
        this.mListener = linphoneCoreListener;
        this.nativePtr = newLinphoneCore(linphoneCoreListener, null, null, null);
    }

    LinphoneCoreImpl(LinphoneCoreListener linphoneCoreListener, File file, File file2, Object obj) {
        String str = null;
        this.nativePtr = 0;
        this.mContext = null;
        this.mAudioManager = null;
        this.mSpeakerEnabled = false;
        this.mListener = linphoneCoreListener;
        String canonicalPath = file == null ? null : file.getCanonicalPath();
        if (file2 != null) {
            str = file2.getCanonicalPath();
        }
        this.nativePtr = newLinphoneCore(linphoneCoreListener, canonicalPath, str, obj);
    }

    private native void acceptCall(long j, long j2);

    private native void acceptCallUpdate(long j, long j2, long j3);

    private native void acceptCallWithParams(long j, long j2, long j3);

    private native void addAllToConference(long j);

    private native void addAuthInfo(long j, long j2);

    private native void addFriend(long j, long j2);

    private native int addProxyConfig(LinphoneProxyConfig linphoneProxyConfig, long j, long j2);

    private native void addToConference(long j, long j2);

    private void applyAudioHacks() {
        if (Hacks.needGalaxySAudioHack()) {
            setMicrophoneGain(-9.0f);
        }
    }

    private native void clearAuthInfos(long j);

    private native void clearCallLogs(long j);

    private native void clearProxyConfigs(long j);

    private boolean contextInitialized() {
        if (this.mContext != null) {
            return true;
        }
        Log.m11091e("Context of LinphoneCore has not been initialized, call setContext() after creating LinphoneCore.");
        return false;
    }

    private native long createDefaultCallParams(long j);

    private native long createInfoMessage(long j);

    private native void declineCall(long j, long j2, int i);

    private native void deferCallUpdate(long j, long j2);

    private native void delete(long j);

    private native void enableEchoCancellation(long j, boolean z);

    private native void enableEchoLimiter(long j, boolean z);

    private native void enableIpv6(long j, boolean z);

    private native void enableKeepAlive(long j, boolean z);

    private native int enablePayloadType(long j, long j2, boolean z);

    private native void enableVideo(long j, boolean z, boolean z2);

    private native boolean enterConference(long j);

    private native long findAuthInfos(long j, String str, String str2, String str3);

    private native Object findCallFromUri(long j, String str);

    private native long findPayloadType(long j, String str, int i, int i2);

    private native void forceSpeakerState(long j, boolean z);

    private native int getAudioDscp(long j);

    private native long[] getAuthInfosList(long j);

    private native Object getCall(long j, int i);

    private native long getCallLog(long j, int i);

    private long getCallParamsPtr(LinphoneCallParams linphoneCallParams) {
        return ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr;
    }

    private long getCallPtr(LinphoneCall linphoneCall) {
        return ((LinphoneCallImpl) linphoneCall).nativePtr;
    }

    private native int getCallsNb(long j);

    private native long[] getChatRooms(long j);

    private native int getConferenceSize(long j);

    private native long getConfig(long j);

    private native Object getCurrentCall(long j);

    private native long getDefaultProxyConfig(long j);

    private native int getFirewallPolicy(long j);

    private native long getFriendByAddress(long j, String str);

    private native int getMaxCalls(long j);

    private native int getMediaEncryption(long j);

    private native int getMissedCallsCount(long j);

    private native int getNumberOfCallLogs(long j);

    private native long getOrCreateChatRoom(long j, String str);

    private native float getPlaybackGain(long j);

    private native int[] getPreferredVideoSize(long j);

    private native int getPresenceInfo(long j);

    private native Object getPresenceModel(long j);

    private native String getPrimaryContactDisplayName(long j);

    private native String getPrimaryContactUsername(long j);

    private native long[] getProxyConfigList(long j);

    private native long getRemoteAddress(long j);

    private native String getRing(long j);

    private native int getSignalingTransportPort(long j, int i);

    private native int getSipDscp(long j);

    private native String getStunServer(long j);

    private native String getUpnpExternalIpaddress(long j);

    private native int getUpnpState(long j);

    private native boolean getUseRfc2833ForDtmfs(long j);

    private native boolean getUseSipInfoForDtmfs(long j);

    private native String getVersion(long j);

    private native boolean getVideoAutoAcceptPolicy(long j);

    private native boolean getVideoAutoInitiatePolicy(long j);

    private native int getVideoDevice(long j);

    private native int getVideoDscp(long j);

    private native long interpretUrl(long j, String str);

    private native Object invite(long j, String str);

    private native Object inviteAddress(long j, long j2);

    private native Object inviteAddressWithParams(long j, long j2, long j3);

    private native boolean isEchoCancellationEnabled(long j);

    private native boolean isEchoLimiterEnabled(long j);

    private native boolean isInCall(long j);

    private native boolean isInComingInvitePending(long j);

    private native boolean isInConference(long j);

    private native boolean isIpv6Enabled(long j);

    private native boolean isKeepAliveEnabled(long j);

    private native boolean isMediaEncryptionMandatory(long j);

    private native boolean isMicMuted(long j);

    private native boolean isNetworkStateReachable(long j);

    private native boolean isPayloadTypeEnabled(long j, long j2);

    private void isValid() {
        if (this.nativePtr == 0) {
            throw new RuntimeException("object already destroyed");
        }
    }

    private native boolean isVideoEnabled(long j);

    private native boolean isVideoSupported(long j);

    private native void iterate(long j);

    private native void leaveConference(long j);

    private native long[] listAudioPayloadTypes(long j);

    private native String[] listSupportedVideoResolutions(long j);

    private native long[] listVideoPayloadTypes(long j);

    private native boolean mediaEncryptionSupported(long j, int i);

    private native int migrateToMultiTransport(long j);

    private native void muteMic(long j, boolean z);

    private native boolean needsEchoCalibration(long j);

    private native long newLinphoneCore(LinphoneCoreListener linphoneCoreListener, String str, String str2, Object obj);

    private native int pauseAllCalls(long j);

    private native int pauseCall(long j, long j2);

    private native void playDtmf(long j, char c, int i);

    private native Object publish(long j, long j2, String str, int i, String str2, String str3, byte[] bArr, String str4);

    private native void refreshRegisters(long j);

    private native void removeAuthInfo(long j, long j2);

    private native void removeCallLog(long j, long j2);

    private native void removeFriend(long j, long j2);

    private native void removeFromConference(long j, long j2);

    private native void removeProxyConfig(long j, long j2);

    private native void resetMissedCallsCount(long j);

    private native int resumeCall(long j, long j2);

    private native void sendDtmf(long j, char c);

    private native void setAudioDscp(long j, int i);

    private void setAudioModeIncallForGalaxyS() {
        if (contextInitialized()) {
            this.mAudioManager.setMode(2);
        }
    }

    private native void setAudioPort(long j, int i);

    private native void setAudioPortRange(long j, int i, int i2);

    private native void setChatDatabasePath(long j, String str);

    private native void setCpuCountNative(int i);

    private native void setDefaultProxyConfig(long j, long j2);

    private native void setDeviceRotation(long j, int i);

    private native void setDownloadBandwidth(long j, int i);

    private native void setDownloadPtime(long j, int i);

    private native void setFirewallPolicy(long j, int i);

    private native void setInCallTimeout(long j, int i);

    private native void setIncomingTimeout(long j, int i);

    private native void setMaxCalls(long j, int i);

    private native void setMediaEncryption(long j, int i);

    private native void setMediaEncryptionMandatory(long j, boolean z);

    private native void setMicrophoneGain(long j, float f);

    private native void setNetworkStateReachable(long j, boolean z);

    private native void setPlayFile(long j, String str);

    private native void setPlaybackGain(long j, float f);

    private native void setPreferredVideoSize(long j, int i, int i2);

    private native void setPreferredVideoSizeByName(long j, String str);

    private native void setPresenceInfo(long j, int i, String str, int i2);

    private native void setPresenceModel(long j, long j2);

    private native void setPreviewWindowId(long j, Object obj);

    private native void setPrimaryContact(long j, String str, String str2);

    private native void setRing(long j, String str);

    private native void setRootCA(long j, String str);

    private native void setSignalingTransportPorts(long j, int i, int i2, int i3);

    private native void setSipDscp(long j, int i);

    private native void setStaticPicture(long j, String str);

    private native void setStunServer(long j, String str);

    private native void setUploadBandwidth(long j, int i);

    private native void setUploadPtime(long j, int i);

    private native void setUseRfc2833ForDtmfs(long j, boolean z);

    private native void setUseSipInfoForDtmfs(long j, boolean z);

    private native void setUserAgent(long j, String str, String str2);

    private native int setVideoDevice(long j, int i);

    private native void setVideoDscp(long j, int i);

    private native void setVideoPolicy(long j, boolean z, boolean z2);

    private native void setVideoPort(long j, int i);

    private native void setVideoPortRange(long j, int i, int i2);

    private native void setVideoWindowId(long j, Object obj);

    private native void setZrtpSecretsCache(long j, String str);

    private native boolean soundResourcesLocked(long j);

    private native int startConferenceRecording(long j, String str);

    private native int startEchoCalibration(long j, Object obj);

    private native LinphoneCall startReferedCall(long j, long j2, long j3);

    private native int stopConferenceRecording(long j);

    private native void stopDtmf(long j);

    private native Object subscribe(long j, long j2, String str, int i, String str2, String str3, byte[] bArr, String str4);

    private native void terminateAllCalls(long j);

    private native void terminateCall(long j, long j2);

    private native void terminateConference(long j);

    private native int transferCall(long j, long j2, String str);

    private native int transferCallToAnother(long j, long j2, long j3);

    private native void tunnelAddServerAndMirror(long j, String str, int i, int i2, int i3);

    private native void tunnelAutoDetect(long j);

    private native void tunnelCleanServers(long j);

    private native void tunnelEnable(long j, boolean z);

    private native void tunnelSetHttpProxy(long j, String str, int i, String str2, String str3);

    private native int updateCall(long j, long j2, long j3);

    private native boolean upnpAvailable(long j);

    public synchronized void acceptCall(LinphoneCall linphoneCall) {
        isValid();
        acceptCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr);
    }

    public synchronized void acceptCallUpdate(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        acceptCallUpdate(this.nativePtr, getCallPtr(linphoneCall), getCallParamsPtr(linphoneCallParams));
    }

    public synchronized void acceptCallWithParams(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        acceptCallWithParams(this.nativePtr, getCallPtr(linphoneCall), getCallParamsPtr(linphoneCallParams));
    }

    public synchronized void addAllToConference() {
        addAllToConference(this.nativePtr);
    }

    public synchronized void addAuthInfo(LinphoneAuthInfo linphoneAuthInfo) {
        isValid();
        addAuthInfo(this.nativePtr, ((LinphoneAuthInfoImpl) linphoneAuthInfo).nativePtr);
    }

    public synchronized void addFriend(LinphoneFriend linphoneFriend) {
        addFriend(this.nativePtr, ((LinphoneFriendImpl) linphoneFriend).nativePtr);
    }

    public synchronized void addProxyConfig(LinphoneProxyConfig linphoneProxyConfig) {
        isValid();
        if (addProxyConfig(linphoneProxyConfig, this.nativePtr, ((LinphoneProxyConfigImpl) linphoneProxyConfig).nativePtr) != 0) {
            throw new LinphoneCoreException("bad proxy config");
        }
    }

    public synchronized void addToConference(LinphoneCall linphoneCall) {
        addToConference(this.nativePtr, getCallPtr(linphoneCall));
    }

    public synchronized void adjustSoftwareVolume(int i) {
    }

    public synchronized void clearAuthInfos() {
        isValid();
        clearAuthInfos(this.nativePtr);
    }

    public synchronized void clearCallLogs() {
        clearCallLogs(this.nativePtr);
    }

    public synchronized void clearProxyConfigs() {
        isValid();
        clearProxyConfigs(this.nativePtr);
    }

    public synchronized LinphoneCallParams createDefaultCallParameters() {
        return new LinphoneCallParamsImpl(createDefaultCallParams(this.nativePtr));
    }

    public LinphoneInfoMessage createInfoMessage() {
        return new LinphoneInfoMessageImpl(createInfoMessage(this.nativePtr));
    }

    public synchronized void declineCall(LinphoneCall linphoneCall, Reason reason) {
        declineCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr, reason.mValue);
    }

    public synchronized void deferCallUpdate(LinphoneCall linphoneCall) {
        deferCallUpdate(this.nativePtr, getCallPtr(linphoneCall));
    }

    public synchronized void destroy() {
        isValid();
        delete(this.nativePtr);
        this.nativePtr = 0;
    }

    public synchronized void enableEchoCancellation(boolean z) {
        isValid();
        enableEchoCancellation(this.nativePtr, z);
    }

    public synchronized void enableEchoLimiter(boolean z) {
        enableEchoLimiter(this.nativePtr, z);
    }

    public synchronized void enableIpv6(boolean z) {
        enableIpv6(this.nativePtr, z);
    }

    public synchronized void enableKeepAlive(boolean z) {
        enableKeepAlive(this.nativePtr, z);
    }

    public synchronized void enablePayloadType(PayloadType payloadType, boolean z) {
        isValid();
        if (enablePayloadType(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr, z) != 0) {
            throw new LinphoneCoreException("cannot enable payload type [" + payloadType + "]");
        }
    }

    public void enableSpeaker(boolean z) {
        LinphoneCall currentCall = getCurrentCall();
        this.mSpeakerEnabled = z;
        applyAudioHacks();
        if (currentCall != null && currentCall.getState() == State.StreamsRunning && Hacks.needGalaxySAudioHack()) {
            Log.m11089d("Hack to have speaker=", Boolean.valueOf(z), " while on call");
            forceSpeakerState(this.nativePtr, z);
            return;
        }
        routeAudioToSpeakerHelper(z);
    }

    public synchronized void enableVideo(boolean z, boolean z2) {
        enableVideo(this.nativePtr, z, z2);
    }

    public synchronized boolean enterConference() {
        return enterConference(this.nativePtr);
    }

    protected void finalize() {
    }

    public LinphoneAuthInfo findAuthInfo(String str, String str2, String str3) {
        long findAuthInfos = findAuthInfos(this.nativePtr, str, str2, str3);
        return findAuthInfos == 0 ? null : new LinphoneAuthInfoImpl(findAuthInfos);
    }

    public synchronized LinphoneCall findCallFromUri(String str) {
        return (LinphoneCall) findCallFromUri(this.nativePtr, str);
    }

    public synchronized LinphoneFriend findFriendByAddress(String str) {
        long friendByAddress;
        friendByAddress = getFriendByAddress(this.nativePtr, str);
        return friendByAddress == 0 ? null : new LinphoneFriendImpl(friendByAddress);
    }

    public PayloadType findPayloadType(String str) {
        return findPayloadType(str, FIND_PAYLOAD_IGNORE_RATE);
    }

    public synchronized PayloadType findPayloadType(String str, int i) {
        return findPayloadType(str, i, FIND_PAYLOAD_IGNORE_CHANNELS);
    }

    public synchronized PayloadType findPayloadType(String str, int i, int i2) {
        long findPayloadType;
        isValid();
        findPayloadType = findPayloadType(this.nativePtr, str, i, i2);
        return findPayloadType == 0 ? null : new PayloadTypeImpl(findPayloadType);
    }

    public synchronized PayloadType[] getAudioCodecs() {
        PayloadType[] payloadTypeArr;
        long[] listAudioPayloadTypes = listAudioPayloadTypes(this.nativePtr);
        if (listAudioPayloadTypes == null) {
            payloadTypeArr = null;
        } else {
            payloadTypeArr = new PayloadType[listAudioPayloadTypes.length];
            for (int i = 0; i < payloadTypeArr.length; i++) {
                payloadTypeArr[i] = new PayloadTypeImpl(listAudioPayloadTypes[i]);
            }
        }
        return payloadTypeArr;
    }

    public int getAudioDscp() {
        return getAudioDscp(this.nativePtr);
    }

    public LinphoneAuthInfo[] getAuthInfosList() {
        long[] authInfosList = getAuthInfosList(this.nativePtr);
        if (authInfosList == null) {
            return null;
        }
        LinphoneAuthInfo[] linphoneAuthInfoArr = new LinphoneAuthInfo[authInfosList.length];
        for (int i = 0; i < linphoneAuthInfoArr.length; i++) {
            linphoneAuthInfoArr[i] = new LinphoneAuthInfoImpl(authInfosList[i]);
        }
        return linphoneAuthInfoArr;
    }

    public synchronized LinphoneCallLog[] getCallLogs() {
        LinphoneCallLog[] linphoneCallLogArr;
        isValid();
        linphoneCallLogArr = new LinphoneCallLog[getNumberOfCallLogs(this.nativePtr)];
        for (int i = 0; i < getNumberOfCallLogs(this.nativePtr); i++) {
            linphoneCallLogArr[i] = new LinphoneCallLogImpl(getCallLog(this.nativePtr, i));
        }
        return linphoneCallLogArr;
    }

    public synchronized LinphoneCall[] getCalls() {
        LinphoneCall[] linphoneCallArr;
        int callsNb = getCallsNb(this.nativePtr);
        linphoneCallArr = new LinphoneCall[callsNb];
        for (int i = 0; i < callsNb; i++) {
            linphoneCallArr[i] = (LinphoneCall) getCall(this.nativePtr, i);
        }
        return linphoneCallArr;
    }

    public synchronized int getCallsNb() {
        return getCallsNb(this.nativePtr);
    }

    public synchronized LinphoneChatRoom[] getChatRooms() {
        LinphoneChatRoom[] linphoneChatRoomArr;
        long[] chatRooms = getChatRooms(this.nativePtr);
        if (chatRooms == null) {
            linphoneChatRoomArr = null;
        } else {
            linphoneChatRoomArr = new LinphoneChatRoom[chatRooms.length];
            for (int i = 0; i < linphoneChatRoomArr.length; i++) {
                linphoneChatRoomArr[i] = new LinphoneChatRoomImpl(chatRooms[i]);
            }
        }
        return linphoneChatRoomArr;
    }

    public synchronized int getConferenceSize() {
        return getConferenceSize(this.nativePtr);
    }

    public synchronized LpConfig getConfig() {
        return new LpConfigImpl(getConfig(this.nativePtr));
    }

    public synchronized LinphoneCall getCurrentCall() {
        isValid();
        return (LinphoneCall) getCurrentCall(this.nativePtr);
    }

    public synchronized LinphoneProxyConfig getDefaultProxyConfig() {
        long defaultProxyConfig;
        isValid();
        defaultProxyConfig = getDefaultProxyConfig(this.nativePtr);
        return defaultProxyConfig != 0 ? new LinphoneProxyConfigImpl(defaultProxyConfig) : null;
    }

    public synchronized FirewallPolicy getFirewallPolicy() {
        return FirewallPolicy.fromInt(getFirewallPolicy(this.nativePtr));
    }

    public synchronized int getMaxCalls() {
        return getMaxCalls(this.nativePtr);
    }

    public synchronized MediaEncryption getMediaEncryption() {
        return MediaEncryption.fromInt(getMediaEncryption(this.nativePtr));
    }

    public synchronized int getMissedCallsCount() {
        return getMissedCallsCount(this.nativePtr);
    }

    public synchronized LinphoneChatRoom getOrCreateChatRoom(String str) {
        return new LinphoneChatRoomImpl(getOrCreateChatRoom(this.nativePtr, str));
    }

    public int getPlayLevel() {
        return 0;
    }

    public synchronized float getPlaybackGain() {
        return getPlaybackGain(this.nativePtr);
    }

    public synchronized VideoSize getPreferredVideoSize() {
        VideoSize videoSize;
        int[] preferredVideoSize = getPreferredVideoSize(this.nativePtr);
        videoSize = new VideoSize();
        videoSize.width = preferredVideoSize[0];
        videoSize.height = preferredVideoSize[1];
        return videoSize;
    }

    public synchronized OnlineStatus getPresenceInfo() {
        return OnlineStatus.fromInt(getPresenceInfo(this.nativePtr));
    }

    public synchronized PresenceModel getPresenceModel() {
        return (PresenceModel) getPresenceModel(this.nativePtr);
    }

    public synchronized String getPrimaryContactDisplayName() {
        return getPrimaryContactDisplayName(this.nativePtr);
    }

    public synchronized String getPrimaryContactUsername() {
        return getPrimaryContactUsername(this.nativePtr);
    }

    public synchronized LinphoneProxyConfig[] getProxyConfigList() {
        LinphoneProxyConfig[] linphoneProxyConfigArr;
        long[] proxyConfigList = getProxyConfigList(this.nativePtr);
        if (proxyConfigList == null) {
            linphoneProxyConfigArr = null;
        } else {
            linphoneProxyConfigArr = new LinphoneProxyConfig[proxyConfigList.length];
            for (int i = 0; i < linphoneProxyConfigArr.length; i++) {
                linphoneProxyConfigArr[i] = new LinphoneProxyConfigImpl(proxyConfigList[i]);
            }
        }
        return linphoneProxyConfigArr;
    }

    public synchronized LinphoneAddress getRemoteAddress() {
        long remoteAddress;
        isValid();
        remoteAddress = getRemoteAddress(this.nativePtr);
        return remoteAddress == 0 ? null : new LinphoneAddressImpl(remoteAddress, WrapMode.FromConst);
    }

    public synchronized String getRing() {
        return getRing(this.nativePtr);
    }

    public synchronized Transports getSignalingTransportPorts() {
        Transports transports;
        transports = new Transports();
        transports.udp = getSignalingTransportPort(this.nativePtr, 0);
        transports.tcp = getSignalingTransportPort(this.nativePtr, 1);
        transports.tls = getSignalingTransportPort(this.nativePtr, 3);
        return transports;
    }

    public int getSipDscp() {
        return getSipDscp(this.nativePtr);
    }

    public synchronized String getStunServer() {
        return getStunServer(this.nativePtr);
    }

    public String[] getSupportedVideoSizes() {
        return listSupportedVideoResolutions(this.nativePtr);
    }

    public String getUpnpExternalIpaddress() {
        return getUpnpExternalIpaddress(this.nativePtr);
    }

    public UpnpState getUpnpState() {
        return UpnpState.fromInt(getUpnpState(this.nativePtr));
    }

    public synchronized boolean getUseRfc2833ForDtmfs() {
        return getUseRfc2833ForDtmfs(this.nativePtr);
    }

    public synchronized boolean getUseSipInfoForDtmfs() {
        return getUseSipInfoForDtmfs(this.nativePtr);
    }

    public String getVersion() {
        return getVersion(this.nativePtr);
    }

    public synchronized boolean getVideoAutoAcceptPolicy() {
        return getVideoAutoAcceptPolicy(this.nativePtr);
    }

    public synchronized boolean getVideoAutoInitiatePolicy() {
        return getVideoAutoInitiatePolicy(this.nativePtr);
    }

    public synchronized PayloadType[] getVideoCodecs() {
        PayloadType[] payloadTypeArr;
        long[] listVideoPayloadTypes = listVideoPayloadTypes(this.nativePtr);
        if (listVideoPayloadTypes == null) {
            payloadTypeArr = null;
        } else {
            payloadTypeArr = new PayloadType[listVideoPayloadTypes.length];
            for (int i = 0; i < payloadTypeArr.length; i++) {
                payloadTypeArr[i] = new PayloadTypeImpl(listVideoPayloadTypes[i]);
            }
        }
        return payloadTypeArr;
    }

    public int getVideoDevice() {
        return getVideoDevice(this.nativePtr);
    }

    public int getVideoDscp() {
        return getVideoDscp(this.nativePtr);
    }

    public synchronized LinphoneAddress interpretUrl(String str) {
        long interpretUrl;
        interpretUrl = interpretUrl(this.nativePtr, str);
        if (interpretUrl != 0) {
        } else {
            throw new LinphoneCoreException("Cannot interpret [" + str + "]");
        }
        return new LinphoneAddressImpl(interpretUrl, WrapMode.FromNew);
    }

    public synchronized LinphoneCall invite(String str) {
        isValid();
        return (LinphoneCall) invite(this.nativePtr, str);
    }

    public synchronized LinphoneCall invite(LinphoneAddress linphoneAddress) {
        LinphoneCall linphoneCall;
        linphoneCall = (LinphoneCall) inviteAddress(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr);
        if (linphoneCall == null) {
            throw new LinphoneCoreException("Unable to invite address " + linphoneAddress.asString());
        }
        return linphoneCall;
    }

    public synchronized LinphoneCall inviteAddressWithParams(LinphoneAddress linphoneAddress, LinphoneCallParams linphoneCallParams) {
        LinphoneCall linphoneCall;
        linphoneCall = (LinphoneCall) inviteAddressWithParams(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr);
        if (linphoneCall == null) {
            throw new LinphoneCoreException("Unable to invite with params " + linphoneAddress.asString());
        }
        return linphoneCall;
    }

    public synchronized boolean isEchoCancellationEnabled() {
        isValid();
        return isEchoCancellationEnabled(this.nativePtr);
    }

    public synchronized boolean isEchoLimiterEnabled() {
        return isEchoLimiterEnabled(this.nativePtr);
    }

    public synchronized boolean isInComingInvitePending() {
        isValid();
        return isInComingInvitePending(this.nativePtr);
    }

    public synchronized boolean isInConference() {
        return isInConference(this.nativePtr);
    }

    public synchronized boolean isIncall() {
        isValid();
        return isInCall(this.nativePtr);
    }

    public synchronized boolean isIpv6Enabled() {
        return isIpv6Enabled(this.nativePtr);
    }

    public synchronized boolean isKeepAliveEnabled() {
        return isKeepAliveEnabled(this.nativePtr);
    }

    public synchronized boolean isMediaEncryptionMandatory() {
        return isMediaEncryptionMandatory(this.nativePtr);
    }

    public synchronized boolean isMicMuted() {
        return isMicMuted(this.nativePtr);
    }

    public boolean isMyself(String str) {
        LinphoneProxyConfig defaultProxyConfig = getDefaultProxyConfig();
        return defaultProxyConfig == null ? false : str.equals(defaultProxyConfig.getIdentity());
    }

    public synchronized boolean isNetworkReachable() {
        return isNetworkStateReachable(this.nativePtr);
    }

    public synchronized boolean isPayloadTypeEnabled(PayloadType payloadType) {
        isValid();
        return isPayloadTypeEnabled(this.nativePtr, ((PayloadTypeImpl) payloadType).nativePtr);
    }

    public boolean isSpeakerEnabled() {
        return this.mSpeakerEnabled;
    }

    public native boolean isTunnelAvailable();

    public synchronized boolean isVideoEnabled() {
        return isVideoEnabled(this.nativePtr);
    }

    public synchronized boolean isVideoSupported() {
        return isVideoSupported(this.nativePtr);
    }

    public synchronized void iterate() {
        isValid();
        iterate(this.nativePtr);
    }

    public synchronized void leaveConference() {
        leaveConference(this.nativePtr);
    }

    public synchronized boolean mediaEncryptionSupported(MediaEncryption mediaEncryption) {
        return mediaEncryptionSupported(this.nativePtr, mediaEncryption.mValue);
    }

    public int migrateToMultiTransport() {
        return migrateToMultiTransport(this.nativePtr);
    }

    public synchronized void muteMic(boolean z) {
        muteMic(this.nativePtr, z);
    }

    public synchronized boolean needsEchoCalibration() {
        return needsEchoCalibration(this.nativePtr);
    }

    public synchronized boolean pauseAllCalls() {
        return pauseAllCalls(this.nativePtr) == 0;
    }

    public synchronized boolean pauseCall(LinphoneCall linphoneCall) {
        return pauseCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr) == 0;
    }

    public synchronized void playDtmf(char c, int i) {
        playDtmf(this.nativePtr, c, i);
    }

    public LinphoneEvent publish(LinphoneAddress linphoneAddress, String str, int i, LinphoneContent linphoneContent) {
        return (LinphoneEvent) publish(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, str, i, linphoneContent != null ? linphoneContent.getType() : null, linphoneContent != null ? linphoneContent.getSubtype() : null, linphoneContent != null ? linphoneContent.getData() : null, linphoneContent != null ? linphoneContent.getEncoding() : null);
    }

    public synchronized void refreshRegisters() {
        refreshRegisters(this.nativePtr);
    }

    public synchronized void removeAuthInfo(LinphoneAuthInfo linphoneAuthInfo) {
        isValid();
        removeAuthInfo(this.nativePtr, ((LinphoneAuthInfoImpl) linphoneAuthInfo).nativePtr);
    }

    public synchronized void removeCallLog(LinphoneCallLog linphoneCallLog) {
        removeCallLog(this.nativePtr, ((LinphoneCallLogImpl) linphoneCallLog).getNativePtr());
    }

    public synchronized void removeFriend(LinphoneFriend linphoneFriend) {
        removeFriend(this.nativePtr, linphoneFriend.getNativePtr());
    }

    public synchronized void removeFromConference(LinphoneCall linphoneCall) {
        removeFromConference(this.nativePtr, getCallPtr(linphoneCall));
    }

    public synchronized void removeProxyConfig(LinphoneProxyConfig linphoneProxyConfig) {
        isValid();
        removeProxyConfig(this.nativePtr, ((LinphoneProxyConfigImpl) linphoneProxyConfig).nativePtr);
    }

    public synchronized void resetMissedCallsCount() {
        resetMissedCallsCount(this.nativePtr);
    }

    public synchronized boolean resumeCall(LinphoneCall linphoneCall) {
        return resumeCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr) == 0;
    }

    public void routeAudioToSpeakerHelper(boolean z) {
        if (contextInitialized()) {
            if (Hacks.needGalaxySAudioHack()) {
                setAudioModeIncallForGalaxyS();
            }
            this.mAudioManager.setSpeakerphoneOn(z);
        }
    }

    public synchronized void sendDtmf(char c) {
        sendDtmf(this.nativePtr, c);
    }

    public void setAudioDscp(int i) {
        setAudioDscp(this.nativePtr, i);
    }

    public synchronized void setAudioPort(int i) {
        setAudioPort(this.nativePtr, i);
    }

    public synchronized void setAudioPortRange(int i, int i2) {
        setAudioPortRange(this.nativePtr, i, i2);
    }

    public void setChatDatabasePath(String str) {
        setChatDatabasePath(this.nativePtr, str);
    }

    public void setContext(Object obj) {
        this.mContext = (Context) obj;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
    }

    public synchronized void setCpuCount(int i) {
        setCpuCountNative(i);
    }

    public synchronized void setDefaultProxyConfig(LinphoneProxyConfig linphoneProxyConfig) {
        isValid();
        setDefaultProxyConfig(this.nativePtr, ((LinphoneProxyConfigImpl) linphoneProxyConfig).nativePtr);
    }

    public synchronized void setDeviceRotation(int i) {
        setDeviceRotation(this.nativePtr, i);
    }

    public synchronized void setDownloadBandwidth(int i) {
        setDownloadBandwidth(this.nativePtr, i);
    }

    public synchronized void setDownloadPtime(int i) {
        setDownloadPtime(this.nativePtr, i);
    }

    public synchronized void setFirewallPolicy(FirewallPolicy firewallPolicy) {
        setFirewallPolicy(this.nativePtr, firewallPolicy.value());
    }

    public synchronized void setInCallTimeout(int i) {
        setInCallTimeout(this.nativePtr, i);
    }

    public synchronized void setIncomingTimeout(int i) {
        setIncomingTimeout(this.nativePtr, i);
    }

    public synchronized void setMaxCalls(int i) {
        setMaxCalls(this.nativePtr, i);
    }

    public synchronized void setMediaEncryption(MediaEncryption mediaEncryption) {
        setMediaEncryption(this.nativePtr, mediaEncryption.mValue);
    }

    public synchronized void setMediaEncryptionMandatory(boolean z) {
        setMediaEncryptionMandatory(this.nativePtr, z);
    }

    public synchronized void setMicrophoneGain(float f) {
        setMicrophoneGain(this.nativePtr, f);
    }

    public synchronized void setNetworkReachable(boolean z) {
        setNetworkStateReachable(this.nativePtr, z);
    }

    public synchronized void setPlayFile(String str) {
        setPlayFile(this.nativePtr, str);
    }

    public void setPlayLevel(int i) {
    }

    public synchronized void setPlaybackGain(float f) {
        setPlaybackGain(this.nativePtr, f);
    }

    public synchronized void setPreferredVideoSize(VideoSize videoSize) {
        setPreferredVideoSize(this.nativePtr, videoSize.width, videoSize.height);
    }

    public synchronized void setPreferredVideoSizeByName(String str) {
        setPreferredVideoSizeByName(this.nativePtr, str);
    }

    public synchronized void setPresenceInfo(int i, String str, OnlineStatus onlineStatus) {
        setPresenceInfo(this.nativePtr, i, str, onlineStatus.mValue);
    }

    public synchronized void setPresenceModel(PresenceModel presenceModel) {
        setPresenceModel(this.nativePtr, ((PresenceModelImpl) presenceModel).getNativePtr());
    }

    public synchronized void setPreviewWindow(Object obj) {
        setPreviewWindowId(this.nativePtr, obj);
    }

    public synchronized void setPrimaryContact(String str, String str2) {
        setPrimaryContact(this.nativePtr, str, str2);
    }

    public synchronized void setRing(String str) {
        setRing(this.nativePtr, str);
    }

    public synchronized void setRootCA(String str) {
        setRootCA(this.nativePtr, str);
    }

    public synchronized void setSignalingTransportPorts(Transports transports) {
        setSignalingTransportPorts(this.nativePtr, transports.udp, transports.tcp, transports.tls);
    }

    public void setSipDscp(int i) {
        setSipDscp(this.nativePtr, i);
    }

    public synchronized void setStaticPicture(String str) {
        setStaticPicture(this.nativePtr, str);
    }

    public synchronized void setStunServer(String str) {
        setStunServer(this.nativePtr, str);
    }

    public synchronized void setUploadBandwidth(int i) {
        setUploadBandwidth(this.nativePtr, i);
    }

    public synchronized void setUploadPtime(int i) {
        setUploadPtime(this.nativePtr, i);
    }

    public synchronized void setUseRfc2833ForDtmfs(boolean z) {
        setUseRfc2833ForDtmfs(this.nativePtr, z);
    }

    public synchronized void setUseSipInfoForDtmfs(boolean z) {
        setUseSipInfoForDtmfs(this.nativePtr, z);
    }

    public synchronized void setUserAgent(String str, String str2) {
        setUserAgent(this.nativePtr, str, str2);
    }

    public void setVideoDevice(int i) {
        Log.m11095i("Setting camera id :", Integer.valueOf(i));
        if (setVideoDevice(this.nativePtr, i) != 0) {
            Log.m11091e("Failed to set video device to id:", Integer.valueOf(i));
        }
    }

    public void setVideoDscp(int i) {
        setVideoDscp(this.nativePtr, i);
    }

    public synchronized void setVideoPolicy(boolean z, boolean z2) {
        setVideoPolicy(this.nativePtr, z, z2);
    }

    public synchronized void setVideoPort(int i) {
        setVideoPort(this.nativePtr, i);
    }

    public synchronized void setVideoPortRange(int i, int i2) {
        setVideoPortRange(this.nativePtr, i, i2);
    }

    public synchronized void setVideoWindow(Object obj) {
        setVideoWindowId(this.nativePtr, obj);
    }

    public synchronized void setZrtpSecretsCache(String str) {
        setZrtpSecretsCache(this.nativePtr, str);
    }

    public synchronized boolean soundResourcesLocked() {
        return soundResourcesLocked(this.nativePtr);
    }

    public void startConferenceRecording(String str) {
        startConferenceRecording(this.nativePtr, str);
    }

    public synchronized void startEchoCalibration(Object obj) {
        startEchoCalibration(this.nativePtr, obj);
    }

    public LinphoneCall startReferedCall(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        return startReferedCall(this.nativePtr, getCallPtr(linphoneCall), ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr);
    }

    public void stopConferenceRecording() {
        stopConferenceRecording(this.nativePtr);
    }

    public synchronized void stopDtmf() {
        stopDtmf(this.nativePtr);
    }

    public LinphoneEvent subscribe(LinphoneAddress linphoneAddress, String str, int i, LinphoneContent linphoneContent) {
        return (LinphoneEvent) subscribe(this.nativePtr, ((LinphoneAddressImpl) linphoneAddress).nativePtr, str, i, linphoneContent != null ? linphoneContent.getType() : null, linphoneContent != null ? linphoneContent.getSubtype() : null, linphoneContent != null ? linphoneContent.getData() : null, linphoneContent != null ? linphoneContent.getEncoding() : null);
    }

    public synchronized void terminateAllCalls() {
        terminateAllCalls(this.nativePtr);
    }

    public synchronized void terminateCall(LinphoneCall linphoneCall) {
        isValid();
        if (linphoneCall != null) {
            terminateCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr);
        }
    }

    public synchronized void terminateConference() {
        terminateConference(this.nativePtr);
    }

    public synchronized void transferCall(LinphoneCall linphoneCall, String str) {
        transferCall(this.nativePtr, getCallPtr(linphoneCall), str);
    }

    public synchronized void transferCallToAnother(LinphoneCall linphoneCall, LinphoneCall linphoneCall2) {
        transferCallToAnother(this.nativePtr, getCallPtr(linphoneCall), getCallPtr(linphoneCall2));
    }

    public synchronized void tunnelAddServerAndMirror(String str, int i, int i2, int i3) {
        tunnelAddServerAndMirror(this.nativePtr, str, i, i2, i3);
    }

    public synchronized void tunnelAutoDetect() {
        tunnelAutoDetect(this.nativePtr);
    }

    public synchronized void tunnelCleanServers() {
        tunnelCleanServers(this.nativePtr);
    }

    public synchronized void tunnelEnable(boolean z) {
        tunnelEnable(this.nativePtr, z);
    }

    public void tunnelSetHttpProxy(String str, int i, String str2, String str3) {
        tunnelSetHttpProxy(this.nativePtr, str, i, str2, str3);
    }

    public synchronized int updateCall(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams) {
        return updateCall(this.nativePtr, ((LinphoneCallImpl) linphoneCall).nativePtr, linphoneCallParams != null ? ((LinphoneCallParamsImpl) linphoneCallParams).nativePtr : 0);
    }

    public boolean upnpAvailable() {
        return upnpAvailable(this.nativePtr);
    }
}
