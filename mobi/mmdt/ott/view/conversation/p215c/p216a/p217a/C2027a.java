package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p037d.p039b.C0652e;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.componentsutils.view.roundavatarimageview.RoundAvatarImageView;
import mobi.mmdt.ott.view.components.p181b.C1790i;
import mobi.mmdt.ott.view.conversation.p213a.C1981a;
import mobi.mmdt.ott.view.conversation.p215c.p216a.C2026a;
import mobi.mmdt.ott.view.conversation.p222d.p223a.p225a.C2154a;
import mobi.mmdt.ott.view.p178a.aj;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.a */
public abstract class C2027a extends C2026a {
    protected C1981a f6609c;
    private TextView f6610d;
    private ImageView f6611e;
    private TextView f6612f;
    private RoundAvatarImageView f6613g;

    public C2027a(Activity activity, C1790i c1790i, LayoutInflater layoutInflater, ViewGroup viewGroup, int i, C1981a c1981a) {
        super(activity, c1790i, layoutInflater, viewGroup, i);
        this.f6611e = (ImageView) this.itemView.findViewById(2131689728);
        this.f6610d = (TextView) this.itemView.findViewById(2131689729);
        this.f6612f = (TextView) this.itemView.findViewById(2131689720);
        this.f6613g = (RoundAvatarImageView) this.itemView.findViewById(2131689718);
        this.f6609c = c1981a;
        this.f6611e.setOnClickListener(new C2028b(this));
    }

    private void m9662a(boolean z, boolean z2) {
        if (z2) {
            AnimatorSet animatorSet = new AnimatorSet();
            Object obj = this.f6611e;
            String str = "rotation";
            float[] fArr = new float[2];
            fArr[0] = 0.0f;
            fArr[1] = z ? 360.0f : -360.0f;
            Animator ofFloat = ObjectAnimator.ofFloat(obj, str, fArr);
            ofFloat.setDuration(300);
            ofFloat.setInterpolator(new AccelerateInterpolator());
            Animator ofFloat2 = ObjectAnimator.ofFloat(this.f6611e, "scaleX", 0.2f, 1.0f);
            ofFloat2.setDuration(300);
            ofFloat2.setInterpolator(new OvershootInterpolator());
            Animator ofFloat3 = ObjectAnimator.ofFloat(this.f6611e, "scaleY", 0.2f, 1.0f);
            ofFloat3.setDuration(300);
            ofFloat3.setInterpolator(new OvershootInterpolator());
            ofFloat3.addListener(new C2031e(this, z));
            animatorSet.play(ofFloat);
            animatorSet.play(ofFloat2).with(ofFloat3).after(ofFloat);
            animatorSet.start();
        } else if (z) {
            this.f6611e.setImageResource(2130838555);
        } else {
            this.f6611e.setImageResource(2130838556);
        }
    }

    protected void m9664a(C2154a c2154a) {
        super.m9659a(c2154a);
        this.f6612f.setText(c2154a.m9846j());
        this.f6613g.setName(c2154a.m9846j());
        this.f6613g.setBackgroundColor(C1111c.m6402b(this.a, c2154a.m9851w()));
        this.f6613g.setImageBitmap(null);
        if (!(c2154a.m9852y() == null || c2154a.m9852y().isEmpty())) {
            C0872i.m5265a(this.a).m5329a(aj.m8474a(c2154a.m9852y())).m4409a(C0652e.ALL).m4406a(0.25f).m4417a(this.f6613g);
        }
        m9662a(c2154a.m9853o() != 0, false);
        this.f6610d.setText(C1111c.m6412e(c2154a.m9854p()));
    }
}
