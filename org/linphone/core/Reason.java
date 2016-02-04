package org.linphone.core;

import java.util.Vector;

public class Reason {
    public static Reason BadCredentials;
    public static Reason Busy;
    public static Reason Declined;
    public static Reason DoNotDisturb;
    public static Reason IOError;
    public static Reason Media;
    public static Reason NoMatch;
    public static Reason NoResponse;
    public static Reason None;
    public static Reason NotAcceptable;
    public static Reason NotAnswered;
    public static Reason NotFound;
    public static Reason Unauthorized;
    private static Vector<Reason> values;
    private final String mStringValue;
    protected final int mValue;

    static {
        values = new Vector();
        None = new Reason(0, "None");
        NoResponse = new Reason(1, "NoResponse");
        BadCredentials = new Reason(2, "BadCredentials");
        Declined = new Reason(3, "Declined");
        NotFound = new Reason(4, "NotFound");
        NotAnswered = new Reason(5, "NotAnswered");
        Busy = new Reason(6, "Busy");
        Media = new Reason(7, "Media");
        IOError = new Reason(8, "IOError");
        DoNotDisturb = new Reason(9, "DoNotDisturb");
        Unauthorized = new Reason(10, "Unauthorized");
        NotAcceptable = new Reason(11, "NotAcceptable");
        NoMatch = new Reason(12, "NoMatch");
    }

    private Reason(int i, String str) {
        this.mValue = i;
        values.addElement(this);
        this.mStringValue = str;
    }

    public static Reason fromInt(int i) {
        for (int i2 = 0; i2 < values.size(); i2++) {
            Reason reason = (Reason) values.elementAt(i2);
            if (reason.mValue == i) {
                return reason;
            }
        }
        throw new RuntimeException("Reason not found [" + i + "]");
    }

    public String toString() {
        return this.mStringValue;
    }
}
