package mobi.mmdt.ott.view.call;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.dd.morphingbutton.C1035j;
import com.dd.morphingbutton.MorphingButton;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1320a;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1322b;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1323c;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1324d;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1325e;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1326f;
import mobi.mmdt.ott.logic.p112a.p113a.p114a.C1327g;
import mobi.mmdt.ott.logic.p112a.p113a.p116b.C1328a;
import mobi.mmdt.ott.logic.p112a.p113a.p116b.C1329b;
import mobi.mmdt.ott.logic.p112a.p113a.p116b.C1331d;
import mobi.mmdt.ott.logic.p161g.C1533f;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.conversation.C1988a;
import net.frakbot.glowpadbackport.BuildConfig;
import net.frakbot.glowpadbackport.GlowPadView;
import org.jivesoftware.smack.tcp.XMPPTCPConnection.PacketWriter;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;
import p000a.p001a.p002a.C0002c;

public class CallActivity extends C1685b implements SensorEventListener {
    private static String f5562j;
    private C1707v f5563i;
    private String f5564k;
    private FrameLayout f5565l;
    private TextView f5566m;
    private GlowPadView f5567n;
    private boolean f5568o;
    private boolean f5569p;
    private boolean f5570q;
    private boolean f5571r;
    private boolean f5572s;
    private boolean f5573t;
    private boolean f5574u;
    private CountDownTimer f5575v;
    private SensorManager f5576w;
    private C1988a f5577x;

    public CallActivity() {
        this.f5570q = false;
        this.f5571r = false;
        this.f5572s = false;
        this.f5573t = false;
        this.f5574u = false;
        this.f5577x = C1988a.NOTHING;
    }

    private C1035j m8497a(int i, int i2) {
        return C1035j.m6195a().m6213g((int) PacketWriter.QUEUE_SIZE).m6208b((int) C1111c.m6388a(getApplicationContext(), 2.0f)).m6209c(i).m6210d(i2).m6211e(getResources().getColor(2131623963)).m6212f(getResources().getColor(2131623964));
    }

    private void m8499a(float f) {
        LayoutParams attributes = getWindow().getAttributes();
        attributes.flags |= 128;
        attributes.screenBrightness = f;
        getWindow().setAttributes(attributes);
    }

    private C1035j m8503b(int i, int i2) {
        return C1035j.m6195a().m6213g((int) PacketWriter.QUEUE_SIZE).m6208b(i2).m6209c(i).m6210d(i2).m6211e(getResources().getColor(2131623965)).m6212f(getResources().getColor(2131623966));
    }

    private void m8505b(boolean z) {
        if (z) {
            runOnUiThread(new C1687b(this));
        } else {
            runOnUiThread(new C1688c(this));
        }
    }

    private void m8507c(boolean z) {
        if (z) {
            runOnUiThread(new C1689d(this));
        } else {
            runOnUiThread(new C1690e(this));
        }
    }

    private void m8510d(boolean z) {
        if (z) {
            runOnUiThread(new C1691f(this));
        } else {
            runOnUiThread(new C1693h(this));
        }
    }

    private void m8521l() {
        m8510d(true);
        m8505b(true);
        C1494c.m7539a(new C1328a(getApplicationContext()));
    }

    private void m8523m() {
        m8527r();
        m8524n();
    }

    private void m8524n() {
        C1494c.m7539a(new C1329b(getApplicationContext(), this.f5564k));
    }

    private void m8525o() {
        this.f5567n.setPointsMultiplier(8);
        this.f5567n.setOnTriggerListener(new C1703r(this));
        new Thread(new C1704s(this)).start();
    }

    private void m8526p() {
        runOnUiThread(new C1706u(this));
    }

    private void m8527r() {
        runOnUiThread(new C1695j(this));
    }

