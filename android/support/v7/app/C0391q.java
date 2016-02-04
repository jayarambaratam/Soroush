package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.cb;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0364g;
import android.support.v7.p019a.C0369l;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.apache.http.myHttp.entity.ContentLengthStrategy;

/* renamed from: android.support.v7.app.q */
class C0391q {
    private TextView f1905A;
    private TextView f1906B;
    private View f1907C;
    private ListAdapter f1908D;
    private int f1909E;
    private int f1910F;
    private int f1911G;
    private int f1912H;
    private int f1913I;
    private int f1914J;
    private int f1915K;
    private int f1916L;
    private Handler f1917M;
    private final OnClickListener f1918N;
    private final Context f1919a;
    private final bf f1920b;
    private final Window f1921c;
    private CharSequence f1922d;
    private CharSequence f1923e;
    private ListView f1924f;
    private View f1925g;
    private int f1926h;
    private int f1927i;
    private int f1928j;
    private int f1929k;
    private int f1930l;
    private boolean f1931m;
    private Button f1932n;
    private CharSequence f1933o;
    private Message f1934p;
    private Button f1935q;
    private CharSequence f1936r;
    private Message f1937s;
    private Button f1938t;
    private CharSequence f1939u;
    private Message f1940v;
    private NestedScrollView f1941w;
    private int f1942x;
    private Drawable f1943y;
    private ImageView f1944z;

