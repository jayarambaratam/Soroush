package android.support.v4.p012b;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.b.t$android.support.v4.b.u;
import android.support.v4.os.C0262c;
import android.support.v4.os.C0268i;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* renamed from: android.support.v4.b.m */
public class C0167m extends C0155a<Cursor> {
    final u f1080f;
    Uri f1081g;
    String[] f1082h;
    String f1083i;
    String[] f1084j;
    String f1085k;
    Cursor f1086l;
    C0262c f1087m;

    public C0167m(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.f1080f = new C0174u(this);
        this.f1081g = uri;
        this.f1082h = strArr;
        this.f1083i = str;
        this.f1084j = strArr2;
        this.f1085k = str2;
    }

    public void m1524a(Cursor cursor) {
        if (!m1472p()) {
            Cursor cursor2 = this.f1086l;
            this.f1086l = cursor;
            if (m1470n()) {
                super.m1462b((Object) cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public /* synthetic */ void m1525a(Object obj) {
        m1527b((Cursor) obj);
    }

    public void m1526a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.m1485a(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.f1081g);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.f1082h));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.f1083i);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.f1084j));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.f1085k);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.f1086l);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.u);
    }

    public void m1527b(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    public /* synthetic */ void m1528b(Object obj) {
        m1524a((Cursor) obj);
    }

    public /* synthetic */ Object m1529d() {
        return m1531h();
    }

    public void m1530f() {
        super.m1491f();
        synchronized (this) {
            if (this.f1087m != null) {
                this.f1087m.m1801c();
            }
        }
    }

    public Cursor m1531h() {
        Cursor a;
        synchronized (this) {
            if (m1492g()) {
                throw new C0268i();
            }
            this.f1087m = new C0262c();
        }
        try {
            a = C0158c.m1514a(m1469m().getContentResolver(), this.f1081g, this.f1082h, this.f1083i, this.f1084j, this.f1085k, this.f1087m);
            if (a != null) {
                a.getCount();
                a.registerContentObserver(this.f1080f);
            }
            synchronized (this) {
                this.f1087m = null;
            }
            return a;
        } catch (RuntimeException e) {
            a.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
            }
            this.f1087m = null;
        }
    }

    protected void m1532i() {
        if (this.f1086l != null) {
            m1524a(this.f1086l);
        }
        if (m1478v() || this.f1086l == null) {
            m1475s();
        }
    }

    protected void m1533j() {
        m1474r();
    }

    protected void m1534k() {
        super.m1467k();
        m1533j();
        if (!(this.f1086l == null || this.f1086l.isClosed())) {
            this.f1086l.close();
        }
        this.f1086l = null;
    }
}
