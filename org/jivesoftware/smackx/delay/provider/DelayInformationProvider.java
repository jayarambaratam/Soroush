package org.jivesoftware.smackx.delay.provider;

import java.util.Date;
import org.p253a.p254a.C2639a;

public class DelayInformationProvider extends AbstractDelayInformationProvider {
    public static final DelayInformationProvider INSTANCE;

    static {
        INSTANCE = new DelayInformationProvider();
    }

    protected Date parseDate(String str) {
        return C2639a.m11068a(str);
    }
}
