package org.linphone.mediastream.video.capture;

import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.view.SurfaceView;
import java.util.List;
import org.jivesoftware.smackx.xdata.packet.DataForm;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration.AndroidCamera;

public class AndroidVideoApi5JniWrapper {
    public static boolean isRecording;

    /* renamed from: org.linphone.mediastream.video.capture.AndroidVideoApi5JniWrapper.1 */
    final class C28081 implements PreviewCallback {
        final /* synthetic */ long val$nativePtr;

        C28081(long j) {
            this.val$nativePtr = j;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (AndroidVideoApi5JniWrapper.isRecording) {
                AndroidVideoApi5JniWrapper.putImage(this.val$nativePtr, bArr);
            }
        }
    }

    static {
        isRecording = false;
    }

    public static void activateAutoFocus(Object obj) {
        Log.m11089d("mediastreamer", "Turning on autofocus on camera " + obj);
        Camera camera = (Camera) obj;
        if (camera == null) {
            return;
        }
        if (camera.getParameters().getFocusMode() == "auto" || camera.getParameters().getFocusMode() == "macro") {
            camera.autoFocus(null);
        }
    }

    protected static void applyCameraParameters(Camera camera, int i, int i2, int i3) {
        Parameters parameters = camera.getParameters();
        parameters.setPreviewSize(i, i2);
        List<Integer> supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates != null) {
            int i4 = Integer.MAX_VALUE;
            for (Integer num : supportedPreviewFrameRates) {
                int i5;
                int abs = Math.abs(num.intValue() - i3);
                if (abs < i4) {
                    parameters.setPreviewFrameRate(num.intValue());
                    i5 = abs;
                } else {
                    i5 = i4;
                }
                i4 = i5;
            }
            Log.m11089d("mediastreamer", "Preview framerate set:" + parameters.getPreviewFrameRate());
        }
        camera.setParameters(parameters);
    }

    public static int detectCameras(int[] iArr, int[] iArr2, int[] iArr3) {
        Log.m11089d("detectCameras\n");
        int i = 0;
        for (AndroidCamera androidCamera : AndroidCameraConfiguration.retrieveCameras()) {
            if (i == 2) {
                Log.m11097w("Returning only the 2 first cameras (increase buffer size to retrieve all)");
                break;
            }
            iArr[i] = androidCamera.id;
            iArr2[i] = androidCamera.frontFacing ? 1 : 0;
            iArr3[i] = androidCamera.orientation;
            i++;
        }
        return i;
    }

    public static native void putImage(long j, byte[] bArr);

    public static int[] selectNearestResolutionAvailable(int i, int i2, int i3) {
        Log.m11089d("mediastreamer", "selectNearestResolutionAvailable: " + i + ", " + i2 + DataForm.ELEMENT + i3);
        return selectNearestResolutionAvailableForCamera(i, i2, i3);
    }

    protected static int[] selectNearestResolutionAvailableForCamera(int i, int i2, int i3) {
        if (i3 <= i2) {
            int i4 = i3;
            i3 = i2;
            i2 = i4;
        }
        AndroidCamera[] retrieveCameras = AndroidCameraConfiguration.retrieveCameras();
        List list = null;
        int length = retrieveCameras.length;
        int i5 = 0;
        while (i5 < length) {
            AndroidCamera androidCamera = retrieveCameras[i5];
            i5++;
            list = androidCamera.id == i ? androidCamera.resolutions : list;
        }
        if (list == null) {
            Log.m11091e("mediastreamer", "Failed to retrieve supported resolutions.");
            return null;
        }
        Log.m11089d("mediastreamer", list.size() + " supported resolutions :");
        for (Size size : list) {
            Log.m11089d("mediastreamer", "\t" + size.width + DataForm.ELEMENT + size.height);
        }
        int max = Math.max(i3, i2);
        int min = Math.min(i3, i2);
        int i6 = max * min;
        int i7 = (int) ((((float) max) / ((float) min)) * 100.0f);
        try {
            int i8 = 0;
            Size size2 = null;
            int i9 = Integer.MAX_VALUE;
            for (Size size3 : list) {
                if (((int) ((((float) size3.width) / ((float) size3.height)) * 100.0f)) == i7) {
                    Size size4;
                    Size size5;
                    length = Math.abs(i6 - (size3.width * size3.height));
                    if (length < i9) {
                        i8 = 0;
                        i9 = length;
                        size4 = size3;
                    } else {
                        size4 = size2;
                    }
                    i5 = Math.abs(i6 - ((size3.width * size3.height) / 4));
                    if (i5 >= i9) {
                        i5 = i9;
                        size5 = size4;
                    } else if (Version.isArmv7() && Version.hasNeon()) {
                        i8 = 1;
                        size5 = size3;
                    } else {
                        i8 = 0;
                        i5 = i9;
                        size5 = size3;
                    }
                    if (size3.width == max && size3.height == min) {
                        i8 = 0;
                        size2 = size3;
                        break;
                    }
                    i4 = i5;
                    size2 = size5;
                    i9 = i4;
                }
            }
            Log.m11089d("mediastreamer", "resolution selection done (" + new int[]{size2.width, size2.height, i8}[0] + ", " + new int[]{size2.width, size2.height, i8}[1] + ", " + new int[]{size2.width, size2.height, i8}[2] + ")");
            return new int[]{size2.width, size2.height, i8};
        } catch (Exception e) {
            Log.m11091e("mediastreamer", "resolution selection failed");
            e.printStackTrace();
            return null;
        }
    }

    public static void setPreviewDisplaySurface(Object obj, Object obj2) {
        Log.m11089d("mediastreamer", "setPreviewDisplaySurface(" + obj + ", " + obj2 + ")");
        try {
            ((Camera) obj).setPreviewDisplay(((SurfaceView) obj2).getHolder());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object startRecording(int i, int i2, int i3, int i4, int i5, long j) {
        Log.m11089d("mediastreamer", "startRecording(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + j + ")");
        Camera open = Camera.open();
        applyCameraParameters(open, i2, i3, i4);
        open.setPreviewCallback(new C28081(j));
        open.startPreview();
        isRecording = true;
        Log.m11089d("mediastreamer", "Returning camera object: " + open);
        return open;
    }

    public static void stopRecording(Object obj) {
        isRecording = false;
        Log.m11089d("mediastreamer", "stopRecording(" + obj + ")");
        Camera camera = (Camera) obj;
        if (camera != null) {
            camera.setPreviewCallback(null);
            camera.stopPreview();
            camera.release();
            return;
        }
        Log.m11095i("mediastreamer", "Cannot stop recording ('camera' is null)");
    }
}
