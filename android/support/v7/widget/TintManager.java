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
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

public final class TintManager {
    private static final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
    private static final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
    private static final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
    private static final ColorFilterLruCache COLOR_FILTER_CACHE;
    private static final boolean DEBUG = false;
    private static final Mode DEFAULT_MODE;
    private static final WeakHashMap<Context, TintManager> INSTANCE_CACHE;
    public static final boolean SHOULD_BE_USED;
    private static final String TAG = "TintManager";
    private static final int[] TINT_CHECKABLE_BUTTON_LIST;
    private static final int[] TINT_COLOR_CONTROL_NORMAL;
    private static final int[] TINT_COLOR_CONTROL_STATE_LIST;
    private final WeakReference<Context> mContextRef;
    private ColorStateList mDefaultColorStateList;
    private SparseArray<ColorStateList> mTintLists;

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

    static {
        SHOULD_BE_USED = VERSION.SDK_INT < 21 ? true : SHOULD_BE_USED;
        DEFAULT_MODE = Mode.SRC_IN;
        INSTANCE_CACHE = new WeakHashMap();
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
        COLORFILTER_TINT_COLOR_CONTROL_NORMAL = new int[]{C0363f.abc_textfield_search_default_mtrl_alpha, C0363f.abc_textfield_default_mtrl_alpha, C0363f.abc_ab_share_pack_mtrl_alpha};
        TINT_COLOR_CONTROL_NORMAL = new int[]{C0363f.abc_ic_ab_back_mtrl_am_alpha, C0363f.abc_ic_go_search_api_mtrl_alpha, C0363f.abc_ic_search_api_mtrl_alpha, C0363f.abc_ic_commit_search_api_mtrl_alpha, C0363f.abc_ic_clear_mtrl_alpha, C0363f.abc_ic_menu_share_mtrl_alpha, C0363f.abc_ic_menu_copy_mtrl_am_alpha, C0363f.abc_ic_menu_cut_mtrl_alpha, C0363f.abc_ic_menu_selectall_mtrl_alpha, C0363f.abc_ic_menu_paste_mtrl_am_alpha, C0363f.abc_ic_menu_moreoverflow_mtrl_alpha, C0363f.abc_ic_voice_search_api_mtrl_alpha};
        COLORFILTER_COLOR_CONTROL_ACTIVATED = new int[]{C0363f.abc_textfield_activated_mtrl_alpha, C0363f.abc_textfield_search_activated_mtrl_alpha, C0363f.abc_cab_background_top_mtrl_alpha, C0363f.abc_text_cursor_material};
        COLORFILTER_COLOR_BACKGROUND_MULTIPLY = new int[]{C0363f.abc_popup_background_mtrl_mult, C0363f.abc_cab_background_internal_bg, C0363f.abc_menu_hardkey_panel_mtrl_mult};
        TINT_COLOR_CONTROL_STATE_LIST = new int[]{C0363f.abc_edit_text_material, C0363f.abc_tab_indicator_material, C0363f.abc_textfield_search_material, C0363f.abc_spinner_mtrl_am_alpha, C0363f.abc_spinner_textfield_background_material, C0363f.abc_ratingbar_full_material, C0363f.abc_switch_track_mtrl_alpha, C0363f.abc_switch_thumb_material, C0363f.abc_btn_default_mtrl_shape, C0363f.abc_btn_borderless_material};
        TINT_CHECKABLE_BUTTON_LIST = new int[]{C0363f.abc_btn_check_material, C0363f.abc_btn_radio_material};
    }

    private TintManager(Context context) {
        this.mContextRef = new WeakReference(context);
    }

