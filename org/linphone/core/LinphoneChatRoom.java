package org.linphone.core;

import org.linphone.core.LinphoneChatMessage.State;
import org.linphone.core.LinphoneChatMessage.StateListener;

public interface LinphoneChatRoom {
    void compose();

    LinphoneChatMessage createLinphoneChatMessage(String str);

    LinphoneChatMessage createLinphoneChatMessage(String str, String str2, State state, long j, boolean z, boolean z2);

    void deleteHistory();

    void deleteMessage(LinphoneChatMessage linphoneChatMessage);

    void destroy();

    LinphoneChatMessage[] getHistory();

    LinphoneChatMessage[] getHistory(int i);

    LinphoneAddress getPeerAddress();

    int getUnreadMessagesCount();

    boolean isRemoteComposing();

    void markAsRead();

    void sendMessage(String str);

    void sendMessage(LinphoneChatMessage linphoneChatMessage, StateListener stateListener);

    void updateUrl(LinphoneChatMessage linphoneChatMessage);
}
