package jp.wasabeef.recyclerview.animators;

import android.support.v4.view.cb;
import android.support.v4.view.el;
import android.support.v4.view.fc;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder;
import jp.wasabeef.recyclerview.animators.internal.ViewHelper;

public abstract class BaseItemAnimator extends ItemAnimator {
    private static final boolean DEBUG = false;
    protected ArrayList<ViewHolder> mAddAnimations;
    private ArrayList<ArrayList<ViewHolder>> mAdditionsList;
    private ArrayList<ViewHolder> mChangeAnimations;
    private ArrayList<ArrayList<ChangeInfo>> mChangesList;
    private ArrayList<ViewHolder> mMoveAnimations;
    private ArrayList<ArrayList<MoveInfo>> mMovesList;
    private ArrayList<ViewHolder> mPendingAdditions;
    private ArrayList<ChangeInfo> mPendingChanges;
    private ArrayList<MoveInfo> mPendingMoves;
    private ArrayList<ViewHolder> mPendingRemovals;
    protected ArrayList<ViewHolder> mRemoveAnimations;

    /* renamed from: jp.wasabeef.recyclerview.animators.BaseItemAnimator.1 */
    class C10971 implements Runnable {
        final /* synthetic */ ArrayList val$moves;

        C10971(ArrayList arrayList) {
            this.val$moves = arrayList;
        }

