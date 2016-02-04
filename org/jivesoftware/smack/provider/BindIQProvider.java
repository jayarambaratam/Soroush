package org.jivesoftware.smack.provider;

import org.jivesoftware.smack.packet.Bind;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class BindIQProvider extends IQProvider<Bind> {
    public Bind parse(XmlPullParser xmlPullParser, int i) {
        Bind bind = null;
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    Object obj = -1;
                    switch (name.hashCode()) {
                        case -341064690:
                            if (name.equals("resource")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 105221:
                            if (name.equals("jid")) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case VideoSize.QCIF /*0*/:
                            bind = Bind.newSet(xmlPullParser.nextText());
                            break;
                        case VideoSize.CIF /*1*/:
                            bind = Bind.newResult(xmlPullParser.nextText());
                            break;
                        default:
                            break;
                    }
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() != i) {
                        break;
                    }
                    return bind;
                default:
                    break;
            }
        }
    }
}
