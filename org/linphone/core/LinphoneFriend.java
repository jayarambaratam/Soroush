package org.linphone.core;

import java.util.Vector;

public interface LinphoneFriend {

    public class SubscribePolicy {
        public static final SubscribePolicy SPAccept;
        public static final SubscribePolicy SPDeny;
        public static final SubscribePolicy SPWait;
        private static Vector<SubscribePolicy> values;
        private final String mStringValue;
        protected final int mValue;

        static {
            values = new Vector();
            SPWait = new SubscribePolicy(0, "SPWait");
            SPDeny = new SubscribePolicy(1, "SPDeny");
            SPAccept = new SubscribePolicy(2, "SPAccept");
        }

        private SubscribePolicy(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static SubscribePolicy fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                SubscribePolicy subscribePolicy = (SubscribePolicy) values.elementAt(i2);
                if (subscribePolicy.mValue == i) {
                    return subscribePolicy;
                }
            }
            throw new RuntimeException("Policy not found [" + i + "]");
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    void done();

    void edit();

    void enableSubscribes(boolean z);

    LinphoneAddress getAddress();

    SubscribePolicy getIncSubscribePolicy();

    long getNativePtr();

    PresenceModel getPresenceModel();

    OnlineStatus getStatus();

    boolean isSubscribesEnabled();

    void setAddress(LinphoneAddress linphoneAddress);

    void setIncSubscribePolicy(SubscribePolicy subscribePolicy);

    String toString();
}
