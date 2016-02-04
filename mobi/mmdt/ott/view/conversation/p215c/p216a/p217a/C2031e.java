package mobi.mmdt.ott.view.conversation.p215c.p216a.p217a;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;

/* renamed from: mobi.mmdt.ott.view.conversation.c.a.a.e */
class C2031e extends AnimatorListenerAdapter {
    final /* synthetic */ boolean f6684a;
    final /* synthetic */ C2027a f6685b;

    C2031e(C2027a c2027a, boolean z) {
        this.f6685b = c2027a;
        this.f6684a = z;
    }

    public void onAnimationStart(Animator animator) {
        if (this.f6684a) {
            this.f6685b.f6611e.setImageResource(2130838555);
        } else {
            this.f6685b.f6611e.setImageResource(2130838556);
        }
    }
}
