package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.C0077a;
import android.support.v4.view.p017a.C0284g;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class RecyclerViewAccessibilityDelegate extends C0077a {
    final C0077a mItemDelegate;
    final RecyclerView mRecyclerView;

    /* renamed from: android.support.v7.widget.RecyclerViewAccessibilityDelegate.1 */
    class C05031 extends C0077a {
        C05031() {
        }

        public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
            super.onInitializeAccessibilityNodeInfo(view, c0284g);
            if (!RecyclerViewAccessibilityDelegate.this.shouldIgnore() && RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager() != null) {
                RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, c0284g);
            }
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return super.performAccessibilityAction(view, i, bundle) ? true : (RecyclerViewAccessibilityDelegate.this.shouldIgnore() || RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager() == null) ? false : RecyclerViewAccessibilityDelegate.this.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
        }
    }

    public RecyclerViewAccessibilityDelegate(RecyclerView recyclerView) {
        this.mItemDelegate = new C05031();
        this.mRecyclerView = recyclerView;
    }

    private boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }

    C0077a getItemDelegate() {
        return this.mItemDelegate;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !shouldIgnore()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(View view, C0284g c0284g) {
        super.onInitializeAccessibilityNodeInfo(view, c0284g);
        c0284g.m1955b(RecyclerView.class.getName());
        if (!shouldIgnore() && this.mRecyclerView.getLayoutManager() != null) {
            this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(c0284g);
        }
    }

    public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
        return super.performAccessibilityAction(view, i, bundle) ? true : (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) ? false : this.mRecyclerView.getLayoutManager().performAccessibilityAction(i, bundle);
    }
}