    private static boolean arrayContains(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return SHOULD_BE_USED;
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

    public static TintManager get(Context context) {
        TintManager tintManager = (TintManager) INSTANCE_CACHE.get(context);
        if (tintManager != null) {
            return tintManager;
        }
        tintManager = new TintManager(context);
        INSTANCE_CACHE.put(context, tintManager);
        return tintManager;
    }

    private ColorStateList getDefaultColorStateList(Context context) {
        if (this.mDefaultColorStateList == null) {
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
            this.mDefaultColorStateList = new ColorStateList(r2, iArr);
        }
        return this.mDefaultColorStateList;
    }

    public static Drawable getDrawable(Context context, int i) {
        return isInTintList(i) ? get(context).getDrawable(i) : C0125h.m1018a(context, i);
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

    private static boolean isInTintList(int i) {
        return (arrayContains(TINT_COLOR_CONTROL_NORMAL, i) || arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i) || arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i) || arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i) || arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i) || arrayContains(TINT_CHECKABLE_BUTTON_LIST, i) || i == C0363f.abc_cab_background_top_material) ? true : SHOULD_BE_USED;
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
            return VERSION.SDK_INT < 14 ? SHOULD_BE_USED : true;
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
                    return SHOULD_BE_USED;
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

    public Drawable getDrawable(int i) {
        return getDrawable(i, (boolean) SHOULD_BE_USED);
    }

    public Drawable getDrawable(int i, boolean z) {
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return null;
        }
        Drawable a = C0125h.m1018a(context, i);
        if (a != null) {
            if (VERSION.SDK_INT >= 8) {
                a = a.mutate();
            }
            ColorStateList tintList = getTintList(i);
            if (tintList != null) {
                a = C0177a.m1549c(a);
                C0177a.m1544a(a, tintList);
                Mode tintMode = getTintMode(i);
                if (tintMode != null) {
                    C0177a.m1545a(a, tintMode);
                }
            } else if (i == C0363f.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{getDrawable(C0363f.abc_cab_background_internal_bg), getDrawable(C0363f.abc_cab_background_top_mtrl_alpha)});
            } else if (i == C0363f.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) a;
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908288), ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal), DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.getThemeAttrColor(context, C0359b.colorControlNormal), DEFAULT_MODE);
                setPorterDuffColorFilter(layerDrawable.findDrawableByLayerId(16908301), ThemeUtils.getThemeAttrColor(context, C0359b.colorControlActivated), DEFAULT_MODE);
            } else if (!tintDrawableUsingColorFilter(i, a) && z) {
                a = null;
            }
        }
        return a;
    }

    public final ColorStateList getTintList(int i) {
        ColorStateList colorStateList = null;
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return null;
        }
        if (this.mTintLists != null) {
            colorStateList = (ColorStateList) this.mTintLists.get(i);
        }
        if (colorStateList != null) {
            return colorStateList;
        }
        ColorStateList createEditTextColorStateList = i == C0363f.abc_edit_text_material ? createEditTextColorStateList(context) : i == C0363f.abc_switch_track_mtrl_alpha ? createSwitchTrackColorStateList(context) : i == C0363f.abc_switch_thumb_material ? createSwitchThumbColorStateList(context) : (i == C0363f.abc_btn_default_mtrl_shape || i == C0363f.abc_btn_borderless_material) ? createDefaultButtonColorStateList(context) : i == C0363f.abc_btn_colored_material ? createColoredButtonColorStateList(context) : (i == C0363f.abc_spinner_mtrl_am_alpha || i == C0363f.abc_spinner_textfield_background_material) ? createSpinnerColorStateList(context) : arrayContains(TINT_COLOR_CONTROL_NORMAL, i) ? ThemeUtils.getThemeAttrColorStateList(context, C0359b.colorControlNormal) : arrayContains(TINT_COLOR_CONTROL_STATE_LIST, i) ? getDefaultColorStateList(context) : arrayContains(TINT_CHECKABLE_BUTTON_LIST, i) ? createCheckableButtonColorStateList(context) : i == C0363f.abc_seekbar_thumb_material ? createSeekbarThumbColorStateList(context) : colorStateList;
        if (createEditTextColorStateList == null) {
            return createEditTextColorStateList;
        }
        if (this.mTintLists == null) {
            this.mTintLists = new SparseArray();
        }
        this.mTintLists.append(i, createEditTextColorStateList);
        return createEditTextColorStateList;
    }

    final Mode getTintMode(int i) {
        return i == C0363f.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public final boolean tintDrawableUsingColorFilter(int i, Drawable drawable) {
        Context context = (Context) this.mContextRef.get();
        if (context == null) {
            return SHOULD_BE_USED;
        }
        int i2;
        Mode mode;
        Object obj;
        int i3;
        Mode mode2 = DEFAULT_MODE;
        if (arrayContains(COLORFILTER_TINT_COLOR_CONTROL_NORMAL, i)) {
            i2 = C0359b.colorControlNormal;
            mode = mode2;
            obj = 1;
            i3 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_CONTROL_ACTIVATED, i)) {
            i2 = C0359b.colorControlActivated;
            mode = mode2;
            r6 = 1;
            i3 = -1;
        } else if (arrayContains(COLORFILTER_COLOR_BACKGROUND_MULTIPLY, i)) {
            r6 = 1;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0363f.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            r6 = 1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            obj = null;
        }
        if (obj == null) {
            return SHOULD_BE_USED;
        }
        drawable.setColorFilter(getPorterDuffColorFilter(ThemeUtils.getThemeAttrColor(context, i2), mode));
        if (i3 != -1) {
            drawable.setAlpha(i3);
        }
        return true;
    }
}
