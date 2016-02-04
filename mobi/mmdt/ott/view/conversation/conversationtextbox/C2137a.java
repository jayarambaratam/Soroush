package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.a */
class C2137a implements OnClickListener {
    final /* synthetic */ ConversationTextBoxFragment f6996a;

    C2137a(ConversationTextBoxFragment conversationTextBoxFragment) {
        this.f6996a = conversationTextBoxFragment;
    }

    public void onClick(View view) {
        if (this.f6996a.f6983g) {
            this.f6996a.f6983g = false;
            this.f6996a.f6980d.setImageResource(2130838525);
            this.f6996a.f6977a.m9360w();
        }
    }
}
