package org.linphone.mediastream.video;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import android.view.Surface.OutOfResourcesException;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.Version;
import org.linphone.mediastream.video.display.OpenGLESDisplay;

public class AndroidVideoWindowImpl {
    private Bitmap mBitmap;
    private VideoWindowListener mListener;
    private Surface mSurface;
    private SurfaceView mVideoPreviewView;
    private SurfaceView mVideoRenderingView;
    private Renderer renderer;
    private boolean useGLrendering;

    /* renamed from: org.linphone.mediastream.video.AndroidVideoWindowImpl.1 */
    class C28061 implements Callback {
        C28061() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.m11095i("Video display surface is being changed.");
            if (!AndroidVideoWindowImpl.this.useGLrendering) {
                synchronized (AndroidVideoWindowImpl.this) {
                    AndroidVideoWindowImpl.this.mBitmap = Bitmap.createBitmap(i2, i3, Config.RGB_565);
                    AndroidVideoWindowImpl.this.mSurface = surfaceHolder.getSurface();
                }
            }
            if (AndroidVideoWindowImpl.this.mListener != null) {
                AndroidVideoWindowImpl.this.mListener.onVideoRenderingSurfaceReady(AndroidVideoWindowImpl.this, AndroidVideoWindowImpl.this.mVideoRenderingView);
            }
            Log.m11097w("Video display surface changed");
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.m11097w("Video display surface created");
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (!AndroidVideoWindowImpl.this.useGLrendering) {
                synchronized (AndroidVideoWindowImpl.this) {
                    AndroidVideoWindowImpl.this.mSurface = null;
                    AndroidVideoWindowImpl.this.mBitmap = null;
                }
            }
            if (AndroidVideoWindowImpl.this.mListener != null) {
                AndroidVideoWindowImpl.this.mListener.onVideoRenderingSurfaceDestroyed(AndroidVideoWindowImpl.this);
            }
            Log.m11089d("Video display surface destroyed");
        }
    }

    /* renamed from: org.linphone.mediastream.video.AndroidVideoWindowImpl.2 */
    class C28072 implements Callback {
        C28072() {
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Log.m11095i("Video preview surface is being changed.");
            if (AndroidVideoWindowImpl.this.mListener != null) {
                AndroidVideoWindowImpl.this.mListener.onVideoPreviewSurfaceReady(AndroidVideoWindowImpl.this, AndroidVideoWindowImpl.this.mVideoPreviewView);
            }
            Log.m11097w("Video preview surface changed");
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Log.m11097w("Video preview surface created");
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (AndroidVideoWindowImpl.this.mListener != null) {
                AndroidVideoWindowImpl.this.mListener.onVideoPreviewSurfaceDestroyed(AndroidVideoWindowImpl.this);
            }
            Log.m11089d("Video preview surface destroyed");
        }
    }

    class Renderer implements android.opengl.GLSurfaceView.Renderer {
        int height;
        boolean initPending;
        int ptr;
        int width;

        public Renderer() {
            this.ptr = 0;
            this.initPending = false;
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                if (this.ptr == 0) {
                    return;
                }
                if (this.initPending) {
                    OpenGLESDisplay.init(this.ptr, this.width, this.height);
                    this.initPending = false;
                }
                OpenGLESDisplay.render(this.ptr);
            }
        }

        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            this.width = i;
            this.height = i2;
            this.initPending = true;
        }

        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        }

        public void setOpenGLESDisplay(int i) {
            synchronized (this) {
                if (!(this.ptr == 0 || i == this.ptr)) {
                    this.initPending = true;
                }
                this.ptr = i;
            }
        }
    }

    public interface VideoWindowListener {
        void onVideoPreviewSurfaceDestroyed(AndroidVideoWindowImpl androidVideoWindowImpl);

        void onVideoPreviewSurfaceReady(AndroidVideoWindowImpl androidVideoWindowImpl, SurfaceView surfaceView);

        void onVideoRenderingSurfaceDestroyed(AndroidVideoWindowImpl androidVideoWindowImpl);

        void onVideoRenderingSurfaceReady(AndroidVideoWindowImpl androidVideoWindowImpl, SurfaceView surfaceView);
    }

    public AndroidVideoWindowImpl(SurfaceView surfaceView, SurfaceView surfaceView2) {
        this.mVideoRenderingView = surfaceView;
        this.mVideoPreviewView = surfaceView2;
        this.useGLrendering = surfaceView instanceof GLSurfaceView;
        this.mBitmap = null;
        this.mSurface = null;
        this.mListener = null;
    }

    public static int rotationToAngle(int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return 90;
            case VideoSize.HVGA /*2*/:
                return 180;
            case Version.API03_CUPCAKE_15 /*3*/:
                return 270;
            default:
                return 0;
        }
    }

    public Bitmap getBitmap() {
        if (this.useGLrendering) {
            Log.m11091e("View class does not match Video display filter used (you must use a non-GL View)");
        }
        return this.mBitmap;
    }

    public Surface getSurface() {
        if (this.useGLrendering) {
            Log.m11091e("View class does not match Video display filter used (you must use a non-GL View)");
        }
        return this.mVideoRenderingView.getHolder().getSurface();
    }

    public void init() {
        this.mVideoRenderingView.getHolder().addCallback(new C28061());
        if (this.mVideoPreviewView != null) {
            this.mVideoPreviewView.getHolder().addCallback(new C28072());
        }
        if (this.useGLrendering) {
            this.renderer = new Renderer();
            ((GLSurfaceView) this.mVideoRenderingView).setRenderer(this.renderer);
            ((GLSurfaceView) this.mVideoRenderingView).setRenderMode(0);
        }
    }

    public void release() {
    }

    public void requestRender() {
        ((GLSurfaceView) this.mVideoRenderingView).requestRender();
    }

    public void setListener(VideoWindowListener videoWindowListener) {
        this.mListener = videoWindowListener;
    }

    public void setOpenGLESDisplay(int i) {
        if (!this.useGLrendering) {
            Log.m11091e("View class does not match Video display filter used (you must use a GL View)");
        }
        this.renderer.setOpenGLESDisplay(i);
    }

    public synchronized void update() {
        if (this.mSurface != null) {
            try {
                Canvas lockCanvas = this.mSurface.lockCanvas(null);
                lockCanvas.drawBitmap(this.mBitmap, 0.0f, 0.0f, null);
                this.mSurface.unlockCanvasAndPost(lockCanvas);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (OutOfResourcesException e2) {
                e2.printStackTrace();
            }
        }
    }
}
