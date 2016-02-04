package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.h */
class C2144h implements OnClickListener {
    final /* synthetic */ ConversationTextBoxFragment f7004a;

    C2144h(ConversationTextBoxFragment conversationTextBoxFragment) {
        this.f7004a = conversationTextBoxFragment;
    }

    public void onClick(View view) {
        if (this.f7004a.f6983g) {
            this.f7004a.f6983g = false;
            this.f7004a.f6980d.setImageResource(2130838525);
        } else {
            this.f7004a.f6983g = true;
            this.f7004a.f6980d.setImageResource(2130838524);
        }
        this.f7004a.f6977a.m9360w();
    }
}
