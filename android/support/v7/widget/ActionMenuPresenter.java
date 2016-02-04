package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p013c.p014a.C0177a;
import android.support.v4.view.C0319n;
import android.support.v4.view.C0320o;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0365h;
import android.support.v7.p019a.C0366i;
import android.support.v7.p023f.C0424a;
import android.support.v7.view.C0427a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0047z;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0374y;
import android.support.v7.view.menu.C0443c;
import android.support.v7.view.menu.C0444d;
import android.support.v7.view.menu.C0448m;
import android.support.v7.view.menu.C0457v;
import android.support.v7.view.menu.aa;
import android.support.v7.view.menu.ad;
import android.support.v7.widget.ActionMenuView.ActionMenuChildView;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class ActionMenuPresenter extends C0444d implements C0320o {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups;
    private ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    private OverflowMenuButton mOverflowButton;
    private OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback;
    private OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private View mScrapActionButtonView;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    class ActionButtonSubmenu extends C0457v {
        private ad mSubMenu;
        final /* synthetic */ ActionMenuPresenter this$0;

        public ActionButtonSubmenu(ActionMenuPresenter actionMenuPresenter, Context context, ad adVar) {
            boolean z = false;
            this.this$0 = actionMenuPresenter;
            super(context, adVar, null, false, C0359b.actionOverflowMenuStyle);
            this.mSubMenu = adVar;
            if (!((C0448m) adVar.getItem()).m4079j()) {
                setAnchorView(actionMenuPresenter.mOverflowButton == null ? (View) actionMenuPresenter.mMenuView : actionMenuPresenter.mOverflowButton);
            }
            setCallback(actionMenuPresenter.mPopupPresenterCallback);
            int size = adVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = adVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            setForceShowIcon(z);
        }

        public void onDismiss() {
            super.onDismiss();
            this.this$0.mActionButtonPopup = null;
            this.this$0.mOpenSubMenuId = 0;
        }
    }

    class ActionMenuPopupCallback extends C0443c {
        private ActionMenuPopupCallback() {
        }

        public ListPopupWindow getPopup() {
            return ActionMenuPresenter.this.mActionButtonPopup != null ? ActionMenuPresenter.this.mActionButtonPopup.getPopup() : null;
        }
    }

    class OpenOverflowRunnable implements Runnable {
        private OverflowPopup mPopup;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.mPopup = overflowPopup;
        }

        public void run() {
            ActionMenuPresenter.this.mMenu.m126f();
            View view = (View) ActionMenuPresenter.this.mMenuView;
            if (!(view == null || view.getWindowToken() == null || !this.mPopup.tryShow())) {
                ActionMenuPresenter.this.mOverflowPopup = this.mPopup;
            }
            ActionMenuPresenter.this.mPostedOpenRunnable = null;
        }
    }

    class OverflowMenuButton extends AppCompatImageView implements ActionMenuChildView {
        private final float[] mTempPts;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter.OverflowMenuButton.1 */
        class C04651 extends ForwardingListener {
            final /* synthetic */ ActionMenuPresenter val$this$0;

            C04651(View view, ActionMenuPresenter actionMenuPresenter) {
                this.val$this$0 = actionMenuPresenter;
                super(view);
            }

            public ListPopupWindow getPopup() {
                return ActionMenuPresenter.this.mOverflowPopup == null ? null : ActionMenuPresenter.this.mOverflowPopup.getPopup();
            }

            public boolean onForwardingStarted() {
                ActionMenuPresenter.this.showOverflowMenu();
                return true;
            }

            public boolean onForwardingStopped() {
                if (ActionMenuPresenter.this.mPostedOpenRunnable != null) {
                    return false;
                }
                ActionMenuPresenter.this.hideOverflowMenu();
                return true;
            }
        }

        public OverflowMenuButton(Context context) {
            super(context, null, C0359b.actionOverflowButtonStyle);
            this.mTempPts = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C04651(this, ActionMenuPresenter.this));
        }

        public boolean needsDividerAfter() {
            return false;
        }

        public boolean needsDividerBefore() {
            return false;
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                ActionMenuPresenter.this.showOverflowMenu();
            }
            return true;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0177a.m1543a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    class OverflowPopup extends C0457v {
        public OverflowPopup(Context context, C0049i c0049i, View view, boolean z) {
            super(context, c0049i, view, z, C0359b.actionOverflowMenuStyle);
            setGravity(8388613);
            setCallback(ActionMenuPresenter.this.mPopupPresenterCallback);
        }

        public void onDismiss() {
            super.onDismiss();
            if (ActionMenuPresenter.this.mMenu != null) {
                ActionMenuPresenter.this.mMenu.close();
            }
            ActionMenuPresenter.this.mOverflowPopup = null;
        }
    }

    class PopupPresenterCallback implements C0374y {
        private PopupPresenterCallback() {
        }

        public void onCloseMenu(C0049i c0049i, boolean z) {
            if (c0049i instanceof ad) {
                ((ad) c0049i).m184p().m115b(false);
            }
            C0374y callback = ActionMenuPresenter.this.getCallback();
            if (callback != null) {
                callback.onCloseMenu(c0049i, z);
            }
        }

        public boolean onOpenSubMenu(C0049i c0049i) {
            if (c0049i == null) {
                return false;
            }
            ActionMenuPresenter.this.mOpenSubMenuId = ((ad) c0049i).getItem().getItemId();
            C0374y callback = ActionMenuPresenter.this.getCallback();
            return callback != null ? callback.onOpenSubMenu(c0049i) : false;
        }
    }

    class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        public int openSubMenuId;

        /* renamed from: android.support.v7.widget.ActionMenuPresenter.SavedState.1 */
        final class C04661 implements Creator<SavedState> {
            C04661() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C04661();
        }

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.openSubMenuId = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.openSubMenuId);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, C0366i.abc_action_menu_layout, C0366i.abc_action_menu_item_layout);
        this.mActionButtonGroups = new SparseBooleanArray();
        this.mPopupPresenterCallback = new PopupPresenterCallback();
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof aa) && ((aa) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public void bindItemView(C0448m c0448m, aa aaVar) {
        aaVar.m75a(c0448m, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aaVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.mMenuView);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return hideOverflowMenu() | hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int i) {
        return viewGroup.getChildAt(i) == this.mOverflowButton ? false : super.filterLeftoverView(viewGroup, i);
    }

    public boolean flagActionItems() {
        int i;
        ArrayList i2 = this.mMenu.m129i();
        int size = i2.size();
        int i3 = this.mMaxItems;
        int i4 = this.mActionItemWidthLimit;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.mMenuView;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0448m c0448m = (C0448m) i2.get(i7);
            if (c0448m.m4081l()) {
                i5++;
            } else if (c0448m.m4080k()) {
                i6++;
            } else {
                obj = 1;
            }
            i = (this.mExpandedActionViewsExclusive && c0448m.isActionViewExpanded()) ? 0 : i3;
            i7++;
            i3 = i;
        }
        if (this.mReserveOverflow && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.mActionButtonGroups;
        sparseBooleanArray.clear();
        i = 0;
        if (this.mStrictWidthLimit) {
            i = i4 / this.mMinCellSize;
            i6 = ((i4 % this.mMinCellSize) / i) + this.mMinCellSize;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0448m = (C0448m) i2.get(i8);
            int i10;
            if (c0448m.m4081l()) {
                View itemView = getItemView(c0448m, this.mScrapActionButtonView, viewGroup);
                if (this.mScrapActionButtonView == null) {
                    this.mScrapActionButtonView = itemView;
                }
                if (this.mStrictWidthLimit) {
                    i9 -= ActionMenuView.measureChildForCells(itemView, i6, i9, makeMeasureSpec, 0);
                } else {
                    itemView.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = itemView.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0448m.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0448m.m4072d(true);
                i = i10;
                i3 = i7;
            } else if (c0448m.m4080k()) {
                boolean z;
                int groupId = c0448m.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.mStrictWidthLimit || i9 > 0);
                if (z3) {
                    View itemView2 = getItemView(c0448m, this.mScrapActionButtonView, viewGroup);
                    if (this.mScrapActionButtonView == null) {
                        this.mScrapActionButtonView = itemView2;
                    }
                    boolean z4;
                    if (this.mStrictWidthLimit) {
                        int measureChildForCells = ActionMenuView.measureChildForCells(itemView2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - measureChildForCells;
                        if (measureChildForCells == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        itemView2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = itemView2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.mStrictWidthLimit) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0448m c0448m2 = (C0448m) i2.get(i7);
                        if (c0448m2.getGroupId() == groupId) {
                            if (c0448m2.m4079j()) {
                                i5++;
                            }
                            c0448m2.m4072d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0448m.m4072d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0448m.m4072d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public View getItemView(C0448m c0448m, View view, ViewGroup viewGroup) {
        View actionView = c0448m.getActionView();
        if (actionView == null || c0448m.m4083n()) {
            actionView = super.getItemView(c0448m, view, viewGroup);
        }
        actionView.setVisibility(c0448m.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    public C0047z getMenuView(ViewGroup viewGroup) {
        C0047z menuView = super.getMenuView(viewGroup);
        ((ActionMenuView) menuView).setPresenter(this);
        return menuView;
    }

    public Drawable getOverflowIcon() {
        return this.mOverflowButton != null ? this.mOverflowButton.getDrawable() : this.mPendingOverflowIconSet ? this.mPendingOverflowIcon : null;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable == null || this.mMenuView == null) {
            C0457v c0457v = this.mOverflowPopup;
            if (c0457v == null) {
                return false;
            }
            c0457v.dismiss();
            return true;
        }
        ((View) this.mMenuView).removeCallbacks(this.mPostedOpenRunnable);
        this.mPostedOpenRunnable = null;
        return true;
    }

    public boolean hideSubMenus() {
        if (this.mActionButtonPopup == null) {
            return false;
        }
        this.mActionButtonPopup.dismiss();
        return true;
    }

    public void initForMenu(Context context, C0049i c0049i) {
        super.initForMenu(context, c0049i);
        Resources resources = context.getResources();
        C0427a a = C0427a.m3956a(context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = a.m3958b();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = a.m3959c();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = a.m3957a();
        }
        int i = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
                if (this.mPendingOverflowIconSet) {
                    this.mOverflowButton.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.mOverflowButton.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = i;
        this.mMinCellSize = (int) (56.0f * resources.getDisplayMetrics().density);
        this.mScrapActionButtonView = null;
    }

    public boolean isOverflowMenuShowPending() {
        return this.mPostedOpenRunnable != null || isOverflowMenuShowing();
    }

    public boolean isOverflowMenuShowing() {
        return this.mOverflowPopup != null && this.mOverflowPopup.isShowing();
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        dismissPopupMenus();
        super.onCloseMenu(c0049i, z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = this.mContext.getResources().getInteger(C0365h.abc_max_action_buttons);
        }
        if (this.mMenu != null) {
            this.mMenu.m107a(true);
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.openSubMenuId > 0) {
            MenuItem findItem = this.mMenu.findItem(savedState.openSubMenuId);
            if (findItem != null) {
                onSubMenuSelected((ad) findItem.getSubMenu());
            }
        }
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    public boolean onSubMenuSelected(ad adVar) {
        if (!adVar.hasVisibleItems()) {
            return false;
        }
        ad adVar2 = adVar;
        while (adVar2.m185s() != this.mMenu) {
            adVar2 = (ad) adVar2.m185s();
        }
        View findViewForItem = findViewForItem(adVar2.getItem());
        if (findViewForItem == null) {
            if (this.mOverflowButton == null) {
                return false;
            }
            findViewForItem = this.mOverflowButton;
        }
        this.mOpenSubMenuId = adVar.getItem().getItemId();
        this.mActionButtonPopup = new ActionButtonSubmenu(this, this.mContext, adVar);
        this.mActionButtonPopup.setAnchorView(findViewForItem);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(adVar);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean z) {
        if (z) {
            super.onSubMenuSelected(null);
        } else {
            this.mMenu.m115b(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.mExpandedActionViewsExclusive = z;
    }

    public void setItemLimit(int i) {
        this.mMaxItems = i;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable drawable) {
        if (this.mOverflowButton != null) {
            this.mOverflowButton.setImageDrawable(drawable);
            return;
        }
        this.mPendingOverflowIconSet = true;
        this.mPendingOverflowIcon = drawable;
    }

    public void setReserveOverflow(boolean z) {
        this.mReserveOverflow = z;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int i, boolean z) {
        this.mWidthLimit = i;
        this.mStrictWidthLimit = z;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int i, C0448m c0448m) {
        return c0448m.m4079j();
    }

    public boolean showOverflowMenu() {
        if (!this.mReserveOverflow || isOverflowMenuShowing() || this.mMenu == null || this.mMenuView == null || this.mPostedOpenRunnable != null || this.mMenu.m132l().isEmpty()) {
            return false;
        }
        this.mPostedOpenRunnable = new OpenOverflowRunnable(new OverflowPopup(this.mContext, this.mMenu, this.mOverflowButton, true));
        ((View) this.mMenuView).post(this.mPostedOpenRunnable);
        super.onSubMenuSelected(null);
        return true;
    }

    public void updateMenuView(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.mMenuView).getParent();
        if (viewGroup != null) {
            C0424a.m3955a(viewGroup);
        }
        super.updateMenuView(z);
        ((View) this.mMenuView).requestLayout();
        if (this.mMenu != null) {
            ArrayList k = this.mMenu.m131k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0319n a = ((C0448m) k.get(i)).m4061a();
                if (a != null) {
                    a.setSubUiVisibilityListener(this);
                }
            }
        }
        ArrayList l = this.mMenu != null ? this.mMenu.m132l() : null;
        if (this.mReserveOverflow && l != null) {
            i = l.size();
            if (i == 1) {
                i3 = !((C0448m) l.get(0)).isActionViewExpanded() ? 1 : 0;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this.mSystemContext);
            }
            viewGroup = (ViewGroup) this.mOverflowButton.getParent();
            if (viewGroup != this.mMenuView) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.mOverflowButton);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.mMenuView;
                actionMenuView.addView(this.mOverflowButton, actionMenuView.generateOverflowButtonLayoutParams());
            }
        } else if (this.mOverflowButton != null && this.mOverflowButton.getParent() == this.mMenuView) {
            ((ViewGroup) this.mMenuView).removeView(this.mOverflowButton);
        }
        ((ActionMenuView) this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
