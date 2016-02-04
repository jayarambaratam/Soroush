package org.jivesoftware.smack.packet;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jivesoftware.smack.util.XmlStringBuilder;

public class DefaultExtensionElement implements ExtensionElement {
    private String elementName;
    private Map<String, String> map;
    private String namespace;

    public DefaultExtensionElement(String str, String str2) {
        this.elementName = str;
        this.namespace = str2;
    }

    public String getElementName() {
        return this.elementName;
    }

    public synchronized Collection<String> getNames() {
        return this.map == null ? Collections.emptySet() : Collections.unmodifiableSet(new HashMap(this.map).keySet());
    }

    public String getNamespace() {
        return this.namespace;
    }

    public synchronized String getValue(String str) {
        return this.map == null ? null : (String) this.map.get(str);
    }

    public synchronized void setValue(String str, String str2) {
        if (this.map == null) {
            this.map = new HashMap();
        }
        this.map.put(str, str2);
    }

    public CharSequence toXML() {
        CharSequence xmlStringBuilder = new XmlStringBuilder();
        xmlStringBuilder.halfOpenElement(this.elementName).xmlnsAttribute(this.namespace).rightAngleBracket();
        for (String str : getNames()) {
            xmlStringBuilder.element(str, getValue(str));
        }
        xmlStringBuilder.closeElement(this.elementName);
        return xmlStringBuilder;
    }
}
