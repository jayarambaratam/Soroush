package mobi.mmdt.ott.view.conversation.sharedmediaviewer;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.ViewGroup;
import mobi.mmdt.ott.provider.p169c.C1592l;
import mobi.mmdt.ott.provider.p169c.C1594n;
import mobi.mmdt.ott.view.components.p181b.C1712b;
import mobi.mmdt.ott.view.components.p181b.C1722f;
import mobi.mmdt.ott.view.components.p181b.C1786a;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p233a.C2277a;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p233a.C2278b;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p234b.C2281b;
import mobi.mmdt.ott.view.conversation.sharedmediaviewer.p234b.C2282c;
import org.linphone.core.VideoSize;

/* renamed from: mobi.mmdt.ott.view.conversation.sharedmediaviewer.d */
public class C2284d extends C1786a {
    final /* synthetic */ C2279a f7529j;

    public C2284d(C2279a c2279a, Context context) {
        this.f7529j = c2279a;
        super(context);
    }

    public C1712b m10291a(ViewGroup viewGroup, int i) {
        switch (i) {
            case VideoSize.CIF /*1*/:
                return new C2277a(this.f7529j.getActivity(), this.f7529j, m8750a(), viewGroup, this.f7529j.f7516e, this.f7529j.f7517f);
            case VideoSize.HVGA /*2*/:
                return new C2278b(this.f7529j.getActivity(), this.f7529j, m8750a(), viewGroup, this.f7529j.f7516e, this.f7529j.f7517f);
            default:
                return null;
        }
    }

    protected C1722f m10292a(Cursor cursor, int i) {
        boolean z = true;
        String string = cursor.getString(cursor.getColumnIndex("files_thumbnail_uri"));
        String string2 = cursor.getString(cursor.getColumnIndex("files_file_uri"));
        int i2 = cursor.getInt(cursor.getColumnIndex("conversations_event_type"));
        int i3 = cursor.getInt(cursor.getColumnIndex("conversations_direction_type"));
        if (i2 == C1594n.IMAGE.ordinal()) {
            if (i3 != C1592l.IN.ordinal()) {
                z = false;
            }
            return new C2281b(i, string2, string, z);
        } else if (i2 != C1594n.VIDEO.ordinal()) {
            return null;
        } else {
            if (i3 != C1592l.IN.ordinal()) {
                z = false;
            }
            return new C2282c(i, string2, string, z);
        }
    }

    public int getItemViewType(int i) {
        Cursor cursor = (Cursor) m8746b(i);
        int i2 = cursor.getInt(cursor.getColumnIndex("conversations_event_type"));
        return i2 == C1594n.IMAGE.ordinal() ? 1 : i2 == C1594n.VIDEO.ordinal() ? 2 : 1;
    }

    public /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return m10291a(viewGroup, i);
    }
}
