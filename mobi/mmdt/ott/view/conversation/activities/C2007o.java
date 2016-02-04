package mobi.mmdt.ott.view.conversation.activities;

import android.widget.TextView;
import com.pnikosis.materialishprogress.ProgressWheel;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.o */
class C2007o implements Runnable {
    final /* synthetic */ C1992a f6546a;

    C2007o(C1992a c1992a) {
        this.f6546a = c1992a;
    }

    public void run() {
        if (this.f6546a.f6359Q != null) {
            ProgressWheel progressWheel = (ProgressWheel) this.f6546a.f6359Q.findViewById(2131689739);
            ((TextView) this.f6546a.f6359Q.findViewById(2131689738)).setText(this.f6546a.getString(2131230881));
            progressWheel.setVisibility(8);
            this.f6546a.f6359Q.setClickable(true);
            this.f6546a.f6359Q.setBackgroundResource(2130837590);
        }
    }
}
