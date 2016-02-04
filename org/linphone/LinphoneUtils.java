package org.linphone;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.provider.Contacts.People;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.HttpHost;
import org.linphone.core.LinphoneAddress;
import org.linphone.core.LinphoneCall;
import org.linphone.core.LinphoneCall.State;
import org.linphone.core.LinphoneCore;
import org.linphone.core.LinphoneCoreException;
import org.linphone.core.LinphoneCoreFactory;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;
import org.linphone.mediastream.video.capture.hwconf.Hacks;

public final class LinphoneUtils {
    private LinphoneUtils() {
    }

    public static void clearLogs() {
        try {
            Runtime.getRuntime().exec(new String[]{"logcat", "-c"});
        } catch (Throwable e) {
            C1104b.m6368b((Object) "LinphoneUtils", e);
        }
    }

    public static int countConferenceCalls(LinphoneCore linphoneCore) {
        int conferenceSize = linphoneCore.getConferenceSize();
        return linphoneCore.isInConference() ? conferenceSize - 1 : conferenceSize;
    }

    public static int countNonConferenceCalls(LinphoneCore linphoneCore) {
        return linphoneCore.getCallsNb() - countConferenceCalls(linphoneCore);
    }

    public static int countVirtualCalls(LinphoneCore linphoneCore) {
        return linphoneCore.getCallsNb() - countConferenceCalls(linphoneCore);
    }

