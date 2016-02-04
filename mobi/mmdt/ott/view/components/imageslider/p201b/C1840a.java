package mobi.mmdt.ott.view.components.imageslider.p201b;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.p032a.p033a.C0872i;
import com.p032a.p033a.p045h.C0866h;
import java.io.File;

/* renamed from: mobi.mmdt.ott.view.components.imageslider.b.a */
public abstract class C1840a {
    protected Context f5958a;
    protected C1843e f5959b;
    private String f5960c;
    private File f5961d;
    private int f5962e;
    private boolean f5963f;
    private C1838d f5964g;
    private String f5965h;
    private C1844f f5966i;

    protected C1840a(Context context) {
        this.f5966i = C1844f.Fit;
        this.f5958a = context;
    }

    public C1840a m8939a(String str) {
        this.f5965h = str;
        return this;
    }

    public C1840a m8940a(C1843e c1843e) {
        this.f5959b = c1843e;
        return this;
    }

    public C1840a m8941a(C1844f c1844f) {
        this.f5966i = c1844f;
        return this;
    }

    protected void m8942a(View view, ImageView imageView) {
        C0866h c1841b = new C1841b(this, this, view);
        view.setOnClickListener(new C1842c(this, this));
        if (imageView != null) {
            if (this.f5964g != null) {
                this.f5964g.m8927c(this);
            }
            if (this.f5960c != null) {
                C0872i.m5270b(this.f5958a).m5329a(this.f5960c).m4413a(c1841b).m4418b().m4406a(0.25f).m4417a(imageView);
            } else if (this.f5961d != null) {
                C0872i.m5270b(this.f5958a).m5329a(this.f5961d.getAbsolutePath()).m4413a(c1841b).m4418b().m4406a(0.25f).m4417a(imageView);
            } else if (this.f5962e == 0) {
            }
        }
    }

    public void m8943a(C1838d c1838d) {
        this.f5964g = c1838d;
    }

    public boolean m8944a() {
        return this.f5963f;
    }

    public String m8945b() {
        return this.f5965h;
    }

    public C1840a m8946b(String str) {
        if (this.f5961d == null && this.f5962e == 0) {
            this.f5960c = str;
            return this;
        }
        throw new IllegalStateException("Call multi image function,you only have permission to call it once");
    }

    public Context m8947c() {
        return this.f5958a;
    }

    public abstract View m8948d();
}
