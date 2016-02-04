package mobi.mmdt.ott.view.settings.mainsettings.profile_info.deactivate_account;

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

public class DeactivateAccountFragment extends Fragment {
    private C2551j f8183a;
    private View f8184b;
    private ImageView f8185c;
    private TextView f8186d;
    private TextView f8187e;
    private OnClickListener f8188f;
    private OnClickListener f8189g;

    public DeactivateAccountFragment() {
        this.f8188f = new C2559h(this);
        this.f8189g = new C2560i(this);
    }

    private void m10924a() {
        this.f8185c = (ImageView) this.f8184b.findViewById(2131689670);
        this.f8186d = (TextView) this.f8184b.findViewById(2131689847);
        this.f8187e = (TextView) this.f8184b.findViewById(2131689848);
        this.f8186d.setOnClickListener(this.f8188f);
        this.f8187e.setOnClickListener(this.f8189g);
        m10925b();
        C0872i.m5265a(getActivity()).m5328a(Integer.valueOf(2130838500)).m4418b().m4406a(0.25f).m4417a(this.f8185c);
    }

    private void m10925b() {
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = getResources().getConfiguration().orientation == 1 ? (point.x * 60) / 100 : (point.y * 60) / 100;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(13);
        this.f8185c.setLayoutParams(layoutParams);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f8183a = (C2551j) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IDeactivateAccountFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8184b = layoutInflater.inflate(2130968721, viewGroup, false);
        return this.f8184b;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        m10924a();
    }
}