        public void run() {
            Iterator it = this.val$moves.iterator();
            while (it.hasNext()) {
                MoveInfo moveInfo = (MoveInfo) it.next();
                BaseItemAnimator.this.animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY);
            }
            this.val$moves.clear();
            BaseItemAnimator.this.mMovesList.remove(this.val$moves);
        }
    }

    /* renamed from: jp.wasabeef.recyclerview.animators.BaseItemAnimator.2 */
    class C10982 implements Runnable {
        final /* synthetic */ ArrayList val$changes;

        C10982(ArrayList arrayList) {
            this.val$changes = arrayList;
        }

        public void run() {
            Iterator it = this.val$changes.iterator();
            while (it.hasNext()) {
                BaseItemAnimator.this.animateChangeImpl((ChangeInfo) it.next());
            }
            this.val$changes.clear();
            BaseItemAnimator.this.mChangesList.remove(this.val$changes);
        }
    }

    /* renamed from: jp.wasabeef.recyclerview.animators.BaseItemAnimator.3 */
    class C10993 implements Runnable {
        final /* synthetic */ ArrayList val$additions;

        C10993(ArrayList arrayList) {
            this.val$additions = arrayList;
        }

        public void run() {
            Iterator it = this.val$additions.iterator();
            while (it.hasNext()) {
                BaseItemAnimator.this.doAnimateAdd((ViewHolder) it.next());
            }
            this.val$additions.clear();
            BaseItemAnimator.this.mAdditionsList.remove(this.val$additions);
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

    /* renamed from: jp.wasabeef.recyclerview.animators.BaseItemAnimator.4 */
    class C11004 extends VpaListenerAdapter {
        final /* synthetic */ el val$animation;
        final /* synthetic */ int val$deltaX;
        final /* synthetic */ int val$deltaY;
        final /* synthetic */ ViewHolder val$holder;

        C11004(ViewHolder viewHolder, int i, int i2, el elVar) {
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
            BaseItemAnimator.this.dispatchMoveFinished(this.val$holder);
            BaseItemAnimator.this.mMoveAnimations.remove(this.val$holder);
            BaseItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            BaseItemAnimator.this.dispatchMoveStarting(this.val$holder);
        }
    }

    /* renamed from: jp.wasabeef.recyclerview.animators.BaseItemAnimator.5 */
    class C11015 extends VpaListenerAdapter {
        final /* synthetic */ ChangeInfo val$changeInfo;
        final /* synthetic */ el val$oldViewAnim;

        C11015(ChangeInfo changeInfo, el elVar) {
            this.val$changeInfo = changeInfo;
            this.val$oldViewAnim = elVar;
            super();
        }

        public void onAnimationEnd(View view) {
            this.val$oldViewAnim.m2800a(null);
            cb.m2413c(view, 1.0f);
            cb.m2393a(view, 0.0f);
            cb.m2408b(view, 0.0f);
            BaseItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.oldHolder, true);
            BaseItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.oldHolder);
            BaseItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            BaseItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.oldHolder, true);
        }
    }

    /* renamed from: jp.wasabeef.recyclerview.animators.BaseItemAnimator.6 */
    class C11026 extends VpaListenerAdapter {
        final /* synthetic */ ChangeInfo val$changeInfo;
        final /* synthetic */ View val$newView;
        final /* synthetic */ el val$newViewAnimation;

        C11026(ChangeInfo changeInfo, el elVar, View view) {
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
            BaseItemAnimator.this.dispatchChangeFinished(this.val$changeInfo.newHolder, false);
            BaseItemAnimator.this.mChangeAnimations.remove(this.val$changeInfo.newHolder);
            BaseItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            BaseItemAnimator.this.dispatchChangeStarting(this.val$changeInfo.newHolder, false);
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

    public class DefaultAddVpaListener extends VpaListenerAdapter {
        ViewHolder mViewHolder;

        public DefaultAddVpaListener(ViewHolder viewHolder) {
            super();
            this.mViewHolder = viewHolder;
        }

        public void onAnimationCancel(View view) {
            ViewHelper.clear(view);
        }

        public void onAnimationEnd(View view) {
            ViewHelper.clear(view);
            BaseItemAnimator.this.dispatchAddFinished(this.mViewHolder);
            BaseItemAnimator.this.mAddAnimations.remove(this.mViewHolder);
            BaseItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            BaseItemAnimator.this.dispatchAddStarting(this.mViewHolder);
        }
    }

    public class DefaultRemoveVpaListener extends VpaListenerAdapter {
        ViewHolder mViewHolder;

        public DefaultRemoveVpaListener(ViewHolder viewHolder) {
            super();
            this.mViewHolder = viewHolder;
        }

        public void onAnimationCancel(View view) {
            ViewHelper.clear(view);
        }

        public void onAnimationEnd(View view) {
            ViewHelper.clear(view);
            BaseItemAnimator.this.dispatchRemoveFinished(this.mViewHolder);
            BaseItemAnimator.this.mRemoveAnimations.remove(this.mViewHolder);
            BaseItemAnimator.this.dispatchFinishedWhenDone();
        }

        public void onAnimationStart(View view) {
            BaseItemAnimator.this.dispatchRemoveStarting(this.mViewHolder);
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

    public BaseItemAnimator() {
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

    private void animateChangeImpl(ChangeInfo changeInfo) {
        View view = null;
        ViewHolder viewHolder = changeInfo.oldHolder;
        View view2 = viewHolder == null ? null : viewHolder.itemView;
        ViewHolder viewHolder2 = changeInfo.newHolder;
        if (viewHolder2 != null) {
            view = viewHolder2.itemView;
        }
        if (view2 != null) {
            this.mChangeAnimations.add(changeInfo.oldHolder);
            el a = cb.m2442s(view2).m2799a(getChangeDuration());
            a.m2803b((float) (changeInfo.toX - changeInfo.fromX));
            a.m2806c((float) (changeInfo.toY - changeInfo.fromY));
            a.m2798a(0.0f).m2800a(new C11015(changeInfo, a)).m2807c();
        }
        if (view != null) {
            this.mChangeAnimations.add(changeInfo.newHolder);
            a = cb.m2442s(view);
            a.m2803b(0.0f).m2806c(0.0f).m2799a(getChangeDuration()).m2798a(1.0f).m2800a(new C11026(changeInfo, a, view)).m2807c();
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
        this.mMoveAnimations.add(viewHolder);
        el s = cb.m2442s(view);
        s.m2799a(getMoveDuration()).m2800a(new C11004(viewHolder, i5, i6, s)).m2807c();
    }

    private void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }

    private void doAnimateAdd(ViewHolder viewHolder) {
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).animateAddImpl(new DefaultAddVpaListener(viewHolder));
        } else {
            animateAddImpl(viewHolder);
        }
        this.mAddAnimations.add(viewHolder);
    }

    private void doAnimateRemove(ViewHolder viewHolder) {
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).animateRemoveImpl(new DefaultRemoveVpaListener(viewHolder));
        } else {
            animateRemoveImpl(viewHolder);
        }
        this.mRemoveAnimations.add(viewHolder);
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

    private void preAnimateAdd(ViewHolder viewHolder) {
        ViewHelper.clear(viewHolder.itemView);
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).preAnimateAddImpl();
        } else {
            preAnimateAddImpl(viewHolder);
        }
    }

    private void preAnimateRemove(ViewHolder viewHolder) {
        ViewHelper.clear(viewHolder.itemView);
        if (viewHolder instanceof AnimateViewHolder) {
            ((AnimateViewHolder) viewHolder).preAnimateRemoveImpl();
        } else {
            preAnimateRemoveImpl(viewHolder);
        }
    }

    public boolean animateAdd(ViewHolder viewHolder) {
        endAnimation(viewHolder);
        preAnimateAdd(viewHolder);
        this.mPendingAdditions.add(viewHolder);
        return true;
    }

    protected abstract void animateAddImpl(ViewHolder viewHolder);

    public boolean animateChange(ViewHolder viewHolder, ViewHolder viewHolder2, int i, int i2, int i3, int i4) {
        float o = cb.m2438o(viewHolder.itemView);
        float p = cb.m2439p(viewHolder.itemView);
        float f = cb.m2423f(viewHolder.itemView);
        endAnimation(viewHolder);
        int i5 = (int) (((float) (i3 - i)) - o);
        int i6 = (int) (((float) (i4 - i2)) - p);
        cb.m2393a(viewHolder.itemView, o);
        cb.m2408b(viewHolder.itemView, p);
        cb.m2413c(viewHolder.itemView, f);
        if (!(viewHolder2 == null || viewHolder2.itemView == null)) {
            endAnimation(viewHolder2);
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
        endAnimation(viewHolder);
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
        endAnimation(viewHolder);
        preAnimateRemove(viewHolder);
        this.mPendingRemovals.add(viewHolder);
        return true;
    }

    protected abstract void animateRemoveImpl(ViewHolder viewHolder);

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
            ViewHelper.clear(viewHolder.itemView);
            dispatchRemoveFinished(viewHolder);
        }
        if (this.mPendingAdditions.remove(viewHolder)) {
            ViewHelper.clear(viewHolder.itemView);
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
                ViewHelper.clear(viewHolder.itemView);
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
            ViewHelper.clear(viewHolder.itemView);
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

    protected void preAnimateAddImpl(ViewHolder viewHolder) {
    }

    protected void preAnimateRemoveImpl(ViewHolder viewHolder) {
    }

    public void runPendingAnimations() {
        int i = !this.mPendingRemovals.isEmpty() ? 1 : 0;
        int i2 = !this.mPendingMoves.isEmpty() ? 1 : 0;
        int i3 = !this.mPendingChanges.isEmpty() ? 1 : 0;
        int i4 = !this.mPendingAdditions.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable c10971;
            Iterator it = this.mPendingRemovals.iterator();
            while (it.hasNext()) {
                doAnimateRemove((ViewHolder) it.next());
            }
            this.mPendingRemovals.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingMoves);
                this.mMovesList.add(arrayList);
                this.mPendingMoves.clear();
                c10971 = new C10971(arrayList);
                if (i != 0) {
                    cb.m2403a(((MoveInfo) arrayList.get(0)).holder.itemView, c10971, getRemoveDuration());
                } else {
                    c10971.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.mPendingChanges);
                this.mChangesList.add(arrayList);
                this.mPendingChanges.clear();
                c10971 = new C10982(arrayList);
                if (i != 0) {
                    cb.m2403a(((ChangeInfo) arrayList.get(0)).oldHolder.itemView, c10971, getRemoveDuration());
                } else {
                    c10971.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.mPendingAdditions);
                this.mAdditionsList.add(arrayList2);
                this.mPendingAdditions.clear();
                Runnable c10993 = new C10993(arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c10993.run();
                } else {
                    cb.m2403a(((ViewHolder) arrayList2.get(0)).itemView, c10993, (i != 0 ? getRemoveDuration() : 0) + Math.max(i2 != 0 ? getMoveDuration() : 0, i3 != 0 ? getChangeDuration() : 0));
                }
            }
        }
    }
}
