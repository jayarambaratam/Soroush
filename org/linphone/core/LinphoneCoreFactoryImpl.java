package org.linphone.core;

import android.util.Log;
import java.io.File;
import org.linphone.mediastream.MediastreamerAndroidContext;
import org.linphone.mediastream.Version;

public class LinphoneCoreFactoryImpl extends LinphoneCoreFactory {
    static {
        String str = "armeabi";
        if (Version.isX86()) {
            str = "x86";
        } else if (Version.isArmv7()) {
            str = "armeabi-v7a";
        }
        if (Version.isX86()) {
            loadOptionalLibrary("avutil-linphone-x86");
            loadOptionalLibrary("swscale-linphone-x86");
            loadOptionalLibrary("avcodec-linphone-x86");
        } else if (Version.isArmv7()) {
            loadOptionalLibrary("avutil-linphone-arm");
            loadOptionalLibrary("swscale-linphone-arm");
            loadOptionalLibrary("avcodec-linphone-arm");
        }
        loadOptionalLibrary("srtp-" + str);
        loadOptionalLibrary("zrtpcpp-" + str);
        System.loadLibrary("linphone-" + str);
        Version.dumpCapabilities();
    }

    private native void _setLogHandler(Object obj);

    public static boolean isArmv7() {
        return System.getProperty("os.arch").contains("armv7");
    }

    private static boolean loadOptionalLibrary(String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (Throwable th) {
            Log.w("Unable to load optional library lib", str);
            return false;
        }
    }

    public LinphoneAuthInfo createAuthInfo(String str, String str2, String str3, String str4) {
        return new LinphoneAuthInfoImpl(str, str2, str3, str4);
    }

    public LinphoneAuthInfo createAuthInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        return new LinphoneAuthInfoImpl(str, str2, str3, str4, str5, str6);
    }

    public LinphoneAddress createLinphoneAddress(String str) {
        return new LinphoneAddressImpl(str);
    }

    public LinphoneAddress createLinphoneAddress(String str, String str2, String str3) {
        return new LinphoneAddressImpl(str, str2, str3);
    }

    public LinphoneContent createLinphoneContent(String str, String str2, String str3) {
        return new LinphoneContentImpl(str, str2, str3.getBytes(), null);
    }

    public LinphoneContent createLinphoneContent(String str, String str2, byte[] bArr, String str3) {
        return new LinphoneContentImpl(str, str2, bArr, str3);
    }

    public LinphoneCore createLinphoneCore(LinphoneCoreListener linphoneCoreListener, Object obj) {
        try {
            MediastreamerAndroidContext.setContext(obj);
            return new LinphoneCoreImpl(linphoneCoreListener);
        } catch (Throwable e) {
            throw new LinphoneCoreException("Cannot create LinphoneCore", e);
        }
    }

    public LinphoneCore createLinphoneCore(LinphoneCoreListener linphoneCoreListener, String str, String str2, Object obj, Object obj2) {
        File file = null;
        try {
            MediastreamerAndroidContext.setContext(obj2);
            File file2 = str == null ? null : new File(str);
            if (str2 != null) {
                file = new File(str2);
            }
            return new LinphoneCoreImpl(linphoneCoreListener, file2, file, obj);
        } catch (Throwable e) {
            throw new LinphoneCoreException("Cannot create LinphoneCore", e);
        }
    }

    public LinphoneFriend createLinphoneFriend() {
        return createLinphoneFriend(null);
    }

    public LinphoneFriend createLinphoneFriend(String str) {
        return new LinphoneFriendImpl(str);
    }

    public LpConfig createLpConfig(String str) {
        return new LpConfigImpl(str);
    }

    public PresenceActivity createPresenceActivity(PresenceActivityType presenceActivityType, String str) {
        return new PresenceActivityImpl(presenceActivityType, str);
    }

    public PresenceModel createPresenceModel() {
        return new PresenceModelImpl();
    }

    public PresenceModel createPresenceModel(PresenceActivityType presenceActivityType, String str) {
        return new PresenceModelImpl(presenceActivityType, str);
    }

    public PresenceModel createPresenceModel(PresenceActivityType presenceActivityType, String str, String str2, String str3) {
        return new PresenceModelImpl(presenceActivityType, str, str2, str3);
    }

    public PresenceService createPresenceService(String str, PresenceBasicStatus presenceBasicStatus, String str2) {
        return new PresenceServiceImpl(str, presenceBasicStatus, str2);
    }

    public LinphoneProxyConfig createProxyConfig(String str, String str2, String str3, boolean z) {
        return new LinphoneProxyConfigImpl(str, str2, str3, z);
    }

    public native void setDebugMode(boolean z, String str);

    public void setLogHandler(LinphoneLogHandler linphoneLogHandler) {
        _setLogHandler(linphoneLogHandler);
    }
}
