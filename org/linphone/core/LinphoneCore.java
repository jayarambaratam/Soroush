package org.linphone.core;

import java.util.Vector;

public interface LinphoneCore {

    public class EcCalibratorStatus {
        public static final int DONE_NO_ECHO_STATUS = 3;
        public static final int DONE_STATUS = 1;
        public static EcCalibratorStatus Done = null;
        public static EcCalibratorStatus DoneNoEcho = null;
        public static final int FAILED_STATUS = 2;
        public static EcCalibratorStatus Failed;
        public static final int IN_PROGRESS_STATUS = 0;
        public static EcCalibratorStatus InProgress;
        private static Vector<EcCalibratorStatus> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            InProgress = new EcCalibratorStatus(0, "InProgress");
            Done = new EcCalibratorStatus(DONE_STATUS, "Done");
            Failed = new EcCalibratorStatus(FAILED_STATUS, "Failed");
            DoneNoEcho = new EcCalibratorStatus(DONE_NO_ECHO_STATUS, "DoneNoEcho");
        }

        private EcCalibratorStatus(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static EcCalibratorStatus fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2 += DONE_STATUS) {
                EcCalibratorStatus ecCalibratorStatus = (EcCalibratorStatus) values.elementAt(i2);
                if (ecCalibratorStatus.mValue == i) {
                    return ecCalibratorStatus;
                }
            }
            throw new RuntimeException("status not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }

        public int value() {
            return this.mValue;
        }
    }

    public class FirewallPolicy {
        public static FirewallPolicy NoFirewall;
        public static FirewallPolicy UseIce;
        public static FirewallPolicy UseNatAddress;
        public static FirewallPolicy UseStun;
        public static FirewallPolicy UseUpnp;
        private static Vector<FirewallPolicy> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            NoFirewall = new FirewallPolicy(0, "NoFirewall");
            UseNatAddress = new FirewallPolicy(1, "UseNatAddress");
            UseStun = new FirewallPolicy(2, "UseStun");
            UseIce = new FirewallPolicy(3, "UseIce");
            UseUpnp = new FirewallPolicy(4, "UseUpnp");
        }

        private FirewallPolicy(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static FirewallPolicy fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                FirewallPolicy firewallPolicy = (FirewallPolicy) values.elementAt(i2);
                if (firewallPolicy.mValue == i) {
                    return firewallPolicy;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }

        public int value() {
            return this.mValue;
        }
    }

    public class GlobalState {
        public static GlobalState GlobalConfiguring;
        public static GlobalState GlobalOff;
        public static GlobalState GlobalOn;
        public static GlobalState GlobalShutdown;
        public static GlobalState GlobalStartup;
        private static Vector<GlobalState> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            GlobalOff = new GlobalState(0, "GlobalOff");
            GlobalStartup = new GlobalState(1, "GlobalStartup");
            GlobalOn = new GlobalState(2, "GlobalOn");
            GlobalShutdown = new GlobalState(3, "GlobalShutdown");
            GlobalConfiguring = new GlobalState(4, "GlobalConfiguring");
        }

