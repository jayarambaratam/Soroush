package mobi.mmdt.ott.view.conversation.sharedmediaviewer;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.io.File;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.p178a.C1659a;
import org.jivesoftware.smackx.xdata.packet.DataForm.Item;

public class SharedMediaViewerActivity extends C1685b implements C2276c {
    private C2279a f7504i;
    private String f7505j;
    private String f7506k;

    public void m10272a(int i) {
        String str = Item.ELEMENT;
        if (i > 1) {
            str = "items";
        }
        m8493f(i + " " + str);
    }

    public void m10273a(String str, boolean z) {
        if (new File(Uri.parse(str).getPath()).exists()) {
            C1659a.m8430a(m8494q(), str, this.f7506k, this.f7505j);
            return;
        }
        C1598c.m8096a(m8494q(), str, z ? C1604i.NOT_STARTED : C1604i.DELETED);
        Toast.makeText(m8494q(), "File not exists!", 0).show();
    }

    public void m10274b(String str, boolean z) {
        if (new File(Uri.parse(str).getPath()).exists()) {
            C1659a.m8428a(m8494q(), str);
            return;
        }
        C1598c.m8096a(m8494q(), str, z ? C1604i.NOT_STARTED : C1604i.DELETED);
        Toast.makeText(m8494q(), "File not exists!", 0).show();
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968627);
        m3618a((Toolbar) findViewById(2131689633));
        Bundle bundle2 = new Bundle();
        if (bundle != null && bundle.containsKey("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION")) {
            bundle2.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", bundle.getInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION"));
        }
        this.f7505j = getIntent().getStringExtra("KEY_TITLE_TEXT");
        this.f7506k = getIntent().getStringExtra("KEY_PEER_PARTY");
        bundle2.putString("KEY_TITLE_TEXT", this.f7505j);
        bundle2.putString("KEY_PEER_PARTY", this.f7506k);
        this.f7504i = new C2279a();
        this.f7504i.setArguments(bundle2);
        m8492e(this.f7505j);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f7504i);
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
        bundle.putInt("KEY_FIRST_COMPLETELY_VISIBLE_ITEM_POSITION", this.f7504i.m10283a());
    }
}
