package mobi.mmdt.ott.view.conversation.emojisticker.emoji;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import mobi.mmdt.ott.view.p178a.p179a.C1656d;

/* renamed from: mobi.mmdt.ott.view.conversation.emojisticker.emoji.b */
class C2205b extends C1656d {
    final /* synthetic */ C2203a f7264a;

    C2205b(C2203a c2203a, Context context, int i) {
        this.f7264a = c2203a;
        super(context, i);
    }

    protected Bitmap m10072a(int i) {
        return BitmapFactory.decodeResource(this.f7264a.f7254b.getResources(), i);
    }
}
