package mobi.mmdt.ott.view.components.mediaviewer;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import com.pnikosis.materialishprogress.ProgressWheel;
import mobi.mmdt.componentsutils.C1119f;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.p178a.aj;

public class ImageViewerActivity extends C1685b {
    private ViewGroup f6151i;
    private ImageView f6152j;
    private String f6153k;
    private ProgressWheel f6154l;

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968615);
        m3618a((Toolbar) findViewById(2131689633));
        m8489a(getWindow(), getResources().getColor(2131623986));
        m8492e("Photo");
        this.f6151i = (ViewGroup) findViewById(2131689635);
        this.f6152j = (ImageView) findViewById(2131689670);
        this.f6154l = (ProgressWheel) findViewById(C1119f.progress_wheel);
        if (getIntent() != null && getIntent().getExtras() != null) {
            this.f6153k = getIntent().getExtras().getString("KEY_CURRENT_MEDIA_PATH");
            m8492e(getIntent().getExtras().getString("KEY_TITLE"));
            C0872i.m5265a(m8494q()).m5329a(aj.m8474a(this.f6153k)).m4409a(C0652e.SOURCE).m4413a(new C1923a(this)).m4417a(this.f6152j);
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        }
        if (itemId == 2131690002) {
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
    }
}
