package org.jivesoftware.smackx.jiveproperties;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.jivesoftware.smack.packet.Stanza;
import org.jivesoftware.smackx.jiveproperties.packet.JivePropertiesExtension;

public class JivePropertiesManager {
    private static boolean javaObjectEnabled;

    static {
        javaObjectEnabled = false;
    }

    public static void addProperty(Stanza stanza, String str, Object obj) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanza.getExtension(JivePropertiesExtension.NAMESPACE);
        if (jivePropertiesExtension == null) {
            jivePropertiesExtension = new JivePropertiesExtension();
            stanza.addExtension(jivePropertiesExtension);
        }
        jivePropertiesExtension.setProperty(str, obj);
    }

    public static Map<String, Object> getProperties(Stanza stanza) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanza.getExtension(JivePropertiesExtension.NAMESPACE);
        return jivePropertiesExtension == null ? Collections.emptyMap() : jivePropertiesExtension.getProperties();
    }

    public static Collection<String> getPropertiesNames(Stanza stanza) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanza.getExtension(JivePropertiesExtension.NAMESPACE);
        return jivePropertiesExtension == null ? Collections.emptyList() : jivePropertiesExtension.getPropertyNames();
    }

    public static Object getProperty(Stanza stanza, String str) {
        JivePropertiesExtension jivePropertiesExtension = (JivePropertiesExtension) stanza.getExtension(JivePropertiesExtension.NAMESPACE);
        return jivePropertiesExtension != null ? jivePropertiesExtension.getProperty(str) : null;
    }

    public static boolean isJavaObjectEnabled() {
        return javaObjectEnabled;
    }

    public static void setJavaObjectEnabled(boolean z) {
        javaObjectEnabled = z;
    }
}
