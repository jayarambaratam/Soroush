package com.cocosw.bottomsheet;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

class PinnedSectionGridView extends GridView {
    private int f3743a;
    private int f3744b;
    private int f3745c;
    private int f3746d;

    public PinnedSectionGridView(Context context) {
        super(context);
    }

    public PinnedSectionGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PinnedSectionGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public int m6056a() {
        return this.f3746d != 0 ? this.f3746d : getWidth();
    }

    public int getColumnWidth() {
        return this.f3745c;
    }

    public int getHorizontalSpacing() {
        return this.f3744b;
    }

    public int getNumColumns() {
        return this.f3743a;
    }

    public void setColumnWidth(int i) {
        this.f3745c = i;
        super.setColumnWidth(i);
    }

    public void setHorizontalSpacing(int i) {
        this.f3744b = i;
        super.setHorizontalSpacing(i);
    }

    public void setNumColumns(int i) {
        this.f3743a = i;
        super.setNumColumns(i);
    }
}
