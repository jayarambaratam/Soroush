package mobi.mmdt.ott.view.settings.forceupdate;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.p032a.p033a.C0872i;

public class ForceUpdateFragment extends Fragment {
    private C2524c f8137a;
    private View f8138b;
    private ImageView f8139c;
    private TextView f8140d;
    private TextView f8141e;
    private OnClickListener f8142f;
    private OnClickListener f8143g;

    public ForceUpdateFragment() {
        this.f8142f = new C2525a(this);
        this.f8143g = new C2526b(this);
    }

    private void m10864a() {
        this.f8139c = (ImageView) this.f8138b.findViewById(2131689670);
        this.f8140d = (TextView) this.f8138b.findViewById(2131689856);
        this.f8141e = (TextView) this.f8138b.findViewById(2131689857);
        this.f8140d.setOnClickListener(this.f8142f);
        this.f8141e.setOnClickListener(this.f8143g);
        m10865b();
        C0872i.m5265a(getActivity()).m5328a(Integer.valueOf(2130838521)).m4418b().m4406a(0.25f).m4417a(this.f8139c);
    }

    private void m10865b() {
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = getResources().getConfiguration().orientation == 1 ? (point.x * 60) / 100 : (point.y * 60) / 100;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(13);
        this.f8139c.setLayoutParams(layoutParams);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f8137a = (C2524c) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IForceUpdateFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8138b = layoutInflater.inflate(2130968727, viewGroup, false);
        return this.f8138b;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        m10864a();
    }
}