        private GlobalState(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static GlobalState fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                GlobalState globalState = (GlobalState) values.elementAt(i2);
                if (globalState.mValue == i) {
                    return globalState;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    public final class MediaEncryption {
        public static final MediaEncryption None;
        public static final MediaEncryption SRTP;
        public static final MediaEncryption ZRTP;
        private static Vector<MediaEncryption> values;
        private final String mStringValue;
        protected final int mValue;

        static {
            values = new Vector();
            None = new MediaEncryption(0, "None");
            SRTP = new MediaEncryption(1, "SRTP");
            ZRTP = new MediaEncryption(2, "ZRTP");
        }

        private MediaEncryption(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static MediaEncryption fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                MediaEncryption mediaEncryption = (MediaEncryption) values.elementAt(i2);
                if (mediaEncryption.mValue == i) {
                    return mediaEncryption;
                }
            }
            throw new RuntimeException("MediaEncryption not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    public class RegistrationState {
        public static RegistrationState RegistrationCleared;
        public static RegistrationState RegistrationFailed;
        public static RegistrationState RegistrationNone;
        public static RegistrationState RegistrationOk;
        public static RegistrationState RegistrationProgress;
        private static Vector<RegistrationState> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            RegistrationNone = new RegistrationState(0, "RegistrationNone");
            RegistrationProgress = new RegistrationState(1, "RegistrationProgress");
            RegistrationOk = new RegistrationState(2, "RegistrationOk");
            RegistrationCleared = new RegistrationState(3, "RegistrationCleared");
            RegistrationFailed = new RegistrationState(4, "RegistrationFailed");
        }

        private RegistrationState(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static RegistrationState fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                RegistrationState registrationState = (RegistrationState) values.elementAt(i2);
                if (registrationState.mValue == i) {
                    return registrationState;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    public class RemoteProvisioningState {
        public static RemoteProvisioningState ConfiguringFailed;
        public static RemoteProvisioningState ConfiguringSkipped;
        public static RemoteProvisioningState ConfiguringSuccessful;
        private static Vector<RemoteProvisioningState> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            ConfiguringSuccessful = new RemoteProvisioningState(0, "ConfiguringSuccessful");
            ConfiguringFailed = new RemoteProvisioningState(1, "ConfiguringFailed");
            ConfiguringSkipped = new RemoteProvisioningState(2, "ConfiguringSkipped");
        }

        private RemoteProvisioningState(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static RemoteProvisioningState fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                RemoteProvisioningState remoteProvisioningState = (RemoteProvisioningState) values.elementAt(i2);
                if (remoteProvisioningState.mValue == i) {
                    return remoteProvisioningState;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    public class Transports {
        public int tcp;
        public int tls;
        public int udp;

        public Transports(Transports transports) {
            this.udp = transports.udp;
            this.tcp = transports.tcp;
            this.tls = transports.tls;
        }

        public String toString() {
            return "udp[" + this.udp + "] tcp[" + this.tcp + "] tls[" + this.tls + "]";
        }
    }

    public class UpnpState {
        public static UpnpState Adding;
        public static UpnpState Blacklisted;
        public static UpnpState Idle;
        public static UpnpState Ko;
        public static UpnpState NotAvailable;
        public static UpnpState Ok;
        public static UpnpState Pending;
        public static UpnpState Removing;
        private static Vector<UpnpState> values;
        private final String mStringValue;
        protected final int mValue;

        static {
            values = new Vector();
            Idle = new UpnpState(0, "Idle");
            Pending = new UpnpState(1, "Pending");
            Adding = new UpnpState(2, "Adding");
            Removing = new UpnpState(3, "Removing");
            NotAvailable = new UpnpState(4, "Not available");
            Ok = new UpnpState(5, "Ok");
            Ko = new UpnpState(6, "Ko");
            Blacklisted = new UpnpState(7, "Blacklisted");
        }

        private UpnpState(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static UpnpState fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                UpnpState upnpState = (UpnpState) values.elementAt(i2);
                if (upnpState.mValue == i) {
                    return upnpState;
                }
            }
            throw new RuntimeException("UpnpState not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    void acceptCall(LinphoneCall linphoneCall);

    void acceptCallUpdate(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams);

    void acceptCallWithParams(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams);

    void addAllToConference();

    void addAuthInfo(LinphoneAuthInfo linphoneAuthInfo);

    void addFriend(LinphoneFriend linphoneFriend);

    void addProxyConfig(LinphoneProxyConfig linphoneProxyConfig);

    void addToConference(LinphoneCall linphoneCall);

    void adjustSoftwareVolume(int i);

    void clearAuthInfos();

    void clearCallLogs();

    void clearProxyConfigs();

    LinphoneCallParams createDefaultCallParameters();

    LinphoneInfoMessage createInfoMessage();

    void declineCall(LinphoneCall linphoneCall, Reason reason);

    void deferCallUpdate(LinphoneCall linphoneCall);

    void destroy();

    void enableEchoCancellation(boolean z);

    void enableEchoLimiter(boolean z);

    void enableIpv6(boolean z);

    void enableKeepAlive(boolean z);

    void enablePayloadType(PayloadType payloadType, boolean z);

    void enableSpeaker(boolean z);

    void enableVideo(boolean z, boolean z2);

    boolean enterConference();

    LinphoneAuthInfo findAuthInfo(String str, String str2, String str3);

    LinphoneCall findCallFromUri(String str);

    LinphoneFriend findFriendByAddress(String str);

    PayloadType findPayloadType(String str);

    PayloadType findPayloadType(String str, int i);

    PayloadType findPayloadType(String str, int i, int i2);

    PayloadType[] getAudioCodecs();

    int getAudioDscp();

    LinphoneAuthInfo[] getAuthInfosList();

    LinphoneCallLog[] getCallLogs();

    LinphoneCall[] getCalls();

    int getCallsNb();

    LinphoneChatRoom[] getChatRooms();

    int getConferenceSize();

    LpConfig getConfig();

    LinphoneCall getCurrentCall();

    LinphoneProxyConfig getDefaultProxyConfig();

    FirewallPolicy getFirewallPolicy();

    int getMaxCalls();

    MediaEncryption getMediaEncryption();

    int getMissedCallsCount();

    LinphoneChatRoom getOrCreateChatRoom(String str);

    int getPlayLevel();

    float getPlaybackGain();

    VideoSize getPreferredVideoSize();

    OnlineStatus getPresenceInfo();

    PresenceModel getPresenceModel();

    String getPrimaryContactDisplayName();

    String getPrimaryContactUsername();

    LinphoneProxyConfig[] getProxyConfigList();

    LinphoneAddress getRemoteAddress();

    String getRing();

    Transports getSignalingTransportPorts();

    int getSipDscp();

    String getStunServer();

    String[] getSupportedVideoSizes();

    String getUpnpExternalIpaddress();

    UpnpState getUpnpState();

    boolean getUseRfc2833ForDtmfs();

    boolean getUseSipInfoForDtmfs();

    String getVersion();

    boolean getVideoAutoAcceptPolicy();

    boolean getVideoAutoInitiatePolicy();

    PayloadType[] getVideoCodecs();

    int getVideoDevice();

    int getVideoDscp();

    LinphoneAddress interpretUrl(String str);

    LinphoneCall invite(String str);

    LinphoneCall invite(LinphoneAddress linphoneAddress);

    LinphoneCall inviteAddressWithParams(LinphoneAddress linphoneAddress, LinphoneCallParams linphoneCallParams);

    boolean isEchoCancellationEnabled();

    boolean isEchoLimiterEnabled();

    boolean isInComingInvitePending();

    boolean isInConference();

    boolean isIncall();

    boolean isIpv6Enabled();

    boolean isKeepAliveEnabled();

    boolean isMediaEncryptionMandatory();

    boolean isMicMuted();

    boolean isMyself(String str);

    boolean isNetworkReachable();

    boolean isPayloadTypeEnabled(PayloadType payloadType);

    boolean isSpeakerEnabled();

    boolean isTunnelAvailable();

    boolean isVideoEnabled();

    boolean isVideoSupported();

    void iterate();

    void leaveConference();

    boolean mediaEncryptionSupported(MediaEncryption mediaEncryption);

    int migrateToMultiTransport();

    void muteMic(boolean z);

    boolean needsEchoCalibration();

    boolean pauseAllCalls();

    boolean pauseCall(LinphoneCall linphoneCall);

    void playDtmf(char c, int i);

    LinphoneEvent publish(LinphoneAddress linphoneAddress, String str, int i, LinphoneContent linphoneContent);

    void refreshRegisters();

    void removeAuthInfo(LinphoneAuthInfo linphoneAuthInfo);

    void removeCallLog(LinphoneCallLog linphoneCallLog);

    void removeFriend(LinphoneFriend linphoneFriend);

    void removeFromConference(LinphoneCall linphoneCall);

    void removeProxyConfig(LinphoneProxyConfig linphoneProxyConfig);

    void resetMissedCallsCount();

    boolean resumeCall(LinphoneCall linphoneCall);

    void sendDtmf(char c);

    void setAudioDscp(int i);

    void setAudioPort(int i);

    void setAudioPortRange(int i, int i2);

    void setChatDatabasePath(String str);

    void setContext(Object obj);

    void setCpuCount(int i);

    void setDefaultProxyConfig(LinphoneProxyConfig linphoneProxyConfig);

    void setDeviceRotation(int i);

    void setDownloadBandwidth(int i);

    void setDownloadPtime(int i);

    void setFirewallPolicy(FirewallPolicy firewallPolicy);

    void setInCallTimeout(int i);

    void setIncomingTimeout(int i);

    void setMaxCalls(int i);

    void setMediaEncryption(MediaEncryption mediaEncryption);

    void setMediaEncryptionMandatory(boolean z);

    void setMicrophoneGain(float f);

    void setNetworkReachable(boolean z);

    void setPlayFile(String str);

    void setPlayLevel(int i);

    void setPlaybackGain(float f);

    void setPreferredVideoSize(VideoSize videoSize);

    void setPreferredVideoSizeByName(String str);

    void setPresenceInfo(int i, String str, OnlineStatus onlineStatus);

    void setPresenceModel(PresenceModel presenceModel);

    void setPreviewWindow(Object obj);

    void setPrimaryContact(String str, String str2);

    void setRing(String str);

    void setRootCA(String str);

    void setSignalingTransportPorts(Transports transports);

    void setSipDscp(int i);

    void setStaticPicture(String str);

    void setStunServer(String str);

    void setUploadBandwidth(int i);

    void setUploadPtime(int i);

    void setUseRfc2833ForDtmfs(boolean z);

    void setUseSipInfoForDtmfs(boolean z);

    void setUserAgent(String str, String str2);

    void setVideoDevice(int i);

    void setVideoDscp(int i);

    void setVideoPolicy(boolean z, boolean z2);

    void setVideoPort(int i);

    void setVideoPortRange(int i, int i2);

    void setVideoWindow(Object obj);

    void setZrtpSecretsCache(String str);

    boolean soundResourcesLocked();

    void startConferenceRecording(String str);

    void startEchoCalibration(Object obj);

    LinphoneCall startReferedCall(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams);

    void stopConferenceRecording();

    void stopDtmf();

    LinphoneEvent subscribe(LinphoneAddress linphoneAddress, String str, int i, LinphoneContent linphoneContent);

    void terminateAllCalls();

    void terminateCall(LinphoneCall linphoneCall);

    void terminateConference();

    void transferCall(LinphoneCall linphoneCall, String str);

    void transferCallToAnother(LinphoneCall linphoneCall, LinphoneCall linphoneCall2);

    void tunnelAddServerAndMirror(String str, int i, int i2, int i3);

    void tunnelAutoDetect();

    void tunnelCleanServers();

    void tunnelEnable(boolean z);

    void tunnelSetHttpProxy(String str, int i, String str2, String str3);

    int updateCall(LinphoneCall linphoneCall, LinphoneCallParams linphoneCallParams);

    boolean upnpAvailable();
}
