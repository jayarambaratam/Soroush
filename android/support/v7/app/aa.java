package android.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

class aa implements OnItemClickListener {
    final /* synthetic */ ListView f1768a;
    final /* synthetic */ C0391q f1769b;
    final /* synthetic */ C0397w f1770c;

    aa(C0397w c0397w, ListView listView, C0391q c0391q) {
        this.f1770c = c0397w;
        this.f1768a = listView;
        this.f1769b = c0391q;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.f1770c.f1960C != null) {
            this.f1770c.f1960C[i] = this.f1768a.isItemChecked(i);
        }
        this.f1770c.f1964G.onClick(this.f1769b.f1920b, i, this.f1768a.isItemChecked(i));
    }
}
