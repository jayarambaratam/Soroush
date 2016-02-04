package android.support.v4.app;

import java.util.ArrayList;

public class bo extends by {
    ArrayList<CharSequence> f911a;

    public bo() {
        this.f911a = new ArrayList();
    }

    public bo m1189a(CharSequence charSequence) {
        this.e = bm.m1168d(charSequence);
        return this;
    }

    public bo m1190b(CharSequence charSequence) {
        this.f = bm.m1168d(charSequence);
        this.g = true;
        return this;
    }

    public bo m1191c(CharSequence charSequence) {
        this.f911a.add(bm.m1168d(charSequence));
        return this;
    }
}
