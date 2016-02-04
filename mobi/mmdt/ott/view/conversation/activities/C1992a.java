package mobi.mmdt.ott.view.conversation.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.af;
import android.support.v7.widget.Toolbar;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.cocosw.bottomsheet.C1003l;
import com.p032a.p033a.C0872i;
import com.pnikosis.materialishprogress.ProgressWheel;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.logic.C1486a;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1366a;
import mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b.C1376j;
import mobi.mmdt.ott.logic.p112a.p152j.p153a.C1479f;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;
import mobi.mmdt.ott.logic.p160f.C1521a;
import mobi.mmdt.ott.logic.p160f.C1525e;
import mobi.mmdt.ott.logic.p160f.C1527g;
import mobi.mmdt.ott.p086a.C1136d;
import mobi.mmdt.ott.p095c.C1303d;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1588h;
import mobi.mmdt.ott.provider.p170d.C1598c;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.provider.p170d.C1605j;
import mobi.mmdt.ott.view.components.fileselector.FileSelectorActivity;
import mobi.mmdt.ott.view.components.mediacaption.MediaCaptionActivity;
import mobi.mmdt.ott.view.components.p180c.C1685b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.conversation.conversationtextbox.C1990o;
import mobi.mmdt.ott.view.conversation.conversationtextbox.ConversationTextBoxFragment;
import mobi.mmdt.ott.view.conversation.emojisticker.C1991h;
import mobi.mmdt.ott.view.conversation.emojisticker.C2197c;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.Emojicon;
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p213a.C1984d;
import mobi.mmdt.ott.view.conversation.p213a.C1985e;
import mobi.mmdt.ott.view.conversation.p213a.C1986f;
import mobi.mmdt.ott.view.conversation.p213a.C1987g;
import mobi.mmdt.ott.view.conversation.p214b.C1989e;
import mobi.mmdt.ott.view.conversation.p214b.C2019a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.C2152a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2182b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2183c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2184d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2185e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2186f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2187g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2188h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p224d.C2189i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2155b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2156c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2157d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2158e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2159f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2160g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2161h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2162i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2163j;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2165b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2166c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2167d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2168e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2169f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2170g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2171h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p226b.C2172i;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2174b;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2175c;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2176d;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2177e;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2178f;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2179g;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2180h;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p227c.C2181i;
import mobi.mmdt.ott.view.p178a.C1659a;
import mobi.mmdt.ott.view.p178a.ao;
import mobi.mmdt.ott.view.stickermarket.StickerDetailsActivity;
import net.frakbot.glowpadbackport.BuildConfig;
import org.apache.http.myHttp.protocol.HTTP;
import org.json.JSONObject;
import org.linphone.mediastream.Version;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.a */
public abstract class C1992a extends C1685b implements C1981a, C1984d, C1985e, C1986f, C1987g, C1989e, C1990o, C1991h {
    public static int f6342i;
    private View f6343A;
    private C2197c f6344B;
    private boolean f6345C;
    private ViewStub f6346D;
    private FrameLayout f6347E;
    private TextView f6348F;
    private TextView f6349G;
    private ImageView f6350H;
    private boolean f6351I;
    private String f6352J;
    private String f6353K;
    private String f6354L;
    private String f6355M;
    private int f6356N;
    private int f6357O;
    private C1527g f6358P;
    private View f6359Q;
    protected C2019a f6360j;
    protected ViewGroup f6361k;
    protected ViewGroup f6362l;
    protected RoundAvatarImageView f6363m;
    protected ConversationTextBoxFragment f6364n;
    protected int f6365o;
    private C1525e f6366p;
    private Toolbar f6367q;
    private String f6368r;
    private int f6369s;
    private int f6370t;
    private boolean f6371u;
    private boolean f6372v;
    private boolean f6373w;
    private boolean f6374x;
    private boolean f6375y;
    private PopupWindow f6376z;

    public C1992a() {
        this.f6369s = 0;
        this.f6356N = -1;
        this.f6357O = 0;
        this.f6358P = new C2001i(this);
    }

    private void m9365G() {
        C1588h a = C1583c.m7969a(getApplicationContext(), this.f6368r);
        if (a != null) {
            String f = a.m8045f();
            if (!(f == null || f.isEmpty())) {
                this.f6364n.m9831a(f);
            }
            new Handler().postDelayed(new C2016x(this, a), 1000);
        }
    }

    private int m9366H() {
        if (f6342i == 0) {
            f6342i = C1111c.m6413e(getApplicationContext()) ? C1111c.m6414f(getApplicationContext()).x : C1111c.m6414f(getApplicationContext()).y;
        }
        return f6342i;
    }

    private void m9367I() {
        this.f6361k.getViewTreeObserver().addOnGlobalLayoutListener(new C1994c(this));
    }

    private void m9368J() {
        if (!this.f6373w) {
            this.f6373w = true;
            new Handler().postDelayed(new C1998f(this), 500);
        }
    }

    private void m9369K() {
        new C1003l(this).m6120a(2131755021).m6121a(new C2000h(this)).m6124c(4).m6119a().show();
    }

    private void m9370L() {
        Intent intent = new Intent(this, FileSelectorActivity.class);
        intent.putExtra("EXTRA_MAX_PHOTO_SELECT_COUNT", 10);
        intent.putExtra("EXTRA_SELECT_MODE", 1);
        startActivityForResult(intent, 217);
        overridePendingTransition(2131034125, 2131034129);
    }

    private void m9378b(String str, String str2, C1605j c1605j) {
        if (this.f6351I) {
            m9410a(str, str2, c1605j, this.f6352J);
            m9379b(false);
            return;
        }
        m9409a(str, str2, c1605j);
    }

    private void m9379b(boolean z) {
        this.f6351I = false;
        this.f6352J = null;
        if (z) {
            new Handler().postDelayed(new C2009q(this), 50);
            new Handler().postDelayed(new C2010r(this), 550);
            return;
        }
        this.f6347E.setVisibility(8);
    }

