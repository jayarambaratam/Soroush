package mobi.mmdt.ott.view.about;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import net.frakbot.glowpadbackport.BuildConfig;

public class AboutFragment extends Fragment {
    private View f5561a;

    private void m8495a() {
        Point f = C1111c.m6414f(getActivity());
        int i = getResources().getConfiguration().orientation == 1 ? (f.x * 50) / 100 : (f.y * 50) / 100;
        ImageView imageView = (ImageView) this.f5561a.findViewById(2131689649);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(i, i);
        layoutParams.gravity = 17;
        imageView.setLayoutParams(layoutParams);
    }

    private void m8496b() {
        String str = C1309a.m6934a(getActivity()).m6937a().equals("fa") ? "?fa" : BuildConfig.FLAVOR;
        TextView textView = (TextView) this.f5561a.findViewById(2131689786);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml("<font color=\"#FF4444\"><a href='http://www.soroush-app.ir" + str + "'>www.soroush-app.ir</a></font>"));
        textView = (TextView) this.f5561a.findViewById(2131689784);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml("<font color=\"#FF4444\"><a href='http://soroush-app.me/feedback" + str + "'>" + getString(2131230927) + "</a></font>"));
        textView = (TextView) this.f5561a.findViewById(2131689782);
        textView.setClickable(true);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(Html.fromHtml("<font color=\"#FF4444\"><a href='tel:00982127862020'>" + getString(2131231428) + "</a></font>"));
        String str2 = BuildConfig.FLAVOR;
        try {
            str = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
            str = str2;
        }
        ((TextView) this.f5561a.findViewById(2131689779)).setText(getString(2131230964) + ": " + str);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5561a = layoutInflater.inflate(2130968706, viewGroup, false);
        m8496b();
        m8495a();
        return this.f5561a;
    }
}
