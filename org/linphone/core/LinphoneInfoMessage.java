package org.linphone.core;

public interface LinphoneInfoMessage {
    void addHeader(String str, String str2);

    LinphoneContent getContent();

    String getHeader(String str);

    void setContent(LinphoneContent linphoneContent);
}
