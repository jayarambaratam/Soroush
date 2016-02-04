package org.jivesoftware.smack.util;

import java.util.Collection;
import java.util.Random;
import mobi.mmdt.ott.C1317h;

public class StringUtils {
    public static final String AMP_ENCODE = "&amp;";
    public static final String APOS_ENCODE = "&apos;";
    public static final String GT_ENCODE = "&gt;";
    public static final char[] HEX_CHARS;
    public static final String LT_ENCODE = "&lt;";
    public static final String MD5 = "MD5";
    public static final String QUOTE_ENCODE = "&quot;";
    public static final String SHA1 = "SHA-1";
    public static final String USASCII = "US-ASCII";
    public static final String UTF8 = "UTF-8";
    private static char[] numbersAndLetters;
    private static Random randGen;

    static {
        HEX_CHARS = "0123456789abcdef".toCharArray();
        randGen = new Random();
        numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    }

    public static String collectionToString(Collection<String> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : collection) {
            stringBuilder.append(append);
            stringBuilder.append(" ");
        }
        String append2 = stringBuilder.toString();
        return append2.substring(0, append2.length() - 1);
    }

    public static String encodeHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = HEX_CHARS[i2 >>> 4];
            cArr[(i * 2) + 1] = HEX_CHARS[i2 & 15];
        }
        return new String(cArr);
    }

    public static CharSequence escapeForXML(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        StringBuilder stringBuilder = new StringBuilder((int) (((double) length) * 1.3d));
        int i = 0;
        int i2 = 0;
        while (i < length) {
            CharSequence charSequence;
            switch (toCharArray[i]) {
                case C1317h.Theme_actionModePasteDrawable /*34*/:
                    charSequence = QUOTE_ENCODE;
                    break;
                case C1317h.Theme_actionModeWebSearchDrawable /*38*/:
                    charSequence = AMP_ENCODE;
                    break;
                case C1317h.Theme_actionModePopupWindowStyle /*39*/:
                    charSequence = APOS_ENCODE;
                    break;
                case C1317h.Theme_popupMenuStyle /*60*/:
                    charSequence = LT_ENCODE;
                    break;
                case C1317h.Theme_editTextColor /*62*/:
                    charSequence = GT_ENCODE;
                    break;
                default:
                    charSequence = null;
                    break;
            }
            if (charSequence != null) {
                if (i > i2) {
                    stringBuilder.append(toCharArray, i2, i - i2);
                }
                stringBuilder.append(charSequence);
                int i3 = i + 1;
                i = i3;
                i2 = i3;
            } else {
                i++;
            }
        }
        if (i2 == 0) {
            return str;
        }
        if (i > i2) {
            stringBuilder.append(toCharArray, i2, i - i2);
        }
        return stringBuilder;
    }

    @Deprecated
    public static synchronized String hash(String str) {
        String hex;
        synchronized (StringUtils.class) {
            hex = SHA1.hex(str);
        }
        return hex;
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isNullOrEmpty(charSequence);
    }

    public static boolean isNullOrEmpty(CharSequence charSequence) {
        return charSequence == null || isEmpty(charSequence);
    }

    public static String maybeToString(CharSequence charSequence) {
        return charSequence == null ? null : charSequence.toString();
    }

    public static int nullSafeCharSequenceComperator(CharSequence charSequence, CharSequence charSequence2) {
        return ((charSequence2 == null ? 1 : 0) ^ (charSequence == null ? 1 : 0)) != 0 ? charSequence == null ? -1 : 1 : (charSequence == null && charSequence2 == null) ? 0 : charSequence.toString().compareTo(charSequence2.toString());
    }

    public static boolean nullSafeCharSequenceEquals(CharSequence charSequence, CharSequence charSequence2) {
        return nullSafeCharSequenceComperator(charSequence, charSequence2) == 0;
    }

    public static String randomString(int i) {
        if (i < 1) {
            return null;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = numbersAndLetters[randGen.nextInt(numbersAndLetters.length)];
        }
        return new String(cArr);
    }

    public static <CS extends CharSequence> CS requireNotNullOrEmpty(CS cs, String str) {
        if (!isNullOrEmpty(cs)) {
            return cs;
        }
        throw new IllegalArgumentException(str);
    }

    public static String returnIfNotEmptyTrimmed(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        return trim.length() > 0 ? trim : null;
    }

    public static byte[] toBytes(String str) {
        try {
            return str.getBytes(UTF8);
        } catch (Throwable e) {
            throw new IllegalStateException("UTF-8 encoding not supported by platform", e);
        }
    }
}
