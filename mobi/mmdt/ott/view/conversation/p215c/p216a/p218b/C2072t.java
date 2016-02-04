package mobi.mmdt.ott.view.conversation.p215c.p216a.p218b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import mobi.mmdt.ott.view.components.p181b.C1790i;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.b.t */
public class C2072t extends C2053a {
    private TextView f6800c;
    private boolean f6801d;

    public C2072t(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(activity, c1790i, layoutInflater, viewGroup, 2130968668);
        this.f6800c = (TextView) this.itemView.findViewById(2131689740);
        this.f6800c.setOnLongClickListener(new C2073u(this));
        this.f6800c.setOnTouchListener(new C2074v(this));
    }

    protected void m9726a(mobi.mmdt.ott.view.components.p181b.C1722f r3) {
        /* JADX: method processing error */
/*
        Error: java.util.ConcurrentModificationException
	at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
	at java.util.ArrayList$Itr.next(ArrayList.java:851)
	at jadx.core.dex.visitors.ReSugarCode.getEnumMap(ReSugarCode.java:172)
	at jadx.core.dex.visitors.ReSugarCode.processEnumSwitch(ReSugarCode.java:123)
	at jadx.core.dex.visitors.ReSugarCode.process(ReSugarCode.java:68)
	at jadx.core.dex.visitors.ReSugarCode.visit(ReSugarCode.java:52)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r2 = this;
        r3 = (mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2170g) r3;
        super.m9659a(r3);
        r0 = r2.f6800c;
        r1 = r3.m9931p();
        r1 = (float) r1;
        r0.setTextSize(r1);
        r0 = r2.f6800c;
        r1 = r3.m9930o();
        r0.setText(r1);
        r0 = r2.f6800c;
        mobi.mmdt.ott.view.p178a.am.m8479a(r0);
        r0 = mobi.mmdt.ott.view.conversation.p215c.p216a.p218b.C2075w.f6804a;
        r1 = r3.m9849m();
        r1 = r1.ordinal();
        r0 = r0[r1];
        switch(r0) {
            case 1: goto L_0x002c;
            case 2: goto L_0x002c;
            case 3: goto L_0x002c;
            case 4: goto L_0x002c;
            case 5: goto L_0x002c;
            case 6: goto L_0x002c;
            case 7: goto L_0x002c;
            case 8: goto L_0x002c;
            default: goto L_0x002c;
        };
    L_0x002c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.conversation.c.a.b.t.a(mobi.mmdt.ott.view.components.b.f):void");
    }
}
