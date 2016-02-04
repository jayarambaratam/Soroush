package org.jivesoftware.smackx.pubsub;

import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.packet.ExtensionElement;

public class NodeExtension implements ExtensionElement {
    private final PubSubElementType element;
    private final String node;

    public NodeExtension(PubSubElementType pubSubElementType) {
        this(pubSubElementType, null);
    }

    public NodeExtension(PubSubElementType pubSubElementType, String str) {
        this.element = pubSubElementType;
        this.node = str;
    }

    public String getElementName() {
        return this.element.getElementName();
    }

    public String getNamespace() {
        return this.element.getNamespace().getXmlns();
    }

    public String getNode() {
        return this.node;
    }

    public String toString() {
        return getClass().getName() + " - content [" + toXML() + "]";
    }

    public CharSequence toXML() {
        return '<' + getElementName() + (this.node == null ? BuildConfig.FLAVOR : " node='" + this.node + '\'') + "/>";
    }
}
