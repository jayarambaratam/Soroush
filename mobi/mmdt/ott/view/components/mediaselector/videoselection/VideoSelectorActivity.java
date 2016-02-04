package mobi.mmdt.ott.view.components.mediaselector.videoselection;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class VideoSelectorActivity extends C1685b implements C1914d {
    private C1915a f6138i;

    public void m9144a(String str) {
        Intent intent = new Intent();
        intent.putExtra("KEY_VIDEO_PATH_RESULT", str);
        setResult(-1, intent);
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968621);
        m3618a((Toolbar) findViewById(2131689633));
        String stringExtra = getIntent().getStringExtra("KEY_FOLDER_NAME");
        String stringExtra2 = getIntent().getStringExtra("KEY_FOLDER_PATH");
        Bundle bundle2 = new Bundle();
        bundle2.putString("KEY_FOLDER_NAME", stringExtra);
        bundle2.putString("KEY_FOLDER_PATH", stringExtra2);
        this.f6138i = new C1915a();
        this.f6138i.setArguments(bundle2);
        m8492e(stringExtra);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f6138i);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onRestoreInstanceState(Bundle bundle) {
    }

    public void onSaveInstanceState(Bundle bundle) {
    }
}
