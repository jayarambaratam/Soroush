package org.jivesoftware.smackx.pubsub;

import java.util.Locale;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;

public enum FormNodeType {
    CONFIGURE_OWNER,
    CONFIGURE,
    OPTIONS,
    DEFAULT;

    public static FormNodeType valueOfFromElementName(String str, String str2) {
        return ("configure".equals(str) && PubSubNamespace.OWNER.getXmlns().equals(str2)) ? CONFIGURE_OWNER : valueOf(str.toUpperCase(Locale.US));
    }

    public PubSubElementType getNodeElement() {
        return PubSubElementType.valueOf(toString());
    }
}
