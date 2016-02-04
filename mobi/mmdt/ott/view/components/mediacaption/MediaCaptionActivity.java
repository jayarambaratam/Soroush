package mobi.mmdt.ott.view.components.mediacaption;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.dz;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.view.components.mediacaption.p204b.C1879c;
import mobi.mmdt.ott.view.components.mediaselector.MainMediaSelectorActivity;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import net.frakbot.glowpadbackport.BuildConfig;

public class MediaCaptionActivity extends C1685b implements C1870c {
    protected String f6016i;
    private C1876a f6017j;
    private String f6018k;
    private C1885h f6019l;
    private ViewPager f6020m;
    private FrameLayout f6021n;
    private LinkedHashMap<String, String> f6022o;
    private boolean f6023p;
    private int f6024q;
    private String f6025r;
    private LinkedHashMap<String, C1886i> f6026s;
    private int f6027t;
    private int f6028u;
    private dz f6029v;

    public MediaCaptionActivity() {
        this.f6022o = new LinkedHashMap();
        this.f6023p = true;
        this.f6024q = 10;
        this.f6026s = new LinkedHashMap();
        this.f6027t = 1;
        this.f6028u = 215;
        this.f6029v = new C1882e(this);
    }

    private void m8996a(int i, boolean z) {
        this.f6020m.m1859b(this.f6029v);
        this.f6020m.m1849a(i, z);
        this.f6020m.m1852a(this.f6029v);
    }

    private void m8997a(ArrayList<String> arrayList) {
        this.f6019l = new C1885h(this, m1311f(), arrayList);
        this.f6020m = (ViewPager) findViewById(2131689672);
        this.f6020m.setAdapter(this.f6019l);
        this.f6020m.m1852a(this.f6029v);
    }

    private void m8998a(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        m9010s().clear();
        Intent intent = new Intent();
        intent.putExtra("KEY_RESULT_ARRAYLIST_OF_PATH", arrayList);
        intent.putExtra("KEY_RESULT_ARRAYLIST_OF_CAPTION", arrayList2);
        intent.putExtra("KEY_RESULT_TYPE", this.f6027t);
        setResult(-1, intent);
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    private void m9000b(ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("KEY_RESULT_ARRAYLIST_OF_PATH", arrayList);
        bundle.putString("KEY_SELECTED_PHOTO_PATH", null);
        this.f6017j = new C1876a();
        this.f6017j.setArguments(bundle);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689684, this.f6017j);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
        m9006n();
    }

    private void m9001b(boolean z) {
        int i = z ? 3 : 1;
        int i2 = this.f6024q;
        Intent intent = new Intent(this, MainMediaSelectorActivity.class);
        intent.putExtra("EXTRA_MAX_PHOTO_SELECT_COUNT", i2);
        intent.putExtra("EXTRA_SELECT_MODE", i);
        intent.putExtra("EXTRA_SELECTOR_TITLE", this.f6018k);
        startActivityForResult(intent, 215);
        overridePendingTransition(2131034125, 2131034129);
    }

    private int m9005m() {
        int i = 0;
        if (this.f6025r != null) {
            for (Entry key : this.f6022o.entrySet()) {
                if (((String) key.getKey()).equals(this.f6025r)) {
                    return i;
                }
                i++;
            }
        } else if (this.f6022o.size() > 0) {
            this.f6025r = (String) new ArrayList(this.f6022o.keySet()).get(0);
            return 0;
        }
        return -1;
    }

    private void m9006n() {
        int size = this.f6022o.size();
        LayoutParams layoutParams = this.f6021n.getLayoutParams();
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        if (getResources().getConfiguration().orientation == 1) {
            int i = point.x / 5;
            if (size <= 4) {
                layoutParams.height = i + (((int) C1111c.m6388a(getApplicationContext(), 2.0f)) * 2);
                this.f6021n.setLayoutParams(layoutParams);
                return;
            }
            layoutParams.height = (i * 2) + (((int) C1111c.m6388a(getApplicationContext(), 2.0f)) * 3);
            this.f6021n.setLayoutParams(layoutParams);
            return;
        }
        layoutParams.height = (point.x / 10) + (((int) C1111c.m6388a(getApplicationContext(), 2.0f)) * 2);
    }

