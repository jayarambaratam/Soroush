package mobi.mmdt.ott.view.components.mediaselector;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;

/* renamed from: mobi.mmdt.ott.view.components.mediaselector.a */
public class C1893a extends ItemDecoration {
    private int f6080a;
    private int f6081b;
    private boolean f6082c;

    public C1893a(int i, int i2) {
        this.f6082c = false;
        this.f6080a = i;
        this.f6081b = i2;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, State state) {
        int width = (recyclerView.getWidth() / this.f6081b) - ((int) ((((float) recyclerView.getWidth()) - (((float) this.f6080a) * ((float) (this.f6081b - 1)))) / ((float) this.f6081b)));
        int viewAdapterPosition = ((LayoutParams) view.getLayoutParams()).getViewAdapterPosition();
        if (viewAdapterPosition < this.f6081b) {
            rect.top = 0;
        } else {
            rect.top = this.f6080a;
        }
        if (viewAdapterPosition % this.f6081b == 0) {
            rect.left = 0;
            rect.right = width;
            this.f6082c = true;
        } else if ((viewAdapterPosition + 1) % this.f6081b == 0) {
            this.f6082c = false;
            rect.right = 0;
            rect.left = width;
        } else if (this.f6082c) {
            this.f6082c = false;
            rect.left = this.f6080a - width;
            if ((viewAdapterPosition + 2) % this.f6081b == 0) {
                rect.right = this.f6080a - width;
            } else {
                rect.right = this.f6080a / 2;
            }
        } else if ((viewAdapterPosition + 2) % this.f6081b == 0) {
            this.f6082c = false;
            rect.left = this.f6080a / 2;
            rect.right = this.f6080a - width;
        } else {
            this.f6082c = false;
            rect.left = this.f6080a / 2;
            rect.right = this.f6080a / 2;
        }
        rect.bottom = 0;
    }
}
