package org.jivesoftware.smack.sm.provider;

import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.packet.XMPPError;
import org.jivesoftware.smack.packet.XMPPError.Condition;
import org.jivesoftware.smack.sm.packet.StreamManagement.AckAnswer;
import org.jivesoftware.smack.sm.packet.StreamManagement.AckRequest;
import org.jivesoftware.smack.sm.packet.StreamManagement.Enabled;
import org.jivesoftware.smack.sm.packet.StreamManagement.Failed;
import org.jivesoftware.smack.sm.packet.StreamManagement.Resume;
import org.jivesoftware.smack.sm.packet.StreamManagement.Resumed;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class ParseStreamManagement {
    public static AckAnswer ackAnswer(XmlPullParser xmlPullParser) {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long longValue = ParserUtils.getLongAttribute(xmlPullParser, XHTMLText.f8413H).longValue();
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new AckAnswer(longValue);
    }

    public static AckRequest ackRequest(XmlPullParser xmlPullParser) {
        ParserUtils.assertAtStartTag(xmlPullParser);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return AckRequest.INSTANCE;
    }

    public static Enabled enabled(XmlPullParser xmlPullParser) {
        ParserUtils.assertAtStartTag(xmlPullParser);
        boolean booleanAttribute = ParserUtils.getBooleanAttribute(xmlPullParser, Resume.ELEMENT, false);
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "id");
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "location");
        int integerAttribute = ParserUtils.getIntegerAttribute(xmlPullParser, "max", -1);
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new Enabled(attributeValue, booleanAttribute, attributeValue2, integerAttribute);
    }

    public static Failed failed(XmlPullParser xmlPullParser) {
        ParserUtils.assertAtStartTag(xmlPullParser);
        Condition condition = null;
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    if (!XMPPError.NAMESPACE.equals(xmlPullParser.getNamespace())) {
                        break;
                    }
                    condition = Condition.fromString(name);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (!Failed.ELEMENT.equals(xmlPullParser.getName())) {
                        break;
                    }
                    ParserUtils.assertAtEndTag(xmlPullParser);
                    return new Failed(condition);
                default:
                    break;
            }
        }
    }

    public static Resumed resumed(XmlPullParser xmlPullParser) {
        ParserUtils.assertAtStartTag(xmlPullParser);
        long longValue = ParserUtils.getLongAttribute(xmlPullParser, XHTMLText.f8413H).longValue();
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "previd");
        xmlPullParser.next();
        ParserUtils.assertAtEndTag(xmlPullParser);
        return new Resumed(longValue, attributeValue);
    }
}
