package org.linphone;

import android.content.Context;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.p086a.p087a.C1130b;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneAddress.TransportType;
import org.linphone.core.LinphoneAuthInfo;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCore.FirewallPolicy;
import org.linphone.core.LinphoneCore.MediaEncryption;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.core.LinphoneCore.Transports;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.LpConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Log;

public class LinphonePreferences {
    private static final int LINPHONE_CORE_RANDOM_PORT = -1;
    private static LinphonePreferences instance;
    private Context mContext;
    private String tempContactsParams;
    private String tempDomain;
    private String tempExpire;
    private boolean tempOutboundProxy;
    private String tempPassword;
    private String tempProxy;
    private TransportType tempTransport;
    private String tempUserId;
    private String tempUsername;

    private LinphonePreferences() {
    }

    private LinphoneAuthInfo getAuthInfo(int i) {
        LinphoneAuthInfo linphoneAuthInfo = null;
        try {
            LinphoneAddress createLinphoneAddress = LinphoneCoreFactory.instance().createLinphoneAddress(getProxyConfig(i).getIdentity());
            linphoneAuthInfo = getLc().findAuthInfo(createLinphoneAddress.getUserName(), null, createLinphoneAddress.getDomain());
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        return linphoneAuthInfo;
    }

    private LinphoneAuthInfo getClonedAuthInfo(int i) {
        LinphoneAuthInfo authInfo = getAuthInfo(i);
        if (authInfo == null) {
            return null;
        }
        LinphoneAuthInfo clone = authInfo.clone();
        getLc().removeAuthInfo(authInfo);
        return clone;
    }

    private LinphoneCore getLc() {
        return LinphoneManager.getLcIfManagerNotDestroyedOrNull();
    }

    private LinphoneProxyConfig getProxyConfig(int i) {
        LinphoneProxyConfig[] proxyConfigList = getLc().getProxyConfigList();
        return (i < 0 || i >= proxyConfigList.length) ? null : proxyConfigList[i];
    }

    private String getString(int i) {
        if (this.mContext == null) {
            this.mContext = LinphoneManager.getInstance().getContext();
        }
        return this.mContext.getString(i);
    }

    public static synchronized LinphonePreferences instance() {
        LinphonePreferences linphonePreferences;
        synchronized (LinphonePreferences.class) {
            if (instance == null) {
                instance = new LinphonePreferences();
            }
            linphonePreferences = instance;
        }
        return linphonePreferences;
    }

    private void saveAuthInfo(LinphoneAuthInfo linphoneAuthInfo) {
        getLc().addAuthInfo(linphoneAuthInfo);
    }

    public boolean areAnimationsEnabled() {
        return getConfig().getBool("app", "animations", false);
    }

    public void deleteAccount(int i) {
        LinphoneAuthInfo authInfo = getAuthInfo(i);
        if (authInfo != null) {
            getLc().removeAuthInfo(authInfo);
        }
        LinphoneProxyConfig proxyConfig = getProxyConfig(i);
        if (proxyConfig != null) {
            getLc().removeProxyConfig(proxyConfig);
        }
        if (getLc().getProxyConfigList().length == 0) {
            C1130b.m6468a(this.mContext, null).onRegistrationStateChanged(RegistrationState.RegistrationNone);
        } else {
            getLc().refreshRegisters();
        }
    }

    public void enableVideo(boolean z) {
        getLc().enableVideo(z, z);
    }

    public void firstLaunchSuccessful() {
        getConfig().setBool("app", "first_launch", false);
    }

    public int getAccountCount() {
        return getLc().getProxyConfigList().length;
    }

    public String getAccountDomain(int i) {
        return getProxyConfig(i).getDomain();
    }

    public String getAccountPassword(int i) {
        LinphoneAuthInfo authInfo = getAuthInfo(i);
        return authInfo == null ? null : authInfo.getPassword();
    }

    public String getAccountProxy(int i) {
        return getProxyConfig(i).getProxy();
    }

    public TransportType getAccountTransport(int i) {
        TransportType transportType = null;
        LinphoneProxyConfig proxyConfig = getProxyConfig(i);
        if (proxyConfig != null) {
            try {
                transportType = LinphoneCoreFactory.instance().createLinphoneAddress(proxyConfig.getProxy()).getTransport();
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
        return transportType;
    }

    public String getAccountTransportKey(int i) {
        TransportType accountTransport = getAccountTransport(i);
        String string = getString(C1136d.pref_transport_udp_key);
        return (accountTransport == null || accountTransport != TransportType.LinphoneTransportTcp) ? (accountTransport == null || accountTransport != TransportType.LinphoneTransportTls) ? string : getString(C1136d.pref_transport_tls_key) : getString(C1136d.pref_transport_tcp_key);
    }

    public String getAccountTransportString(int i) {
        TransportType accountTransport = getAccountTransport(i);
        return (accountTransport == null || accountTransport != TransportType.LinphoneTransportTcp) ? (accountTransport == null || accountTransport != TransportType.LinphoneTransportTls) ? getString(C1136d.pref_transport_udp) : getString(C1136d.pref_transport_tls) : getString(C1136d.pref_transport_tcp);
    }

    public String getAccountUserId(int i) {
        LinphoneAuthInfo authInfo = getAuthInfo(i);
        return authInfo == null ? null : authInfo.getUserId();
    }

    public String getAccountUsername(int i) {
        LinphoneAuthInfo authInfo = getAuthInfo(i);
        return authInfo == null ? null : authInfo.getUsername();
    }

    public LpConfig getConfig() {
        LinphoneCore lc = getLc();
        return lc != null ? lc.getConfig() : LinphoneCoreFactory.instance().createLpConfig(LinphoneManager.getInstance().mLinphoneConfigFile);
    }

    public int getDefaultAccountIndex() {
        LinphoneProxyConfig defaultProxyConfig = getLc().getDefaultProxyConfig();
        if (defaultProxyConfig == null) {
            return 0;
        }
        LinphoneProxyConfig[] proxyConfigList = getLc().getProxyConfigList();
        for (int i = 0; i < proxyConfigList.length; i++) {
            if (defaultProxyConfig.getIdentity().equals(proxyConfigList[i].getIdentity())) {
                return i;
            }
        }
        return 0;
    }

    public String getDefaultDisplayName() {
        return getLc().getPrimaryContactDisplayName();
    }

    public String getDefaultUsername() {
        return getLc().getPrimaryContactUsername();
    }

    public String getExpires(int i) {
        return String.valueOf(getProxyConfig(i).getExpires());
    }

    public MediaEncryption getMediaEncryption() {
        return getLc().getMediaEncryption();
    }

    public String getPreferredVideoSize() {
        return getConfig().getString("video", "size", "qvga");
    }

    public String getPrefix(int i) {
        return getProxyConfig(i).getDialPrefix();
    }

    public String getPushNotificationRegistrationID() {
        return getConfig().getString("app", "push_notification_regid", null);
    }

    public String getRemoteProvisioningUrl() {
        return getConfig().getString("app", "remote_provisioning", null);
    }

    public boolean getReplacePlusByZeroZero(int i) {
        return getProxyConfig(i).getDialEscapePlus();
    }

    public String getRingtone(String str) {
        String string = getConfig().getString("app", "ringtone", str);
        return (string == null || string.length() == 0) ? str : string;
    }

    public String getSharingPictureServerUrl() {
        return getConfig().getString("app", "sharing_server", null);
    }

    public String getSipPort() {
        Transports signalingTransportPorts = getLc().getSignalingTransportPorts();
        return String.valueOf(signalingTransportPorts.udp > 0 ? signalingTransportPorts.udp : signalingTransportPorts.tcp);
    }

    public String getStunServer() {
        return getLc().getStunServer();
    }

    public String getTunnelHost() {
        return getConfig().getString("tunnel", "host", null);
    }

    public String getTunnelMode() {
        return getConfig().getString("app", "tunnel", null);
    }

    public int getTunnelPort() {
        return getConfig().getInt("tunnel", "port", 443);
    }

    public boolean isAccountEnabled(int i) {
        return getProxyConfig(i).registerEnabled();
    }

    public boolean isAccountOutboundProxySet(int i) {
        return getProxyConfig(i).getRoute() != null;
    }

    public boolean isAutoStartEnabled() {
        return getConfig().getBool("app", "auto_start", false);
    }

    public boolean isBackgroundModeEnabled() {
        return getConfig().getBool("app", "background_mode", true);
    }

    public boolean isDebugEnabled() {
        return getConfig().getBool("app", "debug", false);
    }

    public boolean isEchoCancellationEnabled() {
        return getLc().isEchoCancellationEnabled();
    }

    public boolean isFirstLaunch() {
        return getConfig().getBool("app", "first_launch", true);
    }

    public boolean isIceEnabled() {
        return getLc().getFirewallPolicy() == FirewallPolicy.UseIce;
    }

    public boolean isPushNotificationEnabled() {
        return getConfig().getBool("app", "push_notification", false);
    }

    public boolean isUpnpEnabled() {
        return getLc().upnpAvailable() && getLc().getFirewallPolicy() == FirewallPolicy.UseUpnp;
    }

    public boolean isUsingIpv6() {
        return getLc().isIpv6Enabled();
    }

    public boolean isUsingRandomPort() {
        return getConfig().getBool("app", "random_port", true);
    }

    public boolean isVideoEnabled() {
        return getLc().isVideoSupported() && getLc().isVideoEnabled();
    }

    public boolean isWifiOnlyEnabled() {
        return getConfig().getBool("app", "wifi_only", false);
    }

    public void removePreviousVersionAuthInfoRemoval() {
        getConfig().setBool("sip", "store_auth_info", true);
    }

    public void saveNewAccount() {
        String str = "sip:" + this.tempUsername + "@" + this.tempDomain;
        LinphoneAddress createLinphoneAddress = LinphoneCoreFactory.instance().createLinphoneAddress("sip:" + (this.tempProxy == null ? this.tempDomain : this.tempProxy));
        if (this.tempTransport == null) {
            this.tempTransport = TransportType.LinphoneTransportUdp;
        }
        createLinphoneAddress.setTransport(this.tempTransport);
        LinphoneProxyConfig createProxyConfig = LinphoneCoreFactory.instance().createProxyConfig(str, createLinphoneAddress.asStringUriOnly(), this.tempOutboundProxy ? createLinphoneAddress.asStringUriOnly() : null, true);
        if (this.tempContactsParams != null) {
            createProxyConfig.setContactUriParameters(this.tempContactsParams);
        }
        if (this.tempExpire != null) {
            try {
                createProxyConfig.setExpires(Integer.parseInt(this.tempExpire));
            } catch (NumberFormatException e) {
            }
        }
        LinphoneAuthInfo createAuthInfo = LinphoneCoreFactory.instance().createAuthInfo(this.tempUsername, this.tempUserId, this.tempPassword, null, null, this.tempDomain);
        getLc().addProxyConfig(createProxyConfig);
        getLc().addAuthInfo(createAuthInfo);
        if (getAccountCount() == 1) {
            getLc().setDefaultProxyConfig(createProxyConfig);
        }
        this.tempUsername = null;
        this.tempUserId = null;
        this.tempPassword = null;
        this.tempDomain = null;
        this.tempProxy = null;
        this.tempOutboundProxy = false;
        this.tempContactsParams = null;
        this.tempExpire = null;
        this.tempTransport = null;
    }

    public void sendDTMFsAsSipInfo(boolean z) {
        getLc().setUseSipInfoForDtmfs(z);
    }

    public void sendDtmfsAsRfc2833(boolean z) {
        getLc().setUseRfc2833ForDtmfs(z);
    }

    public void setAccountContactParameters(int i, String str) {
        LinphoneProxyConfig proxyConfig = getProxyConfig(i);
        proxyConfig.setContactUriParameters(str);
        proxyConfig.done();
    }

    public void setAccountDomain(int i, String str) {
        String str2 = "sip:" + getAccountUsername(i) + "@" + str;
        try {
            LinphoneAuthInfo clonedAuthInfo = getClonedAuthInfo(i);
            clonedAuthInfo.setDomain(str);
            saveAuthInfo(clonedAuthInfo);
            LinphoneProxyConfig proxyConfig = getProxyConfig(i);
            proxyConfig.setIdentity(str2);
            proxyConfig.done();
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public void setAccountEnabled(int i, boolean z) {
        LinphoneProxyConfig proxyConfig = getProxyConfig(i);
        proxyConfig.enableRegister(z);
        proxyConfig.done();
        if (!z && getLc().getDefaultProxyConfig().getIdentity().equals(proxyConfig.getIdentity())) {
            int length = getLc().getProxyConfigList().length;
            if (length > 1) {
                for (int i2 = 0; i2 < length; i2++) {
                    if (isAccountEnabled(i2)) {
                        getLc().setDefaultProxyConfig(getProxyConfig(i2));
                        return;
                    }
                }
            }
        }
    }

    public void setAccountOutboundProxyEnabled(int i, boolean z) {
        try {
            LinphoneProxyConfig proxyConfig = getProxyConfig(i);
            if (z) {
                proxyConfig.setRoute(proxyConfig.getProxy());
            } else {
                proxyConfig.setRoute(null);
            }
            proxyConfig.done();
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public void setAccountPassword(int i, String str) {
        LinphoneAuthInfo clonedAuthInfo = getClonedAuthInfo(i);
        clonedAuthInfo.setPassword(str);
        saveAuthInfo(clonedAuthInfo);
    }

    public void setAccountProxy(int i, String str) {
        if (str == null || str.length() <= 0) {
            str = getAccountDomain(i);
        }
        if (!str.contains("sip:")) {
            str = "sip:" + str;
        }
        try {
            LinphoneAddress createLinphoneAddress = LinphoneCoreFactory.instance().createLinphoneAddress(str);
            if (!str.contains("transport=")) {
                createLinphoneAddress.setTransport(getAccountTransport(i));
            }
            LinphoneProxyConfig proxyConfig = getProxyConfig(i);
            proxyConfig.setProxy(createLinphoneAddress.asStringUriOnly());
            proxyConfig.done();
            if (isAccountOutboundProxySet(i)) {
                setAccountOutboundProxyEnabled(i, true);
            }
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public void setAccountTransport(int i, String str) {
        LinphoneProxyConfig proxyConfig = getProxyConfig(i);
        if (proxyConfig != null && str != null) {
            try {
                LinphoneAddress createLinphoneAddress = LinphoneCoreFactory.instance().createLinphoneAddress(proxyConfig.getProxy());
                if (str.equals(getString(C1136d.pref_transport_udp_key))) {
                    createLinphoneAddress.setTransport(TransportType.LinphoneTransportUdp);
                } else if (str.equals(getString(C1136d.pref_transport_tcp_key))) {
                    createLinphoneAddress.setTransport(TransportType.LinphoneTransportTcp);
                } else if (str.equals(getString(C1136d.pref_transport_tls_key))) {
                    createLinphoneAddress.setTransport(TransportType.LinphoneTransportTls);
                }
                LinphoneProxyConfig proxyConfig2 = getProxyConfig(i);
                proxyConfig2.setProxy(createLinphoneAddress.asStringUriOnly());
                proxyConfig2.done();
                if (isAccountOutboundProxySet(i)) {
                    setAccountOutboundProxyEnabled(i, true);
                }
            } catch (Throwable e) {
                C1104b.m6368b((Object) this, e);
            }
        }
    }

    public void setAccountUserId(int i, String str) {
        LinphoneAuthInfo clonedAuthInfo = getClonedAuthInfo(i);
        clonedAuthInfo.setUserId(str);
        saveAuthInfo(clonedAuthInfo);
    }

    public void setAccountUsername(int i, String str) {
        String str2 = "sip:" + str + "@" + getAccountDomain(i);
        LinphoneAuthInfo clonedAuthInfo = getClonedAuthInfo(i);
        try {
            LinphoneProxyConfig proxyConfig = getProxyConfig(i);
            proxyConfig.setIdentity(str2);
            proxyConfig.done();
            clonedAuthInfo.setUsername(str);
            saveAuthInfo(clonedAuthInfo);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public void setAnimationsEnabled(boolean z) {
        getConfig().setBool("app", "animations", z);
    }

    public void setAutoStart(boolean z) {
        getConfig().setBool("app", "auto_start", z);
    }

    public void setAutomaticallyAcceptVideoRequests(boolean z) {
        getLc().setVideoPolicy(shouldInitiateVideoCall(), z);
    }

    public void setBackgroundModeEnabled(boolean z) {
        getConfig().setBool("app", "background_mode", z);
    }

    public void setDebugEnabled(boolean z) {
        getConfig().setBool("app", "debug", z);
        LinphoneCoreFactory.instance().setDebugMode(z, "mobi.mmdt.ott.voip");
    }

    public void setDefaultAccount(int i) {
        LinphoneProxyConfig[] proxyConfigList = getLc().getProxyConfigList();
        if (i >= 0 && i < proxyConfigList.length) {
            getLc().setDefaultProxyConfig(proxyConfigList[i]);
        }
    }

    public void setDefaultDisplayName(String str) {
        getLc().setPrimaryContact(str, getDefaultUsername());
    }

    public void setDefaultUsername(String str) {
        getLc().setPrimaryContact(getDefaultDisplayName(), str);
    }

    public void setEchoCancellation(boolean z) {
        getLc().enableEchoCancellation(z);
    }

    public void setExpires(int i, String str) {
        try {
            LinphoneProxyConfig proxyConfig = getProxyConfig(i);
            proxyConfig.setExpires(Integer.parseInt(str));
            proxyConfig.done();
        } catch (NumberFormatException e) {
        }
    }

    public void setFrontCamAsDefault(boolean z) {
        getConfig().setBool("app", "front_camera_default", z);
    }

    public void setIceEnabled(boolean z) {
        if (z) {
            getLc().setFirewallPolicy(FirewallPolicy.UseIce);
            return;
        }
        String stunServer = getStunServer();
        if (stunServer == null || stunServer.length() <= 0) {
            getLc().setFirewallPolicy(FirewallPolicy.NoFirewall);
        } else {
            getLc().setFirewallPolicy(FirewallPolicy.UseStun);
        }
    }

    public void setInitiateVideoCall(boolean z) {
        getLc().setVideoPolicy(z, shouldAutomaticallyAcceptVideoRequests());
    }

    public void setMediaEncryption(MediaEncryption mediaEncryption) {
        if (mediaEncryption != null) {
            getLc().setMediaEncryption(mediaEncryption);
        }
    }

    public void setNewAccountContactParameters(String str) {
        this.tempContactsParams = str;
    }

    public void setNewAccountDomain(String str) {
        this.tempDomain = str;
    }

    public void setNewAccountExpires(String str) {
        this.tempExpire = str;
    }

    public void setNewAccountOutboundProxyEnabled(boolean z) {
        this.tempOutboundProxy = z;
    }

    public void setNewAccountPassword(String str) {
        this.tempPassword = str;
    }

    public void setNewAccountProxy(String str) {
        this.tempProxy = str;
    }

    public void setNewAccountTransport(TransportType transportType) {
        this.tempTransport = transportType;
    }

    public void setNewAccountUserId(String str) {
        this.tempUserId = str;
    }

    public void setNewAccountUsername(String str) {
        this.tempUsername = str;
    }

    public void setPreferredVideoSize(String str) {
        int i = 512;
        Object obj = LINPHONE_CORE_RANDOM_PORT;
        switch (str.hashCode()) {
            case 1688155:
                if (str.equals("720p")) {
                    obj = null;
                    break;
                }
                break;
            case 3464879:
                if (str.equals("qcif")) {
                    obj = 2;
                    break;
                }
                break;
            case 3483071:
                if (str.equals("qvga")) {
                    obj = 1;
                    break;
                }
                break;
        }
        switch (obj) {
            case VideoSize.QCIF /*0*/:
                i = 1152;
                break;
            case VideoSize.CIF /*1*/:
                i = 380;
                break;
            case VideoSize.HVGA /*2*/:
                i = 256;
                break;
        }
        getLc().setPreferredVideoSizeByName(str);
        getLc().setUploadBandwidth(i);
        getLc().setDownloadBandwidth(i);
    }

    public void setPrefix(int i, String str) {
        LinphoneProxyConfig proxyConfig = getProxyConfig(i);
        proxyConfig.setDialPrefix(str);
        proxyConfig.done();
    }

    public void setPushNotificationEnabled(boolean z) {
        getConfig().setBool("app", "push_notification", z);
    }

    public void setPushNotificationRegistrationID(String str) {
        getConfig().setString("app", "push_notification_regid", str);
    }

    public void setRemoteProvisioningUrl(String str) {
        getConfig().setString("app", "remote_provisioning", str);
    }

    public void setReplacePlusByZeroZero(int i, boolean z) {
        LinphoneProxyConfig proxyConfig = getProxyConfig(i);
        proxyConfig.setDialEscapePlus(z);
        proxyConfig.done();
    }

    public void setRingtone(String str) {
        getConfig().setString("app", "ringtone", str);
    }

    public void setSharingPictureServerUrl(String str) {
        getConfig().setString("app", "sharing_server", str);
    }

    public void setSipPort(int i) {
        Transports signalingTransportPorts = getLc().getSignalingTransportPorts();
        signalingTransportPorts.udp = i;
        signalingTransportPorts.tcp = i;
        signalingTransportPorts.tls = LINPHONE_CORE_RANDOM_PORT;
        getLc().setSignalingTransportPorts(signalingTransportPorts);
    }

    public void setStunServer(String str) {
        getLc().setStunServer(str);
    }

    public void setTunnelHost(String str) {
        getConfig().setString("tunnel", "host", str);
        LinphoneManager.getInstance().initTunnelFromConf();
    }

    public void setTunnelMode(String str) {
        getConfig().setString("app", "tunnel", str);
        LinphoneManager.getInstance().initTunnelFromConf();
    }

    public void setTunnelPort(int i) {
        getConfig().setInt("tunnel", "port", i);
        LinphoneManager.getInstance().initTunnelFromConf();
    }

    public void setUpnpEnabled(boolean z) {
        if (!z) {
            String stunServer = getStunServer();
            if (stunServer == null || stunServer.length() <= 0) {
                getLc().setFirewallPolicy(FirewallPolicy.NoFirewall);
            } else {
                getLc().setFirewallPolicy(FirewallPolicy.UseStun);
            }
        } else if (isIceEnabled()) {
            Log.m11091e("Cannot have both ice and upnp enabled, disabling upnp");
        } else {
            getLc().setFirewallPolicy(FirewallPolicy.UseUpnp);
        }
    }

    public void setWifiOnlyEnabled(Boolean bool) {
        getConfig().setBool("app", "wifi_only", bool.booleanValue());
    }

    public boolean shouldAutomaticallyAcceptFriendsRequests() {
        return false;
    }

    public boolean shouldAutomaticallyAcceptVideoRequests() {
        return getLc().getVideoAutoAcceptPolicy();
    }

    public boolean shouldInitiateVideoCall() {
        return getLc().getVideoAutoInitiatePolicy();
    }

    public boolean useFrontCam() {
        return getConfig().getBool("app", "front_camera_default", true);
    }

    public void useIpv6(Boolean bool) {
        getLc().enableIpv6(bool.booleanValue());
    }

    public void useRandomPort(boolean z) {
        useRandomPort(z, true);
    }

    public void useRandomPort(boolean z, boolean z2) {
        getConfig().setBool("app", "random_port", z);
        if (!z2) {
            return;
        }
        if (z) {
            setSipPort(LINPHONE_CORE_RANDOM_PORT);
        } else {
            setSipPort(5060);
        }
    }

    public boolean useRfc2833Dtmfs() {
        return getLc().getUseRfc2833ForDtmfs();
    }

    public boolean useSipInfoDtmfs() {
        return getLc().getUseSipInfoForDtmfs();
    }
}
