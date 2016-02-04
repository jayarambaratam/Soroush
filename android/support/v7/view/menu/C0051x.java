package android.support.v7.view.menu;

import android.content.Context;
import android.os.Parcelable;

/* renamed from: android.support.v7.view.menu.x */
public interface C0051x {
    boolean collapseItemActionView(C0049i c0049i, C0448m c0448m);

    boolean expandItemActionView(C0049i c0049i, C0448m c0448m);

    boolean flagActionItems();

    int getId();

    void initForMenu(Context context, C0049i c0049i);

    void onCloseMenu(C0049i c0049i, boolean z);

    void onRestoreInstanceState(Parcelable parcelable);

    Parcelable onSaveInstanceState();

    boolean onSubMenuSelected(ad adVar);

    void updateMenuView(boolean z);
}