    private void m9381c(int i) {
        Intent intent = new Intent(getApplicationContext(), MediaCaptionActivity.class);
        intent.putExtra("KEY_REQUEST_CODE", i);
        intent.putExtra("EXTRA_MAX_PHOTO_SELECT_COUNT", 10);
        intent.putExtra("EXTRA_SELECTOR_TITLE", getString(2131230928) + " " + this.f6367q.getTitle());
        startActivityForResult(intent, 215);
        overridePendingTransition(2131034125, 2131034129);
    }

    private void m9382c(int i, int i2, int i3, String str) {
        if (this.f6351I) {
            m9402a(i, i2, i3, str, this.f6352J);
            m9379b(false);
            return;
        }
        m9417b(i, i2, i3, str);
    }

    private void m9388h(String str) {
        if (this.f6351I) {
            m9408a(str, this.f6352J);
            m9379b(false);
            return;
        }
        m9423c(str);
    }

    public void m9395A() {
        this.f6372v = true;
        m9369K();
    }

    public void m9396B() {
        this.f6366p.m7688a();
    }

    public void m9397C() {
        this.f6366p.m7690c();
    }

    public void m9398D() {
        this.f6366p.m7689b();
    }

    protected void m9399E() {
        new Handler().postDelayed(new C2007o(this), 100);
    }

    public void m9400a(int i) {
        this.f6375y = true;
    }

    public void m9401a(int i, int i2, int i3, String str) {
        m9382c(i, i2, i3, str);
    }

    protected abstract void m9402a(int i, int i2, int i3, String str, String str2);

    public abstract void m9403a(int i, String str);

    public void m9404a(long j) {
        try {
            C1521a.m7668a((Context) this).m7678a(j);
        } catch (Throwable e) {
            C1104b.m6368b((Object) this, e);
        }
    }

    public void m9405a(long j, boolean z) {
        C1494c.m7539a(new C1376j(getApplicationContext(), j, z));
    }

    @SuppressLint({"MissingSuperCall"})
    protected void m9406a(Bundle bundle, String str) {
        super.m8487a(bundle, true);
        this.f6368r = str;
        setContentView(2130968607);
        m3618a((Toolbar) findViewById(2131689633));
        this.f6367q = (Toolbar) findViewById(2131689648);
        this.f6367q.setTitleTextColor(-1);
        this.f6367q.setSubtitleTextColor(-1);
        this.f6363m = (RoundAvatarImageView) findViewById(2131689649);
        this.f6346D = (ViewStub) findViewById(2131689653);
        this.f6347E = (FrameLayout) findViewById(2131689652);
        f6342i = C1111c.m6413e(getApplicationContext()) ? C1111c.m6414f(getApplicationContext()).x : C1111c.m6414f(getApplicationContext()).y;
        this.f6361k = (ViewGroup) findViewById(2131689635);
        this.f6362l = (ViewGroup) findViewById(2131689654);
        this.f6367q.setOnClickListener(new C1993b(this));
        this.f6365o = C1583c.m7986d(getApplicationContext(), this.f6368r);
        this.f6360j = new C2019a();
        Bundle bundle2 = new Bundle();
        bundle2.putString(C2019a.f6561a, this.f6368r);
        if (bundle != null) {
            this.f6351I = bundle.getBoolean("key_is_reply_mode", false);
            this.f6352J = bundle.getString("key_reply_message_id", null);
            this.f6353K = bundle.getString("key_reply_top_text", null);
            this.f6354L = bundle.getString("key_reply_bottom_text", null);
            this.f6355M = bundle.getString("key_reply_image_uri", null);
            this.f6356N = bundle.getInt("key_reply_image_res_id", -1);
            this.f6357O = bundle.getInt("key_reply_image_background_color", 0);
            int i = bundle.getInt(C2019a.f6562b);
            boolean z = bundle.getBoolean(C2019a.f6563c);
            int i2 = bundle.getInt(C2019a.f6564d);
            bundle2.putInt(C2019a.f6562b, i);
            bundle2.putBoolean(C2019a.f6563c, z);
            bundle2.putInt(C2019a.f6564d, i2);
        }
        this.f6360j.setArguments(bundle2);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.replace(2131689650, this.f6360j);
        beginTransaction.setTransition(4099);
        beginTransaction.commit();
        this.f6364n = (ConversationTextBoxFragment) getFragmentManager().findFragmentById(2131689655);
        Point f = C1111c.m6414f(getApplicationContext());
        if (C1111c.m6413e(getApplicationContext())) {
            i = C1309a.m6934a(getApplicationContext()).m6946c();
            if (i == -1) {
                this.f6370t = (int) (((double) f.x) * 0.6d);
            } else {
                this.f6371u = true;
                this.f6370t = i;
            }
        } else {
            i = C1309a.m6934a(getApplicationContext()).m6950d();
            if (i == -1) {
                this.f6370t = (int) (((double) f.y) * 0.5d);
            } else {
                this.f6371u = true;
                this.f6370t = i;
            }
        }
        m9367I();
        this.f6366p = C1525e.m7680a(this, this.f6358P);
        this.f6343A = getLayoutInflater().inflate(2130968765, null);
        this.f6376z = new PopupWindow(this.f6343A, -1, this.f6370t, false);
        this.f6344B = new C2197c(this, this.f6370t);
        this.f6344B.m10053a((C1991h) this);
        m9365G();
        m9442r();
        this.f6346D.inflate();
        this.f6348F = (TextView) findViewById(2131689735);
        this.f6349G = (TextView) findViewById(2131689736);
        this.f6350H = (ImageView) findViewById(2131689734);
        if (!this.f6351I || this.f6352J == null) {
            this.f6347E.setVisibility(8);
            return;
        }
        this.f6348F.setText(this.f6353K);
        this.f6349G.setText(this.f6354L);
        this.f6350H.setBackgroundColor(this.f6357O);
        this.f6347E.setVisibility(0);
        if (this.f6355M != null) {
            this.f6350H.setVisibility(0);
            C0872i.m5265a(m8494q()).m5329a(this.f6355M).m4405a().m4407a(this.f6356N).m4406a(0.25f).m4417a(this.f6350H);
        } else if (this.f6356N > 0) {
            this.f6350H.setVisibility(0);
            C0872i.m5265a(m8494q()).m5328a(Integer.valueOf(this.f6356N)).m4405a().m4406a(0.25f).m4417a(this.f6350H);
        } else {
            this.f6350H.setVisibility(8);
            this.f6350H.setImageBitmap(null);
        }
    }

