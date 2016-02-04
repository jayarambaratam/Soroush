package com.felipecsl.asymmetricgridview.library.widget;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.ViewTreeObserver;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.WrapperListAdapter;
import com.felipecsl.asymmetricgridview.library.C1040a;
import com.felipecsl.asymmetricgridview.library.C1054o;

public class AsymmetricGridView extends ListView {
    protected int f3957a;
    protected int f3958b;
    protected int f3959c;
    protected int f3960d;
    protected boolean f3961e;
    protected boolean f3962f;
    protected C1040a f3963g;
    protected OnItemClickListener f3964h;
    protected OnItemLongClickListener f3965i;

    public class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR;
        int f3947a;
        int f3948b;
        int f3949c;
        int f3950d;
        int f3951e;
        int f3952f;
        boolean f3953g;
        boolean f3954h;
        Parcelable f3955i;
        ClassLoader f3956j;

        static {
            CREATOR = new C1057c();
        }

        SavedState(Parcel parcel) {
            boolean z = true;
            super(parcel);
            this.f3947a = parcel.readInt();
            this.f3948b = parcel.readInt();
            this.f3949c = parcel.readInt();
            this.f3950d = parcel.readInt();
            this.f3951e = parcel.readInt();
            this.f3952f = parcel.readInt();
            this.f3953g = parcel.readByte() == (byte) 1;
            if (parcel.readByte() != (byte) 1) {
                z = false;
            }
            this.f3954h = z;
            this.f3955i = parcel.readParcelable(this.f3956j);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f3947a);
            parcel.writeInt(this.f3948b);
            parcel.writeInt(this.f3949c);
            parcel.writeInt(this.f3950d);
            parcel.writeInt(this.f3951e);
            parcel.writeInt(this.f3952f);
            parcel.writeByte((byte) (this.f3953g ? 1 : 0));
            if (!this.f3954h) {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            parcel.writeParcelable(this.f3955i, i);
        }
    }

    public AsymmetricGridView(Context context) {
        super(context);
        this.f3957a = 2;
        setSelector(17170445);
        this.f3958b = C1054o.m6245a(context, 5.0f);
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new C1056b(this));
        }
    }

    public int m6247a() {
        int availableSpace = this.f3959c > 0 ? (getAvailableSpace() + this.f3958b) / (this.f3959c + this.f3958b) : this.f3960d > 0 ? this.f3960d : 2;
        if (availableSpace <= 0) {
            availableSpace = 1;
        }
        this.f3957a = availableSpace;
        return availableSpace;
    }

    protected void m6248a(int i, View view) {
        if (this.f3964h != null) {
            this.f3964h.onItemClick(this, view, i, (long) view.getId());
        }
    }

    public boolean m6249b() {
        return this.f3961e;
    }

    protected boolean m6250b(int i, View view) {
        if (this.f3965i != null) {
            if (this.f3965i.onItemLongClick(this, view, i, (long) view.getId())) {
                return true;
            }
        }
        return false;
    }

    public boolean m6251c() {
        return this.f3962f;
    }

    public int getAvailableSpace() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public int getColumnWidth() {
        return (getAvailableSpace() - ((this.f3957a - 1) * this.f3958b)) / this.f3957a;
    }

    public int getNumColumns() {
        return this.f3957a;
    }

    public int getRequestedHorizontalSpacing() {
        return this.f3958b;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m6247a();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f3961e = savedState.f3954h;
            this.f3962f = savedState.f3953g;
            this.f3957a = savedState.f3947a;
            this.f3960d = savedState.f3949c;
            this.f3959c = savedState.f3948b;
            this.f3958b = savedState.f3951e;
            if (this.f3963g != null) {
                this.f3963g.m6222a(savedState.f3955i);
            }
            setSelectionFromTop(20, 0);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3954h = this.f3961e;
        savedState.f3953g = this.f3962f;
        savedState.f3947a = this.f3957a;
        savedState.f3949c = this.f3960d;
        savedState.f3948b = this.f3959c;
        savedState.f3951e = this.f3958b;
        if (this.f3963g != null) {
            savedState.f3955i = this.f3963g.m6223b();
        }
        return savedState;
    }

    public void setAdapter(ListAdapter listAdapter) {
        ListAdapter wrappedAdapter;
        if (listAdapter instanceof WrapperListAdapter) {
            wrappedAdapter = ((WrapperListAdapter) listAdapter).getWrappedAdapter();
            if (!(wrappedAdapter instanceof C1040a)) {
                throw new UnsupportedOperationException("Wrapped adapter must implement AsymmetricGridViewAdapterContract");
            }
        } else if (listAdapter instanceof C1040a) {
            wrappedAdapter = listAdapter;
        } else {
            throw new UnsupportedOperationException("Adapter must implement AsymmetricGridViewAdapterContract");
        }
        this.f3963g = (C1040a) wrappedAdapter;
        super.setAdapter(wrappedAdapter);
        this.f3963g.m6221a();
    }

    public void setAllowReordering(boolean z) {
        this.f3961e = z;
        if (this.f3963g != null) {
            this.f3963g.m6221a();
        }
    }

    public void setDebugging(boolean z) {
        this.f3962f = z;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.f3964h = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.f3965i = onItemLongClickListener;
    }

    public void setRequestedColumnCount(int i) {
        this.f3960d = i;
    }

    public void setRequestedColumnWidth(int i) {
        this.f3959c = i;
    }

    public void setRequestedHorizontalSpacing(int i) {
        this.f3958b = i;
    }
}
