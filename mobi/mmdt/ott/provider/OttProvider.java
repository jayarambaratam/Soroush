package mobi.mmdt.ott.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import java.util.Arrays;
import mobi.mmdt.componentsutils.p079a.p080a.C1104b;
import mobi.mmdt.ott.C1317h;
import mobi.mmdt.ott.provider.p167a.C1566d;
import mobi.mmdt.ott.provider.p167a.C1570e;
import org.linphone.core.VideoSize;
import org.linphone.mediastream.Version;

public class OttProvider extends C1566d {
    private static final UriMatcher f5249b;

    static {
        f5249b = new UriMatcher(-1);
        f5249b.addURI("mobi.mmdt.ott.provider", "blockedusers", 0);
        f5249b.addURI("mobi.mmdt.ott.provider", "blockedusers/#", 1);
        f5249b.addURI("mobi.mmdt.ott.provider", "conversations", 2);
        f5249b.addURI("mobi.mmdt.ott.provider", "conversations/#", 3);
        f5249b.addURI("mobi.mmdt.ott.provider", "files", 4);
        f5249b.addURI("mobi.mmdt.ott.provider", "files/#", 5);
        f5249b.addURI("mobi.mmdt.ott.provider", "PrivateGroups", 6);
        f5249b.addURI("mobi.mmdt.ott.provider", "PrivateGroups/#", 7);
        f5249b.addURI("mobi.mmdt.ott.provider", "CHANNELS", 22);
        f5249b.addURI("mobi.mmdt.ott.provider", "CHANNELS/#", 23);
        f5249b.addURI("mobi.mmdt.ott.provider", "members", 8);
        f5249b.addURI("mobi.mmdt.ott.provider", "members/#", 9);
        f5249b.addURI("mobi.mmdt.ott.provider", "members_group", 10);
        f5249b.addURI("mobi.mmdt.ott.provider", "members_group/#", 11);
        f5249b.addURI("mobi.mmdt.ott.provider", "stickers", 12);
        f5249b.addURI("mobi.mmdt.ott.provider", "stickers/#", 13);
        f5249b.addURI("mobi.mmdt.ott.provider", "stickerspackage", 14);
        f5249b.addURI("mobi.mmdt.ott.provider", "stickerspackage/#", 15);
        f5249b.addURI("mobi.mmdt.ott.provider", "syncedcontacts", 16);
        f5249b.addURI("mobi.mmdt.ott.provider", "syncedcontacts/#", 17);
        f5249b.addURI("mobi.mmdt.ott.provider", "userinchatstates", 18);
        f5249b.addURI("mobi.mmdt.ott.provider", "userinchatstates/#", 19);
        f5249b.addURI("mobi.mmdt.ott.provider", "recentemoji", 20);
        f5249b.addURI("mobi.mmdt.ott.provider", "recentemoji/#", 21);
    }

    public Cursor m7891a(Uri uri, String str) {
        C1104b.m6370d(this, "rawQuery uri=" + uri + "   " + str);
        return super.m7886a(uri, str);
    }

    protected SQLiteOpenHelper m7892a() {
        return C1606d.m8145a(getContext());
    }