    private void m9007o() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.f6016i = C1490b.m7517b();
        intent.putExtra("output", Uri.fromFile(new File(this.f6016i)));
        intent.putExtra("android.intent.extra.sizeLimit", 10485760);
        startActivityForResult(intent, 172);
        overridePendingTransition(2131034125, 2131034129);
    }

    private void m9008p() {
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 0);
        startActivityForResult(intent, 173);
        overridePendingTransition(2131034125, 2131034129);
    }

    private LinkedHashMap<String, Boolean> m9009r() {
        return ((MyApplication) getApplication()).f4172c;
    }

    private LinkedHashMap<String, String> m9010s() {
        return ((MyApplication) getApplication()).f4174e;
    }

    public void m9011a(C1879c c1879c) {
        int i;
        int m = m9005m();
        int size = this.f6022o.size();
        int i2 = 0;
        for (String equals : this.f6022o.keySet()) {
            if (equals.equals(c1879c.m9029a())) {
                i = i2;
                break;
            }
            i2++;
        }
        i = -1;
        i2 = size == 1 ? -1 : size > 1 ? m == i ? i < size + -1 ? i : i - 1 : m < i ? m : m - 1 : -1;
        for (Entry entry : this.f6026s.entrySet()) {
            if (m9010s().containsKey(entry.getKey())) {
                m9010s().remove(entry.getKey());
            }
            m9010s().put(entry.getKey(), ((C1886i) entry.getValue()).m9044J());
        }
        this.f6022o.remove(c1879c.m9029a());
        this.f6019l.m9040a(c1879c.m9029a());
        if (i2 >= 0) {
            this.f6025r = (String) new ArrayList(this.f6022o.keySet()).get(i2);
            m8996a(i2, false);
            this.f6017j.m9025a(c1879c);
            new Handler().postDelayed(new C1884g(this), 750);
            return;
        }
        this.f6025r = null;
        this.f6017j.m9025a(c1879c);
    }

    public void m9012b(C1879c c1879c) {
        this.f6025r = c1879c.m9029a();
        m8996a(m9005m(), true);
        this.f6017j.m9023a();
    }

    public void e_() {
        for (String put : this.f6022o.keySet()) {
            m9009r().put(put, Boolean.valueOf(true));
        }
        m9001b(true);
    }

    public String m9013l() {
        return this.f6025r;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == 0) {
            onBackPressed();
        } else if (i == 172) {
            if (i2 == -1) {
                this.f6023p = false;
                if (this.f6016i != null) {
                    this.f6027t = 1;
                    if (!this.f6022o.containsKey(this.f6016i)) {
                        this.f6022o.put(this.f6016i, this.f6016i);
                    }
                    r0 = new ArrayList();
                    r0.add(this.f6016i);
                    m8997a(r0);
                }
            }
        } else if (i == 173) {
            if (i2 == -1) {
                this.f6023p = false;
                Uri data = intent.getData();
                if (data != null) {
                    this.f6027t = 2;
                    this.f6016i = C1111c.m6396a(getApplicationContext(), data);
                    if (!this.f6022o.containsKey(this.f6016i)) {
                        this.f6022o.put(this.f6016i, this.f6016i);
                    }
                    r0 = new ArrayList();
                    r0.add(this.f6016i);
                    m8997a(r0);
                    return;
                }
                C1104b.m6363a(this, "video uri must not be null.", new IOException());
            }
        } else if (i != 215) {
        } else {
            if (i2 == -1) {
                if (intent.hasExtra("KEY_RESULT_ARRAYLIST_OF_PATH")) {
                    this.f6023p = false;
                    this.f6027t = intent.getIntExtra("KEY_RESULT_TYPE", 1);
                    ArrayList stringArrayListExtra = intent.getStringArrayListExtra("KEY_RESULT_ARRAYLIST_OF_PATH");
                    Iterator it;
                    String str;
                    if (this.f6027t == 1) {
                        it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            str = (String) it.next();
                            if (!this.f6022o.containsKey(str)) {
                                this.f6022o.put(str, str);
                            }
                        }
                        m9000b(stringArrayListExtra);
                        m8997a(stringArrayListExtra);
                        int m = m9005m();
                        if (m != -1) {
                            m8996a(m, false);
                        }
                    } else if (this.f6027t == 2) {
                        it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            str = (String) it.next();
                            if (!this.f6022o.containsKey(str)) {
                                this.f6022o.put(str, str);
                            }
                        }
                        m8997a(stringArrayListExtra);
                    }
                }
            } else if (this.f6022o.size() == 0) {
                onBackPressed();
            }
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        m9010s().clear();
        setResult(0);
        overridePendingTransition(2131034126, 2131034130);
    }

    @SuppressLint({"MissingSuperCall"})
    protected void onCreate(Bundle bundle) {
        super.m8487a(bundle, true);
        setContentView(2130968619);
        m3618a((Toolbar) findViewById(2131689633));
        this.f6021n = (FrameLayout) findViewById(2131689684);
        if (!(getIntent() == null || getIntent().getExtras() == null)) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey("EXTRA_SELECTOR_TITLE")) {
                this.f6018k = extras.getString("EXTRA_SELECTOR_TITLE");
            }
            if (extras.containsKey("EXTRA_MAX_PHOTO_SELECT_COUNT")) {
                this.f6024q = extras.getInt("EXTRA_MAX_PHOTO_SELECT_COUNT");
            }
            if (extras.containsKey("KEY_REQUEST_CODE")) {
                this.f6028u = extras.getInt("KEY_REQUEST_CODE");
            }
        }
        if (bundle != null) {
            if (bundle.containsKey("KEY_REQUEST_CODE")) {
                this.f6028u = bundle.getInt("KEY_REQUEST_CODE");
            }
            if (bundle.containsKey("KEY_IS_FIRST_START")) {
                this.f6023p = bundle.getBoolean("KEY_IS_FIRST_START");
            }
            if (bundle.containsKey("KEY_RESULT_TYPE")) {
                this.f6027t = bundle.getInt("KEY_RESULT_TYPE");
            }
            if (bundle.containsKey("KEY_SELECTED_PATH")) {
                this.f6025r = bundle.getString("KEY_SELECTED_PATH");
            }
            if (bundle.containsKey("KEY_LAST_CAMERA_TAKEN_ADDRESS")) {
                this.f6016i = bundle.getString("KEY_LAST_CAMERA_TAKEN_ADDRESS");
            }
            if (bundle.containsKey("KEY_CAPTIONED_MEDIA_DATA_HOLDERS_LIST_PATH")) {
                ArrayList stringArrayList = bundle.getStringArrayList("KEY_CAPTIONED_MEDIA_DATA_HOLDERS_LIST_PATH");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    this.f6022o.put(stringArrayList.get(i), stringArrayList.get(i));
                }
            }
        }
        if (this.f6023p) {
            switch (this.f6028u) {
                case 172:
                    m9007o();
                    break;
                case 173:
                    m9008p();
                    break;
                case 215:
                    m9001b(false);
                    break;
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f6022o.keySet());
        m8997a(arrayList);
        if (this.f6028u == 215 && this.f6027t == 1) {
            m9000b(arrayList);
            m8996a(m9005m(), false);
        }
        m8492e(this.f6018k);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            onBackPressed();
            return true;
        } else if (itemId != 2131689999) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Entry entry : this.f6022o.entrySet()) {
                arrayList2.add(entry.getKey());
                if (this.f6026s.containsKey(entry.getKey())) {
                    arrayList.add(((C1886i) this.f6026s.get(entry.getKey())).m9044J());
                } else {
                    arrayList.add(BuildConfig.FLAVOR);
                }
            }
            m8998a(arrayList2, arrayList);
            return true;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("KEY_IS_FIRST_START", this.f6023p);
        bundle.putInt("KEY_REQUEST_CODE", this.f6028u);
        bundle.putInt("KEY_RESULT_TYPE", this.f6027t);
        bundle.putString("KEY_SELECTED_PATH", this.f6025r);
        bundle.putInt("KEY_SELECTED_POSITION", this.f6020m == null ? 0 : this.f6020m.getCurrentItem());
        ArrayList arrayList = new ArrayList();
        for (Entry key : this.f6022o.entrySet()) {
            arrayList.add(key.getKey());
        }
        bundle.putStringArrayList("KEY_CAPTIONED_MEDIA_DATA_HOLDERS_LIST_PATH", arrayList);
        for (Entry key2 : this.f6026s.entrySet()) {
            if (m9010s().containsKey(key2.getKey())) {
                m9010s().remove(key2.getKey());
            }
            m9010s().put(key2.getKey(), ((C1886i) key2.getValue()).m9044J());
        }
        if (this.f6016i != null) {
            bundle.putString("KEY_LAST_CAMERA_TAKEN_ADDRESS", this.f6016i);
        }
    }
}
