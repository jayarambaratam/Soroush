package com.p063b.p064a;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

/* renamed from: com.b.a.cn */
public class cn extends ImageView {
    private static Method f3447a;

    static {
        f3447a = null;
    }

    public cn(Context context) {
        super(context);
        try {
            f3447a = View.class.getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class});
        } catch (NoSuchMethodException e) {
        }
    }

    private void m5647a() {
        if (f3447a != null) {
            try {
                f3447a.invoke(this, new Object[]{Integer.valueOf(1), null});
            } catch (Throwable e) {
                Log.w("SVGImageView", "Unexpected failure calling setLayerType", e);
            }
        }
    }

    private boolean m5648a(Uri uri) {
        InputStream inputStream = null;
        try {
            inputStream = getContext().getContentResolver().openInputStream(uri);
            C0929n a = C0929n.m5791a(inputStream);
            m5647a();
            setImageDrawable(new PictureDrawable(a.m5793a()));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            return true;
        } catch (Throwable e2) {
            Log.w("ImageView", "Unable to open content: " + uri, e2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
    }

    public void setImageAsset(String str) {
        try {
            C0929n a = C0929n.m5790a(getContext().getAssets(), str);
            m5647a();
            setImageDrawable(new PictureDrawable(a.m5793a()));
        } catch (Throwable e) {
            Log.w("SVGImageView", "Unable to find asset file: " + str, e);
        }
    }

    public void setImageResource(int i) {
        try {
            C0929n a = C0929n.m5789a(getContext(), i);
            m5647a();
            setImageDrawable(new PictureDrawable(a.m5793a()));
        } catch (Throwable e) {
            Log.w("SVGImageView", "Unable to find resource: " + i, e);
        }
    }

    public void setImageURI(Uri uri) {
        m5648a(uri);
    }
}
