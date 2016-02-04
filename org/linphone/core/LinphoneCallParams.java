package org.linphone.core;

import org.linphone.core.LinphoneCore.MediaEncryption;

public interface LinphoneCallParams {
    void addCustomHeader(String str, String str2);

    void enableLowBandwidth(boolean z);

    String getCustomHeader(String str);

    MediaEncryption getMediaEncryption();

    int getPrivacy();

    String getSessionName();

    PayloadType getUsedAudioCodec();

    PayloadType getUsedVideoCodec();

    boolean getVideoEnabled();

    boolean isLowBandwidthEnabled();

    void setAudioBandwidth(int i);

    void setMediaEnctyption(MediaEncryption mediaEncryption);

    void setPrivacy(int i);

    void setRecordFile(String str);

    void setSessionName(String str);

    void setVideoEnabled(boolean z);
}
