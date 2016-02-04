package mobi.mmdt.ott.view.conversation.activities;

import android.net.Uri;
import java.io.File;
import mobi.mmdt.componentsutils.p079a.C1111c;
import mobi.mmdt.ott.provider.p170d.C1605j;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.conversation.activities.s */
class C2011s implements Runnable {
    final /* synthetic */ C1992a f6550a;

    C2011s(C1992a c1992a) {
        this.f6550a = c1992a;
    }

    public void run() {
        String string;
        if (this.f6550a.getIntent().getExtras().containsKey("key_to_share_message")) {
            string = this.f6550a.getIntent().getExtras().getString("key_to_share_message");
            if (string.length() > 100000) {
                string = string.substring(0, 100000);
            }
            this.f6550a.m9388h(string);
        } else if (this.f6550a.getIntent().getExtras().containsKey("key_to_share_image_uri")) {
            string = this.f6550a.getIntent().getExtras().getString("key_to_share_image_uri");
            this.f6550a.m9378b(string.startsWith("content:/") ? C1111c.m6396a(this.f6550a.getApplicationContext(), Uri.parse(string)) : new File(Uri.parse(string).getPath()).getPath(), BuildConfig.FLAVOR, C1605j.IMAGE);
        } else if (this.f6550a.getIntent().getExtras().containsKey("key_to_share_video_uri")) {
            string = this.f6550a.getIntent().getExtras().getString("key_to_share_video_uri");
            this.f6550a.m9378b(string.startsWith("content:/") ? C1111c.m6396a(this.f6550a.getApplicationContext(), Uri.parse(string)) : new File(Uri.parse(string).getPath()).getPath(), BuildConfig.FLAVOR, C1605j.VIDEO);
        } else if (this.f6550a.getIntent().getExtras().containsKey("key_to_share_file_uri")) {
            string = this.f6550a.getIntent().getExtras().getString("key_to_share_file_uri");
            this.f6550a.m9378b(string.startsWith("content:/") ? C1111c.m6396a(this.f6550a.getApplicationContext(), Uri.parse(string)) : new File(Uri.parse(string).getPath()).getPath(), BuildConfig.FLAVOR, C1605j.OTHER);
        }
    }
}
