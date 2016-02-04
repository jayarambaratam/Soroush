package mobi.mmdt.ott.view.components.squarecrop;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.isseiaoki.simplecropview.C1068b;
import com.isseiaoki.simplecropview.CropImageView;
import com.p032a.p033a.C0872i;
import java.io.File;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.view.components.mediaselector.MainMediaSelectorActivity;
import mobi.mmdt.ott.view.components.p180c.C1685b;

public class SquareCropActivity extends C1685b {
    private String f6221i;
    private boolean f6222j;
    private CropImageView f6223k;
    private ViewGroup f6224l;

    private void m9216l() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        this.f6221i = C1490b.m7517b();
        intent.putExtra("output", Uri.fromFile(new File(this.f6221i)));
        intent.putExtra("android.intent.extra.sizeLimit", 10485760);
        startActivityForResult(intent, 2002);
    }

    private void m9217m() {
        Intent intent = new Intent(this, MainMediaSelectorActivity.class);
        intent.putExtra("EXTRA_SELECT_MODE", 2);
        intent.putExtra("EXTRA_SELECTOR_TITLE", "Photos");
        startActivityForResult(intent, 2001);
    }

    private void m9218n() {
        new Thread(new C1938b(this, this.f6223k.getCroppedBitmap())).start();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2001:
                    if (intent.hasExtra("KEY_RESULT_ARRAYLIST_OF_PATH")) {
                        this.f6221i = (String) intent.getStringArrayListExtra("KEY_RESULT_ARRAYLIST_OF_PATH").get(0);
                        this.f6222j = true;
                        C0872i.m5265a(m8494q()).m5329a(this.f6221i).m5047j().m4303a(0.25f).m4315a(this.f6223k);
                        return;
                    }
                    return;
                case 2002:
                    if (this.f6221i != null) {
                        this.f6222j = true;
                        C0872i.m5265a(m8494q()).m5329a(this.f6221i).m5047j().m4303a(0.25f).m4315a(this.f6223k);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        finish();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130968629);
        m3618a((Toolbar) findViewById(2131689633));
        this.f6224l = (ViewGroup) findViewById(2131689631);
        this.f6223k = (CropImageView) findViewById(2131689692);
        this.f6223k.setCropMode(C1068b.RATIO_1_1);
        m8491e(2131230829);
        if (bundle != null) {
            if (bundle.containsKey("KEY_IS_LAST_TAKE_PICTURE_ADDRESS_VALID")) {
                this.f6222j = bundle.getBoolean("KEY_IS_LAST_TAKE_PICTURE_ADDRESS_VALID");
            }
            if (bundle.containsKey("KEY_LAST_CAMERA_TAKEN_ADDRESS")) {
                this.f6221i = bundle.getString("KEY_LAST_CAMERA_TAKEN_ADDRESS");
            }
        }
        if (this.f6221i == null) {
            int i = 1001;
            if (!(getIntent() == null || getIntent().getExtras() == null || !getIntent().getExtras().containsKey("KEY_IMAGE_SELECTOR"))) {
                i = getIntent().getExtras().getInt("KEY_IMAGE_SELECTOR");
            }
            switch (i) {
                case 1001:
                    m9217m();
                    return;
                case 1002:
                    m9216l();
                    return;
                default:
                    return;
            }
        }
        C0872i.m5265a(m8494q()).m5329a(this.f6221i).m4406a(0.25f).m4413a(new C1937a(this)).m4417a(this.f6223k);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131755045, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            setResult(0);
            onBackPressed();
            return true;
        }
        if (itemId == 2131689999) {
            m9218n();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("KEY_IS_LAST_TAKE_PICTURE_ADDRESS_VALID", this.f6222j);
        if (this.f6222j) {
            bundle.putString("KEY_LAST_CAMERA_TAKEN_ADDRESS", this.f6221i);
        }
    }
}
