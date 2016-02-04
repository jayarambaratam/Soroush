package org.linphone.core;

import org.linphone.core.LinphoneCore.RegistrationState;

public interface LinphoneProxyConfig {
    void done();

    LinphoneProxyConfig edit();

    void enablePublish(boolean z);

    LinphoneProxyConfig enableRegister(boolean z);

    String getContactParameters();

    String getContactUriParameters();

    boolean getDialEscapePlus();

    String getDialPrefix();

    String getDomain();

    Reason getError();

    int getExpires();

    String getIdentity();

    int getPrivacy();

    String getProxy();

    String getRoute();

    RegistrationState getState();

    boolean isRegistered();

    int lookupCCCFromE164(String str);

    int lookupCCCFromIso(String str);

    String normalizePhoneNumber(String str);

    boolean publishEnabled();

    boolean registerEnabled();

    void setContactParameters(String str);

    void setContactUriParameters(String str);

    void setDialEscapePlus(boolean z);

    void setDialPrefix(String str);

    void setExpires(int i);

    void setIdentity(String str);

    void setPrivacy(int i);

    void setProxy(String str);

    void setRoute(String str);
}
