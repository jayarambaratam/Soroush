package org.jivesoftware.smackx.iqversion.provider;

import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.iqversion.packet.Version;
import org.jivesoftware.smackx.search.UserSearch;
import org.linphone.core.VideoSize;
import org.xmlpull.v1.XmlPullParser;

public class VersionProvider extends IQProvider<Version> {
    public Version parse(XmlPullParser xmlPullParser, int i) {
        String str = null;
        String str2 = null;
        String str3 = null;
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    Object obj = -1;
                    switch (name.hashCode()) {
                        case 3556:
                            if (name.equals("os")) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 3373707:
                            if (name.equals("name")) {
                                obj = null;
                                break;
                            }
                            break;
                        case 351608024:
                            if (name.equals("version")) {
                                obj = 1;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case VideoSize.QCIF /*0*/:
                            str3 = xmlPullParser.nextText();
                            break;
                        case VideoSize.CIF /*1*/:
                            str2 = xmlPullParser.nextText();
                            break;
                        case VideoSize.HVGA /*2*/:
                            str = xmlPullParser.nextText();
                            break;
                        default:
                            break;
                    }
                case org.linphone.mediastream.Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() == i && xmlPullParser.getName().equals(UserSearch.ELEMENT)) {
                        return (str3 == null && str2 == null && str == null) ? new Version() : new Version(str3, str2, str);
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
