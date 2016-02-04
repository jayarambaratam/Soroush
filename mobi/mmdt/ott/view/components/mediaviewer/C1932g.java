package mobi.mmdt.ott.view.components.mediaviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.view.components.mediaviewer.p207a.C1919b;
import mobi.mmdt.ott.view.components.mediaviewer.p207a.C1921d;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1721e;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.g */
public class C1932g extends C1721e {
    final /* synthetic */ MediaViewerActivity f6201a;

    public C1932g(MediaViewerActivity mediaViewerActivity, Context context) {
        this.f6201a = mediaViewerActivity;
        super(context);
    }

    public C1712b m9199a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C1919b(this.f6201a.m8494q(), null, m8654a(), viewGroup);
            case VideoSize.HVGA /*2*/:
                return new C1921d(this.f6201a.m8494q(), null, m8654a(), viewGroup);
            default:
                return null;
        }
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m9199a(viewGroup, i);
    }
}
