package mobi.mmdt.ott.view.components.mediaselector;

import android.content.Intent;
import mobi.mmdt.ott.view.components.mediaselector.videoselection.VideoSelectorActivity;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.c */
class C1899c implements Runnable {
    final /* synthetic */ String f6100a;
    final /* synthetic */ String f6101b;
    final /* synthetic */ MainMediaSelectorActivity f6102c;

    C1899c(MainMediaSelectorActivity mainMediaSelectorActivity, String str, String str2) {
        this.f6102c = mainMediaSelectorActivity;
        this.f6100a = str;
        this.f6101b = str2;
    }

    public void run() {
        Intent intent = new Intent(this.f6102c.m8494q(), VideoSelectorActivity.class);
        intent.putExtra("KEY_FOLDER_NAME", this.f6100a);
        intent.putExtra("KEY_FOLDER_PATH", this.f6101b);
        this.f6102c.startActivityForResult(intent, 1819);
        this.f6102c.overridePendingTransition(2131034125, 2131034129);
    }
}
