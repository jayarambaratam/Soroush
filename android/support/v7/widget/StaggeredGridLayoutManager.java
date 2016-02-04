package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.p017a.C0278a;
import android.support.v4.view.p017a.C0284g;
import android.support.v4.view.p017a.C0296s;
import android.support.v4.view.p017a.am;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager.Properties;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.SmoothScroller;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import org.linphone.mediastream.Version;

public class StaggeredGridLayoutManager extends LayoutManager {
    private static final boolean DEBUG = false;
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    private static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final String TAG = "StaggeredGridLayoutManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy;
    private int mHeightSpec;
    private boolean mLaidOutInvalidFullSpan;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    private boolean mReverseLayout;
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount;
    private Span[] mSpans;
    private final Rect mTmpRect;
    private int mWidthSpec;

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.1 */
    class C05151 implements Runnable {
        C05151() {
        }

        public void run() {
            StaggeredGridLayoutManager.this.checkForGaps();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.2 */
    class C05162 extends LinearSmoothScroller {
        C05162(Context context) {
            super(context);
        }

        public PointF computeScrollVectorForPosition(int i) {
            int access$400 = StaggeredGridLayoutManager.this.calculateScrollDirectionForPosition(i);
            return access$400 == 0 ? null : StaggeredGridLayoutManager.this.mOrientation == 0 ? new PointF((float) access$400, 0.0f) : new PointF(0.0f, (float) access$400);
        }
    }

    class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;

        private AnchorInfo() {
        }

        void assignCoordinateFromPadding() {
            this.mOffset = this.mLayoutFromEnd ? StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() : StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
        }

        void assignCoordinateFromPadding(int i) {
            if (this.mLayoutFromEnd) {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding() - i;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding() + i;
            }
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = StaggeredGridLayoutManager.INVALID_OFFSET;
            this.mLayoutFromEnd = StaggeredGridLayoutManager.DEBUG;
            this.mInvalidateOffsets = StaggeredGridLayoutManager.DEBUG;
        }
    }

    public class LayoutParams extends android.support.v7.widget.RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public final int getSpanIndex() {
            return this.mSpan == null ? INVALID_SPAN_ID : this.mSpan.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public void setFullSpan(boolean z) {
            this.mFullSpan = z;
        }
    }

    class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        class FullSpanItem implements Parcelable {
            public static final Creator<FullSpanItem> CREATOR;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1 */
            final class C05171 implements Creator<FullSpanItem> {
                C05171() {
                }

                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            }

            static {
                CREATOR = new C05171();
            }

            public FullSpanItem(Parcel parcel) {
                boolean z = true;
                this.mPosition = parcel.readInt();
                this.mGapDir = parcel.readInt();
                if (parcel.readInt() != StaggeredGridLayoutManager.VERTICAL) {
                    z = StaggeredGridLayoutManager.DEBUG;
                }
                this.mHasUnwantedGapAfter = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.mGapPerSpan = new int[readInt];
                    parcel.readIntArray(this.mGapPerSpan);
                }
            }

            public int describeContents() {
                return StaggeredGridLayoutManager.HORIZONTAL;
            }

            int getGapForSpan(int i) {
                return this.mGapPerSpan == null ? StaggeredGridLayoutManager.HORIZONTAL : this.mGapPerSpan[i];
            }

