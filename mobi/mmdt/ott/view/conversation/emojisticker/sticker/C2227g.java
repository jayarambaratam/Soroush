package mobi.mmdt.ott.view.conversation.emojisticker.sticker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.felipecsl.asymmetricgridview.library.widget.AsymmetricGridView;
import com.felipecsl.asymmetricgridview.library.widget.C1058d;
import java.util.List;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.sticker.g */
class C2227g extends C1058d<StickerItemViewModel> {
    final /* synthetic */ C2222b f7332d;
    final /* synthetic */ C2226f f7333e;

    C2227g(C2226f c2226f, Context context, AsymmetricGridView asymmetricGridView, List list, C2222b c2222b) {
        this.f7333e = c2226f;
        this.f7332d = c2222b;
        super(context, asymmetricGridView, list);
    }

    public View m10121a(int i, View view, ViewGroup viewGroup) {
        return this.f7333e.getView(i, view, viewGroup);
    }
}
