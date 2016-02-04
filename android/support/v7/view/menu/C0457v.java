package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0362e;
import android.support.v7.p019a.C0366i;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.view.menu.v */
public class C0457v implements C0051x, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int ITEM_LAYOUT;
    private static final String TAG = "MenuPopupHelper";
    private final C0458w mAdapter;
    private View mAnchorView;
    private int mContentWidth;
    private final Context mContext;
    private int mDropDownGravity;
    boolean mForceShowIcon;
    private boolean mHasContentWidth;
    private final LayoutInflater mInflater;
    private ViewGroup mMeasureParent;
    private final C0049i mMenu;
    private final boolean mOverflowOnly;
    private ListPopupWindow mPopup;
    private final int mPopupMaxWidth;
    private final int mPopupStyleAttr;
    private final int mPopupStyleRes;
    private C0374y mPresenterCallback;
    private ViewTreeObserver mTreeObserver;

    static {
        ITEM_LAYOUT = C0366i.abc_popup_menu_item_layout;
    }

    public C0457v(Context context, C0049i c0049i) {
        this(context, c0049i, null, false, C0359b.popupMenuStyle);
    }

    public C0457v(Context context, C0049i c0049i, View view) {
        this(context, c0049i, view, false, C0359b.popupMenuStyle);
    }

    public C0457v(Context context, C0049i c0049i, View view, boolean z, int i) {
        this(context, c0049i, view, z, i, ITEM_LAYOUT);
    }

    public C0457v(Context context, C0049i c0049i, View view, boolean z, int i, int i2) {
        this.mDropDownGravity = ITEM_LAYOUT;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mMenu = c0049i;
        this.mAdapter = new C0458w(this, this.mMenu);
        this.mOverflowOnly = z;
        this.mPopupStyleAttr = i;
        this.mPopupStyleRes = i2;
        Resources resources = context.getResources();
        this.mPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0362e.abc_config_prefDialogWidth));
        this.mAnchorView = view;
        c0049i.m104a((C0051x) this, context);
    }

    private int measureContentWidth() {
        ListAdapter listAdapter = this.mAdapter;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(ITEM_LAYOUT, ITEM_LAYOUT);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(ITEM_LAYOUT, ITEM_LAYOUT);
        int count = listAdapter.getCount();
        int i = ITEM_LAYOUT;
        int i2 = ITEM_LAYOUT;
        View view = null;
        int i3 = ITEM_LAYOUT;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.mMeasureParent == null) {
                this.mMeasureParent = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.mMeasureParent);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.mPopupMaxWidth) {
                return this.mPopupMaxWidth;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public boolean collapseItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    public void dismiss() {
        if (isShowing()) {
            this.mPopup.dismiss();
        }
    }

    public boolean expandItemActionView(C0049i c0049i, C0448m c0448m) {
        return false;
    }

    public boolean flagActionItems() {
        return false;
    }

    public int getGravity() {
        return this.mDropDownGravity;
    }

    public int getId() {
        return ITEM_LAYOUT;
    }

    public C0047z getMenuView(ViewGroup viewGroup) {
        throw new UnsupportedOperationException("MenuPopupHelpers manage their own views");
    }

    public ListPopupWindow getPopup() {
        return this.mPopup;
    }

    public void initForMenu(Context context, C0049i c0049i) {
    }

    public boolean isShowing() {
        return this.mPopup != null && this.mPopup.isShowing();
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (c0049i == this.mMenu) {
            dismiss();
            if (this.mPresenterCallback != null) {
                this.mPresenterCallback.onCloseMenu(c0049i, z);
            }
        }
    }

    public void onDismiss() {
        this.mPopup = null;
        this.mMenu.close();
        if (this.mTreeObserver != null) {
            if (!this.mTreeObserver.isAlive()) {
                this.mTreeObserver = this.mAnchorView.getViewTreeObserver();
            }
            this.mTreeObserver.removeGlobalOnLayoutListener(this);
            this.mTreeObserver = null;
        }
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.mAnchorView;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.mPopup.show();
            }
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0458w c0458w = this.mAdapter;
        c0458w.f2213b.m109a(c0458w.m4092a(i), (int) ITEM_LAYOUT);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public boolean onSubMenuSelected(ad adVar) {
        if (adVar.hasVisibleItems()) {
            boolean z;
            C0457v c0457v = new C0457v(this.mContext, adVar, this.mAnchorView);
            c0457v.setCallback(this.mPresenterCallback);
            int size = adVar.size();
            for (int i = ITEM_LAYOUT; i < size; i++) {
                MenuItem item = adVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0457v.setForceShowIcon(z);
            if (c0457v.tryShow()) {
                if (this.mPresenterCallback == null) {
                    return true;
                }
                this.mPresenterCallback.onOpenSubMenu(adVar);
                return true;
            }
        }
        return false;
    }

    public void setAnchorView(View view) {
        this.mAnchorView = view;
    }

    public void setCallback(C0374y c0374y) {
        this.mPresenterCallback = c0374y;
    }

    public void setForceShowIcon(boolean z) {
        this.mForceShowIcon = z;
    }

    public void setGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void show() {
        if (!tryShow()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean tryShow() {
        boolean z = false;
        this.mPopup = new ListPopupWindow(this.mContext, null, this.mPopupStyleAttr, this.mPopupStyleRes);
        this.mPopup.setOnDismissListener(this);
        this.mPopup.setOnItemClickListener(this);
        this.mPopup.setAdapter(this.mAdapter);
        this.mPopup.setModal(true);
        View view = this.mAnchorView;
        if (view == null) {
            return false;
        }
        if (this.mTreeObserver == null) {
            z = true;
        }
        this.mTreeObserver = view.getViewTreeObserver();
        if (z) {
            this.mTreeObserver.addOnGlobalLayoutListener(this);
        }
        this.mPopup.setAnchorView(view);
        this.mPopup.setDropDownGravity(this.mDropDownGravity);
        if (!this.mHasContentWidth) {
            this.mContentWidth = measureContentWidth();
            this.mHasContentWidth = true;
        }
        this.mPopup.setContentWidth(this.mContentWidth);
        this.mPopup.setInputMethodMode(2);
        this.mPopup.show();
        this.mPopup.getListView().setOnKeyListener(this);
        return true;
    }

    public void updateMenuView(boolean z) {
        this.mHasContentWidth = false;
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
