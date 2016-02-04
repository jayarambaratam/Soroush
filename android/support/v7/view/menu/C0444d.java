package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.cb;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v7.view.menu.d */
public abstract class C0444d implements C0051x {
    private C0374y mCallback;
    protected Context mContext;
    private int mId;
    protected LayoutInflater mInflater;
    private int mItemLayoutRes;
    protected C0049i mMenu;
    private int mMenuLayoutRes;
    protected C0047z mMenuView;
    protected Context mSystemContext;
    protected LayoutInflater mSystemInflater;

    public C0444d(Context context, int i, int i2) {
        this.mSystemContext = context;
        this.mSystemInflater = LayoutInflater.from(context);
        this.mMenuLayoutRes = i;
        this.mItemLayoutRes = i2;
    }

    protected void addItemView(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.mMenuView).addView(view, i);
    }

    public abstract void bindItemView(C0448m c0448m, aa aaVar);

    public boolean collapseItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    public aa createItemView(ViewGroup viewGroup) {
        return (aa) this.mSystemInflater.inflate(this.mItemLayoutRes, viewGroup, false);
    }

    public boolean expandItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    protected boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public boolean flagActionItems() {
        return false;
    }

    public C0374y getCallback() {
        return this.mCallback;
    }

    public int getId() {
        return this.mId;
    }

    public View getItemView(C0448m c0448m, View view, ViewGroup viewGroup) {
        aa createItemView = view instanceof aa ? (aa) view : createItemView(viewGroup);
        bindItemView(c0448m, createItemView);
        return (View) createItemView;
    }

    public C0047z getMenuView(ViewGroup viewGroup) {
        if (this.mMenuView == null) {
            this.mMenuView = (C0047z) this.mSystemInflater.inflate(this.mMenuLayoutRes, viewGroup, false);
            this.mMenuView.initialize(this.mMenu);
            updateMenuView(true);
        }
        return this.mMenuView;
    }

    public void initForMenu(Context context, C0049i c0049i) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(this.mContext);
        this.mMenu = c0049i;
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (this.mCallback != null) {
            this.mCallback.onCloseMenu(c0049i, z);
        }
    }

    public boolean onSubMenuSelected(ad adVar) {
        return this.mCallback != null ? this.mCallback.onOpenSubMenu(adVar) : false;
    }

    public void setCallback(C0374y c0374y) {
        this.mCallback = c0374y;
    }

    public void setId(int i) {
        this.mId = i;
    }

    public boolean shouldIncludeItem(int i, C0448m c0448m) {
        return true;
    }

    public void updateMenuView(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup != null) {
            int i;
            if (this.mMenu != null) {
                this.mMenu.m130j();
                ArrayList i2 = this.mMenu.m129i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0448m c0448m = (C0448m) i2.get(i3);
                    if (shouldIncludeItem(i, c0448m)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0448m itemData = childAt instanceof aa ? ((aa) childAt).getItemData() : null;
                        View itemView = getItemView(c0448m, childAt, viewGroup);
                        if (c0448m != itemData) {
                            itemView.setPressed(false);
                            cb.m2448y(itemView);
                        }
                        if (itemView != childAt) {
                            addItemView(itemView, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!filterLeftoverView(viewGroup, i)) {
                    i++;
                }
            }
        }
    }
}
