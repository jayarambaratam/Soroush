package org.linphone.mediastream.video.capture.hwconf;

import android.hardware.Camera.Size;
import java.util.List;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;

public class AndroidCameraConfiguration {
    private static AndroidCamera[] camerasCache;

    public class AndroidCamera {
        public boolean frontFacing;
        public int id;
        public int orientation;
        public List<Size> resolutions;

        public AndroidCamera(int i, boolean z, int i2, List<Size> list) {
            this.id = i;
            this.frontFacing = z;
            this.orientation = i2;
            this.resolutions = list;
        }
    }

    public static boolean hasFrontCamera() {
        initCamerasCache();
        for (AndroidCamera androidCamera : camerasCache) {
            if (androidCamera.frontFacing) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSeveralCameras() {
        initCamerasCache();
        return camerasCache.length > 1;
    }

    private static void initCamerasCache() {
        if (camerasCache == null) {
            try {
                if (Version.sdk() < 9) {
                    camerasCache = probeCamerasSDK5();
                } else {
                    camerasCache = probeCamerasSDK9();
                }
            } catch (Exception e) {
                Log.m11091e("Error: cannot retrieve cameras information (busy ?)", e);
                e.printStackTrace();
                camerasCache = new AndroidCamera[0];
            }
        }
    }

    static AndroidCamera[] probeCamerasSDK5() {
        return AndroidCameraConfigurationReader5.probeCameras();
    }

    static AndroidCamera[] probeCamerasSDK9() {
        return AndroidCameraConfigurationReader9.probeCameras();
    }

    public static AndroidCamera[] retrieveCameras() {
        initCamerasCache();
        return camerasCache;
    }
}
