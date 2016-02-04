package mobi.mmdt.ott.view.main.basenavigation.viewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;

/* renamed from: mobi.mmdt.ott.view.main.basenavigation.viewpager.a */
public class C2326a extends Scroller {
    public C2326a(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, PacketWriter.QUEUE_SIZE);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, PacketWriter.QUEUE_SIZE);
    }
}