    public static Bitmap downloadBitmap(Uri uri) {
        Throwable e;
        Throwable th;
        Bitmap bitmap = null;
        InputStream openStream;
        try {
            openStream = new URL(uri.toString()).openStream();
            try {
                bitmap = BitmapFactory.decodeStream(openStream);
                try {
                    openStream.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    Log.m11090e(e, e.getMessage());
                    try {
                        openStream.close();
                    } catch (IOException e4) {
                    }
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        openStream.close();
                    } catch (IOException e5) {
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            openStream = bitmap;
            Log.m11090e(e, e.getMessage());
            openStream.close();
            return bitmap;
        } catch (Throwable e7) {
            openStream = bitmap;
            th = e7;
            openStream.close();
            throw th;
        }
        return bitmap;
    }

    public static void enableView(View view, int i, OnClickListener onClickListener, boolean z) {
        View findViewById = view.findViewById(i);
        findViewById.setVisibility(z ? 0 : 8);
        findViewById.setOnClickListener(onClickListener);
    }

    public static Uri findUriPictureOfContactAndSetDisplayName(LinphoneAddress linphoneAddress, ContentResolver contentResolver) {
        ContactHelper contactHelper = new ContactHelper(linphoneAddress, contentResolver);
        contactHelper.query();
        return contactHelper.getUri();
    }

    public static List<LinphoneCall> getCallsInState(LinphoneCore linphoneCore, Collection<State> collection) {
        List<LinphoneCall> arrayList = new ArrayList();
        for (LinphoneCall linphoneCall : getLinphoneCalls(linphoneCore)) {
            if (collection.contains(linphoneCall.getState())) {
                arrayList.add(linphoneCall);
            }
        }
        return arrayList;
    }

    public static List<LinphoneCall> getLinphoneCalls(LinphoneCore linphoneCore) {
        return new ArrayList(Arrays.asList(linphoneCore.getCalls()));
    }

    public static List<LinphoneCall> getLinphoneCallsInConf(LinphoneCore linphoneCore) {
        List<LinphoneCall> arrayList = new ArrayList();
        for (LinphoneCall linphoneCall : linphoneCore.getCalls()) {
            if (linphoneCall.isInConference()) {
                arrayList.add(linphoneCall);
            }
        }
        return arrayList;
    }

    public static List<LinphoneCall> getLinphoneCallsNotInConf(LinphoneCore linphoneCore) {
        List<LinphoneCall> arrayList = new ArrayList();
        for (LinphoneCall linphoneCall : linphoneCore.getCalls()) {
            if (!linphoneCall.isInConference()) {
                arrayList.add(linphoneCall);
            }
        }
        return arrayList;
    }

    public static List<LinphoneCall> getRunningOrPausedCalls(LinphoneCore linphoneCore) {
        return getCallsInState(linphoneCore, Arrays.asList(new State[]{State.Paused, State.PausedByRemote, State.StreamsRunning}));
    }

    public static String getUsernameFromAddress(String str) {
        if (str.contains("sip:")) {
            str = str.replace("sip:", BuildConfig.FLAVOR);
        }
        return str.contains("@") ? str.split("@")[0] : str;
    }

    public static boolean hasExistingResumeableCall(LinphoneCore linphoneCore) {
        for (LinphoneCall state : getLinphoneCalls(linphoneCore)) {
            if (state.getState() == State.Paused) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCallEstablished(LinphoneCall linphoneCall) {
        if (linphoneCall == null) {
            return false;
        }
        State state = linphoneCall.getState();
        return isCallRunning(linphoneCall) || state == State.Paused || state == State.PausedByRemote || state == State.Pausing;
    }

    public static boolean isCallRunning(LinphoneCall linphoneCall) {
        if (linphoneCall == null) {
            return false;
        }
        State state = linphoneCall.getState();
        return state == State.Connected || state == State.CallUpdating || state == State.CallUpdatedByRemote || state == State.StreamsRunning || state == State.Resuming;
    }

    private static boolean isConnectionFast(int i, int i2) {
        if (i == 1) {
            return true;
        }
        if (i != 0) {
            return false;
        }
        switch (i2) {
            case VideoSize.CIF /*1*/:
                return false;
            case VideoSize.HVGA /*2*/:
                return false;
            case Version.API03_CUPCAKE_15 /*3*/:
            case Version.API06_ECLAIR_201 /*6*/:
            case Version.API08_FROYO_22 /*8*/:
            case Version.API09_GINGERBREAD_23 /*9*/:
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
            case Version.API11_HONEYCOMB_30 /*11*/:
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                return true;
            case Version.API04_DONUT_16 /*4*/:
                return false;
            case Version.API05_ECLAIR_20 /*5*/:
                return false;
            case Version.API07_ECLAIR_21 /*7*/:
                return false;
            default:
                return false;
        }
    }

    public static boolean isHightBandwidthConnection(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && isConnectionFast(activeNetworkInfo.getType(), activeNetworkInfo.getSubtype());
    }

    public static boolean isSipAddress(String str) {
        try {
            LinphoneCoreFactory.instance().createLinphoneAddress(str);
            return true;
        } catch (LinphoneCoreException e) {
            return false;
        }
    }

    public static boolean isStrictSipAddress(String str) {
        return isSipAddress(str) && str.startsWith("sip:");
    }

    public static boolean onKeyBackGoHome(Activity activity, int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return false;
        }
        activity.startActivity(new Intent().setAction("android.intent.action.MAIN").addCategory("android.intent.category.HOME"));
        return true;
    }

    public static boolean onKeyVolumeAdjust(int i) {
        if (((i != 24 && i != 25) || !Hacks.needSoftvolume()) && VERSION.SDK_INT < 15) {
            return false;
        }
        if (SipLibService.isReady()) {
            if (i == 24) {
                LinphoneManager.getInstance().adjustVolume(1);
            } else if (i == 25) {
                LinphoneManager.getInstance().adjustVolume(-1);
            }
            return true;
        }
        Log.m11095i("Couldn't change softvolume has service is not running");
        return true;
    }

    public static int pixelsToDpi(Resources resources, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, resources.getDisplayMetrics());
    }

    public static void setImagePictureFromUri(Context context, ImageView imageView, Uri uri, int i) {
        if (uri == null) {
            imageView.setImageResource(i);
        } else if (uri.getScheme().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            Bitmap downloadBitmap = downloadBitmap(uri);
            if (downloadBitmap == null) {
                imageView.setImageResource(i);
            }
            imageView.setImageBitmap(downloadBitmap);
        } else if (Version.sdkAboveOrEqual(6)) {
            imageView.setImageURI(uri);
        } else {
            imageView.setImageBitmap(People.loadContactPhoto(context, uri, i, null));
        }
    }

    public static void setVisibility(View view, int i, boolean z) {
        view.findViewById(i).setVisibility(z ? 0 : 8);
    }

    public static void setVisibility(View view, boolean z) {
        view.setVisibility(z ? 0 : 8);
    }
}