    protected C1570e m7893a(Uri uri, String str, String[] strArr) {
        C1570e c1570e = new C1570e();
        String str2 = null;
        int match = f5249b.match(uri);
        switch (match) {
            case VideoSize.QCIF /*0*/:
            case VideoSize.CIF /*1*/:
                c1570e.f5259a = "blockedusers";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "blockedusers";
                c1570e.f5263e = "blockedusers._id";
                break;
            case VideoSize.HVGA /*2*/:
            case Version.API03_CUPCAKE_15 /*3*/:
                c1570e.f5259a = "conversations";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "conversations";
                c1570e.f5263e = "conversations._id";
                break;
            case Version.API04_DONUT_16 /*4*/:
            case Version.API05_ECLAIR_20 /*5*/:
                c1570e.f5259a = "files";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "files";
                c1570e.f5263e = "files._id";
                break;
            case Version.API06_ECLAIR_201 /*6*/:
            case Version.API07_ECLAIR_21 /*7*/:
                c1570e.f5259a = "PrivateGroups";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "PrivateGroups";
                c1570e.f5263e = "PrivateGroups._id";
                break;
            case Version.API08_FROYO_22 /*8*/:
            case Version.API09_GINGERBREAD_23 /*9*/:
                c1570e.f5259a = "members";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "members";
                c1570e.f5263e = "members._id";
                break;
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
            case Version.API11_HONEYCOMB_30 /*11*/:
                c1570e.f5259a = "members_group";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "members_group";
                c1570e.f5263e = "members_group._id";
                break;
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                c1570e.f5259a = "stickers";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "stickers";
                c1570e.f5263e = "stickers._id";
                break;
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                c1570e.f5259a = "stickerspackage";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "stickerspackage";
                c1570e.f5263e = "stickerspackage._id";
                break;
            case Version.API16_JELLY_BEAN_41 /*16*/:
            case Version.API17_JELLY_BEAN_42 /*17*/:
                c1570e.f5259a = "syncedcontacts";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "syncedcontacts";
                c1570e.f5263e = "syncedcontacts._id";
                break;
            case Version.API18_JELLY_BEAN_43 /*18*/:
            case Version.API19_KITKAT_44 /*19*/:
                c1570e.f5259a = "userinchatstates";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "userinchatstates";
                c1570e.f5263e = "userinchatstates._id";
                break;
            case C1317h.Toolbar_navigationIcon /*20*/:
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                c1570e.f5259a = "recentemoji";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "recentemoji";
                c1570e.f5263e = "recentemoji._id";
                break;
            case C1317h.Toolbar_logoDescription /*22*/:
            case C1317h.Toolbar_titleTextColor /*23*/:
                c1570e.f5259a = "CHANNELS";
                c1570e.f5261c = "_id";
                c1570e.f5260b = "CHANNELS";
                c1570e.f5263e = "CHANNELS._id";
                break;
            default:
                throw new IllegalArgumentException("The uri '" + uri + "' is not supported by this ContentProvider");
        }
        switch (match) {
            case VideoSize.CIF /*1*/:
            case Version.API03_CUPCAKE_15 /*3*/:
            case Version.API05_ECLAIR_20 /*5*/:
            case Version.API07_ECLAIR_21 /*7*/:
            case Version.API09_GINGERBREAD_23 /*9*/:
            case Version.API11_HONEYCOMB_30 /*11*/:
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
            case Version.API17_JELLY_BEAN_42 /*17*/:
            case Version.API19_KITKAT_44 /*19*/:
            case C1317h.Toolbar_navigationContentDescription /*21*/:
            case C1317h.Toolbar_titleTextColor /*23*/:
                str2 = uri.getLastPathSegment();
                break;
        }
        if (str2 == null) {
            c1570e.f5262d = str;
        } else if (str != null) {
            c1570e.f5262d = c1570e.f5259a + "." + c1570e.f5261c + "=" + str2 + " and (" + str + ")";
        } else {
            c1570e.f5262d = c1570e.f5259a + "." + c1570e.f5261c + "=" + str2;
        }
        return c1570e;
    }

    public void m7894b(Uri uri, String str) {
        C1104b.m6370d(this, "rawUpdate uri=" + uri + "   " + str);
        super.m7889b(uri, str);
    }

