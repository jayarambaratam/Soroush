package mobi.mmdt.ott.logic.p112a.p120c.p121a.p123b;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.util.Map;
import mobi.mmdt.ott.logic.C1490b;
import mobi.mmdt.ott.provider.p170d.C1596a;
import mobi.mmdt.ott.provider.p170d.C1603h;
import mobi.mmdt.ott.provider.p170d.C1604i;
import mobi.mmdt.ott.provider.p170d.C1605j;

/* renamed from: mobi.mmdt.ott.logic.a.c.a.b.h */
public class C1374h {
    private C1596a f4714a;

    public C1374h(Context context, Map<String, String> map, C1605j c1605j) {
        this.f4714a = null;
        String str = (String) map.get("FILE_NAME");
        String str2 = (String) map.get("FILE_URL");
        String str3 = (String) map.get("FILE_ID");
        String str4 = (str3 == null || str3.isEmpty()) ? str2.split("/")[4] : str3;
        C1605j c1605j2;
        if (c1605j == C1605j.IMAGE) {
            c1605j2 = c1605j;
            this.f4714a = new C1596a(Uri.fromFile(new File(C1490b.m7516a(context).m7520a(str))), str2, str4, c1605j2, str, Long.parseLong((String) map.get("FILE_SIZE")), 0, Uri.fromFile(new File(C1490b.m7516a(context).m7519a())), (String) map.get("FILE_THUMBNAIL_URL"), -1, C1604i.NOT_STARTED, C1604i.NOT_STARTED, C1603h.STOP, -1);
        } else if (c1605j == C1605j.PUSH_TO_TALK) {
            c1605j2 = c1605j;
            this.f4714a = new C1596a(Uri.fromFile(new File(C1490b.m7516a(context).m7526d(str))), str2, str4, c1605j2, str, Long.parseLong((String) map.get("FILE_SIZE")), 0, null, null, Integer.parseInt((String) map.get("FILE_TYPE_PUSH_TO_TALK_DURATION")), C1604i.NOT_STARTED, C1604i.NOT_STARTED, C1603h.STOP, 0);
        } else if (c1605j == C1605j.VIDEO) {
            c1605j2 = c1605j;
            this.f4714a = new C1596a(Uri.fromFile(new File(C1490b.m7516a(context).m7524c(str))), str2, str4, c1605j2, str, Long.parseLong((String) map.get("FILE_SIZE")), 0, Uri.fromFile(new File(C1490b.m7516a(context).m7519a())), (String) map.get("FILE_THUMBNAIL_URL"), Integer.parseInt((String) map.get("FILE_TYPE_VIDEO_DURATION")), C1604i.NOT_STARTED, C1604i.NOT_STARTED, C1603h.STOP, 0);
        } else if (c1605j == C1605j.OTHER) {
            this.f4714a = new C1596a(Uri.fromFile(new File(C1490b.m7516a(context).m7527e(str))), str2, str4, c1605j, str, Long.parseLong((String) map.get("FILE_SIZE")), 0, null, null, -1, C1604i.NOT_STARTED, C1604i.NOT_STARTED, C1603h.STOP, 0);
        }
    }

    public C1596a m7152a() {
        return this.f4714a;
    }
}
