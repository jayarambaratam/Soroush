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
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.LinphoneCoreListener;
import org.linphone.core.LinphoneEvent;
import org.linphone.core.LinphoneFriend;
import org.linphone.core.LinphoneFriend.SubscribePolicy;
import org.linphone.core.LinphoneInfoMessage;
import org.linphone.core.LinphoneProxyConfig;
import org.linphone.core.OnlineStatus;
import org.linphone.core.PublishState;
import org.linphone.core.SubscriptionState;

public class TutorialBuddyStatus implements LinphoneCoreListener {
    private TutorialNotifier TutorialNotifier;
    private boolean running;

    public TutorialBuddyStatus() {
        this.TutorialNotifier = new TutorialNotifier();
    }

    public TutorialBuddyStatus(TutorialNotifier tutorialNotifier) {
        this.TutorialNotifier = tutorialNotifier;
    }

    public static void main(String[] strArr) {
        String str = null;
        if (strArr.length < 1 || strArr.length > 3) {
            throw new IllegalArgumentException("Bad number of arguments [" + strArr.length + "] should be 1, 2 or 3");
        }
        TutorialBuddyStatus tutorialBuddyStatus = new TutorialBuddyStatus();
        try {
            String str2 = strArr[1];
            String str3 = strArr.length > 1 ? strArr[1] : null;
            if (strArr.length > 2) {
                str = strArr[2];
            }
            tutorialBuddyStatus.launchTutorial(str2, str3, str);
        } catch (Exception e) {
            e.printStackTrace();
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

    public void launchTutorial(String str, String str2, String str3) {
        LinphoneCoreFactory instance = LinphoneCoreFactory.instance();
        LinphoneCore createLinphoneCore = instance.createLinphoneCore(this, null);
        try {
            LinphoneFriend createLinphoneFriend = instance.createLinphoneFriend(str);
            if (createLinphoneFriend == null) {
                write("Could not create friend; weird SIP address?");
                write("Shutting down...");
                createLinphoneCore.destroy();
                write("Exited");
                return;
            }
            if (str2 != null) {
                LinphoneAddress createLinphoneAddress = instance.createLinphoneAddress(str2);
                String userName = createLinphoneAddress.getUserName();
                String domain = createLinphoneAddress.getDomain();
                if (str3 != null) {
                    createLinphoneCore.addAuthInfo(instance.createAuthInfo(userName, str3, null, domain));
                }
                LinphoneProxyConfig createProxyConfig = instance.createProxyConfig(str2, domain, null, true);
                createProxyConfig.enablePublish(true);
                createLinphoneCore.addProxyConfig(createProxyConfig);
                createLinphoneCore.setDefaultProxyConfig(createProxyConfig);
                while (!createProxyConfig.isRegistered()) {
                    createLinphoneCore.iterate();
                    Thread.sleep(1000);
                }
            }
            createLinphoneFriend.enableSubscribes(true);
            createLinphoneFriend.setIncSubscribePolicy(SubscribePolicy.SPAccept);
            try {
                createLinphoneCore.addFriend(createLinphoneFriend);
                createLinphoneCore.setPresenceInfo(0, null, OnlineStatus.Online);
                this.running = true;
                while (this.running) {
                    createLinphoneCore.iterate();
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        write("Interrupted!\nAborting");
                        write("Shutting down...");
                        createLinphoneCore.destroy();
                        write("Exited");
                        return;
                    }
                }
                createLinphoneCore.setPresenceInfo(0, null, OnlineStatus.Offline);
                createLinphoneCore.iterate();
                createLinphoneFriend.edit();
                createLinphoneFriend.enableSubscribes(false);
                createLinphoneFriend.done();
                createLinphoneCore.iterate();
                write("Shutting down...");
                createLinphoneCore.destroy();
                write("Exited");
            } catch (LinphoneCoreException e2) {
                write("Error while adding friend " + createLinphoneFriend.getAddress().getUserName() + " to linphone");
                write("Shutting down...");
                createLinphoneCore.destroy();
                write("Exited");
            }
        } catch (InterruptedException e3) {
            write("Interrupted!\nAborting");
            write("Shutting down...");
            createLinphoneCore.destroy();
            write("Exited");
        } catch (Throwable th) {
            write("Shutting down...");
            createLinphoneCore.destroy();
            write("Exited");
        }
    }

    public void messageReceived(LinphoneCore linphoneCore, LinphoneChatRoom linphoneChatRoom, LinphoneChatMessage linphoneChatMessage) {
    }

    public void newSubscriptionRequest(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend, String str) {
        write("[" + linphoneFriend.getAddress().getUserName() + "] wants to see your status, accepting");
        linphoneFriend.edit();
        linphoneFriend.setIncSubscribePolicy(SubscribePolicy.SPAccept);
        linphoneFriend.done();
        try {
            linphoneCore.addFriend(linphoneFriend);
        } catch (LinphoneCoreException e) {
            write("Error while adding friend [" + linphoneFriend.getAddress().getUserName() + "] to linphone in the callback");
        }
    }

    public void notifyPresenceReceived(LinphoneCore linphoneCore, LinphoneFriend linphoneFriend) {
        write("New state [" + linphoneFriend.getStatus() + "] for user id [" + linphoneFriend.getAddress().getUserName() + "]");
    }

    public void notifyReceived(LinphoneCore linphoneCore, LinphoneCall linphoneCall, LinphoneAddress linphoneAddress, byte[] bArr) {
    }

    public void notifyReceived(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, String str, LinphoneContent linphoneContent) {
    }

    public void publishStateChanged(LinphoneCore linphoneCore, LinphoneEvent linphoneEvent, PublishState publishState) {
    }

    public void registrationState(LinphoneCore linphoneCore, LinphoneProxyConfig linphoneProxyConfig, RegistrationState registrationState, String str) {
        write(linphoneProxyConfig.getIdentity() + " : " + str + "\n");
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
