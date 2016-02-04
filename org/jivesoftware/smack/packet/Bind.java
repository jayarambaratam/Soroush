package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;
import org.jivesoftware.smack.packet.IQ.Type;

public class Bind extends IQ {
    public static final String ELEMENT = "bind";
    public static final String NAMESPACE = "urn:ietf:params:xml:ns:xmpp-bind";
    private final String jid;
    private final String resource;

    public class Feature implements ExtensionElement {
        public static final Feature INSTANCE;

        static {
            INSTANCE = new Feature();
        }

        private Feature() {
        }

        public String getElementName() {
            return Bind.ELEMENT;
        }

        public String getNamespace() {
            return Bind.NAMESPACE;
        }

        public String toXML() {
            return "<bind xmlns='urn:ietf:params:xml:ns:xmpp-bind'/>";
        }
    }

    public Bind(String str, String str2) {
        super(ELEMENT, NAMESPACE);
        this.resource = str;
        this.jid = str2;
    }

    public static Bind newResult(String str) {
        return new Bind(null, str);
    }

    public static Bind newSet(String str) {
        Bind bind = new Bind(str, null);
        bind.setType(Type.set);
        return bind;
    }

    protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        iQChildElementXmlStringBuilder.rightAngleBracket();
        iQChildElementXmlStringBuilder.optElement("resource", this.resource);
        iQChildElementXmlStringBuilder.optElement("jid", this.jid);
        return iQChildElementXmlStringBuilder;
    }

    public String getJid() {
        return this.jid;
    }

    public String getResource() {
        return this.resource;
    }
}
