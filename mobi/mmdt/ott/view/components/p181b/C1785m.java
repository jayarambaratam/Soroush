package mobi.mmdt.ott.view.components.p181b;

import android.content.Context;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import mobi.mmdt.ott.view.components.b.m$mobi.mmdt.ott.view.components.b.o;
import net.frakbot.glowpadbackport.BuildConfig;

/* renamed from: mobi.mmdt.ott.view.components.b.m */
public abstract class C1785m<VH extends ViewHolder> extends Adapter<VH> implements Filterable, C1784h {
    protected boolean f5767a;
    protected boolean f5768b;
    protected Cursor f5769c;
    protected Context f5770d;
    protected int f5771e;
    protected o f5772f;
    protected DataSetObserver f5773g;
    protected C1789g f5774h;
    protected FilterQueryProvider f5775i;

    public C1785m(Context context, Cursor cursor, int i) {
        m8743a(context, cursor, i);
    }

    public Cursor m8741a(CharSequence charSequence) {
        return this.f5775i != null ? this.f5775i.runQuery(charSequence) : this.f5769c;
    }

    public CharSequence m8742a(Cursor cursor) {
        return cursor == null ? BuildConfig.FLAVOR : cursor.toString();
    }

    void m8743a(Context context, Cursor cursor, int i) {
        boolean z = true;
        if ((i & 1) == 1) {
            i |= 2;
            this.f5768b = true;
        } else {
            this.f5768b = false;
        }
        if (cursor == null) {
            z = false;
        }
        this.f5769c = cursor;
        this.f5767a = z;
        this.f5770d = context;
        this.f5771e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f5772f = new C1794o(this);
            this.f5773g = new C1795p();
        } else {
            this.f5772f = null;
            this.f5773g = null;
        }
        if (z) {
            if (this.f5772f != null) {
                cursor.registerContentObserver(this.f5772f);
            }
            if (this.f5773g != null) {
                cursor.registerDataSetObserver(this.f5773g);
            }
        }
    }

    public abstract void m8744a(VH vh, Cursor cursor, int i);

    public Cursor m8745b() {
        return this.f5769c;
    }

    public Object m8746b(int i) {
        if (!this.f5767a || this.f5769c == null) {
            return null;
        }
        this.f5769c.moveToPosition(i);
        return this.f5769c;
    }

    public void m8747b(Cursor cursor) {
        Cursor c = m8748c(cursor);
        if (c != null && !c.isClosed()) {
            c.close();
        }
    }

    public Cursor m8748c(Cursor cursor) {
        if (cursor == this.f5769c) {
            return null;
        }
        Cursor cursor2 = this.f5769c;
        if (cursor2 != null) {
            if (this.f5772f != null) {
                cursor2.unregisterContentObserver(this.f5772f);
            }
            if (this.f5773g != null) {
                cursor2.unregisterDataSetObserver(this.f5773g);
            }
        }
        this.f5769c = cursor;
        if (cursor != null) {
            if (this.f5772f != null) {
                cursor.registerContentObserver(this.f5772f);
            }
            if (this.f5773g != null) {
                cursor.registerDataSetObserver(this.f5773g);
            }
            this.f5771e = cursor.getColumnIndexOrThrow("_id");
            this.f5767a = true;
            notifyDataSetChanged();
            return cursor2;
        }
        this.f5771e = -1;
        this.f5767a = false;
        notifyDataSetChanged();
        return cursor2;
    }

    protected void m8749c() {
        if (this.f5768b && this.f5769c != null && !this.f5769c.isClosed()) {
            this.f5767a = this.f5769c.requery();
        }
    }

    public Filter getFilter() {
        if (this.f5774h == null) {
            this.f5774h = new C1789g(this);
        }
        return this.f5774h;
    }

    public int getItemCount() {
        return this.f5769c != null ? this.f5769c.getCount() : 0;
    }

    public long getItemId(int i) {
        return (this.f5767a && this.f5769c != null && this.f5769c.moveToPosition(i)) ? this.f5769c.getLong(this.f5771e) : 0;
    }

    public void onBindViewHolder(VH vh, int i) {
        if (!this.f5767a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f5769c.moveToPosition(i)) {
            m8744a((ViewHolder) vh, this.f5769c, i);
        } else {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
    }

    public void setHasStableIds(boolean z) {
        super.setHasStableIds(true);
    }
}
