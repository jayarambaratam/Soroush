package android.support.v7.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.support.v4.app.bg;
import android.support.v4.app.ce;
import android.support.v7.p019a.C0362e;
import android.support.v7.p019a.C0364g;
import android.support.v7.p019a.C0365h;
import android.support.v7.p019a.C0366i;
import android.support.v7.p019a.C0367j;
import android.widget.RemoteViews;
import java.text.NumberFormat;
import java.util.List;

class bq {
    private static int m3675a(int i) {
        return i <= 3 ? C0366i.notification_template_big_media_narrow : C0366i.notification_template_big_media;
    }

    private static RemoteViews m3676a(Context context, ce ceVar) {
        Object obj = ceVar.m1154c() == null ? 1 : null;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), C0366i.notification_media_action);
        remoteViews.setImageViewResource(C0364g.action0, ceVar.m1152a());
        if (obj == null) {
            remoteViews.setOnClickPendingIntent(C0364g.action0, ceVar.m1154c());
        }
        if (VERSION.SDK_INT >= 15) {
            remoteViews.setContentDescription(C0364g.action0, ceVar.m1153b());
        }
        return remoteViews;
    }

    private static RemoteViews m3677a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, int i2, boolean z2) {
        Object obj;
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), i2);
        Object obj2 = null;
        Object obj3 = null;
        if (bitmap == null || VERSION.SDK_INT < 16) {
            remoteViews.setViewVisibility(C0364g.icon, 8);
        } else {
            remoteViews.setViewVisibility(C0364g.icon, 0);
            remoteViews.setImageViewBitmap(C0364g.icon, bitmap);
        }
        if (charSequence != null) {
            remoteViews.setTextViewText(C0364g.title, charSequence);
        }
        if (charSequence2 != null) {
            remoteViews.setTextViewText(C0364g.text, charSequence2);
            obj2 = 1;
        }
        if (charSequence3 != null) {
            remoteViews.setTextViewText(C0364g.info, charSequence3);
            remoteViews.setViewVisibility(C0364g.info, 0);
            obj = 1;
        } else if (i > 0) {
            if (i > context.getResources().getInteger(C0365h.status_bar_notification_info_maxnum)) {
                remoteViews.setTextViewText(C0364g.info, context.getResources().getString(C0367j.status_bar_notification_info_overflow));
            } else {
                remoteViews.setTextViewText(C0364g.info, NumberFormat.getIntegerInstance().format((long) i));
            }
            remoteViews.setViewVisibility(C0364g.info, 0);
            int i3 = 1;
        } else {
            remoteViews.setViewVisibility(C0364g.info, 8);
            obj = obj2;
        }
        if (charSequence4 != null && VERSION.SDK_INT >= 16) {
            remoteViews.setTextViewText(C0364g.text, charSequence4);
            if (charSequence2 != null) {
                remoteViews.setTextViewText(C0364g.text2, charSequence2);
                remoteViews.setViewVisibility(C0364g.text2, 0);
                obj3 = 1;
            } else {
                remoteViews.setViewVisibility(C0364g.text2, 8);
            }
        }
        if (obj3 != null && VERSION.SDK_INT >= 16) {
            if (z2) {
                remoteViews.setTextViewTextSize(C0364g.text, 0, (float) context.getResources().getDimensionPixelSize(C0362e.notification_subtext_size));
            }
            remoteViews.setViewPadding(C0364g.line1, 0, 0, 0, 0);
        }
        if (j != 0) {
            if (z) {
                remoteViews.setViewVisibility(C0364g.chronometer, 0);
                remoteViews.setLong(C0364g.chronometer, "setBase", (SystemClock.elapsedRealtime() - System.currentTimeMillis()) + j);
                remoteViews.setBoolean(C0364g.chronometer, "setStarted", true);
            } else {
                remoteViews.setViewVisibility(C0364g.time, 0);
                remoteViews.setLong(C0364g.time, "setTime", j);
            }
        }
        remoteViews.setViewVisibility(C0364g.line3, obj != null ? 0 : 8);
        return remoteViews;
    }

    private static <T extends ce> RemoteViews m3678a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        int min = Math.min(list.size(), 5);
        RemoteViews a = m3677a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, m3675a(min), false);
        a.removeAllViews(C0364g.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                a.addView(C0364g.media_actions, m3676a(context, (ce) list.get(i2)));
            }
        }
        if (z2) {
            a.setViewVisibility(C0364g.cancel_action, 0);
            a.setInt(C0364g.cancel_action, "setAlpha", context.getResources().getInteger(C0365h.cancel_button_image_alpha));
            a.setOnClickPendingIntent(C0364g.cancel_action, pendingIntent);
        } else {
            a.setViewVisibility(C0364g.cancel_action, 8);
        }
        return a;
    }

    private static <T extends ce> RemoteViews m3679a(Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        RemoteViews a = m3677a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, C0366i.notification_template_media, true);
        int size = list.size();
        int min = iArr == null ? 0 : Math.min(iArr.length, 3);
        a.removeAllViews(C0364g.media_actions);
        if (min > 0) {
            for (int i2 = 0; i2 < min; i2++) {
                if (i2 >= size) {
                    throw new IllegalArgumentException(String.format("setShowActionsInCompactView: action %d out of bounds (max %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(size - 1)}));
                }
                a.addView(C0364g.media_actions, m3676a(context, (ce) list.get(iArr[i2])));
            }
        }
        if (z2) {
            a.setViewVisibility(C0364g.end_padder, 8);
            a.setViewVisibility(C0364g.cancel_action, 0);
            a.setOnClickPendingIntent(C0364g.cancel_action, pendingIntent);
            a.setInt(C0364g.cancel_action, "setAlpha", context.getResources().getInteger(C0365h.cancel_button_image_alpha));
        } else {
            a.setViewVisibility(C0364g.end_padder, 0);
            a.setViewVisibility(C0364g.cancel_action, 8);
        }
        return a;
    }

    public static <T extends ce> void m3680a(Notification notification, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, boolean z2, PendingIntent pendingIntent) {
        notification.bigContentView = m3678a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, list, z2, pendingIntent);
        if (z2) {
            notification.flags |= 2;
        }
    }

    public static <T extends ce> void m3681a(bg bgVar, Context context, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i, Bitmap bitmap, CharSequence charSequence4, boolean z, long j, List<T> list, int[] iArr, boolean z2, PendingIntent pendingIntent) {
        bgVar.m1145a().setContent(m3679a(context, charSequence, charSequence2, charSequence3, i, bitmap, charSequence4, z, j, (List) list, iArr, z2, pendingIntent));
        if (z2) {
            bgVar.m1145a().setOngoing(true);
        }
    }
}
