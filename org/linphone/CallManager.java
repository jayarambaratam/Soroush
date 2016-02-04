package org.linphone;

import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCallParams;
import org.linphone.core.LinphoneCore;
import org.linphone.mediastream.Log;

public class CallManager {
    private static CallManager instance;

    private CallManager() {
    }

    private BandwidthManager bm() {
        return BandwidthManager.getInstance();
    }

    public static synchronized CallManager getInstance() {
        CallManager callManager;
        synchronized (CallManager.class) {
            if (instance == null) {
                instance = new CallManager();
            }
            callManager = instance;
        }
        return callManager;
    }

    public void inviteAddress(LinphoneAddress linphoneAddress, boolean z, boolean z2) {
        LinphoneCore lc = LinphoneManager.getLc();
        LinphoneCallParams createDefaultCallParameters = lc.createDefaultCallParameters();
        bm().updateWithProfileSettings(lc, createDefaultCallParameters);
        if (z && createDefaultCallParameters.getVideoEnabled()) {
            createDefaultCallParameters.setVideoEnabled(true);
        } else {
            createDefaultCallParameters.setVideoEnabled(false);
        }
        if (z2) {
            createDefaultCallParameters.enableLowBandwidth(true);
            Log.m11089d("Low bandwidth enabled in call params");
        }
        lc.inviteAddressWithParams(linphoneAddress, createDefaultCallParameters);
    }

    void reinvite() {
        LinphoneCore lc = LinphoneManager.getLc();
        LinphoneCall currentCall = lc.getCurrentCall();
        if (currentCall == null) {
            Log.m11091e("Trying to reinvite while not in call: doing nothing");
            return;
        }
        LinphoneCallParams currentParamsCopy = currentCall.getCurrentParamsCopy();
        bm().updateWithProfileSettings(lc, currentParamsCopy);
        lc.updateCall(currentCall, currentParamsCopy);
    }

    boolean reinviteWithVideo() {
        LinphoneCore lc = LinphoneManager.getLc();
        LinphoneCall currentCall = lc.getCurrentCall();
        if (currentCall == null) {
            Log.m11091e("Trying to reinviteWithVideo while not in call: doing nothing");
            return false;
        }
        LinphoneCallParams currentParamsCopy = currentCall.getCurrentParamsCopy();
        if (currentParamsCopy.getVideoEnabled()) {
            return false;
        }
        bm().updateWithProfileSettings(lc, currentParamsCopy);
        if (!currentParamsCopy.getVideoEnabled()) {
            return false;
        }
        lc.updateCall(currentCall, currentParamsCopy);
        return true;
    }

    public void updateCall() {
        LinphoneCore lc = LinphoneManager.getLc();
        LinphoneCall currentCall = lc.getCurrentCall();
        if (currentCall == null) {
            Log.m11091e("Trying to updateCall while not in call: doing nothing");
            return;
        }
        bm().updateWithProfileSettings(lc, currentCall.getCurrentParamsCopy());
        lc.updateCall(currentCall, null);
    }
}
