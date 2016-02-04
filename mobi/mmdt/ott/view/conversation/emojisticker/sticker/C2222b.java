package mobi.mmdt.ott.view.conversation.emojisticker.sticker;

import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.felipecsl.asymmetricgridview.library.C1054o;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.C1058d;
import java.util.ArrayList;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.view.conversation.emojisticker.C2195a;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.sticker.b */
public class C2222b extends C2195a implements OnItemClickListener {
    private FrameLayout f7318b;
    private View f7319c;
    private int f7320d;
    private Activity f7321e;
    private C1058d<StickerItemViewModel> f7322f;
    private LoaderCallbacks<Cursor> f7323g;

    private C2222b(Activity activity, int i) {
        this.f7323g = new C2223c(this);
        this.f7321e = activity;
        this.f7320d = i;
        this.f7318b = new FrameLayout(this.f7321e);
        m10117b();
        this.f7318b.addView(this.f7319c);
    }

    public static C2222b m10115a(Activity activity, int i) {
        return new C2222b(activity, i);
    }

    private void m10117b() {
        View asymmetricGridView = new AsymmetricGridView(this.f7321e);
        ListAdapter c2226f = new C2226f(this, this.f7321e, asymmetricGridView, new ArrayList());
        this.f7322f = (C1058d) ((WrapperListAdapter) c2226f).getWrappedAdapter();
        asymmetricGridView.setRequestedColumnCount(C1111c.m6413e(this.f7321e) ? 5 : 10);
        asymmetricGridView.setRequestedHorizontalSpacing(C1054o.m6245a(this.f7321e, 1.0f));
        asymmetricGridView.setAdapter(c2226f);
        asymmetricGridView.setDebugging(false);
        asymmetricGridView.setDivider(this.f7321e.getResources().getDrawable(2130838627));
        asymmetricGridView.setOnItemClickListener(this);
        this.f7319c = asymmetricGridView;
        this.f7321e.getLoaderManager().initLoader(this.f7320d, null, this.f7323g);
    }

    public View m10119a() {
        return this.f7318b;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        StickerItemViewModel stickerItemViewModel = (StickerItemViewModel) adapterView.getItemAtPosition(i);
        if (this.a != null) {
            this.a.m10034a(stickerItemViewModel.m10109i(), stickerItemViewModel.m10107g(), stickerItemViewModel.m10104d(), stickerItemViewModel.m10110j());
        }
    }
}
