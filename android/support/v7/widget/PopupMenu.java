package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p019a.C0359b;
import android.support.v7.view.C0433i;
import android.support.v7.view.menu.C0049i;
import android.support.v7.view.menu.C0074j;
import android.support.v7.view.menu.C0374y;
import android.support.v7.view.menu.C0457v;
import android.support.v7.view.menu.ad;
import android.support.v7.widget.ListPopupWindow.ForwardingListener;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;

public class PopupMenu implements C0074j, C0374y {
    private View mAnchor;
    private Context mContext;
    private OnDismissListener mDismissListener;
    private OnTouchListener mDragListener;
    private C0049i mMenu;
    private OnMenuItemClickListener mMenuItemClickListener;
    private C0457v mPopup;

    /* renamed from: android.support.v7.widget.PopupMenu.1 */
    class C04951 extends ForwardingListener {
        C04951(View view) {
            super(view);
        }

        public ListPopupWindow getPopup() {
            return PopupMenu.this.mPopup.getPopup();
        }

        protected boolean onForwardingStarted() {
            PopupMenu.this.show();
            return true;
        }

        protected boolean onForwardingStopped() {
            PopupMenu.this.dismiss();
            return true;
        }
    }

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, C0359b.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.mContext = context;
        this.mMenu = new C0049i(context);
        this.mMenu.m101a((C0074j) this);
        this.mAnchor = view;
        this.mPopup = new C0457v(context, this.mMenu, view, false, i2, i3);
        this.mPopup.setGravity(i);
        this.mPopup.setCallback(this);
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new C04951(this.mAnchor);
        }
        return this.mDragListener;
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new C0433i(this.mContext);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void onCloseMenu(C0049i c0049i, boolean z) {
        if (this.mDismissListener != null) {
            this.mDismissListener.onDismiss(this);
        }
    }

    public void onCloseSubMenu(ad adVar) {
    }

    public boolean onMenuItemSelected(C0049i c0049i, MenuItem menuItem) {
        return this.mMenuItemClickListener != null ? this.mMenuItemClickListener.onMenuItemClick(menuItem) : false;
    }

    public void onMenuModeChange(C0049i c0049i) {
    }

    public boolean onOpenSubMenu(C0049i c0049i) {
        if (c0049i == null) {
            return false;
        }
        if (!c0049i.hasVisibleItems()) {
            return true;
        }
        new C0457v(this.mContext, c0049i, this.mAnchor).show();
        return true;
    }

    public void setGravity(int i) {
        this.mPopup.setGravity(i);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void show() {
        this.mPopup.show();
    }
}
