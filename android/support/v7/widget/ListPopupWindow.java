package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p015e.C0217q;
import android.support.v4.view.bf;
import android.support.v4.view.cb;
import android.support.v4.view.el;
import android.support.v4.widget.ao;
import android.support.v4.widget.ax;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0369l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.reflect.Method;
import mobi.mmdt.ott.C1317h;
import org.linphone.mediastream.Version;

public class ListPopupWindow {
    private static final boolean DEBUG = false;
    private static final int EXPAND_LIST_TIMEOUT = 250;
    public static final int INPUT_METHOD_FROM_FOCUSABLE = 0;
    public static final int INPUT_METHOD_NEEDED = 1;
    public static final int INPUT_METHOD_NOT_NEEDED = 2;
    public static final int MATCH_PARENT = -1;
    public static final int POSITION_PROMPT_ABOVE = 0;
    public static final int POSITION_PROMPT_BELOW = 1;
    private static final String TAG = "ListPopupWindow";
    public static final int WRAP_CONTENT = -2;
    private static Method sClipToWindowEnabledMethod;
    private static Method sGetMaxAvailableHeightMethod;
    private ListAdapter mAdapter;
    private Context mContext;
    private boolean mDropDownAlwaysVisible;
    private View mDropDownAnchorView;
    private int mDropDownGravity;
    private int mDropDownHeight;
    private int mDropDownHorizontalOffset;
    private DropDownListView mDropDownList;
    private Drawable mDropDownListHighlight;
    private int mDropDownVerticalOffset;
    private boolean mDropDownVerticalOffsetSet;
    private int mDropDownWidth;
    private int mDropDownWindowLayoutType;
    private boolean mForceIgnoreOutsideTouch;
    private final Handler mHandler;
    private final ListSelectorHider mHideSelector;
    private OnItemClickListener mItemClickListener;
    private OnItemSelectedListener mItemSelectedListener;
    private int mLayoutDirection;
    int mListItemExpandMaximum;
    private boolean mModal;
    private DataSetObserver mObserver;
    private PopupWindow mPopup;
    private int mPromptPosition;
    private View mPromptView;
    private final ResizePopupRunnable mResizePopupRunnable;
    private final PopupScrollListener mScrollListener;
    private Runnable mShowDropDownRunnable;
    private Rect mTempRect;
    private final PopupTouchInterceptor mTouchInterceptor;

    public abstract class ForwardingListener implements OnTouchListener {
        private int mActivePointerId;
        private Runnable mDisallowIntercept;
        private boolean mForwarding;
        private final int mLongPressTimeout;
        private final float mScaledTouchSlop;
        private final View mSrc;
        private final int mTapTimeout;
        private final int[] mTmpLocation;
        private Runnable mTriggerLongPress;
        private boolean mWasLongPress;

        class DisallowIntercept implements Runnable {
            private DisallowIntercept() {
            }

            public void run() {
                ForwardingListener.this.mSrc.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        class TriggerLongPress implements Runnable {
            private TriggerLongPress() {
            }

            public void run() {
                ForwardingListener.this.onLongPress();
            }
        }

        public ForwardingListener(View view) {
            this.mTmpLocation = new int[ListPopupWindow.INPUT_METHOD_NOT_NEEDED];
            this.mSrc = view;
            this.mScaledTouchSlop = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.mTapTimeout = ViewConfiguration.getTapTimeout();
            this.mLongPressTimeout = (this.mTapTimeout + ViewConfiguration.getLongPressTimeout()) / ListPopupWindow.INPUT_METHOD_NOT_NEEDED;
        }

        private void clearCallbacks() {
            if (this.mTriggerLongPress != null) {
                this.mSrc.removeCallbacks(this.mTriggerLongPress);
            }
            if (this.mDisallowIntercept != null) {
                this.mSrc.removeCallbacks(this.mDisallowIntercept);
            }
        }

        private void onLongPress() {
            clearCallbacks();
            View view = this.mSrc;
            if (view.isEnabled() && !view.isLongClickable() && onForwardingStarted()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, ListPopupWindow.POSITION_PROMPT_ABOVE);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.mForwarding = true;
                this.mWasLongPress = true;
            }
        }

