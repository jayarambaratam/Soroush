package mobi.mmdt.ott.view.call;

import android.app.Activity;
import android.app.Fragment;
import android.app.LoaderManager.LoaderCallbacks;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;

/* renamed from: mobi.mmdt.ott.view.call.v */
public class C1707v extends Fragment {
    private ImageView f5603a;
    private ImageView f5604b;
    private Button f5605c;
    private TextView f5606d;
    private TextView f5607e;
    private RoundAvatarImageView f5608f;
    private String f5609g;
    private String f5610h;
    private boolean f5611i;
    private LoaderCallbacks<Cursor> f5612j;

    public C1707v() {
        this.f5611i = false;
        this.f5612j = new C1710y(this);
    }

    private void m8530a() {
        this.f5605c = (Button) getView().findViewById(2131689642);
        this.f5603a = (ImageView) getView().findViewById(2131689632);
        this.f5608f = (RoundAvatarImageView) getView().findViewById(2131689706);
        this.f5604b = (ImageView) getView().findViewById(2131689795);
        this.f5606d = (TextView) getView().findViewById(2131689796);
        this.f5607e = (TextView) getView().findViewById(2131689646);
        int i = C1111c.m6414f(getActivity()).x;
        int i2 = (int) (((double) i) * 0.4d);
        int a = (int) ((((double) i) * 0.4d) + ((double) C1111c.m6388a(getActivity(), 4.0f)));
        LayoutParams layoutParams = (LayoutParams) this.f5608f.getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i2;
        layoutParams = (LayoutParams) this.f5604b.getLayoutParams();
        layoutParams.height = a;
        layoutParams.width = a;
        if (this.f5610h != null && !this.f5610h.isEmpty()) {
            this.f5607e.setText(this.f5610h);
        }
    }

    public void m8536a(String str) {
        if (getActivity() != null) {
            getActivity().runOnUiThread(new C1708w(this, str));
        }
    }

    public void m8537b(String str) {
        C0872i.m5265a(getActivity()).m5329a(str).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f5608f);
        C0872i.m5265a(getActivity()).m5329a(str).m5047j().m4306a(C0652e.ALL).m4328c().m4305a(256, 256).m4285a(new C1709x(this, this.f5603a));
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null && getArguments().containsKey("key_contact_user_id_string")) {
            this.f5609g = getArguments().getString("key_contact_user_id_string");
            this.f5610h = getArguments().getString("key_call_status_message_string");
        }
        getLoaderManager().initLoader(1, null, this.f5612j);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(2130968708, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        m8530a();
    }
}
