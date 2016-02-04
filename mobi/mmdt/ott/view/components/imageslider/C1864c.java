package mobi.mmdt.ott.view.components.imageslider;

import android.os.Handler;
import android.os.Message;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.c */
class C1864c extends Handler {
    final /* synthetic */ SliderLayout f5985a;

    C1864c(SliderLayout sliderLayout) {
        this.f5985a = sliderLayout;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        this.f5985a.m8857a(true);
    }
}
