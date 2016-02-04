package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.i */
class C2145i implements OnTouchListener {
    final /* synthetic */ int f7005a;
    final /* synthetic */ Handler f7006b;
    final /* synthetic */ ConversationTextBoxFragment f7007c;
    private boolean f7008d;

    C2145i(ConversationTextBoxFragment conversationTextBoxFragment, int i, Handler handler) {
        this.f7007c = conversationTextBoxFragment;
        this.f7005a = i;
        this.f7006b = handler;
        this.f7008d = false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f7007c.f6984h) {
            if (motionEvent.getAction() == 1) {
                this.f7008d = false;
                if (this.f7007c.f6987k) {
                    this.f7007c.f6987k = false;
                } else {
                    this.f7007c.m9824n();
                    this.f7007c.m9820l();
                }
            } else if (motionEvent.getAction() == 3) {
                this.f7008d = false;
                if (this.f7007c.f6987k) {
                    this.f7007c.f6987k = false;
                } else {
                    this.f7007c.m9824n();
                    this.f7007c.m9818k();
                }
            } else if (this.f7007c.f6987k) {
                this.f7008d = false;
            } else if (motionEvent.getAction() == 0) {
                this.f7008d = true;
                this.f7007c.m9822m();
                this.f7007c.m9815j();
            } else if (motionEvent.getAction() == 2) {
                int i = (int) (-motionEvent.getX());
                if (i > 0) {
                    if (i < this.f7005a) {
                        this.f7006b.post(new C2146j(this, i));
                    } else {
                        this.f7007c.f6987k = true;
                        this.f7007c.m9824n();
                        this.f7007c.m9818k();
                    }
                }
            }
        }
        return false;
    }
}