        private boolean onTouchForwarded(MotionEvent motionEvent) {
            boolean z = true;
            View view = this.mSrc;
            ListPopupWindow popup = getPopup();
            if (popup == null || !popup.isShowing()) {
                return ListPopupWindow.DEBUG;
            }
            View access$600 = popup.mDropDownList;
            if (access$600 == null || !access$600.isShown()) {
                return ListPopupWindow.DEBUG;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            toGlobalMotionEvent(view, obtainNoHistory);
            toLocalMotionEvent(access$600, obtainNoHistory);
            boolean onForwardedEvent = access$600.onForwardedEvent(obtainNoHistory, this.mActivePointerId);
            obtainNoHistory.recycle();
            int a = bf.m2309a(motionEvent);
            boolean z2 = (a == ListPopupWindow.POSITION_PROMPT_BELOW || a == 3) ? ListPopupWindow.DEBUG : ListPopupWindow.POSITION_PROMPT_BELOW;
            if (!(onForwardedEvent && z2)) {
                z = ListPopupWindow.DEBUG;
            }
            return z;
        }

        private boolean onTouchObserved(MotionEvent motionEvent) {
            View view = this.mSrc;
            if (!view.isEnabled()) {
                return ListPopupWindow.DEBUG;
            }
            switch (bf.m2309a(motionEvent)) {
                case ListPopupWindow.POSITION_PROMPT_ABOVE /*0*/:
                    this.mActivePointerId = motionEvent.getPointerId(ListPopupWindow.POSITION_PROMPT_ABOVE);
                    this.mWasLongPress = ListPopupWindow.DEBUG;
                    if (this.mDisallowIntercept == null) {
                        this.mDisallowIntercept = new DisallowIntercept();
                    }
                    view.postDelayed(this.mDisallowIntercept, (long) this.mTapTimeout);
                    if (this.mTriggerLongPress == null) {
                        this.mTriggerLongPress = new TriggerLongPress();
                    }
                    view.postDelayed(this.mTriggerLongPress, (long) this.mLongPressTimeout);
                    return ListPopupWindow.DEBUG;
                case ListPopupWindow.POSITION_PROMPT_BELOW /*1*/:
                case Version.API03_CUPCAKE_15 /*3*/:
                    clearCallbacks();
                    return ListPopupWindow.DEBUG;
                case ListPopupWindow.INPUT_METHOD_NOT_NEEDED /*2*/:
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex < 0 || pointInView(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.mScaledTouchSlop)) {
                        return ListPopupWindow.DEBUG;
                    }
                    clearCallbacks();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return ListPopupWindow.DEBUG;
            }
        }

        private static boolean pointInView(View view, float f, float f2, float f3) {
            return (f < (-f3) || f2 < (-f3) || f >= ((float) (view.getRight() - view.getLeft())) + f3 || f2 >= ((float) (view.getBottom() - view.getTop())) + f3) ? ListPopupWindow.DEBUG : true;
        }

        private boolean toGlobalMotionEvent(View view, MotionEvent motionEvent) {
            int[] iArr = this.mTmpLocation;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[ListPopupWindow.POSITION_PROMPT_ABOVE], (float) iArr[ListPopupWindow.POSITION_PROMPT_BELOW]);
            return true;
        }

