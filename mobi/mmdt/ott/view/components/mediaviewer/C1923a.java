package mobi.mmdt.ott.view.components.mediaviewer;

import com.p032a.p033a.p037d.p049d.p052b.C0742b;
import com.p032a.p033a.p045h.C0866h;
import com.p032a.p033a.p045h.p056b.C0778k;
import p025b.p026a.p027a.p028a.C0557d;

/* renamed from: mobi.mmdt.ott.view.components.mediaviewer.a */
class C1923a implements C0866h<String, C0742b> {
    final /* synthetic */ ImageViewerActivity f6178a;

    C1923a(ImageViewerActivity imageViewerActivity) {
        this.f6178a = imageViewerActivity;
    }

    public boolean m9184a(C0742b c0742b, String str, C0778k<C0742b> c0778k, boolean z, boolean z2) {
        new C0557d(this.f6178a.f6152j).m4204a(10.0f);
        this.f6178a.f6154l.setVisibility(8);
        return false;
    }

    public boolean m9186a(Exception exception, String str, C0778k<C0742b> c0778k, boolean z) {
        if (this.f6178a.m8494q() != null) {
            this.f6178a.runOnUiThread(new C1927b(this));
        }
        return false;
    }
}
