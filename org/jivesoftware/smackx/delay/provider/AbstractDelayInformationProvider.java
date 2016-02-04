package org.jivesoftware.smackx.delay.provider;

import java.util.Date;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.delay.packet.DelayInformation;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public abstract class AbstractDelayInformationProvider extends ExtensionElementProvider<DelayInformation> {
    public final DelayInformation parse(XmlPullParser xmlPullParser, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "stamp");
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, PrivacyItem.SUBSCRIPTION_FROM);
        String str = null;
        if (xmlPullParser.isEmptyElementTag()) {
            xmlPullParser.next();
        } else {
            int next = xmlPullParser.next();
            switch (next) {
                case Version.API03_CUPCAKE_15 /*3*/:
                    str = BuildConfig.FLAVOR;
                    break;
                case Version.API04_DONUT_16 /*4*/:
                    str = xmlPullParser.getText();
                    xmlPullParser.next();
                    break;
                default:
                    throw new IllegalStateException("Unexpected event: " + next);
            }
        }
        try {
            return new DelayInformation(parseDate(attributeValue), attributeValue2, str);
        } catch (Throwable e) {
            throw new SmackException(e);
        }
    }

    protected abstract Date parseDate(String str);
}
