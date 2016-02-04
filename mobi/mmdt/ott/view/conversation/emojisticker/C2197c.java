package mobi.mmdt.ott.view.conversation.emojisticker;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.database.Cursor;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.C2203a;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.Emojicon;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.C2230g;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.C2231a;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.C2232b;
import mobi.mmdt.ott.view.conversation.emojisticker.viewpagerindicator.IconPageIndicator;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.c */
public class C2197c extends PopupWindow implements C2196b {
    private ArrayList<C2195a> f7230a;
    private ArrayList<C2231a> f7231b;
    private ArrayList<C2195a> f7232c;
    private ArrayList<C2231a> f7233d;
    private C1991h f7234e;
    private Activity f7235f;
    private View f7236g;
    private C2220i f7237h;
    private ViewPager f7238i;
    private ImageButton f7239j;
    private C2230g f7240k;
    private String f7241l;
    private LoaderCallbacks<Cursor> f7242m;
    private int f7243n;
    private OnClickListener f7244o;
    private OnClickListener f7245p;

    public C2197c(Activity activity, int i) {
        this.f7230a = new ArrayList();
        this.f7231b = new ArrayList();
        this.f7232c = new ArrayList();
        this.f7233d = new ArrayList();
        this.f7241l = BuildConfig.FLAVOR;
        this.f7242m = new C2199e(this);
        this.f7243n = 0;
        this.f7244o = new C2217f(this);
        this.f7245p = new C2218g(this);
        this.f7235f = activity;
        this.f7236g = activity.getLayoutInflater().inflate(2130968723, null);
        setContentView(this.f7236g);
        setAnimationStyle(2131427546);
        setWidth(-1);
        setHeight(i);
        setFocusable(false);
        m10038a();
        this.f7235f.getLoaderManager().initLoader(10, null, this.f7242m);
    }

    private void m10038a() {
        this.f7230a.add(C2203a.m10062a(this.f7235f, 3));
        this.f7230a.add(C2203a.m10062a(this.f7235f, 1));
        this.f7230a.add(C2203a.m10062a(this.f7235f, 2));
        this.f7230a.add(C2203a.m10062a(this.f7235f, 4));
        this.f7230a.add(C2203a.m10062a(this.f7235f, 5));
        this.f7231b.add(new C2232b(0, 3, 2130838450, 2130838451));
        this.f7231b.add(new C2232b(1, 1, 2130838446, 2130838447));
        this.f7231b.add(new C2232b(2, 2, 2130838442, 2130838443));
        this.f7231b.add(new C2232b(3, 4, 2130838444, 2130838445));
        this.f7231b.add(new C2232b(4, 5, 2130838454, 2130838455));
        this.f7238i = (ViewPager) this.f7236g.findViewById(2131689672);
        this.f7238i.removeAllViews();
        this.f7237h = new C2220i(this);
        this.f7238i.setAdapter(this.f7237h);
        this.f7238i.setOffscreenPageLimit(this.f7232c.size());
        this.f7240k = (IconPageIndicator) this.f7236g.findViewById(2131689850);
        this.f7240k.setViewPager(this.f7238i);
        Point f = C1111c.m6414f(this.f7235f);
        int i = this.f7235f.getResources().getConfiguration().orientation == 1 ? f.x / 8 : f.x / 8;
        this.f7238i.m1852a(new C2198d(this));
        this.f7239j = (ImageButton) this.f7236g.findViewById(2131689851);
        this.f7239j.getLayoutParams().width = i;
        this.f7239j.setOnClickListener(this.f7244o);
    }

    public void m10051a(int i, int i2, int i3, String str) {
        if (this.f7234e != null) {
            this.f7234e.m9361a(i, i2, i3, str);
        }
    }

    public void m10052a(Emojicon emojicon) {
        if (this.f7234e != null) {
            this.f7234e.m9362a(emojicon);
        }
    }

    public void m10053a(C1991h c1991h) {
        this.f7234e = c1991h;
    }
}
