package mobi.mmdt.ott.view.components.mediaselector.photoselection;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.photoselection.b */
public class C1910b implements Callback {
    final /* synthetic */ PhotoSelectorActivity f6121a;

    public C1910b(PhotoSelectorActivity photoSelectorActivity) {
        this.f6121a = photoSelectorActivity;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() != 2131689999) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f6121a.m9118m().keySet());
        this.f6121a.m9118m().clear();
        this.f6121a.m9112a(arrayList);
        return true;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(2131755045, menu);
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f6121a.f6117k.m9140d();
        this.f6121a.f6120n = false;
        this.f6121a.m9118m().clear();
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        actionMode.setTitle(this.f6121a.f6119m);
        actionMode.setSubtitle(this.f6121a.m9118m().size() + "/" + this.f6121a.f6116j + "  " + this.f6121a.getString(2131230924));
        return false;
    }
}
