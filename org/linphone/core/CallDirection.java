package org.linphone.core;

public class CallDirection {
    public static CallDirection Incoming;
    public static CallDirection Outgoing;
    private String mStringValue;

    static {
        Outgoing = new CallDirection("CallOutgoing");
        Incoming = new CallDirection("Callincoming");
    }

    private CallDirection(String str) {
        this.mStringValue = str;
    }

    public String toString() {
        return this.mStringValue;
    }
}
