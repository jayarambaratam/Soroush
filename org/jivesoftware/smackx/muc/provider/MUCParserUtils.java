package org.jivesoftware.smackx.muc.provider;

import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smackx.muc.MUCAffiliation;
import org.jivesoftware.smackx.muc.MUCRole;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCItem;
import org.jivesoftware.smackx.nick.packet.Nick;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class MUCParserUtils {
    public static Destroy parseDestroy(XmlPullParser xmlPullParser) {
        Object obj = null;
        Destroy destroy = new Destroy();
        destroy.setJid(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "jid"));
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("reason")) {
                    destroy.setReason(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getName().equals(Destroy.ELEMENT)) {
                obj = 1;
            }
        }
        return destroy;
    }

    public static MUCItem parseItem(XmlPullParser xmlPullParser) {
        String str = null;
        int depth = xmlPullParser.getDepth();
        MUCAffiliation fromString = MUCAffiliation.fromString(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "affiliation"));
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, Nick.ELEMENT_NAME);
        MUCRole fromString2 = MUCRole.fromString(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "role"));
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "jid");
        String str2 = null;
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    Object obj = -1;
                    switch (name.hashCode()) {
                        case -934964668:
                            if (name.equals("reason")) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 92645877:
                            if (name.equals("actor")) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case VideoSize.QCIF /*0*/:
                            str2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "jid");
                            break;
                        case VideoSize.CIF /*1*/:
                            str = xmlPullParser.nextText();
                            break;
                        default:
                            break;
                    }
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() != depth) {
                        break;
                    }
                    return new MUCItem(fromString, fromString2, str2, str, attributeValue2, attributeValue);
                default:
                    break;
            }
        }
    }
}
