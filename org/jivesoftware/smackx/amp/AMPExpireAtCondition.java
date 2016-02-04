package org.jivesoftware.smackx.amp;

import java.util.Date;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smackx.amp.packet.AMPExtension.Condition;
import org.p253a.p254a.C2639a;

public class AMPExpireAtCondition implements Condition {
    public static final String NAME = "expire-at";
    private final String value;

    public AMPExpireAtCondition(String str) {
        if (str == null) {
            throw new NullPointerException("Can't create AMPExpireAtCondition with null value");
        }
        this.value = str;
    }

    public AMPExpireAtCondition(Date date) {
        if (date == null) {
            throw new NullPointerException("Can't create AMPExpireAtCondition with null value");
        }
        this.value = C2639a.m11064a(date);
    }

    public static boolean isSupported(XMPPConnection xMPPConnection) {
        return AMPManager.isConditionSupported(xMPPConnection, NAME);
    }

    public String getName() {
        return NAME;
    }

    public String getValue() {
        return this.value;
    }
}
