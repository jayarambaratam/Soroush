package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.os.CountDownTimer;
import mobi.mmdt.componentsutils.p079a.C1111c;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.k */
class C2147k extends CountDownTimer {
    final /* synthetic */ ConversationTextBoxFragment f7011a;

    C2147k(ConversationTextBoxFragment conversationTextBoxFragment, long j, long j2) {
        this.f7011a = conversationTextBoxFragment;
        super(j, j2);
    }

    public void onFinish() {
    }

    public void onTick(long j) {
        int i = (int) (j / 1000);
        int i2 = (302 - i) - 1;
        this.f7011a.f6990n.setText(C1111c.m6393a(i2));
        this.f7011a.f6993q = i2;
        if (i == 1) {
            this.f7011a.f6987k = true;
            this.f7011a.m9824n();
            this.f7011a.m9820l();
        }
    }
}
