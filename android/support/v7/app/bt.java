package android.support.v7.app;

import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;

class bt implements OnMenuItemClickListener {
    final /* synthetic */ br f1818a;

    bt(br brVar) {
        this.f1818a = brVar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.f1818a.f1810c.onMenuItemSelected(0, menuItem);
    }
}
