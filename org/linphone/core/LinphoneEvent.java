package org.linphone.core;

public interface LinphoneEvent {
    void acceptSubscription();

    void denySubscription(Reason reason);

    String getEventName();

    Reason getReason();

    SubscriptionDir getSubscriptionDir();

    SubscriptionState getSubscriptionState();

    Object getUserContext();

    void notify(LinphoneContent linphoneContent);

    void setUserContext(Object obj);

    void terminate();

    void updatePublish(LinphoneContent linphoneContent);

    void updateSubscribe(LinphoneContent linphoneContent);
}
