package org.apache.http.myHttp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    protected VersionInfo(String str, String str2, String str3, String str4, String str5) {
        Args.notNull(str, "Package identifier");
        this.infoPackage = str;
        if (str2 == null) {
            str2 = UNAVAILABLE;
        }
        this.infoModule = str2;
        if (str3 == null) {
            str3 = UNAVAILABLE;
        }
        this.infoRelease = str3;
        if (str4 == null) {
            str4 = UNAVAILABLE;
        }
        this.infoTimestamp = str4;
        if (str5 == null) {
            str5 = UNAVAILABLE;
        }
        this.infoClassloader = str5;
    }

    protected static VersionInfo fromMap(String str, Map<?, ?> map, ClassLoader classLoader) {
        String str2;
        String str3;
        String str4;
        String str5 = null;
        Args.notNull(str, "Package identifier");
        if (map != null) {
            String str6 = (String) map.get(PROPERTY_MODULE);
            String str7 = (str6 == null || str6.length() >= 1) ? str6 : null;
            str6 = (String) map.get(PROPERTY_RELEASE);
            str2 = (str6 == null || (str6.length() >= 1 && !str6.equals("${pom.version}"))) ? str6 : null;
            str6 = (String) map.get(PROPERTY_TIMESTAMP);
            if (str6 == null || (str6.length() >= 1 && !str6.equals("${mvn.timestamp}"))) {
                str3 = str6;
                str4 = str2;
                str2 = str7;
            } else {
                str3 = null;
                str4 = str2;
                str2 = str7;
            }
        } else {
            str3 = null;
            str4 = null;
            str2 = null;
        }
        if (classLoader != null) {
            str5 = classLoader.toString();
        }
        return new VersionInfo(str, str2, str4, str3, str5);
    }

    public static String getUserAgent(String str, String str2, Class<?> cls) {
        VersionInfo loadVersionInfo = loadVersionInfo(str2, cls.getClassLoader());
        return str + "/" + (loadVersionInfo != null ? loadVersionInfo.getRelease() : UNAVAILABLE) + " (Java 1.5 minimum; Java/" + System.getProperty("java.version") + ")";
    }

    public static VersionInfo loadVersionInfo(String str, ClassLoader classLoader) {
        InputStream resourceAsStream;
        Map properties;
        Args.notNull(str, "Package identifier");
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            resourceAsStream = classLoader.getResourceAsStream(str.replace('.', '/') + "/" + VERSION_PROPERTY_FILE);
            if (resourceAsStream != null) {
                properties = new Properties();
                properties.load(resourceAsStream);
                try {
                    resourceAsStream.close();
                } catch (IOException e) {
                }
            } else {
                properties = null;
            }
        } catch (IOException e2) {
            properties = null;
        } catch (Throwable th) {
            resourceAsStream.close();
        }
        return properties != null ? fromMap(str, properties, classLoader) : null;
    }

    public static VersionInfo[] loadVersionInfo(String[] strArr, ClassLoader classLoader) {
        Args.notNull(strArr, "Package identifier array");
        List arrayList = new ArrayList(strArr.length);
        for (String loadVersionInfo : strArr) {
            VersionInfo loadVersionInfo2 = loadVersionInfo(loadVersionInfo, classLoader);
            if (loadVersionInfo2 != null) {
                arrayList.add(loadVersionInfo2);
            }
        }
        return (VersionInfo[]) arrayList.toArray(new VersionInfo[arrayList.size()]);
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(((((this.infoPackage.length() + 20) + this.infoModule.length()) + this.infoRelease.length()) + this.infoTimestamp.length()) + this.infoClassloader.length());
        stringBuilder.append("VersionInfo(").append(this.infoPackage).append(':').append(this.infoModule);
        if (!UNAVAILABLE.equals(this.infoRelease)) {
            stringBuilder.append(':').append(this.infoRelease);
        }
        if (!UNAVAILABLE.equals(this.infoTimestamp)) {
            stringBuilder.append(':').append(this.infoTimestamp);
        }
        stringBuilder.append(')');
        if (!UNAVAILABLE.equals(this.infoClassloader)) {
            stringBuilder.append('@').append(this.infoClassloader);
        }
        return stringBuilder.toString();
    }
}