    public C0391q(Context context, bf bfVar, Window window) {
        this.f1931m = false;
        this.f1942x = 0;
        this.f1909E = -1;
        this.f1916L = 0;
        this.f1918N = new C0392r(this);
        this.f1919a = context;
        this.f1920b = bfVar;
        this.f1921c = window;
        this.f1917M = new ac(bfVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0369l.AlertDialog, C0359b.alertDialogStyle, 0);
        this.f1910F = obtainStyledAttributes.getResourceId(C0369l.AlertDialog_android_layout, 0);
        this.f1911G = obtainStyledAttributes.getResourceId(C0369l.AlertDialog_buttonPanelSideLayout, 0);
        this.f1912H = obtainStyledAttributes.getResourceId(C0369l.AlertDialog_listLayout, 0);
        this.f1913I = obtainStyledAttributes.getResourceId(C0369l.AlertDialog_multiChoiceItemLayout, 0);
        this.f1914J = obtainStyledAttributes.getResourceId(C0369l.AlertDialog_singleChoiceItemLayout, 0);
        this.f1915K = obtainStyledAttributes.getResourceId(C0369l.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
    }

    private ViewGroup m3845a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void m3850a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f1925g != null ? this.f1925g : this.f1926h != 0 ? LayoutInflater.from(this.f1919a).inflate(this.f1926h, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && C0391q.m3852a(inflate))) {
            this.f1921c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1921c.findViewById(C0364g.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.f1931m) {
                frameLayout.setPadding(this.f1927i, this.f1928j, this.f1929k, this.f1930l);
            }
            if (this.f1924f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m3851a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f1921c.findViewById(C0364g.scrollIndicatorUp);
        View findViewById2 = this.f1921c.findViewById(C0364g.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            cb.m2394a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f1923e != null) {
                this.f1941w.setOnScrollChangeListener(new C0393s(this, findViewById, view2));
                this.f1941w.post(new C0394t(this, findViewById, view2));
            } else if (this.f1924f != null) {
                this.f1924f.setOnScrollListener(new C0395u(this, findViewById, view2));
                this.f1924f.post(new C0396v(this, findViewById, view2));
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    static boolean m3852a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0391q.m3852a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int m3853b() {
        return this.f1911G == 0 ? this.f1910F : this.f1916L == 1 ? this.f1911G : this.f1910F;
    }

    private static void m3855b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(cb.m2412b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!cb.m2412b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m3856b(ViewGroup viewGroup) {
        if (this.f1907C != null) {
            viewGroup.addView(this.f1907C, 0, new LayoutParams(-1, -2));
            this.f1921c.findViewById(C0364g.title_template).setVisibility(8);
            return;
        }
        this.f1944z = (ImageView) this.f1921c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f1922d) ? 1 : 0) != 0) {
            this.f1905A = (TextView) this.f1921c.findViewById(C0364g.alertTitle);
            this.f1905A.setText(this.f1922d);
            if (this.f1942x != 0) {
                this.f1944z.setImageResource(this.f1942x);
                return;
            } else if (this.f1943y != null) {
                this.f1944z.setImageDrawable(this.f1943y);
                return;
            } else {
                this.f1905A.setPadding(this.f1944z.getPaddingLeft(), this.f1944z.getPaddingTop(), this.f1944z.getPaddingRight(), this.f1944z.getPaddingBottom());
                this.f1944z.setVisibility(8);
                return;
            }
        }
        this.f1921c.findViewById(C0364g.title_template).setVisibility(8);
        this.f1944z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m3858c() {
        View findViewById = this.f1921c.findViewById(C0364g.parentPanel);
        View findViewById2 = findViewById.findViewById(C0364g.topPanel);
        View findViewById3 = findViewById.findViewById(C0364g.contentPanel);
        View findViewById4 = findViewById.findViewById(C0364g.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0364g.customPanel);
        m3850a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0364g.topPanel);
        View findViewById6 = viewGroup.findViewById(C0364g.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0364g.buttonPanel);
        ViewGroup a = m3845a(findViewById5, findViewById2);
        ViewGroup a2 = m3845a(findViewById6, findViewById3);
        ViewGroup a3 = m3845a(findViewById7, findViewById4);
        m3859c(a2);
        m3861d(a3);
        m3856b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById3 = a2.findViewById(C0364g.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z2 && this.f1941w != null) {
            this.f1941w.setClipToPadding(true);
        }
        if (!z) {
            findViewById3 = this.f1924f != null ? this.f1924f : this.f1941w;
            if (findViewById3 != null) {
                m3851a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f1924f;
        if (listView != null && this.f1908D != null) {
            listView.setAdapter(this.f1908D);
            int i = this.f1909E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void m3859c(ViewGroup viewGroup) {
        this.f1941w = (NestedScrollView) this.f1921c.findViewById(C0364g.scrollView);
        this.f1941w.setFocusable(false);
        this.f1941w.setNestedScrollingEnabled(false);
        this.f1906B = (TextView) viewGroup.findViewById(16908299);
        if (this.f1906B != null) {
            if (this.f1923e != null) {
                this.f1906B.setText(this.f1923e);
                return;
            }
            this.f1906B.setVisibility(8);
            this.f1941w.removeView(this.f1906B);
            if (this.f1924f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1941w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1941w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1924f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m3861d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f1932n = (Button) viewGroup.findViewById(16908313);
        this.f1932n.setOnClickListener(this.f1918N);
        if (TextUtils.isEmpty(this.f1933o)) {
            this.f1932n.setVisibility(8);
            i = 0;
        } else {
            this.f1932n.setText(this.f1933o);
            this.f1932n.setVisibility(0);
            i = 1;
        }
        this.f1935q = (Button) viewGroup.findViewById(16908314);
        this.f1935q.setOnClickListener(this.f1918N);
        if (TextUtils.isEmpty(this.f1936r)) {
            this.f1935q.setVisibility(8);
        } else {
            this.f1935q.setText(this.f1936r);
            this.f1935q.setVisibility(0);
            i |= 2;
        }
        this.f1938t = (Button) viewGroup.findViewById(16908315);
        this.f1938t.setOnClickListener(this.f1918N);
        if (TextUtils.isEmpty(this.f1939u)) {
            this.f1938t.setVisibility(8);
        } else {
            this.f1938t.setText(this.f1939u);
            this.f1938t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void m3872a() {
        this.f1920b.m3597a(1);
        this.f1920b.setContentView(m3853b());
        m3858c();
    }

    public void m3873a(int i) {
        this.f1925g = null;
        this.f1926h = i;
        this.f1931m = false;
    }

    public void m3874a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1917M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f1939u = charSequence;
                this.f1940v = message;
            case ContentLengthStrategy.CHUNKED /*-2*/:
                this.f1936r = charSequence;
                this.f1937s = message;
            case ContentLengthStrategy.IDENTITY /*-1*/:
                this.f1933o = charSequence;
                this.f1934p = message;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m3875a(Drawable drawable) {
        this.f1943y = drawable;
        this.f1942x = 0;
        if (this.f1944z == null) {
            return;
        }
        if (drawable != null) {
            this.f1944z.setImageDrawable(drawable);
        } else {
            this.f1944z.setVisibility(8);
        }
    }

    public void m3876a(View view, int i, int i2, int i3, int i4) {
        this.f1925g = view;
        this.f1926h = 0;
        this.f1931m = true;
        this.f1927i = i;
        this.f1928j = i2;
        this.f1929k = i3;
        this.f1930l = i4;
    }

    public void m3877a(CharSequence charSequence) {
        this.f1922d = charSequence;
        if (this.f1905A != null) {
            this.f1905A.setText(charSequence);
        }
    }

    public boolean m3878a(int i, KeyEvent keyEvent) {
        return this.f1941w != null && this.f1941w.m3018a(keyEvent);
    }

    public void m3879b(int i) {
        this.f1943y = null;
        this.f1942x = i;
        if (this.f1944z == null) {
            return;
        }
        if (i != 0) {
            this.f1944z.setImageResource(this.f1942x);
        } else {
            this.f1944z.setVisibility(8);
        }
    }

    public void m3880b(View view) {
        this.f1907C = view;
    }

    public void m3881b(CharSequence charSequence) {
        this.f1923e = charSequence;
        if (this.f1906B != null) {
            this.f1906B.setText(charSequence);
        }
    }

    public boolean m3882b(int i, KeyEvent keyEvent) {
        return this.f1941w != null && this.f1941w.m3018a(keyEvent);
    }

    public int m3883c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1919a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void m3884c(View view) {
        this.f1925g = view;
        this.f1926h = 0;
        this.f1931m = false;
    }
}
