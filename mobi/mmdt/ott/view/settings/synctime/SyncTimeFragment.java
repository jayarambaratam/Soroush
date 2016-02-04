package mobi.mmdt.ott.view.settings.synctime;

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

public class SyncTimeFragment extends Fragment {
    private C2562c f8202a;
    private View f8203b;
    private ImageView f8204c;
    private TextView f8205d;
    private TextView f8206e;
    private OnClickListener f8207f;
    private OnClickListener f8208g;

    public SyncTimeFragment() {
        this.f8207f = new C2563a(this);
        this.f8208g = new C2564b(this);
    }

    private void m10931a() {
        this.f8204c = (ImageView) this.f8203b.findViewById(2131689670);
        this.f8205d = (TextView) this.f8203b.findViewById(2131689896);
        this.f8206e = (TextView) this.f8203b.findViewById(2131689857);
        this.f8205d.setOnClickListener(this.f8207f);
        this.f8206e.setOnClickListener(this.f8208g);
        m10932b();
        C0872i.m5265a(getActivity()).m5328a(Integer.valueOf(2130838586)).m4418b().m4406a(0.25f).m4417a(this.f8204c);
    }

    private void m10932b() {
        Display defaultDisplay = ((WindowManager) getActivity().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = getResources().getConfiguration().orientation == 1 ? (point.x * 60) / 100 : (point.y * 60) / 100;
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(13);
        this.f8204c.setLayoutParams(layoutParams);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f8202a = (C2562c) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement ISyncTimeFragmentCallback" + ".");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f8203b = layoutInflater.inflate(2130968754, viewGroup, false);
        return this.f8203b;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        m10931a();
    }
}
