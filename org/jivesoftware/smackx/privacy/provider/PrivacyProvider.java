package org.jivesoftware.smackx.privacy.provider;

import java.util.ArrayList;
import java.util.List;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.amp.packet.AMPExtension.Action;
import org.jivesoftware.smackx.privacy.packet.Privacy;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem.Type;
import org.jivesoftware.smackx.search.UserSearch;
import org.jivesoftware.smackx.xdata.packet.DataForm.Item;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class PrivacyProvider extends IQProvider<Privacy> {
    private static PrivacyItem parseItem(XmlPullParser xmlPullParser) {
        PrivacyItem privacyItem;
        boolean z = true;
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, Action.ATTRIBUTE_NAME);
        long longValue = ParserUtils.getLongAttribute(xmlPullParser, "order").longValue();
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "type");
        boolean z2 = true;
        switch (attributeValue.hashCode()) {
            case 3079692:
                if (attributeValue.equals("deny")) {
                    z2 = true;
                    break;
                }
                break;
            case 92906313:
                if (attributeValue.equals("allow")) {
                    z2 = false;
                    break;
                }
                break;
        }
        switch (z2) {
            case VideoSize.QCIF /*0*/:
                break;
            case VideoSize.CIF /*1*/:
                z = false;
                break;
            default:
                throw new SmackException("Unkown action value '" + attributeValue + "'");
        }
        if (attributeValue2 != null) {
            privacyItem = new PrivacyItem(Type.valueOf(attributeValue2), xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "value"), z, longValue);
        } else {
            privacyItem = new PrivacyItem(z, longValue);
        }
        parseItemChildElements(xmlPullParser, privacyItem);
        return privacyItem;
    }

    private static void parseItemChildElements(XmlPullParser xmlPullParser, PrivacyItem privacyItem) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    boolean z = true;
                    switch (name.hashCode()) {
                        case -1240091849:
                            if (name.equals("presence-in")) {
                                z = true;
                                break;
                            }
                            break;
                        case 3368:
                            if (name.equals(IQ.IQ_ELEMENT)) {
                                z = false;
                                break;
                            }
                            break;
                        case 211864444:
                            if (name.equals("presence-out")) {
                                z = true;
                                break;
                            }
                            break;
                        case 954925063:
                            if (name.equals(Message.ELEMENT)) {
                                z = true;
                                break;
                            }
                            break;
                    }
                    switch (z) {
                        case VideoSize.QCIF /*0*/:
                            privacyItem.setFilterIQ(true);
                            break;
                        case VideoSize.CIF /*1*/:
                            privacyItem.setFilterMessage(true);
                            break;
                        case VideoSize.HVGA /*2*/:
                            privacyItem.setFilterPresenceIn(true);
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            privacyItem.setFilterPresenceOut(true);
                            break;
                        default:
                            break;
                    }
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() != depth) {
                        break;
                    }
                    return;
                default:
                    break;
            }
        }
    }

    private static void parseList(XmlPullParser xmlPullParser, Privacy privacy) {
        Object obj = null;
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "name");
        List arrayList = new ArrayList();
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(Item.ELEMENT)) {
                    arrayList.add(parseItem(xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("list")) {
                obj = 1;
            }
        }
        privacy.setPrivacyList(attributeValue, arrayList);
    }

    public Privacy parse(XmlPullParser xmlPullParser, int i) {
        Privacy privacy = new Privacy();
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String attributeValue;
                if (xmlPullParser.getName().equals("active")) {
                    attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "name");
                    if (attributeValue == null) {
                        privacy.setDeclineActiveList(true);
                    } else {
                        privacy.setActiveName(attributeValue);
                    }
                } else if (xmlPullParser.getName().equals("default")) {
                    attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "name");
                    if (attributeValue == null) {
                        privacy.setDeclineDefaultList(true);
                    } else {
                        privacy.setDefaultName(attributeValue);
                    }
                } else if (xmlPullParser.getName().equals("list")) {
                    parseList(xmlPullParser, privacy);
                }
            } else if (next == 3 && xmlPullParser.getName().equals(UserSearch.ELEMENT)) {
                z = true;
            }
        }
        return privacy;
    }
}
