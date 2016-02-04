package org.linphone.core;

public interface PresenceNote {
    String getContent();

    String getLang();

    long getNativePtr();

    int setContent(String str);

    int setLang(String str);
}
