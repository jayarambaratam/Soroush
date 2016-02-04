package mobi.mmdt.ott.view.components.mediaviewer;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1390x;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.view.components.mediaviewer.p208b.C1924a;
import mobi.mmdt.ott.view.components.mediaviewer.p208b.C1925b;
import mobi.mmdt.ott.view.components.mediaviewer.p208b.C1926c;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.recyclerviewpager.RecyclerViewPager;
import mobi.mmdt.ott.view.p178a.C1659a;
import mobi.mmdt.ott.view.p178a.ah;
import mobi.mmdt.ott.view.p178a.ao;
import org.linphone.core.VideoSize;

public class MediaViewerActivity extends C1685b implements LoaderCallbacks<Cursor> {
    private ProgressWheel f6155i;
    private C1932g f6156j;
    private ViewGroup f6157k;
    private RecyclerViewPager f6158l;
    private LinearLayoutManager f6159m;
    private String f6160n;
    private String f6161o;
    private String f6162p;
    private String f6163q;
    private int f6164r;
    private boolean f6165s;

    private int m9157a(int i) {
        return i == C1594n.IMAGE.ordinal() ? 1 : i == C1594n.VIDEO.ordinal() ? 2 : -1;
    }

    private C1722f m9160a(Cursor cursor, int i) {
        int i2 = cursor.getInt(cursor.getColumnIndex("_id"));
        cursor.getString(cursor.getColumnIndex("members_local_name"));
        String string = cursor.getString(cursor.getColumnIndex("members_nick_name"));
        String string2 = cursor.getString(cursor.getColumnIndex("conversations_party"));
        String string3 = cursor.getString(cursor.getColumnIndex("conversations_peer_user_id"));
        long j = cursor.getLong(cursor.getColumnIndex("conversations_send_time"));
        String string4 = cursor.getString(cursor.getColumnIndex("conversations_event"));
        String string5 = cursor.getString(cursor.getColumnIndex("conversations_message_id"));
        int i3 = cursor.getInt(cursor.getColumnIndex("conversations_event_type"));
        int i4 = cursor.getInt(cursor.getColumnIndex("conversations_direction_type"));
        String string6 = cursor.getString(cursor.getColumnIndex("files_file_uri"));
        long j2 = cursor.getLong(cursor.getColumnIndex("conversations_file_id"));
        String b = ah.m8470b(string, string3);
        if (i4 == C1592l.OUT.ordinal()) {
            b = "You";
        }
        switch (m9157a(i3)) {
            case VideoSize.CIF /*1*/:
                return new C1925b(i2, string2, b, string6, C1111c.m6404b(getApplicationContext(), j), string4, j2, string5, i);
            case VideoSize.HVGA /*2*/:
                return new C1926c(i2, string2, b, string6, C1111c.m6404b(getApplicationContext(), j), string4, j2, string5, i);
            default:
                return null;
        }
    }

    private void m9172l() {
        this.f6156j = new C1932g(this, m8494q());
        this.f6158l = (RecyclerViewPager) findViewById(2131689685);
        this.f6159m = new LinearLayoutManager(m8494q(), 0, false);
        this.f6158l.setLayoutManager(this.f6159m);
        this.f6158l.setAdapter(this.f6156j);
        this.f6158l.setHasFixedSize(true);
        this.f6158l.setLongClickable(true);
        this.f6158l.addOnScrollListener(new C1928c(this));
        this.f6158l.addOnLayoutChangeListener(new C1929d(this));
        getLoaderManager().initLoader(19, null, this);
    }

