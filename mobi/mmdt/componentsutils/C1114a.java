package mobi.mmdt.componentsutils;

import android.webkit.MimeTypeMap;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.componentsutils.a */
public class C1114a {
    public static boolean m6423a(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if ((fileExtensionFromUrl == null || fileExtensionFromUrl.equals(BuildConfig.FLAVOR)) && str.split("\\.").length - 1 > -1) {
            fileExtensionFromUrl = str.split("\\.")[str.split("\\.").length - 1];
        }
        if (fileExtensionFromUrl != null) {
            fileExtensionFromUrl = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
            if (fileExtensionFromUrl != null && fileExtensionFromUrl.startsWith("image/")) {
                return true;
            }
        }
        return false;
    }

    public static boolean m6424b(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if ((fileExtensionFromUrl == null || fileExtensionFromUrl.equals(BuildConfig.FLAVOR)) && str.split("\\.").length - 1 > -1) {
            fileExtensionFromUrl = str.split("\\.")[str.split("\\.").length - 1];
        }
        if (fileExtensionFromUrl != null) {
            fileExtensionFromUrl = fileExtensionFromUrl.toLowerCase();
            fileExtensionFromUrl = (fileExtensionFromUrl.equals("mkv") || fileExtensionFromUrl.equals("flv")) ? "video/*" : MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
            if (fileExtensionFromUrl != null && fileExtensionFromUrl.startsWith("video/")) {
                return true;
            }
        }
        return false;
    }

    public static boolean m6425c(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if ((fileExtensionFromUrl == null || fileExtensionFromUrl.equals(BuildConfig.FLAVOR)) && str.split("\\.").length - 1 > -1) {
            fileExtensionFromUrl = str.split("\\.")[str.split("\\.").length - 1];
        }
        if (fileExtensionFromUrl != null) {
            fileExtensionFromUrl = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase());
            if (fileExtensionFromUrl != null && fileExtensionFromUrl.startsWith("audio/")) {
                return true;
            }
        }
        return false;
    }

    public static boolean m6426d(String str) {
        return C1114a.m6428f(str).equalsIgnoreCase("pdf");
    }

    public static boolean m6427e(String str) {
        return C1114a.m6428f(str).equalsIgnoreCase("apk");
    }

    public static String m6428f(String str) {
        return C1114a.m6430h(str).toLowerCase();
    }

    public static String m6429g(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if ((fileExtensionFromUrl == null || fileExtensionFromUrl.equals(BuildConfig.FLAVOR)) && str.split("\\.").length - 1 > -1) {
            fileExtensionFromUrl = str.split("\\.")[str.split("\\.").length - 1];
        }
        if (fileExtensionFromUrl == null) {
            return "*/*";
        }
        if (fileExtensionFromUrl.equals("mkv") || fileExtensionFromUrl.equals("flv")) {
            return "video/*";
        }
        fileExtensionFromUrl = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
        return fileExtensionFromUrl == null ? "*/*" : fileExtensionFromUrl;
    }

    public static String m6430h(String str) {
        String str2 = BuildConfig.FLAVOR;
        if (str.split("\\.").length - 1 > -1) {
            str2 = str.split("\\.")[str.split("\\.").length - 1];
        }
        return str2.toLowerCase();
    }
}
