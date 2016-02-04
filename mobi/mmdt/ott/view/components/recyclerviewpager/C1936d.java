package mobi.mmdt.ott.view.components.recyclerviewpager;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.components.recyclerviewpager.d */
public class C1936d {
    public static View m9208a(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (C1936d.m9209a(recyclerView, childAt)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public static boolean m9209a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int width = iArr[0] + (recyclerView.getWidth() / 2);
        if (childCount <= 0) {
            return false;
        }
        view.getLocationOnScreen(iArr2);
        return iArr2[0] <= width && iArr2[0] + view.getWidth() >= width;
    }

    public static int m9210b(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return childCount;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (C1936d.m9209a(recyclerView, childAt)) {
                return recyclerView.getChildAdapterPosition(childAt);
            }
        }
        return childCount;
    }

    public static boolean m9211b(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        recyclerView.getLocationOnScreen(iArr);
        int height = iArr[1] + (recyclerView.getHeight() / 2);
        if (childCount > 0) {
            view.getLocationOnScreen(iArr2);
            if (iArr2[1] <= height && iArr2[1] + view.getHeight() >= height) {
                return true;
            }
        }
        return false;
    }

    public static View m9212c(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (C1936d.m9211b(recyclerView, childAt)) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public static int m9213d(RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        if (childCount <= 0) {
            return childCount;
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (C1936d.m9211b(recyclerView, childAt)) {
                return recyclerView.getChildAdapterPosition(childAt);
            }
        }
        return childCount;
    }
}