    public void m9173a(Loader<Cursor> loader, Cursor cursor) {
        if (this.f6156j != null && !this.f6165s) {
            new Thread(new C1930e(this, cursor)).start();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968622);
        m3618a((Toolbar) findViewById(2131689633));
        m8489a(getWindow(), getResources().getColor(2131623986));
        this.f6155i = (ProgressWheel) findViewById(C1119f.progress_wheel);
        this.f6157k = (ViewGroup) findViewById(2131689635);
        this.f6162p = C1309a.m6934a((Context) this).m6942b();
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.f6160n = getIntent().getStringExtra("KEY_PEER_PARTY");
            this.f6161o = getIntent().getStringExtra("KEY_TITLE");
            this.f6163q = getIntent().getStringExtra("KEY_CURRENT_MEDIA_PATH");
        }
        if (bundle != null) {
            if (bundle.containsKey("KEY_PEER_PARTY")) {
                this.f6160n = bundle.getString("KEY_PEER_PARTY");
            }
            if (bundle.containsKey("KEY_TITLE")) {
                this.f6161o = bundle.getString("KEY_TITLE");
            }
            if (bundle.containsKey("KEY_CURRENT_MEDIA_PATH")) {
                this.f6163q = bundle.getString("KEY_CURRENT_MEDIA_PATH");
            }
            if (bundle.containsKey("KEY_CURRENT_POSITION")) {
                this.f6164r = bundle.getInt("KEY_CURRENT_POSITION");
            }
        }
        m8492e(this.f6161o);
        m9172l();
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return C1583c.m7998i(getApplicationContext(), this.f6160n);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755050, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public /* synthetic */ void onLoadFinished(Loader loader, Object obj) {
        m9173a(loader, (Cursor) obj);
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId == 2131689976) {
            if (this.f6164r >= 0 && this.f6164r < this.f6156j.getItemCount()) {
                switch (this.f6156j.m8655a(this.f6164r).m8659g()) {
                    case VideoSize.CIF /*1*/:
                        C1659a.m8451e(m8494q(), ((C1925b) this.f6156j.m8655a(this.f6164r)).m9192e(), true);
                        break;
                    case VideoSize.HVGA /*2*/:
                        C1659a.m8451e(m8494q(), ((C1926c) this.f6156j.m8655a(this.f6164r)).m9197e(), true);
                        break;
                }
                setResult(18);
            }
        } else if (itemId == 2131689977) {
            if (this.f6164r >= 0 && this.f6164r < this.f6156j.getItemCount()) {
                switch (this.f6156j.m8655a(this.f6164r).m8659g()) {
                    case VideoSize.CIF /*1*/:
                        ao.m8483b(m8494q(), C1598c.m8102a(getApplicationContext(), ((C1925b) this.f6156j.m8655a(this.f6164r)).m9193f()).m8088f().toString());
                        break;
                    case VideoSize.HVGA /*2*/:
                        ao.m8484c(m8494q(), C1598c.m8102a(getApplicationContext(), ((C1926c) this.f6156j.m8655a(this.f6164r)).m9198f()).m8088f().toString());
                        break;
                    default:
                        break;
                }
            }
        } else if (itemId == 2131690002 && this.f6164r >= 0 && this.f6164r < this.f6156j.getItemCount()) {
            switch (this.f6156j.m8655a(this.f6164r).m8659g()) {
                case VideoSize.CIF /*1*/:
                    C1494c.m7540b(new C1390x(getApplicationContext(), C1598c.m8102a(getApplicationContext(), ((C1925b) this.f6156j.m8655a(this.f6164r)).m9193f()).m8088f()));
                    break;
                case VideoSize.HVGA /*2*/:
                    C1494c.m7540b(new C1390x(getApplicationContext(), C1598c.m8102a(getApplicationContext(), ((C1926c) this.f6156j.m8655a(this.f6164r)).m9198f()).m8088f()));
                    break;
            }
            Snackbar.m377a(this.f6157k, (CharSequence) "File saved to gallery.", -1).m395a();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f6163q = ((C1924a) this.f6156j.m8655a(this.f6164r)).m9188a();
        bundle.putString("KEY_PEER_PARTY", this.f6160n);
        bundle.putString("KEY_TITLE", this.f6161o);
        bundle.putString("KEY_CURRENT_MEDIA_PATH", this.f6163q);
        bundle.putInt("KEY_CURRENT_POSITION", this.f6164r);
    }
}
