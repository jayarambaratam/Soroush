package mobi.mmdt.ott.logic.notifications.notifsData;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.Loader.OnLoadCompleteListener;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.IBinder;
import mobi.mmdt.ott.MyApplication;
import mobi.mmdt.ott.logic.C1494c;
import mobi.mmdt.ott.logic.notifications.C1556c;
import mobi.mmdt.ott.logic.notifications.C1557d;
import mobi.mmdt.ott.logic.p112a.p135f.p136a.C1424d;
import mobi.mmdt.ott.logic.p157e.p159b.C1512c;
import mobi.mmdt.ott.provider.p168b.C1573b;
import mobi.mmdt.ott.provider.p169c.C1583c;
import mobi.mmdt.ott.provider.p169c.C1590j;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.provider.p169c.C1595o;
import mobi.mmdt.ott.provider.p173g.C1622c;
import mobi.mmdt.ott.view.p178a.ah;
import net.frakbot.glowpadbackport.BuildConfig;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class NewUpdateNotificationService extends Service implements OnLoadCompleteListener<Cursor> {
    private C1590j f5228a;
    private int f5229b;
    private Context f5230c;

    private String m7855a(C1594n c1594n, String str) {
        switch (C1563e.f5241a[c1594n.ordinal()]) {
            case VideoSize.CIF /*1*/:
            case VideoSize.HVGA /*2*/:
                return str;
            case Version.API03_CUPCAKE_15 /*3*/:
                return this.f5230c.getString(2131230933);
            case Version.API04_DONUT_16 /*4*/:
                return this.f5230c.getString(2131230930);
            case Version.API05_ECLAIR_20 /*5*/:
                return this.f5230c.getString(2131230934);
            case Version.API06_ECLAIR_201 /*6*/:
                return this.f5230c.getString(2131230929);
            case Version.API07_ECLAIR_21 /*7*/:
                return this.f5230c.getString(2131230932);
            default:
                return BuildConfig.FLAVOR;
        }
    }

    private C1559b m7856a(Cursor cursor) {
        C1559b c1559b = null;
        try {
            cursor.moveToFirst();
            if (cursor.moveToFirst()) {
                do {
                    String string = cursor.getString(cursor.getColumnIndex("conversations_party"));
                    C1594n c1594n = C1594n.values()[cursor.getInt(cursor.getColumnIndex("conversations_event_type"))];
                    C1595o c1595o = C1595o.values()[cursor.getInt(cursor.getColumnIndex("conversations_group_type"))];
                    String string2 = cursor.getString(cursor.getColumnIndex("members_local_name"));
                    String string3 = cursor.getString(cursor.getColumnIndex("members_local_phone_number"));
                    String string4 = cursor.getString(cursor.getColumnIndex("conversations_peer_user_id"));
                    String string5 = cursor.getString(cursor.getColumnIndex("members_nick_name"));
                    String string6 = cursor.getString(cursor.getColumnIndex("members_avatar_thumbnail_url"));
                    String string7 = cursor.getString(cursor.getColumnIndex("conversations_event"));
                    String string8 = cursor.getString(cursor.getColumnIndex("PrivateGroups_name"));
                    String string9 = cursor.getString(cursor.getColumnIndex("CHANNELS_name"));
                    boolean z = cursor.getInt(cursor.getColumnIndex("PrivateGroups_is_mute")) != 0;
                    boolean z2 = cursor.getInt(cursor.getColumnIndex("CHANNELS_is_mute")) != 0;
                    String a;
                    C1559b c1565g;
                    C1565g c1565g2;
                    C1559b c1560a;
                    C1562d c1562d;
                    C1561c c1561c;
                    if (c1595o == C1595o.SINGLE) {
                        a = ah.m8469a(string2, string3);
                        if (a == null) {
                            a = ah.m8470b(string5, string4);
                        }
                        c1565g = new C1565g(string, a, string6, false);
                        c1565g.m7877a(m7855a(c1594n, string7));
                        if (c1559b == null) {
                            c1559b = c1565g;
                        } else if (c1559b instanceof C1565g) {
                            c1565g2 = (C1565g) c1559b;
                            if (c1565g2.m7876a().equals(string)) {
                                c1565g2.m7877a(m7855a(c1594n, string7));
                            } else {
                                c1560a = new C1560a(null);
                                c1560a.m7861a(c1565g2.m7876a(), c1565g2);
                                c1560a.m7861a(string, c1565g);
                                c1559b = c1560a;
                            }
                        } else if (c1559b instanceof C1562d) {
                            c1562d = (C1562d) c1559b;
                            c1560a = new C1560a(null);
                            c1560a.m7861a(c1562d.m7871c(), c1562d);
                            c1560a.m7861a(string, c1565g);
                            c1559b = c1560a;
                        } else if (c1559b instanceof C1561c) {
                            c1561c = (C1561c) c1559b;
                            c1560a = new C1560a(null);
                            c1560a.m7861a(c1561c.m7865c(), c1561c);
                            c1560a.m7861a(string, c1565g);
                            c1559b = c1560a;
                        } else {
                            ((C1560a) c1559b).m7861a(string, c1565g);
                        }
                    } else if (c1595o == C1595o.CHANNEL) {
                        a = cursor.getString(cursor.getColumnIndex("CHANNELS_avatar_thumbnail_url"));
                        r7 = ah.m8470b(string5, string4);
                        if (C1573b.m7922a(this.f5230c, string) == null || !C1573b.m7922a(this.f5230c, string).m7919a()) {
                            c1565g = new C1561c(string, string9, a, z2);
                            c1565g.m7862a(r7, m7855a(c1594n, string7));
                            if (c1559b == null) {
                                c1559b = c1565g;
                            } else if (c1559b instanceof C1565g) {
                                c1565g2 = (C1565g) c1559b;
                                c1560a = new C1560a(null);
                                c1560a.m7861a(c1565g2.m7876a(), c1565g2);
                                c1560a.m7861a(string, c1565g);
                                c1559b = c1560a;
                            } else if (c1559b instanceof C1562d) {
                                c1562d = (C1562d) c1559b;
                                c1560a = new C1560a(null);
                                c1560a.m7861a(c1562d.m7871c(), c1562d);
                                c1560a.m7861a(string, c1565g);
                                c1559b = c1560a;
                            } else if (c1559b instanceof C1561c) {
                                c1561c = (C1561c) c1559b;
                                if (c1561c.m7865c().equals(string)) {
                                    c1561c.m7862a(r7, m7855a(c1594n, string7));
                                } else {
                                    c1560a = new C1560a(null);
                                    c1560a.m7861a(c1561c.m7865c(), c1561c);
                                    c1560a.m7861a(string, c1565g);
                                    c1559b = c1560a;
                                }
                            } else {
                                ((C1560a) c1559b).m7861a(string, c1565g);
                            }
                        }
                    } else if (c1595o == C1595o.GROUP) {
                        String string10 = cursor.getString(cursor.getColumnIndex("PrivateGroups_thumbnail_url"));
                        r7 = ah.m8470b(string5, string4);
                        if (!(C1622c.m8255b(this.f5230c, string) == null || C1622c.m8255b(this.f5230c, string).m8250c())) {
                            c1565g = new C1562d(string, string8, string10, z);
                            c1565g.m7868a(r7, m7855a(c1594n, string7));
                            if (c1559b == null) {
                                c1559b = c1565g;
                            } else if (c1559b instanceof C1565g) {
                                c1565g2 = (C1565g) c1559b;
                                c1560a = new C1560a(null);
                                c1560a.m7861a(c1565g2.m7876a(), c1565g2);
                                c1560a.m7861a(string, c1565g);
                                c1559b = c1560a;
                            } else if (c1559b instanceof C1562d) {
                                c1562d = (C1562d) c1559b;
                                if (c1562d.m7871c().equals(string)) {
                                    c1562d.m7868a(r7, m7855a(c1594n, string7));
                                } else {
                                    c1560a = new C1560a(null);
                                    c1560a.m7861a(c1562d.m7871c(), c1562d);
                                    c1560a.m7861a(string, c1565g);
                                    c1559b = c1560a;
                                }
                            } else if (c1559b instanceof C1561c) {
                                c1561c = (C1561c) c1559b;
                                c1560a = new C1560a(null);
                                c1560a.m7861a(c1561c.m7865c(), c1561c);
                                c1560a.m7861a(string, c1565g);
                                c1559b = c1560a;
                            } else {
                                ((C1560a) c1559b).m7861a(string, c1565g);
                            }
                        }
                    }
                } while (cursor.moveToNext());
                cursor.close();
            }
            if (c1559b != null) {
                return c1559b;
            }
            C1557d.m7850a(this.f5230c);
            MyApplication.m6445a().m6453a(0);
            return c1559b;
        } catch (Exception e) {
            return null;
        }
    }

    public void m7857a(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && this.f5229b != cursor.getCount()) {
            this.f5229b = cursor.getCount();
            C1556c.m7849a(this.f5230c, cursor.getCount());
            if (cursor.getCount() == 0) {
                C1512c.m7630a(0);
                C1512c.m7634b(0);
                MyApplication.m6445a().m6453a(0);
                C1557d.m7850a(getApplicationContext());
                return;
            }
            C1494c.m7539a(new C1424d(getApplicationContext(), m7856a(cursor)));
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        this.f5230c = getApplicationContext();
        this.f5228a = C1583c.m7996g(this.f5230c);
        this.f5228a.registerListener(2513, this);
        this.f5228a.startLoading();
    }

    public void onDestroy() {
        if (this.f5228a != null) {
            this.f5228a.unregisterListener(this);
            if (VERSION.SDK_INT >= 16) {
                this.f5228a.cancelLoad();
            }
            this.f5228a.stopLoading();
        }
        super.onDestroy();
    }

    public /* synthetic */ void onLoadComplete(Loader loader, Object obj) {
        m7857a(loader, (Cursor) obj);
    }
}