    protected boolean m7895b() {
        return false;
    }

    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        C1104b.m6370d(this, "bulkInsert uri=" + uri + " values.length=" + contentValuesArr.length);
        return super.bulkInsert(uri, contentValuesArr);
    }

    public int delete(Uri uri, String str, String[] strArr) {
        C1104b.m6370d(this, "delete uri=" + uri + " selection=" + str + " selectionArgs=" + Arrays.toString(strArr));
        return super.delete(uri, str, strArr);
    }

    public String getType(Uri uri) {
        switch (f5249b.match(uri)) {
            case VideoSize.QCIF /*0*/:
                return "vnd.android.cursor.dir/blockedusers";
            case VideoSize.CIF /*1*/:
                return "vnd.android.cursor.item/blockedusers";
            case VideoSize.HVGA /*2*/:
                return "vnd.android.cursor.dir/conversations";
            case Version.API03_CUPCAKE_15 /*3*/:
                return "vnd.android.cursor.item/conversations";
            case Version.API04_DONUT_16 /*4*/:
                return "vnd.android.cursor.dir/files";
            case Version.API05_ECLAIR_20 /*5*/:
                return "vnd.android.cursor.item/files";
            case Version.API06_ECLAIR_201 /*6*/:
                return "vnd.android.cursor.dir/PrivateGroups";
            case Version.API07_ECLAIR_21 /*7*/:
                return "vnd.android.cursor.item/PrivateGroups";
            case Version.API08_FROYO_22 /*8*/:
                return "vnd.android.cursor.dir/members";
            case Version.API09_GINGERBREAD_23 /*9*/:
                return "vnd.android.cursor.item/members";
            case Version.API10_GINGERBREAD_MR1_233 /*10*/:
                return "vnd.android.cursor.dir/members_group";
            case Version.API11_HONEYCOMB_30 /*11*/:
                return "vnd.android.cursor.item/members_group";
            case Version.API12_HONEYCOMB_MR1_31X /*12*/:
                return "vnd.android.cursor.dir/stickers";
            case Version.API13_HONEYCOMB_MR2_32 /*13*/:
                return "vnd.android.cursor.item/stickers";
            case Version.API14_ICE_CREAM_SANDWICH_40 /*14*/:
                return "vnd.android.cursor.dir/stickerspackage";
            case Version.API15_ICE_CREAM_SANDWICH_403 /*15*/:
                return "vnd.android.cursor.item/stickerspackage";
            case Version.API16_JELLY_BEAN_41 /*16*/:
                return "vnd.android.cursor.dir/syncedcontacts";
            case Version.API17_JELLY_BEAN_42 /*17*/:
                return "vnd.android.cursor.item/syncedcontacts";
            case Version.API18_JELLY_BEAN_43 /*18*/:
                return "vnd.android.cursor.dir/userinchatstates";
            case Version.API19_KITKAT_44 /*19*/:
                return "vnd.android.cursor.item/userinchatstates";
            case C1317h.Toolbar_navigationIcon /*20*/:
                return "vnd.android.cursor.dir/recentemoji";
            case C1317h.Toolbar_navigationContentDescription /*21*/:
                return "vnd.android.cursor.item/recentemoji";
            case C1317h.Toolbar_logoDescription /*22*/:
                return "vnd.android.cursor.dir/CHANNELS";
            case C1317h.Toolbar_titleTextColor /*23*/:
                return "vnd.android.cursor.item/CHANNELS";
            default:
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        C1104b.m6370d(this, "insert uri=" + uri + " values=" + contentValues);
        return super.insert(uri, contentValues);
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        C1104b.m6370d(this, "query uri=" + uri + " selection=" + str + " selectionArgs=" + Arrays.toString(strArr2) + " sortOrder=" + str2 + " groupBy=" + uri.getQueryParameter("QUERY_GROUP_BY") + " having=" + uri.getQueryParameter("QUERY_HAVING") + " limit=" + uri.getQueryParameter("QUERY_LIMIT"));
        return super.query(uri, strArr, str, strArr2, str2);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        C1104b.m6370d(this, "update uri=" + uri + " values=" + contentValues + " selection=" + str + " selectionArgs=" + Arrays.toString(strArr));
        return super.update(uri, contentValues, str, strArr);
    }
}
