package org.jivesoftware.smack.packet;

import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.linphone.core.VideoSize;

public class StreamOpen extends FullStreamElement {
    public static final String CLIENT_NAMESPACE = "jabber:client";
    public static final String ELEMENT = "stream:stream";
    public static final String SERVER_NAMESPACE = "jabber:server";
    public static final String VERSION = "1.0";
    private final String contentNamespace;
    private final String from;
    private final String id;
    private final String lang;
    private final String to;

    /* renamed from: org.jivesoftware.smack.packet.StreamOpen.1 */
    /* synthetic */ class C26761 {
        static final /* synthetic */ int[] f8404x2ba30084;

        static {
            f8404x2ba30084 = new int[StreamContentNamespace.values().length];
            try {
                f8404x2ba30084[StreamContentNamespace.client.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8404x2ba30084[StreamContentNamespace.server.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum StreamContentNamespace {
        client,
        server
    }

    public StreamOpen(CharSequence charSequence) {
        this(charSequence, null, null, null, StreamContentNamespace.client);
    }

    public StreamOpen(CharSequence charSequence, CharSequence charSequence2, String str) {
        this(charSequence, charSequence2, str, "en", StreamContentNamespace.client);
    }

    public StreamOpen(CharSequence charSequence, CharSequence charSequence2, String str, String str2, StreamContentNamespace streamContentNamespace) {
        this.to = StringUtils.maybeToString(charSequence);
        this.from = StringUtils.maybeToString(charSequence2);
        this.id = str;
        this.lang = str2;
        switch (C26761.f8404x2ba30084[streamContentNamespace.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.contentNamespace = CLIENT_NAMESPACE;
            case VideoSize.HVGA /*2*/:
                this.contentNamespace = SERVER_NAMESPACE;
            default:
                throw new IllegalStateException();
        }
    }

    public String getElementName() {
        return ELEMENT;
    }

    public String getNamespace() {
        return this.contentNamespace;
    }

    public XmlStringBuilder toXML() {
        XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((ExtensionElement) this);
        xmlStringBuilder.attribute(PrivacyItem.SUBSCRIPTION_TO, this.to);
        xmlStringBuilder.attribute("xmlns:stream", "http://etherx.jabber.org/streams");
        xmlStringBuilder.attribute("version", VERSION);
        xmlStringBuilder.optAttribute(PrivacyItem.SUBSCRIPTION_FROM, this.from);
        xmlStringBuilder.optAttribute("id", this.id);
        xmlStringBuilder.xmllangAttribute(this.lang);
        xmlStringBuilder.rightAngleBracket();
        return xmlStringBuilder;
    }
}
