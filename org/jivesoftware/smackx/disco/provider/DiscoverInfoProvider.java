package org.jivesoftware.smackx.disco.provider;

import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.protocol.HTTP;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo;
import org.jivesoftware.smackx.disco.packet.DiscoverInfo.Identity;
import org.jivesoftware.smackx.search.UserSearch;
import org.xmlpull.v1.XmlPullParser;

public class DiscoverInfoProvider extends IQProvider<DiscoverInfo> {
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DiscoverInfoProvider.class.desiredAssertionStatus();
    }

    public DiscoverInfo parse(XmlPullParser xmlPullParser, int i) {
        Stanza discoverInfo = new DiscoverInfo();
        Object obj = null;
        String str = BuildConfig.FLAVOR;
        String str2 = BuildConfig.FLAVOR;
        String str3 = BuildConfig.FLAVOR;
        String str4 = BuildConfig.FLAVOR;
        String str5 = BuildConfig.FLAVOR;
        discoverInfo.setNode(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "node"));
        while (obj == null) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals(HTTP.IDENTITY_CODING)) {
                    str = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "category");
                    str2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "name");
                    str3 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "type");
                    str5 = xmlPullParser.getAttributeValue(xmlPullParser.getNamespace("xml"), "lang");
                } else if (xmlPullParser.getName().equals("feature")) {
                    str4 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "var");
                } else {
                    PacketParserUtils.addExtensionElement(discoverInfo, xmlPullParser);
                }
            } else if (next != 3) {
                continue;
            } else {
                if (xmlPullParser.getName().equals(HTTP.IDENTITY_CODING)) {
                    discoverInfo.addIdentity(new Identity(str, str3, str2, str5));
                }
                if (xmlPullParser.getName().equals("feature")) {
                    boolean addFeature = discoverInfo.addFeature(str4);
                    if (!($assertionsDisabled || addFeature)) {
                        throw new AssertionError();
                    }
                }
                if (xmlPullParser.getName().equals(UserSearch.ELEMENT)) {
                    obj = 1;
                }
            }
        }
        return discoverInfo;
    }
}