            public void invalidateSpanGaps() {
                this.mGapPerSpan = null;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.mGapDir);
                parcel.writeInt(this.mHasUnwantedGapAfter ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);
                if (this.mGapPerSpan == null || this.mGapPerSpan.length <= 0) {
                    parcel.writeInt(StaggeredGridLayoutManager.HORIZONTAL);
                    return;
                }
                parcel.writeInt(this.mGapPerSpan.length);
                parcel.writeIntArray(this.mGapPerSpan);
            }
        }

        LazySpanLookup() {
        }

        private int invalidateFullSpansAfter(int i) {
            if (this.mFullSpanItems == null) {
                return -1;
            }
            FullSpanItem fullSpanItem = getFullSpanItem(i);
            if (fullSpanItem != null) {
                this.mFullSpanItems.remove(fullSpanItem);
            }
            int size = this.mFullSpanItems.size();
            int i2 = StaggeredGridLayoutManager.HORIZONTAL;
            while (i2 < size) {
                if (((FullSpanItem) this.mFullSpanItems.get(i2)).mPosition >= i) {
                    break;
                }
                i2 += StaggeredGridLayoutManager.VERTICAL;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(i2);
            this.mFullSpanItems.remove(i2);
            return fullSpanItem.mPosition;
        }

        private void offsetFullSpansForAddition(int i, int i2) {
            if (this.mFullSpanItems != null) {
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        private void offsetFullSpansForRemoval(int i, int i2) {
            if (this.mFullSpanItems != null) {
                int i3 = i + i2;
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.mFullSpanItems.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }

        public void addFullSpanItem(FullSpanItem fullSpanItem) {
            if (this.mFullSpanItems == null) {
                this.mFullSpanItems = new ArrayList();
            }
            int size = this.mFullSpanItems.size();
            for (int i = StaggeredGridLayoutManager.HORIZONTAL; i < size; i += StaggeredGridLayoutManager.VERTICAL) {
                FullSpanItem fullSpanItem2 = (FullSpanItem) this.mFullSpanItems.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.mFullSpanItems.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.mFullSpanItems.add(i, fullSpanItem);
                    return;
                }
            }
            this.mFullSpanItems.add(fullSpanItem);
        }

        void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.mFullSpanItems = null;
        }

        void ensureSize(int i) {
            if (this.mData == null) {
                this.mData = new int[(Math.max(i, MIN_SIZE) + StaggeredGridLayoutManager.VERTICAL)];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                Object obj = this.mData;
                this.mData = new int[sizeForPosition(i)];
                System.arraycopy(obj, StaggeredGridLayoutManager.HORIZONTAL, this.mData, StaggeredGridLayoutManager.HORIZONTAL, obj.length);
                Arrays.fill(this.mData, obj.length, this.mData.length, -1);
            }
        }

        int forceInvalidateAfter(int i) {
            if (this.mFullSpanItems != null) {
                for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                    if (((FullSpanItem) this.mFullSpanItems.get(size)).mPosition >= i) {
                        this.mFullSpanItems.remove(size);
                    }
                }
            }
            return invalidateAfter(i);
        }

        public FullSpanItem getFirstFullSpanItemInRange(int i, int i2, int i3, boolean z) {
            if (this.mFullSpanItems == null) {
                return null;
            }
            int size = this.mFullSpanItems.size();
            for (int i4 = StaggeredGridLayoutManager.HORIZONTAL; i4 < size; i4 += StaggeredGridLayoutManager.VERTICAL) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i) {
                    if (i3 == 0 || fullSpanItem.mGapDir == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.mHasUnwantedGapAfter) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        public FullSpanItem getFullSpanItem(int i) {
            if (this.mFullSpanItems == null) {
                return null;
            }
            for (int size = this.mFullSpanItems.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = (FullSpanItem) this.mFullSpanItems.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        int getSpan(int i) {
            return (this.mData == null || i >= this.mData.length) ? -1 : this.mData[i];
        }

        int invalidateAfter(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            int invalidateFullSpansAfter = invalidateFullSpansAfter(i);
            if (invalidateFullSpansAfter == -1) {
                Arrays.fill(this.mData, i, this.mData.length, -1);
                return this.mData.length;
            }
            Arrays.fill(this.mData, i, invalidateFullSpansAfter + StaggeredGridLayoutManager.VERTICAL, -1);
            return invalidateFullSpansAfter + StaggeredGridLayoutManager.VERTICAL;
        }

        void offsetForAddition(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                ensureSize(i + i2);
                System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                offsetFullSpansForAddition(i, i2);
            }
        }

        void offsetForRemoval(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                ensureSize(i + i2);
                System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                offsetFullSpansForRemoval(i, i2);
            }
        }

        void setSpan(int i, Span span) {
            ensureSize(i);
            this.mData[i] = span.mIndex;
        }

        int sizeForPosition(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS;
            }
            return length;
        }
    }

    public class SavedState implements Parcelable {
        public static final Creator<SavedState> CREATOR;
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1 */
        final class C05181 implements Creator<SavedState> {
            C05181() {
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        static {
            CREATOR = new C05181();
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            this.mAnchorPosition = parcel.readInt();
            this.mVisibleAnchorPosition = parcel.readInt();
            this.mSpanOffsetsSize = parcel.readInt();
            if (this.mSpanOffsetsSize > 0) {
                this.mSpanOffsets = new int[this.mSpanOffsetsSize];
                parcel.readIntArray(this.mSpanOffsets);
            }
            this.mSpanLookupSize = parcel.readInt();
            if (this.mSpanLookupSize > 0) {
                this.mSpanLookup = new int[this.mSpanLookupSize];
                parcel.readIntArray(this.mSpanLookup);
            }
            this.mReverseLayout = parcel.readInt() == StaggeredGridLayoutManager.VERTICAL ? true : StaggeredGridLayoutManager.DEBUG;
            this.mAnchorLayoutFromEnd = parcel.readInt() == StaggeredGridLayoutManager.VERTICAL ? true : StaggeredGridLayoutManager.DEBUG;
            if (parcel.readInt() != StaggeredGridLayoutManager.VERTICAL) {
                z = StaggeredGridLayoutManager.DEBUG;
            }
            this.mLastLayoutRTL = z;
            this.mFullSpanItems = parcel.readArrayList(FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.mSpanOffsetsSize = savedState.mSpanOffsetsSize;
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mVisibleAnchorPosition = savedState.mVisibleAnchorPosition;
            this.mSpanOffsets = savedState.mSpanOffsets;
            this.mSpanLookupSize = savedState.mSpanLookupSize;
            this.mSpanLookup = savedState.mSpanLookup;
            this.mReverseLayout = savedState.mReverseLayout;
            this.mAnchorLayoutFromEnd = savedState.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = savedState.mLastLayoutRTL;
            this.mFullSpanItems = savedState.mFullSpanItems;
        }

        public int describeContents() {
            return StaggeredGridLayoutManager.HORIZONTAL;
        }

        void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = StaggeredGridLayoutManager.HORIZONTAL;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = StaggeredGridLayoutManager.HORIZONTAL;
            this.mSpanLookupSize = StaggeredGridLayoutManager.HORIZONTAL;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = StaggeredGridLayoutManager.VERTICAL;
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mVisibleAnchorPosition);
            parcel.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize > 0) {
                parcel.writeIntArray(this.mSpanOffsets);
            }
            parcel.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize > 0) {
                parcel.writeIntArray(this.mSpanLookup);
            }
            parcel.writeInt(this.mReverseLayout ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);
            parcel.writeInt(this.mAnchorLayoutFromEnd ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);
            if (!this.mLastLayoutRTL) {
                i2 = StaggeredGridLayoutManager.HORIZONTAL;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.mFullSpanItems);
        }
    }

    class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        private ArrayList<View> mViews;

        private Span(int i) {
            this.mViews = new ArrayList();
            this.mCachedStart = INVALID_LINE;
            this.mCachedEnd = INVALID_LINE;
            this.mDeletedSize = StaggeredGridLayoutManager.HORIZONTAL;
            this.mIndex = i;
        }

        void appendToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(view);
            this.mCachedEnd = INVALID_LINE;
            if (this.mViews.size() == StaggeredGridLayoutManager.VERTICAL) {
                this.mCachedStart = INVALID_LINE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        void cacheReferenceLineAndClear(boolean z, int i) {
            int endLine = z ? getEndLine(INVALID_LINE) : getStartLine(INVALID_LINE);
            clear();
            if (endLine != INVALID_LINE) {
                if (z && endLine < StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding()) {
                    return;
                }
                if (z || endLine <= StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding()) {
                    if (i != INVALID_LINE) {
                        endLine += i;
                    }
                    this.mCachedEnd = endLine;
                    this.mCachedStart = endLine;
                }
            }
        }

        void calculateCachedEnd() {
            View view = (View) this.mViews.get(this.mViews.size() - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
            if (layoutParams.mFullSpan) {
                FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
                if (fullSpanItem != null && fullSpanItem.mGapDir == StaggeredGridLayoutManager.VERTICAL) {
                    this.mCachedEnd = fullSpanItem.getGapForSpan(this.mIndex) + this.mCachedEnd;
                }
            }
        }

        void calculateCachedStart() {
            View view = (View) this.mViews.get(StaggeredGridLayoutManager.HORIZONTAL);
            LayoutParams layoutParams = getLayoutParams(view);
            this.mCachedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
            if (layoutParams.mFullSpan) {
                FullSpanItem fullSpanItem = StaggeredGridLayoutManager.this.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition());
                if (fullSpanItem != null && fullSpanItem.mGapDir == -1) {
                    this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
                }
            }
        }

        void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = StaggeredGridLayoutManager.HORIZONTAL;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? findOneVisibleChild(this.mViews.size() - 1, -1, true) : findOneVisibleChild(StaggeredGridLayoutManager.HORIZONTAL, this.mViews.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? findOneVisibleChild(this.mViews.size() - 1, -1, StaggeredGridLayoutManager.DEBUG) : findOneVisibleChild(StaggeredGridLayoutManager.HORIZONTAL, this.mViews.size(), StaggeredGridLayoutManager.DEBUG);
        }

        public int findLastCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? findOneVisibleChild(StaggeredGridLayoutManager.HORIZONTAL, this.mViews.size(), true) : findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.mReverseLayout ? findOneVisibleChild(StaggeredGridLayoutManager.HORIZONTAL, this.mViews.size(), StaggeredGridLayoutManager.DEBUG) : findOneVisibleChild(this.mViews.size() - 1, -1, StaggeredGridLayoutManager.DEBUG);
        }

        int findOneVisibleChild(int i, int i2, boolean z) {
            int startAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.mPrimaryOrientation.getEndAfterPadding();
            int i3 = i2 > i ? StaggeredGridLayoutManager.VERTICAL : -1;
            while (i != i2) {
                View view = (View) this.mViews.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view);
                if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                    if (!z) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        int getEndLine() {
            if (this.mCachedEnd != INVALID_LINE) {
                return this.mCachedEnd;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        int getEndLine(int i) {
            if (this.mCachedEnd != INVALID_LINE) {
                return this.mCachedEnd;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        LayoutParams getLayoutParams(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        int getNormalizedOffset(int i, int i2, int i3) {
            if (this.mViews.size() == 0) {
                return StaggeredGridLayoutManager.HORIZONTAL;
            }
            int endLine;
            if (i < 0) {
                endLine = getEndLine() - i3;
                return endLine <= 0 ? StaggeredGridLayoutManager.HORIZONTAL : (-i) > endLine ? -endLine : i;
            } else {
                endLine = i2 - getStartLine();
                return endLine <= 0 ? StaggeredGridLayoutManager.HORIZONTAL : endLine < i ? endLine : i;
            }
        }

        int getStartLine() {
            if (this.mCachedStart != INVALID_LINE) {
                return this.mCachedStart;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        int getStartLine(int i) {
            if (this.mCachedStart != INVALID_LINE) {
                return this.mCachedStart;
            }
            if (this.mViews.size() == 0) {
                return i;
            }
            calculateCachedStart();
            return this.mCachedStart;
        }

        void invalidateCache() {
            this.mCachedStart = INVALID_LINE;
            this.mCachedEnd = INVALID_LINE;
        }

        boolean isEmpty(int i, int i2) {
            int size = this.mViews.size();
            for (int i3 = StaggeredGridLayoutManager.HORIZONTAL; i3 < size; i3 += StaggeredGridLayoutManager.VERTICAL) {
                View view = (View) this.mViews.get(i3);
                if (StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedStart(view) < i2 && StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedEnd(view) > i) {
                    return StaggeredGridLayoutManager.DEBUG;
                }
            }
            return true;
        }

        void onOffset(int i) {
            if (this.mCachedStart != INVALID_LINE) {
                this.mCachedStart += i;
            }
            if (this.mCachedEnd != INVALID_LINE) {
                this.mCachedEnd += i;
            }
        }

        void popEnd() {
            int size = this.mViews.size();
            View view = (View) this.mViews.remove(size - 1);
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = null;
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            if (size == StaggeredGridLayoutManager.VERTICAL) {
                this.mCachedStart = INVALID_LINE;
            }
            this.mCachedEnd = INVALID_LINE;
        }

        void popStart() {
            View view = (View) this.mViews.remove(StaggeredGridLayoutManager.HORIZONTAL);
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = null;
            if (this.mViews.size() == 0) {
                this.mCachedEnd = INVALID_LINE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize -= StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
            this.mCachedStart = INVALID_LINE;
        }

        void prependToSpan(View view) {
            LayoutParams layoutParams = getLayoutParams(view);
            layoutParams.mSpan = this;
            this.mViews.add(StaggeredGridLayoutManager.HORIZONTAL, view);
            this.mCachedStart = INVALID_LINE;
            if (this.mViews.size() == StaggeredGridLayoutManager.VERTICAL) {
                this.mCachedEnd = INVALID_LINE;
            }
            if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
                this.mDeletedSize += StaggeredGridLayoutManager.this.mPrimaryOrientation.getDecoratedMeasurement(view);
            }
        }

        void setLine(int i) {
            this.mCachedStart = i;
            this.mCachedEnd = i;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.mSpanCount = -1;
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo();
        this.mLaidOutInvalidFullSpan = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new C05151();
        this.mOrientation = i2;
        setSpanCount(i);
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mSpanCount = -1;
        this.mReverseLayout = DEBUG;
        this.mShouldReverseLayout = DEBUG;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo();
        this.mLaidOutInvalidFullSpan = DEBUG;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new C05151();
        Properties properties = LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
    }

    private void appendViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].appendToSpan(view);
        }
    }

    private void applyPendingSavedState(AnchorInfo anchorInfo) {
        if (this.mPendingSavedState.mSpanOffsetsSize > 0) {
            if (this.mPendingSavedState.mSpanOffsetsSize == this.mSpanCount) {
                for (int i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
                    this.mSpans[i].clear();
                    int i2 = this.mPendingSavedState.mSpanOffsets[i];
                    if (i2 != INVALID_OFFSET) {
                        i2 = this.mPendingSavedState.mAnchorLayoutFromEnd ? i2 + this.mPrimaryOrientation.getEndAfterPadding() : i2 + this.mPrimaryOrientation.getStartAfterPadding();
                    }
                    this.mSpans[i].setLine(i2);
                }
            } else {
                this.mPendingSavedState.invalidateSpanInfo();
                this.mPendingSavedState.mAnchorPosition = this.mPendingSavedState.mVisibleAnchorPosition;
            }
        }
        this.mLastLayoutRTL = this.mPendingSavedState.mLastLayoutRTL;
        setReverseLayout(this.mPendingSavedState.mReverseLayout);
        resolveShouldLayoutReverse();
        if (this.mPendingSavedState.mAnchorPosition != -1) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            anchorInfo.mLayoutFromEnd = this.mPendingSavedState.mAnchorLayoutFromEnd;
        } else {
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (this.mPendingSavedState.mSpanLookupSize > VERTICAL) {
            this.mLazySpanLookup.mData = this.mPendingSavedState.mSpanLookup;
            this.mLazySpanLookup.mFullSpanItems = this.mPendingSavedState.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, LayoutParams layoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == VERTICAL) {
            if (layoutParams.mFullSpan) {
                appendViewToAllSpans(view);
            } else {
                layoutParams.mSpan.appendToSpan(view);
            }
        } else if (layoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            layoutParams.mSpan.prependToSpan(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i) {
        int i2 = -1;
        if (getChildCount() == 0) {
            return this.mShouldReverseLayout ? VERTICAL : -1;
        } else {
            if ((i < getFirstChildPosition() ? VERTICAL : DEBUG) == this.mShouldReverseLayout) {
                i2 = VERTICAL;
            }
            return i2;
        }
    }

    private boolean checkForGaps() {
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return DEBUG;
        }
        int lastChildPosition;
        int firstChildPosition;
        if (this.mShouldReverseLayout) {
            lastChildPosition = getLastChildPosition();
            firstChildPosition = getFirstChildPosition();
        } else {
            lastChildPosition = getFirstChildPosition();
            firstChildPosition = getLastChildPosition();
        }
        if (lastChildPosition == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (!this.mLaidOutInvalidFullSpan) {
            return DEBUG;
        } else {
            int i = this.mShouldReverseLayout ? -1 : VERTICAL;
            FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(lastChildPosition, firstChildPosition + VERTICAL, i, true);
            if (firstFullSpanItemInRange == null) {
                this.mLaidOutInvalidFullSpan = DEBUG;
                this.mLazySpanLookup.forceInvalidateAfter(firstChildPosition + VERTICAL);
                return DEBUG;
            }
            FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(lastChildPosition, firstFullSpanItemInRange.mPosition, i * -1, true);
            if (firstFullSpanItemInRange2 == null) {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
            } else {
                this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + VERTICAL);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
    }

    private boolean checkSpanForGap(Span span) {
        if (this.mShouldReverseLayout) {
            if (span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                return true;
            }
        } else if (span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
            return true;
        }
        return DEBUG;
    }

    private int computeScrollExtent(State state) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureOrientationHelper();
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ScrollbarHelper.computeScrollExtent(state, orientationHelper, findFirstVisibleItemClosestToStart, findFirstVisibleItemClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(State state) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureOrientationHelper();
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ScrollbarHelper.computeScrollOffset(state, orientationHelper, findFirstVisibleItemClosestToStart, findFirstVisibleItemClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(State state) {
        boolean z = DEBUG;
        if (getChildCount() == 0) {
            return HORIZONTAL;
        }
        ensureOrientationHelper();
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled ? true : DEBUG, true);
        if (!this.mSmoothScrollbarEnabled) {
            z = true;
        }
        return ScrollbarHelper.computeScrollRange(state, orientationHelper, findFirstVisibleItemClosestToStart, findFirstVisibleItemClosestToEnd(z, true), this, this.mSmoothScrollbarEnabled);
    }

    private FullSpanItem createFullSpanItemFromEnd(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = HORIZONTAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            fullSpanItem.mGapPerSpan[i2] = i - this.mSpans[i2].getEndLine(i);
        }
        return fullSpanItem;
    }

    private FullSpanItem createFullSpanItemFromStart(int i) {
        FullSpanItem fullSpanItem = new FullSpanItem();
        fullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = HORIZONTAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            fullSpanItem.mGapPerSpan[i2] = this.mSpans[i2].getStartLine(i) - i;
        }
        return fullSpanItem;
    }

    private void ensureOrientationHelper() {
        if (this.mPrimaryOrientation == null) {
            this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
            this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
            this.mLayoutState = new LayoutState();
        }
    }

    private int fill(Recycler recycler, LayoutState layoutState, State state) {
        int maxEnd;
        this.mRemainingSpans.set(HORIZONTAL, this.mSpanCount, true);
        int i = layoutState.mLayoutDirection == VERTICAL ? layoutState.mEndLine + layoutState.mAvailable : layoutState.mStartLine - layoutState.mAvailable;
        updateAllRemainingSpans(layoutState.mLayoutDirection, i);
        int endAfterPadding = this.mShouldReverseLayout ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
        Object obj = null;
        while (layoutState.hasMore(state) && !this.mRemainingSpans.isEmpty()) {
            Span span;
            int decoratedMeasurement;
            View next = layoutState.next(recycler);
            LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int span2 = this.mLazySpanLookup.getSpan(viewLayoutPosition);
            Object obj2 = span2 == -1 ? VERTICAL : HORIZONTAL;
            if (obj2 != null) {
                Span nextSpan = layoutParams.mFullSpan ? this.mSpans[HORIZONTAL] : getNextSpan(layoutState);
                this.mLazySpanLookup.setSpan(viewLayoutPosition, nextSpan);
                span = nextSpan;
            } else {
                span = this.mSpans[span2];
            }
            layoutParams.mSpan = span;
            if (layoutState.mLayoutDirection == VERTICAL) {
                addView(next);
            } else {
                addView(next, HORIZONTAL);
            }
            measureChildWithDecorationsAndMargin(next, layoutParams);
            if (layoutState.mLayoutDirection == VERTICAL) {
                maxEnd = layoutParams.mFullSpan ? getMaxEnd(endAfterPadding) : span.getEndLine(endAfterPadding);
                decoratedMeasurement = maxEnd + this.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (obj2 == null || !layoutParams.mFullSpan) {
                    span2 = maxEnd;
                } else {
                    FullSpanItem createFullSpanItemFromEnd = createFullSpanItemFromEnd(maxEnd);
                    createFullSpanItemFromEnd.mGapDir = -1;
                    createFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromEnd);
                    span2 = maxEnd;
                }
            } else {
                maxEnd = layoutParams.mFullSpan ? getMinStart(endAfterPadding) : span.getStartLine(endAfterPadding);
                span2 = maxEnd - this.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (obj2 != null && layoutParams.mFullSpan) {
                    FullSpanItem createFullSpanItemFromStart = createFullSpanItemFromStart(maxEnd);
                    createFullSpanItemFromStart.mGapDir = VERTICAL;
                    createFullSpanItemFromStart.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(createFullSpanItemFromStart);
                }
                decoratedMeasurement = maxEnd;
            }
            if (layoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                if (obj2 != null) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    obj = layoutState.mLayoutDirection == VERTICAL ? !areAllEndsEqual() ? VERTICAL : null : !areAllStartsEqual() ? VERTICAL : null;
                    if (obj != null) {
                        FullSpanItem fullSpanItem = this.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            attachViewToSpans(next, layoutParams, layoutState);
            int startAfterPadding = layoutParams.mFullSpan ? this.mSecondaryOrientation.getStartAfterPadding() : this.mSecondaryOrientation.getStartAfterPadding() + (span.mIndex * this.mSizePerSpan);
            viewLayoutPosition = startAfterPadding + this.mSecondaryOrientation.getDecoratedMeasurement(next);
            if (this.mOrientation == VERTICAL) {
                layoutDecoratedWithMargins(next, startAfterPadding, span2, viewLayoutPosition, decoratedMeasurement);
            } else {
                layoutDecoratedWithMargins(next, span2, startAfterPadding, decoratedMeasurement, viewLayoutPosition);
            }
            if (layoutParams.mFullSpan) {
                updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i);
            } else {
                updateRemainingSpans(span, this.mLayoutState.mLayoutDirection, i);
            }
            recycle(recycler, this.mLayoutState);
            obj = VERTICAL;
        }
        if (obj == null) {
            recycle(recycler, this.mLayoutState);
        }
        maxEnd = this.mLayoutState.mLayoutDirection == -1 ? this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding()) : getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        return maxEnd > 0 ? Math.min(layoutState.mAvailable, maxEnd) : HORIZONTAL;
    }

    private int findFirstReferenceChildPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = HORIZONTAL; i2 < childCount; i2 += VERTICAL) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return HORIZONTAL;
    }

    private int findLastReferenceChildPosition(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return HORIZONTAL;
    }

    private void fixEndGap(Recycler recycler, State state, boolean z) {
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding());
        if (endAfterPadding > 0) {
            endAfterPadding -= -scrollBy(-endAfterPadding, recycler, state);
            if (z && endAfterPadding > 0) {
                this.mPrimaryOrientation.offsetChildren(endAfterPadding);
            }
        }
    }

    private void fixStartGap(Recycler recycler, State state, boolean z) {
        int minStart = getMinStart(this.mPrimaryOrientation.getStartAfterPadding()) - this.mPrimaryOrientation.getStartAfterPadding();
        if (minStart > 0) {
            minStart -= scrollBy(minStart, recycler, state);
            if (z && minStart > 0) {
                this.mPrimaryOrientation.offsetChildren(-minStart);
            }
        }
    }

    private int getFirstChildPosition() {
        return getChildCount() == 0 ? HORIZONTAL : getPosition(getChildAt(HORIZONTAL));
    }

    private int getLastChildPosition() {
        int childCount = getChildCount();
        return childCount == 0 ? HORIZONTAL : getPosition(getChildAt(childCount - 1));
    }

    private int getMaxEnd(int i) {
        int endLine = this.mSpans[HORIZONTAL].getEndLine(i);
        for (int i2 = VERTICAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i) {
        int startLine = this.mSpans[HORIZONTAL].getStartLine(i);
        for (int i2 = VERTICAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i) {
        int endLine = this.mSpans[HORIZONTAL].getEndLine(i);
        for (int i2 = VERTICAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i) {
        int startLine = this.mSpans[HORIZONTAL].getStartLine(i);
        for (int i2 = VERTICAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private Span getNextSpan(LayoutState layoutState) {
        int i;
        int i2;
        Span span = null;
        int i3 = -1;
        if (preferLastSpan(layoutState.mLayoutDirection)) {
            i = this.mSpanCount - 1;
            i2 = -1;
        } else {
            i = HORIZONTAL;
            i2 = this.mSpanCount;
            i3 = VERTICAL;
        }
        int startAfterPadding;
        int i4;
        Span span2;
        int endLine;
        Span span3;
        if (layoutState.mLayoutDirection == VERTICAL) {
            startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                span2 = this.mSpans[i4];
                endLine = span2.getEndLine(startAfterPadding);
                if (endLine < i) {
                    span3 = span2;
                } else {
                    endLine = i;
                    span3 = span;
                }
                i4 += i3;
                span = span3;
                i = endLine;
            }
        } else {
            startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
            i4 = i;
            i = INVALID_OFFSET;
            while (i4 != i2) {
                span2 = this.mSpans[i4];
                endLine = span2.getStartLine(startAfterPadding);
                if (endLine > i) {
                    span3 = span2;
                } else {
                    endLine = i;
                    span3 = span;
                }
                i4 += i3;
                span = span3;
                i = endLine;
            }
        }
        return span;
    }

    private int getSpecForDimension(int i, int i2) {
        return i < 0 ? i2 : MeasureSpec.makeMeasureSpec(i, 1073741824);
    }

    private void handleUpdate(int i, int i2, int i3) {
        int i4;
        int i5;
        int lastChildPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + VERTICAL;
            i5 = i;
        } else {
            i4 = i + VERTICAL;
            i5 = i2;
        }
        this.mLazySpanLookup.invalidateAfter(i5);
        switch (i3) {
            case VERTICAL /*1*/:
                this.mLazySpanLookup.offsetForAddition(i, i2);
                break;
            case GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS /*2*/:
                this.mLazySpanLookup.offsetForRemoval(i, i2);
                break;
            case Version.API08_FROYO_22 /*8*/:
                this.mLazySpanLookup.offsetForRemoval(i, VERTICAL);
                this.mLazySpanLookup.offsetForAddition(i2, VERTICAL);
                break;
        }
        if (i4 > lastChildPosition) {
            if (i5 <= (this.mShouldReverseLayout ? getFirstChildPosition() : getLastChildPosition())) {
                requestLayout();
            }
        }
    }

    private void layoutDecoratedWithMargins(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        layoutDecorated(view, i + layoutParams.leftMargin, i2 + layoutParams.topMargin, i3 - layoutParams.rightMargin, i4 - layoutParams.bottomMargin);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        view.measure(updateSpecWithExtra(i, layoutParams.leftMargin + this.mTmpRect.left, layoutParams.rightMargin + this.mTmpRect.right), updateSpecWithExtra(i2, layoutParams.topMargin + this.mTmpRect.top, layoutParams.bottomMargin + this.mTmpRect.bottom));
    }

    private void measureChildWithDecorationsAndMargin(View view, LayoutParams layoutParams) {
        if (layoutParams.mFullSpan) {
            if (this.mOrientation == VERTICAL) {
                measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, getSpecForDimension(layoutParams.height, this.mHeightSpec));
            } else {
                measureChildWithDecorationsAndMargin(view, getSpecForDimension(layoutParams.width, this.mWidthSpec), this.mFullSizeSpec);
            }
        } else if (this.mOrientation == VERTICAL) {
            measureChildWithDecorationsAndMargin(view, this.mWidthSpec, getSpecForDimension(layoutParams.height, this.mHeightSpec));
        } else {
            measureChildWithDecorationsAndMargin(view, getSpecForDimension(layoutParams.width, this.mWidthSpec), this.mHeightSpec);
        }
    }

    private boolean preferLastSpan(int i) {
        if (this.mOrientation == 0) {
            return (i == -1 ? true : HORIZONTAL) != this.mShouldReverseLayout ? true : DEBUG;
        } else {
            return ((i == -1 ? true : HORIZONTAL) == this.mShouldReverseLayout ? true : HORIZONTAL) != isLayoutRTL() ? DEBUG : true;
        }
    }

    private void prependViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].prependToSpan(view);
        }
    }

    private void recycle(Recycler recycler, LayoutState layoutState) {
        if (layoutState.mAvailable == 0) {
            if (layoutState.mLayoutDirection == -1) {
                recycleFromEnd(recycler, layoutState.mEndLine);
            } else {
                recycleFromStart(recycler, layoutState.mStartLine);
            }
        } else if (layoutState.mLayoutDirection == -1) {
            r0 = layoutState.mStartLine - getMaxStart(layoutState.mStartLine);
            recycleFromEnd(recycler, r0 < 0 ? layoutState.mEndLine : layoutState.mEndLine - Math.min(r0, layoutState.mAvailable));
        } else {
            r0 = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
            recycleFromStart(recycler, r0 < 0 ? layoutState.mStartLine : Math.min(r0, layoutState.mAvailable) + layoutState.mStartLine);
        }
    }

    private void recycleFromEnd(Recycler recycler, int i) {
        int childCount = getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i2 = HORIZONTAL;
                    while (i2 < this.mSpanCount) {
                        if (this.mSpans[i2].mViews.size() != VERTICAL) {
                            i2 += VERTICAL;
                        } else {
                            return;
                        }
                    }
                    for (i2 = HORIZONTAL; i2 < this.mSpanCount; i2 += VERTICAL) {
                        this.mSpans[i2].popEnd();
                    }
                } else if (layoutParams.mSpan.mViews.size() != VERTICAL) {
                    layoutParams.mSpan.popEnd();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
                childCount--;
            } else {
                return;
            }
        }
    }

    private void recycleFromStart(Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(HORIZONTAL);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.mFullSpan) {
                    int i2 = HORIZONTAL;
                    while (i2 < this.mSpanCount) {
                        if (this.mSpans[i2].mViews.size() != VERTICAL) {
                            i2 += VERTICAL;
                        } else {
                            return;
                        }
                    }
                    for (i2 = HORIZONTAL; i2 < this.mSpanCount; i2 += VERTICAL) {
                        this.mSpans[i2].popStart();
                    }
                } else if (layoutParams.mSpan.mViews.size() != VERTICAL) {
                    layoutParams.mSpan.popStart();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        boolean z = true;
        if (this.mOrientation == VERTICAL || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
            return;
        }
        if (this.mReverseLayout) {
            z = DEBUG;
        }
        this.mShouldReverseLayout = z;
    }

    private void setLayoutStateDirection(int i) {
        int i2 = VERTICAL;
        this.mLayoutState.mLayoutDirection = i;
        LayoutState layoutState = this.mLayoutState;
        if (this.mShouldReverseLayout != (i == -1 ? VERTICAL : DEBUG)) {
            i2 = -1;
        }
        layoutState.mItemDirection = i2;
    }

    private void updateAllRemainingSpans(int i, int i2) {
        for (int i3 = HORIZONTAL; i3 < this.mSpanCount; i3 += VERTICAL) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2);
            }
        }
    }

    private boolean updateAnchorFromChildren(State state, AnchorInfo anchorInfo) {
        anchorInfo.mPosition = this.mLastLayoutFromEnd ? findLastReferenceChildPosition(state.getItemCount()) : findFirstReferenceChildPosition(state.getItemCount());
        anchorInfo.mOffset = INVALID_OFFSET;
        return true;
    }

    private void updateLayoutState(int i, State state) {
        int targetScrollPosition;
        int i2 = HORIZONTAL;
        this.mLayoutState.mAvailable = HORIZONTAL;
        this.mLayoutState.mCurrentPosition = i;
        if (isSmoothScrolling()) {
            targetScrollPosition = state.getTargetScrollPosition();
            if (targetScrollPosition != -1) {
                if (this.mShouldReverseLayout == (targetScrollPosition < i ? true : HORIZONTAL)) {
                    targetScrollPosition = this.mPrimaryOrientation.getTotalSpace();
                } else {
                    i2 = this.mPrimaryOrientation.getTotalSpace();
                    targetScrollPosition = HORIZONTAL;
                }
                if (getClipToPadding()) {
                    this.mLayoutState.mEndLine = targetScrollPosition + this.mPrimaryOrientation.getEnd();
                    this.mLayoutState.mStartLine = -i2;
                    return;
                }
                this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i2;
                this.mLayoutState.mEndLine = targetScrollPosition + this.mPrimaryOrientation.getEndAfterPadding();
            }
        }
        targetScrollPosition = HORIZONTAL;
        if (getClipToPadding()) {
            this.mLayoutState.mEndLine = targetScrollPosition + this.mPrimaryOrientation.getEnd();
            this.mLayoutState.mStartLine = -i2;
            return;
        }
        this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - i2;
        this.mLayoutState.mEndLine = targetScrollPosition + this.mPrimaryOrientation.getEndAfterPadding();
    }

    private void updateRemainingSpans(Span span, int i, int i2) {
        int deletedSize = span.getDeletedSize();
        if (i == -1) {
            if (deletedSize + span.getStartLine() <= i2) {
                this.mRemainingSpans.set(span.mIndex, DEBUG);
            }
        } else if (span.getEndLine() - deletedSize >= i2) {
            this.mRemainingSpans.set(span.mIndex, DEBUG);
        }
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == INVALID_OFFSET || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(HORIZONTAL, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    boolean areAllEndsEqual() {
        int endLine = this.mSpans[HORIZONTAL].getEndLine(INVALID_OFFSET);
        for (int i = VERTICAL; i < this.mSpanCount; i += VERTICAL) {
            if (this.mSpans[i].getEndLine(INVALID_OFFSET) != endLine) {
                return DEBUG;
            }
        }
        return true;
    }

    boolean areAllStartsEqual() {
        int startLine = this.mSpans[HORIZONTAL].getStartLine(INVALID_OFFSET);
        for (int i = VERTICAL; i < this.mSpanCount; i += VERTICAL) {
            if (this.mSpans[i].getStartLine(INVALID_OFFSET) != startLine) {
                return DEBUG;
            }
        }
        return true;
    }

    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public boolean canScrollHorizontally() {
        return this.mOrientation == 0 ? true : DEBUG;
    }

    public boolean canScrollVertically() {
        return this.mOrientation == VERTICAL ? true : DEBUG;
    }

    public boolean checkLayoutParams(android.support.v7.widget.RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int computeHorizontalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeHorizontalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeHorizontalScrollRange(State state) {
        return computeScrollRange(state);
    }

    public int computeVerticalScrollExtent(State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollOffset(State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollRange(State state) {
        return computeScrollRange(state);
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
            iArr[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    View findFirstVisibleItemClosestToEnd(boolean z, boolean z2) {
        ensureOrientationHelper();
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    View findFirstVisibleItemClosestToStart(boolean z, boolean z2) {
        ensureOrientationHelper();
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = HORIZONTAL; i < childCount; i += VERTICAL) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    int findFirstVisibleItemPositionInt() {
        View findFirstVisibleItemClosestToEnd = this.mShouldReverseLayout ? findFirstVisibleItemClosestToEnd(true, true) : findFirstVisibleItemClosestToStart(true, true);
        return findFirstVisibleItemClosestToEnd == null ? -1 : getPosition(findFirstVisibleItemClosestToEnd);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
            iArr[i] = this.mSpans[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
            iArr[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + iArr.length);
        }
        for (int i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
            iArr[i] = this.mSpans[i].findLastVisibleItemPosition();
        }
        return iArr;
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
        return this.mOrientation == VERTICAL ? this.mSpanCount : super.getColumnCountForAccessibility(recycler, state);
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getRowCountForAccessibility(Recycler recycler, State state) {
        return this.mOrientation == 0 ? this.mSpanCount : super.getRowCountForAccessibility(recycler, state);
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    View hasGapsToFix() {
        int i;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(HORIZONTAL, this.mSpanCount, true);
        boolean z = (this.mOrientation == VERTICAL && isLayoutRTL()) ? true : true;
        if (this.mShouldReverseLayout) {
            i = -1;
        } else {
            i = childCount + VERTICAL;
            childCount = HORIZONTAL;
        }
        int i2 = childCount < i ? VERTICAL : -1;
        int i3 = childCount;
        while (i3 != i) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.mSpan.mIndex)) {
                if (checkSpanForGap(layoutParams.mSpan)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.mSpan.mIndex);
            }
            if (!(layoutParams.mFullSpan || i3 + i2 == i)) {
                boolean z2;
                View childAt2 = getChildAt(i3 + i2);
                int decoratedEnd;
                if (this.mShouldReverseLayout) {
                    childCount = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (childCount < decoratedEnd) {
                        return childAt;
                    }
                    if (childCount == decoratedEnd) {
                        z2 = true;
                    }
                    z2 = HORIZONTAL;
                } else {
                    childCount = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    decoratedEnd = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (childCount > decoratedEnd) {
                        return childAt;
                    }
                    if (childCount == decoratedEnd) {
                        z2 = true;
                    }
                    z2 = HORIZONTAL;
                }
                if (z2) {
                    if ((layoutParams.mSpan.mIndex - ((LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0 ? true : HORIZONTAL) != (z >= false ? true : HORIZONTAL)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == VERTICAL ? true : DEBUG;
    }

    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = HORIZONTAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            this.mSpans[i2].onOffset(i);
        }
    }

    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = HORIZONTAL; i2 < this.mSpanCount; i2 += VERTICAL) {
            this.mSpans[i2].onOffset(i);
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, Recycler recycler) {
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
            this.mSpans[i].clear();
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            am a = C0278a.m1865a(accessibilityEvent);
            View findFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(DEBUG, true);
            View findFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(DEBUG, true);
            if (findFirstVisibleItemClosestToStart != null && findFirstVisibleItemClosestToEnd != null) {
                int position = getPosition(findFirstVisibleItemClosestToStart);
                int position2 = getPosition(findFirstVisibleItemClosestToEnd);
                if (position < position2) {
                    a.m1891b(position);
                    a.m1892c(position2);
                    return;
                }
                a.m1891b(position2);
                a.m1892c(position);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(Recycler recycler, State state, View view, C0284g c0284g) {
        android.view.ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (this.mOrientation == 0) {
                c0284g.m1961c(C0296s.m2146a(layoutParams2.getSpanIndex(), layoutParams2.mFullSpan ? this.mSpanCount : VERTICAL, -1, -1, layoutParams2.mFullSpan, DEBUG));
                return;
            } else {
                c0284g.m1961c(C0296s.m2146a(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.mFullSpan ? this.mSpanCount : VERTICAL, layoutParams2.mFullSpan, DEBUG));
                return;
            }
        }
        super.onInitializeAccessibilityNodeInfoForItem(view, c0284g);
    }

    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, VERTICAL);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    public void onLayoutChildren(Recycler recycler, State state) {
        boolean z = DEBUG;
        ensureOrientationHelper();
        AnchorInfo anchorInfo = this.mAnchorInfo;
        anchorInfo.reset();
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.mPendingSavedState != null) {
            applyPendingSavedState(anchorInfo);
        } else {
            resolveShouldLayoutReverse();
            anchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        updateAnchorInfoForLayout(state, anchorInfo);
        if (this.mPendingSavedState == null && !(anchorInfo.mLayoutFromEnd == this.mLastLayoutFromEnd && isLayoutRTL() == this.mLastLayoutRTL)) {
            this.mLazySpanLookup.clear();
            anchorInfo.mInvalidateOffsets = true;
        }
        if (getChildCount() > 0 && (this.mPendingSavedState == null || this.mPendingSavedState.mSpanOffsetsSize < VERTICAL)) {
            int i;
            if (anchorInfo.mInvalidateOffsets) {
                for (i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
                    this.mSpans[i].clear();
                    if (anchorInfo.mOffset != INVALID_OFFSET) {
                        this.mSpans[i].setLine(anchorInfo.mOffset);
                    }
                }
            } else {
                for (i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
                    this.mSpans[i].cacheReferenceLineAndClear(this.mShouldReverseLayout, anchorInfo.mOffset);
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        this.mLaidOutInvalidFullSpan = DEBUG;
        updateMeasureSpecs();
        updateLayoutState(anchorInfo.mPosition, state);
        if (anchorInfo.mLayoutFromEnd) {
            setLayoutStateDirection(-1);
            fill(recycler, this.mLayoutState, state);
            setLayoutStateDirection(VERTICAL);
            this.mLayoutState.mCurrentPosition = anchorInfo.mPosition + this.mLayoutState.mItemDirection;
            fill(recycler, this.mLayoutState, state);
        } else {
            setLayoutStateDirection(VERTICAL);
            fill(recycler, this.mLayoutState, state);
            setLayoutStateDirection(-1);
            this.mLayoutState.mCurrentPosition = anchorInfo.mPosition + this.mLayoutState.mItemDirection;
            fill(recycler, this.mLayoutState, state);
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                fixEndGap(recycler, state, true);
                fixStartGap(recycler, state, DEBUG);
            } else {
                fixStartGap(recycler, state, true);
                fixEndGap(recycler, state, DEBUG);
            }
        }
        if (!state.isPreLayout()) {
            if (this.mGapStrategy != 0 && getChildCount() > 0 && (this.mLaidOutInvalidFullSpan || hasGapsToFix() != null)) {
                z = true;
            }
            if (z) {
                removeCallbacks(this.mCheckForGapsRunnable);
                postOnAnimation(this.mCheckForGapsRunnable);
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = INVALID_OFFSET;
        }
        this.mLastLayoutFromEnd = anchorInfo.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        this.mPendingSavedState = null;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        savedState.mReverseLayout = this.mReverseLayout;
        savedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        savedState.mLastLayoutRTL = this.mLastLayoutRTL;
        if (this.mLazySpanLookup == null || this.mLazySpanLookup.mData == null) {
            savedState.mSpanLookupSize = HORIZONTAL;
        } else {
            savedState.mSpanLookup = this.mLazySpanLookup.mData;
            savedState.mSpanLookupSize = savedState.mSpanLookup.length;
            savedState.mFullSpanItems = this.mLazySpanLookup.mFullSpanItems;
        }
        if (getChildCount() > 0) {
            ensureOrientationHelper();
            savedState.mAnchorPosition = this.mLastLayoutFromEnd ? getLastChildPosition() : getFirstChildPosition();
            savedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            savedState.mSpanOffsetsSize = this.mSpanCount;
            savedState.mSpanOffsets = new int[this.mSpanCount];
            for (int i = HORIZONTAL; i < this.mSpanCount; i += VERTICAL) {
                int endLine;
                if (this.mLastLayoutFromEnd) {
                    endLine = this.mSpans[i].getEndLine(INVALID_OFFSET);
                    if (endLine != INVALID_OFFSET) {
                        endLine -= this.mPrimaryOrientation.getEndAfterPadding();
                    }
                } else {
                    endLine = this.mSpans[i].getStartLine(INVALID_OFFSET);
                    if (endLine != INVALID_OFFSET) {
                        endLine -= this.mPrimaryOrientation.getStartAfterPadding();
                    }
                }
                savedState.mSpanOffsets[i] = endLine;
            }
        } else {
            savedState.mAnchorPosition = -1;
            savedState.mVisibleAnchorPosition = -1;
            savedState.mSpanOffsetsSize = HORIZONTAL;
        }
        return savedState;
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    int scrollBy(int i, Recycler recycler, State state) {
        int i2;
        int lastChildPosition;
        ensureOrientationHelper();
        if (i > 0) {
            i2 = VERTICAL;
            lastChildPosition = getLastChildPosition();
        } else {
            i2 = -1;
            lastChildPosition = getFirstChildPosition();
        }
        updateLayoutState(lastChildPosition, state);
        setLayoutStateDirection(i2);
        this.mLayoutState.mCurrentPosition = lastChildPosition + this.mLayoutState.mItemDirection;
        lastChildPosition = Math.abs(i);
        this.mLayoutState.mAvailable = lastChildPosition;
        i2 = fill(recycler, this.mLayoutState, state);
        if (lastChildPosition >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.mPrimaryOrientation.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        return i;
    }

    public int scrollHorizontallyBy(int i, Recycler recycler, State state) {
        return scrollBy(i, recycler, state);
    }

    public void scrollToPosition(int i) {
        if (!(this.mPendingSavedState == null || this.mPendingSavedState.mAnchorPosition == i)) {
            this.mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = INVALID_OFFSET;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.mPendingSavedState != null) {
            this.mPendingSavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        requestLayout();
    }

    public int scrollVerticallyBy(int i, Recycler recycler, State state) {
        return scrollBy(i, recycler, state);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.mGapStrategy) {
            if (i == 0 || i == GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS) {
                this.mGapStrategy = i;
                requestLayout();
                return;
            }
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
    }

    public void setOrientation(int i) {
        if (i == 0 || i == VERTICAL) {
            assertNotInLayoutOrScroll(null);
            if (i != this.mOrientation) {
                this.mOrientation = i;
                if (!(this.mPrimaryOrientation == null || this.mSecondaryOrientation == null)) {
                    OrientationHelper orientationHelper = this.mPrimaryOrientation;
                    this.mPrimaryOrientation = this.mSecondaryOrientation;
                    this.mSecondaryOrientation = orientationHelper;
                }
                requestLayout();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (!(this.mPendingSavedState == null || this.mPendingSavedState.mReverseLayout == z)) {
            this.mPendingSavedState.mReverseLayout = z;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new Span[this.mSpanCount];
            for (int i2 = HORIZONTAL; i2 < this.mSpanCount; i2 += VERTICAL) {
                this.mSpans[i2] = new Span(i2, null);
            }
            requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, State state, int i) {
        SmoothScroller c05162 = new C05162(recyclerView.getContext());
        c05162.setTargetPosition(i);
        startSmoothScroll(c05162);
    }

    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null ? true : DEBUG;
    }

    boolean updateAnchorFromPendingData(State state, AnchorInfo anchorInfo) {
        boolean z = DEBUG;
        if (state.isPreLayout() || this.mPendingScrollPosition == -1) {
            return DEBUG;
        }
        if (this.mPendingScrollPosition < 0 || this.mPendingScrollPosition >= state.getItemCount()) {
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = INVALID_OFFSET;
            return DEBUG;
        } else if (this.mPendingSavedState == null || this.mPendingSavedState.mAnchorPosition == -1 || this.mPendingSavedState.mSpanOffsetsSize < VERTICAL) {
            View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
            if (findViewByPosition != null) {
                anchorInfo.mPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
                if (this.mPendingScrollPositionOffset != INVALID_OFFSET) {
                    if (anchorInfo.mLayoutFromEnd) {
                        anchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                        return true;
                    }
                    anchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(findViewByPosition);
                    return true;
                } else if (this.mPrimaryOrientation.getDecoratedMeasurement(findViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                    anchorInfo.mOffset = anchorInfo.mLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                    return true;
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(findViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                    if (decoratedStart < 0) {
                        anchorInfo.mOffset = -decoratedStart;
                        return true;
                    }
                    decoratedStart = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(findViewByPosition);
                    if (decoratedStart < 0) {
                        anchorInfo.mOffset = decoratedStart;
                        return true;
                    }
                    anchorInfo.mOffset = INVALID_OFFSET;
                    return true;
                }
            }
            anchorInfo.mPosition = this.mPendingScrollPosition;
            if (this.mPendingScrollPositionOffset == INVALID_OFFSET) {
                if (calculateScrollDirectionForPosition(anchorInfo.mPosition) == VERTICAL) {
                    z = true;
                }
                anchorInfo.mLayoutFromEnd = z;
                anchorInfo.assignCoordinateFromPadding();
            } else {
                anchorInfo.assignCoordinateFromPadding(this.mPendingScrollPositionOffset);
            }
            anchorInfo.mInvalidateOffsets = true;
            return true;
        } else {
            anchorInfo.mOffset = INVALID_OFFSET;
            anchorInfo.mPosition = this.mPendingScrollPosition;
            return true;
        }
    }

    void updateAnchorInfoForLayout(State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingData(state, anchorInfo) && !updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            anchorInfo.mPosition = HORIZONTAL;
        }
    }

    void updateMeasureSpecs() {
        this.mSizePerSpan = this.mSecondaryOrientation.getTotalSpace() / this.mSpanCount;
        this.mFullSizeSpec = MeasureSpec.makeMeasureSpec(this.mSecondaryOrientation.getTotalSpace(), 1073741824);
        if (this.mOrientation == VERTICAL) {
            this.mWidthSpec = MeasureSpec.makeMeasureSpec(this.mSizePerSpan, 1073741824);
            this.mHeightSpec = MeasureSpec.makeMeasureSpec(HORIZONTAL, HORIZONTAL);
            return;
        }
        this.mHeightSpec = MeasureSpec.makeMeasureSpec(this.mSizePerSpan, 1073741824);
        this.mWidthSpec = MeasureSpec.makeMeasureSpec(HORIZONTAL, HORIZONTAL);
    }
}