    private void m8528s() {
        this.f5576w = (SensorManager) getSystemService("sensor");
        this.f5576w.registerListener(this, this.f5576w.getDefaultSensor(8), 3);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onBackPressed() {
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(Bundle bundle) {
        super.m8487a(bundle, false);
        setContentView(2130968603);
        m3618a((Toolbar) findViewById(2131689633));
        m3625h().m3576b();
        Window window = getWindow();
        window.addFlags(524288);
        window.addFlags(128);
        window.addFlags(2097152);
        this.f5568o = true;
        this.f5564k = getIntent().getExtras().getString("key_contact_user_id_string");
        this.f5577x = C1988a.values()[getIntent().getExtras().getInt("key_start_mode", 0)];
        this.f5565l = (FrameLayout) findViewById(2131689638);
        this.f5567n = (GlowPadView) findViewById(2131689643);
        this.f5566m = (TextView) findViewById(2131689644);
        MorphingButton morphingButton = (MorphingButton) findViewById(2131689639);
        MorphingButton morphingButton2 = (MorphingButton) findViewById(2131689640);
        MorphingButton morphingButton3 = (MorphingButton) findViewById(2131689641);
        switch (C1697l.f5590a[this.f5577x.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f5565l.setVisibility(8);
                this.f5566m.setVisibility(8);
                this.f5567n.setVisibility(8);
                f5562j = "In Call";
                break;
            case VideoSize.HVGA /*2*/:
                this.f5565l.setVisibility(8);
                this.f5566m.setVisibility(8);
                this.f5567n.setVisibility(8);
                new Handler().postDelayed(new C1686a(this), 1500);
                f5562j = "Call Finished";
                break;
            case Version.API03_CUPCAKE_15 /*3*/:
                C0002c.m2a().m17c(new C1320a(C1533f.f5135c, BuildConfig.FLAVOR, this.f5564k));
                m8505b(false);
                m8510d(false);
                C1494c.m7539a(new C1331d(getApplicationContext(), this.f5564k));
                f5562j = "Calling";
                break;
            case Version.API04_DONUT_16 /*4*/:
                m8526p();
                m8507c(false);
                m8525o();
                f5562j = "RINGING";
                break;
            case Version.API05_ECLAIR_20 /*5*/:
                m8505b(false);
                m8510d(false);
                break;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("key_contact_user_id_string", this.f5564k);
        bundle2.putString("key_call_status_message_string", f5562j);
        this.f5563i = new C1707v();
        this.f5563i.setArguments(bundle2);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689637, this.f5563i);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
        this.f5575v = new C1698m(this, 1000000000, 1000);
        morphingButton.setOnClickListener(new C1699n(this, morphingButton));
        morphingButton2.setOnClickListener(new C1700o(this, morphingButton2));
        morphingButton3.setOnClickListener(new C1701p(this, morphingButton3));
        ViewGroup.LayoutParams layoutParams = morphingButton.getLayoutParams();
        int i = layoutParams.width;
        int i2 = layoutParams.height;
        morphingButton.m6165a(m8497a(i, i2).m6213g(0).m6207a(getString(2131230787)));
        morphingButton2.m6165a(m8497a(i, i2).m6213g(0).m6207a(getString(2131230774)));
        morphingButton3.m6165a(m8497a(i, i2).m6213g(0).m6207a(getString(2131230770)));
        m8528s();
    }

    protected void onDestroy() {
        super.onDestroy();
        C1111c.m6398a((Activity) this);
        this.f5568o = false;
        if (this.f5575v != null) {
            this.f5575v.cancel();
        }
    }

    public void onDoNothing(View view) {
    }

    public void onEndCallPressed(View view) {
        if (this.f5577x != C1988a.MAKE_CALL) {
            m8523m();
        } else if (this.f5573t) {
            m8523m();
        } else {
            Toast.makeText(this, getString(C1136d.please_wait_), 0).show();
        }
    }

    public void onEvent(C1320a c1320a) {
        if (!(c1320a.m6993a().equals(C1533f.f5133a) || c1320a.m6993a().equals(C1533f.f5134b) || c1320a.m6993a().equals(C1533f.f5135c) || c1320a.m6993a().equals(C1533f.f5136d) || c1320a.m6993a().equals(C1533f.f5137e) || c1320a.m6993a().equals(C1533f.f5138f) || c1320a.m6993a().equals(C1533f.f5139g))) {
            if (c1320a.m6993a().equals(C1533f.f5140h)) {
                this.f5574u = true;
                this.f5575v.start();
            } else if (!(c1320a.m6993a().equals(C1533f.f5141i) || c1320a.m6993a().equals(C1533f.f5142j) || c1320a.m6993a().equals(C1533f.f5143k) || c1320a.m6993a().equals(C1533f.f5144l))) {
                if (c1320a.m6993a().equals(C1533f.f5145m)) {
                    this.f5574u = false;
                    m8527r();
                } else if (c1320a.m6993a().equals(C1533f.f5146n)) {
                    this.f5574u = false;
                    m8527r();
                } else if (!(c1320a.m6993a().equals(C1533f.f5147o) || c1320a.m6993a().equals(C1533f.f5148p) || c1320a.m6993a().equals(C1533f.f5149q) || c1320a.m6993a().equals(C1533f.f5150r) || !c1320a.m6993a().equals(C1533f.f5151s))) {
                    this.f5574u = false;
                    m8527r();
                }
            }
        }
        f5562j = c1320a.m6994b();
        runOnUiThread(new C1694i(this, c1320a));
    }

    public void onEvent(C1322b c1322b) {
        m8523m();
    }

    public void onEvent(C1323c c1323c) {
        this.f5573t = true;
    }

    public void onEvent(C1324d c1324d) {
    }

    public void onEvent(C1325e c1325e) {
    }

    public void onEvent(C1326f c1326f) {
    }

    public void onEvent(C1327g c1327g) {
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f5577x = C1988a.values()[intent.getExtras().getInt("key_start_mode", 0)];
        switch (C1697l.f5590a[this.f5577x.ordinal()]) {
            case VideoSize.CIF /*1*/:
                this.f5566m.setVisibility(0);
                m8521l();
                f5562j = "In Call";
                break;
            case VideoSize.HVGA /*2*/:
                this.f5565l.setVisibility(8);
                this.f5566m.setVisibility(8);
                this.f5567n.setVisibility(8);
                new Handler().postDelayed(new C1702q(this), 1500);
                f5562j = "Call Finished";
                break;
        }
        if (this.f5563i != null) {
            this.f5563i.m8536a(f5562j);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        int i = (((double) f) < 0.0d || f >= 5.0f || f >= sensorEvent.sensor.getMaximumRange()) ? 0 : 1;
        m8499a((float) (i != 0 ? 0.01d : -1.0d));
        if (i != 0) {
            getWindow().setFlags(1024, 1024);
            ((ImageView) findViewById(2131689645)).setVisibility(0);
            return;
        }
        getWindow().clearFlags(1024);
        ((ImageView) findViewById(2131689645)).setVisibility(8);
    }
}
