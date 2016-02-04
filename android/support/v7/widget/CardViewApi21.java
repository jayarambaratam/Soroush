package android.support.v7.widget;

import android.content.Context;
import android.view.View;

class CardViewApi21 implements CardViewImpl {
    CardViewApi21() {
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return ((View) cardViewDelegate).getElevation();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return ((RoundRectDrawable) cardViewDelegate.getBackground()).getPadding();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getRadius(cardViewDelegate) * 2.0f;
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return ((RoundRectDrawable) cardViewDelegate.getBackground()).getRadius();
    }

    public void initStatic() {
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, int i, float f, float f2, float f3) {
        cardViewDelegate.setBackgroundDrawable(new RoundRectDrawable(i, f));
        View view = (View) cardViewDelegate;
        view.setClipToOutline(true);
        view.setElevation(f2);
        setMaxElevation(cardViewDelegate, f3);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        setMaxElevation(cardViewDelegate, getMaxElevation(cardViewDelegate));
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, int i) {
        ((RoundRectDrawable) cardViewDelegate.getBackground()).setColor(i);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f) {
        ((View) cardViewDelegate).setElevation(f);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f) {
        ((RoundRectDrawable) cardViewDelegate.getBackground()).setPadding(f, cardViewDelegate.getUseCompatPadding(), cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f) {
        ((RoundRectDrawable) cardViewDelegate.getBackground()).setRadius(f);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        if (cardViewDelegate.getUseCompatPadding()) {
            float maxElevation = getMaxElevation(cardViewDelegate);
            float radius = getRadius(cardViewDelegate);
            int ceil = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateHorizontalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            int ceil2 = (int) Math.ceil((double) RoundRectDrawableWithShadow.calculateVerticalPadding(maxElevation, radius, cardViewDelegate.getPreventCornerOverlap()));
            cardViewDelegate.setShadowPadding(ceil, ceil2, ceil, ceil2);
            return;
        }
        cardViewDelegate.setShadowPadding(0, 0, 0, 0);
    }
}
