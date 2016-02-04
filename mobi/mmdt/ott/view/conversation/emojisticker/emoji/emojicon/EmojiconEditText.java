package mobi.mmdt.ott.view.conversation.emojisticker.emoji.emojicon;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import mobi.mmdt.ott.C1317h;

public class EmojiconEditText extends EditText {
    private int f7271a;
    private int f7272b;
    private int f7273c;
    private boolean f7274d;
    private C2136a f7275e;

    public EmojiconEditText(Context context) {
        super(context);
        this.f7274d = false;
        this.f7271a = (int) getTextSize();
        this.f7273c = (int) getTextSize();
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7274d = false;
        m10076a(attributeSet);
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7274d = false;
        m10076a(attributeSet);
    }

    private void m10075a() {
        C2209b.m10080a(getContext(), getText(), this.f7271a, this.f7272b, this.f7273c, this.f7274d);
    }

    private void m10076a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1317h.Emojicon);
        this.f7271a = (int) obtainStyledAttributes.getDimension(0, getTextSize());
        this.f7272b = obtainStyledAttributes.getInt(1, 1);
        this.f7274d = obtainStyledAttributes.getBoolean(4, false);
        obtainStyledAttributes.recycle();
        this.f7273c = (int) getTextSize();
        setText(getText());
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (this.f7275e != null) {
            this.f7275e.m9797g();
        }
        return false;
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m10075a();
    }

    public void setEmojiconSize(int i) {
        this.f7271a = i;
        m10075a();
    }

    public void setOnImeBackListener(C2136a c2136a) {
        this.f7275e = c2136a;
    }

    public void setUseSystemDefault(boolean z) {
        this.f7274d = z;
    }
}
