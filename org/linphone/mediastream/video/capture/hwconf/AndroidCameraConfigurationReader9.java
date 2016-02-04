package org.linphone.mediastream.video.capture.hwconf;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import java.util.ArrayList;
import java.util.List;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration.AndroidCamera;

class AndroidCameraConfigurationReader9 {
    AndroidCameraConfigurationReader9() {
    }

    public static AndroidCamera[] probeCameras() {
        List arrayList = new ArrayList(Camera.getNumberOfCameras());
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            Camera open = Camera.open(i);
            arrayList.add(new AndroidCamera(i, cameraInfo.facing == 1, cameraInfo.orientation, open.getParameters().getSupportedPreviewSizes()));
            open.release();
        }
        return (AndroidCamera[]) arrayList.toArray(new AndroidCamera[arrayList.size()]);
    }
}
