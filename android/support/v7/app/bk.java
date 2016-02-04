package android.support.v7.app;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.app.bm;
import android.support.v4.app.bn;

public class bk extends bm {
    public bk(Context context) {
        super(context);
    }

    protected bn m3670b() {
        return VERSION.SDK_INT >= 21 ? new bn() : VERSION.SDK_INT >= 16 ? new bm() : VERSION.SDK_INT >= 14 ? new bl() : super.m1184b();
    }
}
