package mobi.mmdt.ott.view.components.mediaselector;

import android.content.Intent;
import mobi.mmdt.ott.view.components.mediaselector.photoselection.PhotoSelectorActivity;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.b */
class C1898b implements Runnable {
    final /* synthetic */ String f6097a;
    final /* synthetic */ String f6098b;
    final /* synthetic */ MainMediaSelectorActivity f6099c;

    C1898b(MainMediaSelectorActivity mainMediaSelectorActivity, String str, String str2) {
        this.f6099c = mainMediaSelectorActivity;
        this.f6097a = str;
        this.f6098b = str2;
    }

    public void run() {
        Intent intent = new Intent(this.f6099c.m8494q(), PhotoSelectorActivity.class);
        intent.putExtra("KEY_FOLDER_NAME", this.f6097a);
        intent.putExtra("KEY_FOLDER_PATH", this.f6098b);
        intent.putExtra("EXTRA_MAX_PHOTO_SELECT_COUNT", this.f6099c.f6062n);
        intent.putExtra("EXTRA_SELECT_MODE", this.f6099c.f6061m);
        this.f6099c.startActivityForResult(intent, 1818);
        this.f6099c.overridePendingTransition(2131034125, 2131034129);
    }
}
