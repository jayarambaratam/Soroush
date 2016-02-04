package org.linphone.mediastream.video.capture;

import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import org.linphone.mediastream.Log;

public class AndroidVideoApi8JniWrapper {

    /* renamed from: org.linphone.mediastream.video.capture.AndroidVideoApi8JniWrapper.1 */
    final class C28091 implements PreviewCallback {
        final /* synthetic */ long val$nativePtr;

        C28091(long j) {
            this.val$nativePtr = j;
        }

        public void onPreviewFrame(byte[] bArr, Camera camera) {
            if (AndroidVideoApi5JniWrapper.isRecording) {
                AndroidVideoApi5JniWrapper.putImage(this.val$nativePtr, bArr);
                camera.addCallbackBuffer(bArr);
            }
        }
    }

    public static int detectCameras(int[] iArr, int[] iArr2, int[] iArr3) {
        return AndroidVideoApi5JniWrapper.detectCameras(iArr, iArr2, iArr3);
    }

    public static int[] selectNearestResolutionAvailable(int i, int i2, int i3) {
        return AndroidVideoApi5JniWrapper.selectNearestResolutionAvailable(i, i2, i3);
    }

    public static void setPreviewDisplaySurface(Object obj, Object obj2) {
        AndroidVideoApi5JniWrapper.setPreviewDisplaySurface(obj, obj2);
    }

    public static Object startRecording(int i, int i2, int i3, int i4, int i5, long j) {
        Log.m11089d("startRecording(" + i + ", " + i2 + ", " + i3 + ", " + i4 + ", " + i5 + ", " + j + ")");
        Camera open = Camera.open();
        AndroidVideoApi5JniWrapper.applyCameraParameters(open, i2, i3, i4);
        int bitsPerPixel = ((i2 * i3) * ImageFormat.getBitsPerPixel(open.getParameters().getPreviewFormat())) / 8;
        open.addCallbackBuffer(new byte[bitsPerPixel]);
        open.addCallbackBuffer(new byte[bitsPerPixel]);
        open.setPreviewCallbackWithBuffer(new C28091(j));
        open.startPreview();
        AndroidVideoApi5JniWrapper.isRecording = true;
        Log.m11089d("Returning camera object: " + open);
        return open;
    }

    public static void stopRecording(Object obj) {
        AndroidVideoApi5JniWrapper.isRecording = false;
        Log.m11089d("stopRecording(" + obj + ")");
        Camera camera = (Camera) obj;
        if (camera != null) {
            camera.setPreviewCallbackWithBuffer(null);
            camera.stopPreview();
            camera.release();
            return;
        }
        Log.m11095i("Cannot stop recording ('camera' is null)");
    }
}
