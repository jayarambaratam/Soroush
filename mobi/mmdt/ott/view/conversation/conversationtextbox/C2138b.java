package mobi.mmdt.ott.view.conversation.conversationtextbox;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.Timer;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.p089b.C1162g;

/* renamed from: mobi.mmdt.ott.view.conversation.conversationtextbox.b */
class C2138b implements TextWatcher {
    final /* synthetic */ ConversationTextBoxFragment f6997a;

    C2138b(ConversationTextBoxFragment conversationTextBoxFragment) {
        this.f6997a = conversationTextBoxFragment;
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!this.f6997a.f6994r) {
            this.f6997a.f6994r = true;
            this.f6997a.f6977a.m9357a(C1162g.COMPOSING);
        }
        if (this.f6997a.f6985i != null) {
            this.f6997a.f6985i.cancel();
            this.f6997a.f6985i.purge();
        }
        this.f6997a.f6985i = new Timer();
        this.f6997a.f6985i.schedule(new C2139c(this), 1000);
        if (charSequence == null || charSequence.length() <= 0) {
            this.f6997a.f6984h = false;
            this.f6997a.f6981e.setImageResource(2130838472);
            this.f6997a.f6982f.setVisibility(0);
            this.f6997a.f6979c.setPadding((int) C1111c.m6388a(this.f6997a.getActivity(), 52.0f), (int) C1111c.m6388a(this.f6997a.getActivity(), 0.0f), (int) C1111c.m6388a(this.f6997a.getActivity(), 52.0f), (int) C1111c.m6388a(this.f6997a.getActivity(), 0.0f));
            return;
        }
        this.f6997a.f6984h = true;
        this.f6997a.f6981e.setImageResource(2130838499);
        this.f6997a.f6982f.setVisibility(8);
        this.f6997a.f6979c.setPadding((int) C1111c.m6388a(this.f6997a.getActivity(), 52.0f), (int) C1111c.m6388a(this.f6997a.getActivity(), 0.0f), (int) C1111c.m6388a(this.f6997a.getActivity(), 4.0f), (int) C1111c.m6388a(this.f6997a.getActivity(), 0.0f));
    }
}
