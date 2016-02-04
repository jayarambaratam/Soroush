package mobi.mmdt.ott.view.conversation.groupinfo;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;

class ab implements OnClickListener {
    final /* synthetic */ C2275z f7426a;

    ab(C2275z c2275z) {
        this.f7426a = c2275z;
    }

    public void onClick(View view) {
        Snackbar.m377a(this.f7426a.f7503b.f7501a.i, (CharSequence) "No media found!", -1).m395a();
    }
}
