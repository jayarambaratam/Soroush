package org.linphone.core.tutorials;

import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCallStats;
import org.linphone.core.LinphoneChatMessage;
import org.linphone.core.LinphoneChatRoom;
import org.linphone.core.LinphoneContent;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCore.EcCalibratorStatus;
import org.linphone.core.LinphoneCore.GlobalState;
import org.linphone.core.LinphoneCore.RegistrationState;
import org.linphone.core.LinphoneCore.RemoteProvisioningState;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;

public class TutorialRegistration implements LinphoneCoreListener {
    private TutorialNotifier TutorialNotifier;
    private boolean running;

    public TutorialRegistration() {
        this.TutorialNotifier = new TutorialNotifier();
    }

    public TutorialRegistration(TutorialNotifier tutorialNotifier) {
        this.TutorialNotifier = tutorialNotifier;
    }

    public static void main(String[] strArr) {
        if (strArr.length != 2) {
            throw new IllegalArgumentException("Bad number of arguments");
        }
        try {
            new TutorialRegistration().launchTutorial(strArr[1], strArr[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sleep(int i) {
        try {
            Thread.sleep((long) i);
        } catch (InterruptedException e) {
            write("Interrupted!\nAborting");
        }
    }

    private void write(String str) {
        this.TutorialNotifier.notify(str);
    }

    public void authInfoRequested(LinphoneCore linphoneCore, String str, String str2) {
    }

    public void byeReceived(LinphoneCore linphoneCore, String str) {
    }

    public void callEncryptionChanged(LinphoneCore linphoneCore, LinphoneCall linphoneCall, boolean z, String str) {
    }

    public void callState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, State state, String str) {
    }

    public void callStatsUpdated(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneCallStats linphoneCallStats) {
    }

    public void configuringStatus(LinphoneCore linphoneCore, RemoteProvisioningState remoteProvisioningState, String str) {
    }

    public void displayMessage(LinphoneCore linphoneCore, String str) {
    }

    public void displayStatus(LinphoneCore linphoneCore, String str) {
    }

    public void displayWarning(LinphoneCore linphoneCore, String str) {
    }

    public void dtmfReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, int i) {
    }

    public void ecCalibrationStatus(LinphoneCore linphoneCore, EcCalibratorStatus ecCalibratorStatus, int i, Object obj) {
    }

    public void globalState(LinphoneCore linphoneCore, GlobalState globalState, String str) {
    }

    public void infoReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneInfoMessage linphoneInfoMessage) {
    }

    public void isComposingReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom) {
    }

    public void launchTutorial(String str, String str2) {
        LinphoneCoreFactory instance = LinphoneCoreFactory.instance();
        LinphoneCore createLinphoneCore = instance.createLinphoneCore(this, null);
        try {
            LinphoneAddress createLinphoneAddress = instance.createLinphoneAddress(str);
            String userName = createLinphoneAddress.getUserName();
            String domain = createLinphoneAddress.getDomain();
            if (str2 != null) {
                createLinphoneCore.addAuthInfo(instance.createAuthInfo(userName, str2, null, domain));
            }
            LinphoneProxyConfig createProxyConfig = instance.createProxyConfig(str, domain, null, true);
            createProxyConfig.setExpires(2000);
            createLinphoneCore.addProxyConfig(createProxyConfig);
            createLinphoneCore.setDefaultProxyConfig(createProxyConfig);
            this.running = true;
            while (this.running) {
                createLinphoneCore.iterate();
                sleep(50);
            }
            createLinphoneCore.getDefaultProxyConfig().edit();
            createLinphoneCore.getDefaultProxyConfig().enableRegister(false);
            createLinphoneCore.getDefaultProxyConfig().done();
            while (createLinphoneCore.getDefaultProxyConfig().getState() != RegistrationState.RegistrationCleared) {
                createLinphoneCore.iterate();
                sleep(50);
            }
            createLinphoneCore.getDefaultProxyConfig().edit();
            createLinphoneCore.getDefaultProxyConfig().enableRegister(true);
            createLinphoneCore.getDefaultProxyConfig().done();
            while (createLinphoneCore.getDefaultProxyConfig().getState() != RegistrationState.RegistrationOk && createLinphoneCore.getDefaultProxyConfig().getState() != RegistrationState.RegistrationFailed) {
                createLinphoneCore.iterate();
                sleep(50);
            }
            write("Shutting down linphone...");
            createLinphoneCore.destroy();
        } catch (Throwable th) {
            write("Shutting down linphone...");
            createLinphoneCore.destroy();
        }
    }

    public void messageReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    public void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str) {
    }

    public void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend) {
    }

    public void notifyReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneAddress linphoneAddress, byte[] bArr) {
    }

    public void notifyReceived(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, String str, LinphoneContent linphoneContent) {
    }

    public void publishStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, PublishState publishState) {
    }

    public void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, RegistrationState registrationState, String str) {
        write(linphoneProxyConfig.getIdentity() + " : " + str);
    }

    public void show(LinphoneCore linphoneCore) {
    }

    public void stopMainLoop() {
        this.running = false;
    }

    public void subscriptionStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, SubscriptionState subscriptionState) {
    }

    public void textReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneAddress linphoneAddress, String str) {
    }

    public void transferState(LinphoneCore linphoneCore, LinphoneCall linphoneCall, State state) {
    }
}
