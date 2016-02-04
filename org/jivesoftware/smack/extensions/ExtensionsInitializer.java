package org.jivesoftware.smack.extensions;

import org.jivesoftware.smack.initializer.UrlInitializer;

public class ExtensionsInitializer extends UrlInitializer {
    protected String getConfigUrl() {
        return "classpath:org.jivesoftware.smack.extensions/extensions.xml";
    }

    protected String getProvidersUrl() {
        return "classpath:org.jivesoftware.smack.extensions/extensions.providers";
    }
}
