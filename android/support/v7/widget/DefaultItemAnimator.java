package android.support.v7.widget;

import android.support.v4.p011a.C0113a;
import android.support.v4.view.cb;
import android.support.v4.view.el;
import android.support.v4.view.fc;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
    private static final boolean DEBUG = false;
    private ArrayList<ViewHolder> mAddAnimations;
    private ArrayList<ArrayList<ViewHolder>> mAdditionsList;
    private ArrayList<ViewHolder> mChangeAnimations;
    private ArrayList<ArrayList<ChangeInfo>> mChangesList;
    private ArrayList<ViewHolder> mMoveAnimations;
    private ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<ViewHolder> mPendingRemovals;
    private ArrayList<ViewHolder> mRemoveAnimations;

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.1 */
    class C04801 implements Runnable {
        final /* synthetic */ ArrayList val$moves;

        C04801(ArrayList arrayList) {
            this.val$moves = arrayList;
        }

        public void run() {
            Iterator it = this.val$moves.iterator();
            while (it.hasNext()) {
                MoveInfo moveInfo = (MoveInfo) it.next();
                DefaultItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
            }
            this.val$moves.clear();
            DefaultItemAnimator.this.mMovesList.remove(this.val$moves);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.2 */
    class C04812 implements Runnable {
        final /* synthetic */ ArrayList val$changes;

        C04812(ArrayList arrayList) {
            this.val$changes = arrayList;
        }

        public void run() {
            Iterator it = this.val$changes.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.animateChangeImpl((ChangeInfo) it.next());
            }
            this.val$changes.clear();
            DefaultItemAnimator.this.mChangesList.remove(this.val$changes);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.3 */
    class C04823 implements Runnable {
        final /* synthetic */ ArrayList val$additions;

        C04823(ArrayList arrayList) {
            this.val$additions = arrayList;
        }

        public void run() {
            Iterator it = this.val$additions.iterator();
            while (it.hasNext()) {
                DefaultItemAnimator.this.animateAddImpl((ViewHolder) it.next());
            }
            this.val$additions.clear();
            DefaultItemAnimator.this.mAdditionsList.remove(this.val$additions);
        }
    }

    class VpaListenerAdapter implements fc {
        private VpaListenerAdapter() {
        }

        public void onAnimationCancel(View view) {
        }

        public void onAnimationEnd(View view) {
        }

        public void onAnimationStart(View view) {
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.4 */
    class C04834 extends VpaListenerAdapter {
        final /* synthetic */ el val$animation;
        final /* synthetic */ ViewHolder val$holder;

        C04834(ViewHolder viewHolder, el elVar) {
            this.val$holder = viewHolder;
            this.val$animation = elVar;
            super();
        }

        public void onAnimationEnd(View view) {
            this.val$animation.m2800a(null);
            cb.m2413c(view, 1.0f);
            DefaultItemAnimator.this.dispatchRemoveFinished(this.val$holder);
            DefaultItemAnimator.this.mRemoveAnimations.remove(this.val$holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchRemoveStarting(this.val$holder);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.5 */
    class C04845 extends VpaListenerAdapter {
        final /* synthetic */ el val$animation;
        final /* synthetic */ ViewHolder val$holder;

        C04845(ViewHolder viewHolder, el elVar) {
            this.val$holder = viewHolder;
            this.val$animation = elVar;
            super();
        }

        public void onAnimationCancel(View view) {
            cb.m2413c(view, 1.0f);
        }

        public void onAnimationEnd(View view) {
            this.val$animation.m2800a(null);
            DefaultItemAnimator.this.dispatchAddFinished(this.val$holder);
            DefaultItemAnimator.this.mAddAnimations.remove(this.val$holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchAddStarting(this.val$holder);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.6 */
    class C04856 extends VpaListenerAdapter {
        final /* synthetic */ el val$animation;
        final /* synthetic */ int val$deltaX;
        final /* synthetic */ int val$deltaY;
        final /* synthetic */ ViewHolder val$holder;

        C04856(ViewHolder viewHolder, int i, int i2, el elVar) {
            this.val$holder = viewHolder;
            this.val$deltaX = i;
            this.val$deltaY = i2;
            this.val$animation = elVar;
            super();
        }

        public void onAnimationCancel(View view) {
            if (this.val$deltaX != 0) {
                cb.m2393a(view, 0.0f);
            }
            if (this.val$deltaY != 0) {
                cb.m2408b(view, 0.0f);
            }
        }

        public void onAnimationEnd(View view) {
            this.val$animation.m2800a(null);
            DefaultItemAnimator.this.dispatchMoveFinished(this.val$holder);
            DefaultItemAnimator.this.mMoveAnimations.remove(this.val$holder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchMoveStarting(this.val$holder);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.7 */
    class C04867 extends VpaListenerAdapter {
        final /* synthetic */ ChangeInfo val$changeInfo;
        final /* synthetic */ el val$oldViewAnim;

        C04867(ChangeInfo changeInfo, el elVar) {
            this.val$changeInfo = changeInfo;
            this.val$oldViewAnim = elVar;
            super();
        }

        public void onAnimationEnd(View view) {
            this.val$oldViewAnim.m2800a(null);
            cb.m2413c(view, 1.0f);
            cb.m2393a(view, 0.0f);
            cb.m2408b(view, 0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.oldHolder, true);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.oldHolder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.oldHolder, true);
        }
    }

    /* renamed from: android.support.v7.widget.DefaultItemAnimator.8 */
    class C04878 extends VpaListenerAdapter {
        final /* synthetic */ ChangeInfo val$changeInfo;
        final /* synthetic */ View val$newView;
        final /* synthetic */ el val$newViewAnimation;

        C04878(ChangeInfo changeInfo, el elVar, View view) {
            this.val$changeInfo = changeInfo;
            this.val$newViewAnimation = elVar;
            this.val$newView = view;
            super();
        }

        public void onAnimationEnd(View view) {
            this.val$newViewAnimation.m2800a(null);
            cb.m2413c(this.val$newView, 1.0f);
            cb.m2393a(this.val$newView, 0.0f);
            cb.m2408b(this.val$newView, 0.0f);
            DefaultItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
            DefaultItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.newHolder);
            DefaultItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            DefaultItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
        }
    }

    class ChangeInfo {
        public int fromX;
        public int fromY;
        public ViewHolder newHolder;
        public ViewHolder oldHolder;
        public int toX;
        public int toY;

        private ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2) {
            this.oldHolder = viewHolder;
            this.newHolder = viewHolder2;
        }

        private ChangeInfo(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
            this(viewHolder, viewHolder2);
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.oldHolder + ", newHolder=" + this.newHolder + ", fromX=" + this.fromX + ", fromY=" + this.fromY + ", toX=" + this.toX + ", toY=" + this.toY + '}';
        }
    }

    class MoveInfo {
        public int fromX;
        public int fromY;
        public ViewHolder holder;
        public int toX;
        public int toY;

        private MoveInfo(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
            this.holder = viewHolder;
            this.fromX = i;
            this.fromY = i2;
            this.toX = i3;
            this.toY = i4;
        }
    }

    public DefaultItemAnimator() {
        this.mPendingRemovals = new ArrayList();
        this.mPendingAdditions = new ArrayList();
        this.mPendingMoves = new ArrayList();
        this.mPendingChanges = new ArrayList();
        this.mAdditionsList = new ArrayList();
        this.mMovesList = new ArrayList();
        this.mChangesList = new ArrayList();
        this.mAddAnimations = new ArrayList();
        this.mMoveAnimations = new ArrayList();
        this.mRemoveAnimations = new ArrayList();
        this.mChangeAnimations = new ArrayList();
    }

    private void animateAddImpl(ViewHolder viewHolder) {
        el s = cb.m2442s(viewHolder.itemView);
        this.mAddAnimations.add(viewHolder);
        s.m2798a(1.0f).m2799a(getAddDuration()).m2800a(new C04845(viewHolder, s)).m2807c();
    }

    private void animateChangeImpl(ChangeInfo changeInfo) {
        View view = null;
        ViewHolder viewHolder = changeInfo.oldHolder;
        View view2 = viewHolder == null ? null : viewHolder.itemView;
        ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view = viewHolder2.itemView;
        }
        if (view2 != null) {
            el a = cb.m2442s(view2).m2799a(getChangeDuration());
            this.mChangeAnimations.add(changeInfo.oldHolder);
            a.m2803b((float) (changeInfo.toX - changeInfo.fromX));
            a.m2806c((float) (changeInfo.toY - changeInfo.fromY));
            a.m2798a(0.0f).m2800a(new C04867(changeInfo, a)).m2807c();
        }
        if (view != null) {
            a = cb.m2442s(view);
            this.mChangeAnimations.add(changeInfo.newHolder);
            a.m2803b(0.0f).m2806c(0.0f).m2799a(getChangeDuration()).m2798a(1.0f).m2800a(new C04878(changeInfo, a, view)).m2807c();
        }
    }

    private void animateMoveImpl(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            cb.m2442s(view).m2803b(0.0f);
        }
        if (i6 != 0) {
            cb.m2442s(view).m2806c(0.0f);
        }
        el s = cb.m2442s(view);
        this.mMoveAnimations.add(viewHolder);
        s.m2799a(getMoveDuration()).m2800a(new C04856(viewHolder, i5, i6, s)).m2807c();
    }

    private void animateRemoveImpl(ViewHolder viewHolder) {
        el s = cb.m2442s(viewHolder.itemView);
        this.mRemoveAnimations.add(viewHolder);
        s.m2799a(getRemoveDuration()).m2798a(0.0f).m2800a(new C04834(viewHolder, s)).m2807c();
    }

    private void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    private void endChangeAnimation(List<ChangeInfo> list, ViewHolder viewHolder) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ChangeInfo changeInfo = (ChangeInfo) list.get(size);
            if (endChangeAnimationIfNecessary(changeInfo, viewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null) {
                list.remove(changeInfo);
            }
        }
    }

    private void endChangeAnimationIfNecessary(ChangeInfo changeInfo) {
        if (changeInfo.oldHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.oldHolder);
        }
        if (changeInfo.newHolder != null) {
            endChangeAnimationIfNecessary(changeInfo, changeInfo.newHolder);
        }
    }

    private boolean endChangeAnimationIfNecessary(ChangeInfo changeInfo, ViewHolder viewHolder) {
        boolean z = false;
        if (changeInfo.newHolder == viewHolder) {
            changeInfo.newHolder = null;
        } else if (changeInfo.oldHolder != viewHolder) {
            return false;
        } else {
            changeInfo.oldHolder = null;
            z = true;
        }
        cb.m2413c(viewHolder.itemView, 1.0f);
        cb.m2393a(viewHolder.itemView, 0.0f);
        cb.m2408b(viewHolder.itemView, 0.0f);
        dispatchChangeFinished(viewHolder, z);
        return true;
    }

    private void resetAnimation(ViewHolder viewHolder) {
        C0113a.m899a(viewHolder.itemView);
        endAnimation(viewHolder);
    }

    public boolean animateAdd(ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        cb.m2413c(viewHolder.itemView, 0.0f);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    public boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        if (viewHolder == viewHolder2) {
            return animateMove(viewHolder, i, i2, i3, i4);
        }
        float o = cb.m2438o(viewHolder.itemView);
        float p = cb.m2439p(viewHolder.itemView);
        float f = cb.m2423f(viewHolder.itemView);
        resetAnimation(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - o);
        int i6 = (int) (((float) (i4 - i2)) - p);
        cb.m2393a(viewHolder.itemView, o);
        cb.m2408b(viewHolder.itemView, p);
        cb.m2413c(viewHolder.itemView, f);
        if (viewHolder2 != null) {
            resetAnimation(viewHolder2);
            cb.m2393a(viewHolder2.itemView, (float) (-i5));
            cb.m2408b(viewHolder2.itemView, (float) (-i6));
            cb.m2413c(viewHolder2.itemView, 0.0f);
        }
        this.mPendingChanges.add(new ChangeInfo(viewHolder2, i, i2, i3, i4, null));
        return true;
    }

    public boolean animateMove(ViewHolder viewHolder, int i, int i2, int i3, int i4) {
        View view = viewHolder.itemView;
        int o = (int) (((float) i) + cb.m2438o(viewHolder.itemView));
        int p = (int) (((float) i2) + cb.m2439p(viewHolder.itemView));
        resetAnimation(viewHolder);
        int i5 = i3 - o;
        int i6 = i4 - p;
        if (i5 == 0 && i6 == 0) {
            dispatchMoveFinished(viewHolder);
            return false;
        }
        if (i5 != 0) {
            cb.m2393a(view, (float) (-i5));
        }
        if (i6 != 0) {
            cb.m2408b(view, (float) (-i6));
        }
        this.mPendingMoves.add(new MoveInfo(o, p, i3, i4, null));
        return true;
    }

    public boolean animateRemove(ViewHolder viewHolder) {
        resetAnimation(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    void cancelAll(List<ViewHolder> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            cb.m2442s(((ViewHolder) list.get(size)).itemView).m2805b();
        }
    }

    public void endAnimation(ViewHolder viewHolder) {
        int size;
        View view = viewHolder.itemView;
        cb.m2442s(view).m2805b();
        for (size = this.mPendingMoves.size() - 1; size >= 0; size--) {
            if (((MoveInfo) this.mPendingMoves.get(size)).holder == viewHolder) {
                cb.m2408b(view, 0.0f);
                cb.m2393a(view, 0.0f);
                dispatchMoveFinished(viewHolder);
                this.mPendingMoves.remove(size);
            }
        }
        endChangeAnimation(this.mPendingChanges, viewHolder);
        if (this.mPendingRemovals.remove(viewHolder)) {
            cb.m2413c(view, 1.0f);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            cb.m2413c(view, 1.0f);
            dispatchAddFinished(viewHolder);
        }
        for (size = this.mChangesList.size() - 1; size >= 0; size--) {
            ArrayList arrayList = (ArrayList) this.mChangesList.get(size);
            endChangeAnimation(arrayList, viewHolder);
            if (arrayList.isEmpty()) {
                this.mChangesList.remove(size);
            }
        }
        for (int size2 = this.mMovesList.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.mMovesList.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((MoveInfo) arrayList.get(size3)).holder == viewHolder) {
                    cb.m2408b(view, 0.0f);
                    cb.m2393a(view, 0.0f);
                    dispatchMoveFinished(viewHolder);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.mAdditionsList.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.mAdditionsList.get(size);
            if (arrayList.remove(viewHolder)) {
                cb.m2413c(view, 1.0f);
                dispatchAddFinished(viewHolder);
                if (arrayList.isEmpty()) {
                    this.mAdditionsList.remove(size);
                }
            }
        }
        if (this.mRemoveAnimations.remove(viewHolder)) {
        }
        if (this.mAddAnimations.remove(viewHolder)) {
        }
        if (this.mChangeAnimations.remove(viewHolder)) {
        }
        if (this.mMoveAnimations.remove(viewHolder)) {
            dispatchFinishedWhenDone();
        } else {
            dispatchFinishedWhenDone();
        }
    }

    public void endAnimations() {
        int size;
        for (size = this.mPendingMoves.size() - 1; size >= 0; size--) {
            MoveInfo moveInfo = (MoveInfo) this.mPendingMoves.get(size);
            View view = moveInfo.holder.itemView;
            cb.m2408b(view, 0.0f);
            cb.m2393a(view, 0.0f);
            dispatchMoveFinished(moveInfo.holder);
            this.mPendingMoves.remove(size);
        }
        for (size = this.mPendingRemovals.size() - 1; size >= 0; size--) {
            dispatchRemoveFinished((ViewHolder) this.mPendingRemovals.get(size));
            this.mPendingRemovals.remove(size);
        }
        for (size = this.mPendingAdditions.size() - 1; size >= 0; size--) {
            ViewHolder viewHolder = (ViewHolder) this.mPendingAdditions.get(size);
            cb.m2413c(viewHolder.itemView, 1.0f);
            dispatchAddFinished(viewHolder);
            this.mPendingAdditions.remove(size);
        }
        for (size = this.mPendingChanges.size() - 1; size >= 0; size--) {
            endChangeAnimationIfNecessary((ChangeInfo) this.mPendingChanges.get(size));
        }
        this.mPendingChanges.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.mMovesList.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.mMovesList.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    MoveInfo moveInfo2 = (MoveInfo) arrayList.get(size3);
                    View view2 = moveInfo2.holder.itemView;
                    cb.m2408b(view2, 0.0f);
                    cb.m2393a(view2, 0.0f);
                    dispatchMoveFinished(moveInfo2.holder);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.mMovesList.remove(arrayList);
                    }
                }
            }
            for (size2 = this.mAdditionsList.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.mAdditionsList.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    ViewHolder viewHolder2 = (ViewHolder) arrayList.get(size3);
                    cb.m2413c(viewHolder2.itemView, 1.0f);
                    dispatchAddFinished(viewHolder2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.mAdditionsList.remove(arrayList);
                    }
                }
            }
            for (size2 = this.mChangesList.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.mChangesList.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    endChangeAnimationIfNecessary((ChangeInfo) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.mChangesList.remove(arrayList);
                    }
                }
            }
            cancelAll(this.mRemoveAnimations);
            cancelAll(this.mMoveAnimations);
            cancelAll(this.mAddAnimations);
            cancelAll(this.mChangeAnimations);
            dispatchAnimationsFinished();
        }
    }

    public boolean isRunning() {
        return (this.mPendingAdditions.isEmpty() && this.mPendingChanges.isEmpty() && this.mPendingMoves.isEmpty() && this.mPendingRemovals.isEmpty() && this.mMoveAnimations.isEmpty() && this.mRemoveAnimations.isEmpty() && this.mAddAnimations.isEmpty() && this.mChangeAnimations.isEmpty() && this.mMovesList.isEmpty() && this.mAdditionsList.isEmpty() && this.mChangesList.isEmpty()) ? false : true;
    }

    public void runPendingAnimations() {
        int i = !this.mPendingRemovals.isEmpty() ? 1 : 0;
        int i2 = !this.mPendingMoves.isEmpty() ? 1 : 0;
        int i3 = !this.mPendingChanges.isEmpty() ? 1 : 0;
        int i4 = !this.mPendingAdditions.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable c04801;
            Iterator it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                animateRemoveImpl((ViewHolder) it.next());
            }
            this.mPendingRemovals.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                c04801 = new C04801(arrayList);
                if (i != 0) {
                    cb.m2403a(((MoveInfo) arrayList.get(0)).holder.itemView, c04801, getRemoveDuration());
                } else {
                    c04801.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList);
                this.mPendingChanges.clear();
                c04801 = new C04812(arrayList);
                if (i != 0) {
                    cb.m2403a(((ChangeInfo) arrayList.get(0)).oldHolder.itemView, c04801, getRemoveDuration());
                } else {
                    c04801.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList2);
                this.mPendingAdditions.clear();
                Runnable c04823 = new C04823(arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c04823.run();
                } else {
                    cb.m2403a(((ViewHolder) arrayList2.get(0)).itemView, c04823, (i != 0 ? getRemoveDuration() : 0) + Math.max(i2 != 0 ? getMoveDuration() : 0, i3 != 0 ? getChangeDuration() : 0));
                }
            }
        }
    }
}
