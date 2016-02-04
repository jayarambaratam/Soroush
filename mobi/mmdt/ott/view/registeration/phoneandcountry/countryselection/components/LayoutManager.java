package mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.HashMap;
import mobi.mmdt.ott.C1317h;

public class LayoutManager extends android.support.v7.widget.RecyclerView.LayoutManager {
    private final C2459t f7981a;
    private final C2459t f7982b;
    private int f7983c;
    private Rect f7984d;
    private int f7985e;
    private HashMap<String, C2459t> f7986f;
    private boolean f7987g;

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        public int f7979a;
        public int f7980b;

        static {
            CREATOR = new C2469n();
        }

        protected SavedState() {
        }

        protected SavedState(Parcel parcel) {
            this.f7979a = parcel.readInt();
            this.f7980b = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f7979a);
            parcel.writeInt(this.f7980b);
        }
    }

    public LayoutManager(Context context) {
        this.f7983c = -1;
        this.f7984d = new Rect();
        this.f7985e = 0;
        this.f7987g = true;
        this.f7981a = new C2473r(this);
        this.f7982b = new C2460e(this, context);
        this.f7986f = new HashMap();
    }

    private float m10682a(State state, boolean z) {
        View childAt = getChildAt(0);
        int position = getPosition(childAt);
        int i = 0;
        float decoratedTop = (float) getDecoratedTop(childAt);
        if (((float) getDecoratedBottom(childAt)) < 0.0f) {
            decoratedTop = 1.0f;
        } else if (0.0f <= decoratedTop) {
            decoratedTop = 0.0f;
        } else {
            decoratedTop = (-decoratedTop) / ((float) getDecoratedMeasuredHeight(childAt));
        }
        C2474s c2474s = new C2474s(this, childAt);
        if (c2474s.f8051l.f8010a && c2474s.f8051l.m10772f()) {
            return decoratedTop;
        }
        int i2 = -1;
        SparseArray sparseArray = new SparseArray();
        float f = decoratedTop;
        for (int i3 = 1; i3 < getChildCount(); i3++) {
            View childAt2 = getChildAt(i3);
            C2461j c2461j = (C2461j) childAt2.getLayoutParams();
            if (!c2474s.m10797a(c2461j)) {
                break;
            }
            int position2 = getPosition(childAt2);
            if (!z && position2 < position) {
                i++;
            }
            float decoratedTop2 = (float) getDecoratedTop(childAt2);
            if (((float) getDecoratedBottom(childAt2)) < 0.0f) {
                f += 1.0f;
            } else if (0.0f > decoratedTop2) {
                f += (-decoratedTop2) / ((float) getDecoratedMeasuredHeight(childAt2));
            } else {
            }
            if (!c2461j.f8010a) {
                if (i2 == -1) {
                    i2 = position2;
                }
                sparseArray.put(position2, Boolean.valueOf(true));
            }
        }
        return (f - ((float) i)) - ((float) m10697a(c2474s).m10733a(i2, sparseArray));
    }

    private int m10683a(int i, int i2, int i3) {
        if (i2 < i) {
            return -1;
        }
        int i4 = i + ((i2 - i) / 2);
        C2461j c2461j = (C2461j) getChildAt(i4).getLayoutParams();
        if (c2461j.m10770d() < i3) {
            return m10683a(i4 + 1, i2, i3);
        }
        if (c2461j.m10770d() > i3 || c2461j.f8010a) {
            return m10683a(i, i4 - 1, i3);
        }
        if (i4 == getChildCount() - 1) {
            return i4;
        }
        c2461j = (C2461j) getChildAt(i4 + 1).getLayoutParams();
        if (c2461j.m10770d() != i3) {
            return i4;
        }
        if (c2461j.f8010a) {
            if (i4 + 1 == getChildCount() - 1) {
                return i4;
            }
            if (((C2461j) getChildAt(i4 + 2).getLayoutParams()).m10770d() != i3) {
                return i4;
            }
        }
        return m10683a(i4 + 1, i2, i3);
    }

    private int m10684a(int i, int i2, C2471p c2471p) {
        if (i2 >= i) {
            return i2;
        }
        int position = getPosition(m10712c()) + 1;
        if (position >= c2471p.m10782a().getItemCount()) {
            return i2;
        }
        int b;
        C2472q c = c2471p.m10787c(position);
        C2474s c2474s = new C2474s(this, c.f8037a);
        if (c2474s.f8041b) {
            m10720a(c.f8037a);
            c2474s = new C2474s(this, c.f8037a);
            b = m10705b(c.f8037a, i2, c2474s, c2471p);
            position++;
        } else {
            c2471p.m10784a(position, c.f8037a);
            b = i2;
        }
        if (position < c2471p.m10782a().getItemCount()) {
            b = m10697a(c2474s).m10732a(i, b, position, c2474s, c2471p);
        }
        if (c2474s.f8041b) {
            addView(c.f8037a);
            if (c.f8038b) {
                c2471p.m10783a(c2474s.f8040a);
            }
            b = Math.max(getDecoratedBottom(c.f8037a), b);
        }
        return m10684a(i, b, c2471p);
    }

    private int m10685a(int i, C2465i c2465i, C2471p c2471p) {
        return c2465i == C2465i.START ? m10704b(i, c2471p) : m10686a(i, c2471p);
    }

    private int m10686a(int i, C2471p c2471p) {
        View c = m10712c();
        C2474s c2474s = new C2474s(this, m10707b(((C2461j) c.getLayoutParams()).m10770d(), C2465i.END, c2471p));
        int a = m10687a(m10692a(c2474s.f8040a), m10697a(c2474s).m10734a(i, c, c2474s, c2471p));
        return a <= i ? m10684a(i, a, c2471p) : a;
    }

    private int m10687a(View view, int i) {
        if (view == null) {
            return i;
        }
        detachView(view);
        attachView(view, -1);
        return Math.max(i, getDecoratedBottom(view));
    }

    private int m10688a(View view, int i, int i2, int i3, int i4, C2474s c2474s, C2471p c2471p) {
        Rect a = m10691a(this.f7984d, c2474s, c2471p);
        if (c2474s.f8051l.m10772f() && !c2474s.f8051l.m10773g()) {
            a.bottom = i2;
            a.top = a.bottom - c2474s.f8046g;
        } else if (i3 <= 0) {
            a.top = i2 + i3;
            a.bottom = a.top + c2474s.f8046g;
        } else {
            a.bottom = i;
            a.top = a.bottom - c2474s.f8046g;
        }
        if (c2474s.f8051l.m10775i() && a.top < i && c2474s.f8040a != c2471p.m10782a().getTargetScrollPosition()) {
            a.top = i;
            a.bottom = a.top + c2474s.f8046g;
            if (c2474s.f8051l.m10772f() && !c2474s.f8051l.m10773g()) {
                i2 -= c2474s.f8046g;
            }
        }
        if (a.bottom > i4) {
            a.bottom = i4;
            a.top = a.bottom - c2474s.f8046g;
        }
        layoutDecorated(view, a.left, a.top, a.right, a.bottom);
        return Math.min(a.top, i2);
    }

    private int m10689a(View view, int i, int i2, C2474s c2474s, C2471p c2471p) {
        if (!c2474s.f8041b) {
            return i2;
        }
        int i3;
        View a;
        int a2;
        C2459t a3 = m10697a(c2474s);
        int b = m10702b(c2474s.f8040a);
        int height = getHeight();
        for (i3 = b == -1 ? 0 : b; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            C2461j c2461j = (C2461j) childAt.getLayoutParams();
            if (c2461j.m10770d() != c2474s.f8040a) {
                a = m10693a(c2461j.m10770d(), i3, C2465i.START);
                height = a == null ? getDecoratedTop(childAt) : getDecoratedTop(a);
                i3 = (b == -1 || !c2474s.f8051l.m10772f() || c2474s.f8051l.m10773g()) ? i2 : height;
                if (c2474s.f8051l.m10772f() || c2474s.f8051l.m10773g()) {
                    a = a3.m10737a(c2474s.f8040a, true);
                    a2 = a != null ? 0 : a3.m10735a(getPosition(a), c2474s, c2471p);
                } else {
                    a2 = 0;
                }
                i2 = m10688a(view, i, i3, a2, height, c2474s, c2471p);
                m10698a(view, i, c2474s, c2471p);
                return i2;
            }
        }
        if (b == -1) {
        }
        if (c2474s.f8051l.m10772f()) {
        }
        a = a3.m10737a(c2474s.f8040a, true);
        if (a != null) {
        }
        i2 = m10688a(view, i, i3, a2, height, c2474s, c2471p);
        m10698a(view, i, c2474s, c2471p);
        return i2;
    }

    private Rect m10691a(Rect rect, C2474s c2474s, C2471p c2471p) {
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (c2474s.f8051l.m10771e()) {
            if (c2474s.f8051l.m10773g() || c2474s.f8051l.f8015f || c2474s.f8050k <= 0) {
                if (c2471p.f8035c) {
                    rect.right = getWidth() - paddingRight;
                    rect.left = rect.right - c2474s.f8045f;
                } else {
                    rect.left = paddingLeft;
                    rect.right = rect.left + c2474s.f8045f;
                }
            } else if (c2471p.f8035c) {
                rect.left = (getWidth() - c2474s.f8050k) - paddingRight;
                rect.right = rect.left + c2474s.f8045f;
            } else {
                rect.right = paddingLeft + c2474s.f8050k;
                rect.left = rect.right - c2474s.f8045f;
            }
        } else if (!c2474s.f8051l.m10774h()) {
            rect.left = paddingLeft;
            rect.right = rect.left + c2474s.f8045f;
        } else if (c2474s.f8051l.m10773g() || c2474s.f8051l.f8014e || c2474s.f8049j <= 0) {
            if (c2471p.f8035c) {
                rect.left = paddingLeft;
                rect.right = rect.left + c2474s.f8045f;
            } else {
                rect.right = getWidth() - paddingRight;
                rect.left = rect.right - c2474s.f8045f;
            }
        } else if (c2471p.f8035c) {
            rect.right = paddingLeft + c2474s.f8049j;
            rect.left = rect.right - c2474s.f8045f;
        } else {
            rect.left = (getWidth() - c2474s.f8049j) - paddingRight;
            rect.right = rect.left + c2474s.f8045f;
        }
        return rect;
    }

    private View m10692a(int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            C2461j c2461j = (C2461j) childAt.getLayoutParams();
            if (c2461j.m10770d() != i) {
                break;
            } else if (c2461j.f8010a) {
                return childAt;
            } else {
                childCount--;
            }
        }
        return null;
    }

    private View m10693a(int i, int i2, C2465i c2465i) {
        int i3 = c2465i == C2465i.START ? 1 : -1;
        while (i2 >= 0 && i2 < getChildCount()) {
            View childAt = getChildAt(i2);
            if (getPosition(childAt) == i) {
                return childAt;
            }
            if (((C2461j) childAt.getLayoutParams()).m10770d() != i) {
                break;
            }
            i2 += i3;
        }
        return null;
    }

    private View m10694a(int i, C2465i c2465i) {
        return c2465i == C2465i.END ? m10692a(i) : m10706b(0, getChildCount() - 1, i);
    }

    private C2459t m10695a(int i, String str) {
        if (i == -1) {
            return (C2459t) this.f7986f.get(str);
        }
        if (i == 1) {
            return this.f7981a;
        }
        if (i == 2) {
            return this.f7982b;
        }
        throw new C2468m(this, i);
    }

    private C2459t m10696a(C2461j c2461j) {
        if (c2461j.f8017h == -1) {
            return (C2459t) this.f7986f.get(c2461j.f8016g);
        }
        if (c2461j.f8017h == 1) {
            return this.f7981a;
        }
        if (c2461j.f8017h == 2) {
            return this.f7982b;
        }
        throw new C2468m(this, c2461j.f8017h);
    }

    private C2459t m10697a(C2474s c2474s) {
        C2459t c2459t;
        if (c2474s.f8051l.f8017h == -1) {
            c2459t = (C2459t) this.f7986f.get(c2474s.f8043d);
            if (c2459t == null) {
                throw new C2470o(this, c2474s.f8043d);
            }
        } else if (c2474s.f8051l.f8017h == 1) {
            c2459t = this.f7981a;
        } else if (c2474s.f8051l.f8017h == 2) {
            c2459t = this.f7982b;
        } else {
            throw new C2468m(this, c2474s.f8051l.f8017h);
        }
        return c2459t.m10744b(c2474s);
    }

    private void m10698a(View view, int i, C2474s c2474s, C2471p c2471p) {
        if (c2471p.m10785b(c2474s.f8040a) != null && getDecoratedBottom(view) > i) {
            addView(view, m10702b(c2474s.f8040a) + 1);
            c2471p.m10783a(c2474s.f8040a);
        }
    }

    private void m10699a(C2465i c2465i, C2471p c2471p) {
        if (c2465i == C2465i.START) {
            m10714c(c2471p);
        } else {
            m10709b(c2471p);
        }
    }

    private boolean m10700a(C2471p c2471p) {
        int itemCount = c2471p.m10782a().getItemCount();
        if (getChildCount() == 0) {
            return false;
        }
        View a = m10718a();
        boolean z = getPosition(a) == 0;
        boolean z2 = getDecoratedTop(a) > getPaddingTop();
        boolean z3 = getDecoratedTop(a) == getPaddingTop();
        if (z && z2) {
            return true;
        }
        if (z && z3) {
            return false;
        }
        View b = m10721b();
        return (getPosition(b) == itemCount + -1) && (getDecoratedBottom(b) < getHeight() - getPaddingBottom());
    }

    private float m10701b(State state, boolean z) {
        float height = (float) getHeight();
        View childAt = getChildAt(getChildCount() - 1);
        int position = getPosition(childAt);
        C2474s c2474s = new C2474s(this, childAt);
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        float f = 0.0f;
        int i2 = -1;
        for (int i3 = 1; i3 <= getChildCount(); i3++) {
            View childAt2 = getChildAt(getChildCount() - i3);
            C2461j c2461j = (C2461j) childAt2.getLayoutParams();
            if (!c2474s.m10797a(c2461j)) {
                break;
            }
            int position2 = getPosition(childAt2);
            if (!(c2461j.f8010a || z || position2 <= position)) {
                i++;
            }
            float decoratedBottom = (float) getDecoratedBottom(childAt2);
            float decoratedTop = (float) getDecoratedTop(childAt2);
            if (decoratedBottom > height) {
                if (height < decoratedTop) {
                    f += 1.0f;
                } else {
                    f += (decoratedBottom - height) / ((float) getDecoratedMeasuredHeight(childAt2));
                }
                if (!c2461j.f8010a) {
                    if (i2 == -1) {
                        i2 = position2;
                    }
                    sparseArray.put(position2, Boolean.valueOf(true));
                }
            }
        }
        return (f - ((float) i)) - ((float) m10697a(c2474s).m10742b(i2, sparseArray));
    }

    private int m10702b(int i) {
        return m10683a(0, getChildCount() - 1, i);
    }

    private int m10703b(int i, int i2, C2471p c2471p) {
        if (i2 < i) {
            return i2;
        }
        View d = m10715d();
        View a = m10693a(((C2461j) d.getLayoutParams()).m10769c(), 0, C2465i.START);
        int position = a != null ? getPosition(a) - 1 : getPosition(d) - 1;
        if (position < 0) {
            return i2;
        }
        View b = m10707b(c2471p.m10787c(position).m10788a().m10770d(), C2465i.START, c2471p);
        C2474s c2474s = new C2474s(this, b);
        if (c2474s.f8041b) {
            m10720a(b);
            c2474s = new C2474s(this, b);
        }
        C2459t a2 = m10697a(c2474s);
        int b2 = position >= 0 ? a2.m10741b(i, i2, position, c2474s, c2471p) : i2;
        if (c2474s.f8041b) {
            int i3 = 0;
            if (!c2474s.f8051l.m10772f() || c2474s.f8051l.m10773g()) {
                d = a2.m10737a(c2474s.f8040a, true);
                i3 = d == null ? 0 : a2.m10735a(getPosition(d), c2474s, c2471p);
            }
            b2 = m10688a(b, i, b2, i3, i2, c2474s, c2471p);
            m10698a(b, i, c2474s, c2471p);
        }
        return m10703b(i, b2, c2471p);
    }

    private int m10704b(int i, C2471p c2471p) {
        View d = m10715d();
        View b = m10707b(((C2461j) d.getLayoutParams()).m10770d(), C2465i.START, c2471p);
        C2474s c2474s = new C2474s(this, b);
        C2459t a = m10697a(c2474s);
        int position = getPosition(d);
        position = position == c2474s.f8040a ? getDecoratedTop(d) : (position + -1 == c2474s.f8040a && c2474s.f8041b) ? getDecoratedTop(d) : a.m10743b(i, d, c2474s, c2471p);
        int a2 = m10689a(b, i, position, c2474s, c2471p);
        return a2 > i ? m10703b(i, a2, c2471p) : a2;
    }

    private int m10705b(View view, int i, C2474s c2474s, C2471p c2471p) {
        Rect a = m10691a(this.f7984d, c2474s, c2471p);
        a.top = i;
        a.bottom = a.top + c2474s.f8046g;
        if (c2474s.f8051l.m10772f() && !c2474s.f8051l.m10773g()) {
            i = a.bottom;
        }
        if (c2474s.f8051l.m10775i() && a.top < 0) {
            a.top = 0;
            a.bottom = a.top + c2474s.f8046g;
        }
        layoutDecorated(view, a.left, a.top, a.right, a.bottom);
        return i;
    }

    private View m10706b(int i, int i2, int i3) {
        if (i2 < i) {
            return null;
        }
        int i4 = i + ((i2 - i) / 2);
        View childAt = getChildAt(i4);
        C2461j c2461j = (C2461j) childAt.getLayoutParams();
        return c2461j.m10770d() != i3 ? m10706b(i, i4 - 1, i3) : c2461j.f8010a ? childAt : m10706b(i4 + 1, i2, i3);
    }

    private View m10707b(int i, C2465i c2465i, C2471p c2471p) {
        View a = m10693a(i, c2465i == C2465i.START ? 0 : getChildCount() - 1, c2465i);
        if (a == null) {
            C2472q c = c2471p.m10787c(i);
            a = c.f8037a;
            if (c.m10788a().f8010a) {
                m10720a(c.f8037a);
            }
            c2471p.m10784a(i, a);
        }
        return a;
    }

    private void m10708b(View view) {
        int i = 0;
        C2474s c2474s = new C2474s(this, view);
        if (c2474s.f8051l.m10775i()) {
            int b = m10702b(c2474s.f8040a);
            if (b != -1) {
                C2459t a = m10697a(c2474s);
                int a2 = a.m10731a(c2474s.f8040a, b, getHeight());
                b = a.m10740b(c2474s.f8040a, 0, 0);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(view);
                if ((c2474s.f8051l.m10772f() && !c2474s.f8051l.m10773g()) || a2 - b >= decoratedMeasuredHeight) {
                    int decoratedLeft = getDecoratedLeft(view);
                    int decoratedRight = getDecoratedRight(view);
                    int i2 = 0 + decoratedMeasuredHeight;
                    if (i2 > a2) {
                        i = a2 - decoratedMeasuredHeight;
                    } else {
                        a2 = i2;
                    }
                    layoutDecorated(view, decoratedLeft, i, decoratedRight, a2);
                }
            }
        }
    }

    private void m10709b(C2471p c2471p) {
        int height = getHeight();
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (getDecoratedTop(childAt) >= height) {
                removeAndRecycleView(childAt, c2471p.f8033a);
            } else if (!((C2461j) childAt.getLayoutParams()).f8010a) {
                return;
            }
        }
    }

    private int m10710c(int i) {
        C2474s c2474s = new C2474s(this, getChildAt(0));
        return i < getPosition(m10697a(c2474s).m10737a(c2474s.f8040a, true)) ? -1 : 1;
    }

    private int m10711c(int i, int i2, C2471p c2471p) {
        int b;
        int i3;
        int height = getHeight();
        C2472q c = c2471p.m10787c(i);
        c2471p.m10784a(i, c.f8037a);
        int d = c.m10788a().m10770d();
        C2472q c2 = c2471p.m10787c(d);
        m10720a(c2.f8037a);
        c2471p.m10784a(d, c2.f8037a);
        C2474s c2474s = new C2474s(this, c2.f8037a);
        C2459t a = m10697a(c2474s);
        if (c2474s.f8041b && i == c2474s.f8040a) {
            b = m10705b(c2.f8037a, i2, c2474s, c2471p);
            i3 = i + 1;
        } else {
            i3 = i;
            b = i2;
        }
        int a2 = a.m10732a(height, b, i3, c2474s, c2471p);
        if (!c2474s.f8041b || i == c2474s.f8040a) {
            a2 = Math.max(a2, getDecoratedBottom(c2.f8037a));
        } else {
            m10688a(c2.f8037a, 0, i2, a.m10735a(i3, c2474s, c2471p), a2, c2474s, c2471p);
        }
        if (c2474s.f8041b) {
            if (getDecoratedBottom(c2.f8037a) > 0) {
                addView(c2.f8037a);
                c2471p.m10783a(c2474s.f8040a);
            }
        }
        return m10684a(height, a2, c2471p);
    }

    private View m10712c() {
        if (getChildCount() == 1) {
            return getChildAt(0);
        }
        View childAt = getChildAt(getChildCount() - 1);
        C2461j c2461j = (C2461j) childAt.getLayoutParams();
        if (c2461j.f8010a) {
            View childAt2 = getChildAt(getChildCount() - 2);
            if (((C2461j) childAt2.getLayoutParams()).m10770d() == c2461j.m10770d()) {
                return childAt2;
            }
        }
        return childAt;
    }

    private void m10713c(int i, C2471p c2471p) {
        if (m10700a(c2471p)) {
            offsetChildrenVertical((getHeight() - getPaddingBottom()) - i);
            int b = m10704b(0, c2471p);
            if (b > getPaddingTop()) {
                offsetChildrenVertical(getPaddingTop() - b);
            }
        }
    }

    private void m10714c(C2471p c2471p) {
        int i;
        View view;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (getDecoratedBottom(childAt) > 0) {
                i = i2;
                view = childAt;
                break;
            }
        }
        i = 0;
        view = null;
        if (view == null) {
            detachAndScrapAttachedViews(c2471p.f8033a);
            return;
        }
        int i3;
        int i4;
        C2461j c2461j = (C2461j) view.getLayoutParams();
        if (c2461j.f8010a) {
            for (i3 = i - 1; i3 >= 0; i3--) {
                C2461j c2461j2 = (C2461j) getChildAt(i3).getLayoutParams();
                if (c2461j2.m10770d() == c2461j.m10770d()) {
                    c2461j = c2461j2;
                    i4 = i3;
                    break;
                }
            }
        }
        i4 = i;
        for (i3 = 0; i3 < i4; i3++) {
            removeAndRecycleViewAt(0, c2471p.f8033a);
        }
        view = m10694a(c2461j.m10770d(), C2465i.START);
        if (view != null) {
            if (getDecoratedTop(view) < 0) {
                m10708b(view);
            }
            if (getDecoratedBottom(view) <= 0) {
                removeAndRecycleView(view, c2471p.f8033a);
            }
        }
    }

    private View m10715d() {
        View childAt = getChildAt(0);
        C2461j c2461j = (C2461j) childAt.getLayoutParams();
        int d = c2461j.m10770d();
        if (!c2461j.f8010a) {
            return childAt;
        }
        if (1 < getChildCount()) {
            View childAt2 = getChildAt(1);
            if (((C2461j) childAt2.getLayoutParams()).m10770d() == d) {
                return childAt2;
            }
        }
        return childAt;
    }

    private View m10716e() {
        if (getChildCount() == 0) {
            return null;
        }
        View childAt = getChildAt(0);
        int d = ((C2461j) childAt.getLayoutParams()).m10770d();
        View a = m10693a(d, 0, C2465i.START);
        if (a == null) {
            return childAt;
        }
        C2461j c2461j = (C2461j) a.getLayoutParams();
        return !c2461j.f8010a ? childAt : (!c2461j.m10772f() || c2461j.m10773g()) ? getDecoratedTop(childAt) < getDecoratedTop(a) ? childAt : d + 1 == getPosition(childAt) ? a : childAt : getDecoratedBottom(a) <= getDecoratedTop(childAt) ? a : childAt;
    }

    int m10717a(View view, C2465i c2465i) {
        return view == null ? c2465i == C2465i.START ? getPaddingBottom() : getPaddingTop() : c2465i == C2465i.START ? getDecoratedBottom(view) : getDecoratedTop(view);
    }

    public View m10718a() {
        C2474s c2474s = new C2474s(this, getChildAt(0));
        View a = m10697a(c2474s).m10737a(c2474s.f8040a, false);
        int position = getPosition(a);
        if (position > c2474s.f8040a + 1 || position == c2474s.f8040a) {
            return a;
        }
        View a2 = m10693a(c2474s.f8040a, 0, C2465i.START);
        if (a2 == null) {
            return a;
        }
        if (getDecoratedBottom(a2) <= getDecoratedTop(a)) {
            return a2;
        }
        C2461j c2461j = (C2461j) a2.getLayoutParams();
        return ((!c2461j.m10772f() || c2461j.m10773g()) && getDecoratedTop(a2) == getDecoratedTop(a)) ? a2 : a;
    }

    public C2461j m10719a(LayoutParams layoutParams) {
        C2461j b = C2461j.m10764b(layoutParams);
        b.width = -1;
        b.height = -1;
        return m10696a(b).m10739a(b);
    }

    void m10720a(View view) {
        int i;
        C2461j c2461j = (C2461j) view.getLayoutParams();
        int width = (getWidth() - getPaddingStart()) - getPaddingEnd();
        if (!c2461j.m10773g()) {
            if (c2461j.m10774h() && !c2461j.f8014e) {
                i = width - c2461j.f8013d;
                measureChildWithMargins(view, i, 0);
            } else if (c2461j.m10771e() && !c2461j.f8015f) {
                i = width - c2461j.f8012c;
                measureChildWithMargins(view, i, 0);
            }
        }
        i = 0;
        measureChildWithMargins(view, i, 0);
    }

    public View m10721b() {
        C2474s c2474s = new C2474s(this, getChildAt(getChildCount() - 1));
        return m10697a(c2474s).m10745c(c2474s.f8040a);
    }

    public boolean canScrollVertically() {
        return true;
    }

    public int computeVerticalScrollExtent(State state) {
        return (getChildCount() == 0 || state.getItemCount() == 0) ? 0 : !this.f7987g ? getChildCount() : (int) ((((((float) getChildCount()) - m10682a(state, true)) - m10701b(state, true)) / ((float) state.getItemCount())) * ((float) getHeight()));
    }

    public int computeVerticalScrollOffset(State state) {
        if (getChildCount() == 0 || state.getItemCount() == 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        if (!this.f7987g) {
            return getPosition(childAt);
        }
        return (int) (((m10682a(state, false) + ((float) getPosition(childAt))) / ((float) state.getItemCount())) * ((float) getHeight()));
    }

    public int computeVerticalScrollRange(State state) {
        return !this.f7987g ? state.getItemCount() : getHeight();
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new C2461j(-2, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        int i;
        int i2 = 0;
        int i3 = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1317h.superslim_LayoutManager);
        if (VERSION.SDK_INT < 21) {
            TypedValue typedValue = new TypedValue();
            obtainStyledAttributes.getValue(3, typedValue);
            if (typedValue.type == 3) {
                i2 = 1;
            }
            i = i2;
        } else {
            if (obtainStyledAttributes.getType(3) == 3) {
                i2 = 1;
            }
            i = i2;
        }
        String str = null;
        if (i != 0) {
            str = obtainStyledAttributes.getString(3);
            if (!TextUtils.isEmpty(str)) {
                i3 = -1;
            }
        } else {
            i3 = obtainStyledAttributes.getInt(3, 1);
        }
        obtainStyledAttributes.recycle();
        return m10695a(i3, str).m10738a(context, attributeSet);
    }

    public /* synthetic */ RecyclerView.LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m10719a(layoutParams);
    }

    public int getDecoratedBottom(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + super.getDecoratedBottom(view);
    }

    public int getDecoratedLeft(View view) {
        return super.getDecoratedLeft(view) - ((MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    public int getDecoratedMeasuredHeight(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.bottomMargin + (super.getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin);
    }

    public int getDecoratedMeasuredWidth(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.rightMargin + (super.getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin);
    }

    public int getDecoratedRight(View view) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.rightMargin + super.getDecoratedRight(view);
    }

    public int getDecoratedTop(View view) {
        return super.getDecoratedTop(view) - ((MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    public void layoutDecorated(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        super.layoutDecorated(view, i + marginLayoutParams.leftMargin, i2 + marginLayoutParams.topMargin, i3 - marginLayoutParams.rightMargin, i4 - marginLayoutParams.bottomMargin);
    }

    public void onAdapterChanged(Adapter adapter, Adapter adapter2) {
        removeAllViews();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        View e = m10716e();
        if (e == null) {
            this.f7983c = -1;
            this.f7985e = 0;
            return;
        }
        this.f7983c = getPosition(e);
        this.f7985e = getDecoratedTop(e);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        View childAt = getChildAt(0);
        View childAt2 = getChildAt(getChildCount() - 1);
        if (i + i2 > getPosition(childAt) && i <= getPosition(childAt2)) {
            requestLayout();
        }
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        int i = 0;
        int itemCount = state.getItemCount();
        if (itemCount == 0) {
            detachAndScrapAttachedViews(recycler);
            return;
        }
        if (this.f7983c != -1) {
            int min = Math.min(this.f7983c, itemCount - 1);
            this.f7983c = -1;
            itemCount = this.f7985e;
            this.f7985e = 0;
            i = itemCount;
            itemCount = min;
        } else {
            View e = m10716e();
            if (e != null) {
                i = Math.min(getPosition(e), itemCount - 1);
            }
            itemCount = i;
            i = m10717a(e, C2465i.END);
        }
        detachAndScrapAttachedViews(recycler);
        C2471p c2471p = new C2471p(this, recycler, state);
        m10713c(m10711c(itemCount, i, c2471p), c2471p);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        this.f7983c = ((SavedState) parcelable).f7979a;
        this.f7985e = ((SavedState) parcelable).f7980b;
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        View e = m10716e();
        if (e == null) {
            savedState.f7979a = 0;
            savedState.f7980b = 0;
        } else {
            savedState.f7979a = getPosition(e);
            savedState.f7980b = getDecoratedTop(e);
        }
        return savedState;
    }

    public void scrollToPosition(int i) {
        if (i < 0 || getItemCount() <= i) {
            Log.e("SuperSLiM.LayoutManager", "Ignored scroll to " + i + " as it is not within the item range 0 - " + getItemCount());
            return;
        }
        this.f7983c = i;
        requestLayout();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int scrollVerticallyBy(int r12, android.support.v7.widget.RecyclerView.Recycler r13, android.support.v7.widget.RecyclerView.State r14) {
        /*
        r11 = this;
        r3 = 0;
        r0 = r11.getChildCount();
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r3;
    L_0x0008:
        r5 = new mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.p;
        r5.<init>(r11, r13, r14);
        if (r12 <= 0) goto L_0x0078;
    L_0x000f:
        r0 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.END;
        r1 = r0;
    L_0x0012:
        r0 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.END;
        if (r1 != r0) goto L_0x007c;
    L_0x0016:
        r0 = 1;
        r2 = r0;
    L_0x0018:
        r6 = r11.getHeight();
        if (r2 == 0) goto L_0x007e;
    L_0x001e:
        r0 = r6 + r12;
        r4 = r0;
    L_0x0021:
        if (r2 == 0) goto L_0x0057;
    L_0x0023:
        r7 = r11.m10712c();
        r0 = r7.getLayoutParams();
        r0 = (mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2461j) r0;
        r8 = r11.m10696a(r0);
        r0 = r0.m10770d();
        r9 = r11.getChildCount();
        r9 = r9 + -1;
        r10 = r11.getDecoratedBottom(r7);
        r0 = r8.m10731a(r0, r9, r10);
        r8 = r11.getPaddingBottom();
        r8 = r6 - r8;
        if (r0 >= r8) goto L_0x0057;
    L_0x004b:
        r0 = r11.getPosition(r7);
        r7 = r14.getItemCount();
        r7 = r7 + -1;
        if (r0 == r7) goto L_0x0007;
    L_0x0057:
        r0 = r11.m10685a(r4, r1, r5);
        if (r2 == 0) goto L_0x0080;
    L_0x005d:
        r0 = r0 - r6;
        r1 = r11.getPaddingBottom();
        r0 = r0 + r1;
        if (r0 >= r12) goto L_0x0066;
    L_0x0065:
        r12 = r0;
    L_0x0066:
        r3 = r12;
    L_0x0067:
        if (r3 == 0) goto L_0x0074;
    L_0x0069:
        r0 = -r3;
        r11.offsetChildrenVertical(r0);
        if (r2 == 0) goto L_0x008a;
    L_0x006f:
        r0 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.START;
    L_0x0071:
        r11.m10699a(r0, r5);
    L_0x0074:
        r5.m10786b();
        goto L_0x0007;
    L_0x0078:
        r0 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.START;
        r1 = r0;
        goto L_0x0012;
    L_0x007c:
        r2 = r3;
        goto L_0x0018;
    L_0x007e:
        r4 = r12;
        goto L_0x0021;
    L_0x0080:
        r1 = r11.getPaddingTop();
        r0 = r0 - r1;
        if (r0 <= r12) goto L_0x0088;
    L_0x0087:
        r12 = r0;
    L_0x0088:
        r3 = r12;
        goto L_0x0067;
    L_0x008a:
        r0 = mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.C2465i.END;
        goto L_0x0071;
        */
        throw new UnsupportedOperationException("Method not decompiled: mobi.mmdt.ott.view.registeration.phoneandcountry.countryselection.components.LayoutManager.scrollVerticallyBy(int, android.support.v7.widget.RecyclerView$Recycler, android.support.v7.widget.RecyclerView$State):int");
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        if (i < 0 || getItemCount() <= i) {
            Log.e("SuperSLiM.LayoutManager", "Ignored smooth scroll to " + i + " as it is not within the item range 0 - " + getItemCount());
            return;
        }
        requestLayout();
        recyclerView.getHandler().post(new C2463g(this, recyclerView, i));
    }
}
