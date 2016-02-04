package org.jivesoftware.smackx.time.packet;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;
import org.jivesoftware.smack.packet.IQ.Type;
import org.p253a.p254a.C2639a;

public class Time extends IQ {
    public static final String ELEMENT = "time";
    private static final Logger LOGGER;
    public static final String NAMESPACE = "urn:xmpp:time";
    private String tzo;
    private String utc;

    static {
        LOGGER = Logger.getLogger(Time.class.getName());
    }

    public Time() {
        super(ELEMENT, NAMESPACE);
        setType(Type.get);
    }

    public Time(Calendar calendar) {
        super(ELEMENT, NAMESPACE);
        this.tzo = C2639a.m11065a(calendar.getTimeZone());
        this.utc = C2639a.m11064a(calendar.getTime());
    }

    public static Time createResponse(IQ iq) {
        Time time = new Time(Calendar.getInstance());
        time.setType(Type.result);
        time.setTo(iq.getFrom());
        return time;
    }

    protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        if (this.utc != null) {
            iQChildElementXmlStringBuilder.append((CharSequence) "<utc>").append(this.utc).append((CharSequence) "</utc>");
            iQChildElementXmlStringBuilder.append((CharSequence) "<tzo>").append(this.tzo).append((CharSequence) "</tzo>");
        } else {
            iQChildElementXmlStringBuilder.setEmptyElement();
        }
        return iQChildElementXmlStringBuilder;
    }

    public Date getTime() {
        Date date = null;
        if (this.utc != null) {
            try {
                date = C2639a.m11071b(this.utc);
            } catch (Throwable e) {
                LOGGER.log(Level.SEVERE, "Error getting local time", e);
            }
        }
        return date;
    }

    public String getTzo() {
        return this.tzo;
    }

    public String getUtc() {
        return this.utc;
    }

    public void setTime(Date date) {
    }

    public void setTzo(String str) {
        this.tzo = str;
    }

    public void setUtc(String str) {
        this.utc = str;
    }
}
