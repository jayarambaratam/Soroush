package mobi.mmdt.componentsutils.view.roundavatarimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import mobi.mmdt.componentsutils.C1117d;
import mobi.mmdt.componentsutils.C1122i;

public class RoundAvatarImageView extends ImageView {
    private int f4161a;
    private String f4162b;
    private Bitmap f4163c;
    private Paint f4164d;
    private Paint f4165e;
    private TextPaint f4166f;
    private int f4167g;
    private int f4168h;

    public RoundAvatarImageView(Context context) {
        this(context, null);
    }

    public RoundAvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1117d.RoundAvatarImageViewStyle);
    }

    public RoundAvatarImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4164d = new Paint();
        this.f4164d.setAntiAlias(true);
        this.f4165e = new Paint();
        this.f4165e.setAntiAlias(true);
        this.f4166f = new TextPaint(1);
        this.f4167g = -7829368;
        this.f4168h = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1122i.RoundAvatarImageView, i, 0);
        if (obtainStyledAttributes.getBoolean(C1122i.RoundAvatarImageView_border, true)) {
            setName(obtainStyledAttributes.getString(C1122i.RoundAvatarImageView_name));
            setBackgroundColor(obtainStyledAttributes.getColor(C1122i.RoundAvatarImageView_background_color, -1));
            setTextColor(obtainStyledAttributes.getColor(C1122i.RoundAvatarImageView_text_color, -7829368));
        }
    }

    private float m6440a(int i, int i2, String str, TextPaint textPaint) {
        float textSize = textPaint.getTextSize();
        if (str.length() == 0) {
            return textSize;
        }
        Rect rect = new Rect();
        textPaint.getTextBounds(str, 0, str.length(), rect);
        float width = ((float) i) / ((float) rect.width());
        float height = ((float) i2) / ((float) rect.height());
        if (height >= width) {
            height = width;
        }
        return height * textSize;
    }

    private int m6441a(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        return (mode == 1073741824 || mode == RtlSpacingHelper.UNDEFINED) ? size : this.f4161a;
    }

    public static String m6442a(String str) {
        String str2 = "?";
        return (str == null || str.trim().isEmpty()) ? str2 : str.trim().substring(0, 1).toUpperCase();
    }

    private int m6443b(int i) {
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        if (!(mode == 1073741824 || mode == RtlSpacingHelper.UNDEFINED)) {
            size = this.f4161a;
        }
        return size + 2;
    }

    public Bitmap m6444a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public void onDraw(Canvas canvas) {
        this.f4163c = m6444a(getDrawable());
        this.f4161a = canvas.getWidth();
        if (canvas.getHeight() < this.f4161a) {
            this.f4161a = canvas.getHeight();
        }
        int i = this.f4161a / 2;
        this.f4165e.setColor(this.f4168h);
        canvas.drawCircle((float) i, (float) i, (float) (this.f4161a / 2), this.f4165e);
        if (this.f4163c != null) {
            this.f4164d.setShader(new BitmapShader(Bitmap.createScaledBitmap(this.f4163c, this.f4161a, this.f4161a, false), TileMode.CLAMP, TileMode.CLAMP));
            canvas.drawCircle((float) i, (float) i, (float) (this.f4161a / 2), this.f4164d);
            return;
        }
        String a = m6442a(this.f4162b);
        this.f4166f.setColor(this.f4167g);
        Rect rect = new Rect();
        this.f4166f.setTextSize(m6440a(this.f4161a / 3, this.f4161a / 3, a, this.f4166f));
        this.f4166f.getTextBounds(a, 0, a.length(), rect);
        canvas.drawText(a, (float) (i - rect.centerX()), (float) (i + (rect.height() / 2)), this.f4166f);
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(m6441a(i), m6443b(i2));
    }

    public void setBackgroundColor(int i) {
        this.f4168h = i;
        requestLayout();
        invalidate();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
    }

    public void setName(String str) {
        this.f4162b = str;
        setTextColor(-1);
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i) {
        this.f4167g = i;
        requestLayout();
        invalidate();
    }
}
