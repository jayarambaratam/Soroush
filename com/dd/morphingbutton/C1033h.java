package com.dd.morphingbutton;

/* renamed from: com.dd.morphingbutton.h */
class C1033h implements Runnable {
    final /* synthetic */ int f3895a;
    final /* synthetic */ MorphingButton f3896b;

    C1033h(MorphingButton morphingButton, int i) {
        this.f3896b = morphingButton;
        this.f3895a = i;
    }

    public void run() {
        int width = (this.f3896b.getWidth() / 2) - (this.f3896b.getResources().getDrawable(this.f3895a).getIntrinsicWidth() / 2);
        this.f3896b.setCompoundDrawablesWithIntrinsicBounds(this.f3895a, 0, 0, 0);
        this.f3896b.setPadding(width, 0, 0, 0);
    }
}
