package org.linphone.core;

import java.util.Vector;

public interface LinphoneCallLog {

    public class CallStatus {
        public static final CallStatus Aborted;
        public static final CallStatus Declined;
        public static final CallStatus Missed;
        public static final CallStatus Success;
        private static Vector<CallStatus> values;
        private final String mStringValue;
        private final int mValue;

        static {
            values = new Vector();
            Success = new CallStatus(0, "Sucess");
            Aborted = new CallStatus(1, "Aborted");
            Missed = new CallStatus(2, "Missed");
            Declined = new CallStatus(3, "Declined");
        }

        private CallStatus(int i, String str) {
            this.mValue = i;
            values.addElement(this);
            this.mStringValue = str;
        }

        public static CallStatus fromInt(int i) {
            for (int i2 = 0; i2 < values.size(); i2++) {
                CallStatus callStatus = (CallStatus) values.elementAt(i2);
                if (callStatus.mValue == i) {
                    return callStatus;
                }
            }
            throw new RuntimeException("CallStatus not found [" + i + "]");
        }

        public int toInt() {
            return this.mValue;
        }

        public String toString() {
            return this.mStringValue;
        }
    }

    int getCallDuration();

    int getCallId();

    CallDirection getDirection();

    LinphoneAddress getFrom();

    String getStartDate();

    CallStatus getStatus();

    long getTimestamp();

    LinphoneAddress getTo();
}
