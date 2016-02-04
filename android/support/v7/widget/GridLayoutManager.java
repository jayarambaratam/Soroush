package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.C0296s;
import android.support.v7.widget.LinearLayoutManager.LayoutChunkResult;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.Arrays;

public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    static final int MAIN_DIR_SPEC;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;

    public abstract class SpanSizeLookup {
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanIndexCache;

        public SpanSizeLookup() {
            this.mSpanIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = GridLayoutManager.DEBUG;
        }

        int findReferenceIndexFromCache(int i) {
            int i2 = GridLayoutManager.MAIN_DIR_SPEC;
            int size = this.mSpanIndexCache.size() + GridLayoutManager.DEFAULT_SPAN_COUNT;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.mSpanIndexCache.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 + GridLayoutManager.DEFAULT_SPAN_COUNT;
                }
            }
            size = i2 + GridLayoutManager.DEFAULT_SPAN_COUNT;
            return (size < 0 || size >= this.mSpanIndexCache.size()) ? GridLayoutManager.DEFAULT_SPAN_COUNT : this.mSpanIndexCache.keyAt(size);
        }

        int getCachedSpanIndex(int i, int i2) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.mSpanIndexCache.get(i, GridLayoutManager.DEFAULT_SPAN_COUNT);
            if (i3 != GridLayoutManager.DEFAULT_SPAN_COUNT) {
                return i3;
            }
            i3 = getSpanIndex(i, i2);
            this.mSpanIndexCache.put(i, i3);
            return i3;
        }

        public int getSpanGroupIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            int i3 = GridLayoutManager.MAIN_DIR_SPEC;
            int i4 = GridLayoutManager.MAIN_DIR_SPEC;
            int i5 = GridLayoutManager.MAIN_DIR_SPEC;
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                i5 += spanSize2;
                if (i5 == i2) {
                    i4++;
                    spanSize2 = GridLayoutManager.MAIN_DIR_SPEC;
                } else if (i5 > i2) {
                    i4++;
                } else {
                    spanSize2 = i5;
                }
                i3++;
                i5 = spanSize2;
            }
            return i5 + spanSize > i2 ? i4 + 1 : i4;
        }

        public int getSpanIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return GridLayoutManager.MAIN_DIR_SPEC;
            }
            int findReferenceIndexFromCache;
            int spanSize2;
            int i3;
            if (this.mCacheSpanIndices && this.mSpanIndexCache.size() > 0) {
                findReferenceIndexFromCache = findReferenceIndexFromCache(i);
                if (findReferenceIndexFromCache >= 0) {
                    spanSize2 = this.mSpanIndexCache.get(findReferenceIndexFromCache) + getSpanSize(findReferenceIndexFromCache);
                    findReferenceIndexFromCache++;
                    i3 = findReferenceIndexFromCache;
                    while (i3 < i) {
                        findReferenceIndexFromCache = getSpanSize(i3);
                        spanSize2 += findReferenceIndexFromCache;
                        if (spanSize2 == i2) {
                            findReferenceIndexFromCache = GridLayoutManager.MAIN_DIR_SPEC;
                        } else if (spanSize2 <= i2) {
                            findReferenceIndexFromCache = spanSize2;
                        }
                        i3++;
                        spanSize2 = findReferenceIndexFromCache;
                    }
                    return spanSize2 + spanSize > i2 ? spanSize2 : GridLayoutManager.MAIN_DIR_SPEC;
                }
            }
            findReferenceIndexFromCache = GridLayoutManager.MAIN_DIR_SPEC;
            spanSize2 = GridLayoutManager.MAIN_DIR_SPEC;
            i3 = findReferenceIndexFromCache;
            while (i3 < i) {
                findReferenceIndexFromCache = getSpanSize(i3);
                spanSize2 += findReferenceIndexFromCache;
                if (spanSize2 == i2) {
                    findReferenceIndexFromCache = GridLayoutManager.MAIN_DIR_SPEC;
                } else if (spanSize2 <= i2) {
                    findReferenceIndexFromCache = spanSize2;
                }
                i3++;
                spanSize2 = findReferenceIndexFromCache;
            }
            if (spanSize2 + spanSize > i2) {
            }
        }

        public abstract int getSpanSize(int i);

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            this.mCacheSpanIndices = z;
        }
    }

    public final class DefaultSpanSizeLookup extends SpanSizeLookup {
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }

        public int getSpanSize(int i) {
            return 1;
        }
    }

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        private int mSpanIndex;
        private int mSpanSize;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mSpanIndex = INVALID_SPAN_ID;
            this.mSpanSize = GridLayoutManager.MAIN_DIR_SPEC;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    static {
        MAIN_DIR_SPEC = MeasureSpec.makeMeasureSpec(MAIN_DIR_SPEC, MAIN_DIR_SPEC);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.mPendingSpanCountChange = DEBUG;
        this.mSpanCount = DEFAULT_SPAN_COUNT;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.mPendingSpanCountChange = DEBUG;
        this.mSpanCount = DEFAULT_SPAN_COUNT;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPendingSpanCountChange = DEBUG;
        this.mSpanCount = DEFAULT_SPAN_COUNT;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    private void assignSpans(Recycler recycler, State state, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (z) {
            i3 = 1;
            i4 = MAIN_DIR_SPEC;
        } else {
            i4 = i + DEFAULT_SPAN_COUNT;
            i3 = DEFAULT_SPAN_COUNT;
            i = DEFAULT_SPAN_COUNT;
        }
        if (this.mOrientation == 1 && isLayoutRTL()) {
            i5 = this.mSpanCount + DEFAULT_SPAN_COUNT;
            i6 = DEFAULT_SPAN_COUNT;
        } else {
            i5 = MAIN_DIR_SPEC;
            i6 = 1;
        }
        int i7 = i5;
        for (i5 = i4; i5 != i; i5 += i3) {
            View view = this.mSet[i5];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.mSpanSize = getSpanSize(recycler, state, getPosition(view));
            if (i6 != DEFAULT_SPAN_COUNT || layoutParams.mSpanSize <= 1) {
                layoutParams.mSpanIndex = i7;
            } else {
                layoutParams.mSpanIndex = i7 - (layoutParams.mSpanSize + DEFAULT_SPAN_COUNT);
            }
            i7 += layoutParams.mSpanSize * i6;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = MAIN_DIR_SPEC; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i) {
        int i2 = MAIN_DIR_SPEC;
        if (!(this.mCachedBorders != null && this.mCachedBorders.length == this.mSpanCount + 1 && this.mCachedBorders[this.mCachedBorders.length + DEFAULT_SPAN_COUNT] == i)) {
            this.mCachedBorders = new int[(this.mSpanCount + 1)];
        }
        this.mCachedBorders[MAIN_DIR_SPEC] = MAIN_DIR_SPEC;
        int i3 = i / this.mSpanCount;
        int i4 = i % this.mSpanCount;
        int i5 = MAIN_DIR_SPEC;
        for (int i6 = 1; i6 <= this.mSpanCount; i6++) {
            int i7 = i2 + i4;
            if (i7 <= 0 || this.mSpanCount - i7 >= i4) {
                i2 = i7;
                i7 = i3;
            } else {
                int i8 = i3 + 1;
                i2 = i7 - this.mSpanCount;
                i7 = i8;
            }
            i5 += i7;
            this.mCachedBorders[i6] = i5;
        }
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void ensureAnchorIsInFirstSpan(Recycler recycler, State state, AnchorInfo anchorInfo) {
        int spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        while (spanIndex > 0 && anchorInfo.mPosition > 0) {
            anchorInfo.mPosition += DEFAULT_SPAN_COUNT;
            spanIndex = getSpanIndex(recycler, state, anchorInfo.mPosition);
        }
    }

    private void ensureViewSet() {
        if (this.mSet == null || this.mSet.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getMainDirSpec(int i) {
        return i < 0 ? MAIN_DIR_SPEC : MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private int getSpanGroupIndex(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanGroupIndex(i, this.mSpanCount);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout != DEFAULT_SPAN_COUNT) {
            return this.mSpanSizeLookup.getSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i);
        return MAIN_DIR_SPEC;
    }

    private int getSpanIndex(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, DEFAULT_SPAN_COUNT);
        if (i2 != DEFAULT_SPAN_COUNT) {
            return i2;
        }
        i2 = recycler.convertPreLayoutPositionToPostLayout(i);
        if (i2 != DEFAULT_SPAN_COUNT) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i2, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return MAIN_DIR_SPEC;
    }

    private int getSpanSize(Recycler recycler, State state, int i) {
        if (!state.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, DEFAULT_SPAN_COUNT);
        if (i2 != DEFAULT_SPAN_COUNT) {
            return i2;
        }
        i2 = recycler.convertPreLayoutPositionToPostLayout(i);
        if (i2 != DEFAULT_SPAN_COUNT) {
            return this.mSpanSizeLookup.getSpanSize(i2);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z) {
        calculateItemDecorationsForChild(view, this.mDecorInsets);
        android.support.v7.widget.RecyclerView.LayoutParams layoutParams = (android.support.v7.widget.RecyclerView.LayoutParams) view.getLayoutParams();
        if (z || this.mOrientation == 1) {
            i = updateSpecWithExtra(i, layoutParams.leftMargin + this.mDecorInsets.left, layoutParams.rightMargin + this.mDecorInsets.right);
        }
        if (z || this.mOrientation == 0) {
            i2 = updateSpecWithExtra(i2, layoutParams.topMargin + this.mDecorInsets.top, layoutParams.bottomMargin + this.mDecorInsets.bottom);
        }
        view.measure(i, i2);
    }

    private void updateMeasurements() {
        calculateItemBorders(getOrientation() == 1 ? (getWidth() - getPaddingRight()) - getPaddingLeft() : (getHeight() - getPaddingBottom()) - getPaddingTop());
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == RtlSpacingHelper.UNDEFINED || mode == 1073741824) ? MeasureSpec.makeMeasureSpec((MeasureSpec.getSize(i) - i2) - i3, mode) : i;
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    View findReferenceChild(Recycler recycler, State state, int i, int i2, int i3) {
        View view = null;
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        int i4 = i2 > i ? 1 : DEFAULT_SPAN_COUNT;
        View view2 = null;
        while (i != i2) {
            View view3;
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (getSpanIndex(recycler, state, position) != 0) {
                    view3 = view;
                    childAt = view2;
                } else if (((android.support.v7.widget.RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view3 = view;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view3 = childAt;
                        childAt = view2;
                    }
                }
                i += i4;
                view = view3;
                view2 = childAt;
            }
            view3 = view;
            childAt = view2;
            i += i4;
            view = view3;
            view2 = childAt;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    public android.support.v7.widget.RecyclerView.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public int getColumnCountForAccessibility(Recycler recycler, State state) {
        return this.mOrientation == 1 ? this.mSpanCount : state.getItemCount() < 1 ? MAIN_DIR_SPEC : getSpanGroupIndex(recycler, state, state.getItemCount() + DEFAULT_SPAN_COUNT);
    }

    public int getRowCountForAccessibility(Recycler recycler, State state) {
        return this.mOrientation == 0 ? this.mSpanCount : state.getItemCount() < 1 ? MAIN_DIR_SPEC : getSpanGroupIndex(recycler, state, state.getItemCount() + DEFAULT_SPAN_COUNT);
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    void layoutChunk(Recycler recycler, State state, LayoutState layoutState, LayoutChunkResult layoutChunkResult) {
        boolean z = layoutState.mItemDirection == 1 ? true : DEBUG;
        int i = MAIN_DIR_SPEC;
        int i2 = MAIN_DIR_SPEC;
        int i3 = this.mSpanCount;
        if (!z) {
            i3 = getSpanIndex(recycler, state, layoutState.mCurrentPosition) + getSpanSize(recycler, state, layoutState.mCurrentPosition);
        }
        while (i < this.mSpanCount && layoutState.hasMore(state) && i3 > 0) {
            int i4 = layoutState.mCurrentPosition;
            int spanSize = getSpanSize(recycler, state, i4);
            if (spanSize <= this.mSpanCount) {
                i3 -= spanSize;
                if (i3 >= 0) {
                    View next = layoutState.next(recycler);
                    if (next == null) {
                        break;
                    }
                    i2 += spanSize;
                    this.mSet[i] = next;
                    i++;
                } else {
                    break;
                }
            }
            throw new IllegalArgumentException("Item at position " + i4 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
        }
        if (i == 0) {
            layoutChunkResult.mFinished = true;
            return;
        }
        int makeMeasureSpec;
        assignSpans(recycler, state, i, i2, z);
        spanSize = MAIN_DIR_SPEC;
        i4 = MAIN_DIR_SPEC;
        while (spanSize < i) {
            View view = this.mSet[spanSize];
            if (layoutState.mScrapList == null) {
                if (z) {
                    addView(view);
                } else {
                    addView(view, MAIN_DIR_SPEC);
                }
            } else if (z) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, MAIN_DIR_SPEC);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mCachedBorders[layoutParams.mSpanIndex + layoutParams.mSpanSize] - this.mCachedBorders[layoutParams.mSpanIndex], 1073741824);
            if (this.mOrientation == 1) {
                measureChildWithDecorationsAndMargin(view, makeMeasureSpec, getMainDirSpec(layoutParams.height), DEBUG);
            } else {
                measureChildWithDecorationsAndMargin(view, getMainDirSpec(layoutParams.width), makeMeasureSpec, DEBUG);
            }
            i3 = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (i3 <= i4) {
                i3 = i4;
            }
            spanSize++;
            i4 = i3;
        }
        i2 = getMainDirSpec(i4);
        for (spanSize = MAIN_DIR_SPEC; spanSize < i; spanSize++) {
            View view2 = this.mSet[spanSize];
            if (this.mOrientationHelper.getDecoratedMeasurement(view2) != i4) {
                layoutParams = (LayoutParams) view2.getLayoutParams();
                i3 = MeasureSpec.makeMeasureSpec(this.mCachedBorders[layoutParams.mSpanIndex + layoutParams.mSpanSize] - this.mCachedBorders[layoutParams.mSpanIndex], 1073741824);
                if (this.mOrientation == 1) {
                    measureChildWithDecorationsAndMargin(view2, i3, i2, true);
                } else {
                    measureChildWithDecorationsAndMargin(view2, i2, i3, true);
                }
            }
        }
        layoutChunkResult.mConsumed = i4;
        i3 = MAIN_DIR_SPEC;
        if (this.mOrientation == 1) {
            if (layoutState.mLayoutDirection == DEFAULT_SPAN_COUNT) {
                i3 = layoutState.mOffset;
                i4 = i3 - i4;
                spanSize = MAIN_DIR_SPEC;
                i2 = MAIN_DIR_SPEC;
            } else {
                spanSize = layoutState.mOffset;
                i3 = spanSize + i4;
                i4 = spanSize;
                spanSize = MAIN_DIR_SPEC;
                i2 = MAIN_DIR_SPEC;
            }
        } else if (layoutState.mLayoutDirection == DEFAULT_SPAN_COUNT) {
            i2 = layoutState.mOffset;
            spanSize = i2;
            i2 -= i4;
            i4 = MAIN_DIR_SPEC;
        } else {
            i2 = layoutState.mOffset;
            spanSize = i4 + i2;
            i4 = MAIN_DIR_SPEC;
        }
        int i5 = MAIN_DIR_SPEC;
        makeMeasureSpec = i2;
        i2 = spanSize;
        spanSize = i4;
        i4 = i3;
        while (i5 < i) {
            int decoratedMeasurementInOther;
            int i6;
            view2 = this.mSet[i5];
            layoutParams = (LayoutParams) view2.getLayoutParams();
            if (this.mOrientation == 1) {
                makeMeasureSpec = this.mCachedBorders[layoutParams.mSpanIndex] + getPaddingLeft();
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(view2) + makeMeasureSpec;
                i6 = makeMeasureSpec;
            } else {
                spanSize = this.mCachedBorders[layoutParams.mSpanIndex] + getPaddingTop();
                i4 = this.mOrientationHelper.getDecoratedMeasurementInOther(view2) + spanSize;
                decoratedMeasurementInOther = i2;
                i6 = makeMeasureSpec;
            }
            layoutDecorated(view2, i6 + layoutParams.leftMargin, spanSize + layoutParams.topMargin, decoratedMeasurementInOther - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable |= view2.isFocusable();
            i5++;
            i2 = decoratedMeasurementInOther;
            makeMeasureSpec = i6;
        }
        Arrays.fill(this.mSet, null);
    }

    void onAnchorReady(Recycler recycler, State state, AnchorInfo anchorInfo) {
        super.onAnchorReady(recycler, state, anchorInfo);
        updateMeasurements();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            ensureAnchorIsInFirstSpan(recycler, state, anchorInfo);
        }
        ensureViewSet();
    }

    public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, C0284g c0284g) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            int spanGroupIndex = getSpanGroupIndex(recycler, state, layoutParams2.getViewLayoutPosition());
            if (this.mOrientation == 0) {
                int spanIndex = layoutParams2.getSpanIndex();
                int spanSize = layoutParams2.getSpanSize();
                boolean z = (this.mSpanCount <= 1 || layoutParams2.getSpanSize() != this.mSpanCount) ? DEBUG : true;
                c0284g.m1961c(C0296s.m2146a(spanIndex, spanSize, spanGroupIndex, 1, z, DEBUG));
                return;
            }
            int spanIndex2 = layoutParams2.getSpanIndex();
            int spanSize2 = layoutParams2.getSpanSize();
            boolean z2 = (this.mSpanCount <= 1 || layoutParams2.getSpanSize() != this.mSpanCount) ? DEBUG : true;
            c0284g.m1961c(C0296s.m2146a(spanGroupIndex, 1, spanIndex2, spanSize2, z2, DEBUG));
            return;
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, c0284g);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        if (state.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recycler, state);
        clearPreLayoutSpanMappingCache();
        if (!state.isPreLayout()) {
            this.mPendingSpanCountChange = DEBUG;
        }
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    public void setSpanCount(int i) {
        if (i != this.mSpanCount) {
            this.mPendingSpanCountChange = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.mSpanCount = i;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(DEBUG);
    }

    public boolean supportsPredictiveItemAnimations() {
        return (this.mPendingSavedState != null || this.mPendingSpanCountChange) ? DEBUG : true;
    }
}
