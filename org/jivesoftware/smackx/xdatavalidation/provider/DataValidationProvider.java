package org.jivesoftware.smackx.xdatavalidation.provider;

import java.util.logging.Logger;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.util.ParserUtils;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.BasicValidateElement;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.ListRange;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.OpenValidateElement;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.RangeValidateElement;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.RegexValidateElement;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import org.xmlpull.v1.XmlPullParser;

public class DataValidationProvider {
    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(DataValidationProvider.class.getName());
    }

    public static ValidateElement parse(XmlPullParser xmlPullParser) {
        ListRange listRange = null;
        int depth = xmlPullParser.getDepth();
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "datatype");
        ValidateElement validateElement = null;
        while (true) {
            switch (xmlPullParser.next()) {
                case VideoSize.HVGA /*2*/:
                    String name = xmlPullParser.getName();
                    Object obj = -1;
                    switch (name.hashCode()) {
                        case -725250226:
                            if (name.equals(ListRange.ELEMENT)) {
                                obj = 4;
                                break;
                            }
                            break;
                        case 3417674:
                            if (name.equals(OpenValidateElement.METHOD)) {
                                obj = null;
                                break;
                            }
                            break;
                        case 93508654:
                            if (name.equals(BasicValidateElement.METHOD)) {
                                obj = 1;
                                break;
                            }
                            break;
                        case 108280125:
                            if (name.equals(RangeValidateElement.METHOD)) {
                                obj = 2;
                                break;
                            }
                            break;
                        case 108392519:
                            if (name.equals(RegexValidateElement.METHOD)) {
                                obj = 3;
                                break;
                            }
                            break;
                    }
                    switch (obj) {
                        case VideoSize.QCIF /*0*/:
                            validateElement = new OpenValidateElement(attributeValue);
                            break;
                        case VideoSize.CIF /*1*/:
                            validateElement = new BasicValidateElement(attributeValue);
                            break;
                        case VideoSize.HVGA /*2*/:
                            validateElement = new RangeValidateElement(attributeValue, xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "min"), xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "max"));
                            break;
                        case Version.API03_CUPCAKE_15 /*3*/:
                            validateElement = new RegexValidateElement(attributeValue, xmlPullParser.nextText());
                            break;
                        case Version.API04_DONUT_16 /*4*/:
                            Long longAttribute = ParserUtils.getLongAttribute(xmlPullParser, "min");
                            Long longAttribute2 = ParserUtils.getLongAttribute(xmlPullParser, "max");
                            if (longAttribute != null || longAttribute2 != null) {
                                listRange = new ListRange(longAttribute, longAttribute2);
                                break;
                            }
                            LOGGER.fine("Ignoring list-range element without min or max attribute");
                            break;
                            break;
                        default:
                            break;
                    }
                case Version.API03_CUPCAKE_15 /*3*/:
                    if (xmlPullParser.getDepth() != depth) {
                        break;
                    }
                    if (validateElement == null) {
                        validateElement = new BasicValidateElement(attributeValue);
                    }
                    validateElement.setListRange(listRange);
                    return validateElement;
                default:
                    break;
            }
        }
    }
}
