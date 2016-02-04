package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: android.support.v7.app.z */
class C0400z implements OnItemClickListener {
    final /* synthetic */ C0391q f2004a;
    final /* synthetic */ C0397w f2005b;

    C0400z(C0397w c0397w, C0391q c0391q) {
        this.f2005b = c0397w;
        this.f2004a = c0391q;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f2005b.f1991u.onClick(this.f2004a.f1920b, i);
        if (!this.f2005b.f1962E) {
            this.f2004a.f1920b.dismiss();
        }
    }
}