        private boolean toLocalMotionEvent(View view, MotionEvent motionEvent) {
            int[] iArr = this.mTmpLocation;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[ListPopupWindow.POSITION_PROMPT_ABOVE]), (float) (-iArr[ListPopupWindow.POSITION_PROMPT_BELOW]));
            return true;
        }

        public abstract ListPopupWindow getPopup();

        protected boolean onForwardingStarted() {
            ListPopupWindow popup = getPopup();
            if (!(popup == null || popup.isShowing())) {
                popup.show();
            }
            return true;
        }

        protected boolean onForwardingStopped() {
            ListPopupWindow popup = getPopup();
            if (popup != null && popup.isShowing()) {
                popup.dismiss();
            }
            return true;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean onTouchForwarded;
            boolean z = this.mForwarding;
            if (z) {
                onTouchForwarded = this.mWasLongPress ? onTouchForwarded(motionEvent) : (onTouchForwarded(motionEvent) || !onForwardingStopped()) ? true : ListPopupWindow.DEBUG;
            } else {
                boolean z2 = (onTouchObserved(motionEvent) && onForwardingStarted()) ? ListPopupWindow.POSITION_PROMPT_BELOW : ListPopupWindow.DEBUG;
                if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, ListPopupWindow.POSITION_PROMPT_ABOVE);
                    this.mSrc.onTouchEvent(obtain);
                    obtain.recycle();
                }
                onTouchForwarded = z2;
            }
            this.mForwarding = onTouchForwarded;
            return (onTouchForwarded || z) ? true : ListPopupWindow.DEBUG;
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow.1 */
    class C04901 extends ForwardingListener {
        C04901(View view) {
            super(view);
        }

        public ListPopupWindow getPopup() {
            return ListPopupWindow.this;
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow.2 */
    class C04912 implements Runnable {
        C04912() {
        }

        public void run() {
            View anchorView = ListPopupWindow.this.getAnchorView();
            if (anchorView != null && anchorView.getWindowToken() != null) {
                ListPopupWindow.this.show();
            }
        }
    }

    /* renamed from: android.support.v7.widget.ListPopupWindow.3 */
    class C04923 implements OnItemSelectedListener {
        C04923() {
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != ListPopupWindow.MATCH_PARENT) {
                DropDownListView access$600 = ListPopupWindow.this.mDropDownList;
                if (access$600 != null) {
                    access$600.mListSelectionHidden = ListPopupWindow.DEBUG;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    class DropDownListView extends ListViewCompat {
        private el mClickAnimation;
        private boolean mDrawsInPressedState;
        private boolean mHijackFocus;
        private boolean mListSelectionHidden;
        private ao mScrollHelper;

        public DropDownListView(Context context, boolean z) {
            super(context, null, C0359b.dropDownListViewStyle);
            this.mHijackFocus = z;
            setCacheColorHint(ListPopupWindow.POSITION_PROMPT_ABOVE);
        }

        private void clearPressedItem() {
            this.mDrawsInPressedState = ListPopupWindow.DEBUG;
            setPressed(ListPopupWindow.DEBUG);
            drawableStateChanged();
            View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(ListPopupWindow.DEBUG);
            }
            if (this.mClickAnimation != null) {
                this.mClickAnimation.m2805b();
                this.mClickAnimation = null;
            }
        }

        private void clickPressedItem(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        private void setPressedItem(View view, int i, float f, float f2) {
            this.mDrawsInPressedState = true;
            if (VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f, f2);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            if (this.mMotionPosition != ListPopupWindow.MATCH_PARENT) {
                View childAt = getChildAt(this.mMotionPosition - getFirstVisiblePosition());
                if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                    childAt.setPressed(ListPopupWindow.DEBUG);
                }
            }
            this.mMotionPosition = i;
            float left = f - ((float) view.getLeft());
            float top = f2 - ((float) view.getTop());
            if (VERSION.SDK_INT >= 21) {
                view.drawableHotspotChanged(left, top);
            }
            if (!view.isPressed()) {
                view.setPressed(true);
            }
            setSelection(i);
            positionSelectorLikeTouchCompat(i, view, f, f2);
            setSelectorEnabled(ListPopupWindow.DEBUG);
            refreshDrawableState();
        }

        public boolean hasFocus() {
            return (this.mHijackFocus || super.hasFocus()) ? true : ListPopupWindow.DEBUG;
        }

        public boolean hasWindowFocus() {
            return (this.mHijackFocus || super.hasWindowFocus()) ? true : ListPopupWindow.DEBUG;
        }

        public boolean isFocused() {
            return (this.mHijackFocus || super.isFocused()) ? true : ListPopupWindow.DEBUG;
        }

        public boolean isInTouchMode() {
            return ((this.mHijackFocus && this.mListSelectionHidden) || super.isInTouchMode()) ? true : ListPopupWindow.DEBUG;
        }

        public boolean onForwardedEvent(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            int a = bf.m2309a(motionEvent);
            switch (a) {
                case ListPopupWindow.POSITION_PROMPT_BELOW /*1*/:
                    z = ListPopupWindow.DEBUG;
                    break;
                case ListPopupWindow.INPUT_METHOD_NOT_NEEDED /*2*/:
                    z = true;
                    break;
                case Version.API03_CUPCAKE_15 /*3*/:
                    z = ListPopupWindow.DEBUG;
                    z2 = ListPopupWindow.DEBUG;
                    break;
                default:
                    z = ListPopupWindow.DEBUG;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = ListPopupWindow.DEBUG;
                z2 = ListPopupWindow.DEBUG;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == ListPopupWindow.MATCH_PARENT) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    setPressedItem(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                    if (a == ListPopupWindow.POSITION_PROMPT_BELOW) {
                        clickPressedItem(childAt, pointToPosition);
                    }
                    z = ListPopupWindow.DEBUG;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                clearPressedItem();
            }
            if (z2) {
                if (this.mScrollHelper == null) {
                    this.mScrollHelper = new ao(this);
                }
                this.mScrollHelper.m3100a(true);
                this.mScrollHelper.onTouch(this, motionEvent);
            } else if (this.mScrollHelper != null) {
                this.mScrollHelper.m3100a((boolean) ListPopupWindow.DEBUG);
            }
            return z2;
        }

        protected boolean touchModeDrawsInPressedStateCompat() {
            return (this.mDrawsInPressedState || super.touchModeDrawsInPressedStateCompat()) ? true : ListPopupWindow.DEBUG;
        }
    }

    class ListSelectorHider implements Runnable {
        private ListSelectorHider() {
        }

        public void run() {
            ListPopupWindow.this.clearListSelection();
        }
    }

    class PopupDataSetObserver extends DataSetObserver {
        private PopupDataSetObserver() {
        }

        public void onChanged() {
            if (ListPopupWindow.this.isShowing()) {
                ListPopupWindow.this.show();
            }
        }

        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    class PopupScrollListener implements OnScrollListener {
        private PopupScrollListener() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == ListPopupWindow.POSITION_PROMPT_BELOW && !ListPopupWindow.this.isInputMethodNotNeeded() && ListPopupWindow.this.mPopup.getContentView() != null) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
                ListPopupWindow.this.mResizePopupRunnable.run();
            }
        }
    }

    class PopupTouchInterceptor implements OnTouchListener {
        private PopupTouchInterceptor() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && ListPopupWindow.this.mPopup != null && ListPopupWindow.this.mPopup.isShowing() && x >= 0 && x < ListPopupWindow.this.mPopup.getWidth() && y >= 0 && y < ListPopupWindow.this.mPopup.getHeight()) {
                ListPopupWindow.this.mHandler.postDelayed(ListPopupWindow.this.mResizePopupRunnable, 250);
            } else if (action == ListPopupWindow.POSITION_PROMPT_BELOW) {
                ListPopupWindow.this.mHandler.removeCallbacks(ListPopupWindow.this.mResizePopupRunnable);
            }
            return ListPopupWindow.DEBUG;
        }
    }

    class ResizePopupRunnable implements Runnable {
        private ResizePopupRunnable() {
        }

        public void run() {
            if (ListPopupWindow.this.mDropDownList != null && cb.m2387F(ListPopupWindow.this.mDropDownList) && ListPopupWindow.this.mDropDownList.getCount() > ListPopupWindow.this.mDropDownList.getChildCount() && ListPopupWindow.this.mDropDownList.getChildCount() <= ListPopupWindow.this.mListItemExpandMaximum) {
                ListPopupWindow.this.mPopup.setInputMethodMode(ListPopupWindow.INPUT_METHOD_NOT_NEEDED);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        try {
            Class[] clsArr = new Class[POSITION_PROMPT_BELOW];
            clsArr[POSITION_PROMPT_ABOVE] = Boolean.TYPE;
            sClipToWindowEnabledMethod = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", clsArr);
        } catch (NoSuchMethodException e) {
            Log.i(TAG, "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            sGetMaxAvailableHeightMethod = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i(TAG, "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, C0359b.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0359b.listPopupWindowStyle);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, POSITION_PROMPT_ABOVE);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mDropDownHeight = WRAP_CONTENT;
        this.mDropDownWidth = WRAP_CONTENT;
        this.mDropDownWindowLayoutType = 1002;
        this.mDropDownGravity = POSITION_PROMPT_ABOVE;
        this.mDropDownAlwaysVisible = DEBUG;
        this.mForceIgnoreOutsideTouch = DEBUG;
        this.mListItemExpandMaximum = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.mPromptPosition = POSITION_PROMPT_ABOVE;
        this.mResizePopupRunnable = new ResizePopupRunnable();
        this.mTouchInterceptor = new PopupTouchInterceptor();
        this.mScrollListener = new PopupScrollListener();
        this.mHideSelector = new ListSelectorHider();
        this.mTempRect = new Rect();
        this.mContext = context;
        this.mHandler = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0369l.ListPopupWindow, i, i2);
        this.mDropDownHorizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(C0369l.ListPopupWindow_android_dropDownHorizontalOffset, POSITION_PROMPT_ABOVE);
        this.mDropDownVerticalOffset = obtainStyledAttributes.getDimensionPixelOffset(C0369l.ListPopupWindow_android_dropDownVerticalOffset, POSITION_PROMPT_ABOVE);
        if (this.mDropDownVerticalOffset != 0) {
            this.mDropDownVerticalOffsetSet = true;
        }
        obtainStyledAttributes.recycle();
        this.mPopup = new AppCompatPopupWindow(context, attributeSet, i);
        this.mPopup.setInputMethodMode(POSITION_PROMPT_BELOW);
        this.mLayoutDirection = C0217q.m1652a(this.mContext.getResources().getConfiguration().locale);
    }

    private int buildDropDown() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.mDropDownList == null) {
            Context context = this.mContext;
            this.mShowDropDownRunnable = new C04912();
            this.mDropDownList = new DropDownListView(context, !this.mModal ? true : DEBUG);
            if (this.mDropDownListHighlight != null) {
                this.mDropDownList.setSelector(this.mDropDownListHighlight);
            }
            this.mDropDownList.setAdapter(this.mAdapter);
            this.mDropDownList.setOnItemClickListener(this.mItemClickListener);
            this.mDropDownList.setFocusable(true);
            this.mDropDownList.setFocusableInTouchMode(true);
            this.mDropDownList.setOnItemSelectedListener(new C04923());
            this.mDropDownList.setOnScrollListener(this.mScrollListener);
            if (this.mItemSelectedListener != null) {
                this.mDropDownList.setOnItemSelectedListener(this.mItemSelectedListener);
            }
            View view2 = this.mDropDownList;
            View view3 = this.mPromptView;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(POSITION_PROMPT_BELOW);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(MATCH_PARENT, POSITION_PROMPT_ABOVE, 1.0f);
                switch (this.mPromptPosition) {
                    case POSITION_PROMPT_ABOVE /*0*/:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case POSITION_PROMPT_BELOW /*1*/:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e(TAG, "Invalid hint position " + this.mPromptPosition);
                        break;
                }
                if (this.mDropDownWidth >= 0) {
                    i = this.mDropDownWidth;
                    i2 = RtlSpacingHelper.UNDEFINED;
                } else {
                    i2 = POSITION_PROMPT_ABOVE;
                    i = POSITION_PROMPT_ABOVE;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), POSITION_PROMPT_ABOVE);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = POSITION_PROMPT_ABOVE;
            }
            this.mPopup.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.mPopup.getContentView();
            view = this.mPromptView;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = POSITION_PROMPT_ABOVE;
            }
        }
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            i2 = this.mTempRect.top + this.mTempRect.bottom;
            if (this.mDropDownVerticalOffsetSet) {
                i4 = i2;
            } else {
                this.mDropDownVerticalOffset = -this.mTempRect.top;
                i4 = i2;
            }
        } else {
            this.mTempRect.setEmpty();
            i4 = POSITION_PROMPT_ABOVE;
        }
        if (this.mPopup.getInputMethodMode() != INPUT_METHOD_NOT_NEEDED) {
            z = DEBUG;
        }
        i = getMaxAvailableHeight(getAnchorView(), this.mDropDownVerticalOffset, z);
        if (this.mDropDownAlwaysVisible || this.mDropDownHeight == MATCH_PARENT) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.mDropDownWidth) {
            case WRAP_CONTENT /*-2*/:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), RtlSpacingHelper.UNDEFINED);
                break;
            case MATCH_PARENT /*-1*/:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mContext.getResources().getDisplayMetrics().widthPixels - (this.mTempRect.left + this.mTempRect.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.mDropDownWidth, 1073741824);
                break;
        }
        i2 = this.mDropDownList.measureHeightOfChildrenCompat(makeMeasureSpec, POSITION_PROMPT_ABOVE, MATCH_PARENT, i - i3, MATCH_PARENT);
        if (i2 > 0) {
            i3 += i4;
        }
        return i2 + i3;
    }

    private int getMaxAvailableHeight(View view, int i, boolean z) {
        if (sGetMaxAvailableHeightMethod != null) {
            try {
                return ((Integer) sGetMaxAvailableHeightMethod.invoke(this.mPopup, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i(TAG, "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.mPopup.getMaxAvailableHeight(view, i);
    }

    private static boolean isConfirmKey(int i) {
        return (i == 66 || i == 23) ? true : DEBUG;
    }

    private void removePromptView() {
        if (this.mPromptView != null) {
            ViewParent parent = this.mPromptView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.mPromptView);
            }
        }
    }

    private void setPopupClipToScreenEnabled(boolean z) {
        if (sClipToWindowEnabledMethod != null) {
            try {
                Method method = sClipToWindowEnabledMethod;
                PopupWindow popupWindow = this.mPopup;
                Object[] objArr = new Object[POSITION_PROMPT_BELOW];
                objArr[POSITION_PROMPT_ABOVE] = Boolean.valueOf(z);
                method.invoke(popupWindow, objArr);
            } catch (Exception e) {
                Log.i(TAG, "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void clearListSelection() {
        DropDownListView dropDownListView = this.mDropDownList;
        if (dropDownListView != null) {
            dropDownListView.mListSelectionHidden = true;
            dropDownListView.requestLayout();
        }
    }

    public OnTouchListener createDragToOpenListener(View view) {
        return new C04901(view);
    }

    public void dismiss() {
        this.mPopup.dismiss();
        removePromptView();
        this.mPopup.setContentView(null);
        this.mDropDownList = null;
        this.mHandler.removeCallbacks(this.mResizePopupRunnable);
    }

    public View getAnchorView() {
        return this.mDropDownAnchorView;
    }

    public int getAnimationStyle() {
        return this.mPopup.getAnimationStyle();
    }

    public Drawable getBackground() {
        return this.mPopup.getBackground();
    }

    public int getHeight() {
        return this.mDropDownHeight;
    }

    public int getHorizontalOffset() {
        return this.mDropDownHorizontalOffset;
    }

    public int getInputMethodMode() {
        return this.mPopup.getInputMethodMode();
    }

    public ListView getListView() {
        return this.mDropDownList;
    }

    public int getPromptPosition() {
        return this.mPromptPosition;
    }

    public Object getSelectedItem() {
        return !isShowing() ? null : this.mDropDownList.getSelectedItem();
    }

    public long getSelectedItemId() {
        return !isShowing() ? Long.MIN_VALUE : this.mDropDownList.getSelectedItemId();
    }

    public int getSelectedItemPosition() {
        return !isShowing() ? MATCH_PARENT : this.mDropDownList.getSelectedItemPosition();
    }

    public View getSelectedView() {
        return !isShowing() ? null : this.mDropDownList.getSelectedView();
    }

    public int getSoftInputMode() {
        return this.mPopup.getSoftInputMode();
    }

    public int getVerticalOffset() {
        return !this.mDropDownVerticalOffsetSet ? POSITION_PROMPT_ABOVE : this.mDropDownVerticalOffset;
    }

    public int getWidth() {
        return this.mDropDownWidth;
    }

    public boolean isDropDownAlwaysVisible() {
        return this.mDropDownAlwaysVisible;
    }

    public boolean isInputMethodNotNeeded() {
        return this.mPopup.getInputMethodMode() == INPUT_METHOD_NOT_NEEDED ? true : DEBUG;
    }

    public boolean isModal() {
        return this.mModal;
    }

    public boolean isShowing() {
        return this.mPopup.isShowing();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isShowing() && i != 62 && (this.mDropDownList.getSelectedItemPosition() >= 0 || !isConfirmKey(i))) {
            int selectedItemPosition = this.mDropDownList.getSelectedItemPosition();
            boolean z = !this.mPopup.isAboveAnchor() ? true : DEBUG;
            ListAdapter listAdapter = this.mAdapter;
            int i2 = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            int i3 = RtlSpacingHelper.UNDEFINED;
            if (listAdapter != null) {
                boolean areAllItemsEnabled = listAdapter.areAllItemsEnabled();
                i2 = areAllItemsEnabled ? POSITION_PROMPT_ABOVE : this.mDropDownList.lookForSelectablePosition(POSITION_PROMPT_ABOVE, true);
                i3 = areAllItemsEnabled ? listAdapter.getCount() + MATCH_PARENT : this.mDropDownList.lookForSelectablePosition(listAdapter.getCount() + MATCH_PARENT, DEBUG);
            }
            if (!(z && i == 19 && selectedItemPosition <= r4) && (z || i != 20 || selectedItemPosition < i3)) {
                this.mDropDownList.mListSelectionHidden = DEBUG;
                if (this.mDropDownList.onKeyDown(i, keyEvent)) {
                    this.mPopup.setInputMethodMode(INPUT_METHOD_NOT_NEEDED);
                    this.mDropDownList.requestFocusFromTouch();
                    show();
                    switch (i) {
                        case Version.API19_KITKAT_44 /*19*/:
                        case C1317h.Toolbar_navigationIcon /*20*/:
                        case C1317h.Toolbar_titleTextColor /*23*/:
                        case C1317h.Theme_textAppearanceSearchResultSubtitle /*66*/:
                            return true;
                    }
                } else if (z && i == 20) {
                    if (selectedItemPosition == i3) {
                        return true;
                    }
                } else if (!z && i == 19 && selectedItemPosition == r4) {
                    return true;
                }
            }
            clearListSelection();
            this.mPopup.setInputMethodMode(POSITION_PROMPT_BELOW);
            show();
            return true;
        }
        return DEBUG;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && isShowing()) {
            View view = this.mDropDownAnchorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState == null) {
                    return true;
                }
                keyDispatcherState.startTracking(keyEvent, this);
                return true;
            } else if (keyEvent.getAction() == POSITION_PROMPT_BELOW) {
                keyDispatcherState = view.getKeyDispatcherState();
                if (keyDispatcherState != null) {
                    keyDispatcherState.handleUpEvent(keyEvent);
                }
                if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                    dismiss();
                    return true;
                }
            }
        }
        return DEBUG;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!isShowing() || this.mDropDownList.getSelectedItemPosition() < 0) {
            return DEBUG;
        }
        boolean onKeyUp = this.mDropDownList.onKeyUp(i, keyEvent);
        if (!onKeyUp || !isConfirmKey(i)) {
            return onKeyUp;
        }
        dismiss();
        return onKeyUp;
    }

    public boolean performItemClick(int i) {
        if (!isShowing()) {
            return DEBUG;
        }
        if (this.mItemClickListener != null) {
            AdapterView adapterView = this.mDropDownList;
            View childAt = adapterView.getChildAt(i - adapterView.getFirstVisiblePosition());
            ListAdapter adapter = adapterView.getAdapter();
            this.mItemClickListener.onItemClick(adapterView, childAt, i, adapter.getItemId(i));
        }
        return true;
    }

    public void postShow() {
        this.mHandler.post(this.mShowDropDownRunnable);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (this.mObserver == null) {
            this.mObserver = new PopupDataSetObserver();
        } else if (this.mAdapter != null) {
            this.mAdapter.unregisterDataSetObserver(this.mObserver);
        }
        this.mAdapter = listAdapter;
        if (this.mAdapter != null) {
            listAdapter.registerDataSetObserver(this.mObserver);
        }
        if (this.mDropDownList != null) {
            this.mDropDownList.setAdapter(this.mAdapter);
        }
    }

    public void setAnchorView(View view) {
        this.mDropDownAnchorView = view;
    }

    public void setAnimationStyle(int i) {
        this.mPopup.setAnimationStyle(i);
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mPopup.setBackgroundDrawable(drawable);
    }

    public void setContentWidth(int i) {
        Drawable background = this.mPopup.getBackground();
        if (background != null) {
            background.getPadding(this.mTempRect);
            this.mDropDownWidth = (this.mTempRect.left + this.mTempRect.right) + i;
            return;
        }
        setWidth(i);
    }

    public void setDropDownAlwaysVisible(boolean z) {
        this.mDropDownAlwaysVisible = z;
    }

    public void setDropDownGravity(int i) {
        this.mDropDownGravity = i;
    }

    public void setForceIgnoreOutsideTouch(boolean z) {
        this.mForceIgnoreOutsideTouch = z;
    }

    public void setHeight(int i) {
        this.mDropDownHeight = i;
    }

    public void setHorizontalOffset(int i) {
        this.mDropDownHorizontalOffset = i;
    }

    public void setInputMethodMode(int i) {
        this.mPopup.setInputMethodMode(i);
    }

    void setListItemExpandMax(int i) {
        this.mListItemExpandMaximum = i;
    }

    public void setListSelector(Drawable drawable) {
        this.mDropDownListHighlight = drawable;
    }

    public void setModal(boolean z) {
        this.mModal = z;
        this.mPopup.setFocusable(z);
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mPopup.setOnDismissListener(onDismissListener);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.mItemSelectedListener = onItemSelectedListener;
    }

    public void setPromptPosition(int i) {
        this.mPromptPosition = i;
    }

    public void setPromptView(View view) {
        boolean isShowing = isShowing();
        if (isShowing) {
            removePromptView();
        }
        this.mPromptView = view;
        if (isShowing) {
            show();
        }
    }

    public void setSelection(int i) {
        DropDownListView dropDownListView = this.mDropDownList;
        if (isShowing() && dropDownListView != null) {
            dropDownListView.mListSelectionHidden = DEBUG;
            dropDownListView.setSelection(i);
            if (VERSION.SDK_INT >= 11 && dropDownListView.getChoiceMode() != 0) {
                dropDownListView.setItemChecked(i, true);
            }
        }
    }

    public void setSoftInputMode(int i) {
        this.mPopup.setSoftInputMode(i);
    }

    public void setVerticalOffset(int i) {
        this.mDropDownVerticalOffset = i;
        this.mDropDownVerticalOffsetSet = true;
    }

    public void setWidth(int i) {
        this.mDropDownWidth = i;
    }

    public void setWindowLayoutType(int i) {
        this.mDropDownWindowLayoutType = i;
    }

    public void show() {
        boolean z = true;
        boolean z2 = DEBUG;
        int i = MATCH_PARENT;
        int buildDropDown = buildDropDown();
        boolean isInputMethodNotNeeded = isInputMethodNotNeeded();
        ax.m3237a(this.mPopup, this.mDropDownWindowLayoutType);
        if (this.mPopup.isShowing()) {
            int i2;
            int width = this.mDropDownWidth == MATCH_PARENT ? MATCH_PARENT : this.mDropDownWidth == WRAP_CONTENT ? getAnchorView().getWidth() : this.mDropDownWidth;
            if (this.mDropDownHeight == MATCH_PARENT) {
                if (!isInputMethodNotNeeded) {
                    buildDropDown = MATCH_PARENT;
                }
                if (isInputMethodNotNeeded) {
                    this.mPopup.setWidth(this.mDropDownWidth == MATCH_PARENT ? MATCH_PARENT : POSITION_PROMPT_ABOVE);
                    this.mPopup.setHeight(POSITION_PROMPT_ABOVE);
                    i2 = buildDropDown;
                } else {
                    this.mPopup.setWidth(this.mDropDownWidth == MATCH_PARENT ? MATCH_PARENT : POSITION_PROMPT_ABOVE);
                    this.mPopup.setHeight(MATCH_PARENT);
                    i2 = buildDropDown;
                }
            } else {
                i2 = this.mDropDownHeight == WRAP_CONTENT ? buildDropDown : this.mDropDownHeight;
            }
            PopupWindow popupWindow = this.mPopup;
            if (!(this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible)) {
                z2 = true;
            }
            popupWindow.setOutsideTouchable(z2);
            popupWindow = this.mPopup;
            View anchorView = getAnchorView();
            buildDropDown = this.mDropDownHorizontalOffset;
            int i3 = this.mDropDownVerticalOffset;
            if (width < 0) {
                width = MATCH_PARENT;
            }
            if (i2 >= 0) {
                i = i2;
            }
            popupWindow.update(anchorView, buildDropDown, i3, width, i);
            return;
        }
        int width2 = this.mDropDownWidth == MATCH_PARENT ? MATCH_PARENT : this.mDropDownWidth == WRAP_CONTENT ? getAnchorView().getWidth() : this.mDropDownWidth;
        if (this.mDropDownHeight == MATCH_PARENT) {
            buildDropDown = MATCH_PARENT;
        } else if (this.mDropDownHeight != WRAP_CONTENT) {
            buildDropDown = this.mDropDownHeight;
        }
        this.mPopup.setWidth(width2);
        this.mPopup.setHeight(buildDropDown);
        setPopupClipToScreenEnabled(true);
        popupWindow = this.mPopup;
        if (this.mForceIgnoreOutsideTouch || this.mDropDownAlwaysVisible) {
            z = DEBUG;
        }
        popupWindow.setOutsideTouchable(z);
        this.mPopup.setTouchInterceptor(this.mTouchInterceptor);
        ax.m3238a(this.mPopup, getAnchorView(), this.mDropDownHorizontalOffset, this.mDropDownVerticalOffset, this.mDropDownGravity);
        this.mDropDownList.setSelection(MATCH_PARENT);
        if (!this.mModal || this.mDropDownList.isInTouchMode()) {
            clearListSelection();
        }
        if (!this.mModal) {
            this.mHandler.post(this.mHideSelector);
        }
    }
}
