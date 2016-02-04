package org.linphone.core;

public interface PayloadType {
    String getMime();

    int getRate();

    String getRecvFmtp();

    String getSendFmtp();

    void setRecvFmtp(String str);

    void setSendFmtp(String str);
}
