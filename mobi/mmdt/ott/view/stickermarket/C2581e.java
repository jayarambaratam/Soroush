package mobi.mmdt.ott.view.stickermarket;

import mobi.mmdt.ott.provider.p175i.C1638d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.stickermarket.e */
class C2581e implements Runnable {
    final /* synthetic */ C1638d f8285a;
    final /* synthetic */ C2580d f8286b;

    C2581e(C2580d c2580d, C1638d c1638d) {
        this.f8286b = c2580d;
        this.f8285a = c1638d;
    }

    public void run() {
        switch (C2590n.f8297a[this.f8285a.m8358b().ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f8286b.f8284a.m8493f(null);
                this.f8286b.f8284a.f8224j.setOnClickListener(this.f8286b.f8284a.f8239y);
                this.f8286b.f8284a.f8224j.setImageResource(2130838502);
            case VideoSize.HVGA /*2*/:
                this.f8286b.f8284a.m8493f(null);
                this.f8286b.f8284a.f8224j.setOnClickListener(this.f8286b.f8284a.f8239y);
                this.f8286b.f8284a.f8224j.setImageResource(2130838502);
            case Version.API03_CUPCAKE_15 /*3*/:
                this.f8286b.f8284a.m8493f(null);
                this.f8286b.f8284a.f8224j.setOnClickListener(this.f8286b.f8284a.f8239y);
                this.f8286b.f8284a.f8224j.setImageResource(2130838502);
            case Version.API04_DONUT_16 /*4*/:
                this.f8286b.f8284a.m8493f("Downloading...  " + this.f8285a.m8359c() + "%");
                this.f8286b.f8284a.f8224j.setOnClickListener(this.f8286b.f8284a.f8222A);
                this.f8286b.f8284a.f8224j.setImageResource(2130838583);
            case Version.API05_ECLAIR_20 /*5*/:
                this.f8286b.f8284a.m8493f("Downloaded");
                this.f8286b.f8284a.f8224j.setOnClickListener(this.f8286b.f8284a.f8240z);
                this.f8286b.f8284a.f8224j.setImageResource(2130838584);
            case Version.API06_ECLAIR_201 /*6*/:
                this.f8286b.f8284a.m8493f("Installing...");
                this.f8286b.f8284a.f8224j.setOnClickListener(this.f8286b.f8284a.f8240z);
                this.f8286b.f8284a.f8224j.setImageResource(2130838584);
            case Version.API07_ECLAIR_21 /*7*/:
                this.f8286b.f8284a.m8493f("Installed");
                this.f8286b.f8284a.f8224j.setOnClickListener(this.f8286b.f8284a.f8240z);
                this.f8286b.f8284a.f8224j.setImageResource(2130838584);
            default:
        }
    }
}
