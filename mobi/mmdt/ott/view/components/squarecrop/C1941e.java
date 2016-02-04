package mobi.mmdt.ott.view.components.squarecrop;

import android.content.Intent;

/* renamed from: mobi.mmdt.ott.view.components.squarecrop.e */
class C1941e implements Runnable {
    final /* synthetic */ String f6230a;
    final /* synthetic */ C1938b f6231b;

    C1941e(C1938b c1938b, String str) {
        this.f6231b = c1938b;
        this.f6230a = str;
    }

    public void run() {
        Intent intent = new Intent();
        intent.putExtra("KEY_SQUARE_IMAGE_FILE_PATH", this.f6230a);
        this.f6231b.f6227b.setResult(-1, intent);
        this.f6231b.f6227b.onBackPressed();
    }
}