    protected abstract void m9407a(String str);

    protected abstract void m9408a(String str, String str2);

    protected abstract void m9409a(String str, String str2, C1605j c1605j);

    protected abstract void m9410a(String str, String str2, C1605j c1605j, String str3);

    public void m9411a(String str, String str2, boolean z) {
        if (new File(Uri.parse(str).getPath()).exists()) {
            C1659a.m8428a(m8494q(), str);
            return;
        }
        C1598c.m8096a(m8494q(), str, z ? C1604i.NOT_STARTED : C1604i.DELETED);
        Toast.makeText(m8494q(), "File not exists!", 0).show();
    }

    public void m9412a(String str, boolean z) {
        if (new File(Uri.parse(str).getPath()).exists()) {
            C1659a.m8439b(m8494q(), str);
            return;
        }
        C1598c.m8096a(m8494q(), str, z ? C1604i.NOT_STARTED : C1604i.DELETED);
        Toast.makeText(m8494q(), "File not exists!", 0).show();
    }

    protected void m9413a(C1722f c1722f) {
        String str = null;
        switch (c1722f.m8659g()) {
            case C1317h.Theme_editTextColor /*62*/:
                str = ((C2169f) c1722f).m9923p();
                break;
            case C1317h.Theme_editTextBackground /*63*/:
                str = ((C2186f) c1722f).m10007p();
                break;
            case C1317h.Theme_imageButtonStyle /*64*/:
                str = ((C2160g) c1722f).m9879r();
                break;
        }
        if (str != null) {
            Intent intent = new Intent(getApplicationContext(), StickerDetailsActivity.class);
            intent.putExtra("StickerDetailsActivity.KEY_PACKAGE_ID", Integer.parseInt(str));
            intent.putExtra("StickerDetailsActivity.KEY_PACKAGE_NAME", BuildConfig.FLAVOR);
            intent.putExtra("StickerDetailsActivity.KEY_DOWNLOAD_COUNT", BuildConfig.FLAVOR);
            intent.putExtra("StickerDetailsActivity.KEY_PRICE", BuildConfig.FLAVOR);
            startActivity(intent);
            overridePendingTransition(2131034125, 2131034129);
        }
    }

    public void m9414a(C2152a c2152a) {
        switch (c2152a.m8659g()) {
            case Version.API11_HONEYCOMB_30 /*11*/:
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                m9422b(c2152a);
            case C1317h.Toolbar_navigationContentDescription /*21*/:
            case C1317h.Toolbar_logoDescription /*22*/:
            case C1317h.Toolbar_titleTextColor /*23*/:
            case C1317h.Toolbar_subtitleTextColor /*24*/:
            case C1317h.Theme_listPreferredItemHeightLarge /*71*/:
            case C1317h.Theme_listPreferredItemPaddingLeft /*72*/:
            case C1317h.Theme_listPreferredItemPaddingRight /*73*/:
            case C1317h.Theme_dropDownListViewStyle /*74*/:
                m9427d(c2152a);
            case C1317h.Theme_actionModeCloseDrawable /*31*/:
            case HTTP.SP /*32*/:
            case C1317h.Theme_actionModeCopyDrawable /*33*/:
            case C1317h.Theme_actionModePasteDrawable /*34*/:
            case C1317h.Theme_listChoiceBackgroundIndicator /*81*/:
            case C1317h.Theme_colorPrimary /*82*/:
            case C1317h.Theme_colorPrimaryDark /*83*/:
            case C1317h.Theme_colorAccent /*84*/:
                m9429e(c2152a);
            case C1317h.Theme_textAppearanceSmallPopupMenu /*41*/:
            case C1317h.Theme_dialogTheme /*42*/:
            case C1317h.Theme_dialogPreferredPadding /*43*/:
            case C1317h.Theme_listDividerAlertDialog /*44*/:
                m9431f(c2152a);
            case C1317h.Theme_buttonBarButtonStyle /*51*/:
            case C1317h.Theme_selectableItemBackground /*52*/:
            case C1317h.Theme_selectableItemBackgroundBorderless /*53*/:
            case C1317h.Theme_borderlessButtonStyle /*54*/:
                m9432g(c2152a);
            case C1317h.Theme_popupWindowStyle /*61*/:
            case C1317h.Theme_editTextColor /*62*/:
            case C1317h.Theme_editTextBackground /*63*/:
            case C1317h.Theme_imageButtonStyle /*64*/:
                m9425c(c2152a);
            case C1317h.Theme_alertDialogButtonGroupStyle /*92*/:
                m9433h(c2152a);
            default:
        }
    }

    public void m9415a(Emojicon emojicon) {
        this.f6364n.m9832a(emojicon);
    }

    public void m9416b(int i) {
        C1521a.m7668a((Context) this).m7677a(i);
    }

    protected abstract void m9417b(int i, int i2, int i3, String str);

    public void m9418b(long j) {
        C1494c.m7539a(new C1366a(getApplicationContext(), j));
    }

