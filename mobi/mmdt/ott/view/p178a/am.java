package mobi.mmdt.ott.view.p178a;

import android.text.util.Linkify;
import android.util.Patterns;
import android.widget.TextView;

/* renamed from: mobi.mmdt.ott.view.a.am */
public class am {
    public static void m8479a(TextView textView) {
        Linkify.addLinks(textView, 1);
        Linkify.addLinks(textView, Patterns.PHONE, "tel:");
        Linkify.addLinks(textView, Patterns.EMAIL_ADDRESS, "mailto:");
    }
}
