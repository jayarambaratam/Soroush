package org.jivesoftware.smackx.bytestreams.socks5.packet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smack.packet.NamedElement;
import org.jivesoftware.smack.util.XmlStringBuilder;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class Bytestream extends IQ {
    public static final String ELEMENT = "query";
    public static final String NAMESPACE = "http://jabber.org/protocol/bytestreams";
    private Mode mode;
    private String sessionID;
    private final List<StreamHost> streamHosts;
    private Activate toActivate;
    private StreamHostUsed usedHost;

    /* renamed from: org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.1 */
    /* synthetic */ class C27121 {
        static final /* synthetic */ int[] $SwitchMap$org$jivesoftware$smack$packet$IQ$Type;

        static {
            $SwitchMap$org$jivesoftware$smack$packet$IQ$Type = new int[Type.values().length];
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[Type.set.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[Type.result.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$jivesoftware$smack$packet$IQ$Type[Type.get.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public class Activate implements NamedElement {
        public static String ELEMENTNAME;
        private final String target;

        static {
            ELEMENTNAME = "activate";
        }

        public Activate(String str) {
            this.target = str;
        }

        public String getElementName() {
            return ELEMENTNAME;
        }

        public String getTarget() {
            return this.target;
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
            xmlStringBuilder.rightAngleBracket();
            xmlStringBuilder.escape(getTarget());
            xmlStringBuilder.closeElement((NamedElement) this);
            return xmlStringBuilder;
        }
    }

    public enum Mode {
        tcp,
        udp;

        public static Mode fromName(String str) {
            try {
                return valueOf(str);
            } catch (Exception e) {
                return tcp;
            }
        }
    }

    public class StreamHost implements NamedElement {
        public static String ELEMENTNAME;
        private final String JID;
        private final String addy;
        private final int port;

        static {
            ELEMENTNAME = "streamhost";
        }

        public StreamHost(String str, String str2) {
            this(str, str2, 0);
        }

        public StreamHost(String str, String str2, int i) {
            this.JID = str;
            this.addy = str2;
            this.port = i;
        }

        public String getAddress() {
            return this.addy;
        }

        public String getElementName() {
            return ELEMENTNAME;
        }

        public String getJID() {
            return this.JID;
        }

        public int getPort() {
            return this.port;
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
            xmlStringBuilder.attribute("jid", getJID());
            xmlStringBuilder.attribute("host", getAddress());
            if (getPort() != 0) {
                xmlStringBuilder.attribute("port", Integer.toString(getPort()));
            } else {
                xmlStringBuilder.attribute("zeroconf", "_jabber.bytestreams");
            }
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public class StreamHostUsed implements NamedElement {
        public static String ELEMENTNAME;
        private final String JID;

        static {
            ELEMENTNAME = "streamhost-used";
        }

        public StreamHostUsed(String str) {
            this.JID = str;
        }

        public String getElementName() {
            return ELEMENTNAME;
        }

        public String getJID() {
            return this.JID;
        }

        public XmlStringBuilder toXML() {
            XmlStringBuilder xmlStringBuilder = new XmlStringBuilder((NamedElement) this);
            xmlStringBuilder.attribute("jid", getJID());
            xmlStringBuilder.closeEmptyElement();
            return xmlStringBuilder;
        }
    }

    public Bytestream() {
        super(ELEMENT, NAMESPACE);
        this.mode = Mode.tcp;
        this.streamHosts = new ArrayList();
    }

    public Bytestream(String str) {
        this();
        setSessionID(str);
    }

    public StreamHost addStreamHost(String str, String str2) {
        return addStreamHost(str, str2, 0);
    }

    public StreamHost addStreamHost(String str, String str2, int i) {
        StreamHost streamHost = new StreamHost(str, str2, i);
        addStreamHost(streamHost);
        return streamHost;
    }

    public void addStreamHost(StreamHost streamHost) {
        this.streamHosts.add(streamHost);
    }

    public int countStreamHosts() {
        return this.streamHosts.size();
    }

    protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        switch (C27121.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()]) {
            case VideoSize.CIF /*1*/:
                iQChildElementXmlStringBuilder.optAttribute("sid", getSessionID());
                iQChildElementXmlStringBuilder.optAttribute("mode", getMode());
                iQChildElementXmlStringBuilder.rightAngleBracket();
                if (getToActivate() != null) {
                    iQChildElementXmlStringBuilder.append(getToActivate().toXML());
                    break;
                }
                for (StreamHost toXML : getStreamHosts()) {
                    iQChildElementXmlStringBuilder.append(toXML.toXML());
                }
                break;
            case VideoSize.HVGA /*2*/:
                iQChildElementXmlStringBuilder.rightAngleBracket();
                iQChildElementXmlStringBuilder.optAppend(getUsedHost());
                for (StreamHost toXML2 : this.streamHosts) {
                    iQChildElementXmlStringBuilder.append(toXML2.toXML());
                }
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                iQChildElementXmlStringBuilder.setEmptyElement();
                break;
            default:
                throw new IllegalStateException();
        }
        return iQChildElementXmlStringBuilder;
    }

    public Mode getMode() {
        return this.mode;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public StreamHost getStreamHost(String str) {
        if (str == null) {
            return null;
        }
        for (StreamHost streamHost : this.streamHosts) {
            if (streamHost.getJID().equals(str)) {
                return streamHost;
            }
        }
        return null;
    }

    public List<StreamHost> getStreamHosts() {
        return Collections.unmodifiableList(this.streamHosts);
    }

    public Activate getToActivate() {
        return this.toActivate;
    }

    public StreamHostUsed getUsedHost() {
        return this.usedHost;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public void setSessionID(String str) {
        this.sessionID = str;
    }

    public void setToActivate(String str) {
        this.toActivate = new Activate(str);
    }

    public void setUsedHost(String str) {
        this.usedHost = new StreamHostUsed(str);
    }
}
