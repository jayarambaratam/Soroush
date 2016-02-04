package org.jivesoftware.smackx.muc.provider;

import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.provider.ExtensionElementProvider;
import org.jivesoftware.smackx.muc.packet.Destroy;
import org.jivesoftware.smackx.muc.packet.MUCUser;
import org.jivesoftware.smackx.muc.packet.MUCUser.Decline;
import org.jivesoftware.smackx.muc.packet.MUCUser.Invite;
import org.jivesoftware.smackx.muc.packet.MUCUser.Status;
import org.jivesoftware.smackx.privacy.packet.PrivacyItem;
import org.jivesoftware.smackx.xdata.packet.DataForm.Item;
import org.jivesoftware.smackx.xhtmlim.XHTMLText;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class MUCUserProvider extends ExtensionElementProvider<MUCUser> {
    private static Decline parseDecline(XmlPullParser xmlPullParser) {
        Object obj = null;
        Decline decline = new Decline();
        decline.setFrom(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, PrivacyItem.SUBSCRIPTION_FROM));
        decline.setTo(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, PrivacyItem.SUBSCRIPTION_TO));
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("reason")) {
                    decline.setReason(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getName().equals(Decline.ELEMENT)) {
                obj = 1;
            }
        }
        return decline;
    }

    private static Invite parseInvite(XmlPullParser xmlPullParser) {
        Object obj = null;
        Invite invite = new Invite();
        invite.setFrom(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, PrivacyItem.SUBSCRIPTION_FROM));
        invite.setTo(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, PrivacyItem.SUBSCRIPTION_TO));
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("reason")) {
                    invite.setReason(xmlPullParser.nextText());
                }
            } else if (next == 3 && xmlPullParser.getName().equals(Invite.ELEMENT)) {
                obj = 1;
            }
        }
        return invite;
    }

    public MUCUser parse(XmlPullParser xmlPullParser, int i) {
        MUCUser mUCUser = new MUCUser();
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    Object obj = -1;
                    switch (name.hashCode()) {
                        case -1183699191:
                            if (name.equals(Invite.ELEMENT)) {
                                obj = null;
                                break;
                            }
                            break;
                        case -892481550:
                            if (name.equals(Status.ELEMENT)) {
                                obj = 3;
                                break;
                            }
                            break;
                        case 3242771:
                            if (name.equals(Item.ELEMENT)) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 1216985755:
                            if (name.equals("password")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 1542349558:
                            if (name.equals(Decline.ELEMENT)) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 1557372922:
                            if (name.equals(Destroy.ELEMENT)) {
                                obj = 5;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case VideoSize.QCIF /*0*/:
                            mUCUser.setInvite(parseInvite(xmlPullParser));
                            break;
                        case VideoSize.CIF /*1*/:
                            mUCUser.setItem(MUCParserUtils.parseItem(xmlPullParser));
                            break;
                        case VideoSize.HVGA /*2*/:
                            mUCUser.setPassword(xmlPullParser.nextText());
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            mUCUser.addStatusCode(Status.create(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, XHTMLText.CODE)));
                            break;
                        case Version.API04_DONUT_16 /*4*/:
                            mUCUser.setDecline(parseDecline(xmlPullParser));
                            break;
                        case Version.API05_ECLAIR_20 /*5*/:
                            mUCUser.setDestroy(MUCParserUtils.parseDestroy(xmlPullParser));
                            break;
                        default:
                            break;
                    }
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() != i) {
                        break;
                    }
                    return mUCUser;
                default:
                    break;
            }
        }
    }
}
