package org.jivesoftware.smackx.forward.packet;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.delay.packet.DelayInformation;

public class Forwarded implements ExtensionElement {
    public static final String ELEMENT = "forwarded";
    public static final String NAMESPACE = "urn:xmpp:forward:0";
    private final DelayInformation delay;
    private final Stanza forwardedPacket;

    public Forwarded(Stanza stanza) {
        this(null, stanza);
    }

    public Forwarded(DelayInformation delayInformation, Stanza stanza) {
        this.delay = delayInformation;
        this.forwardedPacket = stanza;
    }

    public static Forwarded from(Stanza stanza) {
        return (Forwarded) stanza.getExtension(ELEMENT, NAMESPACE);
    }

    public DelayInformation getDelayInformation() {
        return this.delay;
    }

    public String getElementName() {
        return ELEMENT;
    }

    public Stanza getForwardedPacket() {
        return this.forwardedPacket;
    }

    public String getNamespace() {
        return NAMESPACE;
    }

    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.rightAngleBracket();
        xmlStringBuilder.optElement(getDelayInformation());
        xmlStringBuilder.append(this.forwardedPacket.toXML());
        xmlStringBuilder.closeElement((NamedElement) this);
        return xmlStringBuilder;
    }
}
