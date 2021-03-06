package org.jivesoftware.smackx.bytestreams.ibb.packet;

import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;
import org.jivesoftware.smack.packet.IQ.Type;

public class Close extends IQ {
    public static final String ELEMENT = "close";
    public static final String NAMESPACE = "http://jabber.org/protocol/ibb";
    private final String sessionID;

    public Close(String str) {
        super(ELEMENT, NAMESPACE);
        if (str == null || BuildConfig.FLAVOR.equals(str)) {
            throw new IllegalArgumentException("Session ID must not be null or empty");
        }
        this.sessionID = str;
        setType(Type.set);
    }

    protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.attribute("sid", this.sessionID);
        iQChildElementXmlStringBuilder.setEmptyElement();
        return iQChildElementXmlStringBuilder;
    }

    public String getSessionID() {
        return this.sessionID;
    }
}
