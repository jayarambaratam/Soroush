package android.support.v7.widget.helper;

import android.graphics.Canvas;
import android.support.v4.view.cb;
import android.support.v7.p021d.C0421c;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class ItemTouchUIUtilImpl {

    class Gingerbread implements ItemTouchUIUtil {
        Gingerbread() {
        }

        private void draw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2) {
            canvas.save();
            canvas.translate(f, f2);
            recyclerView.drawChild(canvas, view, 0);
            canvas.restore();
        }

        public void clearView(View view) {
            view.setVisibility(0);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i != 2) {
                draw(canvas, recyclerView, view, f, f2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (i == 2) {
                draw(canvas, recyclerView, view, f, f2);
            }
        }

        public void onSelected(View view) {
            view.setVisibility(4);
        }
    }

    class Honeycomb implements ItemTouchUIUtil {
        Honeycomb() {
        }

        public void clearView(View view) {
            cb.m2393a(view, 0.0f);
            cb.m2408b(view, 0.0f);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            cb.m2393a(view, f);
            cb.m2408b(view, f2);
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
        }

        public void onSelected(View view) {
        }
    }

    class Lollipop extends Honeycomb {
        Lollipop() {
        }

        private float findMaxElevation(RecyclerView recyclerView, View view) {
            int childCount = recyclerView.getChildCount();
            float f = 0.0f;
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                if (childAt != view) {
                    float u = cb.m2444u(childAt);
                    if (u > f) {
                        f = u;
                    }
                }
            }
            return f;
        }

        public void clearView(View view) {
            Object tag = view.getTag(C0421c.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                cb.m2432j(view, ((Float) tag).floatValue());
            }
            view.setTag(C0421c.item_touch_helper_previous_elevation, null);
            super.clearView(view);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, View view, float f, float f2, int i, boolean z) {
            if (z && view.getTag(C0421c.item_touch_helper_previous_elevation) == null) {
                Float valueOf = Float.valueOf(cb.m2444u(view));
                cb.m2432j(view, 1.0f + findMaxElevation(recyclerView, view));
                view.setTag(C0421c.item_touch_helper_previous_elevation, valueOf);
            }
            super.onDraw(canvas, recyclerView, view, f, f2, i, z);
        }
    }

    ItemTouchUIUtilImpl() {
    }
}
