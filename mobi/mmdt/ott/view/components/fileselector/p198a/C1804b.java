package mobi.mmdt.ott.view.components.fileselector.p198a;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import mobi.mmdt.ott.view.components.fileselector.p199b.C1808b;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.a.b */
class C1804b implements OnCheckedChangeListener {
    final /* synthetic */ C1803a f5807a;

    C1804b(C1803a c1803a) {
        this.f5807a = c1803a;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (!this.f5807a.f5806h) {
            if (z) {
                this.f5807a.f5800b.m8800a((C1808b) this.f5807a.m8619a());
            } else {
                this.f5807a.f5800b.m8801b((C1808b) this.f5807a.m8619a());
            }
        }
    }
}
