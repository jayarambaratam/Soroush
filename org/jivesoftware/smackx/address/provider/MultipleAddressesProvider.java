package org.jivesoftware.smackx.address.provider;

import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.address.packet.MultipleAddresses;
import org.jivesoftware.smackx.address.packet.MultipleAddresses.Address;
import org.jivesoftware.smackx.address.packet.MultipleAddresses.Type;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class MultipleAddressesProvider extends ExtensionElementProvider<MultipleAddresses> {
    public MultipleAddresses parse(XmlPullParser xmlPullParser, int i) {
        MultipleAddresses multipleAddresses = new MultipleAddresses();
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    Object obj = -1;
                    switch (name.hashCode()) {
                        case -1147692044:
                            if (name.equals(Address.ELEMENT)) {
                                obj = null;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case VideoSize.QCIF /*0*/:
                            multipleAddresses.addAddress(Type.valueOf(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "type")), xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "jid"), xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "node"), xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "desc"), "true".equals(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "delivered")), xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "uri"));
                            break;
                        default:
                            break;
                    }
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() != i) {
                        break;
                    }
                    return multipleAddresses;
                default:
                    break;
            }
        }
    }
}
