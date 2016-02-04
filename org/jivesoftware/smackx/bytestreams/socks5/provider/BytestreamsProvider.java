package org.jivesoftware.smackx.bytestreams.socks5.provider;

import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.Activate;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.Mode;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.StreamHost;
import org.jivesoftware.smackx.bytestreams.socks5.packet.Bytestream.StreamHostUsed;
import org.jivesoftware.smackx.search.UserSearch;
import org.xmlpull.v1.XmlPullParser;

public class BytestreamsProvider extends IQProvider<Bytestream> {
    public Bytestream parse(XmlPullParser xmlPullParser, int i) {
        Bytestream bytestream = new Bytestream();
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "sid");
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "mode");
        String str = null;
        String str2 = null;
        Object obj = null;
        String str3 = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            if (next == 2) {
                if (name.equals(StreamHost.ELEMENTNAME)) {
                    str2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "jid");
                    str = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "host");
                    str3 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "port");
                } else if (name.equals(StreamHostUsed.ELEMENTNAME)) {
                    bytestream.setUsedHost(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "jid"));
                } else if (name.equals(Activate.ELEMENTNAME)) {
                    bytestream.setToActivate(xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "jid"));
                }
            } else if (next == 3) {
                if (name.equals("streamhost")) {
                    if (str3 == null) {
                        bytestream.addStreamHost(str2, str);
                    } else {
                        bytestream.addStreamHost(str2, str, Integer.parseInt(str3));
                    }
                    str3 = null;
                    str = null;
                    str2 = null;
                } else if (name.equals(UserSearch.ELEMENT)) {
                    obj = 1;
                }
            }
        }
        if (attributeValue2 == null) {
            bytestream.setMode(Mode.tcp);
        } else {
            bytestream.setMode(Mode.fromName(attributeValue2));
        }
        bytestream.setSessionID(attributeValue);
        return bytestream;
    }
}
