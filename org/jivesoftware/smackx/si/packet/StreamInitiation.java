package org.jivesoftware.smackx.si.packet;

import java.util.Date;
import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.IQ.IQChildElementXmlStringBuilder;
import org.jivesoftware.smack.packet.IQ.Type;
import org.jivesoftware.smack.util.StringUtils;
import org.jivesoftware.smackx.filetransfer.FileTransferNegotiator;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.linphone.core.VideoSize;
import org.p253a.p254a.C2639a;

public class StreamInitiation extends IQ {
    public static final String ELEMENT = "si";
    public static final String NAMESPACE = "http://jabber.org/protocol/si";
    private Feature featureNegotiation;
    private File file;
    private String id;
    private String mimeType;

    /* renamed from: org.jivesoftware.smackx.si.packet.StreamInitiation.1 */
    /* synthetic */ class C27811 {
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
        }
    }

    public class Feature implements ExtensionElement {
        private final DataForm data;

        public Feature(DataForm dataForm) {
            this.data = dataForm;
        }

        public DataForm getData() {
            return this.data;
        }

        public String getElementName() {
            return "feature";
        }

        public String getNamespace() {
            return "http://jabber.org/protocol/feature-neg";
        }

        public String toXML() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<feature xmlns=\"http://jabber.org/protocol/feature-neg\">");
            stringBuilder.append(this.data.toXML());
            stringBuilder.append("</feature>");
            return stringBuilder.toString();
        }
    }

    public class File implements ExtensionElement {
        private Date date;
        private String desc;
        private String hash;
        private boolean isRanged;
        private final String name;
        private final long size;

        public File(String str, long j) {
            if (str == null) {
                throw new NullPointerException("name cannot be null");
            }
            this.name = str;
            this.size = j;
        }

        public Date getDate() {
            return this.date;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getElementName() {
            return "file";
        }

        public String getHash() {
            return this.hash;
        }

        public String getName() {
            return this.name;
        }

        public String getNamespace() {
            return FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE;
        }

        public long getSize() {
            return this.size;
        }

        public boolean isRanged() {
            return this.isRanged;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setHash(String str) {
            this.hash = str;
        }

        public void setRanged(boolean z) {
            this.isRanged = z;
        }

        public String toXML() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<").append(getElementName()).append(" xmlns=\"").append(getNamespace()).append("\" ");
            if (getName() != null) {
                stringBuilder.append("name=\"").append(StringUtils.escapeForXML(getName())).append("\" ");
            }
            if (getSize() > 0) {
                stringBuilder.append("size=\"").append(getSize()).append("\" ");
            }
            if (getDate() != null) {
                stringBuilder.append("date=\"").append(C2639a.m11064a(this.date)).append("\" ");
            }
            if (getHash() != null) {
                stringBuilder.append("hash=\"").append(getHash()).append("\" ");
            }
            if ((this.desc == null || this.desc.length() <= 0) && !this.isRanged) {
                stringBuilder.append("/>");
            } else {
                stringBuilder.append(">");
                if (getDesc() != null && this.desc.length() > 0) {
                    stringBuilder.append("<desc>").append(StringUtils.escapeForXML(getDesc())).append("</desc>");
                }
                if (isRanged()) {
                    stringBuilder.append("<range/>");
                }
                stringBuilder.append("</").append(getElementName()).append(">");
            }
            return stringBuilder.toString();
        }
    }

    public StreamInitiation() {
        super(ELEMENT, NAMESPACE);
    }

    public DataForm getFeatureNegotiationForm() {
        return this.featureNegotiation.getData();
    }

    public File getFile() {
        return this.file;
    }

    protected IQChildElementXmlStringBuilder getIQChildElementBuilder(IQChildElementXmlStringBuilder iQChildElementXmlStringBuilder) {
        switch (C27811.$SwitchMap$org$jivesoftware$smack$packet$IQ$Type[getType().ordinal()]) {
            case VideoSize.CIF /*1*/:
                iQChildElementXmlStringBuilder.optAttribute("id", getSessionID());
                iQChildElementXmlStringBuilder.optAttribute("mime-type", getMimeType());
                iQChildElementXmlStringBuilder.attribute("profile", FileTransferNegotiator.SI_PROFILE_FILE_TRANSFER_NAMESPACE);
                iQChildElementXmlStringBuilder.rightAngleBracket();
                iQChildElementXmlStringBuilder.optAppend(this.file.toXML());
                break;
            case VideoSize.HVGA /*2*/:
                iQChildElementXmlStringBuilder.rightAngleBracket();
                break;
            default:
                throw new IllegalArgumentException("IQ Type not understood");
        }
        if (this.featureNegotiation != null) {
            iQChildElementXmlStringBuilder.append(this.featureNegotiation.toXML());
        }
        return iQChildElementXmlStringBuilder;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getSessionID() {
        return this.id;
    }

    public void setFeatureNegotiationForm(DataForm dataForm) {
        this.featureNegotiation = new Feature(dataForm);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setMimeType(String str) {
        this.mimeType = str;
    }

    public void setSessionID(String str) {
        this.id = str;
    }
}
