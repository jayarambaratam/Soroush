package org.linphone.core;

import java.util.Vector;

public class OnlineStatus {
    public static OnlineStatus Away;
    public static OnlineStatus BeRightBack;
    public static OnlineStatus Busy;
    public static OnlineStatus DoNotDisturb;
    public static OnlineStatus Offline;
    public static OnlineStatus OnThePhone;
    public static OnlineStatus Online;
    public static OnlineStatus OutToLunch;
    public static OnlineStatus Pending;
    public static OnlineStatus StatusAltService;
    public static OnlineStatus StatusMoved;
    private static Vector<OnlineStatus> values;
    private final String mStringValue;
    protected final int mValue;

    static {
        values = new Vector();
        Offline = new OnlineStatus(0, "Offline");
        Online = new OnlineStatus(1, "Online");
        Busy = new OnlineStatus(2, "Busy");
        BeRightBack = new OnlineStatus(3, "BeRightBack");
        Away = new OnlineStatus(4, "Away");
        OnThePhone = new OnlineStatus(5, "OnThePhone");
        OutToLunch = new OnlineStatus(6, "OutToLunch ");
        DoNotDisturb = new OnlineStatus(7, "DoNotDisturb");
        StatusMoved = new OnlineStatus(8, "StatusMoved");
        StatusAltService = new OnlineStatus(9, "StatusAltService");
        Pending = new OnlineStatus(10, "Pending");
    }

    private OnlineStatus(int i, String str) {
        this.mValue = i;
        values.addElement(this);
        this.mStringValue = str;
    }

    public static OnlineStatus fromInt(int i) {
        for (int i2 = 0; i2 < values.size(); i2++) {
            OnlineStatus onlineStatus = (OnlineStatus) values.elementAt(i2);
            if (onlineStatus.mValue == i) {
                return onlineStatus;
            }
        }
        throw new RuntimeException("state not found [" + i + "]");
    }

    public String toString() {
        return this.mStringValue;
    }
}
