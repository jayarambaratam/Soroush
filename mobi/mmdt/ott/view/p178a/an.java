package mobi.mmdt.ott.view.p178a;

import android.content.Context;
import android.graphics.Bitmap;
import com.p032a.p033a.p037d.p039b.p040a.C0605e;
import com.p032a.p033a.p037d.p049d.p050a.C0731d;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;

/* renamed from: mobi.mmdt.ott.view.a.an */
public class an extends C0731d {
    public an(Context context) {
        super(context);
    }

    protected Bitmap m8480a(C0605e c0605e, Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2 = null;
        try {
            bitmap2 = ai.m8472a(bitmap, 64, 64, 4, true);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
        return bitmap2;
    }

    public String m8481a() {
        return "mobi.mmdt.ott.view.tools.MyBlurTransformation";
    }
}
