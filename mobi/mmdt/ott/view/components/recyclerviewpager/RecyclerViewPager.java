package mobi.mmdt.ott.view.components.recyclerviewpager;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.Field;
import java.util.List;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.C1317h;

public class RecyclerViewPager extends RecyclerView {
    boolean f6202a;
    int f6203b;
    int f6204c;
    View f6205d;
    int f6206e;
    int f6207f;
    int f6208g;
    int f6209h;
    private C1935c<?> f6210i;
    private float f6211j;
    private float f6212k;
    private float f6213l;
    private List<C1934b> f6214m;
    private int f6215n;
    private int f6216o;
    private boolean f6217p;

    public RecyclerViewPager(Context context) {
        this(context, null);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6211j = 0.1f;
        this.f6212k = 0.001f;
        this.f6215n = -1;
        this.f6216o = -1;
        this.f6206e = RtlSpacingHelper.UNDEFINED;
        this.f6207f = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f6208g = RtlSpacingHelper.UNDEFINED;
        this.f6209h = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        m9202a(context, attributeSet, i);
    }

    private int m9200a(int i, int i2) {
        return i < 0 ? 0 : i >= i2 ? i2 - 1 : i;
    }

    private void m9202a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1317h.RecyclerViewPager, i, 0);
        this.f6212k = obtainStyledAttributes.getFloat(1, 0.001f);
        this.f6211j = obtainStyledAttributes.getFloat(0, 0.1f);
        this.f6217p = obtainStyledAttributes.getBoolean(2, this.f6217p);
        obtainStyledAttributes.recycle();
    }

    protected void m9205a(int i) {
        if (getChildCount() > 0) {
            int b = C1936d.m9210b(this);
            int width = (int) ((((float) i) * this.f6212k) / ((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())));
            if (this.f6217p) {
                width = Math.max(-1, Math.min(1, width));
            }
            width = Math.min(Math.max(width + b, 0), getAdapter().getItemCount() - 1);
            if (width == b) {
                View a = C1936d.m9208a(this);
                if (a != null) {
                    if (this.f6213l > (((float) a.getWidth()) * this.f6211j) * this.f6211j && width != 0) {
                        width--;
                    } else if (this.f6213l < ((float) a.getWidth()) * (-this.f6211j) && width != getAdapter().getItemCount() - 1) {
                        width++;
                    }
                }
            }
            smoothScrollToPosition(m9200a(width, getAdapter().getItemCount()));
        }
    }

    protected void m9206b(int i) {
        if (getChildCount() > 0) {
            int d = C1936d.m9213d(this);
            int min = Math.min(Math.max(((int) ((((float) i) * this.f6212k) / ((float) ((getHeight() - getPaddingTop()) - getPaddingBottom())))) + d, 0), getAdapter().getItemCount() - 1);
            if (min == d) {
                View c = C1936d.m9212c(this);
                if (c != null) {
                    if (this.f6213l > ((float) c.getHeight()) * this.f6211j && min != 0) {
                        min--;
                    } else if (this.f6213l < ((float) c.getHeight()) * (-this.f6211j) && min != getAdapter().getItemCount() - 1) {
                        min++;
                    }
                }
            }
            smoothScrollToPosition(m9200a(min, getAdapter().getItemCount()));
        }
    }

    public boolean fling(int i, int i2) {
        boolean fling = super.fling((int) (((float) i) * this.f6212k), (int) (((float) i2) * this.f6212k));
        if (fling) {
            if (getLayoutManager().canScrollHorizontally()) {
                m9205a(i);
            } else {
                m9206b(i2);
            }
        }
        return fling;
    }

    public Adapter getAdapter() {
        return this.f6210i != null ? this.f6210i.f6219a : null;
    }

    public int getCurrentPosition() {
        return getLayoutManager().canScrollHorizontally() ? C1936d.m9210b(this) : C1936d.m9213d(this);
    }

    public float getFlingFactor() {
        return this.f6212k;
    }

    public float getTriggerOffset() {
        return this.f6211j;
    }

    public C1935c getWrapperAdapter() {
        return this.f6210i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        try {
            Field declaredField = parcelable.getClass().getDeclaredField("mLayoutState");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(parcelable);
            Field declaredField2 = obj.getClass().getDeclaredField("mAnchorOffset");
            Field declaredField3 = obj.getClass().getDeclaredField("mAnchorPosition");
            declaredField3.setAccessible(true);
            declaredField2.setAccessible(true);
            if (declaredField2.getInt(obj) > 0) {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) - 1));
            } else {
                declaredField3.set(obj, Integer.valueOf(declaredField3.getInt(obj) + 1));
            }
            declaredField2.setInt(obj, 0);
        } catch (Throwable th) {
            C1104b.m6368b((Object) this, th);
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 1) {
            this.f6202a = true;
            this.f6205d = getLayoutManager().canScrollHorizontally() ? C1936d.m9208a(this) : C1936d.m9212c(this);
            if (this.f6205d != null) {
                this.f6216o = getChildLayoutPosition(this.f6205d);
                this.f6203b = this.f6205d.getLeft();
                this.f6204c = this.f6205d.getTop();
            } else {
                this.f6216o = -1;
            }
            this.f6213l = 0.0f;
        } else if (i == 2) {
            this.f6202a = false;
            if (this.f6205d == null) {
                this.f6213l = 0.0f;
            } else if (getLayoutManager().canScrollHorizontally()) {
                this.f6213l = (float) (this.f6205d.getLeft() - this.f6203b);
            } else {
                this.f6213l = (float) (this.f6205d.getTop() - this.f6204c);
            }
            this.f6205d = null;
        } else if (i == 0) {
            if (this.f6202a) {
                int b = getLayoutManager().canScrollHorizontally() ? C1936d.m9210b(this) : C1936d.m9213d(this);
                if (this.f6205d != null) {
                    b = getChildAdapterPosition(this.f6205d);
                    int left;
                    if (getLayoutManager().canScrollHorizontally()) {
                        left = this.f6205d.getLeft() - this.f6203b;
                        if (((float) left) > ((float) this.f6205d.getWidth()) * this.f6211j && this.f6205d.getLeft() >= this.f6206e) {
                            b--;
                        } else if (((float) left) < ((float) this.f6205d.getWidth()) * (-this.f6211j) && this.f6205d.getLeft() <= this.f6207f) {
                            b++;
                        }
                    } else {
                        left = this.f6205d.getTop() - this.f6204c;
                        if (((float) left) > ((float) this.f6205d.getHeight()) * this.f6211j && this.f6205d.getTop() >= this.f6208g) {
                            b--;
                        } else if (((float) left) < ((float) this.f6205d.getHeight()) * (-this.f6211j) && this.f6205d.getTop() <= this.f6209h) {
                            b++;
                        }
                    }
                }
                smoothScrollToPosition(m9200a(b, getAdapter().getItemCount()));
                this.f6205d = null;
            } else if (this.f6215n != this.f6216o) {
                if (this.f6214m != null) {
                    for (C1934b c1934b : this.f6214m) {
                        if (c1934b != null) {
                            c1934b.m9207a(this.f6216o, this.f6215n);
                        }
                    }
                }
                this.f6216o = this.f6215n;
            }
            this.f6206e = RtlSpacingHelper.UNDEFINED;
            this.f6207f = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f6208g = RtlSpacingHelper.UNDEFINED;
            this.f6209h = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.f6205d != null) {
            this.f6206e = Math.max(this.f6205d.getLeft(), this.f6206e);
            this.f6208g = Math.max(this.f6205d.getTop(), this.f6208g);
            this.f6207f = Math.min(this.f6205d.getLeft(), this.f6207f);
            this.f6209h = Math.min(this.f6205d.getTop(), this.f6209h);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void scrollToPosition(int i) {
        this.f6216o = getCurrentPosition();
        this.f6215n = i;
        super.scrollToPosition(i);
        getViewTreeObserver().addOnGlobalLayoutListener(new C1933a(this));
    }

    public void setAdapter(Adapter adapter) {
        this.f6210i = adapter instanceof C1935c ? (C1935c) adapter : new C1935c(this, adapter);
        super.setAdapter(this.f6210i);
    }

    public void setFlingFactor(float f) {
        this.f6212k = f;
    }

    public void setSinglePageFling(boolean z) {
        this.f6217p = z;
    }

    public void setTriggerOffset(float f) {
        this.f6211j = f;
    }

    public void smoothScrollToPosition(int i) {
        this.f6215n = i;
        super.smoothScrollToPosition(i);
    }

    public void swapAdapter(Adapter adapter, boolean z) {
        this.f6210i = adapter instanceof C1935c ? (C1935c) adapter : new C1935c(this, adapter);
        super.swapAdapter(this.f6210i, z);
    }
}
