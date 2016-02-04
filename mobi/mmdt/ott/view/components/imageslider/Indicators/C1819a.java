package mobi.mmdt.ott.view.components.imageslider.Indicators;

import android.database.DataSetObserver;
import android.support.v4.view.bt;
import android.view.View;
import android.widget.ImageView;
import mobi.mmdt.ott.view.components.imageslider.Tricks.C1824b;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.Indicators.a */
class C1819a extends DataSetObserver {
    final /* synthetic */ PagerIndicator f5864a;

    C1819a(PagerIndicator pagerIndicator) {
        this.f5864a = pagerIndicator;
    }

    public void onChanged() {
        bt adapter = this.f5864a.f5841b.getAdapter();
        int e = adapter instanceof C1824b ? ((C1824b) adapter).m8912e() : adapter.m871b();
        if (e > this.f5864a.f5848i) {
            for (int i = 0; i < e - this.f5864a.f5848i; i++) {
                View imageView = new ImageView(this.f5864a.f5840a);
                imageView.setImageDrawable(this.f5864a.f5847h);
                imageView.setPadding((int) this.f5864a.f5858s, (int) this.f5864a.f5860u, (int) this.f5864a.f5859t, (int) this.f5864a.f5861v);
                this.f5864a.addView(imageView);
                this.f5864a.f5862w.add(imageView);
            }
        } else if (e < this.f5864a.f5848i) {
            for (int i2 = 0; i2 < this.f5864a.f5848i - e; i2++) {
                this.f5864a.removeView((View) this.f5864a.f5862w.get(0));
                this.f5864a.f5862w.remove(0);
            }
        }
        this.f5864a.f5848i = e;
        this.f5864a.f5841b.setCurrentItem((this.f5864a.f5848i * 20) + this.f5864a.f5841b.getCurrentItem());
    }

    public void onInvalidated() {
        super.onInvalidated();
        this.f5864a.m8843b();
    }
}
