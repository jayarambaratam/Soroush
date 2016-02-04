package org.jivesoftware.smackx.delay.provider;

import java.util.Date;
import org.p253a.p254a.C2639a;

public class LegacyDelayInformationProvider extends AbstractDelayInformationProvider {
    protected Date parseDate(String str) {
        return C2639a.m11071b(str);
    }
}
