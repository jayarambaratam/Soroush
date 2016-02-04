package mobi.mmdt.ott.view.conversation.emojisticker.sticker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.WrapperListAdapter;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.C1058d;
import com.p032a.p033a.C0872i;
import java.util.List;
import mobi.mmdt.componentsutils.C1119f;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.sticker.f */
public class C2226f extends ArrayAdapter<StickerItemViewModel> implements WrapperListAdapter {
    final /* synthetic */ C2222b f7329a;
    private final C1058d<StickerItemViewModel> f7330b;
    private LayoutInflater f7331c;

    public C2226f(C2222b c2222b, Context context, AsymmetricGridView asymmetricGridView, List<StickerItemViewModel> list) {
        this.f7329a = c2222b;
        super(context, 0, list);
        this.f7331c = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f7330b = new C2227g(this, context, asymmetricGridView, list, c2222b);
    }

    @SuppressLint({"ViewHolder"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        StickerItemViewModel stickerItemViewModel = (StickerItemViewModel) getItem(i);
        View inflate = this.f7331c.inflate(2130968812, viewGroup, false);
        C2228h c2228h = new C2228h(this);
        c2228h.f7334a = (ImageView) inflate.findViewById(C1119f.image);
        inflate.setTag(c2228h);
        if (stickerItemViewModel.m10105e() != null) {
            C0872i.m5265a(this.f7329a.f7321e).m5329a(stickerItemViewModel.m10105e()).m4406a(0.25f).m4406a(0.25f).m4417a(c2228h.f7334a);
        }
        return inflate;
    }

    public ListAdapter getWrappedAdapter() {
        return this.f7330b;
    }
}
