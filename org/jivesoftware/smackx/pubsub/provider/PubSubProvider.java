package org.jivesoftware.smackx.pubsub.provider;

import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smack.util.PacketParserUtils;
import org.jivesoftware.smackx.pubsub.packet.PubSub;
import org.jivesoftware.smackx.pubsub.packet.PubSubNamespace;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class PubSubProvider extends IQProvider<PubSub> {
    public PubSub parse(XmlPullParser xmlPullParser, int i) {
        Stanza pubSub = new PubSub(PubSubNamespace.valueOfFromXmlns(xmlPullParser.getNamespace()));
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    PacketParserUtils.addExtensionElement(pubSub, xmlPullParser);
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() != i) {
                        break;
                    }
                    return pubSub;
                default:
                    break;
            }
        }
    }
}
