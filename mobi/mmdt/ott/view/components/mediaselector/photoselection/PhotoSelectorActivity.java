package mobi.mmdt.ott.view.components.mediaselector.photoselection;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class PhotoSelectorActivity extends C1685b implements C1908f {
    private int f6115i;
    private int f6116j;
    private C1911c f6117k;
    private ActionMode f6118l;
    private String f6119m;
    private boolean f6120n;

    public PhotoSelectorActivity() {
        this.f6115i = 2;
        this.f6116j = 10;
    }

    private void m9112a(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("KEY_PHOTO_ARRAYLIST_OF_PATH_RESULT", arrayList);
        setResult(-1, intent);
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    private LinkedHashMap<String, Boolean> m9118m() {
        return ((MyApplication) getApplication()).f4172c;
    }

    public void m9119a(int i) {
        if (this.f6118l == null) {
            return;
        }
        if (this.f6117k.m9135a()) {
            this.f6118l.setSubtitle(i + "/" + this.f6116j + "  " + getString(2131230924));
        } else {
            this.f6118l.setSubtitle(null);
        }
    }

    public void m9120a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        m9112a(arrayList);
    }

    public void m9121l() {
        int size = m9118m().size();
        if (size == 0 && this.f6120n) {
            this.f6118l.finish();
        } else if (!this.f6120n) {
            this.f6118l = startActionMode(new C1910b(this));
            this.f6120n = true;
        }
        m9119a(size);
    }

    public void onBackPressed() {
        if (this.f6120n) {
            m9118m().clear();
            this.f6118l.finish();
            return;
        }
        super.onBackPressed();
        setResult(0);
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        Bundle extras;
        super.m8487a(bundle, true);
        setContentView(2130968620);
        m3618a((Toolbar) findViewById(2131689633));
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            extras = getIntent().getExtras();
            if (extras.containsKey("EXTRA_SELECT_MODE")) {
                this.f6115i = extras.getInt("EXTRA_SELECT_MODE");
            }
            if (extras.containsKey("EXTRA_MAX_PHOTO_SELECT_COUNT")) {
                this.f6116j = extras.getInt("EXTRA_MAX_PHOTO_SELECT_COUNT");
            }
        }
        extras = new Bundle();
        if (bundle != null) {
            if (bundle.containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
                extras.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", bundle.getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION"));
            }
            if (bundle.containsKey("KEY_IS_ACTION_MODE_SHOWING")) {
                this.f6120n = bundle.getBoolean("KEY_IS_ACTION_MODE_SHOWING");
            }
        }
        this.f6119m = getIntent().getStringExtra("KEY_FOLDER_NAME");
        String stringExtra = getIntent().getStringExtra("KEY_FOLDER_PATH");
        extras.putInt("EXTRA_SELECT_MODE", this.f6115i);
        extras.putInt("EXTRA_MAX_PHOTO_SELECT_COUNT", this.f6116j);
        extras.putString("KEY_FOLDER_NAME", this.f6119m);
        extras.putString("KEY_FOLDER_PATH", stringExtra);
        this.f6117k = new C1911c();
        this.f6117k.setArguments(extras);
        m8492e(this.f6119m);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f6117k);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
        if (this.f6120n) {
            this.f6117k.m9139c();
            this.f6118l = startActionMode(new C1910b(this));
            m9121l();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f6115i != 2) {
            getMenuInflater().inflate(2131755051, menu);
        }
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != 2131690003) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            this.f6117k.m9139c();
            this.f6118l = startActionMode(new C1910b(this));
            this.f6120n = true;
            return true;
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", this.f6117k.m9136b());
        bundle.putBoolean("KEY_IS_ACTION_MODE_SHOWING", this.f6120n);
    }
}
