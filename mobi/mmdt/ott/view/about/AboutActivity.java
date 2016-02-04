package mobi.mmdt.ott.view.about;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class AboutActivity extends C1685b {
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968601);
        m3618a((Toolbar) findViewById(2131689633));
        m8491e(2131230740);
        C0872i.m5265a(m8494q()).m5328a(Integer.valueOf(2130838592)).m4409a(C0652e.SOURCE).m4406a(0.25f).m4417a((ImageView) findViewById(2131689632));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
