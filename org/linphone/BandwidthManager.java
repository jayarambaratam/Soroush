package org.linphone;

import org.linphone.core.LinphoneCallParams;
import org.linphone.core.LinphoneCore;

public class BandwidthManager {
    public static final int HIGH_RESOLUTION = 0;
    public static final int LOW_BANDWIDTH = 2;
    public static final int LOW_RESOLUTION = 1;
    private static BandwidthManager instance;
    private int currentProfile;

    private BandwidthManager() {
        this.currentProfile = HIGH_RESOLUTION;
    }

    public static synchronized BandwidthManager getInstance() {
        BandwidthManager bandwidthManager;
        synchronized (BandwidthManager.class) {
            if (instance == null) {
                instance = new BandwidthManager();
            }
            bandwidthManager = instance;
        }
        return bandwidthManager;
    }

    public int getCurrentProfile() {
        return this.currentProfile;
    }

    public boolean isVideoPossible() {
        return this.currentProfile != LOW_BANDWIDTH;
    }

    public void updateWithProfileSettings(LinphoneCore linphoneCore, LinphoneCallParams linphoneCallParams) {
        if (linphoneCallParams == null) {
            return;
        }
        if (isVideoPossible()) {
            linphoneCallParams.setVideoEnabled(true);
            linphoneCallParams.setAudioBandwidth(HIGH_RESOLUTION);
            return;
        }
        linphoneCallParams.setVideoEnabled(false);
        linphoneCallParams.setAudioBandwidth(40);
    }
}
