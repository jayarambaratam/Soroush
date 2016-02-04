package mobi.mmdt.componentsutils.p079a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Vibrator;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.p032a.p033a.C0872i;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import mobi.mmdt.componentsutils.C1116c;
import mobi.mmdt.componentsutils.C1121h;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.componentsutils.a.c */
public class C1111c {
    public static float m6388a(Context context, float f) {
        return context.getResources().getDisplayMetrics().density * f;
    }

    public static int m6389a(Context context) {
        return (int) C1111c.m6388a(context, 12.0f);
    }

    public static int m6390a(View view) {
        if (view == null || VERSION.SDK_INT < 21) {
            return 0;
        }
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            if (obj != null) {
                Field declaredField2 = obj.getClass().getDeclaredField("mStableInsets");
                declaredField2.setAccessible(true);
                return ((Rect) declaredField2.get(obj)).bottom;
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public static Bitmap m6391a(Context context, String str) {
        return (Bitmap) C0872i.m5270b(context).m5329a(str).m5047j().m4297c(256, 256).get();
    }

    public static Bitmap m6392a(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        Bitmap createBitmap = (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) ? Bitmap.createBitmap(1, 1, Config.ARGB_8888) : Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static String m6393a(int i) {
        String str = BuildConfig.FLAVOR;
        int i2 = i / 60;
        int i3 = i % 60;
        if (i2 < 10) {
            str = (str + "0") + i2;
        } else {
            str = str + i2;
        }
        str = str + ":";
        if (i3 >= 10) {
            return str + i3;
        }
        return (str + "0") + i3;
    }

    public static String m6394a(long j) {
        return new SimpleDateFormat("HH:mm").format(new Date(j));
    }

    public static String m6395a(Context context, long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return C1109b.m6385b(instance) ? context.getString(C1121h.today) : C1109b.m6383a(instance, 1) ? context.getString(C1121h.yesterday) : C1109b.m6382a(instance) ? new SimpleDateFormat("MMMM d").format(new Date(j)) : new SimpleDateFormat("MMMM d, yyyy").format(new Date(j));
    }

    public static String m6396a(Context context, Uri uri) {
        Uri uri2;
        Cursor query;
        Throwable th;
        if (VERSION.SDK_INT < 22 || uri == null || uri.toString().length() <= 0 || !uri.toString().contains("com.google.android.apps.photos.contentprovider")) {
            uri2 = uri;
        } else {
            String path = uri.getPath();
            path = path.substring(path.indexOf("external/"), path.indexOf("/ACTUAL"));
            Builder buildUpon = uri.buildUpon();
            buildUpon.path(path);
            buildUpon.authority("media");
            uri2 = buildUpon.build();
        }
        try {
            query = context.getContentResolver().query(uri2, new String[]{"_data"}, null, null, null);
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                path = query.getString(columnIndexOrThrow);
                if (query != null) {
                    query.close();
                }
                return path;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
    }

    public static String m6397a(String str) {
        return "https://soroush-app.me/channel/" + str;
    }

    public static void m6398a(Activity activity) {
        activity.setRequestedOrientation(-1);
    }

    public static void m6399a(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        if (str != null && str.length() > 0) {
            intent.putExtra("phone", str);
        }
        activity.startActivityForResult(intent, 2);
    }

    public static void m6400a(Context context, int i) {
        ((Vibrator) context.getSystemService("vibrator")).vibrate((long) i);
    }

    public static int m6401b(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }

    public static int m6402b(Context context, String str) {
        int i = 0;
        if (str == null) {
            return C1111c.m6417i(context);
        }
        int i2 = 0;
        while (i < str.length()) {
            i2 += str.charAt(i);
            i++;
        }
        String[] stringArray = context.getResources().getStringArray(C1116c.colors);
        return Color.parseColor(stringArray[i2 % stringArray.length]);
    }

    public static String m6403b(int i) {
        String str = BuildConfig.FLAVOR;
        if (i < 1024) {
            return (str + i) + " B";
        } else if (i < 1048576) {
            r1 = (float) (i / 1024);
            return (str + String.format("%.1f", new Object[]{Float.valueOf(r1)})) + " KB";
        } else {
            r1 = (float) (i / 1048576);
            return (str + String.format("%.1f", new Object[]{Float.valueOf(r1)})) + " MB";
        }
    }

    public static String m6404b(Context context, long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (C1109b.m6385b(instance)) {
            return new SimpleDateFormat("HH:mm").format(new Date(j));
        }
        if (!C1109b.m6383a(instance, 1)) {
            return C1109b.m6382a(instance) ? new SimpleDateFormat("MMMM d, HH:mm").format(new Date(j)) : new SimpleDateFormat("MMMM d, yyyy, HH:mm").format(new Date(j));
        } else {
            return context.getString(C1121h.yesterday) + new SimpleDateFormat(", HH:mm").format(new Date(j));
        }
    }

    public static void m6405b(Activity activity) {
        if (activity.getWindowManager().getDefaultDisplay().getRotation() == 0) {
            activity.setRequestedOrientation(1);
        }
        if (activity.getWindowManager().getDefaultDisplay().getRotation() == 1) {
            activity.setRequestedOrientation(0);
        }
        if (activity.getWindowManager().getDefaultDisplay().getRotation() == 2) {
            activity.setRequestedOrientation(9);
        }
        if (activity.getWindowManager().getDefaultDisplay().getRotation() == 3) {
            activity.setRequestedOrientation(8);
        }
    }

    public static int m6406c(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(16843499, typedValue, true) ? TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics()) : 0;
    }

    public static String m6407c(int i) {
        String str = i > 1 ? "followers" : "follower";
        r0 = i < 1000 ? i + BuildConfig.FLAVOR : i < 1000000 ? String.format("%.1f", new Object[]{Float.valueOf((float) (i / 1000))}) + " K" : String.format("%.1f", new Object[]{Float.valueOf((float) (i / 1000000))}) + " M";
        return r0 + "  " + str;
    }

    public static String m6408c(Context context, long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        if (C1109b.m6385b(instance)) {
            return new SimpleDateFormat("HH:mm").format(new Date(j));
        }
        if (!C1109b.m6383a(instance, 1)) {
            return C1109b.m6382a(instance) ? new SimpleDateFormat("MMM d, HH:mm").format(new Date(j)) : new SimpleDateFormat("MMM d, yyyy").format(new Date(j));
        } else {
            return context.getString(C1121h.yesterday) + new SimpleDateFormat(", HH:mm").format(new Date(j));
        }
    }

    public static int m6409d(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
    }

    public static String m6410d(int i) {
        String str = BuildConfig.FLAVOR;
        if (i < 3600) {
            return String.format("%02d:%02d", new Object[]{Long.valueOf(TimeUnit.SECONDS.toMinutes((long) i) % TimeUnit.MINUTES.toMinutes(1)), Long.valueOf(TimeUnit.SECONDS.toSeconds((long) i) % TimeUnit.MINUTES.toSeconds(1))});
        }
        return String.format("%02d:%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toHours((long) i)), Long.valueOf(TimeUnit.SECONDS.toMinutes((long) i) % TimeUnit.HOURS.toMinutes(1)), Long.valueOf(TimeUnit.SECONDS.toSeconds((long) i) % TimeUnit.MINUTES.toSeconds(1))});
    }

    public static String m6411d(Context context, long j) {
        String str = BuildConfig.FLAVOR;
        if (j <= 0) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis() - j;
        Calendar.getInstance();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        long timeInMillis2 = instance.getTimeInMillis();
        instance.setTimeInMillis(j);
        instance.set(13, 0);
        instance.set(14, 0);
        if (j < timeInMillis || j > timeInMillis2) {
            currentTimeMillis = timeInMillis - 86400000;
            timeInMillis = timeInMillis2 - 86400000;
            if (j < currentTimeMillis || j > timeInMillis) {
                return instance.get(5) + "/" + (instance.get(2) + 1) + "/" + instance.get(1) + "  " + instance.get(11) + ":" + (instance.get(12) < 10 ? "0" + instance.get(12) : instance.get(12) + BuildConfig.FLAVOR);
            }
            return context.getString(C1121h.yesterday).toLowerCase() + "  " + instance.get(11) + ":" + (instance.get(12) < 10 ? "0" + instance.get(12) : instance.get(12) + BuildConfig.FLAVOR);
        } else if (currentTimeMillis < 60000) {
            return context.getString(C1121h.online);
        } else {
            if (currentTimeMillis < 60000 || currentTimeMillis >= 3600000) {
                return context.getString(C1121h.today).toLowerCase() + "  " + instance.get(11) + ":" + (instance.get(12) < 10 ? "0" + instance.get(12) : instance.get(12) + BuildConfig.FLAVOR);
            }
            int i = (int) (currentTimeMillis / 60000);
            return i == 1 ? context.getString(C1121h.one_minute_ago) : i + "  " + context.getString(C1121h.minutes_ago);
        }
    }

    public static String m6412e(int i) {
        if (i < 1000) {
            return i + BuildConfig.FLAVOR;
        }
        if (i < 1000000) {
            return String.format("%.1f", new Object[]{Float.valueOf((float) (i / 1000))}) + " K";
        }
        return String.format("%.1f", new Object[]{Float.valueOf((float) (i / 1000000))}) + " M";
    }

    public static boolean m6413e(Context context) {
        return context.getResources().getConfiguration().orientation == 1;
    }

    public static Point m6414f(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static float m6415g(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return context.getResources().getConfiguration().orientation == 1 ? (float) ((point.x * 70) / 100) : (float) ((point.y * 70) / 100);
    }

    public static float m6416h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return context.getResources().getConfiguration().orientation == 1 ? (float) ((point.x * 20) / 100) : (float) ((point.y * 20) / 100);
    }

    private static int m6417i(Context context) {
        Random random = new Random();
        String[] stringArray = context.getResources().getStringArray(C1116c.colors);
        return Color.parseColor(stringArray[random.nextInt(stringArray.length)]);
    }
}
