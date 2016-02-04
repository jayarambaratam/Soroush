package mobi.mmdt.ott.view.components.fileselector;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class FileSelectorActivity extends C1685b implements C1802g {
    public static final HashMap<String, String> f5791i;
    private int f5792j;
    private int f5793k;
    private C1811b f5794l;
    private ActionMode f5795m;
    private String f5796n;
    private String f5797o;
    private boolean f5798p;

    static {
        f5791i = new HashMap();
        f5791i.put("jpg", "jpg");
        f5791i.put("jpeg", "jpeg");
        f5791i.put("png", "png");
        f5791i.put("gif", "gif");
        f5791i.put("jp2", "jp2");
        f5791i.put("jpe", "jpe");
        f5791i.put("jfif", "jfif");
        f5791i.put("avi", "avi");
        f5791i.put("mp4", "mp4");
        f5791i.put("3gp", "3gp");
        f5791i.put("flv", "flv");
        f5791i.put("mp3", "mp3");
        f5791i.put("wav", "wav");
        f5791i.put("amr", "amr");
        f5791i.put("ogg", "ogg");
        f5791i.put("vct", "vct");
        f5791i.put("pdf", "pdf");
        f5791i.put("doc", "doc");
        f5791i.put("docx", "docx");
        f5791i.put("xls", "xls");
        f5791i.put("xlsx", "xlsx");
        f5791i.put("ppt", "ppt");
        f5791i.put("pptx", "pptx");
        f5791i.put("xml", "xml");
        f5791i.put("csv", "csv");
    }

    public FileSelectorActivity() {
        this.f5792j = 1;
        this.f5793k = 10;
    }

    private void m8769a(String str, boolean z) {
        Bundle bundle = new Bundle();
        this.f5797o = str;
        this.f5796n = new File(str).getName();
        bundle.putString("KEY_FOLDER_PATH", this.f5797o);
        this.f5794l = new C1811b();
        this.f5794l.setArguments(bundle);
        if (this.f5797o.equals("/")) {
            this.f5796n = "/";
        }
        m8492e(this.f5796n);
        if (this.f5795m != null) {
            this.f5795m.setTitle(this.f5796n);
        }
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (z) {
            beginTransaction.setCustomAnimations(2131099651, 2131099649);
        } else {
            beginTransaction.setCustomAnimations(2131099648, 2131099650);
        }
        beginTransaction.replace(2131689637, this.f5794l);
        beginTransaction.commit();
    }

    private void m8770a(ArrayList<String> arrayList) {
        Intent intent = new Intent();
        intent.putExtra("KEY_FILE_ARRAYLIST_OF_PATH_RESULT", arrayList);
        setResult(-1, intent);
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    private LinkedHashMap<String, Boolean> m8776n() {
        return ((MyApplication) getApplication()).f4173d;
    }

    public void m8777a(int i) {
        if (this.f5795m == null) {
            return;
        }
        if (this.f5794l.m8816b()) {
            this.f5795m.setSubtitle(i + "/" + this.f5793k + "  selected");
        } else {
            this.f5795m.setSubtitle(null);
        }
    }

    public void m8778a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        m8770a(arrayList);
    }

    public void m8779b(String str) {
        m8769a(str, false);
    }

    public void m8780l() {
        int size = m8776n().size();
        if (size == 0 && this.f5798p) {
            this.f5795m.finish();
        } else if (!this.f5798p) {
            this.f5795m = startActionMode(new C1806a(this));
            this.f5798p = true;
        }
        m8777a(size);
    }

    public boolean m8781m() {
        if (new File(this.f5797o).getAbsolutePath().equals(Environment.getExternalStorageDirectory().getAbsolutePath())) {
            return false;
        }
        String parent = new File(this.f5797o).getParent();
        if (parent == null) {
            return false;
        }
        m8769a(parent, true);
        return true;
    }

    public void onBackPressed() {
        if (!m8781m()) {
            super.onBackPressed();
            setResult(0);
            overridePendingTransition(2131034126, 2131034130);
        }
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        Bundle extras;
        super.m8487a(bundle, true);
        setContentView(2130968611);
        m3618a((Toolbar) findViewById(2131689633));
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            extras = getIntent().getExtras();
            if (extras.containsKey("EXTRA_SELECT_MODE")) {
                this.f5792j = extras.getInt("EXTRA_SELECT_MODE");
            }
            if (extras.containsKey("EXTRA_MAX_PHOTO_SELECT_COUNT")) {
                this.f5793k = extras.getInt("EXTRA_MAX_PHOTO_SELECT_COUNT");
            }
        }
        extras = new Bundle();
        if (bundle != null) {
            if (bundle.containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
                extras.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", bundle.getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION"));
            }
            if (bundle.containsKey("KEY_IS_ACTION_MODE_SHOWING")) {
                this.f5798p = bundle.getBoolean("KEY_IS_ACTION_MODE_SHOWING");
            }
            if (bundle.containsKey("KEY_FOLDER_PATH")) {
                this.f5797o = bundle.getString("KEY_FOLDER_PATH");
            }
        }
        if (this.f5797o == null) {
            this.f5797o = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        this.f5796n = new File(this.f5797o).getName();
        extras.putInt("EXTRA_SELECT_MODE", this.f5792j);
        extras.putInt("EXTRA_MAX_PHOTO_SELECT_COUNT", this.f5793k);
        extras.putString("KEY_FOLDER_PATH", this.f5797o);
        this.f5794l = new C1811b();
        this.f5794l.setArguments(extras);
        m8492e(this.f5796n);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f5794l);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
        if (this.f5798p) {
            this.f5794l.m8817c();
            this.f5795m = startActionMode(new C1806a(this));
            m8780l();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.f5792j != 2) {
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
            this.f5794l.m8817c();
            this.f5795m = startActionMode(new C1806a(this));
            this.f5798p = true;
            return true;
        }
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", this.f5794l.m8811a());
        bundle.putBoolean("KEY_IS_ACTION_MODE_SHOWING", this.f5798p);
        bundle.putString("KEY_FOLDER_PATH", this.f5797o);
    }
}
