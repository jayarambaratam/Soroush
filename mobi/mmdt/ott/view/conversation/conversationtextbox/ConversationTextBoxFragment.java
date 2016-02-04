package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Timer;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.p109d.p111b.C1309a;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.C2136a;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.EmojiconEditText;
import mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon.emoji.Emojicon;

public class ConversationTextBoxFragment extends Fragment implements C2136a {
    private C1990o f6977a;
    private View f6978b;
    private EmojiconEditText f6979c;
    private ImageView f6980d;
    private ImageView f6981e;
    private ImageView f6982f;
    private boolean f6983g;
    private boolean f6984h;
    private Timer f6985i;
    private FrameLayout f6986j;
    private boolean f6987k;
    private FrameLayout f6988l;
    private TextView f6989m;
    private TextView f6990n;
    private LayoutParams f6991o;
    private CountDownTimer f6992p;
    private int f6993q;
    private boolean f6994r;
    private TextWatcher f6995s;

    public ConversationTextBoxFragment() {
        this.f6983g = false;
        this.f6984h = false;
        this.f6985i = null;
        this.f6987k = false;
        this.f6993q = 0;
        this.f6994r = false;
        this.f6995s = new C2138b(this);
    }

    private void m9811h() {
        this.f6979c = (EmojiconEditText) this.f6978b.findViewById(2131689799);
        this.f6980d = (ImageView) this.f6978b.findViewById(2131689815);
        this.f6981e = (ImageView) this.f6978b.findViewById(2131689803);
        this.f6982f = (ImageView) this.f6978b.findViewById(2131689838);
        this.f6989m = (TextView) this.f6978b.findViewById(2131689840);
        this.f6990n = (TextView) this.f6978b.findViewById(2131689841);
        this.f6986j = (FrameLayout) this.f6978b.findViewById(2131689798);
        this.f6988l = (FrameLayout) this.f6978b.findViewById(2131689839);
        this.f6991o = (LayoutParams) this.f6989m.getLayoutParams();
        this.f6979c.addTextChangedListener(this.f6995s);
        this.f6979c.setFilters(new InputFilter[]{new LengthFilter(100000)});
        this.f6979c.setOnImeBackListener(this);
        this.f6979c.setTextSize((float) C1309a.m6934a(getActivity()).m6983z());
        this.f6979c.setOnClickListener(new C2137a(this));
        this.f6981e.setOnClickListener(new C2142f(this));
        this.f6982f.setOnClickListener(new C2143g(this));
        this.f6980d.setOnClickListener(new C2144h(this));
        this.f6988l.setAlpha(0.0f);
        this.f6981e.setOnTouchListener(new C2145i(this, (int) C1111c.m6388a(getActivity(), 84.0f), new Handler()));
    }

    private void m9813i() {
        if (this.f6992p != null) {
            this.f6992p.cancel();
        }
        this.f6993q = 0;
        this.f6992p = new C2147k(this, 302000, 1000).start();
    }

    private void m9815j() {
        this.f6977a.m9354B();
    }

    private void m9818k() {
        if (this.f6992p != null) {
            this.f6992p.cancel();
        }
        this.f6977a.m9355C();
    }

    private void m9820l() {
        if (this.f6992p != null) {
            this.f6992p.cancel();
        }
        if (this.f6993q < 1) {
            this.f6977a.m9355C();
        } else {
            this.f6977a.m9356D();
        }
    }

    private void m9822m() {
        C1111c.m6405b(getActivity());
        C1111c.m6400a(getActivity(), 40);
        m9813i();
        new Handler().postDelayed(new C2148l(this), 25);
    }

    private void m9824n() {
        C1111c.m6400a(getActivity(), 40);
        new Handler().postDelayed(new C2149m(this), 25);
        new Handler().postDelayed(new C2150n(this), 500);
        C1111c.m6398a(getActivity());
    }

    public void m9830a() {
        this.f6979c.dispatchKeyEvent(new KeyEvent(0, 0, 0, 67, 0, 0, 0, 0, 6));
    }

    public void m9831a(String str) {
        getActivity().runOnUiThread(new C2140d(this, str));
    }

    public void m9832a(Emojicon emojicon) {
        if (this.f6979c != null && emojicon != null) {
            int selectionStart = this.f6979c.getSelectionStart();
            int selectionEnd = this.f6979c.getSelectionEnd();
            if (selectionStart < 0) {
                this.f6979c.append(emojicon.m10089b());
            } else {
                this.f6979c.getText().replace(Math.min(selectionStart, selectionEnd), Math.max(selectionStart, selectionEnd), emojicon.m10089b(), 0, emojicon.m10089b().length());
            }
        }
    }

    public String m9833b() {
        return this.f6979c.getText().toString();
    }

    public void m9834c() {
        getActivity().runOnUiThread(new C2141e(this));
    }

    public void m9835d() {
        this.f6983g = false;
        this.f6980d.setImageResource(2130838525);
    }

    public void m9836e() {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f6979c.getWindowToken(), 0);
    }

    public void m9837f() {
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInputFromWindow(this.f6979c.getWindowToken(), 0, 0);
        this.f6979c.requestFocus();
    }

    public void m9838g() {
        this.f6977a.m9359v();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f6977a = (C1990o) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement IConversationTextBoxFragment");
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f6978b = layoutInflater.inflate(2130968717, viewGroup, false);
        m9811h();
        return this.f6978b;
    }
}
