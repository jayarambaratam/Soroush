package mobi.mmdt.ott.provider.p170d;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: mobi.mmdt.ott.provider.d.c */
public class C1598c {
    public static int m8092a(Context context, long j, int i) {
        C1600e c1600e = new C1600e();
        c1600e.m8108a(i);
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8093a(Context context, long j, String str, String str2, String str3) {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException();
        }
        C1600e c1600e = new C1600e();
        c1600e.m8116b(str);
        c1600e.m8118c(str3);
        c1600e.m8121f(str2);
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8094a(Context context, long j, C1603h c1603h) {
        C1600e c1600e = new C1600e();
        c1600e.m8112a(c1603h);
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8095a(Context context, long j, C1604i c1604i) {
        C1600e c1600e = new C1600e();
        c1600e.m8113a(c1604i);
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8096a(Context context, String str, C1604i c1604i) {
        C1600e c1600e = new C1600e();
        c1600e.m8113a(c1604i);
        C1602g c1602g = new C1602g();
        c1602g.m8139a(str);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8097a(Context context, C1603h c1603h) {
        C1600e c1600e = new C1600e();
        c1600e.m8112a(c1603h);
        return c1600e.m8106a(context, new C1602g());
    }

    public static int m8098a(Context context, C1603h c1603h, int i) {
        C1600e c1600e = new C1600e();
        c1600e.m8115b(i);
        C1602g c1602g = new C1602g();
        c1602g.m8140a(c1603h);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8099a(Context context, C1604i c1604i, C1604i c1604i2) {
        C1600e c1600e = new C1600e();
        c1600e.m8113a(c1604i2);
        C1602g c1602g = new C1602g();
        c1602g.m8141a(c1604i);
        return c1600e.m8106a(context, c1602g);
    }

    public static Uri m8100a(Context context, Uri uri, String str, String str2, C1605j c1605j, String str3, long j, int i, Uri uri2, String str4, int i2, C1604i c1604i, C1604i c1604i2, C1603h c1603h, int i3) {
        if (uri == null || uri.getPath().isEmpty() || str3 == null || str3.isEmpty() || c1604i2 == null || c1604i == null) {
            throw new NullPointerException();
        }
        C1600e c1600e = new C1600e();
        if (c1605j == C1605j.IMAGE || c1605j == C1605j.VIDEO) {
            c1600e.m8111a(uri.toString()).m8118c(str2).m8117b(c1604i2).m8116b(str).m8114a(c1605j).m8119d(str3).m8109a(j).m8108a(i).m8120e(uri2.toString()).m8121f(str4).m8110a(Integer.valueOf(i2)).m8113a(c1604i).m8112a(c1603h).m8115b(i3);
        } else {
            c1600e.m8111a(uri.toString()).m8118c(str2).m8117b(c1604i2).m8116b(str).m8114a(c1605j).m8119d(str3).m8109a(j).m8108a(i).m8110a(Integer.valueOf(i2)).m8113a(c1604i).m8112a(c1603h).m8115b(i3);
        }
        return c1600e.m7897a(context);
    }

    public static ArrayList<Uri> m8101a(Context context, ArrayList<C1596a> arrayList) {
        ContentValues[] contentValuesArr = new ContentValues[arrayList.size()];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1596a c1596a = (C1596a) it.next();
            if (c1596a.m8082n() == null || c1596a.m8082n().getPath().isEmpty() || c1596a.m8078j() == null || c1596a.m8078j().isEmpty() || c1596a.m8072d() == null || c1596a.m8071c() == null) {
                throw new NullPointerException();
            }
            contentValuesArr[i] = new ContentValues();
            if (c1596a.m8073e() == C1605j.IMAGE || c1596a.m8073e() == C1605j.VIDEO) {
                contentValuesArr[i].put("files_file_uri", c1596a.m8082n().toString());
                contentValuesArr[i].put("files_server_file_id", c1596a.m8079k());
                contentValuesArr[i].put("files_thumbnail_download_state", Integer.valueOf(c1596a.m8072d().ordinal()));
                contentValuesArr[i].put("files_file_url", c1596a.m8069a());
                contentValuesArr[i].put("files_type", Integer.valueOf(c1596a.m8073e().ordinal()));
                contentValuesArr[i].put("files_name", c1596a.m8078j());
                contentValuesArr[i].put("files_size", Long.valueOf(c1596a.m8077i()));
                contentValuesArr[i].put("files_progress", Long.valueOf(c1596a.m8076h()));
                contentValuesArr[i].put("files_thumbnail_uri", c1596a.m8081m().toString());
                contentValuesArr[i].put("files_thumbnail_url", c1596a.m8080l());
                contentValuesArr[i].put("files_duration", Integer.valueOf(c1596a.m8075g()));
                contentValuesArr[i].put("files_download_state", Integer.valueOf(c1596a.m8071c().ordinal()));
                contentValuesArr[i].put("files_audio_state", Integer.valueOf(c1596a.m8070b().ordinal()));
                contentValuesArr[i].put("files_audio_playing_time", Integer.valueOf(c1596a.m8074f()));
            } else {
                contentValuesArr[i].put("files_file_uri", c1596a.m8082n().toString());
                contentValuesArr[i].put("files_server_file_id", c1596a.m8079k());
                contentValuesArr[i].put("files_thumbnail_download_state", Integer.valueOf(c1596a.m8072d().ordinal()));
                contentValuesArr[i].put("files_file_url", c1596a.m8069a());
                contentValuesArr[i].put("files_type", Integer.valueOf(c1596a.m8073e().ordinal()));
                contentValuesArr[i].put("files_name", c1596a.m8078j());
                contentValuesArr[i].put("files_size", Long.valueOf(c1596a.m8077i()));
                contentValuesArr[i].put("files_progress", Long.valueOf(c1596a.m8076h()));
                contentValuesArr[i].put("files_duration", Integer.valueOf(c1596a.m8075g()));
                contentValuesArr[i].put("files_download_state", Integer.valueOf(c1596a.m8071c().ordinal()));
                contentValuesArr[i].put("files_audio_state", Integer.valueOf(c1596a.m8070b().ordinal()));
                contentValuesArr[i].put("files_audio_playing_time", Integer.valueOf(c1596a.m8074f()));
            }
            i++;
        }
        return new C1602g().m8137a(context, contentValuesArr);
    }

    public static C1597b m8102a(Context context, long j) {
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        C1601f b = c1602g.m8142b(context);
        C1597b c1597b = null;
        if (b.moveToFirst()) {
            Uri uri = null;
            if (b.m8130i() != null) {
                uri = Uri.parse(b.m8130i());
            }
            c1597b = new C1597b(b.m8122a(), b.m8124c(), Uri.parse(b.m8123b()), b.m8127f(), b.m8128g(), b.m8126e(), b.m8129h(), b.m8131j(), uri, b.m8133l(), b.m8132k().intValue(), b.m8135n(), b.m8136o(), b.m8134m(), b.m8125d());
        }
        b.close();
        return c1597b;
    }

    public static int m8103b(Context context, long j, int i) {
        C1600e c1600e = new C1600e();
        c1600e.m8115b(i);
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8104b(Context context, long j, C1604i c1604i) {
        C1600e c1600e = new C1600e();
        c1600e.m8117b(c1604i);
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        return c1600e.m8106a(context, c1602g);
    }

    public static int m8105c(Context context, long j, int i) {
        C1600e c1600e = new C1600e();
        c1600e.m8110a(Integer.valueOf(i));
        C1602g c1602g = new C1602g();
        c1602g.m8143b(j);
        return c1600e.m8106a(context, c1602g);
    }
}
