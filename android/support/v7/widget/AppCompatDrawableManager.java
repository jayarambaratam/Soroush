package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.v4.p012b.C0125h;
import android.support.v4.p013c.C0198a;
import android.support.v4.p013c.p014a.C0177a;
import android.support.v4.p016f.C0230g;
import android.support.v7.p019a.C0359b;
import android.support.v7.p019a.C0363f;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.WeakHashMap;

public final class AppCompatDrawableManager {
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
    private static final ColorFilterLruCache COLOR_FILTER_CACHE;
    private static final boolean DEBUG = false;
    private static final Mode DEFAULT_MODE;
    private static AppCompatDrawableManager INSTANCE = null;
    private static final String TAG = "TintManager";
    private static final int[] TINT_CHECKABLE_BUTTON_LIST;
    private static final int[] TINT_COLOR_CONTROL_NORMAL;
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
    private ArrayList<InflateDelegate> mDelegates;
    private WeakHashMap<Context, SparseArray<ColorStateList>> mTintLists;

    class ColorFilterLruCache extends C0230g<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i) {
            super(i);
        }

        private static int generateCacheKey(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter get(int i, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(generateCacheKey(i, mode)));
        }

        PorterDuffColorFilter put(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(generateCacheKey(i, mode)), porterDuffColorFilter);
        }
    }

    public interface InflateDelegate {
        Drawable onInflateDrawable(Context context, int i);
    }

    static {
        DEFAULT_MODE = Mode.SRC_IN;
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
        COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{C0363f.abc_textfield_search_default_mtrl_alpha, C0363f.abc_textfield_default_mtrl_alpha, C0363f.abc_ab_share_pack_mtrl_alpha};
        TINT_COLOR_CONTROL_NORMAL = new int[]{C0363f.abc_ic_ab_back_mtrl_am_alpha, C0363f.abc_ic_go_search_api_mtrl_alpha, C0363f.abc_ic_search_api_mtrl_alpha, C0363f.abc_ic_commit_search_api_mtrl_alpha, C0363f.abc_ic_clear_mtrl_alpha, C0363f.abc_ic_menu_share_mtrl_alpha, C0363f.abc_ic_menu_copy_mtrl_am_alpha, C0363f.abc_ic_menu_cut_mtrl_alpha, C0363f.abc_ic_menu_selectall_mtrl_alpha, C0363f.abc_ic_menu_paste_mtrl_am_alpha, C0363f.abc_ic_menu_moreoverflow_mtrl_alpha, C0363f.abc_ic_voice_search_api_mtrl_alpha};
        COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{C0363f.abc_textfield_activated_mtrl_alpha, C0363f.abc_textfield_search_activated_mtrl_alpha, C0363f.abc_cab_background_top_mtrl_alpha, C0363f.abc_text_cursor_material};
        COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{C0363f.abc_popup_background_mtrl_mult, C0363f.abc_cab_background_internal_bg, C0363f.abc_menu_hardkey_panel_mtrl_mult};
        TINT_COLOR_CONTROL_STATE_LIST = new int[]{C0363f.abc_edit_text_material, C0363f.abc_tab_indicator_material, C0363f.abc_textfield_search_material, C0363f.abc_spinner_mtrl_am_alpha, C0363f.abc_spinner_textfield_background_material, C0363f.abc_ratingbar_full_material, C0363f.abc_switch_track_mtrl_alpha, C0363f.abc_switch_thumb_material, C0363f.abc_btn_default_mtrl_shape, C0363f.abc_btn_borderless_material};
        TINT_CHECKABLE_BUTTON_LIST = new int[]{C0363f.abc_btn_check_material, C0363f.abc_btn_radio_material};
    }

    private void addTintListToCache(Context context, int i, ColorStateList colorStateList) {
        if (this.mTintLists == null) {
            this.mTintLists = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.mTintLists.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.mTintLists.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return DEBUG;
    }

    private ColorStateList createButtonColorStateList(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, i);
        int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlHighlight);
        r0[0] = ThemeUtils.DISABLED_STATE_SET;
        r1[0] = ThemeUtils.getDisabledThemeAttrColor(context, C0359b.colorButtonNormal);
        r0[1] = ThemeUtils.PRESSED_STATE_SET;
        r1[1] = C0198a.m1617a(themeAttrColor2, themeAttrColor);
        r0[2] = ThemeUtils.FOCUSED_STATE_SET;
        r1[2] = C0198a.m1617a(themeAttrColor2, themeAttrColor);
        r0[3] = ThemeUtils.EMPTY_STATE_SET;
        r1[3] = themeAttrColor;
        return new ColorStateList(r0, r1);
    }

    private ColorStateList createCheckableButtonColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0359b.colorControlNormal), ThemeUtils.CHECKED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList createColoredButtonColorStateList(Context context) {
        return createButtonColorStateList(context, C0359b.colorAccent);
    }

    private ColorStateList createDefaultButtonColorStateList(Context context) {
        return createButtonColorStateList(context, C0359b.colorButtonNormal);
    }

    private ColorStateList createDefaultColorStateList(Context context) {
        int themeAttrColor = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal);
        int themeAttrColor2 = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated);
        r2 = new int[7][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0359b.colorControlNormal), ThemeUtils.FOCUSED_STATE_SET, themeAttrColor2, ThemeUtils.ACTIVATED_STATE_SET, themeAttrColor2, ThemeUtils.PRESSED_STATE_SET};
        iArr[3] = themeAttrColor2;
        r2[4] = ThemeUtils.CHECKED_STATE_SET;
        iArr[4] = themeAttrColor2;
        r2[5] = ThemeUtils.SELECTED_STATE_SET;
        iArr[5] = themeAttrColor2;
        r2[6] = ThemeUtils.EMPTY_STATE_SET;
        iArr[6] = themeAttrColor;
        return new ColorStateList(r2, iArr);
    }

    private ColorStateList createEditTextColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0359b.colorControlNormal), ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList createSeekbarThumbColorStateList(Context context) {
        r0 = new int[2][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0359b.colorControlActivated)};
        r0[1] = ThemeUtils.EMPTY_STATE_SET;
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList createSpinnerColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getDisabledThemeAttrColor(context, C0359b.colorControlNormal), ThemeUtils.NOT_PRESSED_OR_FOCUSED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated);
        return new ColorStateList(r0, iArr);
    }

    private ColorStateList createSwitchThumbColorStateList(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList themeAttrColorStateList = ThemeUtils.getThemeAttrColorStateList(context, C0359b.colorSwitchThumbNormal);
        if (themeAttrColorStateList == null || !themeAttrColorStateList.isStateful()) {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = ThemeUtils.getDisabledThemeAttrColor(context, C0359b.colorSwitchThumbNormal);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = ThemeUtils.getThemeAttrColor(context, C0359b.colorSwitchThumbNormal);
        } else {
            iArr[0] = ThemeUtils.DISABLED_STATE_SET;
            iArr2[0] = themeAttrColorStateList.getColorForState(iArr[0], 0);
            iArr[1] = ThemeUtils.CHECKED_STATE_SET;
            iArr2[1] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated);
            iArr[2] = ThemeUtils.EMPTY_STATE_SET;
            iArr2[2] = themeAttrColorStateList.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    private ColorStateList createSwitchTrackColorStateList(Context context) {
        r0 = new int[3][];
        int[] iArr = new int[]{ThemeUtils.DISABLED_STATE_SET, ThemeUtils.getThemeAttrColor(context, 16842800, 0.1f), ThemeUtils.CHECKED_STATE_SET};
        iArr[1] = ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated, 0.3f);
        r0[2] = ThemeUtils.EMPTY_STATE_SET;
        iArr[2] = ThemeUtils.getThemeAttrColor(context, 16842800, 0.3f);
        return new ColorStateList(r0, iArr);
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : getPorterDuffColorFilter(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static AppCompatDrawableManager get() {
        if (INSTANCE == null) {
            INSTANCE = new AppCompatDrawableManager();
        }
        return INSTANCE;
    }

    private static PorterDuffColorFilter getPorterDuffColorFilter(int i, Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter = COLOR_FILTER_CACHE.get(i, mode);
        if (porterDuffColorFilter != null) {
            return porterDuffColorFilter;
        }
        porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        COLOR_FILTER_CACHE.put(i, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    private ColorStateList getTintListFromCache(Context context, int i) {
        if (this.mTintLists == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.mTintLists.get(context);
        return sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
    }

    private static void setPorterDuffColorFilter(Drawable drawable, int i, Mode mode) {
        if (mode == null) {
            mode = DEFAULT_MODE;
        }
        drawable.setColorFilter(getPorterDuffColorFilter(i, mode));
    }

    private static boolean shouldMutateBackground(Drawable drawable) {
        if (VERSION.SDK_INT >= 16) {
            return true;
        }
        if (drawable instanceof LayerDrawable) {
            return VERSION.SDK_INT >= 16;
        } else if (drawable instanceof InsetDrawable) {
            return VERSION.SDK_INT < 14 ? DEBUG : true;
        } else {
            if (!(drawable instanceof DrawableContainer)) {
                return true;
            }
            ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainerState)) {
                return true;
            }
            for (Drawable shouldMutateBackground : ((DrawableContainerState) constantState).getChildren()) {
                if (!shouldMutateBackground(shouldMutateBackground)) {
                    return DEBUG;
                }
            }
            return true;
        }
    }

    public static void tintDrawable(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        if (!shouldMutateBackground(drawable) || drawable.mutate() == drawable) {
            if (tintInfo.mHasTintList || tintInfo.mHasTintMode) {
                drawable.setColorFilter(createTintFilter(tintInfo.mHasTintList ? tintInfo.mTintList : null, tintInfo.mHasTintMode ? tintInfo.mTintMode : DEFAULT_MODE, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 10) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
    }

    public void addDelegate(InflateDelegate inflateDelegate) {
        if (this.mDelegates == null) {
            this.mDelegates = new ArrayList();
        }
        if (!this.mDelegates.contains(inflateDelegate)) {
            this.mDelegates.add(inflateDelegate);
        }
    }

    public Drawable getDrawable(Context context, int i) {
        return getDrawable(context, i, DEBUG);
    }

    public Drawable getDrawable(Context context, int i, boolean z) {
        Drawable onInflateDrawable;
        if (this.mDelegates != null) {
            int size = this.mDelegates.size();
            for (int i2 = 0; i2 < size; i2++) {
                onInflateDrawable = ((InflateDelegate) this.mDelegates.get(i2)).onInflateDrawable(context, i);
                if (onInflateDrawable != null) {
                    return onInflateDrawable;
                }
            }
        }
        onInflateDrawable = C0125h.m1018a(context, i);
        if (onInflateDrawable == null) {
            return onInflateDrawable;
        }
        if (VERSION.SDK_INT >= 8) {
            onInflateDrawable = onInflateDrawable.mutate();
        }
        ColorStateList tintList = getTintList(context, i);
        if (tintList != null) {
            onInflateDrawable = C0177a.m1549c(onInflateDrawable);
            C0177a.m1544a(onInflateDrawable, tintList);
            Mode tintMode = getTintMode(i);
            if (tintMode == null) {
                return onInflateDrawable;
            }
            C0177a.m1545a(onInflateDrawable, tintMode);
            return onInflateDrawable;
        } else if (i == C0363f.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{getDrawable(context, C0363f.abc_cab_background_internal_bg), getDrawable(context, C0363f.abc_cab_background_top_mtrl_alpha)});
        } else if (i != C0363f.abc_seekbar_track_material) {
            return (tintDrawableUsingColorFilter(context, i, onInflateDrawable) || !z) ? onInflateDrawable : null;
        } else {
            LayerDrawable layerDrawable = (LayerDrawable) onInflateDrawable;
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal), DEFAULT_MODE);
            setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated), DEFAULT_MODE);
            return onInflateDrawable;
        }
    }

    public final ColorStateList getTintList(Context context, int i) {
        ColorStateList tintListFromCache = getTintListFromCache(context, i);
        if (tintListFromCache == null) {
            if (i == C0363f.abc_edit_text_material) {
                tintListFromCache = createEditTextColorStateList(context);
            } else if (i == C0363f.abc_switch_track_mtrl_alpha) {
                tintListFromCache = createSwitchTrackColorStateList(context);
            } else if (i == C0363f.abc_switch_thumb_material) {
                tintListFromCache = createSwitchThumbColorStateList(context);
            } else if (i == C0363f.abc_btn_default_mtrl_shape || i == C0363f.abc_btn_borderless_material) {
                tintListFromCache = createDefaultButtonColorStateList(context);
            } else if (i == C0363f.abc_btn_colored_material) {
                tintListFromCache = createColoredButtonColorStateList(context);
            } else if (i == C0363f.abc_spinner_mtrl_am_alpha || i == C0363f.abc_spinner_textfield_background_material) {
                tintListFromCache = createSpinnerColorStateList(context);
            } else if (arrayContains(TINT_COLOR_CONTROL_NORMAL, i)) {
                tintListFromCache = ThemeUtils.getThemeAttrColorStateList(context, C0359b.colorControlNormal);
            } else if (arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i)) {
                tintListFromCache = createDefaultColorStateList(context);
            } else if (arrayContains(TINT_CHECKABLE_BUTTON_LIST, i)) {
                tintListFromCache = createCheckableButtonColorStateList(context);
            } else if (i == C0363f.abc_seekbar_thumb_material) {
                tintListFromCache = createSeekbarThumbColorStateList(context);
            }
            if (tintListFromCache != null) {
                addTintListToCache(context, i, tintListFromCache);
            }
        }
        return tintListFromCache;
    }

    final Mode getTintMode(int i) {
        return i == C0363f.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public void removeDelegate(InflateDelegate inflateDelegate) {
        if (this.mDelegates != null) {
            this.mDelegates.remove(inflateDelegate);
        }
    }

    public final boolean tintDrawableUsingColorFilter(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = DEFAULT_MODE;
        if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
            i2 = C0359b.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
            i2 = C0359b.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0363f.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return DEBUG;
        }
        drawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }
}
