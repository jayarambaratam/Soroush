package mobi.mmdt.ott.view.conversation.forward;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.p178a.C1659a;
import org.apache.http.myHttp.protocol.HTTP;

public class ForwardActivity extends C1685b implements C2237j {
    private C2238a f7356i;
    private ViewPager f7357j;
    private C2239b f7358k;
    private C2241d f7359l;
    private C2244g f7360m;
    private String f7361n;
    private boolean f7362o;
    private String f7363p;
    private Uri f7364q;
    private Uri f7365r;
    private Uri f7366s;

    private void m10141c(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
        if (stringExtra != null) {
            this.f7363p = stringExtra;
        }
    }

    private void m10142d(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            this.f7364q = uri;
        }
    }

    private void m10143e(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            this.f7365r = uri;
        }
    }

    private void m10144f(Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
        if (uri != null) {
            this.f7366s = uri;
        }
    }

    public void m10145a(String str, boolean z) {
        if (this.f7362o) {
            if (z) {
                C1659a.m8452f(m8494q(), str, this.f7361n);
            } else {
                C1659a.m8429a(m8494q(), str, this.f7361n);
            }
            setResult(18);
            return;
        }
        if (z) {
            if (this.f7363p != null) {
                C1659a.m8453g(m8494q(), str, this.f7363p);
            } else if (this.f7364q != null) {
                C1659a.m8454h(m8494q(), str, this.f7364q.toString());
            } else if (this.f7365r != null) {
                C1659a.m8455i(m8494q(), str, this.f7365r.toString());
            } else if (this.f7366s != null) {
                C1659a.m8456j(m8494q(), str, this.f7366s.toString());
            }
        } else if (this.f7363p != null) {
            C1659a.m8440b(m8494q(), str, this.f7363p);
        } else if (this.f7364q != null) {
            C1659a.m8446c(m8494q(), str, this.f7364q.toString());
        } else if (this.f7365r != null) {
            C1659a.m8448d(m8494q(), str, this.f7365r.toString());
        } else if (this.f7366s != null) {
            C1659a.m8450e(m8494q(), str, this.f7366s.toString());
        }
        setResult(18);
    }

    public void onBackPressed() {
        super.onBackPressed();
        setResult(0);
        overridePendingTransition(2131034126, 2131034130);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968613);
        m3618a((Toolbar) findViewById(2131689633));
        this.f7361n = getIntent().getStringExtra("key_to_forward_message_id");
        this.f7358k = new C2239b();
        this.f7359l = new C2241d();
        this.f7360m = new C2244g();
        this.f7356i = new C2238a(this, getFragmentManager());
        this.f7357j = (ViewPager) findViewById(2131689662);
        this.f7357j.setAdapter(this.f7356i);
        ((TabLayout) findViewById(2131689661)).setupWithViewPager(this.f7357j);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            this.f7362o = getIntent().getExtras().getBoolean("key_is_forward_mode", false);
        }
        if (this.f7362o) {
            m8491e(2131230850);
            return;
        }
        m8491e(2131230939);
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        if (!"android.intent.action.SEND".equals(action) || type == null) {
            if ("android.intent.action.SEND_MULTIPLE".equals(action) && type != null) {
            }
        } else if (HTTP.PLAIN_TEXT_TYPE.equals(type)) {
            m10141c(intent);
        } else if (type.startsWith("image/")) {
            m10142d(intent);
        } else if (type.startsWith("video/")) {
            m10143e(intent);
        } else {
            m10144f(intent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
