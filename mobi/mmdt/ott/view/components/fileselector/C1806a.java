package mobi.mmdt.ott.view.components.fileselector;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* renamed from: mobi.mmdt.ott.view.components.fileselector.a */
public class C1806a implements Callback {
    final /* synthetic */ FileSelectorActivity f5813a;

    public C1806a(FileSelectorActivity fileSelectorActivity) {
        this.f5813a = fileSelectorActivity;
    }

    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        if (menuItem.getItemId() != 2131689999) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f5813a.m8776n().keySet());
        this.f5813a.m8776n().clear();
        this.f5813a.m8770a(arrayList);
        return true;
    }

    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        actionMode.getMenuInflater().inflate(2131755045, menu);
        return true;
    }

    public void onDestroyActionMode(ActionMode actionMode) {
        this.f5813a.f5794l.m8818d();
        this.f5813a.f5798p = false;
        this.f5813a.m8776n().clear();
    }

    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        actionMode.setTitle(this.f5813a.f5796n);
        actionMode.setSubtitle(this.f5813a.m8776n().size() + "/" + this.f5813a.f5793k + "  selected");
        return false;
    }
}
