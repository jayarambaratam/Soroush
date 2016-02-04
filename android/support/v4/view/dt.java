package android.support.v4.view;

class dt implements Runnable {
    final /* synthetic */ ViewPager f1355a;

    dt(ViewPager viewPager) {
        this.f1355a = viewPager;
    }

    public void run() {
        this.f1355a.setScrollState(0);
        this.f1355a.m1862d();
    }
}
