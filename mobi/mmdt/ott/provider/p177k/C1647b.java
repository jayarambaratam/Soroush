package mobi.mmdt.ott.provider.p177k;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;

/* renamed from: mobi.mmdt.ott.provider.k.b */
public class C1647b {
    public static CursorLoader m8381a(Context context, String str) {
        return new CursorLoader(context, C1648c.f5460a, new String[]{"_id", "userinchatstates_party", "userinchatstates_sender", "userinchatstates_state"}, "userinchatstates_party =? ", new String[]{str}, null);
    }

    public static CursorLoader m8382a(Context context, String str, String str2) {
        String str3 = "SELECT userinchatstates._id , userinchatstates.userinchatstates_party , userinchatstates.userinchatstates_sender , userinchatstates.userinchatstates_state , members.members_user_id , members.members_nick_name FROM userinchatstates , members WHERE userinchatstates.userinchatstates_sender = members.members_user_id AND userinchatstates.userinchatstates_party = '" + str + "' AND " + "userinchatstates" + "." + "userinchatstates_sender" + " <> '" + str2 + "'";
        return new C1646a(context, C1648c.f5460a, str3, C1648c.f5460a);
    }

    public static Uri m8383a(Context context, String str, String str2, C1652g c1652g) {
        if (str == null || str2 == null || c1652g == null) {
            throw new NullPointerException();
        }
        C1649d c1649d = new C1649d();
        c1649d.m8390b(str).m8388a(str2).m8389a(c1652g);
        return c1649d.m7897a(context);
    }

    public static int m8384b(Context context, String str, String str2, C1652g c1652g) {
        C1649d c1649d = new C1649d();
        c1649d.m8389a(c1652g);
        c1649d.m8388a(str2);
        C1651f c1651f = new C1651f();
        c1651f.m8393a(str);
        return c1649d.m8386a(context, c1651f);
    }

    public static boolean m8385b(Context context, String str) {
        boolean z = true;
        C1651f c1651f = new C1651f();
        c1651f.m8393a(str);
        C1650e b = c1651f.m8394b(context);
        if (b.getCount() == 0) {
            z = false;
        }
        b.close();
        return z;
    }
}
