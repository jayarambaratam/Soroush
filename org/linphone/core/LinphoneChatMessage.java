package org.linphone.core;

import java.util.Vector;

public interface LinphoneChatMessage {

    public class State {
        public static final State Delivered;
        public static final State Idle;
        public static final State InProgress;
        public static final State NotDelivered;
        private static Vector<State> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            Idle = new State(0, "Idle");
            InProgress = new State(1, "InProgress");
            Delivered = new State(2, "Delivered");
            NotDelivered = new State(3, "NotDelivered");
        }

        private State(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static State fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                State state = (State) values.elementAt(i2);
                if (state.mValue == i) {
                    return state;
                }
            }
            throw new RuntimeException("state not found [" + i + "]");
        }

        public int toInt() {
            return this.mValue;
        }

        public String toString() {
            return this.mStringValue;
        }

        public final int value() {
            return this.mValue;
        }
    }

    public interface StateListener {
        void onLinphoneChatMessageStateChanged(LinphoneChatMessage linphoneChatMessage, State state);
    }

    void addCustomHeader(String str, String str2);

    String getCustomHeader(String str);

    String getExternalBodyUrl();

    LinphoneAddress getFrom();

    long getNativePtr();

    LinphoneAddress getPeerAddress();

    Reason getReason();

    State getStatus();

    int getStorageId();

    String getText();

    long getTime();

    Object getUserData();

    boolean isOutgoing();

    boolean isRead();

    void setExternalBodyUrl(String str);

    void setUserData();

    void store();
}
