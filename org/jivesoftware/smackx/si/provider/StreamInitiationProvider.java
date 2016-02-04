package org.jivesoftware.smackx.si.provider;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.frakbot.glowpadbackport.BuildConfig;
import org.jivesoftware.smack.provider.IQProvider;
import org.jivesoftware.smackx.si.packet.StreamInitiation;
import org.jivesoftware.smackx.si.packet.StreamInitiation.File;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.jivesoftware.smackx.xdata.provider.DataFormProvider;
import org.jivesoftware.smackx.xdatavalidation.packet.ValidateElement.RangeValidateElement;
import org.p253a.p254a.C2639a;
import org.xmlpull.v1.XmlPullParser;

public class StreamInitiationProvider extends IQProvider<StreamInitiation> {
    private static final Logger LOGGER;

    static {
        LOGGER = Logger.getLogger(StreamInitiationProvider.class.getName());
    }

    public StreamInitiation parse(XmlPullParser xmlPullParser, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "id");
        String attributeValue2 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "mime-type");
        StreamInitiation streamInitiation = new StreamInitiation();
        DataFormProvider dataFormProvider = new DataFormProvider();
        String str = null;
        String str2 = null;
        Object obj = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        boolean z = false;
        DataForm dataForm = null;
        while (obj == null) {
            int next = xmlPullParser.next();
            String name = xmlPullParser.getName();
            String namespace = xmlPullParser.getNamespace();
            if (next == 2) {
                if (name.equals("file")) {
                    str3 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "name");
                    namespace = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "size");
                    name = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "hash");
                    str4 = name;
                    str = namespace;
                    str2 = str3;
                    str3 = xmlPullParser.getAttributeValue(BuildConfig.FLAVOR, "date");
                } else if (name.equals("desc")) {
                    str5 = xmlPullParser.nextText();
                } else if (name.equals(RangeValidateElement.METHOD)) {
                    z = true;
                } else if (name.equals(DataForm.ELEMENT) && namespace.equals(DataForm.NAMESPACE)) {
                    dataForm = (DataForm) dataFormProvider.parse(xmlPullParser);
                }
            } else if (next == 3) {
                if (name.equals(StreamInitiation.ELEMENT)) {
                    obj = 1;
                } else if (name.equals("file")) {
                    long j = 0;
                    if (!(str == null || str.trim().length() == 0)) {
                        try {
                            j = Long.parseLong(str);
                        } catch (Throwable e) {
                            LOGGER.log(Level.SEVERE, "Failed to parse file size from " + j, e);
                        }
                    }
                    Date date = new Date();
                    if (str3 != null) {
                        try {
                            date = C2639a.m11071b(str3);
                        } catch (ParseException e2) {
                        }
                    }
                    File file = new File(str2, j);
                    file.setHash(str4);
                    file.setDate(date);
                    file.setDesc(str5);
                    file.setRanged(z);
                    streamInitiation.setFile(file);
                }
            }
        }
        streamInitiation.setSessionID(attributeValue);
        streamInitiation.setMimeType(attributeValue2);
        streamInitiation.setFeatureNegotiationForm(dataForm);
        return streamInitiation;
    }
}
