package mobi.mmdt.ott.view.conversation.emojisticker.emoji;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.conversation.emojisticker.C2195a;
import mobi.mmdt.ott.view.conversation.emojisticker.C2202j;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2212b;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2213c;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2214d;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2215e;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.C2216f;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.Emojicon;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.p230b.C2204a;
import mobi.mmdt.ott.view.p178a.p179a.C1656d;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.emoji.a */
public class C2203a extends C2195a implements C2202j {
    private Activity f7254b;
    private int f7255c;
    private RecyclerView f7256d;
    private C2208e f7257e;
    private GridLayoutManager f7258f;
    private View f7259g;
    private int f7260h;
    private int f7261i;
    private C1656d f7262j;

    private C2203a(Activity activity, int i) {
        this.f7254b = activity;
        this.f7255c = i;
        this.f7259g = LayoutInflater.from(this.f7254b).inflate(2130968722, null, false);
        m10065b();
    }

    public static C2203a m10062a(Activity activity, int i) {
        return new C2203a(activity, i);
    }

    private void m10063a(Activity activity) {
        Emojicon[] emojiconArr = null;
        Emojicon[] emojiconArr2 = C2214d.f7299a;
        switch (this.f7255c) {
            case VideoSize.CIF /*1*/:
                emojiconArr = C2212b.f7297a;
                break;
            case VideoSize.HVGA /*2*/:
                emojiconArr = C2213c.f7298a;
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                emojiconArr = C2214d.f7299a;
                break;
            case Version.API04_DONUT_16 /*4*/:
                emojiconArr = C2215e.f7300a;
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                emojiconArr = C2216f.f7301a;
                break;
            case Version.API06_ECLAIR_201 /*6*/:
            case Version.API07_ECLAIR_21 /*7*/:
                break;
            default:
                emojiconArr = emojiconArr2;
                break;
        }
        if (emojiconArr != null) {
            new Thread(new C2206c(this, emojiconArr, activity)).start();
        }
    }

    private void m10065b() {
        int i;
        Point f = C1111c.m6414f(this.f7254b);
        if (this.f7254b.getResources().getConfiguration().orientation == 1) {
            i = 8;
            this.f7260h = f.x / 8;
            this.f7261i = this.f7260h;
        } else {
            i = 14;
            this.f7260h = f.x / 14;
            this.f7261i = this.f7260h;
        }
        this.f7262j = new C2205b(this, this.f7254b, this.f7261i);
        this.f7262j.m8417a(false);
        this.f7258f = new GridLayoutManager(this.f7254b, i);
        this.f7256d = (RecyclerView) this.f7259g.findViewById(2131689797);
        this.f7257e = new C2208e(this, this.f7254b);
        this.f7256d.setHasFixedSize(true);
        this.f7256d.setAdapter(this.f7257e);
        this.f7256d.setLayoutManager(this.f7258f);
        m10063a(this.f7254b);
    }

    public View m10069a() {
        return this.f7259g;
    }

    public void m10070a(C2204a c2204a) {
        if (this.a != null) {
            this.a.m10035a(c2204a.m10071a());
        }
    }
}
