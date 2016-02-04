package mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import mobi.mmdt.ott.C1317h;

public class EmojiconTextView extends TextView {
    private int f7276a;
    private int f7277b;
    private int f7278c;
    private int f7279d;
    private int f7280e;
    private boolean f7281f;

    public EmojiconTextView(Context context) {
        super(context);
        this.f7279d = 0;
        this.f7280e = -1;
        this.f7281f = false;
        m10077a(null);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7279d = 0;
        this.f7280e = -1;
        this.f7281f = false;
        m10077a(attributeSet);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7279d = 0;
        this.f7280e = -1;
        this.f7281f = false;
        m10077a(attributeSet);
    }

    private void m10077a(AttributeSet attributeSet) {
        this.f7278c = (int) getTextSize();
        if (attributeSet == null) {
            this.f7276a = (int) getTextSize();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1317h.Emojicon);
            this.f7276a = (int) obtainStyledAttributes.getDimension(0, getTextSize());
            this.f7277b = obtainStyledAttributes.getInt(1, 1);
            this.f7279d = obtainStyledAttributes.getInteger(2, 0);
            this.f7280e = obtainStyledAttributes.getInteger(3, -1);
            this.f7281f = obtainStyledAttributes.getBoolean(4, false);
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    public void setEmojiconSize(int i) {
        this.f7276a = i;
        super.setText(getText());
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        CharSequence charSequence2;
        if (TextUtils.isEmpty(charSequence)) {
            charSequence2 = charSequence;
        } else {
            charSequence2 = new SpannableStringBuilder(charSequence);
            C2209b.m10079a(getContext(), charSequence2, this.f7276a, this.f7277b, this.f7278c, this.f7279d, this.f7280e, this.f7281f);
        }
        super.setText(charSequence2, bufferType);
    }

    public void setUseSystemDefault(boolean z) {
        this.f7281f = z;
    }
}
