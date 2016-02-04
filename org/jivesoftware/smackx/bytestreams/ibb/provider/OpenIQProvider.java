package org.jivesoftware.smackx.bytestreams.ibb.provider;

import java.util.Locale;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.bytestreams.ibb.InBandBytestreamManager.StanzaType;
import org.jivesoftware.smackx.bytestreams.ibb.packet.Open;
import org.xmlpull.v1.XmlPullParser;

public class OpenIQProvider extends IQProvider<Open> {
    public Open parse(XmlPullParser xmlPullParser, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "sid");
        int parseInt = Integer.parseInt(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "block-size"));
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "stanza");
        StanzaType valueOf = attributeValue2 == null ? StanzaType.IQ : StanzaType.valueOf(attributeValue2.toUpperCase(Locale.US));
        xmlPullParser.next();
        return new Open(attributeValue, parseInt, valueOf);
    }
}
