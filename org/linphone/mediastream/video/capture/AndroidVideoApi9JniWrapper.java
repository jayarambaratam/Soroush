package org.linphone.mediastream.video.capture;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import java.util.List;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.linphone.mediastream.Log;

@TargetApi(9)
public class AndroidVideoApi9JniWrapper {

    /* renamed from: org.linphone.mediastream.video.capture.AndroidVideoApi9JniWrapper.1 */
    final class C28101 implements PreviewCallback {
        final /* synthetic */ long val$nativePtr;

        C28101(long j) {
            this.val$nativePtr = j;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (bArr == null) {
                Parameters parameters = camera.getParameters();
                Size previewSize = parameters.getPreviewSize();
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (previewSize.height * previewSize.width)) / 8;
                camera.addCallbackBuffer(new byte[(bitsPerPixel + (bitsPerPixel / 20))]);
            } else if (AndroidVideoApi5JniWrapper.isRecording) {
                AndroidVideoApi5JniWrapper.putImage(this.val$nativePtr, bArr);
                camera.addCallbackBuffer(bArr);
            }
        }
    }

    public static int detectCameras(int[] iArr, int[] iArr2, int[] iArr3) {
        return AndroidVideoApi5JniWrapper.detectCameras(iArr, iArr2, iArr3);
    }

    private static int[] findClosestEnclosingFpsRange(int i, List<int[]> list) {
        Log.m11089d("Searching for closest fps range from " + i);
        int[] iArr = (int[]) list.get(0);
        int abs = Math.abs(iArr[0] - i) + Math.abs(iArr[1] - i);
        int[] iArr2 = iArr;
        for (int[] iArr3 : list) {
            if (iArr3[0] <= i && iArr3[1] >= i) {
                int[] iArr4;
                int i2;
                int abs2 = Math.abs(iArr3[0] - i) + Math.abs(iArr3[1] - i);
                if (abs2 < abs) {
                    Log.m11089d("a better range has been found: w=" + iArr3[0] + ",h=" + iArr3[1]);
                    iArr4 = iArr3;
                    i2 = abs2;
                } else {
                    i2 = abs;
                    iArr4 = iArr2;
                }
                iArr2 = iArr4;
                abs = i2;
            }
        }
        Log.m11089d("The closest fps range is w=" + iArr2[0] + ",h=" + iArr2[1]);
        return iArr2;
    }

    public static int[] selectNearestResolutionAvailable(int i, int i2, int i3) {
        Log.m11089d("selectNearestResolutionAvailable: " + i + ", " + i2 + DataForm.ELEMENT + i3);
        return AndroidVideoApi5JniWrapper.selectNearestResolutionAvailableForCamera(i, i2, i3);
    }

    private static void setCameraDisplayOrientation(int i, int i2, Camera camera) {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i2, cameraInfo);
        Log.m11097w("Camera preview orientation: " + (cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360));
        try {
            camera.setDisplayOrientation(cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360);
        } catch (Exception e) {
            Log.m11091e("Failed to execute: camera[" + camera + "].setDisplayOrientation(" + r0 + ")");
            e.printStackTrace();
        }
    }

    public static void setPreviewDisplaySurface(Object obj, Object obj2) {
        AndroidVideoApi5JniWrapper.setPreviewDisplaySurface(obj, obj2);
    }

    public static Object startRecording(int i, int i2, int i3, int i4, int i5, long j) {
        Log.m11089d("startRecording(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + j + ")");
        try {
            Camera open = Camera.open(i);
            Parameters parameters = open.getParameters();
            parameters.setPreviewSize(i2, i3);
            int[] findClosestEnclosingFpsRange = findClosestEnclosingFpsRange(i4 * 1000, parameters.getSupportedPreviewFpsRange());
            parameters.setPreviewFpsRange(findClosestEnclosingFpsRange[0], findClosestEnclosingFpsRange[1]);
            open.setParameters(parameters);
            int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (i2 * i3)) / 8;
            open.addCallbackBuffer(new byte[bitsPerPixel]);
            open.addCallbackBuffer(new byte[bitsPerPixel]);
            open.setPreviewCallbackWithBuffer(new C28101(j));
            setCameraDisplayOrientation(i5, i, open);
            open.startPreview();
            AndroidVideoApi5JniWrapper.isRecording = true;
            Log.m11089d("Returning camera object: " + open);
            return open;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void stopRecording(Object obj) {
        AndroidVideoApi5JniWrapper.isRecording = false;
        AndroidVideoApi8JniWrapper.stopRecording(obj);
    }
}
