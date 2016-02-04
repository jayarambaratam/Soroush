package android.support.design.widget;

import android.os.Build.VERSION;

final class dl implements ct {
    dl() {
    }

    public cn m757a() {
        return new cn(VERSION.SDK_INT >= 12 ? new cz() : new cx());
    }
}