    @SuppressLint({"NewApi"})
    protected void m9419b(String str) {
        if (VERSION.SDK_INT < 11) {
            ((ClipboardManager) getSystemService("clipboard")).setText(str);
        } else {
            ((android.content.ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(getString(C1136d.app_name), str));
        }
    }

    public void m9420b(String str, String str2, boolean z) {
        String charSequence = this.f6367q.getTitle() != null ? this.f6367q.getTitle().toString() : BuildConfig.FLAVOR;
        if (new File(Uri.parse(str).getPath()).exists()) {
            C1659a.m8430a(m8494q(), str, str2, charSequence);
            return;
        }
        C1598c.m8096a(m8494q(), str, z ? C1604i.NOT_STARTED : C1604i.DELETED);
        Toast.makeText(m8494q(), "File not exists!", 0).show();
    }

    protected void m9421b(C1722f c1722f) {
        af afVar = new af(this, 2131427471);
        afVar.m3610b(getString(2131230802));
        afVar.m3607a(getString(2131230760), new C2003k(this, c1722f));
        afVar.m3611b(getString(2131230813), null);
        afVar.m3612c();
    }

    protected abstract void m9422b(C2152a c2152a);

    protected abstract void m9423c(String str);

    protected void m9424c(C1722f c1722f) {
        switch (c1722f.m8659g()) {
            case Version.API11_HONEYCOMB_30 /*11*/:
                m9419b(((C2179g) c1722f).m9970o());
                break;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                m9419b(((C2170g) c1722f).m9930o());
                break;
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                m9419b(((C2187g) c1722f).m10014o());
                break;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                m9419b(((C2161h) c1722f).m9886q());
                break;
        }
        new Handler().postDelayed(new C2006n(this), 50);
    }

    protected abstract void m9425c(C2152a c2152a);

    public void m9426d(String str) {
        m9388h(str);
    }

    protected abstract void m9427d(C2152a c2152a);

    protected void m9428e(String str) {
        m8488a(this.f6367q, str);
    }

    protected abstract void m9429e(C2152a c2152a);

    protected void m9430f(String str) {
        m8490b(this.f6367q, str);
    }

    protected abstract void m9431f(C2152a c2152a);

    protected abstract void m9432g(C2152a c2152a);

    protected abstract void m9433h(C2152a c2152a);

    protected void m9434i(C2152a c2152a) {
        switch (c2152a.m8659g()) {
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                C2176d c2176d = (C2176d) c2152a;
                if (new File(Uri.parse(c2176d.m9956o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2176d.m9956o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Toolbar_logoDescription /*22*/:
                C2167d c2167d = (C2167d) c2152a;
                if (new File(Uri.parse(c2167d.m9912o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2167d.m9912o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Toolbar_titleTextColor /*23*/:
                C2184d c2184d = (C2184d) c2152a;
                if (new File(Uri.parse(c2184d.m9996o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2184d.m9996o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Toolbar_subtitleTextColor /*24*/:
                C2157d c2157d = (C2157d) c2152a;
                if (new File(Uri.parse(c2157d.m9866q()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2157d.m9866q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_actionModeCloseDrawable /*31*/:
                C2181i c2181i = (C2181i) c2152a;
                if (new File(Uri.parse(c2181i.m9979o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2181i.m9979o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case HTTP.SP /*32*/:
                C2172i c2172i = (C2172i) c2152a;
                if (new File(Uri.parse(c2172i.m9939o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2172i.m9939o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_actionModeCopyDrawable /*33*/:
                C2189i c2189i = (C2189i) c2152a;
                if (new File(Uri.parse(c2189i.m10023o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2189i.m10023o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_actionModePasteDrawable /*34*/:
                C2163j c2163j = (C2163j) c2152a;
                if (new File(Uri.parse(c2163j.m9895q()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2163j.m9895q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_textAppearanceSmallPopupMenu /*41*/:
                C2174b c2174b = (C2174b) c2152a;
                if (new File(Uri.parse(c2174b.m9948r()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2174b.m9948r(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_dialogTheme /*42*/:
                C2165b c2165b = (C2165b) c2152a;
                if (new File(Uri.parse(c2165b.m9904r()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2165b.m9904r(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_dialogPreferredPadding /*43*/:
                C2182b c2182b = (C2182b) c2152a;
                if (new File(Uri.parse(c2182b.m9988r()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2182b.m9988r(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listDividerAlertDialog /*44*/:
                C2155b c2155b = (C2155b) c2152a;
                if (new File(Uri.parse(c2155b.m9858t()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2155b.m9858t(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listPreferredItemHeightLarge /*71*/:
                C2175c c2175c = (C2175c) c2152a;
                if (new File(Uri.parse(c2175c.m9950o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2175c.m9950o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listPreferredItemPaddingLeft /*72*/:
                C2166c c2166c = (C2166c) c2152a;
                if (new File(Uri.parse(c2166c.m9906o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2166c.m9906o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listPreferredItemPaddingRight /*73*/:
                C2183c c2183c = (C2183c) c2152a;
                if (new File(Uri.parse(c2183c.m9990o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2183c.m9990o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_dropDownListViewStyle /*74*/:
                C2156c c2156c = (C2156c) c2152a;
                if (new File(Uri.parse(c2156c.m9860q()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2156c.m9860q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listChoiceBackgroundIndicator /*81*/:
                C2180h c2180h = (C2180h) c2152a;
                if (new File(Uri.parse(c2180h.m9972o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2180h.m9972o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_colorPrimary /*82*/:
                C2171h c2171h = (C2171h) c2152a;
                if (new File(Uri.parse(c2171h.m9932o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2171h.m9932o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_colorPrimaryDark /*83*/:
                C2188h c2188h = (C2188h) c2152a;
                if (new File(Uri.parse(c2188h.m10016o()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2188h.m10016o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_colorAccent /*84*/:
                C2162i c2162i = (C2162i) c2152a;
                if (new File(Uri.parse(c2162i.m9888q()).getPath()).exists()) {
                    C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
                    return;
                }
                C1598c.m8096a(m8494q(), c2162i.m9888q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            default:
                C1659a.m8451e((Activity) this, c2152a.m9844f(), false);
        }
    }

    protected void m9435j(C2152a c2152a) {
        switch (c2152a.m8659g()) {
            case Version.API11_HONEYCOMB_30 /*11*/:
                ao.m8482a(m8494q(), ((C2179g) c2152a).m9970o());
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                ao.m8482a(m8494q(), ((C2170g) c2152a).m9930o());
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                ao.m8482a(m8494q(), ((C2187g) c2152a).m10014o());
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                ao.m8482a(m8494q(), ((C2161h) c2152a).m9886q());
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                C2176d c2176d = (C2176d) c2152a;
                if (new File(Uri.parse(c2176d.m9956o()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2176d.m9956o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2176d.m9956o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Toolbar_logoDescription /*22*/:
                C2167d c2167d = (C2167d) c2152a;
                if (new File(Uri.parse(c2167d.m9912o()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2167d.m9912o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2167d.m9912o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Toolbar_titleTextColor /*23*/:
                C2184d c2184d = (C2184d) c2152a;
                if (new File(Uri.parse(c2184d.m9996o()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2184d.m9996o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2184d.m9996o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Toolbar_subtitleTextColor /*24*/:
                C2157d c2157d = (C2157d) c2152a;
                if (new File(Uri.parse(c2157d.m9866q()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2157d.m9866q());
                    return;
                }
                C1598c.m8096a(m8494q(), c2157d.m9866q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_actionModeCloseDrawable /*31*/:
                C2181i c2181i = (C2181i) c2152a;
                if (new File(Uri.parse(c2181i.m9979o()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2181i.m9979o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2181i.m9979o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case HTTP.SP /*32*/:
                C2172i c2172i = (C2172i) c2152a;
                if (new File(Uri.parse(c2172i.m9939o()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2172i.m9939o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2172i.m9939o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_actionModeCopyDrawable /*33*/:
                C2189i c2189i = (C2189i) c2152a;
                if (new File(Uri.parse(c2189i.m10023o()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2189i.m10023o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2189i.m10023o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_actionModePasteDrawable /*34*/:
                C2163j c2163j = (C2163j) c2152a;
                if (new File(Uri.parse(c2163j.m9895q()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2163j.m9895q());
                    return;
                }
                C1598c.m8096a(m8494q(), c2163j.m9895q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_textAppearanceSmallPopupMenu /*41*/:
                C2174b c2174b = (C2174b) c2152a;
                if (new File(Uri.parse(c2174b.m9948r()).getPath()).exists()) {
                    ao.m8485d(m8494q(), c2174b.m9948r());
                    return;
                }
                C1598c.m8096a(m8494q(), c2174b.m9948r(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_dialogTheme /*42*/:
                C2165b c2165b = (C2165b) c2152a;
                if (new File(Uri.parse(c2165b.m9904r()).getPath()).exists()) {
                    ao.m8485d(m8494q(), c2165b.m9904r());
                    return;
                }
                C1598c.m8096a(m8494q(), c2165b.m9904r(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_dialogPreferredPadding /*43*/:
                C2182b c2182b = (C2182b) c2152a;
                if (new File(Uri.parse(c2182b.m9988r()).getPath()).exists()) {
                    ao.m8485d(m8494q(), c2182b.m9988r());
                    return;
                }
                C1598c.m8096a(m8494q(), c2182b.m9988r(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listDividerAlertDialog /*44*/:
                C2155b c2155b = (C2155b) c2152a;
                if (new File(Uri.parse(c2155b.m9858t()).getPath()).exists()) {
                    ao.m8485d(m8494q(), c2155b.m9858t());
                    return;
                }
                C1598c.m8096a(m8494q(), c2155b.m9858t(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listPreferredItemHeightLarge /*71*/:
                C2175c c2175c = (C2175c) c2152a;
                if (new File(Uri.parse(c2175c.m9950o()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2175c.m9950o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2175c.m9950o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listPreferredItemPaddingLeft /*72*/:
                C2166c c2166c = (C2166c) c2152a;
                if (new File(Uri.parse(c2166c.m9906o()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2166c.m9906o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2166c.m9906o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listPreferredItemPaddingRight /*73*/:
                C2183c c2183c = (C2183c) c2152a;
                if (new File(Uri.parse(c2183c.m9990o()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2183c.m9990o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2183c.m9990o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_dropDownListViewStyle /*74*/:
                C2156c c2156c = (C2156c) c2152a;
                if (new File(Uri.parse(c2156c.m9860q()).getPath()).exists()) {
                    ao.m8483b(m8494q(), c2156c.m9860q());
                    return;
                }
                C1598c.m8096a(m8494q(), c2156c.m9860q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_listChoiceBackgroundIndicator /*81*/:
                C2180h c2180h = (C2180h) c2152a;
                if (new File(Uri.parse(c2180h.m9972o()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2180h.m9972o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2180h.m9972o(), C1604i.DELETED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_colorPrimary /*82*/:
                C2171h c2171h = (C2171h) c2152a;
                if (new File(Uri.parse(c2171h.m9932o()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2171h.m9932o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2171h.m9932o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_colorPrimaryDark /*83*/:
                C2188h c2188h = (C2188h) c2152a;
                if (new File(Uri.parse(c2188h.m10016o()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2188h.m10016o());
                    return;
                }
                C1598c.m8096a(m8494q(), c2188h.m10016o(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            case C1317h.Theme_colorAccent /*84*/:
                C2162i c2162i = (C2162i) c2152a;
                if (new File(Uri.parse(c2162i.m9888q()).getPath()).exists()) {
                    ao.m8484c(m8494q(), c2162i.m9888q());
                    return;
                }
                C1598c.m8096a(m8494q(), c2162i.m9888q(), C1604i.NOT_STARTED);
                Toast.makeText(m8494q(), "File not exists!", 0).show();
            default:
        }
    }

    protected void m9436k(C2152a c2152a) {
        this.f6351I = true;
        this.f6352J = c2152a.m9844f();
        this.f6353K = c2152a.m9846j();
        this.f6354L = BuildConfig.FLAVOR;
        this.f6355M = BuildConfig.FLAVOR;
        this.f6356N = -1;
        this.f6357O = 0;
        switch (c2152a.m8659g()) {
            case Version.API11_HONEYCOMB_30 /*11*/:
                this.f6354L = ((C2179g) c2152a).m9970o();
                this.f6355M = null;
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                this.f6354L = ((C2170g) c2152a).m9930o();
                this.f6355M = null;
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                this.f6354L = ((C2187g) c2152a).m10014o();
                this.f6355M = null;
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                this.f6354L = ((C2161h) c2152a).m9886q();
                this.f6355M = null;
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                C2176d c2176d = (C2176d) c2152a;
                this.f6354L = getString(2131230930);
                if (c2176d.m9960s() == C1604i.FINISHED) {
                    this.f6355M = c2176d.m9958q();
                } else if (c2176d.m9959r() == C1604i.FINISHED) {
                    this.f6355M = c2176d.m9956o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Toolbar_logoDescription /*22*/:
                C2167d c2167d = (C2167d) c2152a;
                this.f6354L = getString(2131230930);
                if (c2167d.m9916s() == C1604i.FINISHED) {
                    this.f6355M = c2167d.m9914q();
                } else if (c2167d.m9915r() == C1604i.FINISHED) {
                    this.f6355M = c2167d.m9912o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Toolbar_titleTextColor /*23*/:
                C2184d c2184d = (C2184d) c2152a;
                this.f6354L = getString(2131230930);
                if (c2184d.m10000s() == C1604i.FINISHED) {
                    this.f6355M = c2184d.m9998q();
                } else if (c2184d.m9999r() == C1604i.FINISHED) {
                    this.f6355M = c2184d.m9996o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Toolbar_subtitleTextColor /*24*/:
                C2157d c2157d = (C2157d) c2152a;
                this.f6354L = getString(2131230930);
                if (c2157d.m9870u() == C1604i.FINISHED) {
                    this.f6355M = c2157d.m9868s();
                } else if (c2157d.m9869t() == C1604i.FINISHED) {
                    this.f6355M = c2157d.m9866q();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Theme_actionModeCloseDrawable /*31*/:
                C2181i c2181i = (C2181i) c2152a;
                this.f6354L = getString(2131230934);
                if (c2181i.m9984t() == C1604i.FINISHED) {
                    this.f6355M = c2181i.m9981q();
                } else if (c2181i.m9983s() == C1604i.FINISHED) {
                    this.f6355M = c2181i.m9979o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case HTTP.SP /*32*/:
                C2172i c2172i = (C2172i) c2152a;
                this.f6354L = getString(2131230934);
                if (c2172i.m9944t() == C1604i.FINISHED) {
                    this.f6355M = c2172i.m9941q();
                } else if (c2172i.m9943s() == C1604i.FINISHED) {
                    this.f6355M = c2172i.m9939o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case C1317h.Theme_actionModeCopyDrawable /*33*/:
                C2189i c2189i = (C2189i) c2152a;
                this.f6354L = getString(2131230934);
                if (c2189i.m10028t() == C1604i.FINISHED) {
                    this.f6355M = c2189i.m10025q();
                } else if (c2189i.m10027s() == C1604i.FINISHED) {
                    this.f6355M = c2189i.m10023o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case C1317h.Theme_actionModePasteDrawable /*34*/:
                C2163j c2163j = (C2163j) c2152a;
                this.f6354L = getString(2131230934);
                if (c2163j.m9900v() == C1604i.FINISHED) {
                    this.f6355M = c2163j.m9897s();
                } else if (c2163j.m9899u() == C1604i.FINISHED) {
                    this.f6355M = c2163j.m9895q();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case C1317h.Theme_textAppearanceSmallPopupMenu /*41*/:
                C2174b c2174b = (C2174b) c2152a;
                this.f6354L = getString(2131230929);
                this.f6355M = null;
                this.f6356N = 2130838508;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_dialogTheme /*42*/:
                C2165b c2165b = (C2165b) c2152a;
                this.f6354L = getString(2131230929);
                this.f6355M = null;
                this.f6356N = 2130838508;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_dialogPreferredPadding /*43*/:
                C2182b c2182b = (C2182b) c2152a;
                this.f6354L = getString(2131230929);
                this.f6355M = null;
                this.f6356N = 2130838508;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_listDividerAlertDialog /*44*/:
                C2155b c2155b = (C2155b) c2152a;
                this.f6354L = getString(2131230929);
                this.f6355M = null;
                this.f6356N = 2130838508;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_buttonBarButtonStyle /*51*/:
                C2177e c2177e = (C2177e) c2152a;
                this.f6354L = getString(2131230932);
                this.f6355M = null;
                this.f6356N = 2130838574;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_selectableItemBackground /*52*/:
                C2168e c2168e = (C2168e) c2152a;
                this.f6354L = getString(2131230932);
                this.f6355M = null;
                this.f6356N = 2130838574;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_selectableItemBackgroundBorderless /*53*/:
                C2185e c2185e = (C2185e) c2152a;
                this.f6354L = getString(2131230932);
                this.f6355M = null;
                this.f6356N = 2130838574;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_borderlessButtonStyle /*54*/:
                C2159f c2159f = (C2159f) c2152a;
                this.f6354L = getString(2131230932);
                this.f6355M = null;
                this.f6356N = 2130838574;
                this.f6357O = getResources().getColor(2131624017);
                break;
            case C1317h.Theme_popupWindowStyle /*61*/:
                C2178f c2178f = (C2178f) c2152a;
                this.f6354L = getString(2131230933);
                this.f6355M = c2178f.m9967p();
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case C1317h.Theme_editTextColor /*62*/:
                C2169f c2169f = (C2169f) c2152a;
                this.f6354L = getString(2131230933);
                this.f6355M = c2169f.m9925r();
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case C1317h.Theme_editTextBackground /*63*/:
                C2186f c2186f = (C2186f) c2152a;
                this.f6354L = getString(2131230933);
                this.f6355M = c2186f.m10009r();
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case C1317h.Theme_imageButtonStyle /*64*/:
                C2160g c2160g = (C2160g) c2152a;
                this.f6354L = getString(2131230933);
                this.f6355M = c2160g.m9881t();
                this.f6356N = -1;
                this.f6357O = 0;
                break;
            case C1317h.Theme_listPreferredItemHeightLarge /*71*/:
                C2175c c2175c = (C2175c) c2152a;
                this.f6354L = c2175c.m9954s();
                if (c2175c.m9955t() == C1604i.FINISHED) {
                    this.f6355M = c2175c.m9952q();
                } else if (c2175c.m9953r() == C1604i.FINISHED) {
                    this.f6355M = c2175c.m9950o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Theme_listPreferredItemPaddingLeft /*72*/:
                C2166c c2166c = (C2166c) c2152a;
                this.f6354L = c2166c.m9910s();
                if (c2166c.m9911t() == C1604i.FINISHED) {
                    this.f6355M = c2166c.m9908q();
                } else if (c2166c.m9909r() == C1604i.FINISHED) {
                    this.f6355M = c2166c.m9906o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Theme_listPreferredItemPaddingRight /*73*/:
                C2183c c2183c = (C2183c) c2152a;
                this.f6354L = c2183c.m9994s();
                if (c2183c.m9995t() == C1604i.FINISHED) {
                    this.f6355M = c2183c.m9992q();
                } else if (c2183c.m9993r() == C1604i.FINISHED) {
                    this.f6355M = c2183c.m9990o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Theme_dropDownListViewStyle /*74*/:
                C2156c c2156c = (C2156c) c2152a;
                this.f6354L = c2156c.m9864u();
                if (c2156c.m9865v() == C1604i.FINISHED) {
                    this.f6355M = c2156c.m9862s();
                } else if (c2156c.m9863t() == C1604i.FINISHED) {
                    this.f6355M = c2156c.m9860q();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838530;
                this.f6357O = 0;
                break;
            case C1317h.Theme_listChoiceBackgroundIndicator /*81*/:
                C2180h c2180h = (C2180h) c2152a;
                this.f6354L = c2180h.m9977t();
                if (c2180h.m9978u() == C1604i.FINISHED) {
                    this.f6355M = c2180h.m9974q();
                } else if (c2180h.m9976s() == C1604i.FINISHED) {
                    this.f6355M = c2180h.m9972o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case C1317h.Theme_colorPrimary /*82*/:
                C2171h c2171h = (C2171h) c2152a;
                this.f6354L = c2171h.m9937t();
                if (c2171h.m9938u() == C1604i.FINISHED) {
                    this.f6355M = c2171h.m9934q();
                } else if (c2171h.m9936s() == C1604i.FINISHED) {
                    this.f6355M = c2171h.m9932o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case C1317h.Theme_colorPrimaryDark /*83*/:
                C2188h c2188h = (C2188h) c2152a;
                this.f6354L = c2188h.m10021t();
                if (c2188h.m10022u() == C1604i.FINISHED) {
                    this.f6355M = c2188h.m10018q();
                } else if (c2188h.m10020s() == C1604i.FINISHED) {
                    this.f6355M = c2188h.m10016o();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case C1317h.Theme_colorAccent /*84*/:
                C2162i c2162i = (C2162i) c2152a;
                this.f6354L = c2162i.m9893v();
                if (c2162i.m9894x() == C1604i.FINISHED) {
                    this.f6355M = c2162i.m9890s();
                } else if (c2162i.m9892u() == C1604i.FINISHED) {
                    this.f6355M = c2162i.m9888q();
                } else {
                    this.f6355M = BuildConfig.FLAVOR;
                }
                this.f6356N = 2130838589;
                this.f6357O = 0;
                break;
            case C1317h.Theme_alertDialogButtonGroupStyle /*92*/:
                C2158e c2158e = (C2158e) c2152a;
                this.f6354L = getString(2131230931);
                try {
                    this.f6354L = C1303d.m6879a(new JSONObject(c2158e.m9871q())).m6631a();
                } catch (Throwable e) {
                    C1104b.m6367b(this, "Error in parsing poll data.", e);
                }
                this.f6355M = null;
                this.f6356N = -1;
                this.f6357O = 0;
                break;
        }
        this.f6348F.setText(this.f6353K);
        this.f6349G.setText(this.f6354L);
        this.f6350H.setBackgroundColor(this.f6357O);
        if (this.f6355M != null) {
            this.f6350H.setVisibility(0);
            C0872i.m5265a(m8494q()).m5329a(this.f6355M).m4405a().m4407a(this.f6356N).m4406a(0.25f).m4417a(this.f6350H);
        } else if (this.f6356N > 0) {
            this.f6350H.setVisibility(0);
            C0872i.m5265a(m8494q()).m5328a(Integer.valueOf(this.f6356N)).m4405a().m4406a(0.25f).m4417a(this.f6350H);
        } else {
            this.f6350H.setVisibility(8);
            this.f6350H.setImageBitmap(null);
        }
        this.f6347E.setVisibility(0);
        new Handler().postDelayed(new C2005m(this), 50);
    }

    public int m9437l() {
        return this.f6365o;
    }

    public abstract int m9438m();

    public abstract int m9439n();

    public abstract int m9440o();

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 215 || i == 172 || i == 173) {
            if (i2 == -1 && intent.hasExtra("KEY_RESULT_ARRAYLIST_OF_PATH") && intent.hasExtra("KEY_RESULT_ARRAYLIST_OF_CAPTION")) {
                C1605j c1605j = intent.getIntExtra("KEY_RESULT_TYPE", 1) == 2 ? C1605j.VIDEO : C1605j.IMAGE;
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("KEY_RESULT_ARRAYLIST_OF_PATH");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("KEY_RESULT_ARRAYLIST_OF_CAPTION");
                for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                    m9378b((String) stringArrayListExtra.get(i3), (String) stringArrayListExtra2.get(i3), c1605j);
                }
            }
        } else if (i == 217) {
            if (i2 == -1 && intent.hasExtra("KEY_FILE_ARRAYLIST_OF_PATH_RESULT")) {
                Iterator it = intent.getStringArrayListExtra("KEY_FILE_ARRAYLIST_OF_PATH_RESULT").iterator();
                while (it.hasNext()) {
                    m9378b((String) it.next(), BuildConfig.FLAVOR, C1605j.OTHER);
                }
            }
        } else if (i2 == 18) {
            finish();
        }
    }

    public void onBackPressed() {
        if (this.f6374x) {
            this.f6374x = false;
            this.f6364n.m9835d();
            return;
        }
        String b = this.f6364n.m9833b();
        if (!(b == null || b.isEmpty())) {
            m9407a(b);
        }
        super.onBackPressed();
        overridePendingTransition(2131034126, 2131034130);
    }

    public void onCloseReplyLayoutPressed(View view) {
        m9379b(true);
    }

    protected void onDestroy() {
        super.onDestroy();
        C1512c.m7635c(this.f6368r);
        C1583c.m7989e(getApplicationContext(), this.f6368r);
    }

    public void onEvent(C1479f c1479f) {
        if (c1479f.m6997d() == C1486a.FILE_TOO_LARGE && m8494q() != null && this.f6361k != null) {
            runOnUiThread(new C2008p(this));
        }
    }

    public void onGoToStickerMarketPressed(View view) {
        C1659a.m8444c(m8494q());
    }

    public void onLoadMoreClicked(View view) {
        this.f6359Q = view;
        ProgressWheel progressWheel = (ProgressWheel) view.findViewById(2131689739);
        ((TextView) view.findViewById(2131689738)).setText(getString(2131230882));
        progressWheel.setVisibility(0);
        view.setClickable(false);
        view.setBackgroundResource(2130837588);
        this.f6360j.m9648c();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    protected void onPause() {
        super.onPause();
        this.f6344B.dismiss();
        this.f6376z.dismiss();
        this.f6364n.m9836e();
    }

    protected void onResume() {
        super.onResume();
        if (this.f6345C) {
            C1512c.m7635c(this.f6368r);
            C1583c.m7989e(getApplicationContext(), this.f6368r);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(C2019a.f6562b, this.f6360j.m9650e());
        bundle.putBoolean(C2019a.f6563c, true);
        bundle.putInt(C2019a.f6564d, this.f6360j.m9646b());
        bundle.putBoolean("key_is_reply_mode", this.f6351I);
        bundle.putString("key_reply_message_id", this.f6352J);
        bundle.putString("key_reply_top_text", this.f6353K);
        bundle.putString("key_reply_bottom_text", this.f6354L);
        bundle.putString("key_reply_image_uri", this.f6355M);
        bundle.putInt("key_reply_image_res_id", this.f6356N);
        bundle.putInt("key_reply_image_background_color", this.f6357O);
    }

    protected void m9441p() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            Runnable c2011s = new C2011s(this);
            if (getIntent().getExtras().getBoolean("key_is_share_mode", false)) {
                af afVar = new af(this, 2131427471);
                afVar.m3606a(getString(2131230938));
                afVar.m3610b(getString(2131230809));
                afVar.m3607a(getString(2131230926), new C2012t(this, c2011s));
                afVar.m3611b(getString(2131230813), new C2013u(this));
                afVar.m3612c();
            }
        }
    }

    protected void m9442r() {
        if (getIntent() != null && getIntent().getExtras() != null && getIntent().getExtras().containsKey("key_to_forward_message_id")) {
            String string = getIntent().getExtras().getString("key_to_forward_message_id");
            af afVar = new af(this, 2131427471);
            afVar.m3606a(getString(2131230849));
            afVar.m3610b(getString(2131230809));
            afVar.m3607a(getString(2131230926), new C2014v(this, string));
            afVar.m3611b(getString(2131230813), new C2015w(this));
            afVar.m3612c();
        }
    }

    public void m9443s() {
        if (!this.f6345C) {
            this.f6345C = true;
            C1512c.m7635c(this.f6368r);
            C1583c.m7989e(getApplicationContext(), this.f6368r);
        }
    }

    public void m9444t() {
        C1659a.m8444c(m8494q());
    }

    public void m9445u() {
        this.f6364n.m9830a();
    }

    public void m9446v() {
        if (this.f6373w) {
            this.f6373w = false;
            this.f6364n.m9835d();
            if (this.f6344B.isShowing()) {
                if (this.f6372v) {
                    this.f6372v = false;
                    this.f6376z.dismiss();
                } else {
                    new Handler().postDelayed(new C1999g(this), 300);
                }
                this.f6344B.dismiss();
            }
        }
    }

    public void m9447w() {
        if (this.f6344B.isShowing()) {
            this.f6376z.dismiss();
            this.f6344B.dismiss();
            return;
        }
        int i = this.f6370t;
        if (this.f6373w) {
            i = m9448x();
        }
        this.f6376z.setHeight(i);
        this.f6376z.setSoftInputMode(3);
        this.f6376z.showAtLocation(this.f6361k, 80, 0, 0);
        this.f6344B.setHeight(i);
        this.f6344B.setSoftInputMode(3);
        this.f6344B.showAtLocation(this.f6361k, 80, 0, 0);
        if (!this.f6373w) {
            this.f6364n.m9837f();
        }
    }

    public int m9448x() {
        Rect rect = new Rect();
        View rootView = this.f6361k.getRootView();
        this.f6361k.getWindowVisibleDisplayFrame(rect);
        return ((rootView.getHeight() - (rect.top != 0 ? C1111c.m6409d(getApplicationContext()) : 0)) - C1111c.m6390a(rootView)) - (rect.bottom - rect.top);
    }

    protected abstract void m9449y();

    public void m9450z() {
        C1521a.m7668a((Context) this).m7676a();
    }
}
