package mobi.mmdt.ott.view.p178a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import org.apache.http.myHttp.protocol.HTTP;

/* renamed from: mobi.mmdt.ott.view.a.ao */
public class ao {
    public static void m8482a(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType(HTTP.PLAIN_TEXT_TYPE);
        activity.startActivity(Intent.createChooser(intent, activity.getResources().getText(2131230939)));
    }

    public static void m8483b(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(str));
        intent.setType("image/*");
        intent.addFlags(1);
        activity.startActivity(Intent.createChooser(intent, activity.getResources().getText(2131230939)));
    }

    public static void m8484c(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(str));
        intent.setType("video/*");
        intent.addFlags(1);
        activity.startActivity(Intent.createChooser(intent, activity.getResources().getText(2131230939)));
    }

    public static void m8485d(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(str));
        intent.setType("*/*");
        intent.addFlags(1);
        activity.startActivity(Intent.createChooser(intent, activity.getResources().getText(2131230939)));
    }
}
