package mobi.mmdt.ott.view.conversation;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.akexorcist.roundcornerprogressbar.TextRoundCornerProgressBar;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.p095c.p096a.p098b.p099a.ah;
import mobi.mmdt.ott.p095c.p096a.p098b.p100b.af;
import org.apache.http.myHttp.protocol.HTTP;

/* renamed from: mobi.mmdt.ott.view.conversation.b */
public class C2024b {
    public static void m9657a(Activity activity, af afVar) {
        android.support.v7.app.af afVar2 = new android.support.v7.app.af(activity, 2131427471);
        afVar2.m3606a(afVar.m6731c());
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View inflate = layoutInflater.inflate(2130968693, null);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(2131689742);
        long b = afVar.m6730b();
        ah[] a = afVar.m6729a();
        for (int i = 0; i < a.length; i++) {
            View inflate2 = layoutInflater.inflate(2130968790, null);
            TextRoundCornerProgressBar textRoundCornerProgressBar = (TextRoundCornerProgressBar) inflate2.findViewById(2131689935);
            ((TextView) inflate2.findViewById(2131689740)).setText(a[i].m6629c());
            textRoundCornerProgressBar.setProgressText(C1111c.m6412e((int) a[i].m6630d()));
            float f = 0.0f;
            if (b > 0) {
                f = (((float) a[i].m6630d()) / ((float) b)) * 100.0f;
            }
            textRoundCornerProgressBar.setProgress(f);
            linearLayout.addView(inflate2);
        }
        ((TextView) inflate.findViewById(2131689762)).setText("Total Voters: " + C1111c.m6412e((int) b));
        afVar2.m3609b(inflate);
        afVar2.m3611b(HTTP.CONN_CLOSE, null);
        afVar2.m3612c();
    }
}
